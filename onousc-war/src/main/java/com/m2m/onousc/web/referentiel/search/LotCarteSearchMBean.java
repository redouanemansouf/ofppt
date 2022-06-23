/*
* CanalVenteSearchMBean.java
*
* Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
*/
package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.CarteCriteria;
import com.m2m.onousc.business.referentiel.criteria.CycleVieCriteria;
import com.m2m.onousc.business.referentiel.criteria.LotCarteCriteria;
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
public class LotCarteSearchMBean extends AbstractSearchMBean {



	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6084837209475339589L;
	private LotCarteCriteria carteCriteria=new LotCarteCriteria();
	
	


	public LotCarteSearchMBean() {
		
		search = new LotCarteSearch();
		searchCriteria = carteCriteria;
		initData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.web.AbstractSearchMBean#initData()
	 */
	public void initData() {
		
		
		searchCriteria = carteCriteria;
		run();
	}

	/* (non-Javadoc)
	 * @see com.m2m.technicalservices.web.AbstractSearchMBean#resetSearchCriteria()
	 */
	public void resetSearchCriteria() {
		this.carteCriteria = new LotCarteCriteria();
		searchCriteria = carteCriteria;
	}

	public LotCarteCriteria getCarteCriteria() {
		return carteCriteria;
	}

	public void setCarteCriteria(LotCarteCriteria carteCriteria) {
		this.carteCriteria = carteCriteria;
	}

	
	

	

	

	
}
