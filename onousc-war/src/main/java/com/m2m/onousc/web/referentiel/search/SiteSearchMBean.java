/*
* SiteSearchMBean.java
*
* Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
*/
package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.SiteCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

// TODO: Auto-generated Javadoc
/**
 * The Class SiteSearchMBean.
 *
 * @version 1.0 24 nov. 2014
 * @author aelhachimi
 */
@ManagedBean
@ViewScoped
public class SiteSearchMBean extends AbstractSearchMBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -546184694019534842L;

	/** The canal vente criteria. */
	private SiteCriteria siteCriteria = new SiteCriteria();

	// private ReferentielSrvPresentation referentielSrvPresentation =
	// (ReferentielSrvPresentation) BeansLookuper
	// .lookup("referentielSrvPresentation");

	/**
	 * Instantiates a new canal vente search m bean.
	 */
	public SiteSearchMBean() {
		search = new SiteSearch();
		searchCriteria = siteCriteria;
		initData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.web.AbstractSearchMBean#initData()
	 */
	public void initData() {

		searchCriteria = siteCriteria;
		run();
	}

	/* (non-Javadoc)
	 * @see com.m2m.technicalservices.web.AbstractSearchMBean#resetSearchCriteria()
	 */
	public void resetSearchCriteria() {
		this.siteCriteria = new SiteCriteria();
		searchCriteria = siteCriteria;
	}

	/**
	 * Gets the canal vente criteria.
	 *
	 * @return the siteCriteria
	 */
	public SiteCriteria getSiteCriteria() {
		return siteCriteria;
	}

	/**
	 * Sets the canal vente criteria.
	 *
	 * @param siteCriteria
	 *            the siteCriteria to set
	 */
	public void setSiteCriteria(SiteCriteria siteCriteria) {
		this.siteCriteria = siteCriteria;
	}
}
