package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.OppositionCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class OppositionSearchMbean extends AbstractSearchMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4635089711807520655L;
	private OppositionCriteria criteria = new OppositionCriteria();

	public OppositionSearchMbean() {
		search = new OppositionSearch();
		searchCriteria = criteria;
		initData();
	}

	public void initData() {

		searchCriteria = criteria;
		run();
	}

	public OppositionCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(OppositionCriteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public void resetSearchCriteria() {
		this.criteria = new OppositionCriteria();
		searchCriteria = criteria;
	}

}
