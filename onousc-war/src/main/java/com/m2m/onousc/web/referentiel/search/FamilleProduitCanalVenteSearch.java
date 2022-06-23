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
import com.m2m.onousc.business.referentiel.model.Restaurant;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.CanalVenteVO;
import com.m2m.onousc.business.referentiel.vo.RestaurantVO;
import com.m2m.onousc.business.referentiel.vo.transformer.CanalVenteVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.RestaurantVOTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.ISearchResultVO;
import com.m2m.technicalservices.web.ResultBean;
import com.m2m.technicalservices.web.SearchBase;
import com.m2m.technicalservices.web.SearchConfig;
import com.m2m.technicalservices.web.SearchResultBean;

/**
 * The Class CanalVenteSearch.
 * 
 * @version 1.0 24 nov. 2014
 * @author aelhachimi
 */
public class FamilleProduitCanalVenteSearch extends SearchBase implements Serializable {

	/** The Constant serialVersionUID. */
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2895815848262794718L;

	/**
	 * Instantiates a new canal vente search.
	 */
	public FamilleProduitCanalVenteSearch() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.web.SearchBase#tranform(java.util.List)
	 */
//	@Override
//	public SearchResultBean tranform(List<Object> resultQuery) {
//		SearchResultBean searchResultBean = new SearchResultBean();
//		ResultBean resultBean = new ResultBean();
//		searchResultBean.setResultBean(resultBean);
//		List<ISearchResultVO> listFamilleProduitCanalVenteSearchResultsVo = new ArrayList<ISearchResultVO>();
//		RestaurantVOTransformer restaurantVOTransformer = new RestaurantVOTransformer();
//		for (Object o : resultQuery) {
//			Restaurant restaurant = (Restaurant) o;
//			listFamilleProduitCanalVenteSearchResultsVo
//					.add((RestaurantVO) RestaurantVOTransformer
//							.model2VO(restaurant));
//		}
//		resultBean.setRows(listCanalVenteSearchResultsVo);
//		return searchResultBean;
//	}
	
	@Override
	public SearchResultBean tranform(List<Object> resultQuery) {
		SearchResultBean searchResultBean = new SearchResultBean();
		ResultBean resultBean = new ResultBean();
		searchResultBean.setResultBean(resultBean);
		List<ISearchResultVO> listFiliereSearchResultsVo = new ArrayList<ISearchResultVO>();
		RestaurantVOTransformer filiereVOTransformer = new RestaurantVOTransformer();
		for (Object o : resultQuery) {
			Restaurant srv = (Restaurant) o;
			listFiliereSearchResultsVo.add((RestaurantVO) filiereVOTransformer
					.model2VO(srv));
		}
		resultBean.setRows(listFiliereSearchResultsVo);
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
		CanalVente valueobject = referentielService.findCanalVenteByCode(criteria.getCode());
		Long idcrit = valueobject.getId();
		return referentielService.findRestaurantByIdProduit(idcrit);
	}
}
