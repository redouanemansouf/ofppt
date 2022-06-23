package com.m2m.onousc.web.referentiel.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.CaissierCriteria;
import com.m2m.onousc.business.referentiel.model.Caissier;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.CaissierVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.business.referentiel.vo.transformer.CaissierVOTransformer;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.ISearchResultVO;
import com.m2m.technicalservices.web.JSFUtils;
import com.m2m.technicalservices.web.ResultBean;
import com.m2m.technicalservices.web.SearchBase;
import com.m2m.technicalservices.web.SearchConfig;
import com.m2m.technicalservices.web.SearchResultBean;
import com.m2m.technicalservices.web.UserSession;

public class CaissierSearch extends SearchBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1522051236558525117L;

	public CaissierSearch() {
		super();
	}

	@Override
	public SearchResultBean tranform(List<Object> resultQuery) {
		SearchResultBean searchResultBean = new SearchResultBean();
		ResultBean resultBean = new ResultBean();
		searchResultBean.setResultBean(resultBean);
		List<ISearchResultVO> listCaissierSearchResultsVo = new ArrayList<ISearchResultVO>();
		CaissierVOTransformer CaissierVOTransformer = new CaissierVOTransformer();
		for (Object o : resultQuery) {
			Caissier Caissier = (Caissier) o;
			listCaissierSearchResultsVo.add((CaissierVO) CaissierVOTransformer.model2VO(Caissier));
		}
		resultBean.setRows(listCaissierSearchResultsVo);
		return searchResultBean;
	}

	@Override
	public List specificExecute(Serializable searchBean, SearchConfig config, String sortField, String sortOrder) {
		CaissierCriteria criteria = (CaissierCriteria) searchBean;
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
		return referentielService.findCaissierByCriteria(criteria);
	}

	@Override
	public SearchResultBean precondition(Serializable searchBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
