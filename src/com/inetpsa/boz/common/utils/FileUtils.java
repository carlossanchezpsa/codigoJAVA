package com.inetpsa.boz.common.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;

import com.inetpsa.boz.common.log.LoggerManager;

/**
 * Classe utilitaire pour la manipulation des fichiers
 * 
 * @author e210954
 */
public final class FileUtils {

	/**
	 * Limit on the number of characters that may be read while still preserving
	 * the mark
	 */
	public static final int READ_AHEAD_VALUE = 1000;

	/**
	 * Contruteur priv�
	 */
	private FileUtils() {

	}

	/**
	 * Construit un BufferedReader du fichier pass� en param�tre
	 * 
	 * @param file
	 *            File fichier � parser
	 * @param encoding
	 *            L'encoding de lecture du fichier
	 * 
	 * @return br BufferedReader buffer du fichier source
	 */
	public static BufferedReader read(File file, String encoding) {
		BufferedReader br = null;
		try {

			InputStream ips = new FileInputStream(file);
			InputStreamReader ipsr = new InputStreamReader(ips, encoding);
			br = new BufferedReader(ipsr);

		} catch (FileNotFoundException fnfex) {
			LoggerManager.getInstance().error("Le fichier " + file + " n'a pas ete trouve");
		} catch (UnsupportedEncodingException ueex) {
			LoggerManager.getInstance().error("L'encoding " + encoding + " n'est pas support�");
		}
		return br;
	}

	/**
	 * Construit un BufferedReader du fichier pass� en param�tre
	 * 
	 * @param file
	 *            File fichier � parser
	 * 
	 * @return br BufferedReader buffer du fichier source
	 */
	public static BufferedReader read(File file) {
		BufferedReader br = null;
		try {
			InputStream ips = new FileInputStream(file);
			InputStreamReader ipsr = new InputStreamReader(ips);
			br = new BufferedReader(ipsr);
		} catch (FileNotFoundException fnfex) {
			LoggerManager.getInstance().error("Le fichier " + file + " n'a pas ete trouve");
		}
		return br;
	}

	/**
	 * Construit un BufferedWriter du fichier pass� en param�tre
	 * 
	 * @param file
	 *            File fichier � parser
	 * @return br BufferedWriter buffer du fichier cible
	 */
	public static BufferedWriter create(File file) {

		return create(file, true);
	}

	/**
	 * Construit un BufferedWriter du fichier pass� en param�tre
	 * 
	 * @param file
	 *            File fichier � parser
	 * @param theOption
	 *            true pour conserver les donn�es false pour effacer
	 * @return br BufferedWriter buffer du fichier cible
	 */
	public static BufferedWriter create(File file, boolean theOption) {
		BufferedWriter bw = null;
		try {
			// On �crase le contenu du fichier
			OutputStream ops = new FileOutputStream(file, theOption);
			OutputStreamWriter opsr = new OutputStreamWriter(ops);
			bw = new BufferedWriter(opsr);
		} catch (FileNotFoundException fnfex) {
			LoggerManager.getInstance().error("Le fichier " + file + " n'a pas ete cree");
		}
		return bw;
	}

	/**
	 * Construit un BufferedWriter du fichier pass� en param�tre
	 * 
	 * @param file
	 *            File fichier � parser
	 * @param theOption
	 *            true pour consever les donn�es false pour effacer
	 * @param encoding
	 *            L'encoding
	 * @throws UnsupportedEncodingException
	 *             en cas d'erreur d'encodage
	 * @return br BufferedWriter buffer du fichier cible
	 */
	public static BufferedWriter create(File file, boolean theOption, String encoding) throws UnsupportedEncodingException {
		BufferedWriter bw = null;
		try {
			// On �crase le contenu du fichier
			OutputStream ops = new FileOutputStream(file, theOption);
			OutputStreamWriter opsr = new OutputStreamWriter(ops, encoding);
			bw = new BufferedWriter(opsr);
		} catch (FileNotFoundException fnfex) {
			LoggerManager.getInstance().error("Le fichier " + file + " n'a pas ete cree");
		}
		return bw;
	}

	/**
	 * Supprime un fichier
	 * 
	 * @param file
	 *            File fichier � parser
	 * @return true/false
	 */
	public static boolean deleteFile(File file) {
		return file.delete();
	}

	/**
	 * Mark un bufferedReader
	 * 
	 * @param br
	 *            Le reader sur le fichier
	 * @throws IOException
	 *             En cas d'impossibilit� de poser une marque
	 * @return br
	 */
	public static BufferedReader mark(BufferedReader br) throws IOException {
		br.mark(READ_AHEAD_VALUE);
		return br;
	}

	/**
	 * Reset un bufferedReader
	 * 
	 * @param br
	 *            Le reader sur le fichier
	 * @throws IOException
	 *             En cas d'impossibilit� de poser une marque
	 * @return br
	 */
	public static BufferedReader reset(BufferedReader br) throws IOException {
		br.reset();
		return br;
	}

	/**
	 * Close un bufferedReader
	 * 
	 * @param br
	 *            Le reader sur le fichier
	 * @throws IOException
	 *             En cas d'impossibilit� de poser une marque
	 * @return br
	 */
	public static BufferedReader close(BufferedReader br) throws IOException {
		if (br != null) {
			br.close();
		}
		return null;
	}

	/**
	 * Liste les fichiers contenus dans un r�pertoire dont le nom ne termine pas
	 * par le pattern
	 * 
	 * @param dir
	 *            Le r�pertoire d'entr�e
	 * @return File
	 */
	public static File[] listFiles(String dir) {
		File file = new File(dir);

		return file.listFiles();

	}

	/**
	 * Liste les fichiers contenus dans un r�pertoire dont le nom ne termine pas
	 * par le pattern
	 * 
	 * @param dir
	 *            Le r�pertoire d'entr�e
	 * @param pattern
	 *            Le pattern des fichiers � exclure
	 * @return File
	 */
	public static File[] listFilterFiles(String dir, String pattern) {

		File file = new File(dir);

		if (file.list(new SimpleFileFilter(pattern)) != null) {
			File[] fl = new File[file.listFiles(new SimpleFileFilter(pattern)).length];
			fl = file.listFiles(new SimpleFileFilter(pattern));
			return fl;
		}

		/*
		 * String[] listaArchivos = file.list(); for (int i = 0; i <
		 * listaArchivos.length; i++) { System.out.println(listaArchivos[i]); }
		 */
		return null;
	}

	/**
	 * Compte le nombre deligne dans le fichier pass� en param�tre
	 * 
	 * @param br
	 *            Le reader sur le fichier
	 * @return Le nombre de ligne
	 * @throws IOException
	 *             En cas d'erreur de lecture du fichier
	 */
	public static int countLineNumber(BufferedReader br) throws IOException {
		int nbLine = 0;
		while (br != null && br.readLine() != null)
			nbLine++;
		return nbLine;
	}

	/**
	 * Compte le nombre deligne dans le fichier pass� en param�tre
	 * 
	 * @param br
	 *            Le reader sur le fichier
	 * @return Le nombre de ligne
	 * @throws IOException
	 *             En cas d'erreur de lecture du fichier
	 */
	public static BufferedWriter ReplaceAmpersands(File file, String encoding) throws IOException {

		InputStream ips = new FileInputStream(file);
		InputStreamReader ipsr = new InputStreamReader(ips, encoding);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		BufferedReader reader = new BufferedReader(ipsr);
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(baos));

		String line = null;
		while ((line = reader.readLine()) != null) {
			line = line.replaceAll("&", "&amp;");
			writer.write(line);
			writer.newLine();
		}
		writer.flush();
		writer.close();
		reader.close();
		return writer;

	}

	/**
	 * Copie de fichier de in vers out
	 * 
	 */
	public static void copyFile(File in, File out) throws Exception {
		FileChannel sourceChannel = new FileInputStream(in).getChannel();
		FileChannel destinationChannel = new FileOutputStream(out).getChannel();
		sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);
		sourceChannel.close();
		destinationChannel.close();
	}
}