/*
 * AdministrationWebBean.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.administration.webbean;

import java.util.ArrayList;
import java.util.List;



import com.m2m.onousc.business.referentiel.vo.GroupUserVO;
import com.m2m.onousc.business.referentiel.vo.MenuVO;
import com.m2m.technicalservices.web.BaseWebBean;

/**
 * The Class ReservationWebBean.
 * 
 * @version 1.0 24 oct. 2015
 * @author iissouani
 */
public class GroupUserWebBean extends BaseWebBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7224833772283479772L;

	/** The vo. */
	private GroupUserVO vo = new GroupUserVO();

	/** The vos. */
	private List<GroupUserVO> vos = new ArrayList<GroupUserVO>();
	
	private List<GroupUserVO> selectedVOs = new ArrayList<GroupUserVO>();
	
	private List<GroupUserVO> groups = new ArrayList<GroupUserVO>();
	
	private List<MenuVO> menus = new ArrayList<MenuVO>();

	private boolean groupe;
	
	private Long groupeParent;
	public List<GroupUserVO> getSelectedVOs() {
		return selectedVOs;
	}

	public void setSelectedVOs(List<GroupUserVO> selectedVO) {
		this.selectedVOs = selectedVO;
	}

	public GroupUserVO getVo() {
		return vo;
	}

	public void setVo(GroupUserVO vo) {
		this.vo = vo;
	}

	public List<GroupUserVO> getVos() {
		return vos;
	}

	public void setVos(List<GroupUserVO> vos) {
		this.vos = vos;
	}


	public List<GroupUserVO> getGroups() {
		return groups;
	}

	public void setGroups(List<GroupUserVO> groups) {
		this.groups = groups;
	}

	public List<MenuVO> getMenus() {
		return menus;
	}

	public void setMenus(List<MenuVO> menus) {
		this.menus = menus;
	}

	public boolean isGroupe() {
		return groupe;
	}

	public void setGroupe(boolean groupe) {
		this.groupe = groupe;
	}

	public Long getGroupeParent() {
		return groupeParent;
	}

	public void setGroupeParent(Long groupeParent) {
		this.groupeParent = groupeParent;
	} 


}
