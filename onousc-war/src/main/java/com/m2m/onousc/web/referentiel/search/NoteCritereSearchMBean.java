package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.NoteCritereCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class NoteCritereSearchMBean extends AbstractSearchMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4492524574458538073L;
	private NoteCritereCriteria NoteCritereCriteria = new NoteCritereCriteria();

	public NoteCritereSearchMBean() {
		search = new NoteCritereSearch();
		searchCriteria = NoteCritereCriteria;
		initData();
	}

	public void initData() {

		searchCriteria = NoteCritereCriteria;
		run();
	}

	@Override
	public void resetSearchCriteria() {
		this.NoteCritereCriteria = new NoteCritereCriteria();
		searchCriteria = NoteCritereCriteria;

	}

	public NoteCritereCriteria getNoteCritereCriteria() {
		return NoteCritereCriteria;
	}

	public void setNoteCritereCriteria(NoteCritereCriteria NoteCritereCriteria) {
		this.NoteCritereCriteria = NoteCritereCriteria;
	}
}
