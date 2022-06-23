package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.JoursFerieCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

/**
 * 
 * @author abousnane
 *
 */

@ManagedBean
@ViewScoped
public class JoursFerieSearchMBean extends AbstractSearchMBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4505293816916546525L;
	
	/** The jours ferie criteria. */
	private JoursFerieCriteria joursFerieCriteria = new JoursFerieCriteria();

	public JoursFerieSearchMBean(){
		super();
		search = new JoursFerieSearch();
		searchCriteria = joursFerieCriteria;
		initData();
	}
	
	public void initData() {

		searchCriteria = joursFerieCriteria;
		run();
	}
	
	@Override
	public void resetSearchCriteria() {
		this.joursFerieCriteria = new JoursFerieCriteria();
		searchCriteria = joursFerieCriteria;
		
	}

	public JoursFerieCriteria getJoursFerieCriteria() {
		return joursFerieCriteria;
	}

	public void setJoursFerieCriteria(JoursFerieCriteria joursFerieCriteria) {
		this.joursFerieCriteria = joursFerieCriteria;
	}
	
	

}
