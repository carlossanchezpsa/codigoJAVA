/*
 * Cr�� le 24 ao�t 2007
 *
 * Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre&gt;Pr�f�rences&gt;Java&gt;G�n�ration de code&gt;Code et commentaires
 */
package com.inetpsa.boz.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.inetpsa.boz.common.bean.SuiviModuleBean;
import com.inetpsa.boz.common.bean.SuiviProcessBean;
import com.inetpsa.boz.common.constant.BozConstants;
import com.inetpsa.boz.common.exception.BozException;
import com.inetpsa.boz.common.exception.BozExceptionFactory;
import com.inetpsa.boz.common.utils.StringUtils;
import com.inetpsa.boz.rpv.xml.types.MarquePSAType;

/**
 * @author e210954
 */
public class RpvDao extends BozDao {

	/** Singleton */
	private static RpvDao instance;

	/**
	 * Constructor
	 * 
	 * @param resource
	 *            nom du fichier de ressource
	 */
	private RpvDao(String resource) {
		super(resource);
	}

	/**
	 * Singleton
	 * 
	 * @return instance L'instance unique de la classe
	 */
	public static RpvDao getInstance() {
		if (instance == null)
			instance = new RpvDao("BOZRPVQUERIES");
		return instance;
	}

	/**
	 * Renvoie le num�ro de process
	 * 
	 * @param con
	 *            La connexion � la BD
	 * @throws BGCException
	 *             En cas d'erreur SQL
	 * @return Le num�ro du process
	 */
	public int getNumProcess(Connection con) throws BozException {
		int numProcess = 0;

		PreparedStatement ppStmt = null;
		// SuiviModuleBean suiviModuleBean = new SuiviModuleBean();
		ResultSet rs = null;
		try {

			ppStmt = con.prepareStatement(getQuery("SELECT_NUM_PROCESS"));
			rs = ppStmt.executeQuery();
			if (rs != null && rs.next())
				numProcess = rs.getInt(1);

		} catch (SQLException sqlExp) {
			BozExceptionFactory.getInstance().throwException(sqlExp, 50);
		} finally {
			try {
				if (ppStmt != null) {
					ppStmt.close();
					ppStmt = null;
				}
				if (rs != null) {
					rs.close();
					rs = null;
				}

			} catch (SQLException sqlExp) {
				BozExceptionFactory.getInstance().throwException(sqlExp, 50);
			}
		}

		return numProcess;
	}

	/**
	 * Renvoie le num�ro de process
	 * 
	 * @param con
	 *            La connexion � la BD
	 * @throws BGCException
	 *             En cas d'erreur SQL
	 * @return Le num�ro du process
	 */
	public String ValidateCountry(Connection con, String p_CodePays)
			throws BozException {
		String CodePays = null;

		PreparedStatement ppStmt = null;
		ResultSet rs = null;
		try {

			ppStmt = con.prepareStatement(getQuery("SELECT_COUNTRY"));
			ppStmt.setString(1, p_CodePays);
			rs = ppStmt.executeQuery();
			if (rs != null && rs.next())
				CodePays = rs.getString(1);

		} catch (SQLException sqlExp) {
			BozExceptionFactory.getInstance().throwException(sqlExp, 50);
		} finally {
			try {
				if (ppStmt != null) {
					ppStmt.close();
					ppStmt = null;
				}
				if (rs != null) {
					rs.close();
					rs = null;
				}

			} catch (SQLException sqlExp) {
				BozExceptionFactory.getInstance().throwException(sqlExp, 50);
			}
		}

		return CodePays;
	}

	/**
	 * Cr�ation du suivi du process
	 * 
	 * @param con
	 *            La connexion � la BD
	 * @param report
	 *            Le bean du rapport
	 * @throws BozException
	 *             En cas d'erreur SQL
	 * 
	 */
	public void insertSuiviProcess(Connection con, SuiviProcessBean report)
			throws BozException {

		PreparedStatement ppStmt = null;

		try {
			String query = getQuery("INSERT_SPRO");
			query = query.replaceFirst("@@@", report.getDateDebut());
			query = query.replaceFirst("@@@", report.getDateFin());
			ppStmt = con.prepareStatement(query);
			int i = 1;
			ppStmt.setString(i++, report.getCodeTypeProcess());
			ppStmt.setInt(i++, report.getNumProcess());
			ppStmt.setInt(i++, report.getNbFichierATraiter());
			ppStmt.setInt(i++, report.getNbFichierRejet());
			ppStmt.setInt(i++, report.getNbFichierOk());
			ppStmt.setInt(i++, report.getNumErreur());
			ppStmt.setString(i++, report.getLibErreur());
			ppStmt.setString(i++, report.getCodeEtatProcess());

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
	 * Insertion du suivi d'un module
	 * 
	 * @param con
	 *            La connexion � la BD
	 * @param suiviModule
	 *            L'objet qui repr�sente du module
	 * @throws BozException
	 *             En cas d'erreur
	 */
	public void insertSuiviModule(Connection con, SuiviModuleBean suiviModule)
			throws BozException {

		PreparedStatement ppStmt = null;

		try {

			int i = 1;

			ppStmt = con.prepareStatement(getQuery("INSERT_SMOD"));
			/*
			 * ppStmt = con.prepareStatement(getQuery("INSERT_SMOD2"));
			 * System.out.println("getNumProcess:" +
			 * suiviModule.getNumProcess()); ppStmt.setInt(i++,
			 * suiviModule.getNumProcess());
			 * System.out.println("getDateTransfer:" +
			 * suiviModule.getDateTransfer()); ppStmt.setDate(i++,
			 * suiviModule.getDateTransfer());
			 */
			ppStmt.setString(i++, StringUtils.formatString(
					suiviModule.getCodeTypeProcess(),
					BozConstants.LEN_COD_TYPE_PROCESS));
			ppStmt.setInt(i++, suiviModule.getNumProcess());
			ppStmt.setString(i++, StringUtils.formatString(
					suiviModule.getCodeModule(), BozConstants.LEN_COD_MODULE));
			ppStmt.setString(i++, StringUtils.formatString(
					suiviModule.getCodeSource(), BozConstants.LEN_COD_SOURCE));
			ppStmt.setString(i++, StringUtils.formatString(
					suiviModule.getCodeCible(), BozConstants.LEN_COD_CIBLE));
			ppStmt.setString(i++, StringUtils.formatString(
					suiviModule.getCodePays(), BozConstants.LEN_COD_PAYS));
			// ppStmt.setString(i++,
			// StringUtils.formatString(suiviModule.getCodeMarque(),
			// BozConstants.LEN_COD_MARQUE));
			// Si la marca del fichero es 'DS', guardamos como marca principal
			// 'AC' y en submarca guardaremos 'DS'
			if (suiviModule.getCodeMarque() == null) {
				ppStmt.setString(i++, StringUtils.formatString(
						suiviModule.getCodeMarque(), BozConstants.LEN_COD_PAYS));
			} else {
				ppStmt.setString(i++, StringUtils.formatString(
						suiviModule.getCodeMarque().equals(
								MarquePSAType.DS.toString()) ? MarquePSAType.AC
								.toString() : suiviModule.getCodeMarque(),
						BozConstants.LEN_COD_MARQUE));
			}
			ppStmt.setString(i++, suiviModule.getDateDebutModule());
			ppStmt.setString(i++, suiviModule.getDateFinModule());
			// System.out.println("getDateFinModule:" +
			// suiviModule.getDateFinModule());
			ppStmt.setString(i++, StringUtils.formatString(
					suiviModule.getLibTypeFichier(),
					BozConstants.LEN_LIB_TYP_FICHIER));
			// System.out.println("getDateFinModule:" +
			// suiviModule.getDateTransfer());
			ppStmt.setTimestamp(i++, suiviModule.getDateTransfer());
			ppStmt.setInt(i++, suiviModule.getNumVersion());
			ppStmt.setInt(i++, suiviModule.getNbEnrATraiter());
			ppStmt.setInt(i++, suiviModule.getNbEnrOk());
			ppStmt.setInt(i++, suiviModule.getNbEnrWarning());
			ppStmt.setInt(i++, suiviModule.getNbEnrRejete());
			ppStmt.setInt(i++, suiviModule.getNbEnrARecycler());
			ppStmt.setInt(i++, suiviModule.getNbLigneSupprime());
			ppStmt.setInt(i++, suiviModule.getNbLigneInsere());
			ppStmt.setInt(i++, suiviModule.getNbLigneMaj());
			ppStmt.setInt(i++, suiviModule.getNumErreur());
			ppStmt.setString(i++,
					StringUtils.formatString(suiviModule.getLibErreur(), 4000));
			ppStmt.setString(i++, StringUtils.formatString(
					suiviModule.getCodeEtatModule(), 2));
			// Guardamos la submarca
			ppStmt.setString(i++, StringUtils.formatString(
					suiviModule.getCodeMarque(), BozConstants.LEN_COD_MARQUE));
			ppStmt.executeUpdate();

		} catch (Exception sqlExp) {
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
	 * Insertion des flags � Y
	 * 
	 * @param con
	 *            La connexion � la BD
	 * @param tableName
	 *            Le nom de la table de traitement
	 */
	public void insertFlagFin(Connection con, String tableName)
			throws BozException {

		PreparedStatement ppStmt = null;

		try {

			ppStmt = con.prepareStatement(getQuery("UPDATE_STABY"));
			ppStmt.setString(1, tableName);
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
	 * Insertion des flags � Y
	 * 
	 * @param con
	 *            La connexion � la BD
	 * @param tableName
	 *            Le nom de la table de traitement
	 */
	public void insertFlagIni(Connection con, String tableName)
			throws BozException {

		PreparedStatement ppStmt = null;

		try {

			ppStmt = con.prepareStatement(getQuery("UPDATE_STABN"));
			ppStmt.setString(1, tableName);
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
	 * Insertion des flags � Y
	 * 
	 * @param con
	 *            La connexion � la BD
	 * @throws BozException
	 *             En cas d'erreur SQL
	 */
	public void insertFlagDebut(Connection con) throws BozException {

		PreparedStatement ppStmt = null;

		try {

			ppStmt = con.prepareStatement(getQuery("UPDATE_RIOA"));
			ppStmt.executeUpdate();

			ppStmt = con.prepareStatement(getQuery("UPDATE_XIOA"));
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

}
