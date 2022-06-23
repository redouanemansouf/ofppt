package com.m2m.onousc.web.referentiel.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.OppositionCriteria;
import com.m2m.onousc.business.referentiel.criteria.PersonnelCriteria;
import com.m2m.onousc.business.referentiel.model.Carte;
import com.m2m.onousc.business.referentiel.model.Personnel;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.CarteVO;
import com.m2m.onousc.business.referentiel.vo.PersonnelVO;
import com.m2m.onousc.business.referentiel.vo.transformer.CarteVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.PersonnelVOTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.ISearchResultVO;
import com.m2m.technicalservices.web.JSFUtils;
import com.m2m.technicalservices.web.ResultBean;
import com.m2m.technicalservices.web.SearchBase;
import com.m2m.technicalservices.web.SearchConfig;
import com.m2m.technicalservices.web.SearchResultBean;

public class PersonnelSearch extends SearchBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4356061751357330632L;

	public PersonnelSearch() {
		super();
	}
	
	@Override
	public SearchResultBean tranform(List<Object> resultQuery) {
		SearchResultBean searchResultBean = new SearchResultBean();
		ResultBean resultBean = new ResultBean();
		searchResultBean.setResultBean(resultBean);
		List<ISearchResultVO> listpersonnelSearchResultsVo = new ArrayList<ISearchResultVO>();
		PersonnelVOTransformer personnelVOTransformer=new PersonnelVOTransformer();
		for (Object o : resultQuery) {
			Personnel personnel=(Personnel) o;
			listpersonnelSearchResultsVo.add((PersonnelVO)personnelVOTransformer.model2VO(personnel));
		}
		resultBean.setRows(listpersonnelSearchResultsVo);
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
		PersonnelCriteria criteria = (PersonnelCriteria) searchBean;
		criteria.setSearchConfig(config);
		criteria.setSortField(sortField);
		criteria.setSortOrder(sortOrder);
		ReferentielService referentielService = (ReferentielService) BeansLookuper.lookup("referentielService");
		return referentielService.findPersonnelByCriteria(criteria);
	}

	
	
}
