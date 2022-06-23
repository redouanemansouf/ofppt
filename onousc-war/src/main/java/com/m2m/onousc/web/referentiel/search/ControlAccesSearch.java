package com.m2m.onousc.web.referentiel.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.CaisseCriteria;
import com.m2m.onousc.business.referentiel.criteria.ControlAccesCriteria;
import com.m2m.onousc.business.referentiel.model.Caisse;
import com.m2m.onousc.business.referentiel.model.ControlAcces;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.CaisseVO;
import com.m2m.onousc.business.referentiel.vo.ControlAccesVO;
import com.m2m.onousc.business.referentiel.vo.transformer.CaisseVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.ControlAccesVOTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.ISearchResultVO;
import com.m2m.technicalservices.web.ResultBean;
import com.m2m.technicalservices.web.SearchBase;
import com.m2m.technicalservices.web.SearchConfig;
import com.m2m.technicalservices.web.SearchResultBean;

public class ControlAccesSearch extends SearchBase implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -417113841443857052L;

	public ControlAccesSearch(){
		super();
	}
	@Override
	public SearchResultBean tranform(List<Object> resultQuery) {
		SearchResultBean searchResultBean = new SearchResultBean();
		ResultBean resultBean = new ResultBean();
		searchResultBean.setResultBean(resultBean);
		List<ISearchResultVO> listControlAccesSearchResultsVo = new ArrayList<ISearchResultVO>();
		ControlAccesVOTransformer controlAccesVOTransformer = new ControlAccesVOTransformer();
		for (Object o : resultQuery) {
			ControlAcces controlAcces = (ControlAcces) o;
			listControlAccesSearchResultsVo
					.add((ControlAccesVO) controlAccesVOTransformer
							.model2VO(controlAcces));
		}
		resultBean.setRows(listControlAccesSearchResultsVo);
		return searchResultBean;
	}

	@Override
	public List specificExecute(Serializable searchBean,
			SearchConfig config, String sortField, String sortOrder) {
			ControlAccesCriteria criteria = (ControlAccesCriteria) searchBean;
			criteria.setSearchConfig(config);
			criteria.setSortField(sortField);
			criteria.setSortOrder(sortOrder);
			ReferentielService referentielService = (ReferentielService) BeansLookuper
					.lookup("referentielService");
			return referentielService.findControlAccesByCriteria(criteria);
	}

	@Override
	public SearchResultBean precondition(Serializable searchBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
