package com.m2m.onousc.web.referentiel.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.ClotureCaisseCriteria;
import com.m2m.onousc.business.referentiel.model.ClotureCaisse;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.ClotureCaisseVO;
import com.m2m.onousc.business.referentiel.vo.transformer.ClotureCaisseVOTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.ISearchResultVO;
import com.m2m.technicalservices.web.ResultBean;
import com.m2m.technicalservices.web.SearchBase;
import com.m2m.technicalservices.web.SearchConfig;
import com.m2m.technicalservices.web.SearchResultBean;

public class ClotureCaisseSearch extends SearchBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -856510418786199724L;

	public ClotureCaisseSearch() {
		super();
	}

	@Override
	public SearchResultBean tranform(List<Object> resultQuery) {
		SearchResultBean searchResultBean = new SearchResultBean();
		ResultBean resultBean = new ResultBean();
		searchResultBean.setResultBean(resultBean);
		List<ISearchResultVO> listClotureSearchResultsVo = new ArrayList<ISearchResultVO>();
		ClotureCaisseVOTransformer clotureCaisseVOTransformer = new ClotureCaisseVOTransformer();
		for (Object o : resultQuery) {
			ClotureCaisse clotureCaisse = (ClotureCaisse) o;
			listClotureSearchResultsVo
					.add((ClotureCaisseVO) clotureCaisseVOTransformer
							.model2VO(clotureCaisse));
		}
		resultBean.setRows(listClotureSearchResultsVo);
		return searchResultBean;
	}

	@Override
	public List specificExecute(Serializable searchBean, SearchConfig config,
			String sortField, String sortOrder) {
		ClotureCaisseCriteria criteria = (ClotureCaisseCriteria) searchBean;
		criteria.setSearchConfig(config);
		criteria.setSortField(sortField);
		criteria.setSortOrder(sortOrder);
		ReferentielService referentielService = (ReferentielService) BeansLookuper
				.lookup("referentielService");
		return referentielService.findByCriteria(criteria);
	}

	@Override
	public SearchResultBean precondition(Serializable searchBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
