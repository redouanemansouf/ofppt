package com.m2m.onousc.web.referentiel.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.OppositionCriteria;
import com.m2m.onousc.business.referentiel.model.Personnel;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.PersonnelVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.business.referentiel.vo.transformer.PersonnelVOTransformer;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.ISearchResultVO;
import com.m2m.technicalservices.web.JSFUtils;
import com.m2m.technicalservices.web.ResultBean;
import com.m2m.technicalservices.web.SearchBase;
import com.m2m.technicalservices.web.SearchConfig;
import com.m2m.technicalservices.web.SearchResultBean;
import com.m2m.technicalservices.web.UserSession;

public class OppositionPersoSearch extends SearchBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4356061751357330632L;

	public OppositionPersoSearch() {
		super();
	}

	@Override
	public SearchResultBean tranform(List<Object> resultQuery) {
		SearchResultBean searchResultBean = new SearchResultBean();
		ResultBean resultBean = new ResultBean();
		searchResultBean.setResultBean(resultBean);
		List<ISearchResultVO> listcarteSearchResultsVo = new ArrayList<ISearchResultVO>();
		PersonnelVOTransformer carteVOTransformer = new PersonnelVOTransformer();
		for (Object o : resultQuery) {
			Personnel carte = (Personnel) o;
			listcarteSearchResultsVo.add((PersonnelVO) carteVOTransformer.model2VO(carte));
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
	 * Serializable , com.m2m.technicalservices.web.SearchConfig, java.lang.String,
	 * java.lang.String)
	 */
	public List specificExecute(Serializable searchBean, SearchConfig config, String sortField, String sortOrder) {
		OppositionCriteria criteria = (OppositionCriteria) searchBean;
		criteria.setSearchConfig(config);
		criteria.setSortField(sortField);
		criteria.setSortOrder(sortOrder);

		UserSession userSession = (UserSession) JSFUtils.getSession("userSession");

		ReferentielSrvPresentation referentielSrvPresentation = (ReferentielSrvPresentation) BeansLookuper
				.lookup("referentielSrvPresentation");
		UserEntityVO user = referentielSrvPresentation.findUserEntityByCode(userSession.getUserConecte().getCode());
		if (user.getSiteVO() != null) {
			criteria.setIdSite(user.getSiteVO().getId());
		}
		ReferentielService referentielService = (ReferentielService) BeansLookuper.lookup("referentielService");
		return referentielService.findOppositionPersoByCriteria(criteria);
	}

}
