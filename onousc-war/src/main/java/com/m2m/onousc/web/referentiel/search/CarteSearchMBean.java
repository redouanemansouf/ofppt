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
public class CarteSearchMBean extends AbstractSearchMBean {



	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1715422869684794078L;
	private CarteCriteria carteCriteria=new CarteCriteria();
	
	


	public CarteSearchMBean() {
		
		search = new CarteSearch();
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
		this.carteCriteria = new CarteCriteria();
		searchCriteria = carteCriteria;
	}

	public CarteCriteria getCarteCriteria() {
		return carteCriteria;
	}

	public void setCarteCriteria(CarteCriteria carteCriteria) {
		this.carteCriteria = carteCriteria;
	}

	

	

	

	
}
