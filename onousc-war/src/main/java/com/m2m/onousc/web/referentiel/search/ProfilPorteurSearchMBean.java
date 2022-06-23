/*
* CanalVenteSearchMBean.java
*
* Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
*/
package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.CarteCriteria;
import com.m2m.onousc.business.referentiel.criteria.CarteNapsCriteria;
import com.m2m.onousc.business.referentiel.criteria.CycleVieCriteria;
import com.m2m.onousc.business.referentiel.criteria.ProfilPorteurCriteria;
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
public class ProfilPorteurSearchMBean extends AbstractSearchMBean {



	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7857498088992303747L;
	/**
	 * 
	 */
	
	private ProfilPorteurCriteria profilporteurCriteria=new ProfilPorteurCriteria();
	
	


	public ProfilPorteurSearchMBean() {
		
		search = new ProfilPorteurSearch();
		searchCriteria = profilporteurCriteria;
		initData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.web.AbstractSearchMBean#initData()
	 */
	public void initData() {
		
		
		searchCriteria = profilporteurCriteria;
		run();
	}

	/* (non-Javadoc)
	 * @see com.m2m.technicalservices.web.AbstractSearchMBean#resetSearchCriteria()
	 */
	public void resetSearchCriteria() {
		this.profilporteurCriteria = new ProfilPorteurCriteria();
		searchCriteria = profilporteurCriteria;
	}

	public ProfilPorteurCriteria getProfilporteurCriteria() {
		return profilporteurCriteria;
	}

	public void setProfilporteurCriteria(ProfilPorteurCriteria profilporteurCriteria) {
		this.profilporteurCriteria = profilporteurCriteria;
	}

	
}
