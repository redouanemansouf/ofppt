package com.m2m.technicalservices.exception;


/**
 * Invalid market functional exception
 * 
 * @author Clara
 *
 */public class InvalidObjectException extends FunctionalException {

	private static final long serialVersionUID = -3041264286403948893L;

	public InvalidObjectException(String message) {
		super(message);
	}

	public InvalidObjectException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidObjectException(Throwable cause) {
		super(cause);
	}

	public InvalidObjectException(String clazz, String method, String message) {
		super(clazz, method, message);
	}

	public InvalidObjectException(String clazz, String method, String message, Throwable cause) {
		super(clazz, method, message, cause);
	}	

}
