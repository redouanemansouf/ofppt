/*
 * AdministrationBusDelegate.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.administration.impl;

import javax.validation.groups.Default;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.Constantes; 
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.business.referentiel.vo.WinMenuVO;
import com.m2m.onousc.business.utils.RandomStringGenerator;
import com.m2m.onousc.web.administration.IUserEntityBusDelegate;
import com.m2m.onousc.web.administration.IWinMenuBusDelegate;
import com.m2m.onousc.web.administration.webbean.UserEntityWebBean;
import com.m2m.onousc.web.administration.webbean.WinMenuWebBean;
import com.m2m.technicalservices.core.UserContext;
import com.m2m.technicalservices.web.BaseBusDelegate;

/**
 * @author iissouani
 *
 */
public class WinMenuBusDelegate extends BaseBusDelegate implements
		IWinMenuBusDelegate {

	/**
	 * Instantiates a new administration bus delegate.
	 */
	public WinMenuBusDelegate() {

		domaine = "ADMINISTRATION";
		/*
		 * Toujours initier le groupe de validation
		 */
		Class<?>[] groups = { Default.class };
		UserContext.setValidationGroups(groups);
	}
	
	


	@Override
	public boolean supprimerWinMenu(WinMenuWebBean webBean) {
		String command = Constantes.COMMAND_GERER_WIN_MENU;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_WIN_MENU;
		WinMenuVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED.toString());
		WinMenuVO returnVO = (WinMenuVO) executeCommand(vo, command,
				sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}


	/* (non-Javadoc)
	 * @see com.m2m.onousc.web.administration.IAdministrationBusDelegate#modifierUserEntity(com.m2m.onousc.web.administration.webbean.AdministrationWebBean)
	 */
	@Override
	public boolean modifierWinMenu(WinMenuWebBean webBean) {
		String command = Constantes.COMMAND_GERER_WIN_MENU;
		String sousCommand = Constantes.SOUS_COMMAND_MODIFIER_WIN_MENU;
		WinMenuVO vo = webBean.getVo();
		WinMenuVO returnVO = (WinMenuVO) executeCommand(vo, command,
				sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}




	@Override
	public boolean creerWinMenu(WinMenuWebBean webBean) {
		String command = Constantes.COMMAND_GERER_WIN_MENU;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_WIN_MENU;		
		WinMenuVO vo = webBean.getVo();
		vo.setOperateur(vo.getOperateur());
		vo.setAbbrev("GDP");
		vo.setCode("000011");
		vo.setLibelle("ENROLLEMENT PERSONNEL");
		vo.setActif(false);
		vo.setDroitConsult(false);
		vo.setDroitCreat(false);
		vo.setDroitModif(false);
		vo.setDroitSuppr(false);
		vo.setLangue("FR");
		vo.setStatut(EntityStatus.ENABLED.toString());
		vo.setType("G");
		WinMenuVO returnVO = (WinMenuVO) executeCommand(vo, command,
				sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	
}
