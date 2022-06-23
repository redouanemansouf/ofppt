/*
 * TraceEntityMBean.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.administration.mbean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

//import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.vo.TraceEntityVO;
import com.m2m.onousc.web.administration.webbean.TraceEntityWebBean;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.UserSessionHelper;

/**
 * The Class TraceEntityMBean.
 * 
 * @version 1.0 9 oct. 2015

 * @author iissouani
 *
 */
@ManagedBean
@ViewScoped
public class TraceEntityMBean extends BaseMBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -148933612381819373L;

	private TraceEntityWebBean webBean = new TraceEntityWebBean();

	/** The referentiel service. */
	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");

	
	public String getUserConnecte() {
		String user = UserSessionHelper.getUserConecte().getCode();
		return user == null ? "" : user;
	}
	 
	public void init() {
		webBean = new TraceEntityWebBean();
	}   

	public void resetWebBeanVO() {
		webBean.setVo(new TraceEntityVO());
	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<TraceEntityVO>());
	}

	public TraceEntityWebBean getWebBean() {
		return webBean;
	}

	public void setWebBean(TraceEntityWebBean webBean) {
		this.webBean = webBean;
	}
	
//	@Override
//	protected boolean isAutorise() {
//		return hasEcran(Constantes.CODE_ADM_LOG_TRA);  
//	}
}
