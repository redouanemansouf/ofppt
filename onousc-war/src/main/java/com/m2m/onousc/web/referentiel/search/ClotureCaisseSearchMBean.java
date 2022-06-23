package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.ClotureCaisseCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class ClotureCaisseSearchMBean extends AbstractSearchMBean {


	/**
	 * 
	 */
	private static final long serialVersionUID = -8567217044496936112L;
	private ClotureCaisseCriteria clotureCriteria = new ClotureCaisseCriteria();

	public ClotureCaisseSearchMBean() {
	
		search = new ClotureCaisseSearch();
		searchCriteria = clotureCriteria;
		initData();
	}

	public void initData() {
		searchCriteria = clotureCriteria;
		run();
	}

	@Override
	public void resetSearchCriteria() {
		this.clotureCriteria = new ClotureCaisseCriteria();
		searchCriteria = clotureCriteria;
	}

	public ClotureCaisseCriteria getClotureCriteria() {
		return clotureCriteria;
	}

	public void setClotureCriteria(ClotureCaisseCriteria clotureCriteria) {
		this.clotureCriteria = clotureCriteria;
	}

}
