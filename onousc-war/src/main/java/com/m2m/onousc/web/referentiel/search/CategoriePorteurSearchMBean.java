package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.CategoriePorteurCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class CategoriePorteurSearchMBean extends AbstractSearchMBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4492524574458538073L;
	private CategoriePorteurCriteria CategoriePorteurCriteria = new CategoriePorteurCriteria();
	
	public CategoriePorteurSearchMBean(){
		search = new CategoriePorteurSearch();
		searchCriteria = CategoriePorteurCriteria;
		initData();
	}
	
	public void initData() {

		searchCriteria = CategoriePorteurCriteria;
		run();
	}

	@Override
	public void resetSearchCriteria() {
		this.CategoriePorteurCriteria = new CategoriePorteurCriteria();
		searchCriteria = CategoriePorteurCriteria;
		
	}

	public CategoriePorteurCriteria getCategoriePorteurCriteria() {
		return CategoriePorteurCriteria;
	}

	public void setCategoriePorteurCriteria(CategoriePorteurCriteria CategoriePorteurCriteria) {
		this.CategoriePorteurCriteria = CategoriePorteurCriteria;
	}
}
