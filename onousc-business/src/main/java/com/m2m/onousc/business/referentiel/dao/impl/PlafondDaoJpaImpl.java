package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.PlafondCriteria;
import com.m2m.onousc.business.referentiel.dao.PlafondDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.Plafond;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

@Repository("plafondDao")
public class PlafondDaoJpaImpl extends GenericDaoJpaImpl<Plafond, Long>
implements PlafondDaoJpa{

	@Override
	public List<Plafond> findByCriteria(PlafondCriteria criteria) {
		String statusCode = criteria.getStatut() == null ? null : criteria
				.getStatut().name();
		Object[] parameters = new Object[] { criteria.getCode(), criteria.getLibelle(),
				 statusCode };
		String queryString = Queries.FIND_PLAFOND_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<Plafond> findForCombo() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_PLAFOND_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Plafond> findByCode(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_PLAFOND_BY_CODE;
		return executeQuery(queryString, parameters);
	}

}
