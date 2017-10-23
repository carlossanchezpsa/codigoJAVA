package com.inetpsa.boz.common.exception;

/**
 * Classe d'exception associée à l'application MIC, elle couvre les runtime errors des services. Les instances
 * de cette classe sont caractérisées par un code auquel un associe un message se trouvant dans un
 * ResourceBundle
 * 
 * @author e210954
 * @version 1.0.0
 *  
 */
public class BozException extends Exception {
    /** message d'erreur */
    private final String msg;

    /** code erreur */
    private final int code;

    //    /**
    //     * Constructeur
    //     *
    //     * @param msg
    //     * Le message d'erreur associé
    //     *
    //     */
    //    protected MicException(String msg) {
    //        this.msg = msg;
    //    }

    /**
     * Constructeur
     * 
     * @param msg
     *            Le message d'erreur associé
     * @param code
     *            Le code erreur
     *  
     */
    protected BozException(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    /**
     * Getter du code
     * 
     * @return code
     */
    public int getCode() {
        return code;
    }

    /**
     * Getter du msg
     * 
     * @return code
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Get the full message to return
     * 
     * @return Le message d'erreur
     */
    public String getMessage() {
        StringBuffer buf = new StringBuffer(" message : [").append(this.msg).append("]");

        return buf.toString();
    }

}