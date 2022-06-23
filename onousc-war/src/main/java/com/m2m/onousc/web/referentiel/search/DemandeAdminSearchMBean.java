package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.DemandeAdminCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class DemandeAdminSearchMBean extends AbstractSearchMBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6166430540552473949L;
	
	/** demandeAdmin criteria**/
	private DemandeAdminCriteria demandeAdminCriteria = new DemandeAdminCriteria();
	
	public DemandeAdminSearchMBean(){
		super();
		search = new DemandeAdminSearch();
		searchCriteria = demandeAdminCriteria;
		initData();
	}
	
	public void initData(){
		searchCriteria = demandeAdminCriteria;
		run();
	}
	@Override
	public void resetSearchCriteria() {
		this.demandeAdminCriteria = new DemandeAdminCriteria();
		searchCriteria = demandeAdminCriteria;
	}

	public DemandeAdminCriteria getDemandeAdminCriteria() {
		return demandeAdminCriteria;
	}

	public void setDemandeAdminCriteria(DemandeAdminCriteria demandeAdminCriteria) {
		this.demandeAdminCriteria = demandeAdminCriteria;
	}

}
