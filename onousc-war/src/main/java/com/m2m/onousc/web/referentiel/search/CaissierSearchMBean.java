package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.CaissierCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class CaissierSearchMBean extends AbstractSearchMBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6166464540212473995L;
	
	/** Caissier criteria**/
	private CaissierCriteria CaissierCriteria = new CaissierCriteria();
	
	public CaissierSearchMBean(){
		super();
		search = new CaissierSearch();
		searchCriteria = CaissierCriteria;
		initData();
	}
	
	public void initData(){
		searchCriteria = CaissierCriteria;
		run();
	}
	@Override
	public void resetSearchCriteria() {
		this.CaissierCriteria = new CaissierCriteria();
		searchCriteria = CaissierCriteria;
	}

	public CaissierCriteria getCaissierCriteria() {
		return CaissierCriteria;
	}

	public void setCaissierCriteria(CaissierCriteria CaissierCriteria) {
		this.CaissierCriteria = CaissierCriteria;
	}

}
