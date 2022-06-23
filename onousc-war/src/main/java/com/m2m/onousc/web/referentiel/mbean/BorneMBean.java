package com.m2m.onousc.web.referentiel.mbean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.vo.BorneVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.impl.ReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.webbean.BorneWebBean;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;

@ManagedBean
@ViewScoped
public class BorneMBean extends BaseMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8187753755065641208L;

	/** The web bean. */
	private BorneWebBean webBean;
	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");

	UserEntityVO user = referentielService.findUserEntityByCode(userSession.getUserConecte().getCode());

	public void init() {
		webBean = new BorneWebBean();
		webBean.setSiteVOs(referentielService.findAllSite());
	}

	/**
	 * Reset web bean vo.
	 */
	public void resetWebBeanVO() {
		webBean.setVo(new BorneVO());
	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<BorneVO>());
	}

	/**
	 * Creer.
	 */
	public void creer() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.creeBorne(webBean);
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
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.modifierBorne(webBean);
		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_EDIT", null);
			JSFUtils.contextExecute("_hideDialog()");
		}
		feedReport();
	}

	public void supprimer() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.supprimerBorne(webBean);
		if (error) {
			JSFUtils.contextExecute("_errorDialog()");
		} else {
			addPrezMsgInfo("MESSAGE_SUCCESS_DELETE", null);
		}
		feedReport();
	}

	public BorneWebBean getWebBean() {
		return webBean;
	}

	public void setWebBean(BorneWebBean webBean) {
		this.webBean = webBean;
	}

	public UserEntityVO getUser() {
		return user;
	}

	public void setUser(UserEntityVO user) {
		this.user = user;
	}

//	@Override
//	protected boolean isAutorise() {
//		return hasEcran(Constantes.CODE_REF_ANNEE_UNIV);  
//	}

}
