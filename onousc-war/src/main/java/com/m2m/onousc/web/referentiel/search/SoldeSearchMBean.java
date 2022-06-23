package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.SoldeCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class SoldeSearchMBean extends AbstractSearchMBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2704430766816832238L;
	
	/** restaurant criteria**/
	private SoldeCriteria soldeCriteria = new SoldeCriteria();
	
	public SoldeSearchMBean(){
		super();
		search = new SoldeSearch();
		searchCriteria = soldeCriteria;
		initData();
	}
	
	public void initData(){
		searchCriteria = soldeCriteria;
		run();
	}
	
	@Override
	public void resetSearchCriteria() {
		this.soldeCriteria = new SoldeCriteria();
		searchCriteria = soldeCriteria;
	}

	public SoldeCriteria getSoldeCriteria() {
		return soldeCriteria;
	}

	public void setSoldeCriteria(SoldeCriteria soldeCriteria) {
		this.soldeCriteria = soldeCriteria;
	}
	
	
}
