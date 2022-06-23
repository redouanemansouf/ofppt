/*
 * MenuWebBean.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.administration.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.MenuVO;
import com.m2m.onousc.business.referentiel.vo.ServiceVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.technicalservices.web.BaseWebBean;

/**
 * The Class ReservationWebBean.
 * 
 * @version 1.0 24 oct. 2015
 * @author iissouani
 */
public class MenuWebBean extends BaseWebBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7224833772283479772L;

	/** The vo. */
	private MenuVO vo = new MenuVO();

	/** The vos. */
	private List<MenuVO> vos = new ArrayList<MenuVO>();
	
	private List<MenuVO> selectedVOs = new ArrayList<MenuVO>();
	
	/** The service list for combo. */
	private List<ServiceVO> serviceListForCombo = new ArrayList<ServiceVO>();
	
	/**
	 * 
	 */
	private List<UserEntityVO> users = new ArrayList<UserEntityVO>();


	/**
	 * Gets the service list for combo.
	 * 
	 * @return the service list for combo
	 */
	public List<ServiceVO> getServiceListForCombo() {
		return serviceListForCombo;
	}

	/**
	 * Sets the service list for combo.
	 * 
	 * @param serviceListForCombo
	 *            the new service list for combo
	 */
	public void setServiceListForCombo(List<ServiceVO> serviceListForCombo) {
		this.serviceListForCombo = serviceListForCombo;
	}


	public List<UserEntityVO> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntityVO> users) {
		this.users = users;
	}

	public MenuVO getVo() {
		return vo;
	}

	public void setVo(MenuVO vo) {
		this.vo = vo;
	}

	public List<MenuVO> getVos() {
		return vos;
	}

	public void setVos(List<MenuVO> vos) {
		this.vos = vos;
	}

	public List<MenuVO> getSelectedVOs() {
		return selectedVOs;
	}

	public void setSelectedVOs(List<MenuVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}



}
