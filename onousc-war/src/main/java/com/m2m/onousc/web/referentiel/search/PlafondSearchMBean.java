package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.PlafondCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class PlafondSearchMBean extends AbstractSearchMBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6696062304986781047L;
	
	private PlafondCriteria plafondCriteria = new PlafondCriteria();
	
	public PlafondSearchMBean(){
		search = new PlafondSearch();
		searchCriteria = plafondCriteria;
		initData();
	}
	
	public void initData(){
		searchCriteria = plafondCriteria;
		run();
	}

	@Override
	public void resetSearchCriteria() {
		this.plafondCriteria = new PlafondCriteria();
		searchCriteria = plafondCriteria;
	}

	public PlafondCriteria getPlafondCriteria() {
		return plafondCriteria;
	}

	public void setPlafondCriteria(PlafondCriteria plafondCriteria) {
		this.plafondCriteria = plafondCriteria;
	}
	
	

}
