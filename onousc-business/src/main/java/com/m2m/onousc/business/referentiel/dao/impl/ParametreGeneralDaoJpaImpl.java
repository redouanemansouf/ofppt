package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.ParametreGeneralCriteria;
import com.m2m.onousc.business.referentiel.dao.ParametreGeneralDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.ParametreGeneral;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

@Repository("parametreGeneralDao")
public class ParametreGeneralDaoJpaImpl extends
		GenericDaoJpaImpl<ParametreGeneral, Long> implements
		ParametreGeneralDaoJpa {

	@Override
	public List<ParametreGeneral> findByCriteria(ParametreGeneralCriteria criteria) {
		String statusCode = criteria.getStatut() == null ? null : criteria
				.getStatut().name();
		Object[] parameters = new Object[] { criteria.getCode(),
				criteria.getLibelle(), statusCode };
		String queryString = Queries.FIND_PARAMETRE_GENERAL_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<ParametreGeneral> findForCombo() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_PARAMETRE_GENERAL_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<ParametreGeneral> findByCode(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_PARAMETRE_GENERAL_BY_CODE;
		return executeQuery(queryString, parameters);
	}

}
