/*
 * EntityStatus.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.common;

/**
 * The Enum EntityStatus.
 * 
 * @author M.BEN BOUBKER
 */
public enum EntityStatus {

	/** The enabled. */
	ENABLED("ENABLED", "is-enabled"),
	/** The disabled. */
	DISABLED("DISABLED", "is-disabled"),
	/** The deleted. */
	DELETED("DELETED", "is-deleted"),

	/** The incomplete. */
	INCOMPLETE("INCOMPLETE", "is-incomplete"),

	PERSONALIZED("PERSONALIZED", "is-personalize"),

	/****/
	/** The incomplete. */
	VALIDATED("VALIDATED", "is-validate"),

	/** The incomplete. */
	CLOSED("CLOSED", "is-closed"),

	//DILVRED("DELIVRED", "is-delevred"), 
   DELIVRED("DELIVRED", "is-delevred"),

	/** The suspended. */
	SUSPENDED("SUSPENDED", "is-suspended"),
	
	REJECTED("REJECTED", "is-rejected"),

	/** The opposed. */
	OPPOSED("OPPOSED", "is-opposed"), RESCIND("RESCIND", "is-rescind"), RENEWED("RENEWED", "is-renewed"),
	ACTIVATED("ACTIVATED", "is-activated"), PERSONALIZEDOPPO("PERSONALIZEDOPPO", "is-personalizeoppo"),
	DELIVREDOPPO("DELIVREDOPPO", "is-delevredoppo"), ACTIVATEDOPPO("ACTIVATEDOPPO", "is-activatedoppo");

	/** The status code. */
	private String statusCode;

	private String statusCSSClass;

	/**
	 * Instantiates a new entity status.
	 * 
	 * @param s the s
	 */
	private EntityStatus(String s, String styleClass) {
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
	 * @param statutCode the statut code
	 * @return the statut
	 */
	public static EntityStatus getStatut(String statutCode) {
		for (EntityStatus e : values()) {
			if (e.statusCode.equals(statutCode)) {
				return e;
			}
		}
		return null;
	}

	public String getStatusCSSClass() {
		return statusCSSClass;
	}

	public void setStatusCSSClass(String statusCSSClass) {
		this.statusCSSClass = statusCSSClass;
	}
}
