package com.m2m.technicalservices.exception;

import java.io.Serializable;

/**
 * generic class for all technical exceptions
 * 
 * @author Younes SOUTEH
 * 
 */
public class TechnicalException extends RuntimeException implements
		Serializable {

	private static final long serialVersionUID = 7552671441723224932L;

	protected final String localisationClass;
	protected final String localisationMethod;

	public TechnicalException() {
		super();
		localisationClass = "";
		localisationMethod = "";
	}

	public TechnicalException(String message) {
		super(message);
		localisationClass = "";
		localisationMethod = "";
	}

	public TechnicalException(String message, Throwable cause) {
		super(message, cause);
		localisationClass = "";
		localisationMethod = "";
	}

	public TechnicalException(Throwable cause) {
		super(cause);
		localisationClass = "";
		localisationMethod = "";
	}

	public TechnicalException(String clazz, String method, String message) {
		super(message);
		localisationClass = clazz;
		localisationMethod = method;
	}

	public TechnicalException(String clazz, String method, String message,
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
