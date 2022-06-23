package com.m2m.onousc.web.referentiel.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.UniversiteCriteria;
import com.m2m.onousc.business.referentiel.model.Universite;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.UniversiteVO;
import com.m2m.onousc.business.referentiel.vo.transformer.UniversiteVOTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.ISearchResultVO;
import com.m2m.technicalservices.web.ResultBean;
import com.m2m.technicalservices.web.SearchBase;
import com.m2m.technicalservices.web.SearchConfig;
import com.m2m.technicalservices.web.SearchResultBean;

public class UniversiteSearch extends SearchBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4835792802091810288L;
	
	/**
	 * Instantiates a new universite search.
	 */
	public UniversiteSearch(){
		super();
	}
	@Override
	public SearchResultBean tranform(List<Object> resultQuery) {
		SearchResultBean searchResultBean = new SearchResultBean();
		ResultBean resultBean = new ResultBean();
		searchResultBean.setResultBean(resultBean);
		List<ISearchResultVO> listUniversiteSearchResultsVo = new ArrayList<ISearchResultVO>();
		UniversiteVOTransformer universiteVOTransformer = new UniversiteVOTransformer();
		for (Object o : resultQuery) {
			Universite universite = (Universite) o;
			listUniversiteSearchResultsVo
					.add((UniversiteVO) universiteVOTransformer
							.model2VO(universite));
		}
		resultBean.setRows(listUniversiteSearchResultsVo);
		return searchResultBean;
	}

	@Override
	public List specificExecute(Serializable searchBean,
			SearchConfig config, String sortField, String sortOrder) {
		UniversiteCriteria criteria = (UniversiteCriteria) searchBean;
		criteria.setSearchConfig(config);
		criteria.setSortField(sortField);
		criteria.setSortOrder(sortOrder);
		ReferentielService referentielService = (ReferentielService) BeansLookuper
				.lookup("referentielService");
		return referentielService.findUniversiteByCriteria(criteria);
	}

	@Override
	public SearchResultBean precondition(Serializable searchBean) {
		return null;
	}

}
