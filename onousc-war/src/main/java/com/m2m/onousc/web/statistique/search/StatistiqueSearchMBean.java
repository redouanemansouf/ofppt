package com.m2m.onousc.web.statistique.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.StatistiqueCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class StatistiqueSearchMBean extends AbstractSearchMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1762928174124428067L;
	private StatistiqueCriteria StatistiqueCriteria = new StatistiqueCriteria();

	public StatistiqueSearchMBean() {
		super();
		search = new StatistiqueSearch();
		searchCriteria = StatistiqueCriteria;
		initData();
	}

	public void initData() {
		searchCriteria = StatistiqueCriteria;
		run();
	}

	@Override
	public void resetSearchCriteria() {
		this.StatistiqueCriteria = new StatistiqueCriteria();
		searchCriteria = StatistiqueCriteria;
	}

	public StatistiqueCriteria getStatistiqueCriteria() {
		return StatistiqueCriteria;
	}

	public void setStatistiqueCriteria(
			StatistiqueCriteria StatistiqueCriteria) {
		this.StatistiqueCriteria = StatistiqueCriteria;
	}

}
