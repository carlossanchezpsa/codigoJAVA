/*
 * Cr�� le 22 ao�t 2007
 *
 * Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre&gt;Pr�f�rences&gt;Java&gt;G�n�ration de code&gt;Code et commentaires
 */
package com.inetpsa.boz.rpv.ecm.start;

import com.inetpsa.boz.common.constant.BozConstants;
import com.inetpsa.boz.common.context.BozContext;
import com.inetpsa.boz.common.log.LoggerManager;
import com.inetpsa.boz.rpv.ecm.business.EcmProcess;

/**
 * @author e210954
 * 
 *         Classe de lancement du batch RPV qui effectue le load des donn�es du
 *         SAS.
 * 
 */
public class EcmStart {

	/**
	 * M�thode principale
	 * 
	 * @param args
	 *            Argument de la JVM
	 */
	public static void main(String[] args) {
		try {

			Context.setContext();
			BozContext.init();
			LoggerManager.getInstance().info("version : " + BozConstants.version);
			EcmProcess rpvprocess = new EcmProcess();
			rpvprocess.execute();
			// CHECKSTYLE:OFF
		} catch (Exception ex) {
			LoggerManager.getInstance().error(ex.getMessage());
			System.exit(-1);
			ex.printStackTrace();
		}// CHECKSTYLE:ON
	}

}
