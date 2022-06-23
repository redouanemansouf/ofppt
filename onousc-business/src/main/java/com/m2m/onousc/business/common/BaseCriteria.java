/*
 * BaseCriteria.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.common;

import java.io.Serializable;
import java.lang.reflect.Field;

import com.m2m.technicalservices.web.SearchConfig;

/**
 * La Class BaseCriteria.
 * 
 * @version 1.0 19 févr. 2015
 * @author aelhachimi
 */
public abstract class BaseCriteria implements Serializable {

	/** Le/La Constant serialVersionUID. */
	private static final long serialVersionUID = 2507137339878321696L;

	/** Le/La sort order. */
	protected String sortOrder;

	/** Le/La sort field. */
	protected String sortField;

	/** Le/La statut. */
	protected EntityStatus statut;

	/** Le/La search config. */
	protected SearchConfig searchConfig;

	protected boolean activeFilter;

	/**
	 * Recupère le status code.
	 * 
	 * @return le status code
	 */
	public String getStatusCode() {
		return statut == null ? null : this.statut.getStatusCode();
	}

	/**
	 * Sets the status code.
	 * 
	 * @param statusCode
	 *            the new status code
	 */
	public void setStatusCode(String statusCode) {
		this.statut = EntityStatus.getStatut(statusCode);
	}

	/**
	 * Recupère le sort order.
	 * 
	 * @return le sort order
	 */
	public String getSortOrder() {
		return sortOrder;
	}

	/**
	 * Sets the sort order.
	 * 
	 * @param sortOrder
	 *            the new sort order
	 */
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder != null ? sortOrder : "DESC";
	}

	/**
	 * Recupère le sort field.
	 * 
	 * @return le sort field
	 */
	public String getSortField() {
		return sortField;
	}

	/**
	 * Sets the sort field.
	 * 
	 * @param sortField
	 *            the new sort field
	 */
	public void setSortField(String sortField) {
		this.sortField = sortField != null ? "x." + sortField : "x.id";
	}

	/**
	 * Recupère le statut.
	 * 
	 * @return le statut
	 */
	public EntityStatus getStatut() {
		return statut;
	}

	/**
	 * Sets the statut.
	 * 
	 * @param statut
	 *            the new statut
	 */
	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	/**
	 * Recupère le search config.
	 * 
	 * @return le search config
	 */
	public SearchConfig getSearchConfig() {
		return searchConfig;
	}

	/**
	 * Sets the search config.
	 * 
	 * @param searchConfig
	 *            the new search config
	 */
	public void setSearchConfig(SearchConfig searchConfig) {
		this.searchConfig = searchConfig;
	}

	public boolean isActiveFilter() {
		return activeFilter;
	}

	public void setActiveFilter(boolean activeFilter) {
		this.activeFilter = activeFilter;
	}

	
}
