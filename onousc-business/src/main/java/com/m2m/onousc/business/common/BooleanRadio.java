/*
 * BooleanRadio.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.common;

import java.io.Serializable;

/**
 * Class boolean pour les radio à trois etat (utiliser dans la recherche par
 * criteria) The Class BooleanRadio.
 * 
 * @version 1.0 11 mars 2015
 * @author amtarji
 */
public class BooleanRadio implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8567545789387540489L;

	/** The bool. */
	private Boolean bool;

	/** The code. */
	private String code;
	
	private String prezKey;

	/**
	 * Instantiates a new boolean radio.
	 */
	public BooleanRadio() {
		super();
		this.bool = null;
		this.code = "TOUS";
	}

	/**
	 * Instantiates a new boolean radio.
	 * 
	 * @param bool
	 *            the bool
	 * @param code
	 *            the code
	 */
	public BooleanRadio(Boolean bool, String code,String prezKey) {
		super();
		this.bool = bool;
		this.code = code;
		this.prezKey = prezKey;
	}

	/**
	 * Gets the bool.
	 * 
	 * @return the bool
	 */
	public Boolean getBool() {
		return bool;
	}

	/**
	 * Sets the bool.
	 * 
	 * @param bool
	 *            the new bool
	 */
	public void setBool(Boolean bool) {
		this.bool = bool;
	}

	/**
	 * Gets the code.
	 * 
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 * 
	 * @param code
	 *            the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BooleanRadio other = (BooleanRadio) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	public String getPrezKey() {
		return prezKey;
	}

	public void setPrezKey(String prezKey) {
		this.prezKey = prezKey;
	}

}
