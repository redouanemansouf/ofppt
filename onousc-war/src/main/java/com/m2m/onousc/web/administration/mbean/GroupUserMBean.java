/*
 * AdministrationMBean.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.administration.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.m2m.onousc.business.referentiel.vo.GroupUserVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.web.administration.impl.GroupUserBusDelegate;
import com.m2m.onousc.web.administration.webbean.GroupUserWebBean;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;

/**
 * The Class AdministrationMBean.
 * 
 * @version 1.0 9 oct. 2015
 * 
 * @author iissouani
 *
 */
@ManagedBean
@ViewScoped
public class GroupUserMBean extends BaseMBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -148933612381819373L;

	private GroupUserWebBean webBean = new GroupUserWebBean();
	
	ReferentielSrvPresentation referentielSrvPresentation = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");
	
	public void init() {
		webBean = new GroupUserWebBean();

	}

	public void resetWebBeanVO() {
		webBean.setVo(new GroupUserVO());
		webBean.setGroupe(false);
	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<GroupUserVO>());
	}

	/**
	 * Creer.
	 */
	public void creer() {
		clearReport();
		GroupUserBusDelegate delegate = new GroupUserBusDelegate();
		error = delegate.creerGroupUser(webBean);
		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_CREATE_1", null);
			JSFUtils.contextExecute("_hideDialog()");
		}
		feedReport();
	}

	/**
	 * Modifier
	 */
	public void modifier() {
		clearReport();
		GroupUserBusDelegate delegate = new GroupUserBusDelegate();
	
		error = delegate.modifierGroupUser(webBean);
		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_EDIT", null);
			JSFUtils.contextExecute("_hideDialog()");
		}
		feedReport();
	}

	/**
	 * Supprimer
	 */
	public void supprimer() {
		List<UserEntityVO> deleteGroupUser = referentielSrvPresentation.findUserByGroup(webBean.getVo().getGroupname());
		if(deleteGroupUser.size() == 0){
		clearReport();
		GroupUserBusDelegate delegate = new GroupUserBusDelegate();
		error = delegate.supprimerGroupUser(webBean);
		}
		else{
			error=true;
			message();
			
		}
		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_DELETE", null);
			feedReport();
		}
		
	}
	
	public void message()
	{

		
		FacesContext.getCurrentInstance().addMessage(null,
				 new FacesMessage(FacesMessage.SEVERITY_ERROR,
				 "Le groupe est déjà attribué a un utilisateur" ,"error"));
		

	}


	/**
	 * @return
	 */
	public GroupUserWebBean getWebBean() {
		return webBean;
	}

	/**
	 * @param webBean
	 */
	public void setWebBean(GroupUserWebBean webBean) {
		this.webBean = webBean;
	}

	

	// @Override
	// protected boolean isAutorise() {
	// if(JSFUtils.getRequestURI().contains("pwdOublie") ||
	// JSFUtils.getRequestURI().contains("inscription"))
	// return true;
	// return hasEcran(Constantes.CODE_ADM_USER_ENTITY);
	// }
}
