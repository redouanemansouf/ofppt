package com.m2m.technicalservices.security;

import com.m2m.technicalservices.exception.FunctionalException;


public class AuthenticationException extends FunctionalException{
	public AuthenticationException() {
		super();
	}

	public AuthenticationException(String message) {
		super(message);		
	}

	public AuthenticationException(String message, Throwable cause) {
		super(message, cause);
	}

}
