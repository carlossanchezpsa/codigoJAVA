package com.inetpsa.boz.common.utils;

import com.inetpsa.boz.common.exception.BozException;
import com.inetpsa.boz.common.exception.BozExceptionFactory;

/**
 * Classe utilitaire permettant de manipuler des chaines de caract�res
 * 
 * @author e210954
 * @version 1.0.0
 */

public final class StringUtils {

	/**
	 * Constructeur priv�
	 */
	private StringUtils() {
	}

	/**
	 * V�rifie si la donn�e obligatoire paramName est null ou vide
	 * 
	 * @param paramName
	 *            nom du param�tre
	 * @param paramValues
	 *            valeur du param�tre
	 * @throws Si
	 *             le param�tre est null ou vide
	 */
	public static void checkMandatory(String paramValue, String paramName)
			throws BozException {
		if (paramValue == null || "".equals(paramValue.trim()))
			throw BozExceptionFactory.getInstance().newException(
					"Le champ suivant est manquant : " + paramName, 50);
	}

	/**
	 * Formattage d'une String. La m�thode remplace les chaines null par des
	 * chaines vides. Puis elle tronque la chaine � len si la taille est
	 * sup�rieure � len
	 * 
	 * @param str
	 *            La chaine de caract�re � formatter
	 * @param len
	 *            La longueur correspondant � la chaine de caract�re
	 */
	public static String formatString(String str, int len) {
		String chaine = "";
		if (str != null && str.trim().length() > len)
			chaine = str.trim().substring(0, len - 1);
		else if (str != null)
			chaine = str.trim();
		return chaine;
	}

	/**
	 * Validate the content of the fields in a XML file.
	 * 
	 * @param id
	 * @param type
	 * @param field
	 * @param text
	 * @return
	 */
	/*
	 * public static String getValidString(String field, String text) { //
	 * PrintWriter out = new PrintWriter(new BufferedWriter(Writer w));
	 * 
	 * if (text != null) { char[] chars = text.toCharArray();
	 * 
	 * for (int i = 0; i < chars.length; i++) {
	 * 
	 * char c = chars[i]; final char next_c = i + 1 < chars.length ? chars[i +
	 * 1] : '\0'; // if (!XMLChar.isValid(c)) { //System.out.println("next_c:" +
	 * next_c); if (c == '&' || (c == '>' && next_c == ' ') || (c == '<' &&
	 * next_c == ' ')) { /* Logear la linea del error
	 */
	/*
	 * String errorTxt = "An invalid caracter was found in: " + field +
	 * " value: '" + text; LoggerManager.getInstance().error(errorTxt);
	 * 
	 * /* Reemplazar caracter invalido por caracter valido Se realiza de esta
	 * manera, por si el el replace no encuentra el caracter invalido
	 */
	/*
	 * chars[i] = '-'; text = new String(chars); } } }
	 * 
	 * return text; }
	 */
}
