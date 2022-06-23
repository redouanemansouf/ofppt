/*
 * OrdreJourEnum.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.common;

/**
 * La Enum OrdreJourEnum.
 * 
 * @version 1.0 11 mars 2015
 * @author aelhachimi
 */
public enum OrdreJourEnum {

	/** Le/La premier. */
	Premier(1),

	/** Le/La deuxieme. */
	Deuxième(2),

	/** Le/La troisieme. */
	Troisième(3),

	/** Le/La quatrieme. */
	Quatrième(4),

	/** Le/La dernier. */
	Dernier(100);

	/** Le/La ordre jour code. */
	private Integer ordreJourCode;

	/**
	 * Instantiates a new ordre jour enum.
	 * 
	 * @param code
	 *            the code
	 */
	private OrdreJourEnum(Integer code) {
		this.ordreJourCode = code;
	}

	/**
	 * Recupère le ordre jour code.
	 * 
	 * @return le ordre jour code
	 */
	public Integer getOrdreJourCode() {
		return ordreJourCode;
	}

	/**
	 * Recupère le mois.
	 * 
	 * @param ordreJourCode
	 *            the ordre jour code
	 * @return le mois
	 */
	public static OrdreJourEnum getMois(String ordreJourCode) {
		for (OrdreJourEnum e : values()) {
			if (e.ordreJourCode.equals(ordreJourCode)) {
				return e;
			}
		}
		return null;
	}

}
