/*
 * CanalVenteSearch.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.referentiel.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.CanalVenteCriteria;
import com.m2m.onousc.business.referentiel.model.CanalVente;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.CanalVenteVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.business.referentiel.vo.transformer.CanalVenteVOTransformer;
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
 * @author aelhachimi
 */
public class CanalVenteSearch extends SearchBase implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1601600791719457404L;

	/**
	 * Instantiates a new canal vente search.
	 */
	public CanalVenteSearch() {
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
		List<ISearchResultVO> listCanalVenteSearchResultsVo = new ArrayList<ISearchResultVO>();
		CanalVenteVOTransformer canalVenteVOTransformer = new CanalVenteVOTransformer();
		for (Object o : resultQuery) {
			CanalVente canalVente = (CanalVente) o;
			listCanalVenteSearchResultsVo
					.add((CanalVenteVO) canalVenteVOTransformer
							.model2VO(canalVente));
		}
		resultBean.setRows(listCanalVenteSearchResultsVo);
		return searchResultBean;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.technicalservices.web.SearchBase#precondition(java.io.Serializable
	 * )
	 */
	@Override
	public SearchResultBean precondition(Serializable searchBean) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.technicalservices.web.SearchBase#specificExecute(java.io.Serializable
	 * , com.m2m.technicalservices.web.SearchConfig, java.lang.String,
	 * java.lang.String)
	 */
	public List specificExecute(Serializable searchBean, SearchConfig config,
			String sortField, String sortOrder) {
		CanalVenteCriteria criteria = (CanalVenteCriteria) searchBean;
		criteria.setSearchConfig(config);
		criteria.setSortField(sortField);
		criteria.setSortOrder(sortOrder);
		ReferentielService referentielService = (ReferentielService) BeansLookuper
				.lookup("referentielService");
		
		UserSession userSession = (UserSession) JSFUtils.getSession("userSession");
		
		ReferentielSrvPresentation referentielSrvPresentation = (ReferentielSrvPresentation) BeansLookuper
				.lookup("referentielSrvPresentation");
		UserEntityVO user = referentielSrvPresentation.findUserEntityByCode(userSession.getUserConecte().getCode());
		if (user.getSiteVO() != null) {
			criteria.setIdSite(user.getSiteVO().getId());
		}
		
		return referentielService.findCanalVenteByCriteria(criteria);
	}
}
