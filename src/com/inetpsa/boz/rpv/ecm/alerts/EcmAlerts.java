/*
 * Creation : 20/01/2014
 */
package com.inetpsa.boz.rpv.ecm.alerts;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.inetpsa.boz.common.bean.AlertBean;
import com.inetpsa.boz.common.bean.EcmErrorsBean;
import com.inetpsa.boz.common.bean.EvmErrorsBean;
import com.inetpsa.boz.common.bean.SuiviModuleBean;
import com.inetpsa.boz.common.bean.SuiviProcessBean;
import com.inetpsa.boz.common.constant.BozConstants;
import com.inetpsa.boz.common.context.BozContext;
import com.inetpsa.boz.common.dao.RpvDao;
import com.inetpsa.boz.common.db.DbManager;
import com.inetpsa.boz.common.exception.BozException;
import com.inetpsa.boz.common.log.LoggerManager;
import com.inetpsa.boz.rpv.ecm.dao.EcmDao;
import com.inetpsa.boz.rpv.ecm.start.Context;
import com.inetpsa.boz.rpv.xml.types.MarquePSAType;

public class EcmAlerts {
	public static void main(String[] args) {

		try {
			Context.setContext();
			BozContext.init();
			LoggerManager.getInstance().info(
					"version : " + BozConstants.version);
			SendEmail.execute();
		} catch (Exception ex) {
			LoggerManager.getInstance().error(ex.getMessage());
			System.exit(-1);
			ex.printStackTrace();
		}// CHECKSTYLE:ON
	}
}

class SendEmail {
	static String sStatus = BozConstants.statusOK;
	static String sStatusPro = BozConstants.statusOK;
	static String sfileExcelName = null;

	public static void execute() throws BozException, RowsExceededException,
			WriteException, IOException {
		int numProcess = 0;
		String sModule = null;
		String fileName = null;
		String sTypeVisiteAPV = null;
		ArrayList alSent = null;
		String sEnvio = "";
		alSent = new ArrayList();

		sStatusPro = BozConstants.statusOK;
		SuiviProcessBean suiviProcessBean = new SuiviProcessBean();
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		java.util.Date dateDebutProcess = new java.util.Date();
		Connection con = DbManager.getInstance().getConnection();
		numProcess = RpvDao.getInstance().getNumProcess(con);
		// Buscamos la fecha y hora cuando se ha ejecutado por última vez el
		// envio de alertas
		String lastDate = EcmDao.getInstance().selectLastAlertDate(con);

		// Buscamos los paises cuyos ficheros han sido integrados desde que se
		// lanzó por última vez el envio de alertas
		List suiviModuleBeanList = EcmDao.getInstance()
				.selectProcessedCountries(con, lastDate);
		// Si no se han integrado ficheros se termina el proceso
		if (suiviModuleBeanList.isEmpty())
			return;

		Iterator it = suiviModuleBeanList.iterator();

		// Generamos el cuerpo del email y lo mandamos
		while (it.hasNext()) {
			try {
				sTypeVisiteAPV = "COMPLET";
				sStatus = BozConstants.statusOK;
				SuiviModuleBean suiviModuleBean = (SuiviModuleBean) it.next();
				// Asignamos el numero de proceso que sea el mismo para todos
				// los env�os de mail
				suiviModuleBean.setNumProcess(numProcess);
				sModule = suiviModuleBean.getCodeModule();
				if (sModule.equalsIgnoreCase("LOAD_ECM")) {
					// fileName =
					// suiviModuleBean.getCodeSource().substring(0,8);
					fileName = suiviModuleBean.getCodeSource();
					sEnvio = "LM";
				} else {
					if (sModule.equalsIgnoreCase("LOAD_EVM_APV")) {
						sEnvio = "VMAPV";
						fileName = suiviModuleBean.getCodeSource();

						if (suiviModuleBean.getCodeSource().length() >= 20) {
							fileName = suiviModuleBean.getCodeSource()
									.substring(0, 20);
							try {
								sTypeVisiteAPV = fileName.substring(7, 14)
										.toUpperCase();
							} catch (Exception ee1) {
								sTypeVisiteAPV = "COMPLET";
							}
						}
					}
					if (sModule.equalsIgnoreCase("LOAD_EVM_VN")) {
						sEnvio = "VMVN";
						fileName = suiviModuleBean.getCodeSource().substring(0,
								11);
					}
				}
				suiviModuleBean.setLibTypeFichier(sTypeVisiteAPV); // PARTIAL O
																	// COMPLET
				AlertBean alertBean = EcmDao.getInstance().selectAlertBeanData(
						con, fileName, suiviModuleBean, true);
				if (alertBean != null) {

					sEnvio += alertBean.getCountryCode()
							+ alertBean.getMarqueCode();
					if (!alSent.contains(sEnvio)) {
						if (suiviModuleBean.getCodePays() == null) {
							suiviModuleBean.setCodePays(alertBean
									.getCountryCode());
							suiviModuleBean.setCodeSubMarque(alertBean
									.getMarqueCode());
						}
						insertSuiviModuleInfo(suiviModuleBean, con);
						sendAlertEmail(
								createEmailSubject(alertBean),
								createEmailBody(con, alertBean,
										suiviModuleBean, lastDate), alertBean,
								suiviModuleBean);
						// Volvermos a asignar el n�mero de proceso para poder
						// actualizar el registro a OK
						suiviModuleBean.setNumProcess(numProcess);

						EcmDao.getInstance().updateCodeStatusSuiviModule(con,
								suiviModuleBean);
						alSent.add(sEnvio);
					}
				} else {
					sStatus = BozConstants.statusKO;
					sStatusPro = BozConstants.statusKO;
				}
			} catch (Exception ex1) {
				LoggerManager.getInstance().error(ex1.getMessage());
				sStatus = BozConstants.statusKO;
				sStatusPro = BozConstants.statusKO;
				suiviProcessBean.setLibErreur(ex1.getMessage());
			}

		}
		// -- Suivi du process
		suiviProcessBean.setCodeTypeProcess("ALERT_ECM");
		suiviProcessBean.setNumProcess(numProcess);
		suiviProcessBean.setDateDebut(sdf2.format(dateDebutProcess));
		suiviProcessBean.setDateFin((sdf2.format(new java.util.Date())));
		suiviProcessBean.setNbFichierATraiter(0);
		suiviProcessBean.setNbFichierOk(0);
		suiviProcessBean.setNbFichierRejet(0);
		suiviProcessBean.setCodeEtatProcess(sStatusPro);
		try {
			RpvDao.getInstance().insertSuiviProcess(con, suiviProcessBean);
			if (!con.isReadOnly())
				con.commit();
		} catch (SQLException sqlex) {
			LoggerManager.getInstance().error(sqlex.getMessage());
		}

	}

	private static void sendAlertEmail(String emailSubject, String emailBody,
			AlertBean alertBean, SuiviModuleBean suiviModuleBean) {
		try {
			String to = alertBean.getInstituteEmail();
			String cc = alertBean.getMoaEmail();
			String from = System.getProperty("SMTP_FROM");
			String alias = "Infomys";
			String hostSmpt = System.getProperty("HOST_SMTP");
			// String portSmtp = System.getProperty("PORT_HOST_SMTP");
			send(from, alias, to, cc, emailSubject, emailBody, hostSmpt,
					suiviModuleBean);
		} catch (Exception ex1) {
			sStatus = BozConstants.statusKO;
			LoggerManager.getInstance().error(ex1.getMessage());
			ex1.printStackTrace();
		}

	}

	// send(from, alias, autUser, autPass, to, emailSubject, emailBody,
	// hostSmpt, suiviModuleBean);
	private static void send(String from, String alias, String to, String cc,
			String subject, String emailBody, String hostSmpt,
			SuiviModuleBean suiviModuleBean) {
		MimeMultipart multiPart = new MimeMultipart();
		BodyPart text = new MimeBodyPart();
		BodyPart excel = new MimeBodyPart();

		try {
			// Propiedades de la conexionn
			Properties props = new Properties();
			props.setProperty("mail.smtp.host", hostSmpt);
			props.setProperty("mail.smtp.auth", "true");
			// Preparamos la sesion
			// SMTPAuthentication auth = null;
			SMTPAuthentication auth = new SMTPAuthentication();
			Session session = Session.getDefaultInstance(props, auth);
			session.setDebug(true);
			// Construimos el mensaje
			MimeMessage message = new MimeMessage(session);
			InternetAddress iAFrom = new InternetAddress(from, alias, "UTF-8");
			message.setFrom(iAFrom);
			message.addRecipients(RecipientType.TO, InternetAddress.parse(to));
			message.addRecipients(RecipientType.CC, InternetAddress.parse(cc));
			message.setSubject(subject, "UTF-8");

			text.setText(emailBody);
			text.setContent(emailBody, "text/html; charset=UTF-8");

			if (suiviModuleBean.getNbEnrWarning() != 0
					|| suiviModuleBean.getNbEnrRejete() != 0) {
				excel.setDataHandler(new DataHandler(new FileDataSource(
						sfileExcelName)));
				excel.setFileName(sfileExcelName);
				multiPart.addBodyPart(excel);
			}
			multiPart.addBodyPart(text);

			message.setContent(multiPart, "text/html; charset=UTF-8");
			// Lo enviamos.
			Transport.send(message);

			// Transport t = session.getTransport("smtp");
			// t.connect(props.getProperty("mail.smtp.host"),
			// Integer.parseInt(portSmtp), from, autPass);
			// t.sendMessage(message, message.getAllRecipients());
			// Cierre.
			// t.close();

		} catch (Exception e) {
			sStatus = BozConstants.statusKO;
			LoggerManager.getInstance().error(e.getMessage());
			e.printStackTrace();
		}
	}

	public static String createEmailBody(Connection con, AlertBean alertBean,
			SuiviModuleBean suiviModuleBean, String lastDate)
			throws BozException, RowsExceededException, WriteException,
			IOException {
		String sLibErrour = "";
		String emailBody = new String();
		emailBody = emailBody + "<HEAD>";
		emailBody = emailBody
				+ "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>";
		emailBody = emailBody + "<style  TYPE=\"text/css\">";
		emailBody = emailBody
				+ "	TABLE	{width:'80%';border-collapse:'collapse';border-color:'black';border-width:'1pt';}";
		emailBody = emailBody
				+ "	THEAD	{font-family:'Verdana';background-color:'red';color:'white';font-weight:'bold';font-size:'12pt';}";
		emailBody = emailBody
				+ "	TBODY	{font-family:'Arial';font-size:'10pt';}";
		emailBody = emailBody + "	DIV		{text-align:'center';}";
		emailBody = emailBody + "</style>";
		emailBody = emailBody + "</HEAD>";
		emailBody = emailBody + "<BODY>";
		emailBody = emailBody + "<BR>Bonjour,<BR><BR>";
		emailBody = "<BR>" + alertBean.getEmailBody() + "<BR>";
		Calendar date = new GregorianCalendar();
		String dateSt = date.get(Calendar.DAY_OF_MONTH) + "/"
				+ (date.get(Calendar.MONTH) + 1) + "/"
				+ date.get(Calendar.YEAR);

		emailBody = formatStrings(
				emailBody,
				new String[] { dateSt, alertBean.getMarqueCode(),
						alertBean.getCountryCode(),
						suiviModuleBean.getCodeEtatModule() });

		if (suiviModuleBean.getCodeEtatModule().equals(BozConstants.statusKO)) {

			emailBody = emailBody + alertBean.getEmailBodyKo() + "<BR>";
			sLibErrour = suiviModuleBean.getLibErreur();
			if (sLibErrour == null) {
				sLibErrour = "";
			}
			emailBody = formatStrings(emailBody, new String[] { sLibErrour });

		} else if (suiviModuleBean.getCodeEtatModule().equals(
				BozConstants.statusOK)) {

			suiviModuleBean = obtainAllInfoSuiviModuleBean(con,
					suiviModuleBean, lastDate);
			emailBody = emailBody + alertBean.getEmailBodyOk() + "<BR>";
			emailBody = formatStrings(
					emailBody,
					new String[] {
							Integer.toString(suiviModuleBean.getNbEnrATraiter()),
							Integer.toString(suiviModuleBean.getNbEnrOk()),
							Integer.toString(suiviModuleBean.getNbEnrRejete()),
							Integer.toString(suiviModuleBean.getNbEnrWarning()) });
		}

		if (suiviModuleBean.getNbEnrWarning() != 0
				|| suiviModuleBean.getNbEnrRejete() != 0) {
			emailBody = emailBody + alertBean.getEmailBodyWR() + "<BR>";
			createExcelFile(con, suiviModuleBean, alertBean.getCodeLangue());
		}
		emailBody = emailBody + "<BR>" + alertBean.getFinEmail();
		emailBody = emailBody + "</BODY>";
		emailBody = emailBody + "</HTML>";
		return emailBody;
	}

	/*
	 * public static AlertBean obtainAlertBean(Connection con, String fileName)
	 * throws BozException { AlertBean alertBean = new AlertBean();
	 * alertBean.setFileName(fileName); alertBean =
	 * EcmDao.getInstance().selectAlertBeanData(con, fileName); return
	 * alertBean; }
	 */

	public static String formatStrings(String text, String[] parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {

				text = text.replaceFirst("%s", parameters[i]);
			}
		} catch (Exception e) {
			return text;
		}
		return text;
	}

	public static String createEmailSubject(AlertBean alertBean) {

		String emailSubject = alertBean.getEmailSubject();

		Calendar date = new GregorianCalendar();
		String dateSt = date.get(Calendar.DAY_OF_MONTH) + "/"
				+ (date.get(Calendar.MONTH) + 1) + "/"
				+ date.get(Calendar.YEAR);

		emailSubject = formatStrings(emailSubject, new String[] { dateSt });
		// emailSubject = String.format(emailSubject, new String[] { dateSt });

		return emailSubject;
	}

	public static void insertSuiviModuleInfo(SuiviModuleBean suiviModuleBean,
			Connection con) throws BozException {

		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		suiviModuleBean.setCodeTypeProcess("ALERT_ECM");
		suiviModuleBean.setCodeModule(suiviModuleBean.getCodeModule()
				.replaceFirst("LOAD", "ALERT"));
		SuiviModuleBean suiviModuleAlertBean = suiviModuleBean
				.copySuiviModuleBean();
		suiviModuleAlertBean.setCodeCible("-");
		suiviModuleAlertBean.setDateDebutModule(format.format(date));
		suiviModuleAlertBean.setCodeEtatModule(BozConstants.statusKO);
		// suiviModuleAlertBean.setNumProcess(RpvDao.getInstance().getNumProcess(con));
		EcmDao.getInstance().insertSuiviModuleBean(con, suiviModuleAlertBean);
	}

	public static SuiviModuleBean obtainAllInfoSuiviModuleBean(Connection con,
			SuiviModuleBean suiviModuleBean, String lastDate)
			throws BozException {

		suiviModuleBean = EcmDao.getInstance().selectSuiviModuleBeanData(con,
				suiviModuleBean, lastDate);
		return suiviModuleBean;
	}

	private static void createExcelFile(Connection con,
			SuiviModuleBean suiviModuleBean, String codeLangue)
			throws BozException, IOException, RowsExceededException,
			WriteException {

		if (suiviModuleBean.getCodeModule().equalsIgnoreCase("ALERT_ECM")) {
			createExcelFileECM(con, suiviModuleBean, codeLangue);
		}
		if (suiviModuleBean.getCodeModule().equalsIgnoreCase("ALERT_EVM_APV")) {
			createExcelFileEVM_APV(con, suiviModuleBean, codeLangue);
		}
		if (suiviModuleBean.getCodeModule().equalsIgnoreCase("ALERT_EVM_VN")) {
			createExcelFileEVM_VN(con, suiviModuleBean, codeLangue);
		}

	}

	private static void createExcelFileEVM_APV(Connection con,
			SuiviModuleBean suiviModuleBean, String codeLangue)
			throws BozException, IOException, RowsExceededException,
			WriteException {
		sfileExcelName = "EVM_APV-Processing Detail.xls";
		// Se crea el libro Excel
		WritableWorkbook workbook = Workbook.createWorkbook(new File(
				sfileExcelName));
		// Se crea una nueva hoja dentro del libro
		WritableSheet sheet = workbook.createSheet("Proccesing detail", 0);
		// boolean bCompleto = true;
		int columna = 0;
		EvmErrorsBean evm = null;
		// boolean b2015 = false;
		int iYear = 0;

		// bCompleto = suiviModuleBean.getLibTypeFichier().equalsIgnoreCase(
		// "PARTIEL") ? false : true;

		List listEvmErrorsBean = EcmDao.getInstance().selectEvmErrorsBeanData(
				con, suiviModuleBean, codeLangue,
				com.inetpsa.boz.rpv.xml.types.ActivityPSAType.APV);

		if (!listEvmErrorsBean.isEmpty()) {
			evm = (EvmErrorsBean) listEvmErrorsBean.get(0);
			iYear = Integer.parseInt(evm.getWave().substring(0, 4));
		}

		// Creamos celdas de varios tipos
		sheet.addCell(new jxl.write.Label(columna++, 0, "COUNTRY CODE"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "MARQUE CODE"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "TRASFERT DATE"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "WAVE"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "CODE TRAITEMENT"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ERROR DESCRIPTION"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ACTIVITY TYPE"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "VISIT ID"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "VISIT NUMBER"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "RRDI CODE"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "SITE CODE"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "SCENARIO"));
		if (iYear >= 2017) {
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q1"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q2"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q3"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q4"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q5"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q6"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q7"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q9"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q10"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q11"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q12"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q13"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q14"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q15"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q16"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q17"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q18"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q19"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q20"));
		}
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q21"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q22"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q23"));
		if (iYear >= 2017) {
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q24"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q25"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q26"));
		}
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q27"));
		if (iYear >= 2017) {
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q28"));
		}
		if (iYear < 2017) {
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q29"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q30"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q31"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q32"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q33"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q34"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q35"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q36"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q37"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q38"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q39"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q40"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q41"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q42"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q43"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q44"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q45"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q46"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q47"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q50"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q51"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q52"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q53"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q54"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q55"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q56"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q57"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q58"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q59"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q60"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q61"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q62"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q63"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q64"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q65"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q66"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q67"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q69"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q70"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q71"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q72"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q73"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q74"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q76"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q77"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q78"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q79"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q80"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q81"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q83"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q84"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q85"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q86"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q87"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q88"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q90"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q91"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q92"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER 102"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER 103"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER 104"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER 105"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER 106"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER 107"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER 108"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER 109"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER 110"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER 111"));
			if (iYear != 2015) {
				sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER 112"));
				sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER 113"));
				sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER 114"));
			}
		}

		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER QO1"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER QO2"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER QO3"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER QO4"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER QO5"));
		if (iYear < 2017) {
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER QO6"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER QO7"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER QO8"));
		}
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER QL1"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER QL2"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER QL3"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER QL4"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER QL5"));

		Iterator it = listEvmErrorsBean.iterator();
		int i = 1;

		// Generamos las celdas de datos
		while (it.hasNext()) {
			columna = 0;
			EvmErrorsBean evmErrorsBean = (EvmErrorsBean) it.next();

			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getCountryCode()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getMarqueCode()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getTransferDate()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getWave()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getCodeTraitement()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getErrorDescription()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getActivityType()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getVisitId()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getVisitNum()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getCodPDV()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getCodSite()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getScenario()));
			if (iYear >= 2017) {
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ1()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ2()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ3()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ4()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ5()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ6()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ7()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ9()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ10()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ11()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ12()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ13()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ14()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ15()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ16()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ17()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ18()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ19()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ20()));
			}
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQ21()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQ22()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQ23()));
			if (iYear >= 2017) {
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ24()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ25()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ26()));
			}
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQ27()));
			if (iYear >= 2017) {
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ28()));
			}
			if (iYear < 2017) {
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ29()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ30()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ31()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ32()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ33()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ34()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ35()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ36()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ37()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ38()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ39()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ40()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ41()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ42()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ43()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ44()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ45()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ46()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ47()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ50()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ51()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ52()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ53()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ54()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ55()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ56()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ57()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ58()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ59()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ60()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ61()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ62()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ63()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ64()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ65()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ66()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ67()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ69()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ70()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ71()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ72()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ73()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ74()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ76()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ77()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ78()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ79()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ80()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ81()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ83()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ84()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ85()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ86()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ87()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ88()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ90()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ91()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ92()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ102()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ103()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ104()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ105()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ106()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ107()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ108()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ109()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ110()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ111()));
				if (iYear != 2015) {
					sheet.addCell(new jxl.write.Label(columna++, i,
							evmErrorsBean.getAnswerQ112()));
					sheet.addCell(new jxl.write.Label(columna++, i,
							evmErrorsBean.getAnswerQ113()));
					sheet.addCell(new jxl.write.Label(columna++, i,
							evmErrorsBean.getAnswerQ114()));
				}
			}

			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQO1()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQO2()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQO3()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQO4()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQO5()));
			if (iYear < 2017) {
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQO6()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQO7()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQO8()));
			}

			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQL1()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQL2()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQL3()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQL4()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQL5()));
			i++;
		}

		try {
			FileOutputStream out = new FileOutputStream(sfileExcelName);

			// book.write(out);

			// int c = 30;
			for (int x = 0; x < columna; x++) {
				sheet.setColumnView(x, 20);
			}

			workbook.write();
			try {
				workbook.close();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			out.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}

	private static void createExcelFileEVM_VN(Connection con,
			SuiviModuleBean suiviModuleBean, String codeLangue)
			throws BozException, IOException, RowsExceededException,
			WriteException {
		int columna = 0;
		int iYear = 0;
		boolean bDS = false;
		boolean bAP = false;
		boolean bAC = false;
		EvmErrorsBean evm = null;
		sfileExcelName = "EVM_VN-Processing Detail.xls";
		// Se crea el libro Excel
		WritableWorkbook workbook = Workbook.createWorkbook(new File(
				sfileExcelName));
		// Se crea una nueva hoja dentro del libro
		WritableSheet sheet = workbook.createSheet("Proccesing detail", 0);

		List listEvmErrorsBean = EcmDao.getInstance().selectEvmErrorsBeanData(
				con, suiviModuleBean, codeLangue,
				com.inetpsa.boz.rpv.xml.types.ActivityPSAType.VN);

		if (!listEvmErrorsBean.isEmpty()) {
			evm = (EvmErrorsBean) listEvmErrorsBean.get(0);
			iYear = Integer.parseInt(evm.getWave().substring(0, 4));
			bDS = (evm.getMarqueCode().equals(MarquePSAType.DS.toString())) ? true
					: false;
			bAP = (evm.getMarqueCode().equals(MarquePSAType.AP.toString())) ? true
					: false;
			bAC = (evm.getMarqueCode().equals(MarquePSAType.AC.toString())) ? true
					: false;
		}

		// Creamos celdas de varios tipos
		sheet.addCell(new jxl.write.Label(columna++, 0, "COUNTRY CODE"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "MARQUE CODE"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "TRASFERT DATE"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "WAVE"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "CODE TRAITEMENT"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ERROR DESCRIPTION"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ACTIVITY TYPE"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "VISIT ID"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "VISIT NUMBER"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "RRDI CODE"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "SITE CODE"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "SCENARIO"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q1"));
		if (iYear >= 2017) {
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q2"));
		}
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q3"));
		if (iYear >= 2017) {
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q4"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q5"));
		}
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q6"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q7"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q8"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q9"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q10"));
		if (iYear >= 2017) {
			if (bAP)
				sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q11AP"));
			if (bAC)
				sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q11AC"));
			if (bDS)
				sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q11DS"));
		} else {
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q11BIS"));
		}
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q12"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q13"));
		if (iYear >= 2017) {
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q14"));
		}
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q15"));
		if (iYear >= 2017) {
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q16"));
		}
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q17"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q18"));
		if (iYear >= 2017) {
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q19"));
		}
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q20"));
		if (iYear >= 2017) {
			if (bAP)
				sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q21AP"));
			if (bAC)
				sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q21AC"));
			if (bDS)
				sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q21DS"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q22"));
		} else {
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q21"));
		}
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q23"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q24"));
		if (iYear >= 2017 && bDS) {
			// Si es versión V4 o posterior, Q25 solo existe para DS
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q25"));
		} else {
			if (iYear < 2017) {
				// Si es version anterior a v4 Q25 siempre sale
				sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q25"));
			}
		}
		if (iYear < 2017) {

			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q26"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q29"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q30"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q31"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q33"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q34"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q35"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q38"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q39"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q40"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q41"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q42"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q47"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q48"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q49"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q50"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q51"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q52"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q54"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q55"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q56"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q57"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q58"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q60"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q61"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q62"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q63"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q65"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q66"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q67"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q68"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q69"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q70"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q71"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q72"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q73"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q74"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q75"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q76"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q77"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q78"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q79"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q80"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q81"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q82"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q83"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q84"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q85"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q86"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q87"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q88"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q89"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q90"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q91"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q92"));
			sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q93"));
			if (iYear != 2015) {
				sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER Q94"));
			}
		}

		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER QO1"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER QO2"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER QO3"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER QO4"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER QO5"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER QL1"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER QL2"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER QL3"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER QL4"));
		sheet.addCell(new jxl.write.Label(columna++, 0, "ANSWER QL5"));

		Iterator it = listEvmErrorsBean.iterator();
		int i = 1;

		// Generamos las celdas de datos
		while (it.hasNext()) {
			columna = 0;
			EvmErrorsBean evmErrorsBean = (EvmErrorsBean) it.next();

			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getCountryCode()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getMarqueCode()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getTransferDate()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getWave()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getCodeTraitement()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getErrorDescription()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getActivityType()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getVisitId()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getVisitNum()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getCodPDV()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getCodSite()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getScenario()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQ1()));
			if (iYear >= 2017) {
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ2()));
			}
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQ3()));
			if (iYear >= 2017) {
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ4()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ5()));
			}
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQ6()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQ7()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQ8()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQ9()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQ10()));
			if (iYear >= 2017) {
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ11()));
			} else {
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ11Bis()));
			}
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQ12()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQ13()));
			if (iYear >= 2017) {
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ14()));
			}
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQ15()));
			if (iYear >= 2017) {
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ16()));
			}
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQ17()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQ18()));
			if (iYear >= 2017) {
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ19()));
			}
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQ20()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQ21()));
			if (iYear >= 2017) {
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ22()));
			}
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQ23()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQ24()));
			if (iYear >= 2017 && bDS) {
				// Si es versión V4 o posterior, Q25 solo existe para DS
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ25()));
			} else {
				if (iYear < 2017) {
					// Si es version anterior a v4 Q25 siempre sale
					sheet.addCell(new jxl.write.Label(columna++, i,
							evmErrorsBean.getAnswerQ25()));
				}
			}
			if (iYear < 2017) {
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ26()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ29()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ30()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ31()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ33()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ34()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ35()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ38()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ39()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ40()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ41()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ42()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ47()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ48()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ49()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ50()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ51()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ52()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ54()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ55()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ56()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ57()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ58()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ60()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ61()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ62()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ63()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ65()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ66()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ67()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ68()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ69()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ70()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ71()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ72()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ73()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ74()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ75()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ76()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ77()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ78()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ79()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ80()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ81()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ82()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ83()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ84()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ85()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ86()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ87()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ88()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ89()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ90()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ91()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ92()));
				sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
						.getAnswerQ93()));
				if (iYear != 2015) {
					sheet.addCell(new jxl.write.Label(columna++, i,
							evmErrorsBean.getAnswerQ94()));
				}
			}
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQO1()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQO2()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQO3()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQO4()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQO5()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQL1()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQL2()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQL3()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQL4()));
			sheet.addCell(new jxl.write.Label(columna++, i, evmErrorsBean
					.getAnswerQL5()));
			i++;
		}

		try {
			FileOutputStream out = new FileOutputStream(sfileExcelName);

			// book.write(out);

			int c = 30;
			for (int x = 0; x < c; x++) {
				sheet.setColumnView(x, 20);
			}

			workbook.write();
			try {
				workbook.close();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			out.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}

	private static void createExcelFileECM(Connection con,
			SuiviModuleBean suiviModuleBean, String codeLangue)
			throws BozException, IOException, RowsExceededException,
			WriteException {
		sfileExcelName = "ECM-Processing Detail.xls";
		// Se crea el libro Excel
		WritableWorkbook workbook = Workbook.createWorkbook(new File(
				sfileExcelName));
		boolean bIteracion = false;
		int iFormato = 0;
		EcmErrorsBean ecmErrorsBean1 = null;
		List listEcmErrorsBean = EcmDao.getInstance().selectEcmErrorsBeanData(
				con, suiviModuleBean, codeLangue);

		Iterator it = listEcmErrorsBean.iterator();

		if (it.hasNext()) {

			ecmErrorsBean1 = (EcmErrorsBean) it.next();
			bIteracion = true;
			iFormato = Integer.parseInt(ecmErrorsBean1.getWave()
					.substring(0, 4));
		}

		// Se crea una nueva hoja dentro del libro
		WritableSheet sheet = workbook.createSheet("Proccesing detail", 0);
		// Creamos celdas de varios tipos
		int j = 0;
		sheet.addCell(new jxl.write.Label(j++, 0, "COUNTRY CODE"));
		sheet.addCell(new jxl.write.Label(j++, 0, "MARQUE CODE"));
		sheet.addCell(new jxl.write.Label(j++, 0, "TRASFERT DATE"));
		sheet.addCell(new jxl.write.Label(j++, 0, "WAVE"));
		sheet.addCell(new jxl.write.Label(j++, 0, "CODE TRAITEMENT"));
		sheet.addCell(new jxl.write.Label(j++, 0, "ERROR DESCRIPTION"));
		sheet.addCell(new jxl.write.Label(j++, 0, "ACTIVITY TYPE"));
		sheet.addCell(new jxl.write.Label(j++, 0, "DEALER CODE"));
		sheet.addCell(new jxl.write.Label(j++, 0, "LEAD ID"));
		sheet.addCell(new jxl.write.Label(j++, 0, "ANSWER Q1"));
		sheet.addCell(new jxl.write.Label(j++, 0, "ANSWER Q2"));
		sheet.addCell(new jxl.write.Label(j++, 0, "ANSWER Q3"));
		if (iFormato <= 2016) {
			sheet.addCell(new jxl.write.Label(j++, 0, "ANSWER Q3BIS"));
			sheet.addCell(new jxl.write.Label(j++, 0, "ANSWER Q4"));
			sheet.addCell(new jxl.write.Label(j++, 0, "ANSWER Q5"));
			sheet.addCell(new jxl.write.Label(j++, 0, "ANSWER Q6"));
		}
		sheet.addCell(new jxl.write.Label(j++, 0, "ANSWER Q7"));
		sheet.addCell(new jxl.write.Label(j++, 0, "ANSWER Q8"));
		sheet.addCell(new jxl.write.Label(j++, 0, "ANSWER Q9"));
		sheet.addCell(new jxl.write.Label(j++, 0, "ANSWER Q10"));
		sheet.addCell(new jxl.write.Label(j++, 0, "ANSWER Q11"));
		sheet.addCell(new jxl.write.Label(j++, 0, "ANSWER Q12"));
		sheet.addCell(new jxl.write.Label(j++, 0, "ANSWER Q13"));
		sheet.addCell(new jxl.write.Label(j++, 0, "ANSWER Q14"));
		sheet.addCell(new jxl.write.Label(j++, 0, "ANSWER Q15"));
		sheet.addCell(new jxl.write.Label(j++, 0, "ANSWER Q16"));
		sheet.addCell(new jxl.write.Label(j++, 0, "ANSWER Q17"));
		sheet.addCell(new jxl.write.Label(j++, 0, "ANSWER Q18"));
		sheet.addCell(new jxl.write.Label(j++, 0, "ANSWER Q19"));
		sheet.addCell(new jxl.write.Label(j++, 0, "ANSWER Q20"));
		sheet.addCell(new jxl.write.Label(j++, 0, "ANSWER Q21"));
		sheet.addCell(new jxl.write.Label(j++, 0, "ANSWER Q22"));
		if (iFormato >= 2017) {
			sheet.addCell(new jxl.write.Label(j++, 0, "ANSWER Q23"));
			sheet.addCell(new jxl.write.Label(j++, 0, "ANSWER Q24"));
			sheet.addCell(new jxl.write.Label(j++, 0, "ANSWER Q25"));
		}
		int i = 1;
		// Generamos las celdas de datos
		while (it.hasNext() || bIteracion) {
			j = 0;
			EcmErrorsBean ecmErrorsBean = null;
			if (bIteracion) {
				ecmErrorsBean = ecmErrorsBean1;
				bIteracion = false;
			} else {
				ecmErrorsBean = (EcmErrorsBean) it.next();
			}
			sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
					.getCountryCode()));
			sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
					.getMarqueCode()));
			sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
					.getTransferDate()));
			sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean.getWave()));
			sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
					.getCodeTraitement()));
			sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
					.getErrorDescription()));
			sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
					.getActivityType()));
			sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
					.getDealerCode()));
			sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean.getLeadId()));
			sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
					.getAnswerQ1()));
			sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
					.getAnswerQ2()));
			if (iFormato <= 2016) {
				sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
						.getAnswerQ3()));
				sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
						.getAnswerQ3Bis()));
				sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
						.getAnswerQ4()));
				sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
						.getAnswerQ5()));
				sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
						.getAnswerQ6()));
			} else {
				sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
						.getAnswerQ3Bis()));
			}
			sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
					.getAnswerQ7()));
			sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
					.getAnswerQ8()));
			sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
					.getAnswerQ9()));
			sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
					.getAnswerQ10()));
			sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
					.getAnswerQ11()));
			sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
					.getAnswerQ12()));
			sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
					.getAnswerQ13()));
			sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
					.getAnswerQ14()));
			sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
					.getAnswerQ15()));
			sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
					.getAnswerQ16()));
			sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
					.getAnswerQ17()));
			sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
					.getAnswerQ18()));
			sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
					.getAnswerQ19()));
			sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
					.getAnswerQ20()));
			sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
					.getAnswerQ21()));
			sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
					.getAnswerQ22()));
			if (iFormato >= 2017) {
				sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
						.getAnswerQ23()));
				sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
						.getAnswerQ24()));
				sheet.addCell(new jxl.write.Label(j++, i, ecmErrorsBean
						.getAnswerQ25()));
			}

			i++;
		}

		try {
			FileOutputStream out = new FileOutputStream(sfileExcelName);

			// book.write(out);

			int c = 30;
			for (int x = 0; x < c; x++) {
				sheet.setColumnView(x, 20);
			}

			workbook.write();
			try {
				workbook.close();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			out.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}
}

class SMTPAuthentication extends javax.mail.Authenticator {

	public PasswordAuthentication getPasswordAuthentication() {
		String username = System.getProperty("SMTP_USER");
		String password = System.getProperty("SMTP_PASS");
		return new PasswordAuthentication(username, password);
	}

}
