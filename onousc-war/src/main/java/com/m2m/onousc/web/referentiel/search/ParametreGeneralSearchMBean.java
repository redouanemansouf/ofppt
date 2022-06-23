package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.ParametreGeneralCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class ParametreGeneralSearchMBean extends AbstractSearchMBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4492524574458538073L;
	private ParametreGeneralCriteria ParametreGeneralCriteria = new ParametreGeneralCriteria();
	
	public ParametreGeneralSearchMBean(){
		search = new ParametreGeneralSearch();
		searchCriteria = ParametreGeneralCriteria;
		initData();
	}
	
	public void initData() {

		searchCriteria = ParametreGeneralCriteria;
		run();
	}

	@Override
	public void resetSearchCriteria() {
		this.ParametreGeneralCriteria = new ParametreGeneralCriteria();
		searchCriteria = ParametreGeneralCriteria;
		
	}

	public ParametreGeneralCriteria getParametreGeneralCriteria() {
		return ParametreGeneralCriteria;
	}

	public void setParametreGeneralCriteria(ParametreGeneralCriteria ParametreGeneralCriteria) {
		this.ParametreGeneralCriteria = ParametreGeneralCriteria;
	}
}
