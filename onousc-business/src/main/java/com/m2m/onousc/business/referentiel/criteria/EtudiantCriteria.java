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
public class EtudiantCriteria extends BaseCriteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4275920863207859859L;

	private Long ann_universitaire;

	private String Ndemande;

	private String Nom;

	private String Prenom;

	private String NCIN;

	private Boolean Boursier;

	private Boolean Resident;

	private String Etablissement;

	private String Email;

	private String status;

	private Long idSite;

	private Long cite;

	private Long restaurant;
	private String typePersonelle;
	
	public EtudiantCriteria() {

	}

	public EtudiantCriteria(Long ann_universitaire, String ndemande, String nom, String prenom, String nCIN,
			Boolean boursier, Boolean resident, String etablissement, String email, String status, Long cite,
			Long restaurant) {
		super();
		this.ann_universitaire = ann_universitaire;
		Ndemande = ndemande;
		Nom = nom;
		Prenom = prenom;
		NCIN = nCIN;
		Boursier = boursier;
		Resident = resident;
		Etablissement = etablissement;
		Email = email;
		this.status = status;
		this.cite = cite;
		this.restaurant = restaurant;
	}

	public EtudiantCriteria(Long ann_universitaire, String ndemande, String nom, String prenom, String nCIN,
			Boolean boursier, Boolean resident, String etablissement, String email, Long cite, Long restaurant,
			SearchConfig config) {
		super();
		this.ann_universitaire = ann_universitaire;
		Ndemande = ndemande;
		Nom = nom;
		Prenom = prenom;
		NCIN = nCIN;
		Boursier = boursier;
		Resident = resident;
		Etablissement = etablissement;
		Email = email;
		this.cite = cite;
		this.restaurant = restaurant;
		this.setStatut(statut);
		this.setSearchConfig(config);
		this.setSortField(null);
		this.setSortOrder(null);
	}

	public Long getAnn_universitaire() {
		return ann_universitaire;
	}

	public void setAnn_universitaire(Long ann_universitaire) {
		this.ann_universitaire = ann_universitaire;
	}

	public String getNdemande() {
		return Ndemande;
	}

	public void setNdemande(String ndemande) {
		Ndemande = WebUtils.prepareForLikeStatement(ndemande);
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = WebUtils.prepareForLikeStatement(nom);
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = WebUtils.prepareForLikeStatement(prenom);
	}

	public String getNCIN() {
		return NCIN;
	}

	public void setNCIN(String nCIN) {
		NCIN = WebUtils.prepareForLikeStatement(nCIN);
	}

	public Boolean getBoursier() {
		return Boursier;
	}

	public void setBoursier(Boolean boursier) {
		Boursier = boursier;
	}

	public Boolean getResident() {
		return Resident;
	}

	public void setResident(Boolean resident) {
		Resident = resident;
	}

	public String getEtablissement() {
		return Etablissement;
	}

	public void setEtablissement(String etablissement) {
		Etablissement = WebUtils.prepareForLikeStatement(etablissement);
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = WebUtils.prepareForLikeStatement(email);
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCite() {
		return cite;
	}

	public void setCite(Long cite) {
		this.cite = cite;
	}

	public Long getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Long restaurant) {
		this.restaurant = restaurant;
	}

	public Long getIdSite() {
		return idSite;
	}

	public void setIdSite(Long idSite) {
		this.idSite = idSite;
	}

	public String getTypePersonelle() {
		return typePersonelle;
	}

	public void setTypePersonelle(String typePersonelle) {
		this.typePersonelle = typePersonelle;
	}

}
