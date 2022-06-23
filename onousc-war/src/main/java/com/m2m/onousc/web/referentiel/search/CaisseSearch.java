package com.m2m.onousc.web.referentiel.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.CaisseCriteria;
import com.m2m.onousc.business.referentiel.model.Caisse;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.CaisseVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.business.referentiel.vo.transformer.CaisseVOTransformer;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.ISearchResultVO;
import com.m2m.technicalservices.web.JSFUtils;
import com.m2m.technicalservices.web.ResultBean;
import com.m2m.technicalservices.web.SearchBase;
import com.m2m.technicalservices.web.SearchConfig;
import com.m2m.technicalservices.web.SearchResultBean;
import com.m2m.technicalservices.web.UserSession;

public class CaisseSearch extends SearchBase implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1522051236558525117L;

	public CaisseSearch(){
		super();
	}
	@Override
	public SearchResultBean tranform(List<Object> resultQuery) {
		SearchResultBean searchResultBean = new SearchResultBean();
		ResultBean resultBean = new ResultBean();
		searchResultBean.setResultBean(resultBean);
		List<ISearchResultVO> listCaisseSearchResultsVo = new ArrayList<ISearchResultVO>();
		CaisseVOTransformer caisseVOTransformer = new CaisseVOTransformer();
		for (Object o : resultQuery) {
			Caisse caisse = (Caisse) o;
			listCaisseSearchResultsVo
					.add((CaisseVO) caisseVOTransformer
							.model2VO(caisse));
		}
		resultBean.setRows(listCaisseSearchResultsVo);
		return searchResultBean;
	}

	@Override
	public List specificExecute(Serializable searchBean,
			SearchConfig config, String sortField, String sortOrder) {
			CaisseCriteria criteria = (CaisseCriteria) searchBean;
			criteria.setSearchConfig(config);
			criteria.setSortField(sortField);
			criteria.setSortOrder(sortOrder);
			ReferentielService referentielService = (ReferentielService) BeansLookuper.lookup("referentielService");

			UserSession userSession = (UserSession) JSFUtils.getSession("userSession");

			ReferentielSrvPresentation referentielSrvPresentation = (ReferentielSrvPresentation) BeansLookuper
					.lookup("referentielSrvPresentation");
			UserEntityVO user = referentielSrvPresentation.findUserEntityByCode(userSession.getUserConecte().getCode());
			if (user.getSiteVO() != null) {
				criteria.setIdSite(user.getSiteVO().getId());
			}
			return referentielService.findCaisseByCriteria(criteria);
	}

	@Override
	public SearchResultBean precondition(Serializable searchBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
