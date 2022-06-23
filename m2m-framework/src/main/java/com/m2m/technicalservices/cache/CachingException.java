package com.m2m.technicalservices.cache;

import com.m2m.technicalservices.exception.TechnicalException;

/**
 * Exception qui encapsule les execptions jetés par le service de cache.
 * 
 * @version 1.0
 * @author @Younes SOUTEH
 */

public class CachingException extends TechnicalException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1048475681557204952L;

	public CachingException(String msg) {
		super(msg);
	}
}
