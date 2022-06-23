package com.m2m.onousc.web.statistique.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.StatistiqueCriteria;
import com.m2m.onousc.business.statistique.service.StatistiqueService;
import com.m2m.onousc.business.statistique.vo.StatistiqueJourVO;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.ISearchResultVO;
import com.m2m.technicalservices.web.ResultBean;
import com.m2m.technicalservices.web.SearchBase;
import com.m2m.technicalservices.web.SearchConfig;
import com.m2m.technicalservices.web.SearchResultBean;

public class StatistiqueSearch extends SearchBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3105725340343414808L;
	
	
	public StatistiqueSearch() {
		super();
	}

	@Override
	public SearchResultBean tranform(List<Object> resultQuery) {
		SearchResultBean searchResultBean = new SearchResultBean();
		ResultBean resultBean = new ResultBean();
		searchResultBean.setResultBean(resultBean);
		List<ISearchResultVO> liststSearchResultsVo = new ArrayList<ISearchResultVO>();
		for (Object o : resultQuery) {
			StatistiqueJourVO st = (StatistiqueJourVO) o;
			liststSearchResultsVo
					.add(st);
		}
		resultBean.setRows(liststSearchResultsVo);
		return searchResultBean;
	}

	@Override
	public List specificExecute(Serializable searchBean,
			SearchConfig config, String sortField, String sortOrder) {
		StatistiqueCriteria criteria = (StatistiqueCriteria) searchBean;
		criteria.setSearchConfig(config);
		criteria.setSortField(sortField);
		criteria.setSortOrder(sortOrder);
		StatistiqueService statistiqueService = (StatistiqueService) BeansLookuper
				.lookup("statistiqueService");
		return statistiqueService.findStatistiqueByCriteria(criteria);
	}

	@Override
	public SearchResultBean precondition(Serializable searchBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
