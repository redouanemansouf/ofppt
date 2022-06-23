package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.CaisseCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class CaisseSearchMBean extends AbstractSearchMBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6166464540212473995L;
	
	/** caisse criteria**/
	private CaisseCriteria caisseCriteria = new CaisseCriteria();
	
	public CaisseSearchMBean(){
		super();
		search = new CaisseSearch();
		searchCriteria = caisseCriteria;
		initData();
	}
	
	public void initData(){
		searchCriteria = caisseCriteria;
		run();
	}
	@Override
	public void resetSearchCriteria() {
		this.caisseCriteria = new CaisseCriteria();
		searchCriteria = caisseCriteria;
	}

	public CaisseCriteria getCaisseCriteria() {
		return caisseCriteria;
	}

	public void setCaisseCriteria(CaisseCriteria caisseCriteria) {
		this.caisseCriteria = caisseCriteria;
	}

}
