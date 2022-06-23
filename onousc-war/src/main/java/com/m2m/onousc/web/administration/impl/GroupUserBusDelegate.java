/*
 * AdministrationBusDelegate.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.administration.impl;

import javax.validation.groups.Default;

import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.vo.GroupUserVO;
import com.m2m.onousc.web.administration.IGroupUserBusDelegate;
import com.m2m.onousc.web.administration.webbean.GroupUserWebBean;
import com.m2m.technicalservices.core.UserContext;
import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.technicalservices.web.BaseBusDelegate;


public class GroupUserBusDelegate extends BaseBusDelegate implements
		IGroupUserBusDelegate {

	/**
	 * Instantiates a new administration bus delegate.
	 */
	public GroupUserBusDelegate() {

		domaine = "ADMINISTRATION";
		/*
		 * Toujours initier le groupe de validation
		 */
		Class<?>[] groups = { Default.class };
		UserContext.setValidationGroups(groups);
	}

	@Override
	public boolean creerGroupUser(GroupUserWebBean webBean) {
		String command = Constantes.COMMAND_GERER_GROUP_USER;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_GROUP_USER;
		GroupUserVO vo = webBean.getVo();
		webBean.getVo().setStatut(EntityStatus.ENABLED);
		vo.setStatut(EntityStatus.ENABLED);
		vo.setLibelle(vo.getLibelle());
		GroupUserVO returnVO = (GroupUserVO) executeCommand(vo, command,
				sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}


	/* (non-Javadoc)
	 * @see com.m2m.onousc.web.administration.IGroupUserBusDelegate#modifierGroupUser(com.m2m.onousc.web.administration.webbean.GroupUserWebBean)
	 */
	@Override
	public boolean modifierGroupUser(GroupUserWebBean webBean) {
		String command = Constantes.COMMAND_GERER_GROUP_USER;
		String sousCommand = Constantes.SOUS_COMMAND_MODIFIER_GROUP_USER;
		GroupUserVO vo = webBean.getVo();
		
		GroupUserVO returnVO = (GroupUserVO) executeCommand(vo, command,
				sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}


	@Override
	public boolean supprimerGroupUser(GroupUserWebBean webBean) {
		String command = Constantes.COMMAND_GERER_GROUP_USER;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_GROUP_USER; 
		GroupUserVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		GroupUserVO returnVO = (GroupUserVO) executeCommand(vo, command,
				sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	
}
