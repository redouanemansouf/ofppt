package com.m2m.onousc.web.administration.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.WinMenuCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class WinMenuGSearchMBean extends AbstractSearchMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1762928174124428067L;
	private WinMenuCriteria winMenuCriteria = new WinMenuCriteria();

	public WinMenuGSearchMBean() {

		search = new WinMenuSearch();
		winMenuCriteria.setType("G");
		searchCriteria = winMenuCriteria;
		initData();
	}

	public void initData() {
		winMenuCriteria.setType("G");
		searchCriteria = winMenuCriteria;
		run();
	}

	@Override
	public void resetSearchCriteria() {
		this.winMenuCriteria = new WinMenuCriteria();
		winMenuCriteria.setType("G");
		searchCriteria = winMenuCriteria;
	}

	public WinMenuCriteria getWinMenuCriteria() {
		return winMenuCriteria;
	}

	public void setWinMenuCriteria(WinMenuCriteria winMenuCriteria) {
		this.winMenuCriteria = winMenuCriteria;
	}



}
