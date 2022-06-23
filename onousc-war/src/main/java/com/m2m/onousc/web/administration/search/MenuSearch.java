package com.m2m.onousc.web.administration.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.AnneeUniversitaireCriteria;
import com.m2m.onousc.business.referentiel.criteria.MenuCriteria;
import com.m2m.onousc.business.referentiel.criteria.UserEntityCriteria;
import com.m2m.onousc.business.referentiel.criteria.WinMenuCriteria;
import com.m2m.onousc.business.referentiel.model.AnneeUniversitaire;
import com.m2m.onousc.business.referentiel.model.Menu;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.AnneeUniversitaireVO;
import com.m2m.onousc.business.referentiel.vo.MenuVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.business.referentiel.vo.WinMenuVO;
import com.m2m.onousc.business.referentiel.vo.transformer.AnneeUniversitaireVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.MenuVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.UserEntityVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.WinMenuVOTransformer;
import com.m2m.technicalservices.security.UserEntity;
import com.m2m.technicalservices.security.WinMenu;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.ISearchResultVO;
import com.m2m.technicalservices.web.ResultBean;
import com.m2m.technicalservices.web.SearchBase;
import com.m2m.technicalservices.web.SearchConfig;
import com.m2m.technicalservices.web.SearchResultBean;

public class MenuSearch extends SearchBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5542812971203439841L;

	public MenuSearch(){
		super();
	}

	@Override
	public SearchResultBean tranform(List<Object> resultQuery) {
		SearchResultBean searchResultBean = new SearchResultBean();
		ResultBean resultBean = new ResultBean();
		searchResultBean.setResultBean(resultBean);
		List<ISearchResultVO> listMenuSearchResultsVo = new ArrayList<ISearchResultVO>();
		MenuVOTransformer menuVOTransformer = new MenuVOTransformer();
		for (Object o : resultQuery) {
			Menu annee = (Menu) o;
			listMenuSearchResultsVo
					.add((MenuVO) menuVOTransformer
							.model2VO(annee));
		}
		resultBean.setRows(listMenuSearchResultsVo);
		return searchResultBean;	
	}


	@Override
	public List specificExecute(Serializable searchBean,
			SearchConfig config, String sortField, String sortOrder) {
		MenuCriteria criteria = (MenuCriteria) searchBean;
		criteria.setSearchConfig(config);
		criteria.setSortField(sortField);
		criteria.setSortOrder(sortOrder);
		ReferentielService referentielService = (ReferentielService) BeansLookuper
				.lookup("referentielService");
		return referentielService.findMenuByCriteria(criteria);  
	}

	@Override
	public SearchResultBean precondition(Serializable searchBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
