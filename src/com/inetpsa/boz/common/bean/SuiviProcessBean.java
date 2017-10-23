/*
 * Créé le 28 août 2007
 *
 * Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre&gt;Préférences&gt;Java&gt;Génération de code&gt;Code et commentaires
 */
package com.inetpsa.boz.common.bean;


/**
 * @author e210954
 * 
 * Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre&gt;Préférences&gt;Java&gt;Génération de code&gt;Code et commentaires
 */
public class SuiviProcessBean {
    /** Type du process */
    String codeTypeProcess;

    /** Numéro de process */
    int numProcess;

    /** La date de début */
    String dateDebut;

    /** La date de fin */
    String dateFin;

    /** Le nombre d'enregistrement */
    int nbEnrATraiter;

    /** Le nombre de fichier de rejet */
    int nbFichierRejet;

    /** Le nombre de fichier à traiter */
    int nbFichierATraiter;

    /** Le nombre de fichier Ok */
    int nbFichierOk;

    /** Le numéro de l'erreur */
    int numErreur;

    /** Le libellé de l'erreur */
    String libErreur;

    /** Le code état du suivi du process */
    String codeEtatProcess;

    /***/
    public String getDateDebut() {
        return dateDebut;
    }

    /**
     * Setter de dateDebut
     * 
     * @param dateDebut
     *            La date de début
     */
    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * Getter de dateFin
     * 
     * @return Date
     */
    public String getDateFin() {
        return dateFin;
    }

    /**
     * Setter de dateFin
     * 
     * @param dateFin
     *            La date de fin de traitement
     */
    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * Getter du nombre d'enregistrement à traiter
     * 
     * @return int
     */
    public int getNbEnrATraiter() {
        return nbEnrATraiter;
    }

    /**
     * Setter de nbEnrATraiter
     * 
     * @param nbEnrATraiter
     *            Le nombre d'enregistrement à traiter
     */
    public void setNbEnrATraiter(int nbEnrATraiter) {
        this.nbEnrATraiter = nbEnrATraiter;
    }

    /**
     * Getter de nbFichierRejet
     * 
     * @return nbFichierRejet
     */
    public int getNbFichierRejet() {
        return nbFichierRejet;
    }

    /**
     * Setter de nbFichierRejet
     * 
     * @param nbFichierRejer
     *            Le nombre de fichier rejeter
     */
    public void setNbFichierRejet(int nbFichierRejet) {
        this.nbFichierRejet = nbFichierRejet;
    }

    /**
     * Getter de numProcess
     * 
     * @return int
     */
    public int getNumProcess() {
        return numProcess;
    }

    /**
     * Setter de numProcess
     * 
     * @param numProcess
     *            Le numéro du process
     */
    public void setNumProcess(int numProcess) {
        this.numProcess = numProcess;
    }

    /**
     * Getter de codeTypeProcess
     * 
     * @return String
     */
    public String getCodeTypeProcess() {
        return codeTypeProcess;
    }

    /**
     * Setter de codeTypeProcess
     * 
     * @param codeTypeProcess
     *            Le type de process
     */
    public void setCodeTypeProcess(String codeTypeProcess) {
        this.codeTypeProcess = codeTypeProcess;
    }

    /**
     * Getter de nbFichierOk
     * 
     * @return nbFichierOk
     */
    public int getNbFichierOk() {
        return nbFichierOk;
    }

    /**
     * Setter de nbFichierOk
     * 
     * @param nbFichierOk
     *            Le nombre de fichier ok
     */
    public void setNbFichierOk(int nbFichierOk) {
        this.nbFichierOk = nbFichierOk;
    }

    /**
     * Getter de libErreur
     * 
     * @return String
     */
    public String getLibErreur() {
        return libErreur;
    }

    /**
     * Setter de libErreur
     * 
     * @param libErreur
     *            Le libellé de l'erreur
     */
    public void setLibErreur(String libErreur) {
        this.libErreur = libErreur;
    }

    /**
     * Getter de numéro de l'erreur
     * 
     * @return int
     */
    public int getNumErreur() {
        return numErreur;
    }

    /**
     * Setter de numErreur
     * 
     * @param numErreur
     *            Le numéro de l'erreur
     */
    public void setNumErreur(int numErreur) {
        this.numErreur = numErreur;
    }

    /**
     * Getter de nbFichierATraiter
     * 
     * @return int.
     */
    public int getNbFichierATraiter() {
        return nbFichierATraiter;
    }

    /**
     * Setter de nbFichierATraiter
     * 
     * @param nbFichierATraiter
     *            Le nombre de fichier à traiter
     */
    public void setNbFichierATraiter(int nbFichierATraiter) {
        this.nbFichierATraiter = nbFichierATraiter;
    }

    /**
     * Setter de codeEtatProcess
     * 
     * @return String
     */
    public String getCodeEtatProcess() {
        return codeEtatProcess;
    }

    /**
     * Setter de codeEtatProcess
     * 
     * @param codeEtatProcess
     *            Le code état du process
     */
    public void setCodeEtatProcess(String codeEtatProcess) {
        this.codeEtatProcess = codeEtatProcess;
    }
}
