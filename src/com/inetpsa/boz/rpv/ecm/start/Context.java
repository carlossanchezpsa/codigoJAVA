package com.inetpsa.boz.rpv.ecm.start;

import java.io.IOException;

/**
 * Classe qui d�finit le contexte du batch
 * 
 * @author e210954
 */
public final class Context {

	/**
	 * Constructeur priv�
	 */
	private Context() {
	}

	/** Chemin vers le fichier de rejet */
	private static String rejectPath;

	/** R�pertoire de stockage des fichiers provenant des OLM */
	private static String inputPath;

	/** R�pertoire de stockage des fichiers valides en fin de traitement */
	private static String outputPath;

	/** Pr�fixe des fichiers en entr�e du traitement */
	private static String prefixFileName;

	/**
	 * Setter du contexte
	 * 
	 * @param filePathName
	 *            chemin vers le fichier de config throws
	 * @throws IOException
	 *             En cas de probleme avec le fichier de config
	 */
	public static void setContext() throws IOException {

		Context.setInputPath(System.getProperty("BOZ_REP_IN"));
		Context.setRejectPath(System.getProperty("BOZ_REP_REJET"));
		Context.setOutputPath(System.getProperty("BOZ_REP_VALIDE"));
		Context.setPrefixFileName(System.getProperty("BOZ_PREFIXE_IN"));

	}

	/**
	 * Getter de inputPath
	 * 
	 * @return Renvoie inputPath.
	 */
	public static String getInputPath() {
		return inputPath;
	}

	/**
	 * Setter de inputPath
	 * 
	 * @param inputPath
	 *            Le chemin o� sont stock� les fichiers PS
	 */
	public static void setInputPath(String inputPath) {
		Context.inputPath = inputPath;
	}

	/**
	 * Getter de rejectPath
	 * 
	 * @return rejectPath
	 */
	public static String getRejectPath() {
		return rejectPath;
	}

	/**
	 * Setter de rejectPath
	 * 
	 * @param rejectPath
	 *            Le chemin vers le fichier de rejet
	 * 
	 */
	public static void setRejectPath(String rejectPath) {
		Context.rejectPath = rejectPath;
	}

	/**
	 * Getter de outputPath
	 * 
	 * @return String.
	 */
	public static String getOutputPath() {
		return outputPath;
	}

	/**
	 * Setter de outputPath
	 * 
	 * @param outputPath
	 *            Le chemin de stockage des fichiers valides
	 */
	public static void setOutputPath(String outputPath) {
		Context.outputPath = outputPath;
	}

	/**
	 * Getter de prefixFileName
	 * 
	 * @return String.
	 */
	public static String getPrefixFileName() {
		return prefixFileName;
	}

	/**
	 * Setter de prefixFileName
	 * 
	 * @param prefixFileName
	 *            Le pr�fixe des noms de fichier en entr�e
	 */
	public static void setPrefixFileName(String prefixFileName) {
		Context.prefixFileName = prefixFileName;
	}
}
