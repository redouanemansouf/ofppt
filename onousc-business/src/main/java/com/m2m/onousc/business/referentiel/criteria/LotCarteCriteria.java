/*
 * CanalVenteCriteria.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.criteria;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import com.m2m.onousc.business.common.BaseCriteria;
import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.common.WebUtils;
import com.m2m.technicalservices.web.SearchConfig;

/**
 * The Class CanalVenteCriteria.
 * 
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
public class LotCarteCriteria extends BaseCriteria implements Serializable {





	/**
	 * 
	 */
	private static final long serialVersionUID = 2274785048145063618L;



	private String numSerie;

	private Long numPorteur;

	private String operation;

	private String numeroCarte;
	
	private Long idCite;
	
	private String  operateur;



	public LotCarteCriteria() {

	}

	
	public LotCarteCriteria(String numSerie, Long numPorteur, String operation,
			String numeroCarte,Long idCite, String  operateur) {
		super();
		this.numSerie = numSerie;
		this.numPorteur = numPorteur;
		this.operation = operation;
		this.numeroCarte = numeroCarte;
		this.idCite=idCite;
		this.operateur=operateur;
	}


	public LotCarteCriteria(String numSerie, Long numPorteur, String operation,
	String numeroCarte,Long idCite, String  operateur,SearchConfig config) {
		super();
		this.numSerie = numSerie;
		this.numPorteur = numPorteur;
		this.operation = operation;
		this.numeroCarte = numeroCarte;
		this.idCite=idCite;
		this.operateur=operateur;
		this.setStatut(null);
		this.setSearchConfig(config);
		this.setSortField(null);
		this.setSortOrder(null);
	}

	@SuppressWarnings("rawtypes")
	public void activeCriteria() {
		boolean filter = false;
		for (Field field : this.getClass().getDeclaredFields()) {
			Class t = field.getType();
			Object v = null;
			try {
				v = field.get(this);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TO-DO
			}
			if (t == EntityStatus.class && v != null) {
				filter = true;
				break;
			} else if (!t.isPrimitive() && !"sortField".equals(field)
					&& !"sortOrder".equals(field) && v != null) {
				filter = true;
				break;
			}
		}
		if (getStatut() != null)
			filter = true;

		setActiveFilter(filter);

	}


	public String getNumSerie() {
		return numSerie;
	}


	public void setNumSerie(String numSerie) {
		this.numSerie = WebUtils.prepareForLikeStatement(numSerie);
	}


	public Long getNumPorteur() {
		return numPorteur;
	}


	public void setNumPorteur(Long numPorteur) {
		this.numPorteur = numPorteur;
	}


	public String getOperation() {
		return operation;
	}


	public void setOperation(String operation) {
		this.operation = operation;
	}


	public String getNumeroCarte() {
		return numeroCarte;
	}


	public void setNumeroCarte(String numeroCarte) {
		this.numeroCarte = WebUtils.prepareForLikeStatement(numeroCarte);
	}


	public Long getIdCite() {
		return idCite;
	}


	public void setIdCite(Long idCite) {
		this.idCite = idCite;
	}


	public String getOperateur() {
		return operateur;
	}


	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}

	
}
