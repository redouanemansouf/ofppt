/*
 * AdministrationBusDelegate.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.administration.impl;

import javax.validation.groups.Default;

import com.m2m.onousc.business.referentiel.Constantes; 
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.business.utils.RandomStringGenerator;
import com.m2m.onousc.web.administration.IUserEntityBusDelegate;
import com.m2m.onousc.web.administration.webbean.UserEntityWebBean;
import com.m2m.technicalservices.core.UserContext;
import com.m2m.technicalservices.web.BaseBusDelegate;

/**
 * @author iissouani
 *
 */
public class UserEntityBusDelegate extends BaseBusDelegate implements
		IUserEntityBusDelegate {

	/**
	 * Instantiates a new administration bus delegate.
	 */
	public UserEntityBusDelegate() {

		domaine = "ADMINISTRATION";
		/*
		 * Toujours initier le groupe de validation
		 */
		Class<?>[] groups = { Default.class };
		UserContext.setValidationGroups(groups);
	}

	@Override
	public boolean creerUserEntity(UserEntityWebBean webBean) {
		String command = Constantes.COMMAND_GERER_USER_ENTITY;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_USER_ENTITY;
		UserEntityVO vo = webBean.getVo();
		vo.setStatut("ENABLED");
		try {
			vo.setPassword(RandomStringGenerator.generateRandomString(8,RandomStringGenerator.Mode.ALPHANUMERIC));
//			vo.setPassword("12345678");
		} catch (Exception e) {
			e.printStackTrace();
		}
		vo.setPassword1(vo.getPassword()); 
		UserEntityVO returnVO = (UserEntityVO) executeCommand(vo, command,
				sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean supprimerUserEntity(UserEntityWebBean webBean) {
		String command = Constantes.COMMAND_GERER_USER_ENTITY;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_USER_ENTITY;
		UserEntityVO vo = webBean.getVo();
		vo.setPassword1(vo.getPassword());   
		vo.setStatut("DELETED");
		UserEntityVO returnVO = (UserEntityVO) executeCommand(vo, command,
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
	public boolean modifierUserEntity(UserEntityWebBean webBean) {
		String command = Constantes.COMMAND_GERER_USER_ENTITY;
		String sousCommand = Constantes.SOUS_COMMAND_MODIFIER_USER_ENTITY;
		UserEntityVO vo = webBean.getVo();
		UserEntityVO returnVO = (UserEntityVO) executeCommand(vo, command,
				sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean changerPwdForUserEntity(UserEntityWebBean webBean) {
		String command = Constantes.COMMAND_GERER_USER_ENTITY;
		String sousCommand = Constantes.SOUS_COMMAND_CHANGEPWD_USER_ENTITY;
		UserEntityVO vo = webBean.getVo();
		UserEntityVO returnVO = (UserEntityVO) executeCommand(vo, command,
				sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	
}
