package com.m2m.onousc.web.referentiel.mbean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;








import com.m2m.onousc.business.referentiel.vo.AdherentVO;
import com.m2m.onousc.business.referentiel.vo.CritereVO;
import com.m2m.onousc.business.referentiel.vo.DetailProfilVO;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.impl.ReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.webbean.CritereWebBean;
import com.m2m.onousc.web.referentiel.webbean.DetailProfilWebBean;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;

@ManagedBean
@ViewScoped
public class DetailProfilMBean extends BaseMBean{


	/**
	 * 
	 */
	private static final long serialVersionUID = -2664092084115114044L;
	/** The web bean. */
	private DetailProfilWebBean webBean;
	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");
	
	public void init() {
		webBean = new DetailProfilWebBean();
		webBean.setCriterevos(referentielService.findAllCritereForCombo());
		webBean.setTourniquetVOs(referentielService.findAllTourniquetForCombo());
	}
	
	/**
	 * Creer.
	 */
	public void creer() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.creerDetailProfil(webBean);
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
		error = delegate.modifierDetailProfil(webBean);
		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_EDIT", null);
			JSFUtils.contextExecute("_hideDialog()");
		}
		feedReport();
	}

	
	/**
	 * supprimer
	 */

	public void supprimer() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.supprimerDetailProfil(webBean);
		if (error) {
			JSFUtils.contextExecute("_errorDialog()");
		} else {
			addPrezMsgInfo("MESSAGE_SUCCESS_DELETE", null);
		}
		feedReport();
	}

	
	public void resetWebBeanVO() {
		webBean.setVo(new DetailProfilVO());
	}
	
	
	public DetailProfilWebBean getWebBean() {
		return webBean;
	}

	public void setWebBean(DetailProfilWebBean webBean) {
		this.webBean = webBean;
	}

	

	
}
