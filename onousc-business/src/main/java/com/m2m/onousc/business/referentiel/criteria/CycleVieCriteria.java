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
public class CycleVieCriteria extends BaseCriteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5144669346808367915L;

	private Long id;

	private Long citeId;

	private String numSerie;

	private Long numPorteur;

	private String operation;

	private Date dateOperation;

	private String operateur;

	private String cin;

	private String codeMassar;

	private EntityStatus statut;

	private Long idSite;

	public CycleVieCriteria() {

	}

	public CycleVieCriteria(Long id, String numSerie, Long numPorteur, String operation, Date dateOperation,
			String operateur, String cin, EntityStatus statut) {
		super();
		this.setId(id);
		this.setNumSerie(numSerie);
		this.setNumPorteur(numPorteur);
		this.setOperation(operation);
		this.setDateOperation(dateOperation);
		this.setCin(cin);
		this.setOperateur(operateur);
		this.statut = statut;
	}

	public CycleVieCriteria(Long id, String numSerie, Long numPorteur, String operation, Date dateOperation,
			String operateur, String cin, EntityStatus statut, SearchConfig config) {
		super();
		this.setId(id);
		this.setNumSerie(numSerie);
		this.setNumPorteur(numPorteur);
		this.setOperation(operation);
		this.setDateOperation(dateOperation);
		this.setOperateur(operateur);
		this.setCin(cin);
		this.statut = statut;
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
			} else if (!t.isPrimitive() && !"sortField".equals(field) && !"sortOrder".equals(field) && v != null) {
				filter = true;
				break;
			}
		}
		if (getStatut() != null)
			filter = true;

		setActiveFilter(filter);

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		this.operation = WebUtils.prepareForLikeStatement(operation);
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public String getOperateur() {
		return operateur;
	}

	public void setOperateur(String operateur) {
		this.operateur = WebUtils.prepareForLikeStatement(operateur);
	}

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getCodeMassar() {
		return codeMassar;
	}

	public void setCodeMassar(String codeMassar) {
		this.codeMassar = codeMassar;
	}

	public Long getCiteId() {
		return citeId;
	}

	public void setCiteId(Long citeId) {
		this.citeId = citeId;
	}

	public Long getIdSite() {
		return idSite;
	}

	public void setIdSite(Long idSite) {
		this.idSite = idSite;
	}

}
