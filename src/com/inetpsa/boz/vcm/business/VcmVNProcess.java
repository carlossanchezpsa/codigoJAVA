package com.inetpsa.boz.vcm.business;

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
import com.inetpsa.boz.vcm.start.Context;
import com.inetpsa.boz.vcm.vn.dao.VcmVNDao;

/**
 * Process du traitement du load du SAS
 */
public class VcmVNProcess {

	/**
	 * Effectue l'unmarshalling des fichiers XML du r�pertoire inputPath Puis
	 * l'insertion des objets dans la BD
	 * 
	 */
	public void execute(SuiviProcessBean suiviProcessBean) {
		Unmarshaller unmarshallerV3 = new Unmarshaller(
				com.inetpsa.boz.vcm.vn.xml.v3.TECHNICAL_HEADER.class);
		Unmarshaller unmarshallerV4 = new Unmarshaller(
				com.inetpsa.boz.vcm.vn.xml.v4.TECHNICAL_HEADER.class);
		Connection con = DbManager.getInstance().getConnection();
		// SuiviProcessBean report = new SuiviProcessBean();
		// -- Init date de suivi du process
		java.util.Date dateDebutProcess = new java.util.Date();
		// SuiviProcessBean suiviProcessBean = new SuiviProcessBean();
		SuiviModuleBean suiviModuleBean = null;
		String etatProcess = BozConstants.statusOK;
		// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdfReject = new SimpleDateFormat("yyyyMMddHHmmss");
		String sFriendyMessage = null;
		int iVersion = 0;
		Date date2 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date2);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		String strExceptionV3 = null;
		String strExceptionV4 = null;
		int nbFichierOk = suiviProcessBean.getNbFichierOk();
		int nbFichierKo = suiviProcessBean.getNbFichierRejet();
		int nbFichier = suiviProcessBean.getNbFichierATraiter();

		try {

			// -- R�cup�ration du num�ro du process
			int numProcess = suiviProcessBean.getNumProcess();
			File[] tabFile = FileUtils.listFilterFiles(Context.getInputPath(),
					Context.getPrefixFileNameVN());
			try {
				// LoggerManager.getInstance().info(
				// "/*********** DEBUT PROCESS ***********/");
				for (int i = 0; i < tabFile.length; i++) {
					java.util.Date startDateModule = new java.util.Date();
					String rejectFile = Context.getRejectPath()
							+ File.separator + tabFile[i].getName() + "."
							+ sdfReject.format(startDateModule);

					if (tabFile[i].isFile() && tabFile[i].length() > 0) {

						String etatModule = BozConstants.statusOK;
						LoggerManager.getInstance().info(
								"/*********** DEBUT MODULE ***********/");

						com.inetpsa.boz.vcm.vn.xml.v3.TECHNICAL_HEADER myMsgV3 = null;
						com.inetpsa.boz.vcm.vn.xml.v4.TECHNICAL_HEADER myMsgV4 = null;
						int nbEnrATraiter = 0;
						int nbEnrRejete = 0;
						BufferedReader br = null;
						nbFichier++;

						try {
							suiviModuleBean = new SuiviModuleBean();
							br = FileUtils.read(tabFile[i], "UTF-8");
							try {
								myMsgV4 = (com.inetpsa.boz.vcm.vn.xml.v4.TECHNICAL_HEADER) unmarshallerV4
										.unmarshal(br);
								iVersion = 4;
							} catch (Exception unExceptionV4) {
								strExceptionV4 = unExceptionV4.getMessage();
								if (br != null) {
									br.close();
									br = null;
									try {
										br = FileUtils
												.read(tabFile[i], "UTF-8");
									} catch (Exception exceptionRead) {
										throw exceptionRead;
									}
									try {
										myMsgV3 = (com.inetpsa.boz.vcm.vn.xml.v3.TECHNICAL_HEADER) unmarshallerV3
												.unmarshal(br);
										iVersion = 3;
									} catch (Exception unExceptionV3) {
										strExceptionV3 = unExceptionV3
												.getMessage();
										String sException = null;
										if (year >= 2017 && month >= 5) {
											sException = getFriendlyMessage(strExceptionV4);
										} else {
											sException = "Format Error. For V3 format: "
													+ getFriendlyMessage(strExceptionV3)
													+ ". For V4 format: "
													+ getFriendlyMessage(strExceptionV4);
										}
										throw new Exception(sException);
									}
								}
							}
							if (iVersion == 4) {
								nbEnrATraiter = getNbEnrATraiter(myMsgV4);
								validateMandatoryTags(myMsgV4);
								suiviModuleBean = VcmVNDao.getInstance()
										.insert(con, myMsgV4,
												tabFile[i].getName(),
												numProcess);
							}
							if (iVersion == 3) {
								nbEnrATraiter = getNbEnrATraiter(myMsgV3);
								validateFormat2015(myMsgV3);
								validateMandatoryTags(myMsgV3);
								suiviModuleBean = VcmVNDao.getInstance()
										.insert(con, myMsgV3,
												tabFile[i].getName(),
												numProcess);
							}

							nbFichierOk++;
							RpvDao.getInstance()
									.insertFlagFin(con, "BOZQTOEVM");
							File out = new File(Context.getOutputPath()
									+ File.separator + tabFile[i].getName()
									+ "." + sdfReject.format(startDateModule));
							FileUtils.copyFile(tabFile[i], out);
							tabFile[i].delete();

							// copia el fichero renombrado en el directorio
							// batchs/integre

						} catch (Exception ex) {
							etatModule = BozConstants.statusKO;
							etatProcess = BozConstants.statusKO;
							suiviModuleBean.setNumErreur(-1);

							sFriendyMessage = getFriendlyMessage(ex
									.getMessage());
							try {
								if (sFriendyMessage.length() > 999) {
									sFriendyMessage = sFriendyMessage
											.substring(0, 998);
								}
								suiviModuleBean.setLibErreur(sFriendyMessage);
							} catch (Exception ioobe) {
								suiviModuleBean.setLibErreur(sFriendyMessage);
							}
							suiviProcessBean.setNumErreur(-1);
							suiviProcessBean.setCodeEtatProcess(etatProcess);
							nbFichierKo++;
							treatException(tabFile[i], rejectFile, ex);

						} finally {
							if (br != null)
								br.close();

							suiviModuleBean.setCodeTypeProcess("LOAD_SASINF");
							suiviModuleBean.setNumProcess(numProcess);
							suiviModuleBean.setCodeModule("LOAD_EVM_VN");
							suiviModuleBean.setCodeSource(tabFile[i].getName());
							suiviModuleBean.setCodeCible("BOZQTOEVM");
							if (myMsgV3 != null || myMsgV4 != null) {

								suiviModuleBean
										.setCodePays((myMsgV3 == null) ? myMsgV4
												.getCOUNTRY_CODE() : myMsgV3
												.getCOUNTRY_CODE());

								suiviModuleBean
										.setCodeMarque((myMsgV3 == null) ? myMsgV4
												.getAP_AC().toString()
												: myMsgV3.getAP_AC().toString());

								suiviModuleBean.setNumVersion(iVersion);
								suiviModuleBean.setNbEnrATraiter(nbEnrATraiter);
								suiviModuleBean.setNbEnrRejete(nbEnrRejete);

								suiviModuleBean
										.setLibTypeFichier("Fichier EVM-VN");
								try {
									SimpleDateFormat sdf3 = new SimpleDateFormat(
											"dd/MM/yyyy HH:mm:ss");

									java.util.Date date = sdf3
											.parse((myMsgV3 == null) ? myMsgV4
													.getTRANSFER_DATE()
													: myMsgV3
															.getTRANSFER_DATE());

									java.sql.Timestamp timest = new java.sql.Timestamp(
											date.getTime());
									// System.out.println(timest);

									suiviModuleBean.setDateTransfer(timest);

									// suiviModuleBean.setDateTransfer(new
									// java.sql.Date(sdf2.parse(myMsg.getTRANSFER_DATE()).getTime()));

								} catch (Exception pex) {
									LoggerManager.getInstance().error(
											pex.getMessage());
								}

							}
							suiviModuleBean.setLibTypeFichier("Fichier EVM-VN");
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
				if (!con.isReadOnly())
					con.commit();
			} catch (SQLException sqlex) {
				LoggerManager.getInstance().error(sqlex.getMessage());
			}

		} catch (Exception bex) {
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

	/**
	 * Renvoie le nombre de ligne � cr�er = au nombre total d'activit�
	 * 
	 * @param myMsg
	 *            Le message XML
	 * @return Le nombre de ligne � cr�er
	 */
	private int getNbEnrATraiter(
			com.inetpsa.boz.vcm.vn.xml.v4.TECHNICAL_HEADER myMsg) {
		// int nbEnrATraiter = 0;
		int nbActiviteTotal = 0;
		int nbDealer = myMsg.getDEALERCount();
		for (int k = 0; k < nbDealer; k++) {
			// int nbIndividual = myMsg.getDEALER(k).getINDIVIDUALCount();
			int nbQuestionnaire = myMsg.getDEALER(k).getQUESTIONNAIRECount();
			if (nbQuestionnaire == 0)
				nbActiviteTotal++;
			else
				nbActiviteTotal = nbActiviteTotal + nbQuestionnaire;
		}

		return nbActiviteTotal;
	}

	private int getNbEnrATraiter(
			com.inetpsa.boz.vcm.vn.xml.v3.TECHNICAL_HEADER myMsg) {
		// int nbEnrATraiter = 0;
		int nbActiviteTotal = 0;
		int nbDealer = myMsg.getDEALERCount();
		for (int k = 0; k < nbDealer; k++) {
			// int nbIndividual = myMsg.getDEALER(k).getINDIVIDUALCount();
			int nbQuestionnaire = myMsg.getDEALER(k).getQUESTIONNAIRECount();
			if (nbQuestionnaire == 0)
				nbActiviteTotal++;
			else
				nbActiviteTotal = nbActiviteTotal + nbQuestionnaire;
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
	private void validateMandatoryTags(
			com.inetpsa.boz.vcm.vn.xml.v3.TECHNICAL_HEADER xmlMessage)
			throws BozException {

		com.inetpsa.boz.rpv.xml.types.ActivityPSAType activity;
		com.inetpsa.boz.rpv.xml.types.MarquePSAType marque;

		// int nbDealer = xmlMessage.getDEALERCount();
		Connection con = DbManager.getInstance().getConnection();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		if (xmlMessage.getCOUNTRY_CODE() == null
				|| xmlMessage.getCOUNTRY_CODE().trim().equals("")) {
			throw BozExceptionFactory.getInstance().newException(
					"Label COD_COUNTRY empty");
		}

		if (xmlMessage.getAP_AC().toString() == null
				|| xmlMessage.getAP_AC().toString().trim().equals("")) {
			throw BozExceptionFactory.getInstance().newException(
					"Label AP_AC empty");
		}

		try {
			marque = com.inetpsa.boz.rpv.xml.types.MarquePSAType
					.valueOf(xmlMessage.getAP_AC().toString().trim());
		} catch (IllegalArgumentException iae) {
			throw BozExceptionFactory.getInstance().newException(
					"The marque code does not exists. Verify it.");
		}

		if (xmlMessage.getPERIOD() == null
				|| xmlMessage.getPERIOD().trim().equals("")) {
			throw BozExceptionFactory.getInstance().newException(
					"Label PERIOD empty");
		}

		if (xmlMessage.getFILE_TYPE() == null
				|| xmlMessage.getFILE_TYPE().trim().equals("")) {
			throw BozExceptionFactory.getInstance().newException(
					"File Type empty");
		}

		if (xmlMessage.getACTIVITY() == null
				|| xmlMessage.getACTIVITY().toString().trim().equals("")) {
			throw BozExceptionFactory.getInstance().newException(
					"Activity empty");
		}

		try {
			activity = com.inetpsa.boz.rpv.xml.types.ActivityPSAType
					.valueOf(xmlMessage.getACTIVITY().toString().trim());
		} catch (IllegalArgumentException iae) {
			throw BozExceptionFactory.getInstance().newException(
					"The Activity code does not exists. Verify it.");
		}

		String CodePays = RpvDao.getInstance().ValidateCountry(con,
				xmlMessage.getCOUNTRY_CODE());
		if (CodePays == null) {
			throw BozExceptionFactory.getInstance().newException(
					"The Country code does not exist. Verify it.");
		}

		if (xmlMessage.getPERIOD().length() != 6) {
			throw BozExceptionFactory.getInstance().newException(
					"Label PERIOD has not 6 numbers");
		}

		if (Integer.parseInt(xmlMessage.getPERIOD().substring(0, 4)) < 2013) {
			throw BozExceptionFactory
					.getInstance()
					.newException(
							"The year of label PERIOD must be greater or equal than 2013");
		}

		if (Integer.parseInt(xmlMessage.getPERIOD().substring(4, 6)) < 1
				|| Integer.parseInt(xmlMessage.getPERIOD().substring(4, 6)) > 12) {
			throw BozExceptionFactory.getInstance().newException(
					"The month of label PERIOD must be between 1 and 12");
		}

		if (xmlMessage.getTRANSFER_DATE() == null
				|| xmlMessage.getTRANSFER_DATE().trim().equals("")) {
			throw BozExceptionFactory.getInstance().newException(
					"Label TRANSFER_DATE empty");
		}

		try {
			sdf.setLenient(false);
			sdf.parse(xmlMessage.getTRANSFER_DATE());
		} catch (Exception e) {
			throw BozExceptionFactory.getInstance().newException(
					"Label TRANSFER_DATE failed. Incorrect format");
		}

	}

	/**
	 * 
	 * @param xmlMessage
	 * @throws BozException
	 */
	private void validateMandatoryTags(
			com.inetpsa.boz.vcm.vn.xml.v4.TECHNICAL_HEADER xmlMessage)
			throws BozException {

		com.inetpsa.boz.rpv.xml.types.ActivityPSAType activity;
		com.inetpsa.boz.rpv.xml.types.MarquePSAType marque;

		// int nbDealer = xmlMessage.getDEALERCount();
		Connection con = DbManager.getInstance().getConnection();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		if (xmlMessage.getCOUNTRY_CODE() == null
				|| xmlMessage.getCOUNTRY_CODE().trim().equals("")) {
			throw BozExceptionFactory.getInstance().newException(
					"Label COD_COUNTRY empty");
		}

		if (xmlMessage.getAP_AC().toString() == null
				|| xmlMessage.getAP_AC().toString().trim().equals("")) {
			throw BozExceptionFactory.getInstance().newException(
					"Label AP_AC empty");
		}

		try {
			marque = com.inetpsa.boz.rpv.xml.types.MarquePSAType
					.valueOf(xmlMessage.getAP_AC().toString().trim());
		} catch (IllegalArgumentException iae) {
			throw BozExceptionFactory.getInstance().newException(
					"The marque code does not exists. Verify it.");
		}

		if (xmlMessage.getPERIOD() == null
				|| xmlMessage.getPERIOD().trim().equals("")) {
			throw BozExceptionFactory.getInstance().newException(
					"Label PERIOD empty");
		}

		if (xmlMessage.getFILE_TYPE() == null
				|| xmlMessage.getFILE_TYPE().trim().equals("")) {
			throw BozExceptionFactory.getInstance().newException(
					"File Type empty");
		}

		if (xmlMessage.getACTIVITY() == null
				|| xmlMessage.getACTIVITY().toString().trim().equals("")) {
			throw BozExceptionFactory.getInstance().newException(
					"Activity empty");
		}

		try {
			activity = com.inetpsa.boz.rpv.xml.types.ActivityPSAType
					.valueOf(xmlMessage.getACTIVITY().toString().trim());
		} catch (IllegalArgumentException iae) {
			throw BozExceptionFactory.getInstance().newException(
					"The Activity code does not exists. Verify it.");
		}

		String CodePays = RpvDao.getInstance().ValidateCountry(con,
				xmlMessage.getCOUNTRY_CODE());
		if (CodePays == null) {
			throw BozExceptionFactory.getInstance().newException(
					"The Country code does not exist. Verify it.");
		}

		if (xmlMessage.getPERIOD().length() != 6) {
			throw BozExceptionFactory.getInstance().newException(
					"Label PERIOD has not 6 numbers");
		}

		if (Integer.parseInt(xmlMessage.getPERIOD().substring(0, 4)) < 2013) {
			throw BozExceptionFactory
					.getInstance()
					.newException(
							"The year of label PERIOD must be greater or equal than 2013");
		}

		if (Integer.parseInt(xmlMessage.getPERIOD().substring(4, 6)) < 1
				|| Integer.parseInt(xmlMessage.getPERIOD().substring(4, 6)) > 12) {
			throw BozExceptionFactory.getInstance().newException(
					"The month of label PERIOD must be between 1 and 12");
		}

		if (xmlMessage.getTRANSFER_DATE() == null
				|| xmlMessage.getTRANSFER_DATE().trim().equals("")) {
			throw BozExceptionFactory.getInstance().newException(
					"Label TRANSFER_DATE empty");
		}

		try {
			sdf.setLenient(false);
			sdf.parse(xmlMessage.getTRANSFER_DATE());
		} catch (Exception e) {
			throw BozExceptionFactory.getInstance().newException(
					"Label TRANSFER_DATE failed. Incorrect format");
		}

		if (Integer.parseInt(xmlMessage.getPERIOD().substring(0, 4)) < 2017) {
			throw BozExceptionFactory.getInstance().newException(
					"Format received 2017 for period: "
							+ xmlMessage.getPERIOD());
		}

		// Validamos que Q25 solo venga para la marca DS.
		/*
		 * if (!marque.toString().equals(
		 * com.inetpsa.boz.rpv.xml.types.MarquePSAType.DS.toString())) { int
		 * nbDealer = xmlMessage.getDEALERCount(); for (int j = 0; j < nbDealer;
		 * j++) { int nbLead = xmlMessage.getDEALER(j).getQUESTIONNAIRECount();
		 * for (int k = 0; k < nbLead; k++) { if
		 * (xmlMessage.getDEALER(j).getQUESTIONNAIRE(k).getQ25() != null) {
		 * throw BozExceptionFactory .getInstance() .newException(
		 * "unable to find FieldDescriptor for 'Q25' in ClassDescriptor of QUESTIONNAIRE"
		 * ); } } } }
		 */

	}

	/**
	 * 
	 * @param xmlMessage
	 * @throws BozException
	 */
	private void validateFormat2015(
			com.inetpsa.boz.vcm.vn.xml.v3.TECHNICAL_HEADER xmlMessage)
			throws BozException {

		if (Integer.parseInt(xmlMessage.getPERIOD().substring(0, 4)) == 2015) {
			int nbDealer = xmlMessage.getDEALERCount();
			for (int j = 0; j < nbDealer; j++) {
				int nbLead = xmlMessage.getDEALER(j).getQUESTIONNAIRECount();
				for (int k = 0; k < nbLead; k++) {
					if (xmlMessage.getDEALER(j).getQUESTIONNAIRE(k).getQ94() != null) {
						throw BozExceptionFactory
								.getInstance()
								.newException(
										"unable to find FieldDescriptor for 'Q94' in ClassDescriptor of QUESTIONNAIRE");
					}
				}
			}
		}
	}

}
