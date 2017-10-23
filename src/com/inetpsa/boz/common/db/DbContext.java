package com.inetpsa.boz.common.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Classe qui définit le contexte des batchs BGC pour la connexion à la BD
 * 
 * @author e210954
 */
public final class DbContext {

    /**
     * Constructeur privé
     */
    private DbContext() {
    }

    /** Owner de la base de donnée */
    private static String dbOwner;

    /** Driver d'accès à la BD */
    private static String driver;

    /** Nom de la BD */
    private static String dbName;

    /** User de la BD */
    private static String user;

    /** Mot de passe de la BD */
    private static String password;

    /** PRD de l'application = "GDO" ou "BGC" */
    private static String prd;

    /**
     * Getter de l'owner de la BD
     * 
     * @return Renvoie dbOwner.
     */
    public static String getDbOwner() {
        return dbOwner;
    }

    /**
     * Setter du owner de la BD
     * 
     * @param dbOwner
     *            Le owner de la BD
     */
    public static void setDbOwner(String dbOwner) {
        DbContext.dbOwner = dbOwner;
    }

    /**
     * Getter du nom de la BD
     * 
     * @return Renvoie dbName.
     */
    public static String getDbName() {
        return dbName;
    }

    /**
     * Setter du nom de la BD
     * 
     * @param dbName
     *            Nom de la BD
     */
    public static void setDbName(String dbName) {
        DbContext.dbName = dbName;
    }

    /**
     * Getter du driver
     * 
     * @return Renvoie driver.
     */
    public static String getDriver() {
        return driver;
    }

    /**
     * Setter du driver
     * 
     * @param driver
     *            Le driver d'accès à la BD
     */
    public static void setDriver(String driver) {
        DbContext.driver = driver;
    }

    /**
     * Getter du mot de passe
     * 
     * @return Renvoie password.
     */
    public static String getPassword() {
        return password;
    }

    /**
     * Setter du mot de passe
     * 
     * @param password
     *            Le mot de passe de la BD
     */
    public static void setPassword(String password) {
        DbContext.password = password;
    }

    /**
     * Getter du user de la BD
     * 
     * @return Renvoie user.
     */
    public static String getUser() {
        return user;
    }

    /**
     * Setter du user de la BD
     * 
     * @param user
     *            Le user de la BD
     */
    public static void setUser(String user) {
        DbContext.user = user;
    }

    /**
     * Getter de prd
     * 
     * @return Renvoie prd.
     */
    public static String getPrd() {
        return prd;
    }

    /**
     * Setter de prd
     * 
     * @param prd
     *            Le PRD de l'application
     */
    public static void setPrd(String prd) {
        DbContext.prd = prd;
    }

    /**
     * Setter du contexte
     * 
     * @param filePathName
     *            chemin vers le fichier de config throws
     * @throws IOException
     *             En cas de proleme avec le fichier de config
     */
    public static void setContext(String filePathName) throws IOException {
        Properties propertiesFile = new Properties();
        propertiesFile.load(new FileInputStream(filePathName));
        setDriver(propertiesFile.getProperty("driver"));
    }

}

