package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.MotifOppositionCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class MotifOppositionSearchMBean extends AbstractSearchMBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4492524574458538073L;
	private MotifOppositionCriteria motifOppositionCriteria = new MotifOppositionCriteria();
	
	public MotifOppositionSearchMBean(){
		search = new MotifOppositionSearch();
		searchCriteria = motifOppositionCriteria;
		initData();
	}
	
	public void initData() {

		searchCriteria = motifOppositionCriteria;
		run();
	}

	@Override
	public void resetSearchCriteria() {
		this.motifOppositionCriteria = new MotifOppositionCriteria();
		searchCriteria = motifOppositionCriteria;
		
	}

	public MotifOppositionCriteria getMotifOppositionCriteria() {
		return motifOppositionCriteria;
	}

	public void setMotifOppositionCriteria(MotifOppositionCriteria motifOppositionCriteria) {
		this.motifOppositionCriteria = motifOppositionCriteria;
	}
}
