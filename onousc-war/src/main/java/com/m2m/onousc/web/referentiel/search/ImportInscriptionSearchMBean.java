package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.ImportCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class ImportInscriptionSearchMBean extends AbstractSearchMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1952232836573634227L;

	private ImportCriteria criteria = new ImportCriteria();

	public ImportInscriptionSearchMBean() {
		search = new ImportInscriptionSearch();
		searchCriteria = criteria;
		initData();
	}

	public void initData() {
		searchCriteria = criteria;
		run();
	}

	public ImportCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(ImportCriteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public void resetSearchCriteria() {
		this.setCriteria(new ImportCriteria());
	}

}
