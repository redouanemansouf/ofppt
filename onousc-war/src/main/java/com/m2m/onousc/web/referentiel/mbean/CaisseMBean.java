package com.m2m.onousc.web.referentiel.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.m2m.onousc.business.referentiel.vo.CaisseVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.impl.ReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.webbean.CaisseWebBean;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;

@ManagedBean
@ViewScoped
public class CaisseMBean extends BaseMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8187753755065641208L;

	/** The web bean. */
	private CaisseWebBean webBean;
	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");

	UserEntityVO user = referentielService.findUserEntityByCode(userSession.getUserConecte().getCode());

	public void init() {
		webBean = new CaisseWebBean();
		webBean.setListSiteForCombo(referentielService.findAllSite());
		
		if (user.getSiteVO() != null)
			webBean.setRestaurantVOs(referentielService.findRestaurantByIdSite(user.getSiteVO().getId()));
		else
			webBean.setRestaurantVOs(referentielService.findAllRestaurantForCombo());

	}

	/**
	 * Reset web bean vo.
	 */
	public void resetWebBeanVO() {
		webBean.setVo(new CaisseVO());
	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<CaisseVO>());
	}

	/**
	 * Creer.
	 */
	public void creer() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		List<CaisseVO> check = referentielService.findCaisseListByCode(webBean.getVo().getCode());
		if (check.size() != 0) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Le Code doit être unique", "Doublons"));
		} else {
			if (user.getSiteVO() != null)
				webBean.getVo().setSiteVO(user.getSiteVO());
			error = delegate.creerCaisse(webBean);
			if (!error) {
				FacesMessage message = new FacesMessage("Validation Effectuée");
				FacesContext.getCurrentInstance().addMessage(null, message);

//			FacesContext.getCurrentInstance().addMessage(null,
//					 new FacesMessage(FacesMessage.SEVERITY_INFO,
//					 "Element ajouté avec succès" ,"Succes"));
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
		error = delegate.modifierCaisse(webBean);
		if (!error) {
			FacesMessage message = new FacesMessage("Modification Effectuée");
			FacesContext.getCurrentInstance().addMessage(null, message);
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
			error = delegate.activerCaisse(webBean);
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
			error = delegate.desactiverCaisse(webBean);
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
		error = delegate.supprimerCaisse(webBean);
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
			error = delegate.supprimerCaisse(webBean);
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

	public CaisseWebBean getWebBean() {
		return webBean;
	}

	public void setWebBean(CaisseWebBean webBean) {
		this.webBean = webBean;
	}

	public void codevalidator() {

		List<CaisseVO> check = referentielService.findCaisseListByCode(webBean.getVo().getCode());
		if (check.size() != 0) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Le Code doit être unique", "Doublons"));
		}

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
