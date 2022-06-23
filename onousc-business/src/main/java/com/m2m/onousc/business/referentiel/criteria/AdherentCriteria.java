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
 * @author msadik
 */
public class AdherentCriteria extends BaseCriteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 782774681599883039L;

	private String matr;
	private String nom;
	private String prenom;
	private String cni;
	private Long  personnel;

	public AdherentCriteria(String matr, String nom, String prenom,
			String cni,Long  personnel,  EntityStatus statut, SearchConfig config) {
		super();
		this.setMatr(matr);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setCni(cni);
		this.personnel=personnel;
		this.setStatut(null);
		this.setSearchConfig(config);
		this.setSortField(null);
		this.setSortOrder(null);
	}

	public AdherentCriteria() {
		// TODO Auto-generated constructor stub
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

	public String getMatr() {
		return matr;
	}

	public void setMatr(String matr) {
		this.matr = matr;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = WebUtils.prepareForLikeStatement(nom);
	}

	public String getCni() {
		return cni;
	}

	public void setCni(String cni) {
		this.cni = cni;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom =WebUtils.prepareForLikeStatement(prenom);
	}

	public Long getPersonnel() {
		return personnel;
	}

	public void setPersonnel(Long personnel) {
		this.personnel = personnel;
	}
}
