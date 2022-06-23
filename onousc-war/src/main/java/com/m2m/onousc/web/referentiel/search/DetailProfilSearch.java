package com.m2m.onousc.web.referentiel.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.DetailProfilCriteria;
import com.m2m.onousc.business.referentiel.model.DetailProfilAcces;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.DetailProfilVO;
import com.m2m.onousc.business.referentiel.vo.transformer.DetailProfilVOTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.ISearchResultVO;
import com.m2m.technicalservices.web.ResultBean;
import com.m2m.technicalservices.web.SearchBase;
import com.m2m.technicalservices.web.SearchConfig;
import com.m2m.technicalservices.web.SearchResultBean;

/**
 * 
 * @author msadik
 * 
 */
public class DetailProfilSearch extends SearchBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -537212219011873825L;

	public DetailProfilSearch() {
		super();
	}

	@Override
	public SearchResultBean tranform(List<Object> resultQuery) {
		SearchResultBean searchResultBean = new SearchResultBean();
		ResultBean resultBean = new ResultBean();
		searchResultBean.setResultBean(resultBean);
		List<ISearchResultVO> listDetailProfilSearchResultsVo = new ArrayList<ISearchResultVO>();
		DetailProfilVOTransformer detailProfilVOTransformer = new DetailProfilVOTransformer();
		for (Object o : resultQuery) {
			DetailProfilAcces detailProfilAcces = (DetailProfilAcces) o;
			listDetailProfilSearchResultsVo
					.add((DetailProfilVO) detailProfilVOTransformer
							.model2VO(detailProfilAcces));
		}
		resultBean.setRows(listDetailProfilSearchResultsVo);
		return searchResultBean;
	}

	@Override
	public List specificExecute(Serializable searchBean, SearchConfig config,
			String sortField, String sortOrder) {
		DetailProfilCriteria criteria = (DetailProfilCriteria) searchBean;
		criteria.setSearchConfig(config);
		criteria.setSortField(sortField);
		criteria.setSortOrder(sortOrder);
		ReferentielService referentielService = (ReferentielService) BeansLookuper
				.lookup("referentielService");
		return referentielService.findDetailProfilByCriteria(criteria);
	}

	@Override
	public SearchResultBean precondition(Serializable searchBean) {
		return null;
	}

}
