package com.m2m.onousc.web.referentiel.mbean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.vo.UniversiteVO;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.impl.ReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.webbean.UniversiteWebBean;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;

/**
 * 
 * @author abousnane
 *
 */
@ManagedBean
@ViewScoped
public class UniversiteMBean extends BaseMBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 495396532778485068L;
	
	
	/** The web bean. */
	private UniversiteWebBean webBean;
	
	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");
	
	public void init(){
		webBean = new UniversiteWebBean();
		webBean.setVilleVOs(referentielService.findAllVille());
	}
	
	/**
	 * Reset web bean vo.
	 */
	public void resetWebBeanVO() {
		webBean.setVo(new UniversiteVO());
	}
	
	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<UniversiteVO>());
	}
	/**
	 * Creer universite.
	 */
	public void creer() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.creeUniversite(webBean);
		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_CREATE_1", null);
			JSFUtils.contextExecute("_hideDialog()");
		}
		feedReport();
	}

	/**
	 * Modifier universite.
	 */
	public void modifier() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.modifierUniversite(webBean);
		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_EDIT", null);
			JSFUtils.contextExecute("_hideDialog()");
		}
		feedReport();
	}

	/**
	 * Activer universite.
	 */
	public void activer() {
		clearReport();
		if (!webBean.getSelectedVOs().isEmpty()) {
			ReferentielBusDelegate delegate = new ReferentielBusDelegate();
			error = delegate.activerUniversite(webBean);
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
	 * Desactive universite.
	 */
	public void desactiver() {
		clearReport();
		if (!webBean.getSelectedVOs().isEmpty()) {
			ReferentielBusDelegate delegate = new ReferentielBusDelegate();
			error = delegate.desactiverUniversite(webBean);
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
	/**
	 * Supprimer universite
	 */
	public void supprimer() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.supprimerUniversite(webBean);
		if (error) {
			JSFUtils.contextExecute("_errorDialog()");
		} else {
			addPrezMsgInfo("MESSAGE_SUCCESS_DELETE", null);
		}
		feedReport();
	}
	
	/**
	 * 
	 * @return webBean
	 */
	public UniversiteWebBean getWebBean() {
		return webBean;
	}

	/**
	 * 
	 * @param webBean
	 */
	public void setWebBean(UniversiteWebBean webBean) {
		this.webBean = webBean;
	}
	
//	@Override
//	protected boolean isAutorise() {
//		return hasEcran(Constantes.CODE_REF_GESTION_UNIV);  
//	}
}
