package com.m2m.onousc.web.administration.search;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.GroupUserCriteria;
import com.m2m.onousc.business.referentiel.vo.GroupUserVO;
import com.m2m.onousc.web.administration.AdministrationSrvPresentation;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class GroupUserSearchMBean extends AbstractSearchMBean {

	/**
	 * 
	 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4433541860841899465L;

	/**
	 * 
	 */
	private GroupUserCriteria groupUserCriteria = new GroupUserCriteria();

	private List<GroupUserVO> listGroup = new ArrayList<>();
	AdministrationSrvPresentation administrationServicePres = (AdministrationSrvPresentation) BeansLookuper
			.lookup("administrationSrvPresentationGRP");


	public GroupUserSearchMBean() {
		super();
		search = new GroupUserSearch();
		searchCriteria = groupUserCriteria;
		 initData();
	}

	public void initData() {
		searchCriteria = groupUserCriteria;
		run();
	}

	

	@Override
	public void resetSearchCriteria() {
		this.groupUserCriteria = new GroupUserCriteria();
		searchCriteria = groupUserCriteria;
	}

	public void recherche() {
		listGroup = administrationServicePres
				.findOnlyGroupByCriteria(groupUserCriteria);
	}

	public GroupUserCriteria getGroupUserCriteria() {
		return groupUserCriteria;
	}

	public void setGroupUserCriteria(GroupUserCriteria GroupUserCriteria) {
		this.groupUserCriteria = GroupUserCriteria;
	}

	public List<GroupUserVO> getListGroup() {
		return listGroup;
	}

	public void setListGroup(List<GroupUserVO> listGroup) {
		this.listGroup = listGroup;
	}

}
