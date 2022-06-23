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
public class ProfilPorteurCriteria extends BaseCriteria implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 5945797246288620220L;

	private String code;

	private String libelle;

	private String categorie;

	private Integer ratio;
	
	



	public ProfilPorteurCriteria() {

	}

	
	public ProfilPorteurCriteria(String code, String libelle, String categorie,
			Integer ratio) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.categorie = categorie;
		this.ratio = ratio;
	}


	public ProfilPorteurCriteria(String code, String libelle, String categorie,
			Integer ratio , SearchConfig config) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.categorie = categorie;
		this.ratio = ratio;
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


	public String getCategorie() {
		return categorie;
	}


	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}


	public Integer getRatio() {
		return ratio;
	}


	public void setRatio(Integer ratio) {
		this.ratio = ratio;
	}


	
}
