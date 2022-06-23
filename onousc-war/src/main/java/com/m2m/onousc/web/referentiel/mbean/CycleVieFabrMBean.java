package com.m2m.onousc.web.referentiel.mbean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.CarteVO;
import com.m2m.onousc.business.referentiel.vo.CycleVieVO;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.impl.ReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.webbean.CycleVieWebBean;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;

@ManagedBean
@ViewScoped
public class CycleVieFabrMBean extends BaseMBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 495396532778485068L;

	/** The web bean. */
	private CycleVieWebBean webBean;
	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");
	boolean render=true;
	
	ReferentielService refService = (ReferentielService) BeansLookuper
			.lookup("referentielService");
	
	private boolean activeOpp = false;

	public void init() {
		webBean = new CycleVieWebBean();
		webBean.setEtudiantVOs(referentielService.findAllEtudiantforCombo());
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
			 
			//if(refService.findCarteByEtud(webBean.getVo().getEtudvo().getId()).getStatut()==EntityStatus.DILVRED) render=false;
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

	public boolean isRender() {
		return render;
	}

	public void setRender(boolean render) {
		this.render = render;
	}

}
