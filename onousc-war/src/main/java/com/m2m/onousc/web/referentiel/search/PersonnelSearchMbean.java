package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.OppositionCriteria;
import com.m2m.onousc.business.referentiel.criteria.PersonnelCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class PersonnelSearchMbean extends AbstractSearchMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4635089711807520655L;
	private PersonnelCriteria criteria = new PersonnelCriteria();

	public PersonnelSearchMbean() {
		search = new PersonnelSearch();
		searchCriteria = criteria;
		initData();
	}

	public void initData() {

		searchCriteria = criteria;
		run();
	}
	
	


	public PersonnelCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(PersonnelCriteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public void resetSearchCriteria() {
		this.criteria = new  PersonnelCriteria();
//		this.setCriteria(new PersonnelCriteria());
		searchCriteria = criteria;
	}

}
