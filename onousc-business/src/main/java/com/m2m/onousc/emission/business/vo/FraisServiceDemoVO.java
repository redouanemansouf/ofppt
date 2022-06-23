/*
 * CanalVenteVO.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.emission.business.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.dao.impl.GenericEntity;
import com.m2m.technicalservices.validation.AlphaNum;
import com.m2m.technicalservices.web.ISearchResultVO;

public class FraisServiceDemoVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8739006120072437751L;

	/** The id. */
	private Long id;

	@NotNull
	@AlphaNum
	@Size(max = 30)
	private String libelle;

	@NotNull
	private String code;

	private String type;

	private Double taux;

	private Double fix;

	private Double forfait;

	private String periode;

	private EntityStatus statut;

	public FraisServiceDemoVO() {
		super();
	}

	public FraisServiceDemoVO(Long id, String libelle, String code,
			String type, Double taux, Double fix, Double forfait,
			String periode, EntityStatus statut) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.code = code;
		this.type = type;
		this.taux = taux;
		this.fix = fix;
		this.forfait = forfait;
		this.periode = periode;
		this.statut = statut;
	}

	@Override
	public String getIdForSearch() {
		return null;
	}

	@Override
	public ITransformer<? extends GenericEntity, ? extends ValueObject> getTransformer() {
		return null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

	public Double getFix() {
		return fix;
	}

	public void setFix(Double fix) {
		this.fix = fix;
	}

	public Double getForfait() {
		return forfait;
	}

	public void setForfait(Double forfait) {
		this.forfait = forfait;
	}

	public String getPeriode() {
		return periode;
	}

	public void setPeriode(String periode) {
		this.periode = periode;
	}

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

}
