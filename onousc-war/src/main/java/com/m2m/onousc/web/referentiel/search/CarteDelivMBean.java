/*
 * CanalVenteSearchMBean.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.CycleVieCriteria;
import com.m2m.onousc.business.referentiel.criteria.DelivranceCriteria;
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
public class CarteDelivMBean extends AbstractSearchMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6533022663339282317L;
	private DelivranceCriteria delivranceCriteria = new DelivranceCriteria();

	public CarteDelivMBean() {

		search = new CarteDelivSearch();
		searchCriteria = delivranceCriteria;
		initData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.web.AbstractSearchMBean#initData()
	 */
	public void initData() {

		// cycleVieCriteria.setOperation("DELIVRANCE");
		// searchCriteria = delivranceCriteria;
		run();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.web.AbstractSearchMBean#resetSearchCriteria()
	 */
	public void resetSearchCriteria() {
		this.delivranceCriteria = new DelivranceCriteria();
		searchCriteria = delivranceCriteria;
	}

	public DelivranceCriteria getDelivranceCriteria() {
		return delivranceCriteria;
	}

	public void setDelivranceCriteria(DelivranceCriteria delivranceCriteria) {
		this.delivranceCriteria = delivranceCriteria;
	}

}
