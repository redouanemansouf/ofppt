package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.OppositionAdhCriteria;
import com.m2m.onousc.business.referentiel.criteria.OppositionCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class OppositionAdhSearchMbean extends AbstractSearchMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4635089711807520655L;
	private OppositionAdhCriteria criteria = new OppositionAdhCriteria();

	public OppositionAdhSearchMbean() {
		search = new OppositionAdhSearch();
		searchCriteria = criteria;
		initData();
	}

	public void initData() {

		searchCriteria = criteria;
		run();
	}
	
	


	public OppositionAdhCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(OppositionAdhCriteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public void resetSearchCriteria() {
		this.criteria = new  OppositionAdhCriteria();
		searchCriteria = criteria;
	}

}
