package com.inetpsa.boz.common.constant;

/**
 * Interface de constantes associ�es au standard d'entr�e/sortie du BOZ
 * 
 * @author e210954
 * @version 1.0.0
 */
public class BozConstants {

	/** Cas d'un statut OK */
	public static final String statusOK = "OK";

	/** Cas d'un statut KO */
	public static final String statusKO = "KO";

	/** Le num�ro de version du batch */
	public static final String version = "1.0.0";

	/**
	 * Le nom du fichier log temporaire si LOG_FILE ou UNXLOG ne sont pas
	 * renseign�s
	 */
	public static final String TMPBATCHLOG = "TMPBATCHLOG";

	/** Le user de connexion */
	public static final String BOZ_ALIM_USER = "BOZ_ALIM_USER";

	/** PDV Plaque */
	public static final String BOZ_PDV_PLAQUE = "PLAQUE";

	/** Le mot de passe de connexion */
	public static final String BOZ_ALIM_MDP = "BOZ_ALIM_MDP";

	/** Le pr�fixe du nom de fichier en entr�e */
	public static final String BOZ_PREFIX_IN = "BOZ_PREFIX_IN";

	/** La localisation du r�pertoire des fichiers rejet�s */
	public static final String BOZ_REP_REJET = "BOZ_REP_REJET";

	/** La localisation du r�pertoire des fichiers int�gr�s */
	public static final String BOZ_REP_VALIDE = "BOZ_REP_VALIDE";

	/** La localisation du r�pertoire des logs */
	public static final String BOZ_REP_LOG = "BOZ_REP_LOG";

	/** La localisation du r�pertoire des fichiers de logs */
	public static final String BOZ_FIC_LOG = "BOZ_FIC_LOG";

	/** L'url vers la base de donn�e */
	public static final String BOZ_ORACLE_SID = "BOZ_ORACLE_SID";

	/** Le sch�ma de la BD du SAS */
	public static final String BOZ_SCHEMA_SAS = "BOZ_SCHEMA_SAS";

	/** Le driver JDBC oracle */
	public static final String BOZ_ORACLE_DRIVER = "BOZ_ORACLE_DRIVER";

	/** Le code produit de l'application */
	public static final String BOZ_PRD = "BOZ_PRD";

	/** La taille du champ code pays */
	public final static int LEN_COD_PAYS = 10;

	/** La taille du champ code marque */
	public final static int LEN_COD_MARQUE = 10;

	/** La taille du champ code activite */
	public final static int LEN_COD_ACTIVITY = 10;

	/** La taille du champ code id visit */
	public final static int LEN_VISIT_ID = 10;

	/** La taille du champ vague */
	public final static int LEN_PERIOD = 10;

	/** La taille du champ dealer activity */
	public final static int LEN_DEALER_ACTIVITY = 10;

	/** La taille du champ lead activity */
	public final static int LEN_LEAD_ACTIVITY = 10;

	/** La taille du champ scenario */
	public final static int LEN_SCENARIO = 100;

	/** La taille du champ Qn Indicators */
	public final static int LEN_Q_SHORT = 10;

	/** La taille du champ Qn Indicators */
	public final static int LEN_Q_LONG = 2000;

	/** La taille du champ Qn Indicators */
	public final static int LEN_Q_DATE = 10;

	/** La taille du champ Qn Indicators */
	public final static int LEN_Q_TIME = 8;

	/** La taille du champ Creation Date */
	public final static int LEN_DTH_CREA_DTM = 50;

	/** La taille du champ Creation Date */
	public final static int LEN_NAME = 50;

	/** La taille du champ num�ro d'individu */
	public final static int LEN_NUM_IND = 20;

	/** La taille du champ code PDV */
	public final static int LEN_DEALER_CODE = 30;

	/** La taille du champ SITE CODE */
	public final static int LEN_SITE_CODE = 30;

	/** La taille du champ code Lead Id */
	public final static int LEN_LEAD_ID = 30;

	/** La taille du champ code Visit Number */
	public final static int LEN_VISIT_NUMBER = 10;

	/** La taille du champ code Transfer Date */
	public final static int LEN_TRANSFER_DATE = 30;

	/** La taille du champ code syst�me d'origine */
	public final static int LEN_COD_SYS_ORIGINE = 25;

	/** La taille du champ date de cr�ation d'individu */
	public final static int LEN_DTH_CREA_IND = 19;

	/** La taille du champ date de maj de l'individu */
	public final static int LEN_DTH_MAJ_IND = 19;

	/** La taille du champ du num�ro du type d'individu */
	public final static int LEN_NUM_TYPE_IND = 2;

	/** La taille du champ libell� civilit� */
	public final static int LEN_LIB_CIVILITE = 20;

	/** La taille du champ code sexe */
	public final static int LEN_COD_SEXE = 2;

	/** La taille du champ nom1 de l'individu */
	public final static int LEN_LIB_NOM1_IND = 70;

	/** La taille du champ nom2 de l'individu */
	public final static int LEN_LIB_NOM2_IND = 70;

	/** La taille du champ pr�nom de l'individu */
	public final static int LEN_LIB_PRENOM_IND = 70;

	/** La taille du champ nom du contact */
	public final static int LEN_LIB_NOM_CONTACT = 120;

	/** La taille du champ pr�nom du contact */
	public final static int LEN_LIB_PRENOM_CONTACT = 120;

	/** La taille du champ date de naissance */
	public final static int LEN_DTJ_NAIS_IND = 10;

	/** La taille du champ libell� de l'adresse 1 */
	public final static int LEN_LIB_ADRESSE1 = 100;

	/** La taille du champ libell� de l'adresse 2 */
	public final static int LEN_LIB_ADRESSE2 = 100;

	/** La taille du champ code postal */
	public final static int LEN_COD_POSTAL = 30;

	/** La taille du champ libell� ville */
	public final static int LEN_LIB_VILLE = 100;

	/** La taille du champ libell� r�gion */
	public final static int LEN_LIB_REGION = 70;

	/** La taille du champ libelle pays */
	public final static int LEN_LIB_PAYS = 70;

	/** La taille du champ t�l�phone personnel */
	public final static int LEN_LIB_TEL_PERSO = 24;

	/** La taille du champ t�l�phone mobile */
	public final static int LEN_LIB_TEL_MOBILE = 24;

	/** La taille du champ t�l�phone professionel */
	public final static int LEN_LIB_TEL_PRO = 24;

	/** La taille du champ mail */
	public final static int LEN_LIB_MAIL = 100;

	/** La taille du champ flag information personnelle */
	public final static int LEN_FLG_INFO_PERSO = 1;

	/** La taille du champ flag refus offre */
	public final static int LEN_FLG_REFUS_OFFRE = 1;

	/** La taille du champ flag liste rouge */
	public final static int LEN_FLG_LISTE_ROUGE = 1;

	/** La taille du champ flag interdit email */
	public final static int LEN_FLG_INTERDIT_MAIL = 1;

	/** La taille du champ date de suppression de l'individu */
	public final static int LEN_DTH_SUP_IND = 19;

	/** La taille du champ id fical */
	public final static int LEN_ID_FISCAL = 20;

	/** La taille du champ num�ro de l'opportunit� */
	public final static int LEN_NUM_OPP = 20;

	/** La taille du champ date de cr�ation de l'opportunit� */
	public final static int LEN_DTH_CREA_OPP = 19;

	/** La taille du champ date de maj de l'opportunit� */
	public final static int LEN_DTH_MAJ_OPP = 19;

	/** La taille du champ num�ro de la m�thode de contact */
	public final static int LEN_NUM_METHODE_CONTACT = 5;

	/** La taille du champ num�ro de la source de l'opportunit� */
	public final static int LEN_NUM_SOURCE_OPP = 5;

	/** La taille du champ code du type de l'opportunit� */
	public final static int LEN_COD_TYPE_OPP = 2;

	/** La taille du champ code du type de l'opportunit� */
	public final static int LEN_COD_TYPE_OPP2 = 5;

	/** La taille du champ date de contact de l'individu */
	public final static int LEN_DTJ_CONTACT_IND = 10;

	/** La taille du champ num�ro de nature de l'opportunit� */
	public final static int LEN_NUM_NATURE_OPP = 5;

	/** La taille du champ code marketing */
	public final static int LEN_COD_MARKETING = 20;

	/** La taille du champ libell� de l'opportunit� */
	public final static int LEN_LIB_OPP = 64;

	/** La taille du champ libell� de la demande APV */
	public final static int LEN_LIB_DEMANDE_APV = 256;

	/** La taille du champ libell� de l'information de financement */
	public final static int LEN_LIB_INFO_FINANCEMENT = 64;

	/** La taille du champ libell� de la marque du v�hicule actuel */
	public final static int LEN_LIB_MARQUE_VEH_ACTUEL = 128;

	/** La taille du champ mod�le de v�hicule actuel */
	public final static int LEN_LIB_MODELE_VEH_ACTUEL = 128;

	/** La taille du champ code CAP du v�hicule actuel */
	public final static int LEN_COD_CAP_VEH_ACTUEL = 20;

	/** La taille du champ code */
	public final static int LEN_COD_EXP_VEH_ACTUEL = 20;

	/** La taille du champ flag echange du v�hicule actuel */
	public final static int LEN_FLG_ECH_VEH_ACTUEL = 1;

	/** La taille du champ libell� de l'immatriculation du v�hicule actuel */
	public final static int LEN_LIB_IMMAT_VEH_ACTUEL = 20;

	/** La taille du champ nombre de kilom�tre du v�hicule actuel */
	public final static int LEN_NUM_KM_VEH_ACTUEL = 10;

	/** La taille du champ libell� de la marque du v�hicule d'int�r�t */
	public final static int LEN_LIB_MARQUE_VEH_INT = 128;

	/** La taille du champ libell� du mod�le de v�hicule d'int�r�t */
	public final static int LEN_LIB_MODELE_VEH_INT = 128;

	/** La taille du champ num�ro de type de v�hicule d'int�r�t */
	public final static int LEN_NUM_TYPE_VEH_INT = 2;

	/** La taille du champ nombre de kilom�tre du v�hicule d'int�r�t */
	public final static int LEN_NUM_KM_VEH_INT = 10;

	/** La taille du champ libell� de la marque du v�hicule achet� */
	public final static int LEN_LIB_MARQUE_VEH_ACHT = 128;

	/** La taille du champ libell� du mod�le du v�hicule achet� */
	public final static int LEN_LIB_MODELE_VEH_ACHT = 128;

	/** La taille du champ type v�hicule achet� */
	public final static int LEN_NUM_TYPE_VEH_ACHT = 2;

	/** La taille du champ immatriculationv v�hicule achet� */
	public final static int LEN_LIB_IMMAT_VEH_ACHT = 20;

	/** La taille du champ nombre de kilom�tre du v�hicule achet� */
	public final static int LEN_NUM_KM_VEH_ACHT = 10;

	/** La taille du champ */
	public final static int LEN_COD_CAP_VEH_ACHT = 20;

	/** La taille du champ */
	public final static int LEN_COD_EXP_VEH_ACHT = 20;

	/** La taille du champ num�ro de statut de l'opportunit� */
	public final static int LEN_NUM_STATUT_OPP = 5;

	/** La taille du champ date de suppression de l'opportunit� */
	public final static int LEN_DTH_SUP_OPP = 19;

	/** La taille du champ num�ro d'activit� */
	public final static int LEN_NUM_ACT = 20;

	/** La taille du champ date de cr�ation d'activit� */
	public final static int LEN_DTH_CREA_ACT = 19;

	/** La taille du champ date de mise � jour de l'activit� */
	public final static int LEN_DTH_MAJ_ACT = 19;

	/** La taille du champ type de l'activit� */
	public final static int LEN_NUM_TYPE_ACT = 5;

	/** La taille du champ libell� de vendeur */
	public final static int LEN_LIB_VENDEUR = 70;

	/** La taille du champ num�ro de la m�thode de l'activit� */
	public final static int LEN_NUM_METHODE_ACT = 5;

	/** La taille du champ date de cr�ation dans le SAS */
	public final static int LEN_DTH_CREA_SAS = 16;

	/** La taille du champ num�ro du process */
	public final static int LEN_NUM_PROCESS = 10;

	/** La taille du champ nom de fichier */
	public final static int LEN_COD_NOM_FICHIER = 50;

	/** Le code du type de process */
	public final static int LEN_COD_TYPE_PROCESS = 15;

	/** Le code du module */
	public final static int LEN_COD_MODULE = 15;

	/** Le code source */
	public final static int LEN_COD_SOURCE = 50;

	/** Le code cible */
	public final static int LEN_COD_CIBLE = 9;

	/** Le libell� du type de fichier */
	public final static int LEN_LIB_TYP_FICHIER = 40;

	public final static int LEN_NUM_CONTRACT = 32;

	public final static int LEN_NUM_VEH = 10;

	public final static int LEN_LCDV = 32;

	public final static int LEN_DESCRIP = 128;

	public final static int LEN_KIND = 16;

	public final static int LEN_TYPE = 2;

	public final static int LEN_VIN = 32;

	public final static int LEN_PRICE = 22;

	public final static int LEN_TAX = 10;

	public final static int LEN_REG_NUM = 32;

	public final static int LEN_AMOUNT = 22;

	public final static int LEN_DURATION = 10;

	public final static int LEN_MILEAGE = 10;

	public final static int LEN_SERVICE = 1024;

	public final static int LEN_MONTHLY_PAYMENT = 22;

	public final static int LEN_END_CONTRACT = 19;

	public final static int LEN_CAPITAL = 22;

	public final static int LEN_IN_GDO = 19;

	public final static int LEN_IN_MQ = 19;

	public final static int LEN_USER_QUALIF = 240;

	public final static int LEN_FLAG_QUALIF = 10;

	public final static int LEN_MOTIF_REJECT = 19;

	public final static int LEN_USER_AFECT = 240;

	public final static int LEN_AFECT_AUTOM = 10;

	public final static int LEN_USER_ID = 7;

	/** The length of client id opv */
	public final static int LEN_ID_CLIENT_OPV = 10;

	public final static int LEN_DATE_AFFECTATION = 19;

	public final static int LEN_DATE_TRANSFORMATION = 19;

	public final static int LEN_PERIODE_I_A = 32;

	public final static int LEN_DATE_CONTACT_CLI_CC = 19;

	public final static int LEN_ID_CLICK = 20;

	public final static int LEN_GAMME = 30;

	/** LEN_PRIX catalog price */
	public final static int LEN_PRIX = 21;

	public final static int LEN_ID_EXTERNAL_OPP = 20;

}