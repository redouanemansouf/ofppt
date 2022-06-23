package com.m2m.onousc.web.referentiel.mbean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.vo.MotifOppositionVO;
import com.m2m.onousc.web.referentiel.impl.ReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.webbean.MotifOppositionWebBean;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;

@ManagedBean
@ViewScoped
public class MotifOppositionMBean extends BaseMBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7192840107158921486L;
	/** The web bean. */
	private MotifOppositionWebBean webBean;
	
	public void init() {
		webBean = new MotifOppositionWebBean();
	}
	
	/**
	 * Reset web bean vo.
	 */
	public void resetWebBeanVO() {
		webBean.setVo(new MotifOppositionVO());
	}
	
	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<MotifOppositionVO>());
	}
	
	/**
	 * Creer.
	 */
	public void creer() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.creerMotifOpposition(webBean);
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
		error = delegate.modifierMotifOpposition(webBean);
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
			error = delegate.activerMotifOpposition(webBean);
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
			error = delegate.desactiverMotifOpposition(webBean);
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
		error = delegate.supprimerMotifOpposition(webBean);
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
			error = delegate.supprimerCollectionMotifOpposition(webBean);
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

	public MotifOppositionWebBean getWebBean() {
		return webBean;
	}

	public void setWebBean(MotifOppositionWebBean webBean) {
		this.webBean = webBean;
	}
	
//	@Override
//	protected boolean isAutorise() {
//		return hasEcran(Constantes.CODE_REF_OPP);  
//	}
}
