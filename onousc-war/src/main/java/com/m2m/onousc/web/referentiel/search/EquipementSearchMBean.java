package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.EquipementCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class EquipementSearchMBean extends AbstractSearchMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6166464540212473995L;

	/** Equipement criteria **/
	private EquipementCriteria EquipementCriteria = new EquipementCriteria();

	public EquipementSearchMBean() {
		super();
		search = new EquipementSearch();
		searchCriteria = EquipementCriteria;
		initData();
	}

	public void initData() {
		searchCriteria = EquipementCriteria;
		run();
	}

	@Override
	public void resetSearchCriteria() {
		this.EquipementCriteria = new EquipementCriteria();
		searchCriteria = EquipementCriteria;
	}

	public EquipementCriteria getEquipementCriteria() {
		return EquipementCriteria;
	}

	public void setEquipementCriteria(EquipementCriteria EquipementCriteria) {
		this.EquipementCriteria = EquipementCriteria;
	}

}
