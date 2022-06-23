package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.DetailProfilCriteria;
import com.m2m.onousc.business.referentiel.criteria.JoursFerieCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;



@ManagedBean
@ViewScoped
public class DetailProfilSearchMBean extends AbstractSearchMBean{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8500290865860938718L;

	private DetailProfilCriteria detailProfilCriteria = new DetailProfilCriteria();

	public DetailProfilSearchMBean(){
		super();
		search = new DetailProfilSearch();
		searchCriteria = detailProfilCriteria;
		initData();
	}
	
	public void initData() {

		searchCriteria = detailProfilCriteria;
		run();
	}
	
	@Override
	public void resetSearchCriteria() {
		this.detailProfilCriteria = new DetailProfilCriteria();
		searchCriteria = detailProfilCriteria;
		
	}

	public DetailProfilCriteria getDetailProfilCriteria() {
		return detailProfilCriteria;
	}

	public void setDetailProfilCriteria(DetailProfilCriteria detailProfilCriteria) {
		this.detailProfilCriteria = detailProfilCriteria;
	}

	
	
	

}
