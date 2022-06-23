package com.m2m.onousc.web.referentiel.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.AnneeUniversitaireCriteria;
import com.m2m.onousc.business.referentiel.model.AnneeUniversitaire;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.AnneeUniversitaireVO;
import com.m2m.onousc.business.referentiel.vo.transformer.AnneeUniversitaireVOTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.ISearchResultVO;
import com.m2m.technicalservices.web.ResultBean;
import com.m2m.technicalservices.web.SearchBase;
import com.m2m.technicalservices.web.SearchConfig;
import com.m2m.technicalservices.web.SearchResultBean;

public class AnneeUniversitaireSearch extends SearchBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5542812971203439841L;

	public AnneeUniversitaireSearch(){
		super();
	}

	@Override
	public SearchResultBean tranform(List<Object> resultQuery) {
		SearchResultBean searchResultBean = new SearchResultBean();
		ResultBean resultBean = new ResultBean();
		searchResultBean.setResultBean(resultBean);
		List<ISearchResultVO> listAnneeSearchResultsVo = new ArrayList<ISearchResultVO>();
		AnneeUniversitaireVOTransformer anneeVOTransformer = new AnneeUniversitaireVOTransformer();
		for (Object o : resultQuery) {
			AnneeUniversitaire annee = (AnneeUniversitaire) o;
			listAnneeSearchResultsVo
					.add((AnneeUniversitaireVO) anneeVOTransformer
							.model2VO(annee));
		}
		resultBean.setRows(listAnneeSearchResultsVo);
		return searchResultBean;
	}


	@Override
	public List specificExecute(Serializable searchBean,
			SearchConfig config, String sortField, String sortOrder) {
		AnneeUniversitaireCriteria criteria = (AnneeUniversitaireCriteria) searchBean;
		criteria.setSearchConfig(config);
		criteria.setSortField(sortField);
		criteria.setSortOrder(sortOrder);
		ReferentielService referentielService = (ReferentielService) BeansLookuper
				.lookup("referentielService");
		return referentielService.findAnneeUniversitaireByCriteria(criteria);
	}

	@Override
	public SearchResultBean precondition(Serializable searchBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
