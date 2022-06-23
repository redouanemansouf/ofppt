/*
* CanalVenteSearchMBean.java
*
* Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
*/
package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.ProduitCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

// TODO: Auto-generated Javadoc
/**
 * The Class CanalVenteSearchMBean.
 *
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
@ManagedBean
@ViewScoped
public class ProduitSearchMBean extends AbstractSearchMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5070915603237054848L;
	/** The canal vente criteria. */
	private ProduitCriteria produitCriteria = new ProduitCriteria();

	// private ReferentielSrvPresentation referentielSrvPresentation =
	// (ReferentielSrvPresentation) BeansLookuper
	// .lookup("referentielSrvPresentation");

	/**
	 * Instantiates a new canal vente search m bean.
	 */
	public ProduitSearchMBean() {
		search = new ProduitSearch();
		searchCriteria = produitCriteria;
		initData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.web.AbstractSearchMBean#initData()
	 */
	public void initData() {
		searchCriteria = produitCriteria;
		run();
	}

	public void resetSearchCriteria() {
		this.produitCriteria = new ProduitCriteria();
		searchCriteria = produitCriteria;
	}

	public ProduitCriteria getProduitCriteria() {
		return produitCriteria;
	}

	public void setProduitCriteria(ProduitCriteria produitCriteria) {
		this.produitCriteria = produitCriteria;
	}

}
