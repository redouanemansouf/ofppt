package com.m2m.onousc.web.administration.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.GroupUserCriteria;
import com.m2m.onousc.business.referentiel.model.GroupUser;
import com.m2m.onousc.business.referentiel.service.AdministrationService;
import com.m2m.onousc.business.referentiel.vo.GroupUserVO;
import com.m2m.onousc.business.referentiel.vo.transformer.GroupUserVOTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.ISearchResultVO;
import com.m2m.technicalservices.web.ResultBean;
import com.m2m.technicalservices.web.SearchBase;
import com.m2m.technicalservices.web.SearchConfig;
import com.m2m.technicalservices.web.SearchResultBean;

public class GroupUserSearch extends SearchBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5542812971203439841L;

	public GroupUserSearch() {
		super();
	}

	@Override
	public SearchResultBean tranform(List<Object> resultQuery) {
		SearchResultBean searchResultBean = new SearchResultBean();
		ResultBean resultBean = new ResultBean();
		searchResultBean.setResultBean(resultBean);
		List<ISearchResultVO> listGroupSearchResultsVo = new ArrayList<ISearchResultVO>();
		GroupUserVOTransformer groupVOTransformer = new GroupUserVOTransformer();
		for (Object o : resultQuery) {
			GroupUser group = (GroupUser) o;
			listGroupSearchResultsVo.add((GroupUserVO) groupVOTransformer
					.model2VO(group));
		}
		resultBean.setRows(listGroupSearchResultsVo);
		return searchResultBean;
	}

	@Override
	public List specificExecute(Serializable searchBean, SearchConfig config,
			String sortField, String sortOrder) {
		GroupUserCriteria criteria = (GroupUserCriteria) searchBean;
		criteria.setSearchConfig(config);
		criteria.setSortField(sortField);
		criteria.setSortOrder(sortOrder);
		AdministrationService administrationService = (AdministrationService) BeansLookuper
				.lookup("administrationService");
		
		return administrationService.findGroupByCriteria(criteria);
	}

	@Override
	public SearchResultBean precondition(Serializable searchBean) {
		return null;
	}

}
