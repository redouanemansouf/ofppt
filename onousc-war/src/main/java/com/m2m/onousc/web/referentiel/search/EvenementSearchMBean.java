/*
 * CanalVenteSearchMBean.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.EvenementCriteria;
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
public class EvenementSearchMBean extends AbstractSearchMBean {



	/**
	 * 
	 */
	private static final long serialVersionUID = 4712088712376159079L;
	private EvenementCriteria criteria=new EvenementCriteria();


	public EvenementSearchMBean() {
		search = new EvenementSearch();
		searchCriteria = criteria;
		initData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.web.AbstractSearchMBean#initData()
	 */
	public void initData() {
		searchCriteria = criteria;
		run();
	}

	public void resetSearchCriteria() {
		this.criteria = new EvenementCriteria();
		searchCriteria = criteria;
	}

	public EvenementCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(EvenementCriteria criteria) {
		this.criteria = criteria;
	}

	

}
