/*
 * Cr�� le 17 janv. 2006
 */
package com.inetpsa.boz.common.dao;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.inetpsa.boz.common.context.BozContext;
import com.inetpsa.boz.common.log.LoggerManager;

/**
 * Classe m�re de toutes les dao des batchs X10
 * 
 * @author e210954
 * 
 */
public class BozDao {

	/** bundle contenant les resources */
	protected ResourceBundle bundle;

	/**
	 * Constructeur priv�
	 * 
	 * @param resource
	 *            Le nom du fichier de ressource
	 */
	protected BozDao(String resource) {
		try {
			bundle = ResourceBundle.getBundle(resource);
		} catch (MissingResourceException missException) {
			LoggerManager.getInstance().error(
					"Fichier de ressource :" + resource + " manquant");
		}
	}

	/**
	 * Retourne une requete � partir de son nom
	 * 
	 * @param name
	 *            Le nom de la requete dans le fichier de ressource
	 * @return La requ�te SQL
	 */
	public String getQuery(String name) {
		String str = bundle.getString(name);
		return (str.replaceAll("\"OWNER\"", BozContext.getDbOwner()))
				.replaceAll("PRD", BozContext.getPrd());
	}

}