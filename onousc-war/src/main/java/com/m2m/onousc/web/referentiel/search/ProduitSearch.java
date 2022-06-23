/*
 * CanalVenteSearch.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.referentiel.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.ProduitCriteria;
import com.m2m.onousc.business.referentiel.model.Produit;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.ProduitVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.business.referentiel.vo.transformer.ProduitVOTransformer;
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
 * The Class
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
public class ProduitSearch extends SearchBase implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7786040963257919346L;

	/**
	 * Instantiates a new canal vente search.
	 */
	public ProduitSearch() {
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
		List<ISearchResultVO> listProduitSearchResultsVo = new ArrayList<ISearchResultVO>();
		ProduitVOTransformer produitVOTransformer = new ProduitVOTransformer();
		for (Object o : resultQuery) {
			Produit produit = (Produit) o;
			listProduitSearchResultsVo
					.add((ProduitVO) produitVOTransformer
							.model2VO(produit));
		}
		resultBean.setRows(listProduitSearchResultsVo);
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List specificExecute(Serializable searchBean, SearchConfig config,
			String sortField, String sortOrder) {
		ProduitCriteria criteria = (ProduitCriteria) searchBean;
		criteria.setSearchConfig(config);
		criteria.setSortField(sortField);
		criteria.setSortOrder(sortOrder);
		ReferentielSrvPresentation referentielSrvPresentation = (ReferentielSrvPresentation) BeansLookuper
				.lookup("referentielSrvPresentation");
		UserSession userSession = (UserSession) JSFUtils.getSession("userSession");
		ReferentielService referentielService = (ReferentielService) BeansLookuper
				.lookup("referentielService");
		UserEntityVO user = referentielSrvPresentation.findUserEntityByCode(userSession.getUserConecte().getCode());
		
		if (user.getSiteVO() != null) {
			criteria.setIdSite(user.getSiteVO().getId());
		}
		return referentielService.findProduitByCriteria(criteria);
	}
}
