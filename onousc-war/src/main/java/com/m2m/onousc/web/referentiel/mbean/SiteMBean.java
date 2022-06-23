package com.m2m.onousc.web.referentiel.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.vo.CanalVenteVO;
import com.m2m.onousc.business.referentiel.vo.SiteVO;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.impl.ReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.webbean.SiteWebBean;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;

/**
 * The Class SiteMBean.
 */
@ManagedBean
@ViewScoped
public class SiteMBean extends BaseMBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5316661823094806611L;

	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");

	/** The web bean. */
	private SiteWebBean webBean;

	public void init() {
		webBean = new SiteWebBean();
		webBean.setVilleVOs(referentielService.findAllVille());
//		webBean.setFiliereVOs(referentielService.findAllFiliere());
//		webBean.setRestaurantVOs(referentielService.findAllRestaurantForCombo());
	}

	/**
	 * Reset web bean vo.
	 */
	public void resetWebBeanVO() {
		webBean.setVo(new SiteVO());
	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<SiteVO>());
	}

	/**
	 * Creer.
	 */
	public void creer() {
		clearReport();
		List<SiteVO> check = referentielService.findSiteByCode(webBean.getVo().getCode());
		if (check.size() != 0) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Le Code doit être unique", "Doublons"));
		} else {
			ReferentielBusDelegate delegate = new ReferentielBusDelegate();
			error = delegate.creerSite(webBean);
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
		error = delegate.modifierSite(webBean);
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
//			error = delegate.activerSite(webBean);
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
//			error = delegate.desactiverSite(webBean);
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
		error = delegate.supprimerSite(webBean);
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
//			error = delegate.supprimerCollectionSite(webBean);
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
	public SiteWebBean getWebBean() {
		return webBean;
	}

	/**
	 * Sets the web bean.
	 * 
	 * @param webBean the webBean to set
	 */
	public void setWebBean(SiteWebBean webBean) {
		this.webBean = webBean;
	}

	public void onCycleChange() {
		// webBean.setRestaurantVOs(referentielService.findAllRestaurantForCombo());
	}

	public void codevalidator() {
		List<SiteVO> check = referentielService.findSiteByCode(webBean.getVo().getCode());
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

}
