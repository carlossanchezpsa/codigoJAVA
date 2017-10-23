/*
 * Cr�� le 28 ao�t 2007
 *
 * Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre&gt;Pr�f�rences&gt;Java&gt;G�n�ration de code&gt;Code et commentaires
 */
package com.inetpsa.boz.common.bean;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author e210954
 * 
 *         Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 *         Fen�tre&gt;Pr�f�rences&gt;Java&gt;G�n�ration de code&gt;Code et
 *         commentaires
 */
public class SuiviModuleBean {
	/** Type du process */
	String codeTypeProcess;

	/** Num�ro de process */
	int numProcess;

	/** Le code du module */
	String codeModule;

	/** Le code source */
	String codeSource;

	/** Le code cible */
	String codeCible;

	/** Le code pays */
	String codePays;

	/** Le code marque */
	String codeMarque;

	/** Le code submarque */
	String codeSubMarque;

	/** La date de d�but d'extraction */
	Date dateDebutExtract;

	/** La date de fin d'extracion */
	Date dateFinExtract;

	/** Type du fichier */
	String libTypeFichier;

	/** La date du transfert */
	Timestamp dateTransfer;

	/** La version du fichier */
	int numVersion;

	/** Date de d�but du traitement du module */
	String dateDebutModule;

	/** Date de fin de module */
	String dateFinModule;

	/** Le nombre d'enregistrement � traiter */
	int nbEnrATraiter;

	/** Le nombre d'enregistrement OK */
	int nbEnrOk;

	/** Le nombre d'enregitrement en Warning */
	int nbEnrWarning;

	/** Le nombre d'enregistrement rejet� */
	int nbEnrRejete;

	/** Le nombre d'enregistrement � recycler */
	int nbEnrARecycler;

	/** Le nombre de ligne supprim� */
	int nbLigneSupprime;

	/** Le nombre de ligne ins�r� */
	int nbLigneInsere;

	/** Le nombre de ligne mise � jour */
	int nbLigneMaj;

	/** Le num�ro de l'erreur */
	int numErreur;

	/** Le libell� de l'erreur */
	String libErreur;

	/** Le code �tat du module */
	String codeEtatModule;

	// DTH_FIN_MODULE, NBR_ENR_A_TRAITER,
	// NBR_ENR_OK, NBR_ENR_WARNING, NBR_ENR_REJET, NBR_ENR_RECYCL,
	// NBR_LIGNE_SUP, NBR_LIGNE_INS,
	// NBR_LIGNE_MAJ, NUM_ERREUR, LIB_ERREUR, COD_ETAT_MODULE

	/**
	 * Getter de codeCible
	 * 
	 * @return String.
	 */

	public String getCodeCible() {
		return codeCible;
	}

	/**
	 * Setter de codeCible
	 * 
	 * @param codeCible
	 *            Le code cible
	 */

	public void setCodeCible(String codeCible) {
		this.codeCible = codeCible;
	}

	/**
	 * Getter de codeEtatModule
	 * 
	 * @return String.
	 */
	public String getCodeEtatModule() {
		return codeEtatModule;
	}

	/**
	 * Setter de codeEtatModule
	 * 
	 * @param codeEtatModule
	 *            Le code �tat du module
	 */
	public void setCodeEtatModule(String codeEtatModule) {
		this.codeEtatModule = codeEtatModule;
	}

	/**
	 * Getter de codeMarque
	 * 
	 * @return String.
	 */
	public String getCodeMarque() {
		return codeMarque;
	}

	/**
	 * Setter de codeMarque
	 * 
	 * @param codeMarque
	 *            Le code de la marque
	 */
	public void setCodeMarque(String codeMarque) {
		this.codeMarque = codeMarque;
	}

	/**
	 * Setter de codeSubMarque
	 * 
	 * @param codeSubMarque
	 *            Le code de la submarque
	 */
	public void setCodeSubMarque(String codeSubMarque) {
		this.codeSubMarque = codeSubMarque;
	}

	/**
	 * Getter de codeSubMarque
	 * 
	 * @return String.
	 */
	public String getCodeSubMarque() {
		return codeSubMarque;
	}

	/**
	 * Getter de codeModule
	 * 
	 * @return String.
	 */
	public String getCodeModule() {
		return codeModule;
	}

	/**
	 * Setter de codeModule
	 * 
	 * @param codeModule
	 *            Le code du module
	 */
	public void setCodeModule(String codeModule) {
		this.codeModule = codeModule;
	}

	/**
	 * Getter de codePays
	 * 
	 * @return String.
	 */
	public String getCodePays() {
		return codePays;
	}

	/**
	 * Setter de codePays
	 * 
	 * @param codePays
	 *            Le code pays
	 */
	public void setCodePays(String codePays) {
		this.codePays = codePays;
	}

	/**
	 * Getter de codeSource
	 * 
	 * @return String.
	 */
	public String getCodeSource() {
		return codeSource;
	}

	/**
	 * Setter de codeSource
	 * 
	 * @param codeSource
	 *            Le code source
	 */
	public void setCodeSource(String codeSource) {
		this.codeSource = codeSource;
	}

	/**
	 * Getter de codeTypeProcess
	 * 
	 * @return String.
	 */
	public String getCodeTypeProcess() {
		return codeTypeProcess;
	}

	/**
	 * Setter de codeTypeProcess
	 * 
	 * @param codeTypeProcess
	 *            Le type du process
	 */
	public void setCodeTypeProcess(String codeTypeProcess) {
		this.codeTypeProcess = codeTypeProcess;
	}

	/**
	 * Getter de dateDebutExtract
	 * 
	 * @return Date.
	 */
	public Date getDateDebutExtract() {
		return dateDebutExtract;
	}

	/**
	 * Setter de dateDebutExtract
	 * 
	 * @param dateDebutExtract
	 *            La date de d�but d'extraction
	 */
	public void setDateDebutExtract(Date dateDebutExtract) {
		this.dateDebutExtract = dateDebutExtract;
	}

	/**
	 * Getter de dateFinExtract
	 * 
	 * @return Date.
	 */
	public Date getDateFinExtract() {
		return dateFinExtract;
	}

	/**
	 * Setter de dateFinExtract
	 * 
	 * @param dateFinExtract
	 *            La date de fin d'extraction
	 */
	public void setDateFinExtract(Date dateFinExtract) {
		this.dateFinExtract = dateFinExtract;
	}

	/**
	 * Getter de dateFinModule
	 * 
	 * @return Date.
	 */
	public String getDateFinModule() {
		return dateFinModule;
	}

	/**
	 * Setter de dateFinModule
	 * 
	 * @param dateFinModule
	 *            La date de fin du module
	 */
	public void setDateFinModule(String dateFinModule) {
		this.dateFinModule = dateFinModule;
	}

	/**
	 * Getter de dateStartModule
	 * 
	 * @return Date.
	 */
	public String getDateDebutModule() {
		return dateDebutModule;
	}

	/**
	 * Setter de dateStartModule
	 * 
	 * @param dateStartModule
	 *            La date de d�but du module
	 */
	public void setDateDebutModule(String dateDebutModule) {
		this.dateDebutModule = dateDebutModule;
	}

	/**
	 * Getter de dateTransfer
	 * 
	 * @return Date.
	 */
	public Timestamp getDateTransfer() {
		return dateTransfer;
	}

	/**
	 * Setter de dateTransfer
	 * 
	 * @param timestamp
	 *            La date de transfert du module
	 */
	public void setDateTransfer(Timestamp timestamp) {
		this.dateTransfer = timestamp;
	}

	/**
	 * Getter de libErreur
	 * 
	 * @return String.
	 */
	public String getLibErreur() {
		return libErreur;
	}

	/**
	 * Setter de libErreur
	 * 
	 * @param libErreur
	 *            Le libell� de l'erreur
	 */
	public void setLibErreur(String libErreur) {
		this.libErreur = libErreur;
	}

	/**
	 * Getter de libTypeFichier
	 * 
	 * @return String.
	 */
	public String getLibTypeFichier() {
		return libTypeFichier;
	}

	/**
	 * Setter de libTypeFichier
	 * 
	 * @param libTypeFichier
	 *            Le libell� du type de fichier
	 */
	public void setLibTypeFichier(String libTypeFichier) {
		this.libTypeFichier = libTypeFichier;
	}

	/**
	 * Getter de nbEnrARecycler
	 * 
	 * @return int.
	 */
	public int getNbEnrARecycler() {
		return nbEnrARecycler;
	}

	/**
	 * Setter de nbEnrARecycler
	 * 
	 * @param nbEnrARecycler
	 *            Le nombre d'enregistrement � recycler
	 */
	public void setNbEnrARecycler(int nbEnrARecycler) {
		this.nbEnrARecycler = nbEnrARecycler;
	}

	/**
	 * Getter de nbEnrATraiter
	 * 
	 * @return int.
	 */
	public int getNbEnrATraiter() {
		return nbEnrATraiter;
	}

	/**
	 * Setter de nbEnrATraiter
	 * 
	 * @param nbEnrATraiter
	 *            Le nombre d'enregistrement � traiter
	 */
	public void setNbEnrATraiter(int nbEnrATraiter) {
		this.nbEnrATraiter = nbEnrATraiter;
	}

	/**
	 * Getter de nbEnrOk
	 * 
	 * @return int.
	 */
	public int getNbEnrOk() {
		return nbEnrOk;
	}

	/**
	 * Setter de nbEnrOk
	 * 
	 * @param nbEnrOk
	 *            Le nombre d'enregistrement OK
	 */
	public void setNbEnrOk(int nbEnrOk) {
		this.nbEnrOk = nbEnrOk;
	}

	/**
	 * Getter de nbEnrWarning
	 * 
	 * @return int.
	 */
	public int getNbEnrWarning() {
		return nbEnrWarning;
	}

	/**
	 * Setter de nbEnrWarning
	 * 
	 * @param nbEnrWarning
	 *            Le nombre d'enregistrement en warning
	 */
	public void setNbEnrWarning(int nbEnrWarning) {
		this.nbEnrWarning = nbEnrWarning;
	}

	/**
	 * Getter de nbLigneInsere
	 * 
	 * @return int.
	 */
	public int getNbLigneInsere() {
		return nbLigneInsere;
	}

	/**
	 * Setter de nbLigneInsere
	 * 
	 * @param nbLigneInsere
	 *            Le nombre de ligne ins�r�e
	 */
	public void setNbLigneInsere(int nbLigneInsere) {
		this.nbLigneInsere = nbLigneInsere;
	}

	/**
	 * Getter de nbLigneMaj
	 * 
	 * @return int.
	 */
	public int getNbLigneMaj() {
		return nbLigneMaj;
	}

	/**
	 * Setter de nbLigneMaj
	 * 
	 * @param nbLigneMaj
	 *            Le nombre de ligne mise � jour
	 */
	public void setNbLigneMaj(int nbLigneMaj) {
		this.nbLigneMaj = nbLigneMaj;
	}

	/**
	 * Getter de nbLigneSupprime
	 * 
	 * @return int.
	 */
	public int getNbLigneSupprime() {
		return nbLigneSupprime;
	}

	/**
	 * Setter de nbLigneSupprime
	 * 
	 * @param nbLigneSupprime
	 *            Le nombre de ligne supprim�
	 */
	public void setNbLigneSupprime(int nbLigneSupprime) {
		this.nbLigneSupprime = nbLigneSupprime;
	}

	/**
	 * Getter de numErreur
	 * 
	 * @return int.
	 */
	public int getNumErreur() {
		return numErreur;
	}

	/**
	 * Setter de numErreur
	 * 
	 * @param numErreur
	 *            Le num�ro de l'erreur
	 */
	public void setNumErreur(int numErreur) {
		this.numErreur = numErreur;
	}

	/**
	 * Getter de numProcess
	 * 
	 * @return int.
	 */
	public int getNumProcess() {
		return numProcess;
	}

	/**
	 * Setter de numProcess
	 * 
	 * @param numProcess
	 *            Le num�ro du process
	 */
	public void setNumProcess(int numProcess) {
		this.numProcess = numProcess;
	}

	/**
	 * Getter de versionFichier
	 * 
	 * @return int.
	 */
	public int getNumVersion() {
		return numVersion;
	}

	/**
	 * Setter de versionFichier
	 * 
	 * @param versionFichier
	 *            La version du fichier
	 */
	public void setNumVersion(int numVersion) {
		this.numVersion = numVersion;
	}

	/**
	 * Getter de nbEnrRejete
	 * 
	 * @return int.
	 */
	public int getNbEnrRejete() {
		return nbEnrRejete;
	}

	//
	// /**
	// * Setter de nbEnrRejete
	// *
	// * @param nbEnrRejete
	// * Le nombre d'enregistrement rejet�
	// */
	public void setNbEnrRejete(int nbEnrRejete) {
		this.nbEnrRejete = nbEnrRejete;
	}

	public SuiviModuleBean copySuiviModuleBean() {
		SuiviModuleBean suiviModuleBeanFinal = new SuiviModuleBean();
		suiviModuleBeanFinal.setCodeCible(this.getCodeCible());
		suiviModuleBeanFinal.setCodeEtatModule(this.getCodeEtatModule());
		suiviModuleBeanFinal.setCodeMarque(this.getCodeMarque());
		suiviModuleBeanFinal.setCodeModule(this.getCodeModule());
		suiviModuleBeanFinal.setCodePays(this.getCodePays());
		suiviModuleBeanFinal.setCodeSource(this.getCodeSource());
		suiviModuleBeanFinal.setCodeTypeProcess(this.getCodeTypeProcess());
		suiviModuleBeanFinal.setDateDebutExtract(this.getDateDebutExtract());
		suiviModuleBeanFinal.setDateDebutModule(this.getDateDebutModule());
		suiviModuleBeanFinal.setDateFinExtract(this.getDateFinExtract());
		suiviModuleBeanFinal.setDateFinModule(this.getDateFinModule());
		suiviModuleBeanFinal.setDateTransfer(this.getDateTransfer());
		suiviModuleBeanFinal.setLibErreur(this.getLibErreur());
		suiviModuleBeanFinal.setLibTypeFichier(this.getLibTypeFichier());
		suiviModuleBeanFinal.setNbEnrARecycler(this.getNbEnrARecycler());
		suiviModuleBeanFinal.setNbEnrATraiter(this.getNbEnrATraiter());
		suiviModuleBeanFinal.setNbEnrOk(this.getNbEnrOk());
		suiviModuleBeanFinal.setNbEnrRejete(this.getNbEnrRejete());
		suiviModuleBeanFinal.setNbEnrWarning(this.getNbEnrWarning());
		suiviModuleBeanFinal.setNbLigneInsere(this.getNbLigneInsere());
		suiviModuleBeanFinal.setNbLigneMaj(this.getNbLigneMaj());
		suiviModuleBeanFinal.setNbLigneSupprime(this.getNbLigneSupprime());
		suiviModuleBeanFinal.setNumErreur(this.getNumErreur());
		suiviModuleBeanFinal.setNumProcess(this.getNumProcess());
		suiviModuleBeanFinal.setNumVersion(this.getNumVersion());
		suiviModuleBeanFinal.setCodeSubMarque(this.codeSubMarque);

		return suiviModuleBeanFinal;
	}

}
