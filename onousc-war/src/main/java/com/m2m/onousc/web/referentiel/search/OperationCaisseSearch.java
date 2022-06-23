package com.m2m.onousc.web.referentiel.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.OperCaisseCriteria;
import com.m2m.onousc.business.referentiel.criteria.OperationCaisseCriteria;
import com.m2m.onousc.business.referentiel.model.OperationCaisse;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.OperationCaisseVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.business.referentiel.vo.transformer.OperationCaisseVOTransformer;
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
 * 
 * @author abousnane
 *
 */
public class OperationCaisseSearch extends SearchBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6550556512237867282L;
	
	public OperationCaisseSearch(){
		super();
	}

	@Override
	public SearchResultBean tranform(List<Object> resultQuery) {
		SearchResultBean searchResultBean = new SearchResultBean();
		ResultBean resultBean = new ResultBean();
		searchResultBean.setResultBean(resultBean);
		List<ISearchResultVO> listOperationCaisseSearchResultsVo = new ArrayList<ISearchResultVO>();
		OperationCaisseVOTransformer OperationCaisseVOTransformer = new OperationCaisseVOTransformer();
		for (Object o : resultQuery) {
			OperationCaisse canalVente = (OperationCaisse) o;
			listOperationCaisseSearchResultsVo
					.add((OperationCaisseVO) OperationCaisseVOTransformer
							.model2VO(canalVente));
		}
		resultBean.setRows(listOperationCaisseSearchResultsVo);
		return searchResultBean;
	}

	@Override
	public List specificExecute(Serializable searchBean, SearchConfig config,
			String sortField, String sortOrder) {
		OperCaisseCriteria criteria = (OperCaisseCriteria) searchBean;
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
		return referentielService.findOperationCaisseByCriteria(criteria);
	}

	@Override
	public SearchResultBean precondition(Serializable searchBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
