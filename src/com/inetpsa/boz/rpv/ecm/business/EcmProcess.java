package com.inetpsa.boz.rpv.ecm.business;

import java.io.BufferedReader;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.exolab.castor.xml.Unmarshaller;

import com.inetpsa.boz.common.bean.SuiviModuleBean;
import com.inetpsa.boz.common.bean.SuiviProcessBean;
import com.inetpsa.boz.common.constant.BozConstants;
import com.inetpsa.boz.common.dao.RpvDao;
import com.inetpsa.boz.common.db.DbManager;
import com.inetpsa.boz.common.exception.BozException;
import com.inetpsa.boz.common.exception.BozExceptionFactory;
import com.inetpsa.boz.common.log.LoggerManager;
import com.inetpsa.boz.common.utils.FileUtils;
import com.inetpsa.boz.rpv.ecm.dao.EcmDao;
import com.inetpsa.boz.rpv.ecm.start.Context;

/**
 * Process du traitement du load du SAS
 */
public class EcmProcess {

	/**
	 * Effectue l'unmarshalling des fichiers XML du r�pertoire inputPath Puis
	 * l'insertion des objets dans la BD
	 * 
	 */
	public void execute() {
		Unmarshaller unmarshaller2016 = new Unmarshaller(
				com.inetpsa.boz.rpv.ecm.xml.f2016.TECHNICAL_HEADER.class);
		Unmarshaller unmarshaller2017 = new Unmarshaller(
				com.inetpsa.boz.rpv.ecm.xml.f2017.TECHNICAL_HEADER.class);
		Connection con = DbManager.getInstance().getConnection();
		// SuiviProcessBean report = new SuiviProcessBean();
		// -- Init date de suivi du process
		java.util.Date dateDebutProcess = new java.util.Date();
		SuiviProcessBean suiviProcessBean = new SuiviProcessBean();
		SuiviModuleBean suiviModuleBean = null;
		String etatProcess = BozConstants.statusOK;
		int nbFichierOk = 0;
		int nbFichierKo = 0;
		// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdfReject = new SimpleDateFormat("yyyyMMddHHmmss");
		String sFriendyMessage = null;
		String strException2016 = null;
		String strException2017 = null;
		String strFormato = null;

		try {

			// -- R�cup�ration du num�ro du process
			int numProcess = RpvDao.getInstance().getNumProcess(con);
			File[] tabFile = FileUtils.listFilterFiles(Context.getInputPath(),
					Context.getPrefixFileName());
			// LoggerManager.getInstance().info("InputhPath:" +
			// Context.getInputPath() + ". PrefixFileName:" +
			// Context.getPrefixFileName());
			Date date2 = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date2);
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH);
			int nbFichier = 0;
			// String sLinea = null;

			// if (tabFile != null)
			// nbFichier = tabFile.length;
			// -- Maj du FLG_OLD � Y pour les lignes de SAS recyclages et
			// erreurs
			// RpvDao.getInstance().insertFlagDebut(con);

			// -- Suppression des enregistrement dans OECM
			EcmDao.getInstance().delete_lm(con);
			RpvDao.getInstance().insertFlagIni(con, "BOZQTOECM");

			try {
				LoggerManager.getInstance().info(
						"/*********** DEBUT PROCESS ***********/");
				for (int i = 0; i < tabFile.length; i++) {
					java.util.Date startDateModule = new java.util.Date();
					String rejectFile = Context.getRejectPath()
							+ File.separator + tabFile[i].getName() + "."
							+ sdfReject.format(startDateModule);

					if (tabFile[i].isFile() && tabFile[i].length() > 0) {

						String etatModule = BozConstants.statusOK;
						LoggerManager.getInstance().info(
								"/*********** DEBUT MODULE ***********/");

						com.inetpsa.boz.rpv.ecm.xml.f2016.TECHNICAL_HEADER myMsg2016 = null;
						com.inetpsa.boz.rpv.ecm.xml.f2017.TECHNICAL_HEADER myMsg2017 = null;
						int nbEnrATraiter = 0;
						int nbEnrRejete = 0;
						BufferedReader br = null;
						nbFichier++;
						// BufferedWriter brw = null;
						// BufferedWriter br2 = null;
						strFormato = null;
						try {
							suiviModuleBean = new SuiviModuleBean();
							br = FileUtils.read(tabFile[i], "UTF-8");
							/*
							 * br.read(); sLinea = br.readLine(); while ((sLinea
							 * != null) && (!sLinea.isEmpty())) {
							 * sLinea.toUpperCase().indexOf(<) sLinea =
							 * br.readLine(); }
							 */
							// System.out.println("read ok");
							// brw = FileUtils.ReplaceAmpersands(tabFile[i],
							// "UTF-8");
							// ValidateContentXML(br);
							try {
								myMsg2016 = (com.inetpsa.boz.rpv.ecm.xml.f2016.TECHNICAL_HEADER) unmarshaller2016
										.unmarshal(br);
								strFormato = "2016";

							} catch (Exception unException2016) {
								strException2016 = unException2016.getMessage();
								if (br != null) {
									br.close();
									br = null;
									br = FileUtils.read(tabFile[i], "UTF-8");
								}
								try {
									myMsg2017 = (com.inetpsa.boz.rpv.ecm.xml.f2017.TECHNICAL_HEADER) unmarshaller2017
											.unmarshal(br);
									strFormato = "2017";
								} catch (Exception unException2017) {
									strException2017 = unException2017
											.getMessage();

									String sException = null;
									/*
									 * if (year <= 2016) { sException =
									 * strException2016; } else {
									 */
									if (year >= 2017 && month >= 2) {
										sException = strException2017;
									} else {
										sException = "Format Error. For 2016 format: "
												+ getFriendlyMessage(strException2016)
												+ ". For 2017 format: "
												+ getFriendlyMessage(strException2017);
									}
									// }
									throw new Exception(sException);
								}
							}

							if (strFormato == null) {
								throw new Exception("Format Error.");

							} else if (strFormato == "2016") {
								nbEnrATraiter = getNbEnrATraiter(myMsg2016,
										strFormato);
								validateMandatoryTags(myMsg2016, strFormato);
								suiviModuleBean = EcmDao.getInstance()
										.insert2016(con, myMsg2016,
												tabFile[i].getName(),
												numProcess);

							} else if (strFormato == "2017") {
								nbEnrATraiter = getNbEnrATraiter(myMsg2017,
										strFormato);
								validateMandatoryTags(myMsg2017, strFormato);
								suiviModuleBean = EcmDao.getInstance()
										.insert2017(con, myMsg2017,
												tabFile[i].getName(),
												numProcess);
							}
							nbFichierOk++;
							// -- Maj de BOZQTSTAB avec 'Y'
							RpvDao.getInstance()
									.insertFlagFin(con, "BOZQTOECM");
							File out = new File(Context.getOutputPath()
									+ File.separator + tabFile[i].getName()
									+ "." + sdfReject.format(startDateModule));
							FileUtils.copyFile(tabFile[i], out);
							tabFile[i].delete();

							// copia el fichero renombrado en el directorio
							// batchs/integre

						} catch (Exception ex) {
							// ex.printStackTrace();
							// On sort en erreur du module ==> etatModule ==
							// KO
							etatModule = BozConstants.statusKO;
							etatProcess = BozConstants.statusKO;
							suiviModuleBean.setNumErreur(-1);
							sFriendyMessage = ex.getMessage();
							suiviModuleBean.setLibErreur(sFriendyMessage);
							suiviProcessBean.setLibErreur(sFriendyMessage);
							// suiviModuleBean.setLibErreur(ex.getMessage());
							// suiviProcessBean.setLibErreur(ex.getMessage());
							// System.err.println(ex.getMessage());
							suiviProcessBean.setNumErreur(-1);
							suiviProcessBean.setCodeEtatProcess(etatProcess);
							nbFichierKo++;
							treatException(tabFile[i], rejectFile, ex);

						} finally {
							if (br != null)
								br.close();

							suiviModuleBean.setCodeTypeProcess("LOAD_SASINF");
							suiviModuleBean.setNumProcess(numProcess);
							suiviModuleBean.setCodeModule("LOAD_ECM");
							suiviModuleBean.setCodeSource(tabFile[i].getName());
							suiviModuleBean.setCodeCible("BOZQTOECM");
							if (myMsg2016 != null || myMsg2017 != null) {

								if (myMsg2016 != null) {
									suiviModuleBean.setCodePays(myMsg2016
											.getCOUNTRY_CODE());
									suiviModuleBean.setCodeMarque(myMsg2016
											.getAP_AC().toString());
								} else {
									suiviModuleBean.setCodePays(myMsg2017
											.getCOUNTRY_CODE());
									suiviModuleBean.setCodeMarque(myMsg2017
											.getAP_AC().toString());
								}

								suiviModuleBean.setNumVersion(Integer
										.parseInt("1"));
								suiviModuleBean.setNbEnrATraiter(nbEnrATraiter);
								suiviModuleBean.setNbEnrRejete(nbEnrRejete);

								suiviModuleBean
										.setLibTypeFichier("Fichier ECM");
								try {

									SimpleDateFormat sdf3 = new SimpleDateFormat(
											"dd/MM/yyyy HH:mm:ss");
									java.util.Date date = null;
									if (myMsg2016 != null) {
										date = sdf3.parse(myMsg2016
												.getTRANSFER_DATE());
									} else {
										date = sdf3.parse(myMsg2017
												.getTRANSFER_DATE());
									}
									date = sdf3.parse(myMsg2016
											.getTRANSFER_DATE());
									java.sql.Timestamp timest = new java.sql.Timestamp(
											date.getTime());

									suiviModuleBean.setDateTransfer(timest);

								} catch (Exception pex) {
									LoggerManager.getInstance().error(
											pex.getMessage());
								}

							}

							suiviModuleBean.setDateDebutModule(sdf2
									.format(startDateModule));
							suiviModuleBean.setDateFinModule(sdf2
									.format(new java.util.Date()));
							suiviModuleBean.setCodeEtatModule(etatModule);
							// suiviModuleBean.setLibErreur("No Errors");

							logModule(suiviModuleBean, tabFile[i].getName());

							try {
								RpvDao.getInstance().insertSuiviModule(con,
										suiviModuleBean);
							} catch (BozException bex) {
								LoggerManager.getInstance().error(
										bex.getMessage());
							}

						}
					} else {
						treatEmptyFile(tabFile[i], rejectFile);
					}
				}

			} catch (Exception ex) {
				etatProcess = BozConstants.statusKO;
				suiviProcessBean.setNumErreur(-1);
				suiviProcessBean.setLibErreur(ex.getMessage());
				suiviProcessBean.setCodeEtatProcess(etatProcess);
				suiviModuleBean.setLibErreur(ex.getMessage());
				suiviModuleBean.setNumErreur(-1);
				LoggerManager.getInstance().error(ex.getMessage());
				// ex.printStackTrace();
			}

			// -- Suivi du process
			suiviProcessBean.setCodeTypeProcess("LOAD_SASINF");
			suiviProcessBean.setNumProcess(numProcess);
			suiviProcessBean.setDateDebut(sdf2.format(dateDebutProcess));
			suiviProcessBean.setDateFin((sdf2.format(new java.util.Date())));
			suiviProcessBean.setNbFichierATraiter(nbFichier);
			suiviProcessBean.setNbFichierOk(nbFichierOk);
			suiviProcessBean.setNbFichierRejet(nbFichierKo);
			suiviProcessBean.setCodeEtatProcess(etatProcess);

			try {
				logProcess(suiviProcessBean);
				RpvDao.getInstance().insertSuiviProcess(con, suiviProcessBean);
				if (!con.isReadOnly())
					con.commit();
			} catch (SQLException sqlex) {
				LoggerManager.getInstance().error(sqlex.getMessage());
			}

		} catch (BozException bex) {
			LoggerManager.getInstance().error(bex.getMessage());
		}
	}

	private String getFriendlyMessage(String sMensaje) {
		String ret = sMensaje;
		try {
			int posTheField = 0;
			int posApostrofe = 0;
			String fieldName = "";
			posTheField = ret.indexOf("The field '_", 0);
			if (posTheField > 0) {
				posTheField += 12;
				posApostrofe = ret.indexOf("'", posTheField);
				if (posApostrofe == 0)
					return ret;
				fieldName = ret.substring(posTheField, posApostrofe);
				if (ret.indexOf("(whose xml name is '" + fieldName
						+ "') is a required field)", posApostrofe) == 0)
					return ret;
				return "File rejection: Format error in the XML structure concerning label "
						+ fieldName;
			}
		} catch (Exception e) {
			return ret;
		}
		return ret;
	}

	/*
	 * private int getNbEnrATraiter(
	 * com.inetpsa.boz.rpv.ecm.xml.f2016.TECHNICAL_HEADER myMsg) { int
	 * nbActiviteTotal = 0; int nbDealer = myMsg.getDEALERCount(); for (int k =
	 * 0; k < nbDealer; k++) { int nbLead = myMsg.getDEALER(k).getLEADCount();
	 * if (nbLead == 0) nbActiviteTotal++; else nbActiviteTotal =
	 * nbActiviteTotal + nbLead; }
	 * 
	 * return nbActiviteTotal; }
	 */

	/**
	 * Renvoie le nombre de ligne � cr�er = au nombre total d'activit�
	 * 
	 * @param myMsg
	 *            Le message XML
	 * @return Le nombre de ligne � cr�er
	 */
	private int getNbEnrATraiter(Object myMsg, String sFormat) {
		int nbActiviteTotal = 0;
		int nbDealer = 0;
		if (sFormat == "2016") {
			nbDealer = ((com.inetpsa.boz.rpv.ecm.xml.f2016.TECHNICAL_HEADER) myMsg)
					.getDEALERCount();
		}
		if (sFormat == "2017") {
			nbDealer = ((com.inetpsa.boz.rpv.ecm.xml.f2017.TECHNICAL_HEADER) myMsg)
					.getDEALERCount();
		}
		for (int k = 0; k < nbDealer; k++) {
			int nbLead = 0;
			if (sFormat == "2016")
				nbLead = ((com.inetpsa.boz.rpv.ecm.xml.f2016.TECHNICAL_HEADER) myMsg)
						.getDEALER(k).getLEADCount();
			if (sFormat == "2017")
				nbLead = ((com.inetpsa.boz.rpv.ecm.xml.f2017.TECHNICAL_HEADER) myMsg)
						.getDEALER(k).getLEADCount();
			if (nbLead == 0)
				nbActiviteTotal++;
			else
				nbActiviteTotal = nbActiviteTotal + nbLead;
		}

		return nbActiviteTotal;
	}

	/**
	 * Logge les informations relatives � un module
	 * 
	 * @param suiviModuleBean
	 *            L'objet qui repr�sente un module
	 */
	private void logModule(SuiviModuleBean suiviModuleBean, String fileName) {
		LoggerManager.getInstance().info(
				"Nom du fichier \t\t\t\t\t: " + fileName);
		LoggerManager.getInstance().info(
				"Numéro du process \t\t\t\t: "
						+ suiviModuleBean.getNumProcess());
		LoggerManager.getInstance().info(
				"Code état du module \t\t\t\t: "
						+ suiviModuleBean.getCodeEtatModule());
		LoggerManager.getInstance().info(
				"Nombre de ligne insérée \t\t: "
						+ suiviModuleBean.getNbLigneInsere());
		LoggerManager.getInstance().info(
				"Nombre d'enregistrement à traiter : "
						+ suiviModuleBean.getNbEnrATraiter());
		LoggerManager.getInstance().info(
				"Nombre d'enregistrement rejeté : "
						+ suiviModuleBean.getNbEnrRejete());
		LoggerManager.getInstance().info(
				"Nombre de ligne rejetée \t\t: "
						+ suiviModuleBean.getNbEnrRejete());
		LoggerManager.getInstance()
				.info("/*********** FIN MODULE ***********/");

	}

	/**
	 * Logge les informations relatives � un process
	 * 
	 * @param suiviProcessBean
	 *            L'objet qui repr�sente un process
	 */
	private void logProcess(SuiviProcessBean suiviProcessBean) {
		LoggerManager.getInstance().info(
				"Numéro du process : " + suiviProcessBean.getNumProcess());
		LoggerManager.getInstance().info(
				"Code état du process : "
						+ suiviProcessBean.getCodeEtatProcess());
		LoggerManager.getInstance().info(
				"Nombre de fichier à traiter : "
						+ suiviProcessBean.getNbFichierATraiter());
		LoggerManager.getInstance().info(
				"Nombre de fichier OK : " + suiviProcessBean.getNbFichierOk());
		LoggerManager.getInstance().info(
				"Nombre de fichier rejeté : "
						+ suiviProcessBean.getNbFichierRejet());

		LoggerManager.getInstance().info(
				"/*********** FIN PROCESS ***********/");

	}

	/**
	 * Traitement d'une exception
	 * 
	 * @param inpuFile
	 *            Le fichier en entr�e
	 * @param rejectFile
	 *            Le nom du fichier de rejet chemin absolu + nom
	 * @param ex
	 *            L'exception qui a �t� lev�
	 */
	private void treatException(File inputFile, String rejectFile, Exception ex)
			throws Exception {
		LoggerManager.getInstance().error(ex.getMessage());
		File out = new File(rejectFile);
		FileUtils.copyFile(inputFile, out);
		inputFile.delete();
	}

	private void treatEmptyFile(File inputFile, String rejectFile)
			throws Exception {
		File out = new File(rejectFile);
		FileUtils.copyFile(inputFile, out);
		inputFile.delete();
	}

	/**
	 * 
	 * @param xmlMessage
	 * @throws BozException
	 */
	private void validateMandatoryTags(Object xmlMessage, String sFormat)
			throws BozException {

		Connection con = DbManager.getInstance().getConnection();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		if (sFormat == "2016") {

			if (((com.inetpsa.boz.rpv.ecm.xml.f2016.TECHNICAL_HEADER) xmlMessage)
					.getCOUNTRY_CODE() == null
					|| ((com.inetpsa.boz.rpv.ecm.xml.f2016.TECHNICAL_HEADER) xmlMessage)
							.getCOUNTRY_CODE().trim().equals("")) {
				throw BozExceptionFactory.getInstance().newException(
						"Label COD_COUNTRY empty");
			}

			if (((com.inetpsa.boz.rpv.ecm.xml.f2016.TECHNICAL_HEADER) xmlMessage)
					.getAP_AC().toString() == null
					|| ((com.inetpsa.boz.rpv.ecm.xml.f2016.TECHNICAL_HEADER) xmlMessage)
							.getAP_AC().toString().trim().equals("")) {
				throw BozExceptionFactory.getInstance().newException(
						"Label AP_AC empty");
			}

			if (((com.inetpsa.boz.rpv.ecm.xml.f2016.TECHNICAL_HEADER) xmlMessage)
					.getPERIOD() == null
					|| ((com.inetpsa.boz.rpv.ecm.xml.f2016.TECHNICAL_HEADER) xmlMessage)
							.getPERIOD().trim().equals("")) {
				throw BozExceptionFactory.getInstance().newException(
						"Label PERIOD empty");
			}

			String CodePays = RpvDao
					.getInstance()
					.ValidateCountry(
							con,
							((com.inetpsa.boz.rpv.ecm.xml.f2016.TECHNICAL_HEADER) xmlMessage)
									.getCOUNTRY_CODE());
			if (CodePays == null) {
				throw BozExceptionFactory.getInstance().newException(
						"The Country code does not exist. Verify it.");
			}

			if (((com.inetpsa.boz.rpv.ecm.xml.f2016.TECHNICAL_HEADER) xmlMessage)
					.getPERIOD().length() != 6) {
				throw BozExceptionFactory.getInstance().newException(
						"Label PERIOD has not 6 numbers");
			}

			if (Integer
					.parseInt(((com.inetpsa.boz.rpv.ecm.xml.f2016.TECHNICAL_HEADER) xmlMessage)
							.getPERIOD().substring(0, 4)) < 2013) {
				throw BozExceptionFactory
						.getInstance()
						.newException(
								"The year of label PERIOD must be greater or equal than 2013");
			}

			if (Integer
					.parseInt(((com.inetpsa.boz.rpv.ecm.xml.f2016.TECHNICAL_HEADER) xmlMessage)
							.getPERIOD().substring(0, 4)) > 2016) {
				throw BozExceptionFactory
						.getInstance()
						.newException(
								"Format received 2016 for period: "
										+ ((com.inetpsa.boz.rpv.ecm.xml.f2016.TECHNICAL_HEADER) xmlMessage)
												.getPERIOD());
			}

			if (Integer
					.parseInt(((com.inetpsa.boz.rpv.ecm.xml.f2016.TECHNICAL_HEADER) xmlMessage)
							.getPERIOD().substring(4, 6)) < 1
					|| Integer
							.parseInt(((com.inetpsa.boz.rpv.ecm.xml.f2016.TECHNICAL_HEADER) xmlMessage)
									.getPERIOD().substring(4, 6)) > 12) {
				throw BozExceptionFactory.getInstance().newException(
						"The month of label PERIOD must be between 1 and 12");
			}

			if (((com.inetpsa.boz.rpv.ecm.xml.f2016.TECHNICAL_HEADER) xmlMessage)
					.getTRANSFER_DATE() == null
					|| ((com.inetpsa.boz.rpv.ecm.xml.f2016.TECHNICAL_HEADER) xmlMessage)
							.getTRANSFER_DATE().trim().equals("")) {
				throw BozExceptionFactory.getInstance().newException(
						"Label TRANSFER_DATE empty");
			}

			try {
				sdf.setLenient(false);
				sdf.parse(((com.inetpsa.boz.rpv.ecm.xml.f2016.TECHNICAL_HEADER) xmlMessage)
						.getTRANSFER_DATE());
			} catch (Exception e) {
				throw BozExceptionFactory.getInstance().newException(
						"Label TRANSFER_DATE failed. Incorrect format");
			}

		}

		if (sFormat == "2017") {
			if (((com.inetpsa.boz.rpv.ecm.xml.f2017.TECHNICAL_HEADER) xmlMessage)
					.getCOUNTRY_CODE() == null
					|| ((com.inetpsa.boz.rpv.ecm.xml.f2017.TECHNICAL_HEADER) xmlMessage)
							.getCOUNTRY_CODE().trim().equals("")) {
				throw BozExceptionFactory.getInstance().newException(
						"Label COD_COUNTRY empty");
			}

			if (((com.inetpsa.boz.rpv.ecm.xml.f2017.TECHNICAL_HEADER) xmlMessage)
					.getAP_AC().toString() == null
					|| ((com.inetpsa.boz.rpv.ecm.xml.f2017.TECHNICAL_HEADER) xmlMessage)
							.getAP_AC().toString().trim().equals("")) {
				throw BozExceptionFactory.getInstance().newException(
						"Label AP_AC empty");
			}

			if (((com.inetpsa.boz.rpv.ecm.xml.f2017.TECHNICAL_HEADER) xmlMessage)
					.getPERIOD() == null
					|| ((com.inetpsa.boz.rpv.ecm.xml.f2017.TECHNICAL_HEADER) xmlMessage)
							.getPERIOD().trim().equals("")) {
				throw BozExceptionFactory.getInstance().newException(
						"Label PERIOD empty");
			}

			String CodePays = RpvDao
					.getInstance()
					.ValidateCountry(
							con,
							((com.inetpsa.boz.rpv.ecm.xml.f2017.TECHNICAL_HEADER) xmlMessage)
									.getCOUNTRY_CODE());
			if (CodePays == null) {
				throw BozExceptionFactory.getInstance().newException(
						"The Country code does not exist. Verify it.");
			}

			if (((com.inetpsa.boz.rpv.ecm.xml.f2017.TECHNICAL_HEADER) xmlMessage)
					.getPERIOD().length() != 6) {
				throw BozExceptionFactory.getInstance().newException(
						"Label PERIOD has not 6 numbers");
			}

			if (Integer
					.parseInt(((com.inetpsa.boz.rpv.ecm.xml.f2017.TECHNICAL_HEADER) xmlMessage)
							.getPERIOD().substring(0, 4)) < 2013) {
				throw BozExceptionFactory
						.getInstance()
						.newException(
								"The year of label PERIOD must be greater or equal than 2013");
			}

			if (Integer
					.parseInt(((com.inetpsa.boz.rpv.ecm.xml.f2017.TECHNICAL_HEADER) xmlMessage)
							.getPERIOD().substring(0, 4)) < 2017) {
				throw BozExceptionFactory
						.getInstance()
						.newException(
								"Format received 2017 for period: "
										+ ((com.inetpsa.boz.rpv.ecm.xml.f2017.TECHNICAL_HEADER) xmlMessage)
												.getPERIOD());
			}

			if (Integer
					.parseInt(((com.inetpsa.boz.rpv.ecm.xml.f2017.TECHNICAL_HEADER) xmlMessage)
							.getPERIOD().substring(4, 6)) < 1
					|| Integer
							.parseInt(((com.inetpsa.boz.rpv.ecm.xml.f2017.TECHNICAL_HEADER) xmlMessage)
									.getPERIOD().substring(4, 6)) > 12) {
				throw BozExceptionFactory.getInstance().newException(
						"The month of label PERIOD must be between 1 and 12");
			}

			if (((com.inetpsa.boz.rpv.ecm.xml.f2017.TECHNICAL_HEADER) xmlMessage)
					.getTRANSFER_DATE() == null
					|| ((com.inetpsa.boz.rpv.ecm.xml.f2017.TECHNICAL_HEADER) xmlMessage)
							.getTRANSFER_DATE().trim().equals("")) {
				throw BozExceptionFactory.getInstance().newException(
						"Label TRANSFER_DATE empty");
			}

			try {
				sdf.setLenient(false);
				sdf.parse(((com.inetpsa.boz.rpv.ecm.xml.f2017.TECHNICAL_HEADER) xmlMessage)
						.getTRANSFER_DATE());
			} catch (Exception e) {
				throw BozExceptionFactory.getInstance().newException(
						"Label TRANSFER_DATE failed. Incorrect format");
			}

		}

	}

}
