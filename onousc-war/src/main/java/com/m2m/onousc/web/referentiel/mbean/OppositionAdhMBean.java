package com.m2m.onousc.web.referentiel.mbean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.vo.AdherentVO;
import com.m2m.onousc.business.referentiel.vo.CarteVO;
import com.m2m.onousc.business.referentiel.vo.PersonnelVO;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.impl.ReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.webbean.OppositionAdhWebBean;
import com.m2m.onousc.web.referentiel.webbean.OppositionWebBean;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.tools.Objects;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;

@ManagedBean
@ViewScoped
public class OppositionAdhMBean extends BaseMBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4410966658116883905L;
	
	private OppositionAdhWebBean webBeanAdh;
	
	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");
	
	private boolean activeOpp = false;
	
	public void init() {
		webBeanAdh = new OppositionAdhWebBean();
    // 	webBeanAdh.setAdherentVOs(referentielService.findAllAdherent());
		webBeanAdh.setOpposVOs(referentielService.findAllMotifOppositionForCombo());
		webBeanAdh.setMotifMainVOs(referentielService
				.findAllMotifMainLeveeForCombo());
	}
	
	public void resetWebBeanVO() {
		webBeanAdh.setVo(new AdherentVO());
	}
	
	public void resetWebBeanAdherentVO() {
		webBeanAdh.setAdherentVOs(new ArrayList<AdherentVO>());
	}

	public OppositionAdhWebBean getWebBeanAdh() {
		return webBeanAdh;
	}

	public void setWebBean(OppositionAdhWebBean webBeanAdh) {
		this.webBeanAdh = webBeanAdh;
	}
	
	public void mettreAdhEnOpposition() {
		clearReport();
		
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		
		Objects.copyProperties(webBeanAdh.getVo(),webBeanAdh.getAdherentVO());
		
		error = delegate.mettreCarteAdhEnOpposition(webBeanAdh);


		if (!error) {
			webBeanAdh.setAdherentVO(null);
			addPrezMsgInfo("MESSAGE_SUCCESS_OPPOSITION", null);
			//JSFUtils.contextExecute("_hideDialog()");
		}
		feedReport();
	}
	
	public void carteMainLeveeAdh() {
		clearReport();
		
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();	
		Objects.copyProperties(webBeanAdh.getVo(),webBeanAdh.getAdherentVO());
		error = delegate.carteAdhMainLevee(webBeanAdh);

		if (!error) {
			webBeanAdh.setAdherentVO(null);
			addPrezMsgInfo("MESSAGE_SUCCESS_OPPOSITION", null);
			//JSFUtils.contextExecute("_hideDialog()");
		}
		feedReport();
	}
	
	
	
//	@Override
//	protected boolean isAutorise() {
//		return hasEcran(Constantes.CODE_ENR_CYV);
//	}

	public boolean isActiveOpp() {
		if (webBeanAdh.getAdherentVOs().size() == 0)
			activeOpp = false;
		else
			activeOpp = true;

		return activeOpp;
	}
	
}
