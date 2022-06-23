package com.m2m.onousc.web.referentiel.mbean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.vo.ReservationBorneVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.webbean.ReservationBorneWebBean;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.BaseMBean;

@ManagedBean
@ViewScoped
public class ReservationBorneMBean extends BaseMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8187753755065641208L;

	/** The web bean. */
	private ReservationBorneWebBean webBean;
	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");
	private Long idSite = null;
	UserEntityVO user = referentielService.findUserEntityByCode(userSession.getUserConecte().getCode());

	public void init() {
		webBean = new ReservationBorneWebBean();
		if (user.getSiteVO() != null) {
			webBean.setBorneVOs(referentielService.findBorneBySite(user.getSiteVO().getId()));
		} else {
			webBean.setListSiteForCombo(referentielService.findAllSite());
			webBean.setBorneVOs(referentielService.findAllBorneForCombo());
		}
	}

	public void onChangeSite() {
		webBean.setBorneVOs(referentielService.findBorneBySite(idSite));
	}

	/**
	 * Reset web bean vo.
	 */
	public void resetWebBeanVO() {
		webBean.setVo(new ReservationBorneVO());
	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<ReservationBorneVO>());
	}

	public ReservationBorneWebBean getWebBean() {
		return webBean;
	}

	public void setWebBean(ReservationBorneWebBean webBean) {
		this.webBean = webBean;
	}

	public UserEntityVO getUser() {
		return user;
	}

	public void setUser(UserEntityVO user) {
		this.user = user;
	}

	public Long getIdSite() {
		return idSite;
	}

	public void setIdSite(Long idSite) {
		this.idSite = idSite;
	}

//	@Override
//	protected boolean isAutorise() {
//		return hasEcran(Constantes.CODE_REF_ANNEE_UNIV);  
//	}

}
