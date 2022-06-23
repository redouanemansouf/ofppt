package com.m2m.onousc.web.referentiel.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.FiliereCriteria;
import com.m2m.onousc.business.referentiel.model.Filiere;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.FiliereVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.business.referentiel.vo.transformer.FiliereVOTransformer;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.ISearchResultVO;
import com.m2m.technicalservices.web.JSFUtils;
import com.m2m.technicalservices.web.ResultBean;
import com.m2m.technicalservices.web.SearchBase;
import com.m2m.technicalservices.web.SearchConfig;
import com.m2m.technicalservices.web.SearchResultBean;
import com.m2m.technicalservices.web.UserSession;

public class FiliereSearch extends SearchBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2279381130551885357L;
	
	public FiliereSearch(){
		super();
	}

	@Override
	public SearchResultBean tranform(List<Object> resultQuery) {
		SearchResultBean searchResultBean = new SearchResultBean();
		ResultBean resultBean = new ResultBean();
		searchResultBean.setResultBean(resultBean);
		List<ISearchResultVO> listFiliereSearchResultsVo = new ArrayList<ISearchResultVO>();
		FiliereVOTransformer restVOTransformer = new FiliereVOTransformer();
		for (Object o : resultQuery) {
			Filiere rest = (Filiere) o;
			listFiliereSearchResultsVo
					.add((FiliereVO) restVOTransformer
							.model2VO(rest));
		}
		resultBean.setRows(listFiliereSearchResultsVo);
		return searchResultBean;
	}

	@Override
	public List specificExecute(Serializable searchBean,
			SearchConfig config, String sortField, String sortOrder) {
			FiliereCriteria criteria = (FiliereCriteria) searchBean;
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
			return referentielService.findFiliereByCriteria(criteria);
	}

	@Override
	public SearchResultBean precondition(Serializable searchBean) {
		return null;
	}

}
