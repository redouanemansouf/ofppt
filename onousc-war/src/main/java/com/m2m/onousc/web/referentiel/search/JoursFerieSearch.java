package com.m2m.onousc.web.referentiel.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.JoursFerieCriteria;
import com.m2m.onousc.business.referentiel.model.JoursFerie;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.JoursFerieVO;
import com.m2m.onousc.business.referentiel.vo.transformer.JoursFerieVOTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.ISearchResultVO;
import com.m2m.technicalservices.web.ResultBean;
import com.m2m.technicalservices.web.SearchBase;
import com.m2m.technicalservices.web.SearchConfig;
import com.m2m.technicalservices.web.SearchResultBean;

/**
 * 
 * @author abousnane
 *
 */
public class JoursFerieSearch extends SearchBase implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5909214045657856158L;

	public JoursFerieSearch(){
		super();
	}
	@Override
	public SearchResultBean tranform(List<Object> resultQuery) {
		SearchResultBean searchResultBean = new SearchResultBean();
		ResultBean resultBean = new ResultBean();
		searchResultBean.setResultBean(resultBean);
		List<ISearchResultVO> listJoursFerieSearchResultsVo = new ArrayList<ISearchResultVO>();
		JoursFerieVOTransformer joursFerieVOTransformer = new JoursFerieVOTransformer();
		for (Object o : resultQuery) {
			JoursFerie joursFerie = (JoursFerie) o;
			listJoursFerieSearchResultsVo
					.add((JoursFerieVO) joursFerieVOTransformer
							.model2VO(joursFerie));
		}
		resultBean.setRows(listJoursFerieSearchResultsVo);
		return searchResultBean;
	}

	@Override
	public List specificExecute(Serializable searchBean, SearchConfig config,
			String sortField, String sortOrder) {
		JoursFerieCriteria criteria = (JoursFerieCriteria) searchBean;
		criteria.setSearchConfig(config);
		criteria.setSortField(sortField);
		criteria.setSortOrder(sortOrder);
		ReferentielService referentielService = (ReferentielService) BeansLookuper
				.lookup("referentielService");
		return referentielService.findJoursFerieByCriteria(criteria);
	}

	@Override
	public SearchResultBean precondition(Serializable searchBean) {
		return null;
	}

}
