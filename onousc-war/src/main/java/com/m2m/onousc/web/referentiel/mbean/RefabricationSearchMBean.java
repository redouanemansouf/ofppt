package com.m2m.onousc.web.referentiel.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.EtudiantCriteria;
import com.m2m.onousc.web.referentiel.search.RefabricationSearch;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class RefabricationSearchMBean extends AbstractSearchMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8063676741012917974L;

	private EtudiantCriteria etudiantCriteria = new EtudiantCriteria();

	public RefabricationSearchMBean() {
		search = new RefabricationSearch();
		searchCriteria = etudiantCriteria;
		initData();
	}

	public void initData() {
		searchCriteria = etudiantCriteria;
		run();
	}

	public void resetSearchCriteria() {
		this.etudiantCriteria = new EtudiantCriteria();
		searchCriteria = etudiantCriteria;
	}

	public EtudiantCriteria getEtudiantCriteria() {
		return etudiantCriteria;
	}

	public void setEtudiantCriteria(EtudiantCriteria etudiantCriteria) {
		this.etudiantCriteria = etudiantCriteria;
	}

}
