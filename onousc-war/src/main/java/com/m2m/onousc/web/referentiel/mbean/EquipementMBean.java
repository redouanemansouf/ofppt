package com.m2m.onousc.web.referentiel.mbean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.vo.EquipementVO;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.impl.ReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.webbean.EquipementWebBean;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;

@ManagedBean
@ViewScoped
public class EquipementMBean extends BaseMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8187753755065641208L;

	/** The web bean. */
	private EquipementWebBean webBean;
	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");

	public void init() {
		webBean = new EquipementWebBean();
		webBean.setRestaurantVOs(referentielService.findAllRestaurantForCombo());
		webBean.setCiteVOs(referentielService.findAllCiteForCombo());
	}

	/**
	 * Reset web bean vo.
	 */
	public void resetWebBeanVO() {
		webBean.setVo(new EquipementVO());
	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<EquipementVO>());
	}

	/**
	 * Creer.
	 */
	public void creer() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.creerEquipement(webBean);
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
		error = delegate.modifierEquipement(webBean);
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
			error = delegate.activerEquipement(webBean);
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
			error = delegate.desactiverEquipement(webBean);
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
		error = delegate.supprimerEquipement(webBean);
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
			error = delegate.supprimerEquipement(webBean);
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

	public EquipementWebBean getWebBean() {
		return webBean;
	}

	public void setWebBean(EquipementWebBean webBean) {
		this.webBean = webBean;
	}
	
	public void onCiteChange(String libcite) {
		if (libcite != null
				&& !libcite.equals("")) {
			webBean.setRestaurantVOs(referentielService
					.findAllRestaurantByLibelleCite(libcite));
		} else
			webBean.setRestaurantVOs(referentielService
					.findAllRestaurantForCombo());
	}
	
//	@Override
//	protected boolean isAutorise() {
//		return hasEcran(Constantes.CODE_REF_EQUIPEMENT);  
//	}

}
