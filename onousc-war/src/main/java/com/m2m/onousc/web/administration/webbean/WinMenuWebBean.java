/*
 * AdministrationWebBean.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.administration.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.MenuVO;
import com.m2m.onousc.business.referentiel.vo.ServiceVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.business.referentiel.vo.WinMenuVO;
import com.m2m.technicalservices.web.BaseWebBean;

/**
 * The Class ReservationWebBean.
 * 
 * @version 1.0 24 oct. 2015
 * @author iissouani
 */
public class WinMenuWebBean extends BaseWebBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7224833772283479772L;

	/** The vo. */
	private WinMenuVO vo = new WinMenuVO();

	/** The vos. */
	private List<WinMenuVO> vos = new ArrayList<WinMenuVO>();
	
	private List<WinMenuVO> selectedVOs = new ArrayList<WinMenuVO>();
	
	private List<MenuVO> menus = new ArrayList<MenuVO>();

	private List<String> groups = new ArrayList<String>();
	/**
	 * 
	 */
	private List<WinMenuVO> winMenuModules = new ArrayList<WinMenuVO>();

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

	public WinMenuVO getVo() {
		return vo;
	}

	public void setVo(WinMenuVO vo) {
		this.vo = vo;
	}

	public List<WinMenuVO> getVos() {
		return vos;
	}

	public void setVos(List<WinMenuVO> vos) {
		this.vos = vos;
	}

	public List<WinMenuVO> getSelectedVOs() {
		return selectedVOs;
	}

	public void setSelectedVOs(List<WinMenuVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}

	public List<WinMenuVO> getWinMenuModules() {
		return winMenuModules;
	}

	public void setWinMenuModules(List<WinMenuVO> winMenuModules) {
		this.winMenuModules = winMenuModules;
	}

	public List<UserEntityVO> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntityVO> users) {
		this.users = users;
	}

	public List<MenuVO> getMenus() {
		return menus;
	}

	public void setMenus(List<MenuVO> menus) {
		this.menus = menus;
	}


	public List<String> getGroups() {
		return groups;
	}

	public void setGroups(List<String> groups) {
		this.groups = groups;
	}




}
