package com.m2m.technicalservices.exception;

import java.io.Serializable;

/**
 * generic class for all functional exceptions
 * 
 * @author Younes SOUTEH
 * 
 */
public class FunctionalException extends RuntimeException implements
		Serializable {

	private static final long serialVersionUID = 7552671441723224932L;

	protected final String localisationClass;
	protected final String localisationMethod;

	public FunctionalException() {
		super();
		localisationClass = "";
		localisationMethod = "";
	}

	public FunctionalException(String message) {
		super(message);
		localisationClass = "";
		localisationMethod = "";
	}

	public FunctionalException(String message, Throwable cause) {
		super(message, cause);
		localisationClass = "";
		localisationMethod = "";
	}

	public FunctionalException(Throwable cause) {
		super(cause);
		localisationClass = "";
		localisationMethod = "";
	}

	public FunctionalException(String clazz, String method, String message) {
		super(message);
		localisationClass = clazz;
		localisationMethod = method;
	}

	public FunctionalException(String clazz, String method, String message,
			Throwable cause) {
		super(message, cause);
		localisationClass = clazz;
		localisationMethod = method;
	}

	public String getLocalisationClasse() {
		return localisationClass;
	}

	public String getLocalisationMethod() {
		return localisationMethod;
	}

	public String getLocalisation() {
		return localisationClass + "." + localisationMethod;
	}

}
