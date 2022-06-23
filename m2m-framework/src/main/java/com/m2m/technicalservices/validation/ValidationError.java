package com.m2m.technicalservices.validation;

import java.io.Serializable;

public class ValidationError implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 696783114781097825L;

	private String champ;
	private String value;
	private String message;

	public ValidationError(String champ, String value, String message) {
		this.champ = champ;
		this.value = value;
		this.message = message;

	}

	public String getChamp() {
		return champ;
	}

	public void setChamp(String champ) {
		this.champ = champ;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ValidationError [champ=" + champ + ", value=" + value
				+ ", message=" + message + "]";
	}

}
