package com.m2m.technicalservices.security;

import com.m2m.technicalservices.exception.FunctionalException;


public class AutorizationException extends FunctionalException{
	public AutorizationException() {
		super();
	}

	public AutorizationException(String message) {
		super(message);		
	}

	public AutorizationException(String message, Throwable cause) {
		super(message, cause);
	}

}
