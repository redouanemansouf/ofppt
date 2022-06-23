/*
 * CanalVenteVO.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.emission.business.vo;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.dao.impl.GenericEntity;
import com.m2m.technicalservices.web.ISearchResultVO;

public class ModeReglementDemoVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9083696819312329427L;

	/** The id. */
	private Long id;

	private String typeOperation;
	private String origineTransaction;

	private String typeDebit;
	private Double periode;
	private Double periodeInvalidite;

	private EntityStatus statut;

	public ModeReglementDemoVO() {
		super();
	}

	public ModeReglementDemoVO(Long id, String typeOperation,
			String origineTransaction, String typeDebit, Double periode,
			Double periodeInvalidite) {
		super();
		this.id = id;
		this.typeOperation = typeOperation;
		this.origineTransaction = origineTransaction;
		this.typeDebit = typeDebit;
		this.periode = periode;
		this.periodeInvalidite = periodeInvalidite;
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

	public String getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}

	public String getOrigineTransaction() {
		return origineTransaction;
	}

	public void setOrigineTransaction(String origineTransaction) {
		this.origineTransaction = origineTransaction;
	}

	public String getTypeDebit() {
		return typeDebit;
	}

	public void setTypeDebit(String typeDebit) {
		this.typeDebit = typeDebit;
	}

	public Double getPeriode() {
		return periode;
	}

	public void setPeriode(Double periode) {
		this.periode = periode;
	}

	public Double getPeriodeInvalidite() {
		return periodeInvalidite;
	}

	public void setPeriodeInvalidite(Double periodeInvalidite) {
		this.periodeInvalidite = periodeInvalidite;
	}

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

}
