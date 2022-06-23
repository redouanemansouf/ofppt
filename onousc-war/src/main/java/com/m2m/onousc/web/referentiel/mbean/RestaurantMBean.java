package com.m2m.onousc.web.referentiel.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.vo.RestaurantVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.impl.ReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.webbean.RestaurantWebBean;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;

@ManagedBean
@ViewScoped
public class RestaurantMBean extends BaseMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1709290569714851532L;
	/** The web bean. */
	private RestaurantWebBean webBean;
	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");

	UserEntityVO user = referentielService.findUserEntityByCode(userSession.getUserConecte().getCode());

	public void init() {
		webBean = new RestaurantWebBean();
		// webBean.setCiteVOs(referentielService.findAllCiteForCombo());
		webBean.setVilleVOs(referentielService.findAllVille());
		webBean.setListSiteForCombo(referentielService.findAllSite());
	}

	/**
	 * Reset web bean vo.
	 */
	public void resetWebBeanVO() {
		webBean.setVo(new RestaurantVO());
	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<RestaurantVO>());
	}

	/**
	 * Creer.
	 */
	public void creer() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		List<RestaurantVO> check = referentielService.findRestaurantListByCode(webBean.getVo().getCode());
		if (check.size() != 0) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Le Code doit être unique", "Doublons"));
		} else {

			if (user.getSiteVO() != null)
				webBean.getVo().setSiteVO(user.getSiteVO());
			error = delegate.creerRestaurant(webBean);
			if (!error) {
				addPrezMsgInfo("MESSAGE_SUCCESS_EDIT", null);
				JSFUtils.contextExecute("_hideDialog()");
			}
			feedReport();
		}
	}

	/**
	 * Modifier
	 */
	public void modifier() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();

		if (user.getSiteVO() != null)
			webBean.getVo().setSiteVO(user.getSiteVO());
		error = delegate.modifierRestaurant(webBean);
		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_EDIT", null);
			JSFUtils.contextExecute("_hideDialog()");
		}
		feedReport();
	}

	/**
	 * Activer.
	 */
	public void activer() {
		clearReport();
		if (!webBean.getSelectedVOs().isEmpty()) {
			ReferentielBusDelegate delegate = new ReferentielBusDelegate();
			error = delegate.activerRestaurant(webBean);
			if (error) {
				JSFUtils.contextExecute("_errorDialog()");
			} else {
				addPrezMsgInfo("MESSAGE_SUCCESS_ENABLE", null);
			}
		} else {
			addPrezMsgInfo("AUCUN_ELEMENT_SELECTIONE", null);
		}
		feedReport();
	}

	/**
	 * Desactiver.
	 */
	public void desactiver() {
		clearReport();
		if (!webBean.getSelectedVOs().isEmpty()) {
			ReferentielBusDelegate delegate = new ReferentielBusDelegate();
			error = delegate.desactiverRestaurant(webBean);
			if (error) {
				JSFUtils.contextExecute("_errorDialog()");
			} else {
				addPrezMsgInfo("MESSAGE_SUCCESS_DISABLE", null);
			}
		} else {
			addPrezMsgInfo("AUCUN_ELEMENT_SELECTIONE", null);
		}
		feedReport();
	}

	public void supprimer() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.supprimerRestaurant(webBean);
		if (error) {
			JSFUtils.contextExecute("_errorDialog()");
		} else {
			JSFUtils.contextExecute("_showMessage()");
		}
		feedReport();
	}

	public void supprimerCollection() {
		clearReport();
		if (!webBean.getSelectedVOs().isEmpty()) {
			ReferentielBusDelegate delegate = new ReferentielBusDelegate();
			error = delegate.supprimerRestaurant(webBean);
			if (error) {
				JSFUtils.contextExecute("_errorDialog()");
			} else {
				addPrezMsgInfo("MESSAGE_SUCCESS_DELETE", null);
			}
		} else {
			addPrezMsgInfo("AUCUN_ELEMENT_SELECTIONE", null);
		}
		feedReport();
	}

	public RestaurantWebBean getWebBean() {
		return webBean;
	}

	public void setWebBean(RestaurantWebBean webBean) {
		this.webBean = webBean;
	}

	public void codevalidator() {

		List<RestaurantVO> check = referentielService.findRestaurantListByCode(webBean.getVo().getCode());
		if (check.size() != 0) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Le Code doit être unique", "Doublons"));
		}

	}

	public void showMessage() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Operation effectuée avec succès"));
		feedReport();
	}

	@Override
	protected boolean isAutorise() {
		return hasEcran(Constantes.CODE_REF_RESTAURANT);
	}

	public UserEntityVO getUser() {
		return user;
	}

	public void setUser(UserEntityVO user) {
		this.user = user;
	}

}
