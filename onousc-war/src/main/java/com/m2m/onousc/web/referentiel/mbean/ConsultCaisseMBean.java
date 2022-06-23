package com.m2m.onousc.web.referentiel.mbean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.vo.ConsultCaisseVO;
import com.m2m.onousc.business.statistique.vo.TransactionVO;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.webbean.ConsultCaisseWebBean;
import com.m2m.onousc.web.statistique.StatistiqueSrvPresentation;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.BaseMBean;

/**
 * 
 * @author abousnane
 * 
 */
@ManagedBean
@ViewScoped
public class ConsultCaisseMBean extends BaseMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6524781556624377744L;
	/**
	 * 
	 */


	/** The web bean. */
	private ConsultCaisseWebBean webBean;
	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");
	StatistiqueSrvPresentation statistiqueService = (StatistiqueSrvPresentation) BeansLookuper
			.lookup("statistiqueSrvPresentation");
	private Double someR = 0.0;
	private Double someD = 0.0;

	public void init() {
		webBean = new ConsultCaisseWebBean();
		webBean.setCaisseVOs(referentielService.findAllCaisseForCombo());
		webBean.setRestaurantVOs(referentielService.findAllRestaurantForCombo());
		webBean.setEtudiantVO(referentielService.findAllEtudiantforCombo());
		webBean.setCiteVOs(referentielService.findAllCiteForCombo());
		webBean.setCaissierVOs(referentielService.findAllCaissierVOForCombo());
	}

	/**
	 * Reset web bean vo.
	 */
	public void resetWebBeanVO() {
		webBean.setVo(new ConsultCaisseVO());
	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<ConsultCaisseVO>());
	}

	public ConsultCaisseWebBean getWebBean() {
		return webBean;
	}

	public void setWebBean(ConsultCaisseWebBean webBean) {
		this.webBean = webBean;
	}

	public void onCiteChange(String liberest) {
		if (liberest != null && !liberest.equals("")) {
			webBean.setCaisseVOs(referentielService
					.findAllCaisseByLibelleRestaurant(liberest));
			webBean.setEtudiantVO(referentielService
					.findAllEtudiantByLibelleRestaurant(liberest));
		} else {
			webBean.setCaisseVOs(referentielService.findAllCaisseForCombo());
			webBean.setEtudiantVO(referentielService.findAllEtudiantforCombo());
		}
	}

	public Double getSomeR() {
		for (TransactionVO tr : webBean.getTransactionVOs()) {
			if (tr.getTypeOperation().equals("R"))
				return tr.getTotal();
		}

		return 0.0;

	}

	public void setSomeR(Double someR) {
		this.someR = someR;
	}

	public Double getSomeD() {
		for (TransactionVO tr : webBean.getTransactionVOs()) {
			if (tr.getTypeOperation().equals("D"))
				return tr.getTotal();
		}

		return 0.0;
	}

	public void setSomeD(Double someD) {
		this.someD = someD;
	}

	public void onCountryChange(String libcite) {
		if (libcite != null && !libcite.equals("")) {
			webBean.setRestaurantVOs(referentielService
					.findAllRestaurantByLibelleCite(libcite));
		} else
			webBean.setRestaurantVOs(referentielService
					.findAllRestaurantForCombo());
	}

}