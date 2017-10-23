package com.inetpsa.boz.common.context;

import java.io.File;
import java.io.IOException;

import com.inetpsa.boz.common.constant.BozConstants;
import com.inetpsa.boz.common.db.DbManager;
import com.inetpsa.boz.common.exception.BozExceptionFactory;
import com.inetpsa.boz.common.log.LoggerManager;

/*
 * Cr�� le 22 mars 2007
 *
 */

/**
 * Initialisation globale du contexte : log + BD des batchs BGC
 * 
 * @author e210954
 * 
 */
public final class BozContext {

	/** Le code produit de l'application = "BOZ" ou "..." */
	private static String prd;

	/** Le sch�ma de la base BOZ */
	private static String dbOwner;

	/**
	 * Contructeur par d�faut
	 */
	private BozContext() {
	}

	/**
	 * L'initialisation du context
	 * 
	 * @throws BGCException
	 *             En cas d'erreur
	 * @throws IOException
	 *             En cas d'erreur de lecture de fichier
	 */
	public static void init() throws Exception {

		// Init du Context

		String logPath = System.getProperty(BozConstants.BOZ_REP_LOG);
		String logName = System.getProperty(BozConstants.BOZ_FIC_LOG);
		String dbUser = System.getProperty(BozConstants.BOZ_ALIM_USER);

		String dbPwd = System.getProperty(BozConstants.BOZ_ALIM_MDP);
		String dbOracleSid = System.getProperty(BozConstants.BOZ_ORACLE_SID);
		setDbOwner(System.getProperty(BozConstants.BOZ_SCHEMA_SAS));
		setPrd(System.getProperty(BozConstants.BOZ_PRD));
		if (logPath == null || logName == null) {
			logPath = "." + File.separator;
			logName = BozConstants.TMPBATCHLOG;
			LoggerManager.init(logPath, logName);

			throw BozExceptionFactory.getInstance().newException(
					"La variable " + BozConstants.BOZ_REP_LOG + " ou " + BozConstants.BOZ_FIC_LOG + " n'est pas positionn�e", -1);
		}

		LoggerManager.init(logPath, logName);
		if (dbUser == null || dbPwd == null || dbOracleSid == null || dbOwner == null || prd == null) {
			throw BozExceptionFactory.getInstance().newException("Une variable de connexion � la base de donn�e est manquante", -1);
		}
		DbManager.create(dbOracleSid, dbUser, dbPwd);

	}

	/**
	 * Getter de prd
	 * 
	 * @return String.
	 */
	public static String getPrd() {
		return prd;
	}

	/**
	 * Setter de prd
	 * 
	 * @param prd
	 *            Le code prd de l'application
	 */
	public static void setPrd(String prd) {
		BozContext.prd = prd;
	}

	/**
	 * Getter de dbOwner
	 * 
	 * @return String.
	 */
	public static String getDbOwner() {
		return dbOwner;
	}

	/**
	 * Setter de dbOwner
	 * 
	 * @param dbOwner
	 *            Le sch�ma de la base de donn�e
	 */
	public static void setDbOwner(String dbOwner) {
		BozContext.dbOwner = dbOwner;
	}
}
