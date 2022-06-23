package com.m2m.onousc.web.administration.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.AnneeUniversitaireCriteria;
import com.m2m.onousc.business.referentiel.criteria.UserEntityCriteria;
import com.m2m.onousc.business.referentiel.model.AnneeUniversitaire;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.AnneeUniversitaireVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.business.referentiel.vo.transformer.AnneeUniversitaireVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.UserEntityVOTransformer;
import com.m2m.technicalservices.security.UserEntity;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.ISearchResultVO;
import com.m2m.technicalservices.web.ResultBean;
import com.m2m.technicalservices.web.SearchBase;
import com.m2m.technicalservices.web.SearchConfig;
import com.m2m.technicalservices.web.SearchResultBean;

public class UserEnitySearch extends SearchBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5542812971203439841L;

	public UserEnitySearch(){
		super();
	}

	@Override
	public SearchResultBean tranform(List<Object> resultQuery) {
		SearchResultBean searchResultBean = new SearchResultBean();
		ResultBean resultBean = new ResultBean();
		searchResultBean.setResultBean(resultBean);
		List<ISearchResultVO> listUserSearchResultsVo = new ArrayList<ISearchResultVO>();
		UserEntityVOTransformer userVOTransformer = new UserEntityVOTransformer();
		for (Object o : resultQuery) {
			UserEntity annee = (UserEntity) o;
			listUserSearchResultsVo
					.add((UserEntityVO) userVOTransformer
							.model2VO(annee));
		}
		resultBean.setRows(listUserSearchResultsVo);
		return searchResultBean;
	}


	@Override
	public List specificExecute(Serializable searchBean,
			SearchConfig config, String sortField, String sortOrder) {
		UserEntityCriteria criteria = (UserEntityCriteria) searchBean;
		criteria.setSearchConfig(config);
		criteria.setSortField(sortField);
		criteria.setSortOrder(sortOrder);
		ReferentielService referentielService = (ReferentielService) BeansLookuper
				.lookup("referentielService");
		return referentielService.findUserByCriteria(criteria);  
	}

	@Override
	public SearchResultBean precondition(Serializable searchBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
