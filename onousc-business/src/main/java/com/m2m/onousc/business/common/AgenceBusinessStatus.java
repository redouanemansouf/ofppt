/*
 * EntityStatus.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.common;

/**
 * The Enum AgenceBusinessStatus.
 */
public enum AgenceBusinessStatus {

	/** The incomplete. */
	CLOSED("CLOSED", "is-closed"),

	/** The suspended. */
	SUSPENDED("SUSPENDED", "is-suspended"),

	/** The en prod. */
	EN_PROD("EN_PROD", "in-prod"),

	/** The en test. */
	EN_TEST("EN_TEST", "in-test"),

	/** The need validation. */
	NEED_VALIDATION("NEED_VALIDATION", "need-validation");

	/** The status code. */
	private String statusCode;

	/** The status css class. */
	private String statusCSSClass;

	/**
	 * Instantiates a new entity status.
	 *
	 * @param s
	 *            the s
	 * @param styleClass
	 *            the style class
	 */
	private AgenceBusinessStatus(String s, String styleClass) {
		statusCode = s;
		statusCSSClass = styleClass;
	}

	/**
	 * Gets the status code.
	 * 
	 * @return the status code
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * Gets the statut.
	 * 
	 * @param statutCode
	 *            the statut code
	 * @return the statut
	 */
	public static AgenceBusinessStatus getStatut(String statutCode) {
		for (AgenceBusinessStatus e : values()) {
			if (e.statusCode.equals(statutCode)) {
				return e;
			}
		}
		return null;
	}

	/**
	 * Gets the status css class.
	 *
	 * @return the status css class
	 */
	public String getStatusCSSClass() {
		return statusCSSClass;
	}

	/**
	 * Sets the status css class.
	 *
	 * @param statusCSSClass
	 *            the new status css class
	 */
	public void setStatusCSSClass(String statusCSSClass) {
		this.statusCSSClass = statusCSSClass;
	}
}
