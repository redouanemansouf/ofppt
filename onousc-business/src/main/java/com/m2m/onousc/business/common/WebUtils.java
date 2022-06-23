/*
 * WebUtils.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.common;

/**
 * The Class WebUtils.
 * 
 * @author A.EL HACHIMI ALAOUI
 */
public class WebUtils {

	/**
	 * Instantiates a new web utils.
	 */
	private WebUtils() {
	}

	/**
	 * Prepare for like statement.
	 * 
	 * @param str
	 *            the str
	 * @param startWith
	 *            the start with
	 * @return the string
	 */
	public static String prepareForLikeStatement(String str,
			boolean... startWith) {
		if (startWith.length > 0 && startWith[0]) {
			str = str != null ? str + "%" : str;
		} else {
			str = str != null ? "%" + str + "%" : str;
		}
		return str;
	}
	
	public static String prepareForLikeStatement2(String str,
            boolean... startWith) {
     if (startWith.length > 0 && startWith[0]) {
            str = str != null ? str + "%" : str;
     } else {
            str = str != null ? "%" + str + "%" : str;
     }
     return str;
}

}
