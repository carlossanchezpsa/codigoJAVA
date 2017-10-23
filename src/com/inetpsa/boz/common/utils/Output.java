/*
 * Créé le 3 févr. 2006
 *
 */
package com.inetpsa.boz.common.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

/**
 * Classe qui implémente l'ensemble des sorties des chaines X10
 * 
 * @author e210954
 *  
 */
public class Output {

    /** singleton */
    private static Output instance;

    /** Le writer sur le fichier */
    private static BufferedWriter bw;

    /**
     * On récupère l'instance du manager de logs
     * 
     * @return FileUtils
     */
    public static Output getInstance() {
        if (instance == null) {
            synchronized (Output.class) {
                if (instance == null) {
                    instance = new Output();
                }
            }
        }
        return instance;
    }

    /**
     * Initialise le fichier
     * 
     * @param fileName
     *            Le nom du fichier chemin absolu + nom *
     * @param theOption
     *            L'option
     */
    public static void init(String fileName, boolean theOption)  {
        File fl = new File(fileName);
        //
        //        if (!(new File(fl.getAbsolutePath())).exists()) {
        //            (new File(fl.getAbsolutePath())).mkdirs();
        //        }
        if (!(new File(fl.getParent())).exists()) {
            (new File(fl.getParent())).mkdirs();
        }

        bw = FileUtils.create(fl, theOption);
        getInstance();
    }

    /**
     * Initialise le fichier
     * 
     * @param directory
     *            Le répertoire
     * @param fileName
     *            Le nom du fichier
     */
    public static void init(String directory, String fileName)  {
        File fl = new File(directory + File.separator + fileName);

        if (!(new File(directory)).exists()) {
            (new File(directory)).mkdirs();
        }
        bw = FileUtils.create(fl);
        getInstance();
    }

    /**
     * Initialise le fichier
     * 
     * @param directory
     *            Le répertoire
     * @param fileName
     *            Le nom du fichier
     * @param theOption
     *            L'option
     */
    public static void init(String directory, String fileName, boolean theOption)  {
        File fl = new File(directory + File.separator + fileName);

        if (!(new File(directory)).exists()) {
            (new File(directory)).mkdirs();
        }
        bw = FileUtils.create(fl, theOption);
        getInstance();
    }

    /**
     * Ecrit une ligne dans le fichier
     * 
     * @param line
     *            La ligne de rejet
     * @throws IOException
     *             En cas de problème d'accès sur le fichier
     */
    public void write(String line) throws IOException {
        if (bw != null) {
            bw.write(line);
            bw.newLine();
        }
    }

    /**
     * Ecrit un séparateur de ligne dans le fichier
     * 
     * @throws IOException
     *             En cas de problème d'accès sur le fichier de rejet
     */
    public void newLine() throws IOException {
        if (bw != null)
            bw.newLine();
    }

    /**
     * Ferme le fichier de rejet
     * 
     * @throws IOException
     *             En cas de problème sur la fermeture du fichier de rejet
     */
    public void close() throws IOException {
        if (bw != null)
            bw.close();
    }

}