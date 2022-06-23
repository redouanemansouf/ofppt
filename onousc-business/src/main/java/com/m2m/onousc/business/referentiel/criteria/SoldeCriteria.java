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
import com.m2m.technicalservices.web.SearchConfig;

/**
 * The Class CanalVenteCriteria.
 * 
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
public class SoldeCriteria extends BaseCriteria implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = -1820452889995944311L;

	private String matr;

	private Date dated;

	private Date datef;

	private Long idSite;

	public String getMatr() {
		return matr;
	}

	public void setMatr(String matr) {
		this.matr = matr;
	}

	public Date getDated() {
		return dated;
	}

	public void setDated(Date dated) {
		this.dated = dated;
	}

	public Date getDatef() {
		return datef;
	}

	public void setDatef(Date datef) {
		this.datef = datef;
	}

	public SoldeCriteria() {

	}

	public SoldeCriteria(String matr, Date dated, Date datef) {
		super();
		this.matr = matr;
		this.dated = dated;
		this.datef = datef;
	}

	public SoldeCriteria(String matr, Date dated, Date datef, SearchConfig config) {
		super();
		this.matr = matr;
		this.dated = dated;
		this.datef = datef;
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

	public Long getIdSite() {
		return idSite;
	}

	public void setIdSite(Long idSite) {
		this.idSite = idSite;
	}

}
