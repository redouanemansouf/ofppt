package com.m2m.onousc.web.referentiel.mbean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.vo.CarteVO;
import com.m2m.onousc.business.referentiel.vo.SoldeVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.impl.ReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.webbean.SoldeWebBean;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.tools.Objects;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;

@ManagedBean
@ViewScoped
public class SoldeMBean extends BaseMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4410966658116883905L;

	private SoldeWebBean webBean;

	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");

	UserEntityVO user = referentielService.findUserEntityByCode(userSession.getUserConecte().getCode());

	public void init() {
		webBean = new SoldeWebBean();
		this.webBean.setNom(referentielService.findPersonnelByMatr(webBean.getVo().getMatr()));
		this.webBean.setPrenom(referentielService.findPersonnelByMatr(webBean.getVo().getMatr()));
		webBean.setListSiteForCombo(referentielService.findAllSite());

	}
	public void AddSole() {
		clearReport();

		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		String so = webBean.getSelectedVO().getMaj();
		try {
			Double mnt = Double.valueOf(so.replace(",", "."));
			mnt=mnt+webBean.getRSolde();
			webBean.getSelectedVO().setMaj(mnt.toString());
			webBean.getSelectedVO().setInit(String.valueOf(webBean.getRSolde()));
		}catch (Exception e) {
			webBean.setSelectedVO(null);
			webBean.setPreviousSelectedVO(new SoldeVO());
		 	JSFUtils.contextExecute("_hideDialog()");
		}
		
		Objects.copyProperties(webBean.getVo(), webBean.getSelectedVO());

		error = delegate.AddSolde(webBean);

		if (!error) {
			webBean.setSelectedVO(null);
			webBean.setPreviousSelectedVO(new SoldeVO());
			addPrezMsgInfo("MESSAGE_SUCCESS_OPPOSITION", null);
			JSFUtils.contextExecute("_hideDialog()");
		}
		feedReport();
	}
	
	public void resetWebBeanVO() {
		webBean.setVo(new SoldeVO());
	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<SoldeVO>());
	}

	public SoldeWebBean getWebBean() {
		return webBean;
	}

	public void setWebBean(SoldeWebBean webBean) {
		this.webBean = webBean;
	}

	@Override
	protected boolean isAutorise() {
		return hasEcran(Constantes.CODE_REF_CONSULT_SOLDE);
	}

	public UserEntityVO getUser() {
		return user;
	}

	public void setUser(UserEntityVO user) {
		this.user = user;
	}
	public void refreshSelection() {
		if (webBean.getSelectedVO() != null
				&& webBean.getPreviousSelectedVO().equals(webBean.getSelectedVO())) {
			webBean.setSelectedVO(null);
			webBean.setPreviousSelectedVO(new SoldeVO());
		} else {
			Objects.copyProperties(webBean.getPreviousSelectedVO(), webBean.getSelectedVO());
		}
	}

}
