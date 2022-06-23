package com.m2m.onousc.web.referentiel.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.ImportCriteria;
import com.m2m.onousc.business.referentiel.model.ImportInscription;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.ImportInscriptionVO;
import com.m2m.onousc.business.referentiel.vo.transformer.ImportInscriptionVOTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.ISearchResultVO;
import com.m2m.technicalservices.web.ResultBean;
import com.m2m.technicalservices.web.SearchBase;
import com.m2m.technicalservices.web.SearchConfig;
import com.m2m.technicalservices.web.SearchResultBean;

public class ImportInscriptionSearch extends SearchBase implements Serializable {

	/** The service. */
	ReferentielService referentielService = (ReferentielService) BeansLookuper.lookup("referentielService");

	/**
	 * 
	 */
	private static final long serialVersionUID = -3599407477294242805L;

	@Override
	public SearchResultBean tranform(List<Object> resultQuery) {
		SearchResultBean searchResultBean = new SearchResultBean();
		ResultBean resultBean = new ResultBean();
		searchResultBean.setResultBean(resultBean);
		List<ISearchResultVO> listCategSearchResultsVo = new ArrayList<ISearchResultVO>();
		ImportInscriptionVOTransformer voTransformer = new ImportInscriptionVOTransformer();
		for (Object o : resultQuery) {
			ImportInscription srv = (ImportInscription) o;
			listCategSearchResultsVo.add((ImportInscriptionVO) voTransformer.model2VO(srv));
		}
		resultBean.setRows(listCategSearchResultsVo);
		return searchResultBean;
	}

	@Override
	public List specificExecute(Serializable searchBean, SearchConfig configuration, String sortField,
			String sortOrder) {
		ImportCriteria criteria = (ImportCriteria) searchBean;
		criteria.setSearchConfig(configuration);
		criteria.setSortField(sortField);
		criteria.setSortOrder(sortOrder);

		return referentielService.findImportInscription(criteria);
	}

	@Override
	public SearchResultBean precondition(Serializable searchBean) {
		return null;
	}

}
