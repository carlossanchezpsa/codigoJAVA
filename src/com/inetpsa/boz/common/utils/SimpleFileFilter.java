package com.inetpsa.boz.common.utils;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Classe qui implemente le filtrage de fichier
 * 
 * @author e210954
 * 
 */
public class SimpleFileFilter implements FilenameFilter {
	/** pattern des fichiers a traiter */
	private String m_ext;

	/**
	 * Constructeur
	 * 
	 * @param ext
	 *            Le pattern
	 */
	public SimpleFileFilter(String ext) {
		m_ext = ext;
	}

	/**
	 * Implemente l'interface accept de la classe FilenameFilter
	 * 
	 * @param name
	 *            Le nom des fichiers
	 * @param dir
	 *            Le chemin absolu
	 * @return true/false
	 */
	public boolean accept(File dir, String name) {

		if (name.toLowerCase().startsWith(m_ext))
			// if (name.toUpperCase().startsWith(m_ext))
			// if (name.toLowerCase().endsWith(m_ext))
			return true;

		return false;
	}

}