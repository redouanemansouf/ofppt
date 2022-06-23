package com.m2m.onousc.web.administration.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.TraceEntityCriteria;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.TraceEntityVO;
import com.m2m.onousc.business.referentiel.vo.transformer.TraceEntityVOTransformer;
import com.m2m.technicalservices.audit.impl.TraceEntity;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.ISearchResultVO;
import com.m2m.technicalservices.web.ResultBean;
import com.m2m.technicalservices.web.SearchBase;
import com.m2m.technicalservices.web.SearchConfig;
import com.m2m.technicalservices.web.SearchResultBean;

public class TraceEnitySearch extends SearchBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5542812971203439841L;

	public TraceEnitySearch(){
		super();
	}

	@Override
	public SearchResultBean tranform(List<Object> resultQuery) {
		SearchResultBean searchResultBean = new SearchResultBean();
		ResultBean resultBean = new ResultBean();
		searchResultBean.setResultBean(resultBean);
		List<ISearchResultVO> listUserSearchResultsVo = new ArrayList<ISearchResultVO>();
		TraceEntityVOTransformer userVOTransformer = new TraceEntityVOTransformer();
		for (Object o : resultQuery) {
			TraceEntity annee = (TraceEntity) o;
			listUserSearchResultsVo
					.add((TraceEntityVO) userVOTransformer
							.model2VO(annee));
		}
		resultBean.setRows(listUserSearchResultsVo);
		return searchResultBean;
	}


	@Override
	public List specificExecute(Serializable searchBean,
			SearchConfig config, String sortField, String sortOrder) {
		TraceEntityCriteria criteria = (TraceEntityCriteria) searchBean;
		criteria.setSearchConfig(config);
		criteria.setSortField(sortField);
		criteria.setSortOrder(sortOrder);
		ReferentielService referentielService = (ReferentielService) BeansLookuper
				.lookup("referentielService");
		return referentielService.findTraceByCriteria(criteria);  
	}

	@Override
	public SearchResultBean precondition(Serializable searchBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
