package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.AnneeUniversitaireCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class AnneeUniversitaireSearchMBean extends AbstractSearchMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1762928174124428067L;
	private AnneeUniversitaireCriteria anneeUniversitaireCriteria = new AnneeUniversitaireCriteria();

	public AnneeUniversitaireSearchMBean() {
		super();
		search = new AnneeUniversitaireSearch();
		searchCriteria = anneeUniversitaireCriteria;
		initData();
	}

	public void initData() {
		searchCriteria = anneeUniversitaireCriteria;
		run();
	}

	@Override
	public void resetSearchCriteria() {
		this.anneeUniversitaireCriteria = new AnneeUniversitaireCriteria();
		searchCriteria = anneeUniversitaireCriteria;
	}

	public AnneeUniversitaireCriteria getAnneeUniversitaireCriteria() {
		return anneeUniversitaireCriteria;
	}

	public void setAnneeUniversitaireCriteria(
			AnneeUniversitaireCriteria anneeUniversitaireCriteria) {
		this.anneeUniversitaireCriteria = anneeUniversitaireCriteria;
	}

}
