package com.m2m.onousc.web.referentiel.mbean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.vo.CycleVieVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.impl.ReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.webbean.CycleVieWebBean;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;

@ManagedBean
@ViewScoped
public class CycleVieMBean extends BaseMBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 495396532778485068L;

	/** The web bean. */
	private CycleVieWebBean webBean;
	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");
	UserEntityVO user = referentielService.findUserEntityByCode(userSession.getUserConecte().getCode());
	private boolean activeOpp = false;

	public void init() {
		webBean = new CycleVieWebBean();
//		webBean.setEtudiantVOs(referentielService.findAllEtudiantforCombo());
		webBean.setOpposVOs(referentielService.findAllMotifOppositionForCombo());
		webBean.setMotifMainVOs(referentielService.findAllMotifMainLeveeForCombo());
		webBean.setListSiteForCombo(referentielService.findAllSite());

	}

	/**
	 * Reset web bean vo.
	 */
	public void resetWebBeanVO() {
		webBean.setVo(new CycleVieVO());
		;
	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<CycleVieVO>());
	}

	public CycleVieWebBean getWebBean() {
		return webBean;
	}

	public void setWebBean(CycleVieWebBean webBean) {
		this.webBean = webBean;
	}

	public void delivrer() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.delivrerCarte(webBean);
		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_DELIVRED", null);
			JSFUtils.contextExecute("_hideDialog()");
		}
		feedReport();

	}

	public void mettreEnOpposition() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		if (referentielService.findCycleVieByCode(webBean.getVo().getNumSerie()).size() != 0) {
			CycleVieVO nvo = referentielService.findCycleVieByCode(webBean.getVo().getNumSerie()).get(0);
			webBean.getVo().setEtudvo(nvo.getEtudvo());
			error = delegate.mettreEnOpposition(webBean);
		} else if (referentielService.findCycleVieByCode(webBean.getVo().getNumSerie()).size() == 0) {
			addPrezMsgInfo("opposition.rule1", null);
			error = true;
		}

		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_OPPOSITION", null);
			JSFUtils.contextExecute("_hideDialog()");
		}
		feedReport();

	}

	public void deliverCollectionCarte() {
		clearReport();
		if (!webBean.getSelectedVOs().isEmpty()) {
			ReferentielBusDelegate delegate = new ReferentielBusDelegate();
			error = delegate.delivrerCollectionCarte(webBean);
			if (error) {
				JSFUtils.contextExecute("_errorDialog()");
			} else {
				addPrezMsgInfo("MESSAGE_SUCCESS_DELIVRED", null);
			}
		} else {
			addPrezMsgInfo("AUCUN_ELEMENT_SELECTIONE", null);
		}
		feedReport();
	}

	public void mettreEnOpposition2() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();

		webBean.setVo(webBean.getSelectedVO());
		error = delegate.mettreEnOpposition(webBean);

		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_OPPOSITION", null);
			JSFUtils.contextExecute("_hideDialog()");
		}
		feedReport();
	}

	/**
	 * 
	 * @return webBean
	 */

//	@Override
//	protected boolean isAutorise() {
//		return hasEcran(Constantes.CODE_ENR_CYV);
//	}

	public boolean isActiveOpp() {
		if (webBean.getSelectedVOs().size() == 0)
			activeOpp = false;
		else
			activeOpp = true;

		return activeOpp;
	}

	public UserEntityVO getUser() {
		return user;
	}

	public void setUser(UserEntityVO user) {
		this.user = user;
	}

}
