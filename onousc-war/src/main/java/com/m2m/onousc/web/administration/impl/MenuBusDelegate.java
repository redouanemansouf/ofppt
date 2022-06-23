/*
 * AdministrationBusDelegate.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.administration.impl;

import javax.validation.groups.Default;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.vo.MenuVO;
import com.m2m.onousc.business.referentiel.vo.WinMenuVO;
import com.m2m.onousc.web.administration.IMenuBusDelegate;
import com.m2m.onousc.web.administration.webbean.MenuWebBean;
import com.m2m.onousc.web.administration.webbean.WinMenuWebBean;
import com.m2m.technicalservices.core.UserContext;
import com.m2m.technicalservices.web.BaseBusDelegate;

/**
 * @author iissouani
 *
 */
public class MenuBusDelegate extends BaseBusDelegate implements
		IMenuBusDelegate {

	/**
	 * Instantiates a new administration bus delegate.
	 */
	public MenuBusDelegate() {

		domaine = "ADMINISTRATION";
		/*
		 * Toujours initier le groupe de validation
		 */
		Class<?>[] groups = { Default.class };
		UserContext.setValidationGroups(groups);
	}

	@Override
	public boolean creerMenu(MenuWebBean webBean) {
		String command = Constantes.COMMAND_GERER_MENU;
		String sousCommand = Constantes.SOUS_COMMANDE_CREER_MENU;
		MenuVO vo = webBean.getVo();
		EntityStatus statut = EntityStatus.ENABLED;
		vo.setStatut(statut);
		MenuVO returnVO = (MenuVO) executeCommand(vo, command,
				sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}


	@Override
	public boolean supprimerMenu(MenuWebBean webBean) { 
		String command = Constantes.COMMAND_GERER_MENU;
		String sousCommand = Constantes.SOUS_COMMANDE_SUPPRIMER_MENU;
		MenuVO vo = webBean.getVo();
		EntityStatus statut = EntityStatus.DELETED; 
		vo.setStatut(statut);
		MenuVO returnVO = (MenuVO) executeCommand(vo, command,
				sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}


	@Override
	public boolean modifierMenu(MenuWebBean webBean) {
		String command = Constantes.COMMAND_GERER_MENU;
		String sousCommand = Constantes.SOUS_COMMANDE_MODIFIER_MENU;
		MenuVO vo = webBean.getVo();
		MenuVO returnVO = (MenuVO) executeCommand(vo, command,
				sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}



	
}
