package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.TarifCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

/**
 * 
 * @author abousnane
 *
 */

@ManagedBean
@ViewScoped
public class TarifSearchMBean extends AbstractSearchMBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5393868608707290083L;
	
	/** The canal vente criteria. */
	private TarifCriteria tarifCriteria = new TarifCriteria();
	
	public TarifSearchMBean(){
		search = new TarifSearch();
		searchCriteria = tarifCriteria;
		initData();
	}
	
	public void initData() {

		searchCriteria = tarifCriteria;
		run();
	}

	@Override
	public void resetSearchCriteria() {
		this.tarifCriteria = new TarifCriteria();
		searchCriteria = tarifCriteria;
		
	}

	public TarifCriteria getTarifCriteria() {
		return tarifCriteria;
	}

	public void setTarifCriteria(TarifCriteria tarifCriteria) {
		this.tarifCriteria = tarifCriteria;
	}
	
	

}
