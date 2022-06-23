package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.MotifOppositionCriteria;
import com.m2m.onousc.business.referentiel.dao.MotifOppositionDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.MotifOpposition;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

@Repository("motifOppositionDao")
public class MotifOppositionDaoJpaImpl extends
		GenericDaoJpaImpl<MotifOpposition, Long> implements
		MotifOppositionDaoJpa {

	@Override
	public List<MotifOpposition> findByCriteria(MotifOppositionCriteria criteria) {
		String statusCode = criteria.getStatut() == null ? null : criteria
				.getStatut().name();
		Object[] parameters = new Object[] { criteria.getCode(),
				criteria.getLibelle(), statusCode };
		String queryString = Queries.FIND_MOTIF_OPPOSITION_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<MotifOpposition> findForCombo() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_MOTIF_OPPOSITION_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<MotifOpposition> findByCode(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_MOTIF_OPPOSITION_BY_CODE;
		return executeQuery(queryString, parameters);
	}

}
