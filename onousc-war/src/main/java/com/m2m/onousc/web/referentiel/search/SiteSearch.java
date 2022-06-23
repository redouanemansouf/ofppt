/*
 * SiteSearch.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.referentiel.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.SiteCriteria;
import com.m2m.onousc.business.referentiel.model.Site;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.SiteVO;
import com.m2m.onousc.business.referentiel.vo.transformer.SiteVOTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.ISearchResultVO;
import com.m2m.technicalservices.web.ResultBean;
import com.m2m.technicalservices.web.SearchBase;
import com.m2m.technicalservices.web.SearchConfig;
import com.m2m.technicalservices.web.SearchResultBean;

/**
 * The Class SiteSearch.
 * 
 * @version 1.0 24 nov. 2014
 * @author aelhachimi
 */
public class SiteSearch extends SearchBase implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1601600791719457404L;

	/**
	 * Instantiates a new canal vente search.
	 */
	public SiteSearch() {
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
		List<ISearchResultVO> listSiteSearchResultsVo = new ArrayList<ISearchResultVO>();
		SiteVOTransformer siteVOTransformer = new SiteVOTransformer();
		for (Object o : resultQuery) {
			Site site = (Site) o;
			listSiteSearchResultsVo
					.add((SiteVO) siteVOTransformer
							.model2VO(site));
		}
		resultBean.setRows(listSiteSearchResultsVo);
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
		SiteCriteria criteria = (SiteCriteria) searchBean;
		criteria.setSearchConfig(config);
		criteria.setSortField(sortField);
		criteria.setSortOrder(sortOrder);
		ReferentielService referentielService = (ReferentielService) BeansLookuper
				.lookup("referentielService");
		return referentielService.findSiteByCriteria(criteria);
	}
}
