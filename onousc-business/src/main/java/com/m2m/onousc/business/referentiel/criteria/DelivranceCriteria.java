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
import com.m2m.onousc.business.referentiel.model.Etudiants;
import com.m2m.technicalservices.web.SearchConfig;

/**
 * The Class CanalVenteCriteria.
 * 
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
public class DelivranceCriteria extends BaseCriteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3371195845335712067L;
	private Date dateDelivrance;
	private String categorie;
	private Etudiants etudiant;

	private Date dateDelivranceAu;

	private Long cite;

	private Long idSite;

	// private EntityStatus statut;

	public DelivranceCriteria() {

	}

	public DelivranceCriteria(Etudiants etudiant, Date dateDelivrance, String categorie, EntityStatus statut,
			SearchConfig config) {
		super();

		this.setEtudiant(etudiant);
		this.setDateDelivrance(dateDelivrance);
		this.setCategorie(categorie);
		this.setStatut(statut);
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

	public Etudiants getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiants etudiant) {
		this.etudiant = etudiant;
	}

	public Date getDateDelivrance() {
		return dateDelivrance;
	}

	public void setDateDelivrance(Date dateDelivrance) {
		this.dateDelivrance = dateDelivrance;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = WebUtils.prepareForLikeStatement(categorie);
	}

	public Date getDateDelivranceAu() {
		return dateDelivranceAu;
	}

	public void setDateDelivranceAu(Date dateDelivranceAu) {
		this.dateDelivranceAu = dateDelivranceAu;
	}

	public Long getCite() {
		return cite;
	}

	public void setCite(Long cite) {
		this.cite = cite;
	}

	public Long getIdSite() {
		return idSite;
	}

	public void setIdSite(Long idSite) {
		this.idSite = idSite;
	}

}
