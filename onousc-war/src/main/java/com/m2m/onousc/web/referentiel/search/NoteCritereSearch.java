package com.m2m.onousc.web.referentiel.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.NoteCritereCriteria;
import com.m2m.onousc.business.referentiel.model.NoteCritere;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.NoteCritereVO;
import com.m2m.onousc.business.referentiel.vo.transformer.NoteCritereVOTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.ISearchResultVO;
import com.m2m.technicalservices.web.ResultBean;
import com.m2m.technicalservices.web.SearchBase;
import com.m2m.technicalservices.web.SearchConfig;
import com.m2m.technicalservices.web.SearchResultBean;

public class NoteCritereSearch extends SearchBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -221641057865414867L;

	@Override
	public SearchResultBean tranform(List<Object> resultQuery) {
		SearchResultBean searchResultBean = new SearchResultBean();
		ResultBean resultBean = new ResultBean();
		searchResultBean.setResultBean(resultBean);
		List<ISearchResultVO> listParamSearchResultsVo = new ArrayList<ISearchResultVO>();
		NoteCritereVOTransformer NoteCritereVOTransformer = new NoteCritereVOTransformer();
		for (Object o : resultQuery) {
			NoteCritere opp = (NoteCritere) o;
			listParamSearchResultsVo
					.add((NoteCritereVO) NoteCritereVOTransformer.model2VO(opp));
		}
		resultBean.setRows(listParamSearchResultsVo);
		return searchResultBean;
	}

	@Override
	public List specificExecute(Serializable searchBean, SearchConfig config,
			String sortField, String sortOrder) {
		NoteCritereCriteria criteria = (NoteCritereCriteria) searchBean;
		criteria.setSearchConfig(config);
		criteria.setSortField(sortField);
		criteria.setSortOrder(sortOrder);
		ReferentielService referentielService = (ReferentielService) BeansLookuper
				.lookup("referentielService");
		return referentielService.findNoteCritereByCriteria(criteria);
	}

	@Override
	public SearchResultBean precondition(Serializable searchBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
