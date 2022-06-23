package com.m2m.onousc.web.referentiel.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.MotifMainLeveeCriteria;
import com.m2m.onousc.business.referentiel.model.MotifMainLevee;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.MotifMainLeveeVO;
import com.m2m.onousc.business.referentiel.vo.transformer.MotifMainLeveeVOTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.ISearchResultVO;
import com.m2m.technicalservices.web.ResultBean;
import com.m2m.technicalservices.web.SearchBase;
import com.m2m.technicalservices.web.SearchConfig;
import com.m2m.technicalservices.web.SearchResultBean;

public class MotifMainLeveeSearch extends SearchBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -221641057865414867L;

	@Override
	public SearchResultBean tranform(List<Object> resultQuery) {
		SearchResultBean searchResultBean = new SearchResultBean();
		ResultBean resultBean = new ResultBean();
		searchResultBean.setResultBean(resultBean);
		List<ISearchResultVO> listMainSearchResultsVo = new ArrayList<ISearchResultVO>();
		MotifMainLeveeVOTransformer MotifMainLeveeVOTransformer = new MotifMainLeveeVOTransformer();
		for (Object o : resultQuery) {
			MotifMainLevee mm = (MotifMainLevee) o;
			listMainSearchResultsVo
					.add((MotifMainLeveeVO) MotifMainLeveeVOTransformer
							.model2VO(mm));
		}
		resultBean.setRows(listMainSearchResultsVo);
		return searchResultBean;
	}

	@Override
	public List specificExecute(Serializable searchBean,
			SearchConfig config, String sortField, String sortOrder) {
		MotifMainLeveeCriteria criteria = (MotifMainLeveeCriteria) searchBean;
		criteria.setSearchConfig(config);
		criteria.setSortField(sortField);
		criteria.setSortOrder(sortOrder);
		ReferentielService referentielService = (ReferentielService) BeansLookuper
				.lookup("referentielService");
		return referentielService.findMotifMainLeveeByCriteria(criteria);
	}

	@Override
	public SearchResultBean precondition(Serializable searchBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
