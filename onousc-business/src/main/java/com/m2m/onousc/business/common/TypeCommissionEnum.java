/*
 * ActiviteMetierEnum.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.common;

/**
 * The Enum TypeCommissionEnum.
 */
public enum TypeCommissionEnum {

	/** The virement. */
	VIREMENT("VIREMENT"), /** The retenu source. */
	RETENU_SOURCE("RETENU_SOURCE"), /** The prepaye. */
	PREPAYE("PREPAYE");

	/** The type commission enum code. */
	private String typeCommissionEnumCode;

	/**
	 * Instantiates a new type commission enum.
	 *
	 * @param s
	 *            the s
	 */
	private TypeCommissionEnum(String s) {
		typeCommissionEnumCode = s;
	}

	/**
	 * Gets the type commission.
	 *
	 * @param typeCommissionEnumCode
	 *            the type commission enum code
	 * @return the type commission
	 */
	public static TypeCommissionEnum getTypeCommission(
			String typeCommissionEnumCode) {
		for (TypeCommissionEnum e : values()) {
			if (e.typeCommissionEnumCode.equals(typeCommissionEnumCode)) {
				return e;
			}
		}
		return null;
	}

	/**
	 * Gets the type commission enum code.
	 *
	 * @return the type commission enum code
	 */
	public String getTypeCommissionEnumCode() {
		return typeCommissionEnumCode;
	}

	/**
	 * Sets the type commission enum code.
	 *
	 * @param typeCommissionEnumCode
	 *            the new type commission enum code
	 */
	public void setTypeCommissionEnumCode(String typeCommissionEnumCode) {
		this.typeCommissionEnumCode = typeCommissionEnumCode;
	}

}
