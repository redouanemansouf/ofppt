package com.m2m.onousc.web.referentiel.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.CiteCriteria;
import com.m2m.onousc.business.referentiel.criteria.ServiceCriteria;
import com.m2m.onousc.business.referentiel.model.Cite;
import com.m2m.onousc.business.referentiel.model.Service;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.CiteVO;
import com.m2m.onousc.business.referentiel.vo.ServiceVO;
import com.m2m.onousc.business.referentiel.vo.transformer.CiteVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.ServiceVOTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.ISearchResultVO;
import com.m2m.technicalservices.web.ResultBean;
import com.m2m.technicalservices.web.SearchBase;
import com.m2m.technicalservices.web.SearchConfig;
import com.m2m.technicalservices.web.SearchResultBean;

public class ServiceSearch extends SearchBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4459906229578057324L;
	
	public ServiceSearch(){
		super();
	}

	@Override
	public SearchResultBean tranform(List<Object> resultQuery) {
		SearchResultBean searchResultBean = new SearchResultBean();
		ResultBean resultBean = new ResultBean();
		searchResultBean.setResultBean(resultBean);
		List<ISearchResultVO> listServiceSearchResultsVo = new ArrayList<ISearchResultVO>();
		ServiceVOTransformer serviceVOTransformer = new ServiceVOTransformer();
		for (Object o : resultQuery) {
			Service cite = (Service) o;
			listServiceSearchResultsVo
					.add((ServiceVO) serviceVOTransformer
							.model2VO(cite));
		}
		resultBean.setRows(listServiceSearchResultsVo);
		return searchResultBean;
	}

	@Override
	public List specificExecute(Serializable searchBean,
			SearchConfig config, String sortField, String sortOrder) {
			ServiceCriteria criteria = (ServiceCriteria) searchBean;
			criteria.setSearchConfig(config);
			criteria.setSortField(sortField);
			criteria.setSortOrder(sortOrder);
			ReferentielService referentielService = (ReferentielService) BeansLookuper
					.lookup("referentielService");
			return referentielService.findServiceByCriteria(criteria);
	}

	@Override
	public SearchResultBean precondition(Serializable searchBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
