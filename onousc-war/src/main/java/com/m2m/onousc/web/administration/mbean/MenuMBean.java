/*
 * MenuMBean.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.administration.mbean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.vo.MenuVO;
import com.m2m.onousc.web.administration.impl.MenuBusDelegate;
import com.m2m.onousc.web.administration.webbean.MenuWebBean;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;
import com.m2m.technicalservices.web.UserSessionHelper;

/**
 * The Class AdministrationMBean.
 * 
 * @version 1.0 9 oct. 2015

 * @author iissouani
 *
 */
@ManagedBean
@ViewScoped
public class MenuMBean extends BaseMBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -148933612381819373L;

	private MenuWebBean webBean = new MenuWebBean();

	/** The referentiel service. */
	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");

	
	public String getUserConnecte() {
		String user = UserSessionHelper.getUserConecte().getCode();
		return user == null ? "" : user;
	}
	
	public void init() {
		webBean = new MenuWebBean();
	}

	public void resetWebBeanVO() {
		webBean.setVo(new MenuVO());
	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<MenuVO>());
	}


	/**
	 * Modifier
	 */
	public void modifier() {
		clearReport();
		MenuBusDelegate delegate = new MenuBusDelegate();
		error = delegate.modifierMenu(webBean);
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
		clearReport();
		MenuBusDelegate delegate = new MenuBusDelegate();
		error = delegate.supprimerMenu(webBean);
		if (error) {
			JSFUtils.contextExecute("_errorDialog()");
		} else {
			addPrezMsgInfo("MESSAGE_SUCCESS_DELETE", null);
		}
		feedReport(); 
	}

	/**
	 */
	/**
	 * 
	 */
	public void creer() {
		clearReport();
		MenuBusDelegate delegate = new MenuBusDelegate();
		error = delegate.creerMenu(webBean);
		if (error) {
			JSFUtils.contextExecute("_errorDialog()");
		} else {
			addPrezMsgInfo("MESSAGE_SUCCESS_CREATE_1", null); 
		}
		feedReport(); 
	}

	public MenuWebBean getWebBean() {
		return webBean;
	}

	public void setWebBean(MenuWebBean webBean) {
		this.webBean = webBean;
	}

	public ReferentielSrvPresentation getReferentielService() {
		return referentielService;
	}

	public void setReferentielService(ReferentielSrvPresentation referentielService) {
		this.referentielService = referentielService;
	}


}
