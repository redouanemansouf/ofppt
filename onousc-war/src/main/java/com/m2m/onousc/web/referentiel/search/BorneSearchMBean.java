package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.BorneCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class BorneSearchMBean extends AbstractSearchMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6166464540212473995L;

	/** Borne criteria **/
	private BorneCriteria BorneCriteria = new BorneCriteria();

	public BorneSearchMBean() {
		super();
		search = new BorneSearch();
		searchCriteria = BorneCriteria;
		initData();
	}

	public void initData() {
		searchCriteria = BorneCriteria;
		run();
	}

	@Override
	public void resetSearchCriteria() {
		this.BorneCriteria = new BorneCriteria();
		searchCriteria = BorneCriteria;
	}

	public BorneCriteria getBorneCriteria() {
		return BorneCriteria;
	}

	public void setBorneCriteria(BorneCriteria BorneCriteria) {
		this.BorneCriteria = BorneCriteria;
	}

}
