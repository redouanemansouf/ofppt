package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.FiliereCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class FiliereSearchMBean extends AbstractSearchMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2704430766816832238L;

	/** filiere criteria **/
	private FiliereCriteria filiereCriteria = new FiliereCriteria();

	public FiliereSearchMBean() {
		super();
		search = new FiliereSearch();
		searchCriteria = filiereCriteria;
		initData();
	}

	public void initData() {
		searchCriteria = filiereCriteria;
		run();
	}

	@Override
	public void resetSearchCriteria() {
		this.filiereCriteria = new FiliereCriteria();
		searchCriteria = filiereCriteria;
	}

	public FiliereCriteria getFiliereCriteria() {
		return filiereCriteria;
	}

	public void setFiliereCriteria(FiliereCriteria filiereCriteria) {
		this.filiereCriteria = filiereCriteria;
	}

}
