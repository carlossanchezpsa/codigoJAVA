package com.inetpsa.boz.common.exception;

import java.util.MissingResourceException;

import com.inetpsa.boz.common.log.LoggerManager;

/**
 * Classe permettant de générer les exceptions propres au système qui sont des instances de classe
 * MicException
 * 
 * @author e210954
 * @version 1.0.0
 */

public final class BozExceptionFactory {

    /** instance unique */
    private static BozExceptionFactory instance;

    //    /** ResourceBundle contenant les messages d'erreurs */
    //    private ResourceBundle msgBundle;

    //    /**
    //     * Initialisation de la factory à partir d'un nom de fichier properties
    //     *
    //     * @param resource
    //     * Le nom du fichier properties
    //     * @return instance
    //     */
    //    public static MicExceptionFactory create(String resource) {
    //        if (instance == null) {
    //            synchronized (MicExceptionFactory.class) {
    //                if (instance == null) {
    //                    instance = new MicExceptionFactory(resource);
    //                }
    //            }
    //        }
    //        return instance;
    //    }

    /**
     * Constructeur privé
     *  
     */
    private BozExceptionFactory() {
        //        msgBundle = ResourceBundle.getBundle(resource);
    }

    /**
     * Retourne l'instance unique
     * 
     * @return MicExceptionFactory
     */
    public static BozExceptionFactory getInstance() {
        if (instance == null) {
            synchronized (BozExceptionFactory.class) {
                if (instance == null) {
                    //                    instance = new MicExceptionFactory("msgservices");
                    instance = new BozExceptionFactory();
                }
            }
        }
        return instance;
    }

    /**
     * Génère une exception à partir d'un libellé d'erreur
     * 
     * @param message
     *            Le message d'erreur
     * 
     * @return Exception
     */
    public BozException newException(String message) {
        return new BozException(message, 0);
    }

    /**
     * Génère une exception à partir d'un libellé d'erreur
     * 
     * @param message
     *            Le message d'erreur
     * @param code
     *            Le code erreur
     * @return Exception
     */
    public BozException newException(String message, int code) {
        return new BozException(message, code);
    }

    /**
     * Gestion des exceptions
     * 
     * @param ex
     *            L'exception générée
     * @throws BozException
     *             Pour remonter l'erreur
     */
    public void throwException(Exception ex) throws BozException {
        if (ex instanceof BozException)
            throw (BozException) ex;
        else {
            LoggerManager.getInstance().printStackTrace(ex);
            throw BozExceptionFactory.getInstance().newException(ex.getMessage());
        }
    }

    /**
     * Gestion des exceptions
     * 
     * @param ex
     *            L'exception générée
     * @param code
     *            Le code erreur
     * @throws BozException
     *             Pour remonter l'erreur
     */
    public void throwException(Exception ex, int code) throws BozException {
        if (ex instanceof BozException)
            throw (BozException) ex;
        else {
            LoggerManager.getInstance().printStackTrace(ex);
            throw BozExceptionFactory.getInstance().newException(ex.getMessage(), code);
        }
    }

    /**
     * Gestion des exceptions
     * 
     * @param ex
     *            L'exception générée
     */
    public void logException(Exception ex) {

        LoggerManager.getInstance().printStackTrace(ex);

    }

    /**
     * Génère une exception à partir d'un code et d'une info de détail dynamique
     * 
     * @param code
     *            code associé à un message d'erreur statique
     * @param detail
     *            information optionnelle sur la levée de l'erreur
     */
    public void logException(int code, String detail) {
        StringBuffer message = new StringBuffer();

        try {
            message.append("code=[");
            message.append(code);
            message.append("] msg=[");
            //            msg = msgBundle.getString("" + code);

        } catch (MissingResourceException e) {
            LoggerManager.getInstance().printStackTrace(e);
        }

        //        message.append(msg);
        message.append("]");

        if (detail != null) {
            message.append(" detail=[");
            message.append(detail);
            message.append("]");
        }

        LoggerManager.getInstance().error(message);
    }

    /**
     * Génère une exception à partir d'un code et d'une info de détail dynamique
     * 
     * @param code
     *            code associé à un message d'erreur statique
     * @param detail
     *            information optionnelle sur la levée de l'erreur
     * @return Exception
     */
    public BozException newException(int code, String detail) {
        StringBuffer message = new StringBuffer();
        String msg = "";

        try {
            message.append("code=[");
            message.append(code);
            message.append("] msg=[");
            //            msg = msgBundle.getString("" + code);

        } catch (MissingResourceException e) {
            msg = "not found";
        }

        message.append(msg);
        message.append("]");

        if (detail != null) {
            message.append(" detail=[");
            message.append(detail);
            message.append("]");
        }
        return new BozException(msg, code);
        //        return new BozException(code, msg, detail, message.toString());
    }

}