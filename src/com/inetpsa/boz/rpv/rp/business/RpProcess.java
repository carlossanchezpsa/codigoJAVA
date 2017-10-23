package com.inetpsa.boz.rpv.rp.business;

import java.io.BufferedReader;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

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
import com.inetpsa.boz.rpv.rp.dao.RpDao;
import com.inetpsa.boz.rpv.rp.start.Context;
import com.inetpsa.boz.rpv.rp.xml.TECHNICAL_HEADER;

/**
 * Process du traitement du load du SAS
 */
public class RpProcess {

	/**
	 * Effectue l'unmarshalling des fichiers XML du r�pertoire inputPath <li>
	 * Puis int�gre les r�seaux points de ventes dans le SAS</li>
	 */
	public void execute() {
		Unmarshaller unmarshaller = new Unmarshaller(TECHNICAL_HEADER.class);
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

		try {

			// -- R�cup�ration du num�ro du process
			int numProcess = RpvDao.getInstance().getNumProcess(con);

			File[] tabFile = FileUtils.listFilterFiles(Context.getInputPath(),
					Context.getPrefixFileName());
			// System.out.println("tabfile:" + tabFile.length);
			int nbFichier = 0;
			if (tabFile != null)
				nbFichier = tabFile.length;
			// -- Maj du FLG_OLD � Y pour les lignes de SAS recyclages et
			// erreurs
			// RpvDao.getInstance().insertFlagDebut(con);
			// -- Suppression des enregistrement dans OPDV
			RpDao.getInstance().delete(con);

			try {
				LoggerManager.getInstance().info(
						"/*********** DEBUT PROCESS ***********/");
				for (int i = 0; i < nbFichier; i++) {
					if (tabFile[i].isFile()) {
						String etatModule = BozConstants.statusOK;
						LoggerManager.getInstance().info(
								"/*********** DEBUT MODULE ***********/");

						java.util.Date startDateModule = new java.util.Date();
						TECHNICAL_HEADER myMsg = null;
						int nbEnrATraiter = 0;
						int nbEnrRejete = 0;
						BufferedReader br = null;
						String rejectFile = Context.getRejectPath()
								+ File.separator + tabFile[i].getName() + "."
								+ sdfReject.format(startDateModule);
						// int nbLigneMaj = 0;
						// int nbLigneCree = 0;
						try {
							suiviModuleBean = new SuiviModuleBean();
							br = FileUtils.read(tabFile[i], "UTF-8");
							myMsg = (TECHNICAL_HEADER) unmarshaller
									.unmarshal(br);
							validateMandatoryTags(myMsg);
							nbEnrATraiter = getNbEnrATraiter(myMsg);
							suiviModuleBean = RpDao.getInstance().insert(con,
									myMsg, tabFile[i].getName(), numProcess);
							// nbLigneCree++;
							nbFichierOk++;
							File out = new File(Context.getOutputPath()
									+ File.separator + tabFile[i].getName()
									+ "." + sdfReject.format(startDateModule));
							FileUtils.copyFile(tabFile[i], out);
							tabFile[i].delete();

						} catch (Exception ex) {
							// ex.printStackTrace();
							// On sort en erreur du module ==> etatModule == KO
							etatModule = BozConstants.statusKO;
							etatProcess = BozConstants.statusKO;
							suiviModuleBean.setNumErreur(-1);
							suiviModuleBean.setLibErreur(ex.getMessage());
							suiviProcessBean.setLibErreur(ex.getMessage());
							suiviProcessBean.setNumErreur(-1);
							suiviProcessBean.setCodeEtatProcess(etatProcess);
							nbFichierKo++;
							treatException(tabFile[i], rejectFile, ex);

						} finally {
							if (br != null)
								br.close();

							suiviModuleBean.setCodeTypeProcess("LOAD_SASINF");
							suiviModuleBean.setNumProcess(numProcess);
							suiviModuleBean.setCodeModule("LOAD_RPR");
							suiviModuleBean.setCodeSource(tabFile[i].getName());
							suiviModuleBean.setCodeCible("BOZQTPRPR");
							if (myMsg != null) {
								suiviModuleBean.setCodePays("XX");
								suiviModuleBean.setCodeMarque("XX");
								/*
								 * suiviModuleBean.setCodeMarque(myMsg.
								 * getTECHNICAL_HEADER().getAP_AC().toString());
								 * try { if
								 * (myMsg.getTECHNICAL_HEADER().getEXTRACT_VERSION
								 * () != null &&
								 * !"".equals(myMsg.getTECHNICAL_HEADER
								 * ().getEXTRACT_VERSION().trim()))
								 * suiviModuleBean
								 * .setNumVersion(Integer.parseInt
								 * (myMsg.getTECHNICAL_HEADER
								 * ().getEXTRACT_VERSION())); } catch
								 * (NumberFormatException nbfex) {
								 * LoggerManager.getInstance().info(
								 * "Le num�ro de l'extraction n'est pas un num�rique"
								 * ); }
								 * suiviModuleBean.setNbEnrATraiter(nbEnrATraiter
								 * );
								 * suiviModuleBean.setNbEnrRejete(nbEnrRejete);
								 * 
								 * try { suiviModuleBean.setDateDebutExtract(new
								 * Date
								 * (sdf.parse(myMsg.getTECHNICAL_HEADER().getDATE
								 * ()).getTime())); } catch (ParseException pex)
								 * {
								 * LoggerManager.getInstance().error(pex.getMessage
								 * ()); } try {
								 * suiviModuleBean.setDateFinExtract(new
								 * Date(sdf
								 * .parse(myMsg.getTECHNICAL_HEADER().getDATE
								 * ()).getTime())); } catch (ParseException pex)
								 * {
								 * LoggerManager.getInstance().error(pex.getMessage
								 * ()); }
								 * suiviModuleBean.setLibTypeFichier(myMsg
								 * .getTECHNICAL_HEADER().getFILE_TYPE()); try {
								 * suiviModuleBean.setDateTransfer(new
								 * Date(sdf.parse
								 * (myMsg.getTECHNICAL_HEADER().getDATE
								 * ()).getTime())); } catch (ParseException pex)
								 * {
								 * LoggerManager.getInstance().error(pex.getMessage
								 * ()); }
								 */
								suiviModuleBean.setNumVersion(Integer
										.parseInt("1"));
								suiviModuleBean.setNbEnrATraiter(nbEnrATraiter);
								suiviModuleBean.setNbEnrRejete(nbEnrRejete);
								suiviModuleBean
										.setLibTypeFichier("Fichier RPR");

								try {
									// suiviModuleBean.setDateTransfer(new
									// java.sql.Date(sdf2.parse(myMsg.getTRANSFER_DATE()).getTime()));
									SimpleDateFormat sdf3 = new SimpleDateFormat(
											"dd/MM/yyyy HH:mm:ss");
									java.util.Date date = sdf3.parse(myMsg
											.getTRANSFER_DATE());
									java.sql.Timestamp timest = new java.sql.Timestamp(
											date.getTime());
									// System.out.println(timest);

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
							logModule(suiviModuleBean, tabFile[i].getName());
							try {
								RpvDao.getInstance().insertSuiviModule(con,
										suiviModuleBean);
							} catch (BozException bex) {
								LoggerManager.getInstance().error(
										bex.getMessage());
							}
						}
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

			// -- Maj de BOZQTSTAB avec 'Y'
			RpvDao.getInstance().insertFlagFin(con, "BOZQTORPR");

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
			bex.printStackTrace();
		}
	}

	/**
	 * 
	 * @param xmlMessage
	 * @throws BozException
	 */
	private void validateMandatoryTags(TECHNICAL_HEADER xmlMessage)
			throws BozException {

		// Connection con = DbManager.getInstance().getConnection();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

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

		/*
		 * int nbAct = xmlMessage.getACTIVITYCount();
		 * 
		 * for (int i = 0; i < nbAct; i++) {
		 * 
		 * int nbSubsidiary = xmlMessage.getACTIVITY(i).getSUBSIDIARYCount();
		 * 
		 * for (int j = 0; j < nbSubsidiary; j++) {
		 * 
		 * int nbDealer =
		 * xmlMessage.getACTIVITY(i).getSUBSIDIARY(j).getDEALERCount();
		 * 
		 * for (int k = 0; k < nbDealer; k++) {
		 * 
		 * if
		 * (xmlMessage.getACTIVITY(i).getSUBSIDIARY(j).getDEALER(k).getDEALER_CODE
		 * ().length() < 7 ||
		 * xmlMessage.getACTIVITY(i).getSUBSIDIARY(j).getDEALER
		 * (k).getDEALER_CODE().length() > 10) { throw
		 * BozExceptionFactory.getInstance
		 * ().newException("Label DEALER CODE. Length is not allowed"); } }
		 * 
		 * } }
		 */
		/*
		 * int nbAct = xmlMessage.getACTIVITYCount();
		 * 
		 * for (int i = 0; i < nbAct; i++) {
		 * 
		 * if (xmlMessage.getACTIVITY(i).getACTIVITY_CODE() == null ||
		 * xmlMessage.getACTIVITY(i).getACTIVITY_CODE().trim().equals("")) {
		 * throw
		 * BozExceptionFactory.getInstance().newException("Label ACTITY_CODE empty"
		 * ); }
		 * 
		 * int nbSubsidiary = xmlMessage.getACTIVITY(i).getSUBSIDIARYCount();
		 * 
		 * for (int j = 0; j < nbSubsidiary; j++) {
		 * 
		 * if (xmlMessage.getACTIVITY(i).getSUBSIDIARY(j).getCOUNTRY_CODE() ==
		 * null ||
		 * xmlMessage.getACTIVITY(i).getSUBSIDIARY(j).getCOUNTRY_CODE().trim
		 * ().equals("")) { throw
		 * BozExceptionFactory.getInstance().newException(
		 * "Label COD_COUNTRY empty"); }
		 * 
		 * if (xmlMessage.getACTIVITY(i).getSUBSIDIARY(j).getAP_AC().toString()
		 * == null ||
		 * xmlMessage.getACTIVITY(i).getSUBSIDIARY(j).getAP_AC().toString
		 * ().trim().equals("")) { throw
		 * BozExceptionFactory.getInstance().newException("Label AP_AC empty");
		 * }
		 * 
		 * String CodePays = RpvDao.getInstance().ValidateCountry(con,
		 * xmlMessage.getACTIVITY(i).getSUBSIDIARY(j).getCOUNTRY_CODE()); if
		 * (CodePays == null) { throw
		 * BozExceptionFactory.getInstance().newException
		 * ("The Country code does not exist. Verify it."); }
		 * 
		 * int nbDealer =
		 * xmlMessage.getACTIVITY(i).getSUBSIDIARY(j).getDEALERCount();
		 * 
		 * for (int k = 0; k < nbDealer; k++) { if
		 * (xmlMessage.getACTIVITY(i).getSUBSIDIARY
		 * (j).getDEALER(k).getDEALER_CODE() == null ||
		 * xmlMessage.getACTIVITY(i)
		 * .getSUBSIDIARY(j).getDEALER(k).getDEALER_CODE().trim().equals("")) {
		 * throw
		 * BozExceptionFactory.getInstance().newException("Label DEALER_CODE empty"
		 * ); } }
		 * 
		 * }
		 * 
		 * }
		 */

	}

	/**
	 * Renvoie le nombre de ligne � cr�er = au nombre total d'activit�
	 * 
	 * @param myMsg
	 *            Le message XML
	 * @param Le
	 *            nombre de ligne � cr�er
	 */
	private int getNbEnrATraiter(TECHNICAL_HEADER myMsg) {
		int nbActiviteTotal = 0;
		int nbAct = myMsg.getACTIVITYCount();
		for (int i = 0; i < nbAct; i++) {
			// int nbIndividual = myMsg.getDEALER(k).getINDIVIDUALCount();
			int nbSubsidiary = myMsg.getACTIVITY(i).getSUBSIDIARYCount();
			if (nbSubsidiary == 0)
				nbActiviteTotal++;
			else
				for (int j = 0; j < nbSubsidiary; j++) {
					int nbDealer = myMsg.getACTIVITY(i).getSUBSIDIARY(j)
							.getDEALERCount();
					if (nbSubsidiary == 0)
						nbActiviteTotal++;
					else
						nbActiviteTotal = nbActiviteTotal + nbDealer;
				}
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
				"Num�ro du process \t\t\t\t: "
						+ suiviModuleBean.getNumProcess());
		LoggerManager.getInstance().info(
				"Code �tat du module \t\t\t\t: "
						+ suiviModuleBean.getCodeEtatModule());
		LoggerManager.getInstance().info(
				"Nombre de ligne ins�r�e \t\t: "
						+ suiviModuleBean.getNbLigneInsere());
		LoggerManager.getInstance().info(
				"Nombre d'enregistrement � traiter : "
						+ suiviModuleBean.getNbEnrATraiter());
		LoggerManager.getInstance().info(
				"Nombre d'enregistrement rejet� : "
						+ suiviModuleBean.getNbEnrRejete());
		LoggerManager.getInstance().info(
				"Nombre de ligne rejet�e \t\t: "
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
				"Num�ro du process : " + suiviProcessBean.getNumProcess());
		LoggerManager.getInstance().info(
				"Code �tat du process : "
						+ suiviProcessBean.getCodeEtatProcess());
		LoggerManager.getInstance().info(
				"Nombre de fichier � traiter : "
						+ suiviProcessBean.getNbFichierATraiter());
		LoggerManager.getInstance().info(
				"Nombre de fichier OK : " + suiviProcessBean.getNbFichierOk());
		LoggerManager.getInstance().info(
				"Nombre de fichier rejet� : "
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

	/**
	 * 
	 * @param xmlMessage
	 * @throws BozException
	 */
	/*
	 * private void validateMandatoryTags(TECHNICAL_HEADER xmlMessage) throws
	 * BozException {
	 * 
	 * int nbAct = xmlMessage.getACTIVITYCount(); for (int j = 0; j < nbAct;
	 * j++) {
	 * 
	 * if (xmlMessage.getPDV(j).getPAYS_ORIGINE() == null ||
	 * xmlMessage.getPDV(j).getPAYS_ORIGINE().trim().equals("")) { throw
	 * BozExceptionFactory.getInstance().newException("PAYS_ORIGINE"); }
	 * 
	 * if (xmlMessage.getPDV(j).getMARQUE_ORIGINE() == null ||
	 * xmlMessage.getPDV(j).getMARQUE_ORIGINE().trim().equals("")) { throw
	 * BozExceptionFactory.getInstance().newException("MARQUE_ORIGINE"); }
	 * 
	 * if (xmlMessage.getPDV(j).getID_PDV_RRDI() == null ||
	 * xmlMessage.getPDV(j).getID_PDV_RRDI().trim().equals("")) { throw
	 * BozExceptionFactory.getInstance().newException("ID_PDV_RRDI"); }
	 * 
	 * if (xmlMessage.getPDV(j).getNOM_COMMERCIAL() == null ||
	 * xmlMessage.getPDV(j).getNOM_COMMERCIAL().trim().equals("")) { throw
	 * BozExceptionFactory.getInstance().newException("NOM_COMMERCIAL"); }
	 * 
	 * if (xmlMessage.getPDV(j).getTYPE_PDV1() == null ||
	 * xmlMessage.getPDV(j).getTYPE_PDV1().trim().equals("")) { throw
	 * BozExceptionFactory.getInstance().newException("TYPE_PDV1"); }
	 * 
	 * if
	 * (!xmlMessage.getPDV(j).getTYPE_PDV1().equals(BozConstants.BOZ_PDV_PLAQUE
	 * )) { if (xmlMessage.getPDV(j).getACTIVITE() == null ||
	 * xmlMessage.getPDV(j).getACTIVITE().trim().equals("")) { throw
	 * BozExceptionFactory.getInstance().newException("ACTIVITE"); } }
	 * 
	 * if (xmlMessage.getPDV(j).getDATE_CREATION() == null ||
	 * xmlMessage.getPDV(j).getDATE_CREATION().trim().equals("")) { throw
	 * BozExceptionFactory.getInstance().newException("DATE_CREATION"); }
	 * 
	 * if
	 * (xmlMessage.getPDV(j).getTYPE_PDV1().equals(BozConstants.BOZ_PDV_PLAQUE))
	 * { int nbContrat = xmlMessage.getPDV(j).getCONTRAT_PLAQUECount();
	 * 
	 * for (int k = 0; k < nbContrat; k++) { if
	 * (xmlMessage.getPDV(j).getCONTRAT_PLAQUE(k).getID_CONTRAT_PLAQUE() == null
	 * ||
	 * xmlMessage.getPDV(j).getCONTRAT_PLAQUE(k).getID_CONTRAT_PLAQUE().trim()
	 * .equals("")) { throw
	 * BozExceptionFactory.getInstance().newException("ID_CONTRAT_PLAQUE"); }
	 * 
	 * if
	 * (xmlMessage.getPDV(j).getCONTRAT_PLAQUE(k).getACTIVITE_CONTRAT_PLAQUE()
	 * == null ||
	 * xmlMessage.getPDV(j).getCONTRAT_PLAQUE(k).getACTIVITE_CONTRAT_PLAQUE
	 * ().trim().equals("")) { throw
	 * BozExceptionFactory.getInstance().newException
	 * ("ACTIVITE_CONTRAT_PLAQUE"); }
	 * 
	 * if (xmlMessage.getPDV(j).getCONTRAT_PLAQUE(k).getDATE_CREATION_LIEN() ==
	 * null ||
	 * xmlMessage.getPDV(j).getCONTRAT_PLAQUE(k).getDATE_CREATION_LIEN().
	 * trim().equals("")) { throw
	 * BozExceptionFactory.getInstance().newException("DATE_CREATION_LIEN"); }
	 * 
	 * } }
	 * 
	 * }
	 * 
	 * }
	 */

}
