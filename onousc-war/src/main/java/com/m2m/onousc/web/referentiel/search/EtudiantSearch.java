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
import com.m2m.onousc.business.referentiel.criteria.EtudiantCriteria;
import com.m2m.onousc.business.referentiel.model.CanalVente;
import com.m2m.onousc.business.referentiel.model.Etudiants;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.CanalVenteVO;
import com.m2m.onousc.business.referentiel.vo.EtudiantVO;
import com.m2m.onousc.business.referentiel.vo.transformer.CanalVenteVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.EtudiantVOTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.ISearchResultVO;
import com.m2m.technicalservices.web.JSFUtils;
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
public class EtudiantSearch extends SearchBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 535972455259815621L;

	/**
	 * Instantiates a new canal vente search.
	 */
	public EtudiantSearch() {
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
		List<ISearchResultVO> listEtudiantSearchResultsVo = new ArrayList<ISearchResultVO>();
		EtudiantVOTransformer etudiantVOTransformer = new EtudiantVOTransformer();
		for (Object o : resultQuery) {
			Etudiants etudiants = (Etudiants) o;
			listEtudiantSearchResultsVo.add((EtudiantVO) etudiantVOTransformer.model2VO(etudiants));
		}
		resultBean.setRows(listEtudiantSearchResultsVo);
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
	 * Serializable , com.m2m.technicalservices.web.SearchConfig, java.lang.String,
	 * java.lang.String)
	 */
	public List specificExecute(Serializable searchBean, SearchConfig config, String sortField, String sortOrder) {
		EtudiantCriteria criteria = (EtudiantCriteria) searchBean;
		ReferentielService referentielService = (ReferentielService) BeansLookuper.lookup("referentielService");
		criteria.setSearchConfig(config);
		criteria.setSortField(sortField);
		criteria.setSortOrder(sortOrder);
		if (JSFUtils.getRequestURI().contains("enrolement_carte/listerDmdEnCours.xhtml"))
			criteria.setStatus("ENABLED");
		else if (JSFUtils.getRequestURI().contains("enrolement_carte/listerDmdValidees.xhtml"))
			criteria.setStatus("VALIDATED");
		else if (JSFUtils.getRequestURI().contains("enrolement_carte/listerDmdAnnulees.xhtml"))
			criteria.setStatus("CLOSED");
		else if (JSFUtils.getRequestURI().contains("enrolement_carte/listerDmdSupprimees.xhtml"))
			criteria.setStatus("DELETED");
		else if (JSFUtils.getRequestURI().contains("enrolement_carte/listerDmdLot.xhtml"))
			criteria.setStatus(null);
		return referentielService.findByCriteria(criteria);
	}
}
