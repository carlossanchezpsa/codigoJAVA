package com.inetpsa.boz.vcm.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.inetpsa.boz.common.bean.SuiviProcessBean;
import com.inetpsa.boz.common.constant.BozConstants;
import com.inetpsa.boz.common.dao.RpvDao;
import com.inetpsa.boz.common.db.DbManager;
import com.inetpsa.boz.common.exception.BozException;
import com.inetpsa.boz.common.log.LoggerManager;
import com.inetpsa.boz.vcm.apv.dao.VcmAPVDao;

/**
 * Process du traitement du load du SAS
 */
public class VcmProcess {

	/**
	 * Effectue l'unmarshalling des fichiers XML du r�pertoire inputPath Puis
	 * l'insertion des objets dans la BD
	 * 
	 */
	public void execute() {
		Connection con = DbManager.getInstance().getConnection();
		// SuiviProcessBean report = new SuiviProcessBean();
		// -- Init date de suivi du process
		java.util.Date dateDebutProcess = new java.util.Date();
		SuiviProcessBean suiviProcessBean = new SuiviProcessBean();
		// SuiviModuleBean suiviModuleBean = null;
		String etatProcess = BozConstants.statusOK;
		// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		// SimpleDateFormat sdfReject = new SimpleDateFormat("yyyyMMddHHmmss");
		// String sFriendyMessage = null;

		int numProcess = 0;
		try {

			// -- R�cup�ration du num�ro du process
			numProcess = RpvDao.getInstance().getNumProcess(con);
			VcmAPVDao.getInstance().delete_vm(con);
			RpvDao.getInstance().insertFlagIni(con, "BOZQTOEVM");
			try {
				LoggerManager.getInstance().info(
						"/*********** DEBUT PROCESS ***********/");

				// Procesamos los ficheros VM-APV que existan
				suiviProcessBean.setNumProcess(numProcess);
				suiviProcessBean.setNbFichierATraiter(0);
				suiviProcessBean.setNbFichierRejet(0);
				suiviProcessBean.setNbFichierOk(0);

				VcmAPVProcess vcmAPVProcess = new VcmAPVProcess();
				vcmAPVProcess.execute(suiviProcessBean);

				VcmVNProcess vcmVNProcess = new VcmVNProcess();
				vcmVNProcess.execute(suiviProcessBean);

			} catch (Exception ex) {
				etatProcess = BozConstants.statusKO;
				suiviProcessBean.setNumErreur(-1);
				suiviProcessBean.setLibErreur(ex.getMessage());
				suiviProcessBean.setCodeEtatProcess(etatProcess);
				// suiviModuleBean.setLibErreur(ex.getMessage());
				// suiviModuleBean.setNumErreur(-1);
				LoggerManager.getInstance().error(ex.getMessage());
				// ex.printStackTrace();
			}

			// -- Suivi du process
			suiviProcessBean.setCodeTypeProcess("LOAD_SASINF");
			suiviProcessBean.setNumProcess(numProcess);
			suiviProcessBean.setDateDebut(sdf2.format(dateDebutProcess));
			suiviProcessBean.setDateFin((sdf2.format(new java.util.Date())));
			// suiviProcessBean.setNbFichierATraiter(nbFichier);
			// suiviProcessBean.setNbFichierOk(nbFichierOk);
			// suiviProcessBean.setNbFichierRejet(nbFichierKo);
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
}
