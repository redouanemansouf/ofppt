/*
 * CanalVenteVO.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.vo;

import java.util.Calendar;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.dao.impl.GenericEntity;
import com.m2m.technicalservices.validation.AlphaNum;
import com.m2m.technicalservices.validation.FixedSize;
import com.m2m.technicalservices.web.ISearchResultVO;

public class ExampleVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7539299426307518688L;

	/** The id. */
	private Long id;

	@NotNull
	@AlphaNum
	@Size(max = 30)
	private String libelle;

	@NotNull
	@FixedSize(size = 2)
	private String code;

	private Double doubleField;

	private Integer intField;

	@Size(max = 300)
	private String description;

	private Date date1 = new Date();

	private EntityStatus statut;

	private String typePp;

	public ExampleVO() {
		super();
	}

	/**
	 * Instantiates a new canal vente vo.
	 * 
	 * @param libelle
	 *            the libelle
	 * @param description
	 *            the description
	 */
	public ExampleVO(String libelle, String description) {
		super();
		this.libelle = libelle;
		this.description = description;
	}

	public ExampleVO(Long id, String libelle, String code, Double doubleField,
			Integer intField, String description, EntityStatus statut,
			String typePp) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.code = code;
		this.doubleField = doubleField;
		this.intField = intField;
		this.description = description;
		this.statut = statut;
		this.typePp = typePp;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 *            the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Gets the description.
	 * 
	 * @return the descpription
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 * 
	 * @param description
	 *            the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the statut.
	 * 
	 * @return the statut
	 */
	public EntityStatus getStatut() {
		return statut;
	}

	/**
	 * Sets the statut.
	 * 
	 * @param statut
	 *            the statut to set
	 */
	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.web.ISearchResultVO#getIdForSearch()
	 */
	@Override
	public String getIdForSearch() {
		return String.valueOf(this.id);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public ITransformer<? extends GenericEntity, ? extends ValueObject> getTransformer() {
		// TODO Auto-generated method stub
		return null;
	}

	public Double getDoubleField() {
		return doubleField;
	}

	public void setDoubleField(Double doubleField) {
		this.doubleField = doubleField;
	}

	public Integer getIntField() {
		return intField;
	}

	public void setIntField(Integer intField) {
		this.intField = intField;
	}

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public String getTypePp() {
		return typePp;
	}

	public void setTypePp(String typePp) {
		this.typePp = typePp;
	}

}
