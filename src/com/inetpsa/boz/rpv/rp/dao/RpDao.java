/*
 * Cr�� le 24 ao�t 2007
 *
 * Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre&gt;Pr�f�rences&gt;Java&gt;G�n�ration de code&gt;Code et commentaires
 */
package com.inetpsa.boz.rpv.rp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.inetpsa.boz.common.bean.SuiviModuleBean;
import com.inetpsa.boz.common.constant.BozConstants;
import com.inetpsa.boz.common.dao.BozDao;
import com.inetpsa.boz.common.exception.BozException;
import com.inetpsa.boz.common.exception.BozExceptionFactory;
import com.inetpsa.boz.common.utils.StringUtils;
import com.inetpsa.boz.rpv.rp.xml.TECHNICAL_HEADER;

/**
 * @author e210954
 */
public class RpDao extends BozDao {

	/** Singleton */
	private static RpDao instance;

	/**
	 * Constructor
	 * 
	 * @param resource
	 *            nom du fichier de ressource
	 */
	private RpDao(String resource) {
		super(resource);
	}

	/**
	 * Singleton
	 * 
	 * @return instance L'instance unique de la classe
	 */
	public static RpDao getInstance() {
		if (instance == null)
			instance = new RpDao("BOZRPVQUERIES");
		return instance;
	}

	/**
	 * Insertion du point de vente dans la base reporting
	 * 
	 * @param con
	 *            la connexion � la BD
	 * @param numProcess
	 *            Le num�ro du process
	 * @throws BozException
	 *             En cas d'erreur SQL
	 * @return l'identifiant du client
	 * 
	 */
	public SuiviModuleBean insert(Connection con, TECHNICAL_HEADER xmlMessage,
			String fileName, int numProcess) throws BozException {
		PreparedStatement ppStmt = null;
		SuiviModuleBean suiviModuleBean = new SuiviModuleBean();
		int nbEnrOk = 0;
		int nbEnrKo = 0;

		try {

			ppStmt = con.prepareStatement(getQuery("INSERT_ORPR"));
			int l = 1;
			int nbAct = xmlMessage.getACTIVITYCount();

			for (int i = 0; i < nbAct; i++) {

				int nbSubsidiary = xmlMessage.getACTIVITY(i)
						.getSUBSIDIARYCount();

				for (int j = 0; j < nbSubsidiary; j++) {

					int nbDealer = xmlMessage.getACTIVITY(i).getSUBSIDIARY(j)
							.getDEALERCount();

					for (int k = 0; k < nbDealer; k++) {

						l = 1;
						ppStmt.setString(l++, StringUtils.formatString(
								xmlMessage.getACTIVITY(i).getSUBSIDIARY(j)
										.getCOUNTRY_CODE(),
								BozConstants.LEN_COD_PAYS));
						/*
						 * ppStmt.setString(l++,
						 * StringUtils.formatString(xmlMessage
						 * .getACTIVITY(i).getSUBSIDIARY
						 * (j).getAP_AC().toString(),
						 * BozConstants.LEN_COD_MARQUE));
						 */
						ppStmt.setString(l++, StringUtils.formatString(
								xmlMessage.getACTIVITY(i).getSUBSIDIARY(j)
										.getAP_AC(),
								BozConstants.LEN_COD_MARQUE));
						ppStmt.setString(
								l++,
								StringUtils.formatString(xmlMessage
										.getACTIVITY(i).getSUBSIDIARY(j)
										.getDEALER(k).getDEALER_CODE(), 15));
						ppStmt.setString(l++, StringUtils
								.formatString(xmlMessage.getACTIVITY(i)
										.getACTIVITY_CODE(), 3));
						ppStmt.setString(
								l++,
								StringUtils.formatString(xmlMessage
										.getACTIVITY(i).getSUBSIDIARY(j)
										.getDEALER(k).getPRIORITY_NETWORK(), 5));
						ppStmt.setString(
								l++,
								StringUtils.formatString(xmlMessage
										.getACTIVITY(i).getSUBSIDIARY(j)
										.getDEALER(k).getOSMOSE_SITE(), 5));
						ppStmt.setString(
								l++,
								StringUtils.formatString(xmlMessage
										.getACTIVITY(i).getSUBSIDIARY(j)
										.getDEALER(k).getFI_GROUP(), 25));
						ppStmt.setString(
								l++,
								StringUtils.formatString(xmlMessage
										.getACTIVITY(i).getSUBSIDIARY(j)
										.getDEALER(k).getFLAG_PCR(), 5));
						ppStmt.setString(
								l++,
								StringUtils.formatString(xmlMessage
										.getACTIVITY(i).getSUBSIDIARY(j)
										.getDEALER(k).getSITE_NAME(), 200));
						ppStmt.setString(
								l++,
								StringUtils.formatString(xmlMessage
										.getACTIVITY(i).getSUBSIDIARY(j)
										.getDEALER(k).getDR_CODE(), 50));
						ppStmt.setString(
								l++,
								StringUtils.formatString(xmlMessage
										.getACTIVITY(i).getSUBSIDIARY(j)
										.getDEALER(k).getDR_NAME(), 200));
						ppStmt.setString(
								l++,
								StringUtils.formatString(xmlMessage
										.getACTIVITY(i).getSUBSIDIARY(j)
										.getDEALER(k).getSECTOR_CODE(), 50));
						ppStmt.setString(
								l++,
								StringUtils.formatString(xmlMessage
										.getACTIVITY(i).getSUBSIDIARY(j)
										.getDEALER(k).getSECTOR_NAME(), 200));
						ppStmt.setString(
								l++,
								StringUtils.formatString(xmlMessage
										.getACTIVITY(i).getSUBSIDIARY(j)
										.getDEALER(k).getRRDI_TOWN_NAME(), 200));

						ppStmt.setInt(l++, numProcess);
						ppStmt.setString(l++, fileName);

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
			}
		}

		catch (SQLException sqlExp) {
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

	/**
	 * Sets the prepared statement for sql insert
	 * 
	 * @param xmlMessage
	 *            xml input
	 * @param fileName
	 *            file name
	 * @param numProcess
	 *            process number
	 * @param ppStmt
	 *            prepared statement
	 * @param j
	 *            pdv index
	 * @param k
	 *            contrat plaque index
	 * @param contrat
	 *            boolean flag
	 * @throws SQLException
	 *             exception
	 */
	/*
	 * private void setInsertStatement(MSG_RRDI xmlMessage, String fileName, int
	 * numProcess, PreparedStatement ppStmt, int j, int k, boolean plaque,
	 * boolean contrat) throws SQLException {
	 * 
	 * int i = 1;
	 * 
	 * ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV(j).getPAYS_ORIGINE(), 2));
	 * ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV(j).getMARQUE_ORIGINE(), 2));
	 * if (!plaque) { ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV(j).getID_PDV_RRDI(), 10)); }
	 * else { ppStmt.setString(i++, null); } ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV(j).getNOM_COMMERCIAL(), 200));
	 * ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV(j).getPDV_ADRESS1(), 220));
	 * ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV(j).getPDV_ADRESS2(), 220));
	 * ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV(j).getPDV_CODE_POSTAL(), 12));
	 * ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV(j).getPDV_VILLE(), 120));
	 * ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV(j).getACTIVITE(), 3));
	 * ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV(j).getID_CONTRAT(), 7));
	 * ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV(j).getFLAG_AGENT(), 1));
	 * ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV(j).getFLAG_PCR(), 1));
	 * ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV(j).getFLAG_PDV_TEST(), 1));
	 * ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV(j).getID_CONTRAT_FOURNISSEUR
	 * (), 7)); ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV(j).getDATE_CREATION(), 10));
	 * ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV(j).getDATE_RESILIATION(),
	 * 10)); ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV(j).getTYPE_PDV1(), 20));
	 * ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV(j).getTYPE_PLAQUE(), 10)); if
	 * (plaque) { ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV(j).getID_PDV_RRDI(), 10)); }
	 * else { ppStmt.setString(i++, null); } ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV(j).getGROUPE_FINANCIER(), 3));
	 * ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV(j).getCODE_CONTABLE(), 10));
	 * ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV(j).getCODE_ZONE_COMMERCIALE(),
	 * 4)); ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV(j).getNOM_ZONE_COMMERCIALE(),
	 * 50)); ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV(j).getCODE_DR_COMMERCIALE(),
	 * 4)); ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV(j).getNOM_DR_COMMERCIALE(),
	 * 50)); ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV(j).getCODE_ZONE_FINANCIERE(),
	 * 4)); ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV(j).getNOM_ZONE_FINANCIERE(),
	 * 50));
	 * 
	 * if (contrat) { ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV
	 * (j).getCONTRAT_PLAQUE(k).getID_CONTRAT_PLAQUE(), 7));
	 * ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV(j).getCONTRAT_PLAQUE
	 * (k).getACTIVITE_CONTRAT_PLAQUE(), 3)); ppStmt.setString(i++,
	 * StringUtils.formatString
	 * (xmlMessage.getPDV(j).getCONTRAT_PLAQUE(k).getDATE_CREATION_LIEN(), 10));
	 * ppStmt.setString(i++,
	 * StringUtils.formatString(xmlMessage.getPDV(j).getCONTRAT_PLAQUE
	 * (k).getDATE_RESILIATION_LIEN(), 10)); } else { ppStmt.setString(i++,
	 * null); ppStmt.setString(i++, null); ppStmt.setString(i++, null);
	 * ppStmt.setString(i++, null); }
	 * 
	 * ppStmt.setInt(i++, numProcess); ppStmt.setString(i++,
	 * StringUtils.formatString(fileName, BozConstants.LEN_COD_NOM_FICHIER)); }
	 */
	/**
	 * Suppression de l'ensemble des enregistrements de OPDV
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
			ppStmt = con.prepareStatement(getQuery("DELETE_ORPR"));
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
	 * V�rifie si la valeur est vide ou null. Renvoie true si la chaine est vide
	 * 
	 * @param value
	 *            La chaine � tester
	 * @return true/false
	 */
	public boolean checkEmptyValue(String value) {
		boolean isEmptyValue = true;
		if (value != null && value.trim().length() > 0)
			isEmptyValue = false;

		return isEmptyValue;
	}

}
