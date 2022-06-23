/*
* CanalVenteSearchMBean.java
*
* Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
*/
package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.CarteNapsCriteria;
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
public class CarteNapsSearchMBean extends AbstractSearchMBean {



	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1715422869684794078L;
	private CarteNapsCriteria cartenapsCriteria=new CarteNapsCriteria();
	
	


	public CarteNapsSearchMBean() {
		
		search = new CarteNapsSearch();
		searchCriteria = cartenapsCriteria;
		initData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.web.AbstractSearchMBean#initData()
	 */
	public void initData() {
		
		
		searchCriteria = cartenapsCriteria;
		run();
	}

	/* (non-Javadoc)
	 * @see com.m2m.technicalservices.web.AbstractSearchMBean#resetSearchCriteria()
	 */
	public void resetSearchCriteria() {
		this.cartenapsCriteria = new CarteNapsCriteria();
		searchCriteria = cartenapsCriteria;
	}

	public CarteNapsCriteria getCartenapsCriteria() {
		return cartenapsCriteria;
	}

	public void setCartenapsCriteria(CarteNapsCriteria cartenapsCriteria) {
		this.cartenapsCriteria = cartenapsCriteria;
	}


	
}
