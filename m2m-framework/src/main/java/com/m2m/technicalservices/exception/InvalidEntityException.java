package com.m2m.technicalservices.exception;


/**
 * Invalid market functional exception
 * 
 * @author Clara
 *
 */public class InvalidEntityException extends FunctionalException {

	private static final long serialVersionUID = -3041264286403948893L;

	public InvalidEntityException() {
		super();
	}

	public InvalidEntityException(String message) {
		super(message);
	}

	public InvalidEntityException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidEntityException(Throwable cause) {
		super(cause);
	}

	public InvalidEntityException(String clazz, String method, String message) {
		super(clazz, method, message);
	}

	public InvalidEntityException(String clazz, String method, String message, Throwable cause) {
		super(clazz, method, message, cause);
	}	

}
