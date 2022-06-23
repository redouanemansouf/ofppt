/*
 * CanalVenteCriteria.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.criteria;

import java.io.Serializable;
import java.lang.reflect.Field;

import com.m2m.onousc.business.common.BaseCriteria;
import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.common.WebUtils;
import com.m2m.technicalservices.web.SearchConfig;

/**
 * The Class CanalVenteCriteria.
 * 
 * @version 1.0 24 nov. 2014
 * @author aelhachimi
 */
public class CanalVenteCriteria extends BaseCriteria implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2155707631019533790L;
	
	private Long id;
	private String code;

	/** The libelle. */
	private String libelle;
	
	private Long idSite;

	/** The description. */
	private String description;

	public CanalVenteCriteria() {
		super();
		this.code = null;
		this.libelle = null;
		this.description = null;
	}

	public CanalVenteCriteria(String libelle, String code , String description,
			EntityStatus statut, SearchConfig config) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.description = description;
		this.setStatut(statut);
		this.setSearchConfig(config);
		this.setSortField(null);
		this.setSortOrder(null);
	}

	/**
	 * Gets the libelle.
	 * 
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Sets the libelle.
	 * 
	 * @param libelle
	 *            the new libelle
	 */
	public void setLibelle(String libelle) {
		// using '%' for like search
//		this.libelle = WebUtils.prepareForLikeStatement(libelle);
		this.libelle = libelle;
	}

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 * 
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = WebUtils.prepareForLikeStatement(description);
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdSite() {
		return idSite;
	}

	public void setIdSite(Long idSite) {
		this.idSite = idSite;
	}
	
}
