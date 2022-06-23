package com.m2m.onousc.web.referentiel.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.CategoriePorteurVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.impl.ReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.webbean.CategoriePorteurWebBean;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;

@ManagedBean
@ViewScoped
public class CategoriePorteurMBean extends BaseMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7192840107158921486L;
	/** The web bean. */
	private CategoriePorteurWebBean webBean;
	private String cat;

	ReferentielService referentielSrc = (ReferentielService) BeansLookuper.lookup("referentielService");

	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");

	UserEntityVO user = referentielService.findUserEntityByCode(userSession.getUserConecte().getCode());

	public void init() {
		webBean = new CategoriePorteurWebBean();
		webBean.setListSiteForCombo(referentielService.findAllSite());
	}

	/**
	 * Reset web bean vo.
	 */
	public void resetWebBeanVO() {
		webBean.setVo(new CategoriePorteurVO());
	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<CategoriePorteurVO>());
	}

	/**
	 * Creer.
	 */
	public void creer() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		if (user.getSiteVO() != null)
			webBean.getVo().setSiteVO(user.getSiteVO());
		
		error = delegate.creerCategoriePorteur(webBean);
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
		if (user.getSiteVO() != null)
			webBean.getVo().setSiteVO(user.getSiteVO());
		error = delegate.modifierCategoriePorteur(webBean);
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
			error = delegate.activerCategoriePorteur(webBean);
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
			error = delegate.desactiverCategoriePorteur(webBean);
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
		error = delegate.supprimerCategoriePorteur(webBean);
		if (error) {
			JSFUtils.contextExecute("_errorDialog()");
		} else {
			addPrezMsgInfo("MESSAGE_SUCCESS_DELETE", null);
		}
		feedReport();
	}

	public void supprimerCollection() {
		clearReport();
		if (!webBean.getSelectedVOs().isEmpty()) {
			ReferentielBusDelegate delegate = new ReferentielBusDelegate();
			error = delegate.supprimerCollectionCategoriePorteur(webBean);
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

	public CategoriePorteurWebBean getWebBean() {
		return webBean;
	}

	public void setWebBean(CategoriePorteurWebBean webBean) {
		this.webBean = webBean;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public void onCycleChange() {
		cat = webBean.getVo().getCategorie();
	}

	public void codevalidator() {

		List<CategoriePorteurVO> check = referentielService.findCategoriePorteurListByCode(webBean.getVo().getCode());
		if (check.size() != 0) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Le Code doit être unique", "Doublons"));
		}

	}

//	@Override
//	protected boolean isAutorise() {
//		if(JSFUtils.getRequestURI().contains("gestionProfilPorteur.xhtml")){
//			return hasEcran(Constantes.CODE_REF_CAT_PORT);  
//			}
//		return hasEcran(Constantes.CODE_REF_CAT_PORT);
//	}

	@Override
	protected boolean isAutorise() {
		return hasEcran(Constantes.CODE_REF_CAT_PORT);
	}

	public UserEntityVO getUser() {
		return user;
	}

	public void setUser(UserEntityVO user) {
		this.user = user;
	}

}
