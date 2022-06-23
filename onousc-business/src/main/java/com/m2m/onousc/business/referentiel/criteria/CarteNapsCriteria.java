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
import com.m2m.technicalservices.web.SearchConfig;

/**
 * The Class CanalVenteCriteria.
 * 
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
public class CarteNapsCriteria extends BaseCriteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1820452889995944311L;

	private String nom;

	private String prenom;

	private String numidentite;

	private String matr;
	
	private Long idSite;
	

	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getNumidentite() {
		return numidentite;
	}


	public void setNumidentite(String numidentite) {
		this.numidentite = numidentite;
	}




	public String getMatr() {
		return matr;
	}


	public void setMatr(String matr) {
		this.matr = matr;
	}


	public CarteNapsCriteria() {

	}

	public Long getIdSite() {
		return idSite;
	}


	public void setIdSite(Long idSite) {
		this.idSite = idSite;
	}


	public CarteNapsCriteria(String nom, String prenom, String numidentite, String matr, Long idSite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numidentite = numidentite;
		this.matr = matr;
		this.idSite = idSite;
	}


	public CarteNapsCriteria(String nom, String prenom, String numidentite,
	String refetud , SearchConfig config) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numidentite = numidentite;
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


	
}
