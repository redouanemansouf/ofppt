package com.m2m.onousc.web.statistique.search;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.criteria.StatistiqueCriteria;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.statistique.StatistiqueSrvPresentation;
import com.m2m.onousc.web.statistique.webbean.ChartModelWebBean;
import com.m2m.onousc.web.statistique.webbean.StatistiqueWebBean;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.BaseMBean;

@ManagedBean
@ViewScoped
public class StatistiqueMBean extends BaseMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3599438541626203677L;
	StatistiqueSrvPresentation statistiqueService = (StatistiqueSrvPresentation) BeansLookuper
			.lookup("statistiqueSrvPresentation");
	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");
	private StatistiqueCriteria StatistiqueCriteria;
	private StatistiqueWebBean webBean;
	private ChartModelWebBean chartModelWebBean;
	private boolean vide = false;
	private Long nbreJourConsommation;
	private DashboardModel nbrjourDash;

	@PostConstruct
	public void init() {
		StatistiqueCriteria = new StatistiqueCriteria();
		chartModelWebBean = new ChartModelWebBean();
		StatistiqueCriteria.setType(0);
		nbreJourConsommation = statistiqueService.findNbreJourConsommation();
		webBean = new StatistiqueWebBean();
		webBean.setStatistiqueJourVO(statistiqueService
				.findAllStatistiqueJour(StatistiqueCriteria));
		webBean.setCiteVO(referentielService.findAllCiteForCombo());
		webBean.setRestaurantVO(referentielService.findAllRestaurantForCombo());
		chartModelWebBean.createDateModel(webBean.getStatistiqueJourVO(),
				StatistiqueCriteria.getType(), "");
		nbrjourDash = new DefaultDashboardModel();
		DashboardColumn column1 = new DefaultDashboardColumn();
		column1.addWidget("NbreJours");
		nbrjourDash.addColumn(column1);
	}

	public StatistiqueCriteria getStatistiqueCriteria() {
		return StatistiqueCriteria;
	}

	public void setStatistiqueCriteria(StatistiqueCriteria statistiqueCriteria) {
		StatistiqueCriteria = statistiqueCriteria;
	}

	public void chercher() {
		String date_max = (StatistiqueCriteria.getDateFin() != null) ? StatistiqueCriteria
				.getDateFinFormat() : "";
		webBean.setStatistiqueJourVO(statistiqueService
				.findAllStatistiqueJour(StatistiqueCriteria));
		chartModelWebBean.createDateModel(webBean.getStatistiqueJourVO(),
				StatistiqueCriteria.getType(), date_max);
	}

	public StatistiqueWebBean getWebBean() {
		return webBean;
	}

	public void setWebBean(StatistiqueWebBean webBean) {
		this.webBean = webBean;
	}

	public ChartModelWebBean getChartModelWebBean() {
		return chartModelWebBean;
	}

	public void setChartModelWebBean(ChartModelWebBean chartModelWebBean) {
		this.chartModelWebBean = chartModelWebBean;
	}

	public boolean isVide() {
		return webBean.getStatistiqueJourVO().size() > 1;
	}

	public void setVide(boolean vide) {
		this.vide = vide;
	}

	public void onCountryChange() {
		if (StatistiqueCriteria.getLibcite() != null
				&& !StatistiqueCriteria.getLibcite().equals("")) {
			webBean.setRestaurantVO(referentielService
					.findAllRestaurantByLibelleCite(StatistiqueCriteria
							.getLibcite()));
		} else
			webBean.setRestaurantVO(referentielService
					.findAllRestaurantForCombo());
	}

	public void resetSearchCriteria() {
		this.StatistiqueCriteria = new StatistiqueCriteria();
		StatistiqueCriteria.setType(0);

	}

	public Long getNbreJourConsommation() {
		return nbreJourConsommation;
	}

	public void setNbreJourConsommation(Long nbreJourConsommation) {
		this.nbreJourConsommation = nbreJourConsommation;
	}

//	@Override
//	protected boolean isAutorise() {
//		return hasEcran(Constantes.CODE_SUIVI_TAB_BORD);
//	}

	public DashboardModel getNbrjourDash() {
		return nbrjourDash;
	}

	public void setNbrjourDash(DashboardModel nbrjourDash) {
		this.nbrjourDash = nbrjourDash;
	}

}
