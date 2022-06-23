package com.m2m.technicalservices.core;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 783358076185183527L;

	private String id;

	private String code;

	private String site;

	private String libelle;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public User(String id, String code) {
		super();
		this.id = id;
		this.code = code;
	}

	public User() {
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

}
