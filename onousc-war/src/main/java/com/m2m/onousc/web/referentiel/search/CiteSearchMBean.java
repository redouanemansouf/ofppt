package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.CiteCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

/**
 * 
 * @author abousnane
 *
 */

@ManagedBean
@ViewScoped
public class CiteSearchMBean extends AbstractSearchMBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8545491456788115981L;
	
	/** The cite criteria. */
	private CiteCriteria citeCriteria = new CiteCriteria();

	/**
	 * Instantiates a new cite search m bean.
	 */
	public CiteSearchMBean(){
		super();
		search = new CiteSearch();
		searchCriteria = citeCriteria;
		initData();
	}
	
	public void initData() {

		searchCriteria = citeCriteria;
		run();
	}
	@Override
	public void resetSearchCriteria() {
		this.citeCriteria = new CiteCriteria();
		searchCriteria = citeCriteria;
		
	}
	/**
	 * 
	 * @return citeCriteria
	 */
	public CiteCriteria getCiteCriteria() {
		return citeCriteria;
	}
	
	/**
	 * 
	 * @param citeCriteria
	 */
	public void setCiteCriteria(CiteCriteria citeCriteria) {
		this.citeCriteria = citeCriteria;
	}
}
