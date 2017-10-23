/*
 * Cr�� le 24 ao�t 2007
 *
 * Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre&gt;Pr�f�rences&gt;Java&gt;G�n�ration de code&gt;Code et commentaires
 */
package com.inetpsa.boz.rpv.ecm.dao;

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
import com.inetpsa.boz.common.bean.EvmErrorsBean;
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
public class EcmDao extends BozDao {

	/** Singleton */
	private static EcmDao instance;

	/**
	 * Constructor
	 * 
	 * @param resource
	 *            nom du fichier de ressource
	 */
	private EcmDao(String resource) {
		super(resource);
	}

	/**
	 * Singleton
	 * 
	 * @return instance L'instance unique de la classe
	 */
	public static EcmDao getInstance() {
		if (instance == null)
			instance = new EcmDao("BOZRPVQUERIES");
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
				suiviModuleBean.setCodeModule(rs.getString("COD_MODULE"));
				suiviModuleBean.setCodeSubMarque(rs.getString("COD_SUBMARQUE"));
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

	public AlertBean selectAlertBeanData(Connection con, String fileName,
			SuiviModuleBean suiviModuleBean, boolean bRecursivo)
			throws BozException {
		PreparedStatement ppStmt = null;
		ResultSet rs = null;
		AlertBean alertBean = null;// = new AlertBean();
		try {
			ppStmt = con.prepareStatement(getQuery("SELECT_ALERT"));
			ppStmt.setString(1, fileName);
			rs = ppStmt.executeQuery();
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
			} else {
				String sAuxFileName;
				if (bRecursivo) {
					if (suiviModuleBean != null) {
						if (suiviModuleBean.getCodePays() != null) {
							PreparedStatement ppStmt2 = null;
							ResultSet rs2 = null;
							try {
								ppStmt2 = con
										.prepareStatement(getQuery("SELECT_NOM_FICHIER"));
								if (fileName.contains("bopfir")) {
									ppStmt2.setString(1, "bopfir%");
								} else {
									if (fileName.contains("_APV_")) {
										ppStmt2.setString(1, "VM%APV%");
									} else {
										ppStmt2.setString(1, "VM%VN%");
									}
								}
								ppStmt2.setString(2,
										suiviModuleBean.getCodePays());
								ppStmt2.setString(3,
										suiviModuleBean.getCodeSubMarque());
								// ppStmt2.setString(1, fileName);
								rs2 = ppStmt2.executeQuery();
								if (rs2.next()) {
									sAuxFileName = rs2
											.getString("COD_NOM_FICHIER");
									alertBean = selectAlertBeanData(con,
											sAuxFileName, suiviModuleBean,
											false);
								} else {
									// hacemos nuevamente llamada recursiva pero
									// con null en el tercer parametro para que
									// busque en la proxima ejecución por nombre
									// de fichero
									alertBean = selectAlertBeanData(con,
											fileName, null, true);
								}
							} catch (SQLException sqlExp2) {
								BozExceptionFactory.getInstance()
										.throwException(sqlExp2, 50);
							} finally {
								try {
									if (rs2 != null) {
										rs2.close();
										rs2 = null;
									}
									if (ppStmt2 != null) {
										ppStmt2.close();
										ppStmt2 = null;
									}
								} catch (SQLException sqlExp3) {
									BozExceptionFactory.getInstance()
											.throwException(sqlExp3, 50);
								}
							}
						} else {
							// hacemos nuevamente llamada recursiva pero
							// con null en el tercer parametro para que
							// busque en la proxima ejecución por nombre
							// de fichero
							alertBean = selectAlertBeanData(con, fileName,
									null, true);
						}
					} else {
						if (fileName.substring(0, 6).equals("bopfir")) {
							if (fileName.contains(".001")
									&& fileName.length() > 12) {
								sAuxFileName = fileName.substring(0, 8)
										+ ".001";
								alertBean = selectAlertBeanData(con,
										sAuxFileName, suiviModuleBean, false);
							} else {
								if (fileName.contains(".002")
										&& fileName.length() > 12) {
									sAuxFileName = fileName.substring(0, 8)
											+ ".002";
									alertBean = selectAlertBeanData(con,
											sAuxFileName, suiviModuleBean,
											false);
								} else {
									if (fileName.length() > 8) {
										sAuxFileName = fileName.substring(0, 8);
										alertBean = selectAlertBeanData(con,
												sAuxFileName, suiviModuleBean,
												false);
									}
								}
							}
						}
					}
				}
			}

		} catch (SQLException sqlExp) {
			BozExceptionFactory.getInstance().throwException(sqlExp, 50);
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
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
			ppStmt.setString(3, suiviModuleBean.getCodeSubMarque());
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
				ecmErrorsBean.setAnswerQ23(rs.getString("Q23"));
				ecmErrorsBean.setAnswerQ24(rs.getString("Q24"));
				ecmErrorsBean.setAnswerQ25(rs.getString("Q25"));
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

	public List selectEvmErrorsBeanData(Connection con,
			SuiviModuleBean suiviModuleBean, String codeLangue,
			com.inetpsa.boz.rpv.xml.types.ActivityPSAType activityPSA)
			throws BozException {
		List listEvmErrorsBean = new ArrayList();
		PreparedStatement ppStmt = null;
		try {
			ppStmt = con.prepareStatement(getQuery("SELECT_EVM_ERRORS"));
			ppStmt.setInt(1, suiviModuleBean.getNumProcess());
			ppStmt.setString(2, suiviModuleBean.getCodePays());
			ppStmt.setString(3, suiviModuleBean.getCodeSubMarque());
			ppStmt.setString(4, codeLangue);
			ppStmt.setString(5, activityPSA.toString());
			ResultSet rs = ppStmt.executeQuery();
			while (rs.next()) {
				EvmErrorsBean evmErrorsBean = new EvmErrorsBean();
				evmErrorsBean.setCountryCode(rs.getString("COD_PAYS"));
				evmErrorsBean.setMarqueCode(rs.getString("COD_MARQUE"));
				evmErrorsBean.setTransferDate(rs.getString("TRANSFER_DATE"));
				evmErrorsBean.setWave(rs.getString("VAGUE"));
				evmErrorsBean.setCodeTraitement(rs.getString("COD_TRAITEMENT"));
				evmErrorsBean.setErrorDescription(rs.getString("LIB_ERREUR"));
				evmErrorsBean.setActivityType(rs.getString("ACTIVITE_VM"));
				evmErrorsBean.setCodPDV(rs.getString("COD_PDV"));
				evmErrorsBean.setCodSite(rs.getString("COD_SITE"));
				evmErrorsBean.setScenario(rs.getString("SCENARIO"));
				evmErrorsBean.setVisitId(rs.getString("ID_VISITE"));
				evmErrorsBean.setVisitNum(rs.getString("NUM_VISITE"));
				evmErrorsBean.setAnswerQ1(rs.getString("Q1"));
				evmErrorsBean.setAnswerQ2(rs.getString("Q2"));
				evmErrorsBean.setAnswerQ3(rs.getString("Q3"));
				evmErrorsBean.setAnswerQ4(rs.getString("Q4"));
				evmErrorsBean.setAnswerQ5(rs.getString("Q5"));
				evmErrorsBean.setAnswerQ6(rs.getString("Q6"));
				evmErrorsBean.setAnswerQ7(rs.getString("Q7"));
				evmErrorsBean.setAnswerQ8(rs.getString("Q8"));
				evmErrorsBean.setAnswerQ9(rs.getString("Q9"));
				evmErrorsBean.setAnswerQ10(rs.getString("Q10"));
				evmErrorsBean.setAnswerQ11(rs.getString("Q11"));
				evmErrorsBean.setAnswerQ11Bis(rs.getString("Q11BIS"));
				evmErrorsBean.setAnswerQ12(rs.getString("Q12"));
				evmErrorsBean.setAnswerQ13(rs.getString("Q13"));
				evmErrorsBean.setAnswerQ14(rs.getString("Q14"));
				evmErrorsBean.setAnswerQ15(rs.getString("Q15"));
				evmErrorsBean.setAnswerQ16(rs.getString("Q16"));
				evmErrorsBean.setAnswerQ17(rs.getString("Q17"));
				evmErrorsBean.setAnswerQ18(rs.getString("Q18"));
				evmErrorsBean.setAnswerQ19(rs.getString("Q19"));
				evmErrorsBean.setAnswerQ20(rs.getString("Q20"));
				evmErrorsBean.setAnswerQ21(rs.getString("Q21"));
				evmErrorsBean.setAnswerQ22(rs.getString("Q22"));
				evmErrorsBean.setAnswerQ23(rs.getString("Q23"));
				evmErrorsBean.setAnswerQ24(rs.getString("Q24"));
				evmErrorsBean.setAnswerQ25(rs.getString("Q25"));
				evmErrorsBean.setAnswerQ26(rs.getString("Q26"));
				evmErrorsBean.setAnswerQ27(rs.getString("Q27"));
				evmErrorsBean.setAnswerQ28(rs.getString("Q28"));
				evmErrorsBean.setAnswerQ29(rs.getString("Q29"));
				evmErrorsBean.setAnswerQ30(rs.getString("Q30"));
				evmErrorsBean.setAnswerQ31(rs.getString("Q31"));
				evmErrorsBean.setAnswerQ32(rs.getString("Q32"));
				evmErrorsBean.setAnswerQ33(rs.getString("Q33"));
				evmErrorsBean.setAnswerQ34(rs.getString("Q34"));
				evmErrorsBean.setAnswerQ35(rs.getString("Q35"));
				evmErrorsBean.setAnswerQ36(rs.getString("Q36"));
				evmErrorsBean.setAnswerQ37(rs.getString("Q37"));
				evmErrorsBean.setAnswerQ38(rs.getString("Q38"));
				evmErrorsBean.setAnswerQ39(rs.getString("Q39"));
				evmErrorsBean.setAnswerQ40(rs.getString("Q40"));
				evmErrorsBean.setAnswerQ41(rs.getString("Q41"));
				evmErrorsBean.setAnswerQ42(rs.getString("Q42"));
				evmErrorsBean.setAnswerQ43(rs.getString("Q43"));
				evmErrorsBean.setAnswerQ44(rs.getString("Q44"));
				evmErrorsBean.setAnswerQ45(rs.getString("Q45"));
				evmErrorsBean.setAnswerQ46(rs.getString("Q46"));
				evmErrorsBean.setAnswerQ47(rs.getString("Q47"));
				evmErrorsBean.setAnswerQ48(rs.getString("Q48"));
				evmErrorsBean.setAnswerQ49(rs.getString("Q49"));
				evmErrorsBean.setAnswerQ50(rs.getString("Q50"));
				evmErrorsBean.setAnswerQ51(rs.getString("Q51"));
				evmErrorsBean.setAnswerQ52(rs.getString("Q52"));
				evmErrorsBean.setAnswerQ53(rs.getString("Q53"));
				evmErrorsBean.setAnswerQ54(rs.getString("Q54"));
				evmErrorsBean.setAnswerQ55(rs.getString("Q55"));
				evmErrorsBean.setAnswerQ56(rs.getString("Q56"));
				evmErrorsBean.setAnswerQ57(rs.getString("Q57"));
				evmErrorsBean.setAnswerQ58(rs.getString("Q58"));
				evmErrorsBean.setAnswerQ59(rs.getString("Q59"));
				evmErrorsBean.setAnswerQ60(rs.getString("Q60"));
				evmErrorsBean.setAnswerQ61(rs.getString("Q61"));
				evmErrorsBean.setAnswerQ62(rs.getString("Q62"));
				evmErrorsBean.setAnswerQ63(rs.getString("Q63"));
				evmErrorsBean.setAnswerQ64(rs.getString("Q64"));
				evmErrorsBean.setAnswerQ65(rs.getString("Q65"));
				evmErrorsBean.setAnswerQ66(rs.getString("Q66"));
				evmErrorsBean.setAnswerQ67(rs.getString("Q67"));
				evmErrorsBean.setAnswerQ68(rs.getString("Q68"));
				evmErrorsBean.setAnswerQ69(rs.getString("Q69"));
				evmErrorsBean.setAnswerQ70(rs.getString("Q70"));
				evmErrorsBean.setAnswerQ71(rs.getString("Q71"));
				evmErrorsBean.setAnswerQ72(rs.getString("Q72"));
				evmErrorsBean.setAnswerQ73(rs.getString("Q73"));
				evmErrorsBean.setAnswerQ74(rs.getString("Q74"));
				evmErrorsBean.setAnswerQ75(rs.getString("Q75"));
				evmErrorsBean.setAnswerQ76(rs.getString("Q76"));
				evmErrorsBean.setAnswerQ77(rs.getString("Q77"));
				evmErrorsBean.setAnswerQ78(rs.getString("Q78"));
				evmErrorsBean.setAnswerQ79(rs.getString("Q79"));
				evmErrorsBean.setAnswerQ80(rs.getString("Q80"));
				evmErrorsBean.setAnswerQ81(rs.getString("Q81"));
				evmErrorsBean.setAnswerQ82(rs.getString("Q82"));
				evmErrorsBean.setAnswerQ83(rs.getString("Q83"));
				evmErrorsBean.setAnswerQ84(rs.getString("Q84"));
				evmErrorsBean.setAnswerQ85(rs.getString("Q85"));
				evmErrorsBean.setAnswerQ86(rs.getString("Q86"));
				evmErrorsBean.setAnswerQ87(rs.getString("Q87"));
				evmErrorsBean.setAnswerQ88(rs.getString("Q88"));
				evmErrorsBean.setAnswerQ89(rs.getString("Q89"));
				evmErrorsBean.setAnswerQ90(rs.getString("Q90"));
				evmErrorsBean.setAnswerQ91(rs.getString("Q91"));
				evmErrorsBean.setAnswerQ92(rs.getString("Q92"));
				evmErrorsBean.setAnswerQ93(rs.getString("Q93"));
				evmErrorsBean.setAnswerQ94(rs.getString("Q94"));
				evmErrorsBean.setAnswerQ102(rs.getString("Q102"));
				evmErrorsBean.setAnswerQ103(rs.getString("Q103"));
				evmErrorsBean.setAnswerQ104(rs.getString("Q104"));
				evmErrorsBean.setAnswerQ105(rs.getString("Q105"));
				evmErrorsBean.setAnswerQ106(rs.getString("Q106"));
				evmErrorsBean.setAnswerQ107(rs.getString("Q107"));
				evmErrorsBean.setAnswerQ108(rs.getString("Q108"));
				evmErrorsBean.setAnswerQ109(rs.getString("Q109"));
				evmErrorsBean.setAnswerQ110(rs.getString("Q110"));
				evmErrorsBean.setAnswerQ111(rs.getString("Q111"));
				evmErrorsBean.setAnswerQ112(rs.getString("Q112"));
				evmErrorsBean.setAnswerQ113(rs.getString("Q113"));
				evmErrorsBean.setAnswerQ114(rs.getString("Q114"));
				evmErrorsBean.setAnswerQO1(rs.getString("QO1"));
				evmErrorsBean.setAnswerQO2(rs.getString("QO2"));
				evmErrorsBean.setAnswerQO3(rs.getString("QO3"));
				evmErrorsBean.setAnswerQO4(rs.getString("QO4"));
				evmErrorsBean.setAnswerQO5(rs.getString("QO5"));
				evmErrorsBean.setAnswerQO6(rs.getString("QO6"));
				evmErrorsBean.setAnswerQO7(rs.getString("QO7"));
				evmErrorsBean.setAnswerQO8(rs.getString("QO8"));
				evmErrorsBean.setAnswerQL1(rs.getString("QL1"));
				evmErrorsBean.setAnswerQL2(rs.getString("QL2"));
				evmErrorsBean.setAnswerQL3(rs.getString("QL3"));
				evmErrorsBean.setAnswerQL4(rs.getString("QL4"));
				evmErrorsBean.setAnswerQL5(rs.getString("QL5"));
				listEvmErrorsBean.add(evmErrorsBean);
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
		return listEvmErrorsBean;
	}

	public SuiviModuleBean selectSuiviModuleBeanData(Connection con,
			SuiviModuleBean suiviModuleBean, String lastDate)
			throws BozException {
		PreparedStatement ppStmt = null;
		try {
			ppStmt = con.prepareStatement(getQuery("SELECT_SMOD"));
			if (suiviModuleBean.getCodeModule().equals("ALERT_ECM")) {
				ppStmt.setString(1, "ALIM_ECM");
				ppStmt.setString(2, "Scan_TOECM");
			}
			if (suiviModuleBean.getCodeModule().equals("ALERT_EVM_APV")) {
				ppStmt.setString(1, "ALIM_EVM");
				ppStmt.setString(2, "Scan_TOEVM-APV");
			}
			if (suiviModuleBean.getCodeModule().equals("ALERT_EVM_VN")) {
				ppStmt.setString(1, "ALIM_EVM");
				ppStmt.setString(2, "Scan_TOEVM-VN");
			}

			ppStmt.setString(3, suiviModuleBean.getCodePays());
			ppStmt.setString(4, suiviModuleBean.getCodeSubMarque());
			ppStmt.setString(5, lastDate);
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
			// int i = 0;
			// i++;
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
			ppStmt.setString(24, suiviModuleBean.getCodeSubMarque());

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
	public SuiviModuleBean insert2016(Connection con,
			com.inetpsa.boz.rpv.ecm.xml.f2016.TECHNICAL_HEADER xmlMessage,
			String NameFile, int NumProcess) throws BozException,
			UnsupportedEncodingException, IndexOutOfBoundsException {
		PreparedStatement ppStmt = null;
		SuiviModuleBean suiviModuleBean = new SuiviModuleBean();
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		int nbEnrOk = 0;
		int nbEnrKo = 0;
		try {
			int i = 1;
			ppStmt = con.prepareStatement(getQuery("INSERT_OECM"));

			int nbDealer = xmlMessage.getDEALERCount();

			for (int j = 0; j < nbDealer; j++) {
				int nbLead = xmlMessage.getDEALER(j).getLEADCount();
				for (int k = 0; k < nbLead; k++) {

					i = 1;
					ppStmt.setString(i++, StringUtils.formatString(
							xmlMessage.getCOUNTRY_CODE(),
							BozConstants.LEN_COD_PAYS));
					ppStmt.setString(i++, StringUtils
							.formatString(xmlMessage.getAP_AC().toString(),
									BozConstants.LEN_COD_MARQUE));
					ppStmt.setString(i++, StringUtils.formatString(
							xmlMessage.getPERIOD(), BozConstants.LEN_PERIOD));
					ppStmt.setString(i++, StringUtils.formatString(
							xmlMessage.getTRANSFER_DATE(),
							BozConstants.LEN_TRANSFER_DATE));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getDEALER_CODE(),
							BozConstants.LEN_DEALER_CODE));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getLEAD_ID(),
							BozConstants.LEN_LEAD_ID));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getLEAD_ACTIVITY(),
							BozConstants.LEN_LEAD_ACTIVITY));

					ppStmt.setString(i++, StringUtils.formatString(
							sdf2.format(new java.util.Date()).toString(),
							BozConstants.LEN_DTH_CREA_DTM));

					ppStmt.setInt(i++, NumProcess);
					ppStmt.setString(i++, NameFile);
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ1(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ2(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ3(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ3Bis(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ4(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ5(),
							BozConstants.LEN_Q_DATE));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ6(),
							BozConstants.LEN_Q_TIME));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ7(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ8(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ9(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ10(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ11(),
							BozConstants.LEN_Q_LONG));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ12(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ13(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ14(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ15(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ16(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ17(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ18(),
							BozConstants.LEN_Q_LONG));

					final byte[] utf8q19Bytes = xmlMessage.getDEALER(j)
							.getLEAD(k).getQ19().getBytes("UTF-8");

					if (utf8q19Bytes.length > 10)
						ppStmt.setString(i++, StringUtils.formatString(null,
								BozConstants.LEN_Q_SHORT));
					else
						ppStmt.setString(i++, StringUtils.formatString(
								xmlMessage.getDEALER(j).getLEAD(k).getQ19(),
								BozConstants.LEN_Q_SHORT));

					final byte[] utf8q20Bytes = xmlMessage.getDEALER(j)
							.getLEAD(k).getQ20().getBytes("UTF-8");
					if (utf8q20Bytes.length > 10)
						ppStmt.setString(i++, StringUtils.formatString(null,
								BozConstants.LEN_Q_SHORT));
					else
						ppStmt.setString(i++, StringUtils.formatString(
								xmlMessage.getDEALER(j).getLEAD(k).getQ20(),
								BozConstants.LEN_Q_SHORT));

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ21(),
							BozConstants.LEN_Q_LONG));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ22(),
							BozConstants.LEN_Q_LONG));

					ppStmt.setString(i++, ""); // Q23
					ppStmt.setString(i++, ""); // Q24
					ppStmt.setString(i++, ""); // Q25

					try {

						ppStmt.executeUpdate();
						nbEnrOk++;
					} catch (SQLException sqlExp) {
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

	public SuiviModuleBean insert2017(Connection con,
			com.inetpsa.boz.rpv.ecm.xml.f2017.TECHNICAL_HEADER xmlMessage,
			String NameFile, int NumProcess) throws BozException,
			UnsupportedEncodingException, IndexOutOfBoundsException {
		PreparedStatement ppStmt = null;
		SuiviModuleBean suiviModuleBean = new SuiviModuleBean();
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		int nbEnrOk = 0;
		int nbEnrKo = 0;
		try {
			int i = 1;
			ppStmt = con.prepareStatement(getQuery("INSERT_OECM"));

			int nbDealer = xmlMessage.getDEALERCount();

			for (int j = 0; j < nbDealer; j++) {
				int nbLead = xmlMessage.getDEALER(j).getLEADCount();
				for (int k = 0; k < nbLead; k++) {

					i = 1;
					ppStmt.setString(i++, StringUtils.formatString(
							xmlMessage.getCOUNTRY_CODE(),
							BozConstants.LEN_COD_PAYS));
					ppStmt.setString(i++, StringUtils
							.formatString(xmlMessage.getAP_AC().toString(),
									BozConstants.LEN_COD_MARQUE));
					ppStmt.setString(i++, StringUtils.formatString(
							xmlMessage.getPERIOD(), BozConstants.LEN_PERIOD));
					ppStmt.setString(i++, StringUtils.formatString(
							xmlMessage.getTRANSFER_DATE(),
							BozConstants.LEN_TRANSFER_DATE));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getDEALER_CODE(),
							BozConstants.LEN_DEALER_CODE));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getLEAD_ID(),
							BozConstants.LEN_LEAD_ID));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getLEAD_ACTIVITY(),
							BozConstants.LEN_LEAD_ACTIVITY));

					ppStmt.setString(i++, StringUtils.formatString(
							sdf2.format(new java.util.Date()).toString(),
							BozConstants.LEN_DTH_CREA_DTM));

					ppStmt.setInt(i++, NumProcess);
					ppStmt.setString(i++, NameFile);
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ1(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ2(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, ""); // Q3
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ3(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, ""); // Q4
					ppStmt.setString(i++, ""); // Q5
					ppStmt.setString(i++, ""); // Q6
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ7(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ8(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ9(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ10(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ11(),
							BozConstants.LEN_Q_LONG));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ12(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ13(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ14(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ15(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ16(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ17(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ18(),
							BozConstants.LEN_Q_LONG));

					final byte[] utf8q19Bytes = xmlMessage.getDEALER(j)
							.getLEAD(k).getQ19().getBytes("UTF-8");

					if (utf8q19Bytes.length > 10)
						ppStmt.setString(i++, StringUtils.formatString(null,
								BozConstants.LEN_Q_SHORT));
					else
						ppStmt.setString(i++, StringUtils.formatString(
								xmlMessage.getDEALER(j).getLEAD(k).getQ19(),
								BozConstants.LEN_Q_SHORT));

					final byte[] utf8q20Bytes = xmlMessage.getDEALER(j)
							.getLEAD(k).getQ20().getBytes("UTF-8");
					if (utf8q20Bytes.length > 10)
						ppStmt.setString(i++, StringUtils.formatString(null,
								BozConstants.LEN_Q_SHORT));
					else
						ppStmt.setString(i++, StringUtils.formatString(
								xmlMessage.getDEALER(j).getLEAD(k).getQ20(),
								BozConstants.LEN_Q_SHORT));

					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ21(),
							BozConstants.LEN_Q_LONG));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ22(),
							BozConstants.LEN_Q_LONG));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ23(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ24(),
							BozConstants.LEN_Q_SHORT));
					ppStmt.setString(i++, StringUtils.formatString(xmlMessage
							.getDEALER(j).getLEAD(k).getQ25(),
							BozConstants.LEN_Q_SHORT));

					try {

						ppStmt.executeUpdate();
						nbEnrOk++;
					} catch (SQLException sqlExp) {
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
