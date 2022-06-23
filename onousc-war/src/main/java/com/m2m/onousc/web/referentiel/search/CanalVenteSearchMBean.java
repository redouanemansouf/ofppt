/*
* CanalVenteSearchMBean.java
*
* Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
*/
package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.CanalVenteCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

// TODO: Auto-generated Javadoc
/**
 * The Class CanalVenteSearchMBean.
 *
 * @version 1.0 24 nov. 2014
 * @author aelhachimi
 */
@ManagedBean
@ViewScoped
public class CanalVenteSearchMBean extends AbstractSearchMBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -546184694019534842L;

	/** The canal vente criteria. */
	private CanalVenteCriteria canalVenteCriteria = new CanalVenteCriteria();

	// private ReferentielSrvPresentation referentielSrvPresentation =
	// (ReferentielSrvPresentation) BeansLookuper
	// .lookup("referentielSrvPresentation");

	/**
	 * Instantiates a new canal vente search m bean.
	 */
	public CanalVenteSearchMBean() {
		search = new CanalVenteSearch();
		searchCriteria = canalVenteCriteria;
		initData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.web.AbstractSearchMBean#initData()
	 */
	public void initData() {

		searchCriteria = canalVenteCriteria;
		run();
	}

	/* (non-Javadoc)
	 * @see com.m2m.technicalservices.web.AbstractSearchMBean#resetSearchCriteria()
	 */
	public void resetSearchCriteria() {
		this.canalVenteCriteria = new CanalVenteCriteria();
		searchCriteria = canalVenteCriteria;
	}

	/**
	 * Gets the canal vente criteria.
	 *
	 * @return the canalVenteCriteria
	 */
	public CanalVenteCriteria getCanalVenteCriteria() {
		return canalVenteCriteria;
	}

	/**
	 * Sets the canal vente criteria.
	 *
	 * @param canalVenteCriteria
	 *            the canalVenteCriteria to set
	 */
	public void setCanalVenteCriteria(CanalVenteCriteria canalVenteCriteria) {
		this.canalVenteCriteria = canalVenteCriteria;
	}
}
