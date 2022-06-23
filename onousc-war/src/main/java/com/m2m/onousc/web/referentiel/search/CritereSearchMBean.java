package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.CritereCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class CritereSearchMBean extends AbstractSearchMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4492524574458538073L;
	private CritereCriteria CritereCriteria = new CritereCriteria();

	public CritereSearchMBean() {
		search = new CritereSearch();
		searchCriteria = CritereCriteria;
		initData();
	}

	public void initData() {

		searchCriteria = CritereCriteria;
		run();
	}

	@Override
	public void resetSearchCriteria() {
		this.CritereCriteria = new CritereCriteria();
		searchCriteria = CritereCriteria;

	}

	public CritereCriteria getCritereCriteria() {
		return CritereCriteria;
	}

	public void setCritereCriteria(CritereCriteria CritereCriteria) {
		this.CritereCriteria = CritereCriteria;
	}
}
