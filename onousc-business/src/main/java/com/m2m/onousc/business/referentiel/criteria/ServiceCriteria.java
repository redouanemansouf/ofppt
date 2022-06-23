/*
 * ServiceCriteria.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
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
 * 
 * @author abousnane
 * 
 */

public class ServiceCriteria extends BaseCriteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7233541826275881320L;
	/**
	 * 
	 */
	/** code **/
	private String code;
	/** The libelle. */
	private String libelle;

	/** Date debut. */
	private Date heureDebut;

	/** Date Fin. */
	private Date heureFin;

	private String plafond;

	public ServiceCriteria() {
		super();
		this.code = null;
		this.libelle = null;
		this.heureDebut = null;
		this.heureFin = null;
		this.plafond = null;
	}

	public ServiceCriteria(String code, String libelle, Date date_debut,
			Date date_fin, String plafond, EntityStatus statut,
			SearchConfig config) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.heureDebut = date_debut;
		this.heureFin = date_fin;
		this.plafond = plafond;
		this.setStatut(statut);
		this.setSearchConfig(config);
		this.setSortField(null);
		this.setSortOrder(null);
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
		this.libelle = WebUtils.prepareForLikeStatement(libelle);
	}

	/**
	 * Gets the heure debut.
	 * 
	 * @return the heure debut
	 */
	public Date getHeureDebut() {
		return heureDebut;
	}

	/**
	 * Sets the heure debut.
	 * 
	 * @param heureDebut
	 *            the new heure debut
	 */
	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}

	public Date getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}

	public String getPlafond() {
		return plafond;
	}

	public void setPlafond(String plafond) {
		this.plafond = plafond;
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
