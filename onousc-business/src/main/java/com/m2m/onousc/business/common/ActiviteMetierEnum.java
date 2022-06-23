/*
 * ActiviteMetierEnum.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.common;

/**
 * The Enum ActiviteMetierEnum.
 * 
 * @version 1.0 29 avr. 2015
 * @author yaalou
 */
public enum ActiviteMetierEnum {

	/** The interurbain. */
	INTERURBAIN("INTERURBAIN", "IU"),

	/** The international. */
	INTERNATIONAL("INTERNATIONAL", "IN");

	/** The activite metier code. */
	private String activiteMetierCode;

	private String abreviation;

	/**
	 * Instantiates a new activite metier enum.
	 * 
	 * @param s
	 *            the s
	 */
	private ActiviteMetierEnum(String s, String abrv) {
		activiteMetierCode = s;
		abreviation = abrv;
	}

	/**
	 * Gets the activite metier code.
	 * 
	 * @return the activite metier code
	 */
	public String getActiviteMetierCode() {
		return activiteMetierCode;
	}

	/**
	 * Gets the activite metier.
	 * 
	 * @param activiteMetierCode
	 *            the activite metier code
	 * @return the activite metier
	 */
	public static ActiviteMetierEnum getActiviteMetier(String activiteMetierCode) {
		for (ActiviteMetierEnum e : values()) {
			if (e.activiteMetierCode.equals(activiteMetierCode)) {
				return e;
			}
		}
		return null;
	}

	public String getAbreviation() {
		return abreviation;
	}

	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
	}
}
