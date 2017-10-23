package com.inetpsa.boz.vcm.start;

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

	/** Pr�fixe des fichiers en entr�e du traitement APV */
	private static String prefixFileNameAPV;

	/** Pr�fixe des fichiers en entr�e du traitement VN */
	private static String prefixFileNameVN;

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
		Context.setPrefixFileNameAPV(System
				.getProperty("BOZ_PREFIXE_IN_APV_LM"));
		Context.setPrefixFileNameVN(System.getProperty("BOZ_PREFIXE_IN_VN_LM"));

		System.out.println("System.getPropety(BOZ_PREFIXE_IN_APV_LM): "
				+ System.getProperty("BOZ_PREFIXE_IN_APV_LM"));
		System.out.println("System.getPropety(BOZ_PREFIXE_IN_VN_LM): "
				+ System.getProperty("BOZ_PREFIXE_IN_VN_LM"));
	}

	/**
	 * Getter de inputPath
	 * 
	 * @return Renvoie inputPath.
	 */
	public static String getInputPath() {
		System.out.println("getInputPath: " + inputPath);
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
	 * Getter de prefixFileNameAPV
	 * 
	 * @return String.
	 */
	public static String getPrefixFileNameAPV() {
		// System.out.println("getPrefixFileNameAPV: " + prefixFileNameAPV);
		// return prefixFileNameAPV;
		return "vm_apv";
	}

	/**
	 * Getter de prefixFileNameAPVPartiel
	 * 
	 * @return String.
	 */
	public static String getPrefixFileNameAPVPartiel() {
		// System.out.println("getPrefixFileNameAPV: " + prefixFileNameAPV);
		// return prefixFileNameAPV;
		return "vm_apv_partiel";
	}

	/**
	 * Getter de prefixFileNameAPVPartiel
	 * 
	 * @return String.
	 */
	public static String getPrefixFileNameAPVComplet() {
		// System.out.println("getPrefixFileNameAPV: " + prefixFileNameAPV);
		// return prefixFileNameAPV;
		return "vm_apv_complet";
	}

	/**
	 * Getter de prefixFileNameVN
	 * 
	 * @return String.
	 */
	public static String getPrefixFileNameVN() {
		// System.out.println("getPrefixFileNameVN: " + prefixFileNameVN);
		// return prefixFileNameVN;
		return "vm_vn";
	}

	/**
	 * Setter de prefixFileNameAPV
	 * 
	 * @param prefixFileName
	 *            Le pr�fixe des noms de fichier en entr�e APV
	 */
	public static void setPrefixFileNameAPV(String prefixFileName) {
		Context.prefixFileNameAPV = prefixFileName;
		// Context.prefixFileNameAPV = "VM_APV_";
	}

	/**
	 * Setter de prefixFileNameVN
	 * 
	 * @param prefixFileName
	 *            Le pr�fixe des noms de fichier en entr�e VN
	 */
	public static void setPrefixFileNameVN(String prefixFileName) {
		Context.prefixFileNameVN = prefixFileName;
	}
}
