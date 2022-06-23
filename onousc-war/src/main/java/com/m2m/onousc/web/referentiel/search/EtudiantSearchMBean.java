/*
* CanalVenteSearchMBean.java
*
* Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
*/
package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.criteria.EtudiantCriteria;
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
public class EtudiantSearchMBean extends AbstractSearchMBean {



	/**
	 * 
	 */
	private static final long serialVersionUID = -4732054425502373397L;
	/** The canal vente criteria. */
	private EtudiantCriteria etudiantCriteria=new EtudiantCriteria();
	
	

	// private ReferentielSrvPresentation referentielSrvPresentation =
	// (ReferentielSrvPresentation) BeansLookuper
	// .lookup("referentielSrvPresentation");

	/**
	 * Instantiates a new canal vente search m bean.
	 */
	public EtudiantSearchMBean() {
		
		search = new EtudiantSearch();
		searchCriteria = etudiantCriteria;
		initData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.web.AbstractSearchMBean#initData()
	 */
	public void initData() {
		
		etudiantCriteria.setStatus(null);
		searchCriteria = etudiantCriteria;
		run();
	}

	/* (non-Javadoc)
	 * @see com.m2m.technicalservices.web.AbstractSearchMBean#resetSearchCriteria()
	 */
	public void resetSearchCriteria() {
		this.etudiantCriteria = new EtudiantCriteria();
		searchCriteria = etudiantCriteria;
	}

	public EtudiantCriteria getEtudiantCriteria() {
		return etudiantCriteria;
	}

	public void setEtudiantCriteria(EtudiantCriteria etudiantCriteria) {
		this.etudiantCriteria = etudiantCriteria;
	}

	

	
}
