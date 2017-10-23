/*
 * Créé le 31 mai 2006
 *
 */
package com.inetpsa.boz.common.constant;

/**
 * Classe de constante contenant les codes erreurs des batchs
 * 
 * @author e210954
 *  
 */
public class CodeConstant {


    /** Codes erreur base de données */
    public static final int BOZ_ERR_DB_QUERY = 50;

    /** Codes erreur technique */
    public static final int BOZ_ERR_INTERNAL_RUNTIME = 51;

    /** Valeur du SQLCODE -803 (doublon) */
    public static final int SQLCODE_803 = -803;

    /** Valeur du SQLCODE -503 (contrainte d'intégrité sur table parente) */
    public static final int SQLCODE_530 = -530;

    /** Valeur du SQLCODE -302 (valeur d'une variable SQL trop longue) */
    public static final int SQLCODE_302 = -302;

    /** Statut en erreur du batch */
    public static final int BGC_ERR_EXIT_KO = -1;

}
