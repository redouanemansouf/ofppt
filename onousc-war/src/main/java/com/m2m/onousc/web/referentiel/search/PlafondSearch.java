package com.m2m.onousc.web.referentiel.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.PlafondCriteria;
import com.m2m.onousc.business.referentiel.model.Plafond;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.PlafondVO;
import com.m2m.onousc.business.referentiel.vo.transformer.PlafondVOTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.ISearchResultVO;
import com.m2m.technicalservices.web.ResultBean;
import com.m2m.technicalservices.web.SearchBase;
import com.m2m.technicalservices.web.SearchConfig;
import com.m2m.technicalservices.web.SearchResultBean;

public class PlafondSearch extends SearchBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7949563381041932553L;
	
	public PlafondSearch(){
		super();
	}
	@Override
	public SearchResultBean tranform(List<Object> resultQuery) {
		SearchResultBean searchResultBean = new SearchResultBean();
		ResultBean resultBean = new ResultBean();
		searchResultBean.setResultBean(resultBean);
		List<ISearchResultVO> listPlafondSearchResultsVo = new ArrayList<ISearchResultVO>();
		PlafondVOTransformer plafondVOTransformer = new PlafondVOTransformer();
		for (Object o : resultQuery) {
			Plafond plafond = (Plafond) o;
			listPlafondSearchResultsVo
					.add((PlafondVO) plafondVOTransformer
							.model2VO(plafond));
		}
		resultBean.setRows(listPlafondSearchResultsVo);
		return searchResultBean;
	}

	@Override
	public List specificExecute(Serializable searchBean,
			SearchConfig config, String sortField, String sortOrder) {
			PlafondCriteria criteria = (PlafondCriteria) searchBean;
			criteria.setSearchConfig(config);
			criteria.setSortField(sortField);
			criteria.setSortOrder(sortOrder);
			ReferentielService referentielService = (ReferentielService) BeansLookuper
					.lookup("referentielService");
			return referentielService.findPlafondByCriteria(criteria);
	}

	@Override
	public SearchResultBean precondition(Serializable searchBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
