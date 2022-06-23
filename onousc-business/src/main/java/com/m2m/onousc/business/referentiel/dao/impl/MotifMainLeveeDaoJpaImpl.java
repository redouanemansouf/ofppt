package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.MotifMainLeveeCriteria;
import com.m2m.onousc.business.referentiel.dao.MotifMainLeveeDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.MotifMainLevee;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

@Repository("motifMainLeveeDao")
public class MotifMainLeveeDaoJpaImpl extends
		GenericDaoJpaImpl<MotifMainLevee, Long> implements MotifMainLeveeDaoJpa {

	@Override
	public List<MotifMainLevee> findByCriteria(MotifMainLeveeCriteria criteria) {
		String statusCode = criteria.getStatut() == null ? null : criteria
				.getStatut().name();
		Object[] parameters = new Object[] { criteria.getCode(),
				criteria.getLibelle(), statusCode };
		String queryString = Queries.FIND_MOTIF_MAIN_LEVEE_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<MotifMainLevee> findForCombo() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_MOTIF_MAIN_LEVEE_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<MotifMainLevee> findByCode(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_MOTIF_MAIN_LEVEE_BY_CODE;
		return executeQuery(queryString, parameters);
	}

}
