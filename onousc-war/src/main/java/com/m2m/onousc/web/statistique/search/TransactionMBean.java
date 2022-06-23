package com.m2m.onousc.web.statistique.search;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.StatistiqueCriteria;
import com.m2m.onousc.business.referentiel.criteria.TransactionCriteria;
import com.m2m.onousc.business.statistique.vo.TransactionVO;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.statistique.StatistiqueSrvPresentation;
import com.m2m.onousc.web.statistique.webbean.TransactionWebBean;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.BaseMBean;

@ManagedBean
@ViewScoped
public class TransactionMBean extends BaseMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6105268893630279308L;
	StatistiqueSrvPresentation statistiqueService = (StatistiqueSrvPresentation) BeansLookuper
			.lookup("statistiqueSrvPresentation");
	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");
	private TransactionCriteria transactionCriteria;
	private TransactionWebBean webBean;
	private Double someR = 0.0;
	private Double someD = 0.0;

	@PostConstruct
	public void init() {
		transactionCriteria = new TransactionCriteria();
		transactionCriteria.setType(0);
		webBean = new TransactionWebBean();
		webBean.setTransactionVO(statistiqueService
				.findAllTransaction(transactionCriteria));
		webBean.setCiteVO(referentielService.findAllCiteForCombo());
		webBean.setEtudiantVO(referentielService.findAllEtudiantforCombo());
	}

	public TransactionCriteria getTransactionCriteria() {
		return transactionCriteria;
	}

	public void setTransactionCriteria(TransactionCriteria transactionCriteria) {
		this.transactionCriteria = transactionCriteria;
	}

	public TransactionWebBean getWebBean() {
		return webBean;
	}

	public void setWebBean(TransactionWebBean webBean) {
		this.webBean = webBean;
	}

	public void onCountryChange() {
		if (transactionCriteria.getLibcite() != null
				&& !transactionCriteria.getLibcite().equals("")) {
			webBean.setRestaurantVO(referentielService
					.findAllRestaurantByLibelleCite(transactionCriteria
							.getLibcite()));

		} else
			webBean.setRestaurantVO(referentielService
					.findAllRestaurantForCombo());
	}

	public void onRestaurantChange() {
		if (transactionCriteria.getLibrestaurant() != null
				&& !transactionCriteria.getLibrestaurant().equals("")) {
			webBean.setEtudiantVO(referentielService
					.findAllEtudiantByLibelleRestaurant(transactionCriteria
							.getLibrestaurant()));
		} else
			webBean.setEtudiantVO(referentielService.findAllEtudiantforCombo());
	}

	public void chercher() {
		String date_max = (transactionCriteria.getDateFin() != null) ? transactionCriteria
				.getDateFinFormat() : "";
		webBean.setTransactionVO(statistiqueService
				.findAllTransaction(transactionCriteria));
	}

	public Double getSomeR() {
		for (TransactionVO tr : webBean.getTransactionVO()) {
			if (tr.getTypeOperation().equals("R"))
				return tr.getTotal();
		}

		return 0.0;
	}

	public void setSomeR(Double someR) {
		this.someR = someR;
	}

	public Double getSomeD() {
		for (TransactionVO tr : webBean.getTransactionVO()) {
			if (tr.getTypeOperation().equals("D"))
				return tr.getTotal();
		}

		return 0.0;
	}

	public void setSomeD(Double someD) {
		this.someD = someD;
	}

	public void resetSearchCriteria() {
		this.transactionCriteria = new TransactionCriteria();
		transactionCriteria.setType(0);

	}

}
