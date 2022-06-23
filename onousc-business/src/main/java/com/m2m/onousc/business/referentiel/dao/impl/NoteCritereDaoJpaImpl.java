package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.NoteCritereCriteria;
import com.m2m.onousc.business.referentiel.dao.NoteCritereDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.NoteCritere;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

@Repository("noteCritereDao")
public class NoteCritereDaoJpaImpl extends GenericDaoJpaImpl<NoteCritere, Long>
		implements NoteCritereDaoJpa {

	@Override
	public List<NoteCritere> findByCriteria(NoteCritereCriteria criteria) {
		String statusCode = criteria.getStatut() == null ? null : criteria
				.getStatut().name();
		Object[] parameters = new Object[] { criteria.getCode(),
				criteria.getLibelle(), criteria.getMax(), criteria.getMin(),
				criteria.getLibcritere(), criteria.getNote(), statusCode };
		String queryString = Queries.FIND_NOTE_CRITERE_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<NoteCritere> findForCombo() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_NOTE_CRITERE_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<NoteCritere> findByCode(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_NOTE_CRITERE_BY_CODE;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<NoteCritere> findByCodeCritere(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_NOTE_CRITERE_BY_CODE_CRITERE;
		return executeQuery(queryString, parameters);
	}

}
