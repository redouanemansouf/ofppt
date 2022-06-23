package com.m2m.onousc.web.referentiel.search;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.UniversiteCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class UniversiteSearchMBean extends AbstractSearchMBean{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5162298871762494802L;
	
	/** The universite criteria. */
	private UniversiteCriteria universiteCriteria = new UniversiteCriteria();

	/**
	 * Instantiates a new universite search m bean.
	 */
	public UniversiteSearchMBean(){
		super();
		search = new UniversiteSearch();
		searchCriteria = universiteCriteria;
		initData();
	}
	
	public void initData() {

		searchCriteria = universiteCriteria;
		run();
	}
	@Override
	public void resetSearchCriteria() {
		this.universiteCriteria = new UniversiteCriteria();
		searchCriteria = universiteCriteria;
		
	}
	/**
	 * 
	 * @return universiteCriteria
	 */
	public UniversiteCriteria getUniversiteCriteria() {
		return universiteCriteria;
	}
	
	/**
	 * 
	 * @param universiteCriteria
	 */
	public void setUniversiteCriteria(UniversiteCriteria universiteCriteria) {
		this.universiteCriteria = universiteCriteria;
	}

}
