package com.m2m.onousc.web.referentiel.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.vo.FiliereVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.impl.ReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.webbean.FiliereWebBean;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;

/**
 * The Class FiliereMBean.
 */
@ManagedBean
@ViewScoped
public class FiliereMBean extends BaseMBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5316661823094806611L;

	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");

	/** The web bean. */
	private FiliereWebBean webBean;
	UserEntityVO user = referentielService.findUserEntityByCode(userSession.getUserConecte().getCode());

	public void init() {
		webBean = new FiliereWebBean();
		webBean.setListSiteForCombo(referentielService.findAllSite());
//		webBean.setFiliereVOs(referentielService.findAllFiliere());
	}

	/**
	 * Reset web bean vo.
	 */
	public void resetWebBeanVO() {
		webBean.setVo(new FiliereVO());
	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<FiliereVO>());
	}

	/**
	 * Creer.
	 */
	public void creer() {
		clearReport();
		List<FiliereVO> check = referentielService.findFiliereByCode(webBean.getVo().getCode());
		if (check.size() != 0) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Le Code doit être unique", "Doublons"));
		} else {
			if (user.getSiteVO() != null)
				webBean.getVo().setSiteVO(user.getSiteVO());
			ReferentielBusDelegate delegate = new ReferentielBusDelegate();
			error = delegate.creerFiliere(webBean);
			if (!error) {
				addPrezMsgInfo("MESSAGE_SUCCESS_CREATE", null);
				JSFUtils.contextExecute("_hideDialog()");

			}
		}

		feedReport();
	}

	private void prepared() {
//		webBean.getVo().setRestaurantVOs(new ArrayList<RestaurantVO>());
//		for(String id : webBean.getVo().getIdRestaurants()){
//			
//			RestaurantVO fi = referentielService
//					.findRestaurant(Long.parseLong(id));
//			webBean.getVo().getRestaurantVOs().add(fi);
//		}

	}

	/**
	 * Modifier
	 */
	public void modifier() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		// prepared();
		if (user.getSiteVO() != null)
			webBean.getVo().setSiteVO(user.getSiteVO());
		error = delegate.modifierFiliere(webBean);
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
//		if (!webBean.getSelectedVOs().isEmpty()) {
//			ReferentielBusDelegate delegate = new ReferentielBusDelegate();
//			error = delegate.activerFiliere(webBean);
//			if (error) {
//				JSFUtils.contextExecute("_errorDialog()");
//			} else {
//				addPrezMsgInfo("MESSAGE_SUCCESS_ENABLE", null);
//			}
//		} else {
//			addPrezMsgInfo("AUCUN_ELEMENT_SELECTIONE", null);
//		}
		feedReport();
	}

	/**
	 * Desactiver.
	 */
	public void desactiver() {
		clearReport();
//		if (!webBean.getSelectedVOs().isEmpty()) {
//			ReferentielBusDelegate delegate = new ReferentielBusDelegate();
//			error = delegate.desactiverFiliere(webBean);
//			if (error) {
//				JSFUtils.contextExecute("_errorDialog()");
//			} else {
//				addPrezMsgInfo("MESSAGE_SUCCESS_DISABLE", null);
//			}
//		} else {
//			addPrezMsgInfo("AUCUN_ELEMENT_SELECTIONE", null);
//		}
		feedReport();
	}

	public void supprimer() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.supprimerFiliere(webBean);
		if (error) {
			JSFUtils.contextExecute("_errorDialog()");
		} else {
			JSFUtils.contextExecute("_showMessage()");
		}
		feedReport();
	}

	public void supprimerCollection() {
		clearReport();
//		if (!webBean.getSelectedVOs().isEmpty()) {
//			ReferentielBusDelegate delegate = new ReferentielBusDelegate();
//			error = delegate.supprimerCollectionFiliere(webBean);
//			if (error) {
//				JSFUtils.contextExecute("_errorDialog()");
//			} else {
//				addPrezMsgInfo("MESSAGE_SUCCESS_DELETE", null);
//			}
//		} else {
//			addPrezMsgInfo("AUCUN_ELEMENT_SELECTIONE", null);
//		}
		feedReport();
	}

	/**
	 * Gets the web bean.
	 * 
	 * @return the webBean
	 */
	public FiliereWebBean getWebBean() {
		return webBean;
	}

	/**
	 * Sets the web bean.
	 * 
	 * @param webBean the webBean to set
	 */
	public void setWebBean(FiliereWebBean webBean) {
		this.webBean = webBean;
	}

	public void onCycleChange() {
		// webBean.setRestaurantVOs(referentielService.findAllRestaurantForCombo());
	}

	public void codevalidator() {
		List<FiliereVO> check = referentielService.findFiliereByCode(webBean.getVo().getCode());
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
		return hasEcran(Constantes.CODE_GESTION_VENTES_FPROD);
	}

	public UserEntityVO getUser() {
		return user;
	}

	public void setUser(UserEntityVO user) {
		this.user = user;
	}

}
