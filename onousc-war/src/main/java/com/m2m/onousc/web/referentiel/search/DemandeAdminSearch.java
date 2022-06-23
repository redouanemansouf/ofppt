package com.m2m.onousc.web.referentiel.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.DemandeAdminCriteria;
import com.m2m.onousc.business.referentiel.model.DemandeAdmin;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.DemandeAdminVO;
import com.m2m.onousc.business.referentiel.vo.transformer.DemandeAdminVOTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.ISearchResultVO;
import com.m2m.technicalservices.web.ResultBean;
import com.m2m.technicalservices.web.SearchBase;
import com.m2m.technicalservices.web.SearchConfig;
import com.m2m.technicalservices.web.SearchResultBean;

public class DemandeAdminSearch extends SearchBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1522051236558525117L;

	public DemandeAdminSearch() {
		super();
	}

	@Override
	public SearchResultBean tranform(List<Object> resultQuery) {
		SearchResultBean searchResultBean = new SearchResultBean();
		ResultBean resultBean = new ResultBean();
		searchResultBean.setResultBean(resultBean);
		List<ISearchResultVO> listDemandeAdminSearchResultsVo = new ArrayList<ISearchResultVO>();
		DemandeAdminVOTransformer demandeAdminVOTransformer = new DemandeAdminVOTransformer();
		for (Object o : resultQuery) {
			DemandeAdmin demandeAdmin = (DemandeAdmin) o;
			listDemandeAdminSearchResultsVo.add((DemandeAdminVO) demandeAdminVOTransformer.model2VO(demandeAdmin));
		}
		resultBean.setRows(listDemandeAdminSearchResultsVo);
		return searchResultBean;
	}

	@Override
	public List specificExecute(Serializable searchBean, SearchConfig config, String sortField, String sortOrder) {
		DemandeAdminCriteria criteria = (DemandeAdminCriteria) searchBean;
		criteria.setSearchConfig(config);
		criteria.setSortField(sortField);
		criteria.setSortOrder(sortOrder);
		ReferentielService referentielService = (ReferentielService) BeansLookuper.lookup("referentielService");
		return referentielService.findDemandeAdminByCriteria(criteria);
	}

	@Override
	public SearchResultBean precondition(Serializable searchBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
