package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.CritereCriteria;
import com.m2m.onousc.business.referentiel.dao.CritereDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.Critere;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

@Repository("critereDao")
public class CritereDaoJpaImpl extends GenericDaoJpaImpl<Critere, Long>
		implements CritereDaoJpa {

	@Override
	public List<Critere> findByCriteria(CritereCriteria criteria) {
		String statusCode = criteria.getStatut() == null ? null : criteria
				.getStatut().name();
		Object[] parameters = new Object[] { criteria.getCode(),
				criteria.getLibelle(), statusCode };
		String queryString = Queries.FIND_CRITERE_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<Critere> findForCombo() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_CRITERE_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Critere> findByCode(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_CRITERE_BY_CODE;
		return executeQuery(queryString, parameters);
	}

}
