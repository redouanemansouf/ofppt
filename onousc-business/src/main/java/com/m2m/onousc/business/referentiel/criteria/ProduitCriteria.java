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
 * 
 * 
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
public class ProduitCriteria extends BaseCriteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;

	private String libelle;

	private Double montant;

	private Double tva;

	private String codeBar;

	private Long familleProd;

	private Long idSite;

	public ProduitCriteria(String code, String libelle, Double montant, Double tva, String codeBar, Long familleProd,
			EntityStatus statut, SearchConfig config) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.montant = montant;
		this.tva = tva;
		this.codeBar = codeBar;
		this.familleProd = familleProd;
		this.setStatut(null);
		this.setSearchConfig(config);
		this.setSortField(null);
		this.setSortOrder(null);
	}

	public ProduitCriteria() {
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
			} else if (!t.isPrimitive() && !"sortField".equals(field) && !"sortOrder".equals(field) && v != null) {
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
		this.libelle = WebUtils.prepareForLikeStatement2(libelle);
	}

//	public void setLibelle(String libelle) {
//		this.libelle = libelle;
//	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Double getTva() {
		return tva;
	}

	public void setTva(Double tva) {
		this.tva = tva;
	}

	public String getCodeBar() {
		return codeBar;
	}

	public void setCodeBar(String codeBar) {
		this.codeBar = codeBar;
	}

	public Long getFamilleProd() {
		return familleProd;
	}

	public void setFamilleProd(Long familleProd) {
		this.familleProd = familleProd;
	}

	public Long getIdSite() {
		return idSite;
	}

	public void setIdSite(Long idSite) {
		this.idSite = idSite;
	}
}
