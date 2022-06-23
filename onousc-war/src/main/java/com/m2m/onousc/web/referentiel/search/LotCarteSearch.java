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
import com.m2m.onousc.business.referentiel.criteria.CarteCriteria;
import com.m2m.onousc.business.referentiel.criteria.CycleVieCriteria;
import com.m2m.onousc.business.referentiel.criteria.EtudiantCriteria;
import com.m2m.onousc.business.referentiel.criteria.LotCarteCriteria;
import com.m2m.onousc.business.referentiel.model.CanalVente;
import com.m2m.onousc.business.referentiel.model.Carte;
import com.m2m.onousc.business.referentiel.model.CycleVie;
import com.m2m.onousc.business.referentiel.model.Etudiants;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.CanalVenteVO;
import com.m2m.onousc.business.referentiel.vo.CarteVO;
import com.m2m.onousc.business.referentiel.vo.CycleVieVO;
import com.m2m.onousc.business.referentiel.vo.EtudiantVO;
import com.m2m.onousc.business.referentiel.vo.transformer.CanalVenteVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.CarteVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.CycleVieVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.EtudiantVOTransformer;
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
 * @author msadik
 */
public class LotCarteSearch extends SearchBase implements Serializable {

	


	/**
	 * 
	 */
	private static final long serialVersionUID = 8094315751695401399L;
	List<CarteVO> elements = new ArrayList<CarteVO>();

	/**
	 * Instantiates a new canal vente search.
	 */
	public LotCarteSearch() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.web.SearchBase#tranform(java.util.List)
	 */
	@Override
	public SearchResultBean tranform(List<Object> resultQuery) {
		ReferentielService referentielService = (ReferentielService) BeansLookuper.lookup("referentielService");
		
		
		SearchResultBean searchResultBean = new SearchResultBean();
		ResultBean resultBean = new ResultBean();
		searchResultBean.setResultBean(resultBean);
		List<ISearchResultVO> listcarteSearchResultsVo = new ArrayList<ISearchResultVO>();
	//	CycleVieVOTransformer cycleVieVOTransformer=new CycleVieVOTransformer();
		CarteVOTransformer carteVOTransformer=new CarteVOTransformer();
		for (Object o : resultQuery) {
			Carte carte=(Carte) o;
		/*	CarteVO cartvo=new CarteVO();
			cartvo=(CarteVO)carteVOTransformer.model2VO(carte);
			for(Carte c : referentielService.find_Carte_By_Lot(cartvo.getOperateur())){
			elements.add(carteVOTransformer.model2VO(c));*/
		
			//cartvo.setElements(elements);
			//System.out.println("#############  "+cartvo.getElements().size());
			
			
			listcarteSearchResultsVo.add((CarteVO)carteVOTransformer.model2VO(carte));
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
	public List specificExecute(Serializable searchBean, SearchConfig config, String sortField, String sortOrder) {
		LotCarteCriteria criteria = (LotCarteCriteria) searchBean;
		criteria.setSearchConfig(config);
		criteria.setSortField(sortField);
		criteria.setSortOrder(sortOrder);
		ReferentielService referentielService = (ReferentielService) BeansLookuper.lookup("referentielService");
		return referentielService.findCarteByCriteria(criteria);
	}

	public List<CarteVO> getElements() {
		return elements;
	}

	public void setElements(List<CarteVO> elements) {
		this.elements = elements;
	}
	
}
