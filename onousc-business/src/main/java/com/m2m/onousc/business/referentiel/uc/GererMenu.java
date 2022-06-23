/*
* GererWinMenu.java
*
* Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
*/
package com.m2m.onousc.business.referentiel.uc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.dao.GroupUserDaoJpa;
import com.m2m.onousc.business.referentiel.dao.MenuDaoJpa;
import com.m2m.onousc.business.referentiel.dao.UserEntityDaoJpa;
import com.m2m.onousc.business.referentiel.dao.WinMenuDaoJpa;
import com.m2m.onousc.business.referentiel.model.GroupUser;
import com.m2m.onousc.business.referentiel.model.Menu;
import com.m2m.onousc.business.referentiel.rule.MenuBusinessRuleManager;
import com.m2m.technicalservices.core.IBusinessRuleManager;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.core.UseCaseController;
import com.m2m.technicalservices.core.UserContext;
import com.m2m.technicalservices.security.UserEntity;
import com.m2m.technicalservices.security.WinMenu;



/**
 * The Class GererMenu.
 *
 * @version 1.0 24 nov. 2014
 * @author iissouani
 */
@Service("ADMINISTRATION_GererMenu_UC")
public class GererMenu extends UseCaseController {

	
	
	@Autowired
	WinMenuDaoJpa windaoJpa;


	@Autowired
	GroupUserDaoJpa groupUserdao;

	@Autowired
	UserEntityDaoJpa userdao;
	
	/* (non-Javadoc)   
	 * @see com.m2m.technicalServices.core.UseCaseController#getBusinessRuleManager()
	 */
	@Override
	protected IBusinessRuleManager getBusinessRuleManager() {
		return  new MenuBusinessRuleManager();
	}

	/* (non-Javadoc)
	 * @see com.m2m.technicalServices.core.UseCaseController#business()
	 */
	@Override
	protected ProcessResult business() {
		if(UserContext.getClientParameters().getSousCommand().equals(Constantes.SOUS_COMMANDE_CREER_MENU )){
			creerAssociatedWinMenus();
		}
//		if(UserContext.getClientParameters().getSousCommand().equals(Constantes.SOUS_COMMANDE_SUPPRIMER_MENU )){
//			deleteAssociatedWinMenus();
//		}
		return null;
	}

	private void creerAssociatedWinMenus() {
		Menu subject = (Menu) UserContext.getSubject();
		List<UserEntity> users = userdao.findAllUsersExceptDeleted();
		List<GroupUser> gUsers= groupUserdao.findAll();
			for (UserEntity user : users) {
				WinMenu winMenu = new WinMenu(String.valueOf(subject.getCode()), subject.getAbbrev(), subject.getLibelle(), null, user.getUsername(), "O");
				winMenu.setStatut(EntityStatus.ENABLED.toString());
				windaoJpa.persist(winMenu);
			}

			for (GroupUser guser : gUsers) { 
				WinMenu winMenu = new WinMenu(String.valueOf(subject.getCode()), subject.getAbbrev(), subject.getLibelle(), null, guser.getGroupname(), "G");
				winMenu.setStatut(EntityStatus.ENABLED.toString());  
				windaoJpa.persist(winMenu);
			}
		
	}
	
	
	private void deleteAssociatedWinMenus(){
		List<WinMenu> winmenus= windaoJpa.findAll();
		Menu subject = (Menu) UserContext.getSubject();
		for (WinMenu winMenu : winmenus) {
			if(subject.getCode().equals(winMenu.getCode())){
				windaoJpa.remove(winMenu);
			}
		}
	}


}  
