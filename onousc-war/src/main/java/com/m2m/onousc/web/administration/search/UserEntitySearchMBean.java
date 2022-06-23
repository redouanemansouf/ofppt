package com.m2m.onousc.web.administration.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.UserEntityCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class UserEntitySearchMBean extends AbstractSearchMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1762928174124428067L;
	private UserEntityCriteria userEntityCriteria = new UserEntityCriteria();

	public UserEntitySearchMBean() {
		super();
		search = new UserEnitySearch();
		searchCriteria = userEntityCriteria;
		initData();
	}

	public void initData() {
		searchCriteria = userEntityCriteria;
		run();
	}

	@Override
	public void resetSearchCriteria() {
		this.userEntityCriteria = new UserEntityCriteria();
		searchCriteria = userEntityCriteria;
	}

	public UserEntityCriteria getUserEntityCriteria() {
		return userEntityCriteria;
	}

	public void setUserEntityCriteria(UserEntityCriteria userEntityCriteria) {
		this.userEntityCriteria = userEntityCriteria;
	}


}
