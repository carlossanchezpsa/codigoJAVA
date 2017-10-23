package com.inetpsa.boz.common.log;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Classe permettant de générer les différents logs de l'application. Plusieurs sorties sont actives en
 * fonction du type de log
 * 
 * @author e210954
 * @version 1.0.0
 */

public final class LoggerManager {

    /** singleton */
    private static LoggerManager instance;

    /** chemin ou on génère la sortie */
    private static String outputLogPath;

    /** nom du fichier de sortie */
    private static String outputLogFile;

    /** chemin ou on génère les logs d'erreur */
    private static String errLogPath;

    /** nom du fichier log d'erreur */
    private static String errLogFile;

    /** noms du logger des dossiers */
    private static String errLoggerName = "err";

    /** noms du logger des dossiers */
    private static String outputLoggerName = "out";

    /**
     * Configure le manager à partir d'un fichier de properties
     * 
     * @param properties
     *            fichier de propriété
     */
    private static void configure(String properties) {

        ResourceBundle bundle = ResourceBundle.getBundle(properties);
        Properties log4jproperties = new java.util.Properties();

        Enumeration enu = bundle.getKeys();

        String key;
        String value;

        while (enu.hasMoreElements()) {
            key = (String) enu.nextElement();
            value = bundle.getString(key);
            log4jproperties.put(key, value);
        }

        PropertyConfigurator.configure(log4jproperties);
    }

    /**
     * On récupère l'instance du manager de logs
     * 
     * @return LoggerManager
     */
    public static LoggerManager getInstance() {
        if (instance == null) {
            synchronized (LoggerManager.class) {
                if (instance == null) {
                    configure("LOG");
                    instance = new LoggerManager();
                }
            }
        }
        return instance;
    }

    /**
     * Retourne le chemin où sont générés les logs
     * 
     * @return String
     */
    public static String getOutPutPath() {
        return outputLogPath;
    }

    /**
     * Retourne le chemin où sont générés les logs
     * 
     * @return String
     */
    public static String getErrLogPath() {
        return errLogPath;
    }

    /**
     * Retourne le nom du fichier de log de l'application PNR
     * 
     * @return String
     */
    public static String getErrLogFile() {
        return errLogFile;
    }

    /**
     * initialisation du manager de logs
     * 
     * @param outputPath
     *            Le chemin ou sont stocké les fichiers de sorties
     * @param outputFile
     *            Le préfix du nom du fichier de sortie
     * @param logPath
     *            Le chemin ou sont stocké les logs
     * @param logFile
     *            Le préfix du nom du fichier log
     *  
     */
    public static void init(String outputPath, String outputFile, String logPath, String logFile) {

        if (instance == null) {

            synchronized (LoggerManager.class) {

                if (instance == null) {

                    errLogPath = logPath;
                    outputLogPath = outputPath;

                    errLogFile = logFile;
                    outputLogFile = outputFile;

                    if (errLogPath == null) {
                        errLogPath = "." + File.separator;
                    } else {
                        if (!errLogPath.endsWith(File.separator))
                            errLogPath += File.separator;
                    }
                    if (outputLogPath == null) {
                        outputLogPath = "." + File.separator;
                    } else {
                        if (!outputLogPath.endsWith(File.separator))
                            outputLogPath += File.separator;
                    }

                    (new File(errLogPath)).mkdirs();

                    System.setProperty("err.log.path", errLogPath);
                    System.setProperty("err.log.file", errLogFile);
                    System.setProperty("out.log.path", outputLogPath);
                    System.setProperty("out.log.file", outputLogFile);

                    configure("LOG");

                    instance = new LoggerManager();
                }
            }
        }
    }

    /**
     * initialisation du manager de logs
     * 
     * 
     * @param logPath
     *            Le chemin ou sont stocké les logs
     * @param logFile
     *            Le préfix du nom du fichier log
     *  
     */
    public static void init(String logPath, String logFile) {

        if (instance == null) {

            synchronized (LoggerManager.class) {

                if (instance == null) {

                    errLogPath = logPath;

                    errLogFile = logFile;

                    if (errLogPath == null) {
                        errLogPath = "." + File.separator;
                    } else {
                        if (!errLogPath.endsWith(File.separator))
                            errLogPath += File.separator;
                    }

                    (new File(errLogPath)).mkdirs();

                    System.setProperty("out.log.path", errLogPath);
                    System.setProperty("out.log.file", errLogFile);

                    configure("LOG");

                    instance = new LoggerManager();
                }
            }
        }
    }

    /** out */
    private Logger output;

    /** pnr */
    private Logger err;

    /**
     * Constructeur privé
     */
    private LoggerManager() {
        output = Logger.getLogger(outputLoggerName);
        err = Logger.getLogger(errLoggerName);
    }

    /**
     * On log une donnée de type erreur
     * 
     * @param o
     *            objet à logger
     */
    public void error(Object o) {
        err.error("ERR >> " + o);
    }

    /**
     * On log une donnée de type info PNR
     * 
     * @param o
     *            objet à logger
     */
    public void info(Object o) {
        output.info(o);
    }

    /**
     * on log le printStacktrace d'un excpetion sur le flux d'erreur
     * 
     * @param thr
     *            throwable
     */
    public void printStackTrace(Throwable thr) {
        StringWriter strW = new StringWriter();
        PrintWriter pW = new PrintWriter(strW);
        thr.printStackTrace(pW);
        err.error("ERR_APP >> " + strW.getBuffer());
    }

}