/*
 * Cr�� le 24 ao�t 2007
 *
 * Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre&gt;Pr�f�rences&gt;Java&gt;G�n�ration de code&gt;Code et commentaires
 */
package com.inetpsa.boz.vcm.apv.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.inetpsa.boz.common.bean.AlertBean;
import com.inetpsa.boz.common.bean.EcmErrorsBean;
import com.inetpsa.boz.common.bean.SuiviModuleBean;
import com.inetpsa.boz.common.constant.BozConstants;
import com.inetpsa.boz.common.dao.BozDao;
import com.inetpsa.boz.common.exception.BozException;
import com.inetpsa.boz.common.exception.BozExceptionFactory;
import com.inetpsa.boz.common.utils.StringUtils;

/**
 * DAO des objets Opportunit�s
 * 
 * @author e210954
 */
public class VcmAPVDao extends BozDao {

	/** Singleton */
	private static VcmAPVDao instance;

	/**
	 * Constructor
	 * 
	 * @param resource
	 *            nom du fichier de ressource
	 */
	private VcmAPVDao(String resource) {
		super(resource);
	}

	/**
	 * Singleton
	 * 
	 * @return instance L'instance unique de la classe
	 */
	public static VcmAPVDao getInstance() {
		if (instance == null)
			instance = new VcmAPVDao("BOZRPVQUERIES");
		return instance;
	}

	public List selectProcessedCountries(Connection con, String lastDate)
			throws BozException {
		PreparedStatement ppStmt = null;
		List listSuiviModuleBeans = new ArrayList();
		try {
			ppStmt = con.prepareStatement(getQuery("SELECT_FILES"));
			ppStmt.setString(1, lastDate);
			ResultSet rs = ppStmt.executeQuery();
			while (rs.next()) {
				SuiviModuleBean suiviModuleBean = new SuiviModuleBean();
				suiviModuleBean.setCodePays(rs.getString("COD_PAYS"));
				suiviModuleBean.setCodeMarque(rs.getString("COD_MARQUE"));
				suiviModuleBean.setCodeEtatModule(rs
						.getString("COD_ETAT_MODULE"));
				suiviModuleBean.setLibErreur(rs.getString("LIB_ERREUR"));
				suiviModuleBean.setCodeSource(rs.getString("COD_SOURCE"));
				listSuiviModuleBeans.add(suiviModuleBean);
			}
		} catch (SQLException sqlExp) {
			BozExceptionFactory.getInstance().throwException(sqlExp, 50);
		} finally {
			try {
				if (ppStmt != null) {
					ppStmt.close();
					ppStmt = null;
				}
			} catch (SQLException sqlExp) {
				BozExceptionFactory.getInstance().throwException(sqlExp, 50);
			}
		}
		return listSuiviModuleBeans;
	}

	public String selectLastAlertDate(Connection con) throws BozException {
		PreparedStatement ppStmt = null;
		String date = null;
		try {
			ppStmt = con.prepareStatement(getQuery("SELECT_SMOD_LAST_ALERT"));
			ResultSet rs = ppStmt.executeQuery();
			while (rs.next()) {
				date = rs.getString("DTH_DEB_MODULE");
			}
		} catch (SQLException sqlExp) {
			BozExceptionFactory.getInstance().throwException(sqlExp, 50);
		} finally {
			try {
				if (ppStmt != null) {
					ppStmt.close();
					ppStmt = null;
				}
			} catch (SQLException sqlExp) {
				BozExceptionFactory.getInstance().throwException(sqlExp, 50);
			}
		}
		return date;
	}

	public AlertBean selectAlertBeanData(Connection con, String fileName)
			throws BozException {
		PreparedStatement ppStmt = null;
		AlertBean alertBean = null;// = new AlertBean();
		try {
			ppStmt = con.prepareStatement(getQuery("SELECT_ALERT"));
			ppStmt.setString(1, fileName);
			ResultSet rs = ppStmt.executeQuery();
			if (rs.next()) {
				alertBean = new AlertBean();
				// do {
				alertBean.setCountryCode(rs.getString("COD_PAYS"));
				alertBean.setMarqueCode(rs.getString("COD_MARQUE"));
				alertBean.setCodeLangue(rs.getString("COD_LANGUE"));
				alertBean.setEmailSubject(rs.getString("SUJET_EMAIL"));
				alertBean.setFileName(rs.getString("COD_NOM_FICHIER"));
				alertBean.setInstituteEmail(rs.getString("INSTITUT_EMAIL"));
				alertBean.setMoaEmail(rs.getString("MOA_EMAIL"));
				alertBean.setEmailBody(rs.getString("CORP_EMAIL"));
				alertBean.setEmailBodyKo(rs.getString("CORP_EMAIL_KO"));
				alertBean.setEmailBodyOk(rs.getString("CORP_EMAIL_OK"));
				alertBean.setEmailBodyWR(rs.getString("CORP_EMAIL_WR"));
				alertBean.setFinEmail(rs.getString("FIN_EMAIL"));
				// }while (rs.next());
			}
		} catch (SQLException sqlExp) {
			BozExceptionFactory.getInstance().throwException(sqlExp, 50);
		} finally {
			try {
				if (ppStmt != null) {
					ppStmt.close();
					ppStmt = null;
				}
			} catch (SQLException sqlExp) {
				BozExceptionFactory.getInstance().throwException(sqlExp, 50);
			}
		}
		return alertBean;
	}

	public List selectEcmErrorsBeanData(Connection con,
			SuiviModuleBean suiviModuleBean, String codeLangue)
			throws BozException {
		List listEcmErrorsBean = new ArrayList();
		PreparedStatement ppStmt = null;
		try {
			ppStmt = con.prepareStatement(getQuery("SELECT_ECM_ERRORS"));
			ppStmt.setInt(1, suiviModuleBean.getNumProcess());
			ppStmt.setString(2, suiviModuleBean.getCodePays());
			ppStmt.setString(3, suiviModuleBean.getCodeMarque());
			ppStmt.setString(4, codeLangue);
			ResultSet rs = ppStmt.executeQuery();
			while (rs.next()) {
				EcmErrorsBean ecmErrorsBean = new EcmErrorsBean();
				ecmErrorsBean.setCountryCode(rs.getString("COD_PAYS"));
				ecmErrorsBean.setMarqueCode(rs.getString("COD_MARQUE"));
				ecmErrorsBean.setTransferDate(rs.getString("TRANSFER_DATE"));
				ecmErrorsBean.setWave(rs.getString("VAGUE"));
				ecmErrorsBean.setCodeTraitement(rs.getString("COD_TRAITEMENT"));
				ecmErrorsBean.setErrorDescription(rs.getString("LIB_ERREUR"));
				ecmErrorsBean.setActivityType(rs.getString("LEAD_ACTIVITE"));
				ecmErrorsBean.setDealerCode(rs.getString("COD_PDV"));
				ecmErrorsBean.setLeadId(rs.getString("LEAD_ID"));
				ecmErrorsBean.setAnswerQ1(rs.getString("Q1"));
				ecmErrorsBean.setAnswerQ2(rs.getString("Q2"));
				ecmErrorsBean.setAnswerQ3(rs.getString("Q3"));
				ecmErrorsBean.setAnswerQ3Bis(rs.getString("Q3BIS"));
				ecmErrorsBean.setAnswerQ4(rs.getString("Q4"));
				ecmErrorsBean.setAnswerQ5(rs.getString("Q5"));
				ecmErrorsBean.setAnswerQ6(rs.getString("Q6"));
				ecmErrorsBean.setAnswerQ7(rs.getString("Q7"));
				ecmErrorsBean.setAnswerQ8(rs.getString("Q8"));
				ecmErrorsBean.setAnswerQ9(rs.getString("Q9"));
				ecmErrorsBean.setAnswerQ10(rs.getString("Q10"));
				ecmErrorsBean.setAnswerQ11(rs.getString("Q11"));
				ecmErrorsBean.setAnswerQ12(rs.getString("Q12"));
				ecmErrorsBean.setAnswerQ13(rs.getString("Q13"));
				ecmErrorsBean.setAnswerQ14(rs.getString("Q14"));
				ecmErrorsBean.setAnswerQ15(rs.getString("Q15"));
				ecmErrorsBean.setAnswerQ16(rs.getString("Q16"));
				ecmErrorsBean.setAnswerQ17(rs.getString("Q17"));
				ecmErrorsBean.setAnswerQ18(rs.getString("Q18"));
				ecmErrorsBean.setAnswerQ19(rs.getString("Q19"));
				ecmErrorsBean.setAnswerQ20(rs.getString("Q20"));
				ecmErrorsBean.setAnswerQ21(rs.getString("Q21"));
				ecmErrorsBean.setAnswerQ22(rs.getString("Q22"));
				listEcmErrorsBean.add(ecmErrorsBean);
			}
		} catch (SQLException sqlExp) {
			BozExceptionFactory.getInstance().throwException(sqlExp, 50);
		} finally {
			try {
				if (ppStmt != null) {
					ppStmt.close();
					ppStmt = null;
				}
			} catch (SQLException sqlExp) {
				BozExceptionFactory.getInstance().throwException(sqlExp, 50);
			}
		}
		return listEcmErrorsBean;
	}

	public SuiviModuleBean selectSuiviModuleBeanData(Connection con,
			SuiviModuleBean suiviModuleBean, String lastDate)
			throws BozException {
		PreparedStatement ppStmt = null;
		try {
			ppStmt = con.prepareStatement(getQuery("SELECT_SMOD"));
			ppStmt.setString(1, suiviModuleBean.getCodePays());
			ppStmt.setString(2, suiviModuleBean.getCodeMarque());
			ppStmt.setString(3, lastDate);
			ResultSet rs = ppStmt.executeQuery();
			while (rs.next()) {
				suiviModuleBean.setNumProcess(rs.getInt("NUM_PROCESS"));
				suiviModuleBean
						.setNbEnrATraiter(rs.getInt("NBR_ENR_A_TRAITER"));
				suiviModuleBean.setNbEnrOk(rs.getInt("NBR_ENR_OK"));
				suiviModuleBean.setNbEnrWarning(rs.getInt("NBR_ENR_WARNING"));
				suiviModuleBean.setNbEnrRejete(rs.getInt("NBR_ENR_REJET"));

			}
		} catch (SQLException sqlExp) {
			BozExceptionFactory.getInstance().throwException(sqlExp, 50);
		} finally {
			try {
				if (ppStmt != null) {
					ppStmt.close();
					ppStmt = null;
				}
			} catch (SQLException sqlExp) {
				BozExceptionFactory.getInstance().throwException(sqlExp, 50);
			}
		}
		return suiviModuleBean;
	}

	/**
	 * Suppression de l'ensemble des enregistrements de OIOA
	 * 
	 * @param con
	 *            La connexion � la BD
	 * @throws BozException
	 *             En cas d'erreur SQL
	 * 
	 */
	public void delete(Connection con) throws BozException {
		PreparedStatement ppStmt = null;
		try {
			ppStmt = con.prepareStatement(getQuery("DELETE_OIOA"));
			ppStmt.executeUpdate();
		} catch (SQLException sqlExp) {
			BozExceptionFactory.getInstance().throwException(sqlExp, 50);
		} finally {
			try {
				if (ppStmt != null) {
					ppStmt.close();
					ppStmt = null;
				}

			} catch (SQLException sqlExp) {
				BozExceptionFactory.getInstance().throwException(sqlExp, 50);
			}
		}
	}

	public void delete_lm(Connection con) throws BozException {
		PreparedStatement ppStmt = null;
		try {
			ppStmt = con.prepareStatement(getQuery("DELETE_OECM"));
			ppStmt.executeUpdate();
		} catch (SQLException sqlExp) {
			BozExceptionFactory.getInstance().throwException(sqlExp, 50);
		} finally {
			try {
				if (ppStmt != null) {
					ppStmt.close();
					ppStmt = null;
				}

			} catch (SQLException sqlExp) {
				BozExceptionFactory.getInstance().throwException(sqlExp, 50);
			}
		}
	}

	public void delete_vm(Connection con) throws BozException {
		PreparedStatement ppStmt = null;
		try {
			ppStmt = con.prepareStatement(getQuery("DELETE_OEVM"));
			ppStmt.executeUpdate();
		} catch (SQLException sqlExp) {
			BozExceptionFactory.getInstance().throwException(sqlExp, 50);
		} finally {
			try {
				if (ppStmt != null) {
					ppStmt.close();
					ppStmt = null;
				}

			} catch (SQLException sqlExp) {
				BozExceptionFactory.getInstance().throwException(sqlExp, 50);
			}
		}
	}

	public SuiviModuleBean insertSuiviModuleBean(Connection con,
			SuiviModuleBean suiviModuleBean) throws BozException {

		PreparedStatement ppStmt = null;
		try {
			ppStmt = con.prepareStatement(getQuery("INSERT_SMOD"));
			ppStmt.setString(1, suiviModuleBean.getCodeTypeProcess());
			ppStmt.setInt(2, suiviModuleBean.getNumProcess());
			ppStmt.setString(3, suiviModuleBean.getCodeModule());
			ppStmt.setString(4, suiviModuleBean.getCodeSource());
			ppStmt.setString(5, suiviModuleBean.getCodeCible());
			ppStmt.setString(6, suiviModuleBean.getCodePays());
			ppStmt.setString(7, suiviModuleBean.getCodeMarque());
			ppStmt.setString(8, suiviModuleBean.getDateDebutModule());
			ppStmt.setString(9, suiviModuleBean.getDateFinModule());
			ppStmt.setString(10, suiviModuleBean.getLibTypeFichier());
			ppStmt.setTimestamp(11, suiviModuleBean.getDateTransfer());
			ppStmt.setInt(12, suiviModuleBean.getNumVersion());
			ppStmt.setInt(13, suiviModuleBean.getNbEnrATraiter());
			ppStmt.setInt(14, suiviModuleBean.getNbEnrOk());
			ppStmt.setInt(15, suiviModuleBean.getNbEnrWarning());
			ppStmt.setInt(16, suiviModuleBean.getNbEnrRejete());
			ppStmt.setInt(17, suiviModuleBean.getNbEnrARecycler());
			ppStmt.setInt(18, suiviModuleBean.getNbLigneSupprime());
			ppStmt.setInt(19, suiviModuleBean.getNbLigneInsere());
			ppStmt.setInt(20, suiviModuleBean.getNbLigneMaj());
			ppStmt.setInt(21, suiviModuleBean.getNumErreur());
			ppStmt.setString(22, suiviModuleBean.getLibErreur());
			ppStmt.setString(23, suiviModuleBean.getCodeEtatModule());

			ppStmt.executeUpdate();

		} catch (SQLException sqlExp) {
			BozExceptionFactory.getInstance().throwException(sqlExp, 50);
		} finally {
			try {
				if (ppStmt != null) {
					ppStmt.close();
					ppStmt = null;
				}
			} catch (SQLException sqlExp) {
				BozExceptionFactory.getInstance().throwException(sqlExp, 50);
			}
		}
		return suiviModuleBean;
	}

	public void updateCodeStatusSuiviModule(Connection con,
			SuiviModuleBean suiviModuleBean) throws BozException {

		PreparedStatement ppStmt = null;
		try {
			ppStmt = con.prepareStatement(getQuery("UPDATE_COD_MODULE"));
			ppStmt.setString(1, suiviModuleBean.getCodeTypeProcess());
			ppStmt.setString(2, suiviModuleBean.getCodePays());
			ppStmt.setString(3, suiviModuleBean.getCodeMarque());
			ppStmt.setInt(4, suiviModuleBean.getNumProcess());

			ppStmt.executeUpdate();

		} catch (SQLException sqlExp) {
			BozExceptionFactory.getInstance().throwException(sqlExp, 50);
		} finally {
			try {
				if (ppStmt != null) {
					ppStmt.close();
					ppStmt = null;
				}
			} catch (SQLException sqlExp) {
				BozExceptionFactory.getInstance().throwException(sqlExp, 50);
			}
		}
	}

	/**
	 * Renvoie le current ID ID_CLIENT
	 * 
	 * @param con
	 *            la connexion à la BD
	 * @param numProcess
	 *            Le numéro du process
	 * @throws BozException
	 *             En cas d'erreur SQL
	 * @return l'identifiant du client
	 * @throws IndexOutOfBoundsException
	 * @throws UnsupportedEncodingException
	 * 
	 */
	public SuiviModuleBean insert(Connection con,
			com.inetpsa.boz.vcm.apv.xml.v3.TECHNICAL_HEADER xmlMessage,
			String NameFile, int NumProcess) throws BozException,
			UnsupportedEncodingException, IndexOutOfBoundsException {
		PreparedStatement ppStmt = null;
		SuiviModuleBean suiviModuleBean = new SuiviModuleBean();
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		int nbEnrOk = 0;
		int nbEnrKo = 0;
		try {

			int i = 1;
			ppStmt = con.prepareStatement(getQuery("INSERT_OEVM_APV_V3"));

			int nbDealer = xmlMessage.getDEALERCount();

			for (int j = 0; j < nbDealer; j++) {
				int nbLead = xmlMessage.getDEALER(j).getQUESTIONNAIRECount();
				for (int k = 0; k < nbLead; k++) {

					i = 1;
					ppStmt.setString(i++, StringUtils.formatString(
							xmlMessage.getCOUNTRY_CODE(),
							BozConstants.LEN_COD_PAYS));
					ppStmt.setString(i++, StringUtils
							.formatString(xmlMessage.getAP_AC().toString(),
									BozConstants.LEN_COD_MARQUE));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getACTIVITY().toString(),
							BozConstants.LEN_COD_ACTIVITY));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getVISIT_ID(),
							BozConstants.LEN_VISIT_ID));
					ppStmt.setString(i++, StringUtils.formatString(
							sdf2.format(new java.util.Date()).toString(),
							BozConstants.LEN_DTH_CREA_DTM));
					ppStmt.setString(i++, StringUtils.formatString(
							xmlMessage.getPERIOD(), BozConstants.LEN_PERIOD));
					ppStmt.setString(i++, StringUtils.formatString(
							xmlMessage.getTRANSFER_DATE(),
							BozConstants.LEN_TRANSFER_DATE));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getRRDI_CODE(),
							BozConstants.LEN_DEALER_CODE));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getSITE_CODE(),
							BozConstants.LEN_SITE_CODE));
					ppStmt.setString(i++, StringUtils.formatString(
							xmlMessage.getDEALER(j).getQUESTIONNAIRE(k)
									.getVISIT_NUMBER(),
							BozConstants.LEN_VISIT_NUMBER));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getSCENARIO(),
							BozConstants.LEN_SCENARIO));

					ppStmt.setInt(i++, NumProcess);
					ppStmt.setString(i++, NameFile);

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ21(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ22(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ23(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ27(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ29(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ30(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ31(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ32(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ33(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ34(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ35(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ36(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ37(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ38(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ39(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ40(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ41(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ42(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ43(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ44(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ45(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ46(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ47(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ50(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ51(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ52(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ53(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ54(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ55(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ56(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ57(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ58(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ59(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ60(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ61(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ62(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ63(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ64(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ65(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ66(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ67(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ69(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ70(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ71(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ72(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ73(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ74(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ76(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ77(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ78(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ79(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ80(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ81(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ83(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ84(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ85(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ86(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ87(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ88(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ90(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ91(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ92(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ102(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ103(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ104(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ105(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ106(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ107(),
							BozConstants.LEN_DESCRIP));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ108(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ109(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ110(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ111(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ112(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ113(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ114(),
							BozConstants.LEN_Q_SHORT));

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQO1(),
							BozConstants.LEN_Q_LONG));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQO2(),
							BozConstants.LEN_Q_LONG));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQO3(),
							BozConstants.LEN_Q_LONG));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQO4(),
							BozConstants.LEN_Q_LONG));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQO5(),
							BozConstants.LEN_Q_LONG));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQO6(),
							BozConstants.LEN_Q_LONG));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQO7(),
							BozConstants.LEN_Q_LONG));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQO8(),
							BozConstants.LEN_Q_LONG));

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQL1(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQL2(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQL3(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQL4(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQL5(),
							BozConstants.LEN_Q_SHORT));

					try {

						ppStmt.executeUpdate();
						nbEnrOk++;
					} catch (SQLException sqlExp) {
						System.err.println(sqlExp.getMessage());
						nbEnrKo++;
						BozExceptionFactory.getInstance().throwException(
								sqlExp, 50);
					}

				}

			}

		} catch (SQLException sqlExp) {
			BozExceptionFactory.getInstance().throwException(sqlExp, 50);
		} finally {
			suiviModuleBean.setNbEnrOk(nbEnrOk);
			suiviModuleBean.setNbEnrRejete(nbEnrKo);
			try {
				if (ppStmt != null) {
					ppStmt.close();
					ppStmt = null;
				}

			} catch (SQLException sqlExp) {
				BozExceptionFactory.getInstance().throwException(sqlExp, 50);
			}
		}
		return suiviModuleBean;
	}

	public SuiviModuleBean insert(Connection con,
			com.inetpsa.boz.vcm.apv.xml.v4.TECHNICAL_HEADER xmlMessage,
			String NameFile, int NumProcess) throws BozException,
			UnsupportedEncodingException, IndexOutOfBoundsException {
		PreparedStatement ppStmt = null;
		SuiviModuleBean suiviModuleBean = new SuiviModuleBean();
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		int nbEnrOk = 0;
		int nbEnrKo = 0;
		try {

			int i = 1;
			ppStmt = con.prepareStatement(getQuery("INSERT_OEVM_APV_V4"));

			int nbDealer = xmlMessage.getDEALERCount();

			for (int j = 0; j < nbDealer; j++) {
				int nbLead = xmlMessage.getDEALER(j).getQUESTIONNAIRECount();
				for (int k = 0; k < nbLead; k++) {

					i = 1;
					ppStmt.setString(i++, StringUtils.formatString(
							xmlMessage.getCOUNTRY_CODE(),
							BozConstants.LEN_COD_PAYS));
					ppStmt.setString(i++, StringUtils
							.formatString(xmlMessage.getAP_AC().toString(),
									BozConstants.LEN_COD_MARQUE));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getACTIVITY().toString(),
							BozConstants.LEN_COD_ACTIVITY));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getVISIT_ID(),
							BozConstants.LEN_VISIT_ID));
					ppStmt.setString(i++, StringUtils.formatString(
							sdf2.format(new java.util.Date()).toString(),
							BozConstants.LEN_DTH_CREA_DTM));
					ppStmt.setString(i++, StringUtils.formatString(
							xmlMessage.getPERIOD(), BozConstants.LEN_PERIOD));
					ppStmt.setString(i++, StringUtils.formatString(
							xmlMessage.getTRANSFER_DATE(),
							BozConstants.LEN_TRANSFER_DATE));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getRRDI_CODE(),
							BozConstants.LEN_DEALER_CODE));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getSITE_CODE(),
							BozConstants.LEN_SITE_CODE));
					ppStmt.setString(i++, StringUtils.formatString(
							xmlMessage.getDEALER(j).getQUESTIONNAIRE(k)
									.getVISIT_NUMBER(),
							BozConstants.LEN_VISIT_NUMBER));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getSCENARIO(),
							BozConstants.LEN_SCENARIO));

					ppStmt.setInt(i++, NumProcess);
					ppStmt.setString(i++, NameFile);

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ1(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ2(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ3(),
							BozConstants.LEN_Q_SHORT));

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ4(),
							BozConstants.LEN_Q_SHORT));

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ5(),
							BozConstants.LEN_Q_SHORT));

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ6(),
							BozConstants.LEN_Q_SHORT));

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ7(),
							BozConstants.LEN_Q_SHORT));

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ9(),
							BozConstants.LEN_Q_SHORT));

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ10(),
							BozConstants.LEN_Q_SHORT));

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ11(),
							BozConstants.LEN_Q_SHORT));

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ12(),
							BozConstants.LEN_Q_SHORT));

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ13(),
							BozConstants.LEN_Q_SHORT));

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ14(),
							BozConstants.LEN_Q_SHORT));

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ15(),
							BozConstants.LEN_Q_SHORT));

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ16(),
							BozConstants.LEN_Q_SHORT));

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ17(),
							BozConstants.LEN_Q_SHORT));

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ18(),
							BozConstants.LEN_Q_SHORT));

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ19(),
							BozConstants.LEN_Q_SHORT));

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ20(),
							BozConstants.LEN_Q_SHORT));

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ21(),
							BozConstants.LEN_Q_SHORT));

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ22(),
							BozConstants.LEN_Q_SHORT));

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ23(),
							BozConstants.LEN_Q_SHORT));

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ24(),
							BozConstants.LEN_Q_SHORT));

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ25(),
							BozConstants.LEN_Q_SHORT));

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ26(),
							BozConstants.LEN_Q_SHORT));

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ27(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQ28(),
							BozConstants.LEN_Q_SHORT));

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQO1(),
							BozConstants.LEN_Q_LONG));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQO2(),
							BozConstants.LEN_Q_LONG));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQO3(),
							BozConstants.LEN_Q_LONG));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQO4(),
							BozConstants.LEN_Q_LONG));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQO5(),
							BozConstants.LEN_Q_LONG));

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQL1(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQL2(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQL3(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQL4(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getQUESTIONNAIRE(k).getQL5(),
							BozConstants.LEN_Q_SHORT));

					try {

						ppStmt.executeUpdate();
						nbEnrOk++;
					} catch (SQLException sqlExp) {
						System.err.println(sqlExp.getMessage());
						nbEnrKo++;
						BozExceptionFactory.getInstance().throwException(
								sqlExp, 50);
					}

				}

			}

		} catch (SQLException sqlExp) {
			BozExceptionFactory.getInstance().throwException(sqlExp, 50);
		} finally {
			suiviModuleBean.setNbEnrOk(nbEnrOk);
			suiviModuleBean.setNbEnrRejete(nbEnrKo);
			try {
				if (ppStmt != null) {
					ppStmt.close();
					ppStmt = null;
				}

			} catch (SQLException sqlExp) {
				BozExceptionFactory.getInstance().throwException(sqlExp, 50);
			}
		}
		return suiviModuleBean;
	}

	public static java.sql.Date stringToSqlDate(String date, String formato) {
		try {
			SimpleDateFormat df = new SimpleDateFormat(formato);
			java.sql.Date dateSql = new java.sql.Date(df.parse(date).getTime());
			return dateSql;
		} catch (ParseException e) {
			return null;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	public static java.sql.Timestamp stringToSqlTimestamp(String date,
			String formato) {
		try {
			SimpleDateFormat df = new SimpleDateFormat(formato);
			java.sql.Timestamp timestamp = new java.sql.Timestamp(df
					.parse(date).getTime());
			return timestamp;
		} catch (ParseException e) {
			return null;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

}
