package com.m2m.onousc.web.referentiel.mbean;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.vo.DemandeAdminVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.impl.ReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.webbean.DemandeAdminWebBean;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;

@ManagedBean
@ViewScoped
public class DemandeAdminMBean extends BaseMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8187753755065641208L;

	/** The web bean. */
	private DemandeAdminWebBean webBean;
	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");

	UserEntityVO user = referentielService.findUserEntityByCode(userSession.getUserConecte().getCode());

	public void init() {
		webBean = new DemandeAdminWebBean();

	}

	/**
	 * Reset web bean vo.
	 */
	public void resetWebBeanVO() {
		webBean.setVo(new DemandeAdminVO());
	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<DemandeAdminVO>());
	}

	/**
	 * Valider
	 */
	public void valider() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		webBean.getVo().setStatut(EntityStatus.VALIDATED);
		error = delegate.validerDemandeAdmin(webBean);
		if (!error) {
			FacesMessage message = new FacesMessage("Validation Effectuée");
			FacesContext.getCurrentInstance().addMessage(null, message);
			JSFUtils.contextExecute("_hideDialog()");
		}
		feedReport();
	}

	public void supprimer() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		webBean.getVo().setStatut(EntityStatus.REJECTED);
		error = delegate.rejeterDemandeAdmin(webBean);
		if (error) {
			JSFUtils.contextExecute("_errorDialog()");
		} else {
			JSFUtils.contextExecute("_showMessage()");
		}

		feedReport();
	}

	public DemandeAdminWebBean getWebBean() {
		return webBean;
	}

	public void setWebBean(DemandeAdminWebBean webBean) {
		this.webBean = webBean;
	}

	public void showMessage() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Operation effectuée avec succès"));
		feedReport();
	}

	public UserEntityVO getUser() {
		return user;
	}

	public void setUser(UserEntityVO user) {
		this.user = user;
	}

}
