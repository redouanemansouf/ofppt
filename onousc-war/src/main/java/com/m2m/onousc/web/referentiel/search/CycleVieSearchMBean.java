/*
* CanalVenteSearchMBean.java
*
* Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
*/
package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
public class CycleVieSearchMBean extends AbstractSearchMBean {



	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CycleVieCriteria cycleVieCriteria=new CycleVieCriteria();
	
	


	public CycleVieSearchMBean() {
		
		search = new CycleVieSearch();
		searchCriteria = cycleVieCriteria;
		initData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.web.AbstractSearchMBean#initData()
	 */
	public void initData() {
		
		
		searchCriteria = cycleVieCriteria;
		run();
	}

	/* (non-Javadoc)
	 * @see com.m2m.technicalservices.web.AbstractSearchMBean#resetSearchCriteria()
	 */
	public void resetSearchCriteria() {
		this.cycleVieCriteria = new CycleVieCriteria();
		searchCriteria = cycleVieCriteria;
	}

	public CycleVieCriteria getCycleVieCriteria() {
		return cycleVieCriteria;
	}

	public void setCycleVieCriteria(CycleVieCriteria cycleVieCriteria) {
		this.cycleVieCriteria = cycleVieCriteria;
	}

	

	

	
}
