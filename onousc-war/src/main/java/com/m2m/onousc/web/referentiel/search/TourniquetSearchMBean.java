package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.TourniquetCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class TourniquetSearchMBean extends AbstractSearchMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6166464540212473995L;

	/** Tourniquet criteria **/
	private TourniquetCriteria TourniquetCriteria = new TourniquetCriteria();

	public TourniquetSearchMBean() {
		super();
		search = new TourniquetSearch();
		searchCriteria = TourniquetCriteria;
		initData();
	}

	public void initData() {
		searchCriteria = TourniquetCriteria;
		run();
	}

	@Override
	public void resetSearchCriteria() {
		this.TourniquetCriteria = new TourniquetCriteria();
		searchCriteria = TourniquetCriteria;
	}

	public TourniquetCriteria getTourniquetCriteria() {
		return TourniquetCriteria;
	}

	public void setTourniquetCriteria(TourniquetCriteria TourniquetCriteria) {
		this.TourniquetCriteria = TourniquetCriteria;
	}

}
