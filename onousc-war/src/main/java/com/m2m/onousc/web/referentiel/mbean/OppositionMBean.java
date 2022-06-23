package com.m2m.onousc.web.referentiel.mbean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.vo.CarteVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.impl.ReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.webbean.OppositionWebBean;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.tools.Objects;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;

@ManagedBean
@ViewScoped
public class OppositionMBean extends BaseMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4410966658116883905L;

	private OppositionWebBean webBean;

	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");

	UserEntityVO user = referentielService.findUserEntityByCode(userSession.getUserConecte().getCode());

	private boolean activeOpp = false;

	public void init() {
		webBean = new OppositionWebBean();
		webBean.setEtudiantVOs(referentielService.findAllEtudiantforCombo());
		webBean.setOpposVOs(referentielService.findAllMotifOppositionForCombo());
		webBean.setMotifMainVOs(referentielService.findAllMotifMainLeveeForCombo());
		webBean.setListSiteForCombo(referentielService.findAllSite());
	}

	public void resetWebBeanVO() {
		webBean.setVo(new CarteVO());
	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<CarteVO>());
	}

	public OppositionWebBean getWebBean() {
		return webBean;
	}

	public void setWebBean(OppositionWebBean webBean) {
		this.webBean = webBean;
	}

	public void mettreEnOpposition() {
		clearReport();

		ReferentielBusDelegate delegate = new ReferentielBusDelegate();

		Objects.copyProperties(webBean.getVo(), webBean.getSelectedVO());

		error = delegate.mettreCarteEnOpposition(webBean);

		if (!error) {
			webBean.setSelectedVO(null);
			webBean.setPreviousSelectedVO(new CarteVO());
			addPrezMsgInfo("MESSAGE_SUCCESS_OPPOSITION", null);
			JSFUtils.contextExecute("_hideDialog()");
		}
		feedReport();
	}

	public void carteMainLevee() {
		clearReport();

		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		Objects.copyProperties(webBean.getVo(), webBean.getSelectedVO());
		error = delegate.carteMainLevee(webBean);

		if (!error) {
			webBean.setSelectedVO(null);
			webBean.setPreviousSelectedVO(new CarteVO());
			addPrezMsgInfo("MESSAGE_SUCCESS_OPPOSITION", null);
			JSFUtils.contextExecute("_hideDialog()");
		}
		feedReport();
	}

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

	public void refreshSelection() {
		if (webBean.getPreviousSelectedVO() != null
				&& webBean.getPreviousSelectedVO().equals(webBean.getSelectedVO())) {
			webBean.setSelectedVO(null);
			webBean.setPreviousSelectedVO(new CarteVO());
		} else {
			Objects.copyProperties(webBean.getPreviousSelectedVO(), webBean.getSelectedVO());
		}
	}

	public UserEntityVO getUser() {
		return user;
	}

	public void setUser(UserEntityVO user) {
		this.user = user;
	}

}
