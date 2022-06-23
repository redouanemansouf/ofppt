/*
 * Utils.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */

package com.m2m.onousc.business.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.m2m.technicalservices.log.ILogger;
import com.m2m.technicalservices.log.impl.SL4JLogger;

// TODO: Auto-generated Javadoc
/**
 * The Class Utils.
 * 
 * @version 1.0 20 nov. 2014
 * @author aelhachimi
 */
/**
 * @author yaalou
 *
 */
/**
 * @author yaalou
 *
 */
/**
 * @author yaalou
 * 
 */
public class Utils {

	/** The logger. */
	private static ILogger logger = SL4JLogger.getInstance(Utils.class);

	/**
	 * Instantiates a new utils.
	 */
	private Utils() {
	}

	/**
	 * Serialize object to json string.
	 * 
	 * @param sourceObject
	 *            the source object
	 * @return the string
	 */
	public static String serializeObjectToJsonString(Object sourceObject) {
		String jsonString = "";
		try {
			ObjectMapper objectMapper = getObjectMapper();

			jsonString = objectMapper.writeValueAsString(sourceObject);

		} catch (JsonGenerationException | JsonMappingException e) {
			jsonString = sourceObject.toString();
			logger.error("JSON Serialization error", e);

		} catch (IOException e) {
			jsonString = sourceObject.toString();
			logger.error("JSON Serialization error", e);

		}
		return jsonString;
	}

	/**
	 * Gets the object mapper.
	 * 
	 * @return the object mapper
	 */
	private static ObjectMapper getObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();

		objectMapper.setVisibilityChecker(objectMapper.getSerializationConfig()
				.getDefaultVisibilityChecker()
				.withFieldVisibility(Visibility.ANY)
				.withGetterVisibility(Visibility.NONE)
				.withSetterVisibility(Visibility.NONE)
				.withCreatorVisibility(Visibility.NONE));
		return objectMapper;
	}

	/**
	 * Complet chaine : entre ("test","x",6) --> "xxtest"
	 * 
	 * @param input
	 *            the chaine à completer
	 * @param var
	 *            the caractere à utiliser
	 * @param taille
	 *            the taille de la chaine de retour
	 * @return the string
	 */
	public static String completChaine(String input, String var, int taille) {

		if (input.length() < taille) {
			input = StringUtils.repeat(var, taille - input.length()) + input;
		}
		return input;

	}
	
	public static String controlePWD(String pwd){
  		if(StringUtils.isEmpty(pwd)) {
			return "0";
		}
		if(pwd.length()<6 || pwd.length()>20){
			return "1";
		}
		if(!Pattern.compile("[0-9]").matcher(pwd).find()){
			return "2";
		}
		if(!Pattern.compile("[a-zA-Z]").matcher(pwd).find()){
			return "3";
		}
		return null;
	}

	public static File creerFichir(String nomFichier,String repertoire,String extention) {
		try{
			SimpleDateFormat format= new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			String dateJour=format.format(new Date());
			Path folder = Paths.get(repertoire);
			String fileName = FilenameUtils.getBaseName(nomFichier);
			Path pathFile = Files.createTempFile(folder, fileName+"_"+dateJour+ "_", "."+ extention);
			File file = new File(pathFile.toString());
			return file;
		}catch(Exception e){
			e.printStackTrace();
			return null;

		}
	}

}
