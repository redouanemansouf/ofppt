package com.m2m.onousc.web.referentiel.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.ParametreGeneralCriteria;
import com.m2m.onousc.business.referentiel.model.ParametreGeneral;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.ParametreGeneralVO;
import com.m2m.onousc.business.referentiel.vo.transformer.ParametreGeneralVOTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.ISearchResultVO;
import com.m2m.technicalservices.web.ResultBean;
import com.m2m.technicalservices.web.SearchBase;
import com.m2m.technicalservices.web.SearchConfig;
import com.m2m.technicalservices.web.SearchResultBean;

public class ParametreGeneralSearch extends SearchBase implements Serializable {

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
		ParametreGeneralVOTransformer ParametreGeneralVOTransformer = new ParametreGeneralVOTransformer();
		for (Object o : resultQuery) {
			ParametreGeneral opp = (ParametreGeneral) o;
			listParamSearchResultsVo
					.add((ParametreGeneralVO) ParametreGeneralVOTransformer
							.model2VO(opp));
		}
		resultBean.setRows(listParamSearchResultsVo);
		return searchResultBean;
	}

	@Override
	public List specificExecute(Serializable searchBean,
			SearchConfig config, String sortField, String sortOrder) {
		ParametreGeneralCriteria criteria = (ParametreGeneralCriteria) searchBean;
		criteria.setSearchConfig(config);
		criteria.setSortField(sortField);
		criteria.setSortOrder(sortOrder);
		ReferentielService referentielService = (ReferentielService) BeansLookuper
				.lookup("referentielService");
		return referentielService.findParametreGeneralByCriteria(criteria);
	}

	@Override
	public SearchResultBean precondition(Serializable searchBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
