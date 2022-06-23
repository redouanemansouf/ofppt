/*
 * JoursEnum.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.common;

/**
 * La Enum JoursEnum.
 * 
 * @version 1.0 10 mars 2015
 * @author aelhachimi
 */
public enum JoursEnum {

	/** Le/La lundi. */
	LUNDI("Lundi", 0),

	/** Le/La mardi. */
	MARDI("Mardi", 1),
	/** Le/La mercredi. */
	MERCREDI("Mercredi", 2),

	/** Le/La jeudi. */
	JEUDI("Jeudi", 3),

	/** Le/La vendredi. */
	VENDREDI("Vendredi", 4),

	/** Le/La samedi. */
	SAMEDI("Samedi", 5),

	/** Le/La dimanche. */
	DIMANCHE("Dimanche", 6);

	/** Le/La jours code. */
	private String joursCode;
	private int order;

	/**
	 * Instantiates a new jours enum.
	 * 
	 * @param code
	 *            the code
	 */
	private JoursEnum(String code, int order) {
		this.joursCode = code;
		this.order = order;
	}

	/**
	 * Recupère le jours code.
	 * 
	 * @return the joursCode
	 */
	public String getJoursCode() {
		return joursCode;
	}

	/**
	 * Recupère le jour.
	 * 
	 * @param jourCode
	 *            the jour code
	 * @return le jour
	 */
	public static JoursEnum getJour(String jourCode) {
		for (JoursEnum e : values()) {
			if (e.joursCode.equals(jourCode)) {
				return e;
			}
		}
		return null;
	}

	public static JoursEnum getJour(int order) {
		for (JoursEnum e : values()) {
			if (e.getOrder() == order) {
				return e;
			}
		}
		return null;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

}
