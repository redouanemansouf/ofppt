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
import com.m2m.onousc.business.referentiel.vo.SiteVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.technicalservices.validation.Email;
import com.m2m.technicalservices.web.BaseWebBean;

/**
 * The Class ReservationWebBean.
 * 
 * @version 1.0 24 oct. 2015
 * @author iissouani
 */
public class UserEntityWebBean extends BaseWebBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7224833772283479772L;

	/** The vo. */
	private UserEntityVO vo = new UserEntityVO();

	/** The vos. */
	private List<UserEntityVO> vos = new ArrayList<UserEntityVO>();
	
	private List<UserEntityVO> selectedVOs = new ArrayList<UserEntityVO>();
	
	private List<String> groups = new ArrayList<String>();
	
	private List<MenuVO> menus = new ArrayList<MenuVO>();
	
	private List<SiteVO> ListSite = new ArrayList<SiteVO>();

	private String password2;
	
	@Email
	private String email;
	
	public String typeUser;
	
	public List<UserEntityVO> getSelectedVOs() {
		return selectedVOs;
	}

	public void setSelectedVOs(List<UserEntityVO> selectedVO) {
		this.selectedVOs = selectedVO;
	}

	public UserEntityVO getVo() {
		return vo;
	}

	public void setVo(UserEntityVO vo) {
		this.vo = vo;
	}

	public List<UserEntityVO> getVos() {
		return vos;
	}

	public void setVos(List<UserEntityVO> vos) {
		this.vos = vos;
	}

	/** The service list for combo. */
	private List<ServiceVO> serviceListForCombo = new ArrayList<ServiceVO>();


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

	public List<String> getGroups() {
		return groups;
	}

	public void setGroups(List<String> groups) {
		this.groups = groups;
	}

	public List<MenuVO> getMenus() {
		return menus;
	}

	public void setMenus(List<MenuVO> menus) {
		this.menus = menus;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}

	public List<SiteVO> getListSite() {
		return ListSite;
	}

	public void setListSite(List<SiteVO> listSite) {
		ListSite = listSite;
	}
	
	

}
