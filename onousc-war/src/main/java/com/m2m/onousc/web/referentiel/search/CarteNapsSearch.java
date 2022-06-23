/*
 * CanalVenteSearch.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.referentiel.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.CarteNapsCriteria;
import com.m2m.onousc.business.referentiel.model.CarteNaps;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.CarteNapsVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.business.referentiel.vo.transformer.CarteNapsVOTransformer;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.ISearchResultVO;
import com.m2m.technicalservices.web.JSFUtils;
import com.m2m.technicalservices.web.ResultBean;
import com.m2m.technicalservices.web.SearchBase;
import com.m2m.technicalservices.web.SearchConfig;
import com.m2m.technicalservices.web.SearchResultBean;
import com.m2m.technicalservices.web.UserSession;

/**
 * The Class CanalVenteSearch.
 * 
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
public class CarteNapsSearch extends SearchBase implements Serializable {

	


	/**
	 * 
	 */
	private static final long serialVersionUID = 8094315751695401399L;

	/**
	 * Instantiates a new canal vente search.
	 */
	public CarteNapsSearch() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.web.SearchBase#tranform(java.util.List)
	 */
	@Override
	public SearchResultBean tranform(List<Object> resultQuery) {
		SearchResultBean searchResultBean = new SearchResultBean();
		ResultBean resultBean = new ResultBean();
		searchResultBean.setResultBean(resultBean);
		List<ISearchResultVO> listcarteSearchResultsVo = new ArrayList<ISearchResultVO>();
	//	CycleVieVOTransformer cycleVieVOTransformer=new CycleVieVOTransformer();
		CarteNapsVOTransformer cartenapsVOTransformer=new CarteNapsVOTransformer();
		for (Object o : resultQuery) {
			CarteNaps cartenaps=(CarteNaps) o;
			listcarteSearchResultsVo.add((CarteNapsVO)cartenapsVOTransformer.model2VO(cartenaps));
		}
		resultBean.setRows(listcarteSearchResultsVo);
		return searchResultBean;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.web.SearchBase#precondition(java.io.
	 * Serializable )
	 */
	@Override
	public SearchResultBean precondition(Serializable searchBean) {
		return null;
	}
	
	


	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.web.SearchBase#specificExecute(java.io.
	 * Serializable , com.m2m.technicalservices.web.SearchConfig,
	 * java.lang.String, java.lang.String)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List specificExecute(Serializable searchBean, SearchConfig config, String sortField, String sortOrder) {
		CarteNapsCriteria criteria = (CarteNapsCriteria) searchBean;
		UserSession userSession = (UserSession) JSFUtils.getSession("userSession");
		
		ReferentielSrvPresentation referentielSrvPresentation = (ReferentielSrvPresentation) BeansLookuper
				.lookup("referentielSrvPresentation");
		UserEntityVO user = referentielSrvPresentation.findUserEntityByCode(userSession.getUserConecte().getCode());
		if (user.getSiteVO() != null) {
			criteria.setIdSite(user.getSiteVO().getId());
		}
		criteria.setSearchConfig(config);
		criteria.setSortField(sortField);
		criteria.setSortOrder(sortOrder);
		ReferentielService referentielService = (ReferentielService) BeansLookuper.lookup("referentielService");
		return referentielService.findCarteNapsByCriteria(criteria);
	}
}
