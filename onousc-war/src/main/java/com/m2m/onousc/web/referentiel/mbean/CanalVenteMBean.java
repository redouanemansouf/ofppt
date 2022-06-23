package com.m2m.onousc.web.referentiel.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.vo.CanalVenteVO;
import com.m2m.onousc.business.referentiel.vo.ProduitVO;
import com.m2m.onousc.business.referentiel.vo.RestaurantVO;
import com.m2m.onousc.business.referentiel.vo.SiteVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.impl.ReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.webbean.CanalVenteWebBean;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;

/**
 * The Class CanalVenteMBean.
 */
@ManagedBean
@ViewScoped
public class CanalVenteMBean extends BaseMBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5316661823094806611L;

	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");

	/** The web bean. */
	private CanalVenteWebBean webBean;

	UserEntityVO user = referentielService.findUserEntityByCode(userSession.getUserConecte().getCode());

	@SuppressWarnings("unchecked")
	public void init() {
		webBean = new CanalVenteWebBean();
//		webBean.setFiliereVOs(referentielService.findAllFiliere());
		webBean.setRestaurantVOs(referentielService.findAllRestaurantForCombo());
//		if (user.getSiteVO() != null)
//			webBean.setListSiteForCombo((List<SiteVO>) referentielService.findSite(user.getSiteVO().getId()));
//		else
		webBean.setListSiteForCombo(referentielService.findAllSite());
	}

	/**
	 * Reset web bean vo.
	 */
	public void resetWebBeanVO() {
		webBean.setVo(new CanalVenteVO());
	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<CanalVenteVO>());
	}

	/**
	 * Creer.
	 */
	public void creer() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		List<CanalVenteVO> check = referentielService.findCanalByCode(webBean.getVo().getCode());
		if (check.size() == 0) {
			prepared();
			if (user.getSiteVO() != null)
				webBean.getVo().setSiteVO(user.getSiteVO());

			error = delegate.creerCanalVente(webBean);
			if (!error) {
				addPrezMsgInfo("MESSAGE_SUCCESS_CREATE", null);
				JSFUtils.contextExecute("_hideDialog()");

			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Le Code doit être unique", "Doublons"));
		}

		feedReport();
	}

	private void prepared() {
		webBean.getVo().setRestaurantVOs(new ArrayList<RestaurantVO>());
		for (String id : webBean.getVo().getIdRestaurants()) {

			RestaurantVO fi = referentielService.findRestaurant(Long.parseLong(id));
			webBean.getVo().getRestaurantVOs().add(fi);
		}

	}

	/**
	 * Modifier
	 */
	public void modifier() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		prepared();
		if (user.getSiteVO() != null)
			webBean.getVo().setSiteVO(user.getSiteVO());
		
		error = delegate.modifierCanalVente(webBean);
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
			error = delegate.activerCanalVente(webBean);
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
			error = delegate.desactiverCanalVente(webBean);
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

		List<ProduitVO> isLinked = referentielService.findProduitByFamille(webBean.getVo().getId());
		if (isLinked.size() == 0) {
			error = delegate.supprimerCanalVente(webBean);
			if (!error)
				JSFUtils.contextExecute("_showMessage()");
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Impossible de supprimmer une famille produit liée avec produit", "Error"));
		}
//		if (error) {
//			JSFUtils.contextExecute("_errorDialog()");
		

		feedReport();
	}

	public void supprimerCollection() {
		clearReport();
		if (!webBean.getSelectedVOs().isEmpty()) {
			ReferentielBusDelegate delegate = new ReferentielBusDelegate();
			error = delegate.supprimerCollectionCanalVente(webBean);
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

	/**
	 * Gets the web bean.
	 * 
	 * @return the webBean
	 */
	public CanalVenteWebBean getWebBean() {
		return webBean;
	}

	/**
	 * Sets the web bean.
	 * 
	 * @param webBean the webBean to set
	 */
	public void setWebBean(CanalVenteWebBean webBean) {
		this.webBean = webBean;
	}

	public void onCycleChange() {
		webBean.setRestaurantVOs(referentielService.findAllRestaurantForCombo());
	}

	public void codevalidator() {
//		if(webBean.getVo().getCode().length() != 4)
//		{
//			FacesContext.getCurrentInstance().addMessage(null,
//					 new FacesMessage(FacesMessage.SEVERITY_ERROR,
//					 "Le Code doit 4 charactères" ,"syntaxe"));
//		}

		List<CanalVenteVO> check = referentielService.findCanalByCode(webBean.getVo().getCode());
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
