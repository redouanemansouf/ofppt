/*
 * MoisEnum.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.common;

/**
 * La Enum MoisEnum.
 * 
 * @version 1.0 11 mars 2015
 * @author aelhachimi
 */
public enum MoisEnum {

	/** Le/La janvier. */
	JANVIER("Janvier"),

	/** Le/La fevrier. */
	FEVRIER("F�vrier"),

	/** Le/La mars. */
	MARS("Mars"),

	/** Le/La avril. */
	AVRIL("Avril"),

	/** Le/La mai. */
	MAI("Mai"),

	/** Le/La juin. */
	JUIN("Juin"),

	/** Le/La juillet. */
	JUILLET("Juillet"),

	/** Le/La A o� t. */
	AO�T("Ao�t"),

	/** Le/La septembre. */
	SEPTEMBRE("Septembre"),

	/** Le/La octobre. */
	OCTOBRE("Octobre"),

	/** Le/La novembre. */
	NOVEMBRE("Novembre"),

	/** Le/La decembre. */
	DECEMBRE("D�cembre");

	/** Le/La mois code. */
	private String moisCode;

	/**
	 * Instantiates a new mois enum.
	 * 
	 * @param code
	 *            the code
	 */
	private MoisEnum(String code) {
		this.moisCode = code;
	}

	/**
	 * Recup�re le mois code.
	 * 
	 * @return le mois code
	 */
	public String getMoisCode() {
		return moisCode;
	}

	/**
	 * Recup�re le mois.
	 * 
	 * @param moisCode
	 *            the mois code
	 * @return le mois
	 */
	public static MoisEnum getMois(String moisCode) {
		for (MoisEnum e : values()) {
			if (e.moisCode.equals(moisCode)) {
				return e;
			}
		}
		return null;
	}
}
