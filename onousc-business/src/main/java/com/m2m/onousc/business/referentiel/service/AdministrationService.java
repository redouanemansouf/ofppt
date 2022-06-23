package com.m2m.onousc.business.referentiel.service;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.GroupUserCriteria;
import com.m2m.onousc.business.referentiel.criteria.WinMenuCriteria;
import com.m2m.onousc.business.referentiel.model.GroupUser;
import com.m2m.onousc.business.referentiel.model.Menu;
import com.m2m.technicalservices.security.UserEntity;
import com.m2m.technicalservices.security.WinMenu;

public interface AdministrationService {

	List<GroupUser> findGroupByCode(String groupName);

	GroupUser findGroupUserByID(long id);
	List<GroupUser> findOnlyGroupByCriteria(GroupUserCriteria criteria);

	List<GroupUser> findGroupByCriteria(GroupUserCriteria criteria);

	List<UserEntity> findUserByGroup(String group);

	List<GroupUser> findGroupByCriteriaCS(GroupUserCriteria criteria);

	List<WinMenu> findWinMenuByCriteria(WinMenuCriteria criteria);

	List<Menu> findAllMenu();

	List<WinMenu> getWinMenuByCriteria(WinMenuCriteria criteria);

	List<WinMenu> findWinMenuByGroupList(String groupname);


}
