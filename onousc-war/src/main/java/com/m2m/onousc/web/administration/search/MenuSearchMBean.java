package com.m2m.onousc.web.administration.search; 

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.MenuCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class MenuSearchMBean extends AbstractSearchMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1762928174124428067L;
	private MenuCriteria menuCriteria = new MenuCriteria();

	public MenuSearchMBean() {
		super();
		search = new MenuSearch();
		searchCriteria = menuCriteria;
		initData();
	}

	public void initData() {
		searchCriteria = menuCriteria;
		run();
	}

	@Override
	public void resetSearchCriteria() {
		this.menuCriteria = new MenuCriteria();
		searchCriteria = menuCriteria;
	}

	public MenuCriteria getMenuCriteria() {
		return menuCriteria;
	}

	public void setMenuCriteria(MenuCriteria menuCriteria) {
		this.menuCriteria = menuCriteria;
	}




}
