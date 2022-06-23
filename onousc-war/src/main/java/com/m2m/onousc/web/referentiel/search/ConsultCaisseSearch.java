package com.m2m.onousc.web.referentiel.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.ConsultCaisseCriteria;
import com.m2m.onousc.business.referentiel.model.ConsultCaisse;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.ConsultCaisseVO;
import com.m2m.onousc.business.referentiel.vo.transformer.ConsultCaisseVOTransformer;
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
public class ConsultCaisseSearch extends SearchBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3041760194584861475L;

	/**
	 * 
	 */
	
	
	public ConsultCaisseSearch(){
		super();
	}

	@Override
	public SearchResultBean tranform(List<Object> resultQuery) {
		SearchResultBean searchResultBean = new SearchResultBean();
		ResultBean resultBean = new ResultBean();
		searchResultBean.setResultBean(resultBean);
		List<ISearchResultVO> listConsultCaisseSearchResultsVo = new ArrayList<ISearchResultVO>();
		ConsultCaisseVOTransformer ConsultCaisseVOTransformer = new ConsultCaisseVOTransformer();
		for (Object o : resultQuery) {
			ConsultCaisse canalVente = (ConsultCaisse) o;
			listConsultCaisseSearchResultsVo
					.add((ConsultCaisseVO) ConsultCaisseVOTransformer
							.model2VO(canalVente));
		}
		resultBean.setRows(listConsultCaisseSearchResultsVo);
		return searchResultBean;
	}

	@Override
	public List specificExecute(Serializable searchBean, SearchConfig config,
			String sortField, String sortOrder) {
		ConsultCaisseCriteria criteria = (ConsultCaisseCriteria) searchBean;
		criteria.setSearchConfig(config);
		criteria.setSortField(sortField);
		criteria.setSortOrder(sortOrder);
		ReferentielService referentielService = (ReferentielService) BeansLookuper
				.lookup("referentielService");
		return referentielService.findConsultCaisseByCriteria(criteria);
	}

	@Override
	public SearchResultBean precondition(Serializable searchBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
