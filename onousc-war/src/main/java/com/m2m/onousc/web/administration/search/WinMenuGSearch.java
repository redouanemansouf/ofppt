package com.m2m.onousc.web.administration.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.WinMenuCriteria;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.WinMenuVO;
import com.m2m.onousc.business.referentiel.vo.transformer.WinMenuVOTransformer;
import com.m2m.technicalservices.security.WinMenu;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.ISearchResultVO;
import com.m2m.technicalservices.web.ResultBean;
import com.m2m.technicalservices.web.SearchBase;
import com.m2m.technicalservices.web.SearchConfig;
import com.m2m.technicalservices.web.SearchResultBean;

public class WinMenuGSearch extends SearchBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5542812971203439841L;

	public WinMenuGSearch(){
		super();
	}

	@Override
	public SearchResultBean tranform(List<Object> resultQuery) {
		SearchResultBean searchResultBean = new SearchResultBean();
		ResultBean resultBean = new ResultBean();
		searchResultBean.setResultBean(resultBean);
		List<ISearchResultVO> listwinMenuSearchResultsVo = new ArrayList<ISearchResultVO>();
		WinMenuVOTransformer winMenuVOTransformer = new WinMenuVOTransformer();
		for (Object o : resultQuery) {
			WinMenu annee = (WinMenu) o;
			listwinMenuSearchResultsVo
					.add((WinMenuVO) winMenuVOTransformer
							.model2VO(annee));
		}
		resultBean.setRows(listwinMenuSearchResultsVo);
		return searchResultBean;	
	}


	@Override
	public List specificExecute(Serializable searchBean,
			SearchConfig config, String sortField, String sortOrder) {
		WinMenuCriteria criteria = (WinMenuCriteria) searchBean;
		criteria.setSearchConfig(config);
		criteria.setSortField(sortField);
		criteria.setSortOrder(sortOrder);
		ReferentielService referentielService = (ReferentielService) BeansLookuper
				.lookup("referentielService");
		criteria.setType("O");
		return referentielService.findWinMenuByCriteria(criteria);  
	}

	@Override
	public SearchResultBean precondition(Serializable searchBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
