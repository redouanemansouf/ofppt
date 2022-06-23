/*
 * AdministrationMBean.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.administration.mbean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.vo.WinMenuVO;
import com.m2m.onousc.web.administration.impl.WinMenuBusDelegate;
import com.m2m.onousc.web.administration.webbean.WinMenuWebBean;
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
public class WinMenuMBean extends BaseMBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -148933612381819373L;

	private WinMenuWebBean webBean = new WinMenuWebBean();

	/** The referentiel service. */
	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");

	
	public String getUserConnecte() {
		String user = UserSessionHelper.getUserConecte().getCode();
		return user == null ? "" : user;
	}
	
	public void init() {
		webBean = new WinMenuWebBean();
		webBean.setWinMenuModules(referentielService.findWinMenuModule());
		webBean.setUsers(referentielService.findAllUserEnabled());
		webBean.setMenus(referentielService.findAllMenu());
		webBean.setGroups(referentielService.findAllgroup());
	}

	public void resetWebBeanVO() {
		webBean.setVo(new WinMenuVO());
	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<WinMenuVO>());
	}
	
	public void creer() {
		clearReport();
		WinMenuBusDelegate delegate = new WinMenuBusDelegate();
		error = delegate.creerWinMenu(webBean);
		if (error) {
			JSFUtils.contextExecute("_errorDialog()");
		} else {
			addPrezMsgInfo("MESSAGE_SUCCESS_DELETE", null);
		}
		feedReport(); 
	}


	/**
	 * Modifier
	 */
	public void modifier() {
		clearReport();
		WinMenuBusDelegate delegate = new WinMenuBusDelegate();
		error = delegate.modifierWinMenu(webBean);
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
		WinMenuBusDelegate delegate = new WinMenuBusDelegate();
		error = delegate.supprimerWinMenu(webBean);
		if (error) {
			JSFUtils.contextExecute("_errorDialog()");
		} else {
			addPrezMsgInfo("MESSAGE_SUCCESS_DELETE", null);
		}
		feedReport(); 
	}

	public WinMenuWebBean getWebBean() {
		return webBean;
	}

	public void setWebBean(WinMenuWebBean webBean) {
		this.webBean = webBean;
	}

	public ReferentielSrvPresentation getReferentielService() {
		return referentielService;
	}

	public void setReferentielService(ReferentielSrvPresentation referentielService) {
		this.referentielService = referentielService;
	}
	
public void togleState(int action,Object obj){
		
		
		webBean.setVo((WinMenuVO)obj);
		
		switch (action) {
		case 1 :
			webBean.getVo().setActif(!webBean.getVo().isActif());
			break;
		case 2 :
			webBean.getVo().setDroitConsult(!webBean.getVo().isDroitConsult());
			break;
		case 3  :
			webBean.getVo().setDroitCreat(!webBean.getVo().isDroitCreat());
			if(webBean.getVo().isDroitCreat()){
				webBean.getVo().setActif(true);
				webBean.getVo().setDroitConsult(true);
			}
			break;
		case 4  :
			webBean.getVo().setDroitModif(!webBean.getVo().isDroitModif());
			if(webBean.getVo().isDroitModif()){
				webBean.getVo().setActif(true);
				webBean.getVo().setDroitConsult(true);
			}
			break;
		case 5  :
			webBean.getVo().setDroitSuppr(!webBean.getVo().isDroitSuppr());
			if(webBean.getVo().isDroitSuppr()){
				webBean.getVo().setActif(true);
				webBean.getVo().setDroitConsult(true);
			}
			break;
		default:
			break;
		}
	
		clearReport();
		WinMenuBusDelegate delegate = new WinMenuBusDelegate();
		error = delegate.modifierWinMenu(webBean);
		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_EDIT", null);
		}
		feedReport();
	}

//	@Override
//	protected boolean isAutorise() {
//		if(JSFUtils.getRequestURI().contains("listerWinMenuG.xhtml")){
//		return hasEcran(Constantes.CODE_ADM_WIN_MENUG);  
//		}else{
//			return hasEcran(Constantes.CODE_ADM_WIN_MENU);  
//		}
//	} 
}
