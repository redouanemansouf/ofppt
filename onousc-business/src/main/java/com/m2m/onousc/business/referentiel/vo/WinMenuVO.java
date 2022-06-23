/*
 * NationaliteVO.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.vo;

import com.m2m.onousc.business.referentiel.vo.transformer.WinMenuVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.dao.impl.GenericEntity;
import com.m2m.technicalservices.web.ISearchResultVO;

/**
 * The Class WinMenuVO.
 * 
 * @version 1.0 24 oct. 2015
 *
 * @author iissouani
 *
 */
public class WinMenuVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;  
	
	private String id;

	private String code;

	private String libelle; 

	private String abbrev;
	
	private String langue;
	

	private String operateur;

	private boolean droitCreat;

	private boolean droitModif;

	private boolean droitSuppr;

	private boolean droitConsult;

	private boolean actif;
	private String type;
	private String menuLevel;
	private String statut;
	private String groupOperateur;
	
	public WinMenuVO() {

	}



	/**
	 * @param code
	 * @param libelle
	 * @param abbrev
	 * @param langue
	 * @param operateur
	 * @param droitCreat
	 * @param droitModif
	 * @param droitSuppr
	 * @param droitConsult
	 * @param actif
	 * @param type
	 */
	public WinMenuVO(String code, String libelle, String abbrev, String langue,
			String operateur, boolean droitCreat, boolean droitModif,
			boolean droitSuppr, boolean droitConsult, boolean actif, String type) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.abbrev = abbrev;
		this.langue = langue;
		this.operateur = operateur;
		this.droitCreat = droitCreat;
		this.droitModif = droitModif;
		this.droitSuppr = droitSuppr;
		this.droitConsult = droitConsult;
		this.actif = actif;
		this.type = type;
	}
	
	/**
	 * @param code
	 * @param libelle
	 * @param abbrev
	 * @param langue
	 * @param operateur
	 * @param type
	 */
	public WinMenuVO(String code, String libelle, String abbrev, String langue,
			String operateur, String type) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.abbrev = abbrev;
		this.langue = langue;
		this.operateur = operateur;
		this.droitCreat = false;
		this.droitModif = false;
		this.droitSuppr = false;
		this.droitConsult = false;
		this.actif = false;
		this.type = type;
	}



	@Override
	public ITransformer<? extends GenericEntity, ? extends ValueObject> getTransformer() {
		return new WinMenuVOTransformer(); 
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getAbbrev() {
		return abbrev;
	}

	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public String getOperateur() {
		return operateur;
	}

	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}

	public boolean isDroitCreat() {
		return droitCreat;
	}

	public void setDroitCreat(boolean droitCreat) {
		this.droitCreat = droitCreat;
	}

	public boolean isDroitModif() {
		return droitModif;
	}

	public void setDroitModif(boolean droitModif) {
		this.droitModif = droitModif;
	}

	public boolean isDroitSuppr() {
		return droitSuppr;
	}

	public void setDroitSuppr(boolean droitSuppr) {
		this.droitSuppr = droitSuppr;
	}

	public boolean isDroitConsult() {
		return droitConsult;
	}

	public void setDroitConsult(boolean droitConsult) {
		this.droitConsult = droitConsult;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public String getType() {
		return type;
	}

	/**
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String getIdForSearch() {
		return null; 
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getStatut() {
		return statut;
	}



	public void setStatut(String statut) {
		this.statut = statut;
	}



	public String getGroupOperateur() {
		return groupOperateur;
	}



	public void setGroupOperateur(String groupOperateur) {
		this.groupOperateur = groupOperateur;
	}



	public String getMenuLevel() {
		return menuLevel;
	}



	public void setMenuLevel(String menuLevel) {
		this.menuLevel = menuLevel;
	}
	
	

}
