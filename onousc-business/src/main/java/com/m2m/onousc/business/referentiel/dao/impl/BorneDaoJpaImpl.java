package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.BorneCriteria;
import com.m2m.onousc.business.referentiel.dao.BorneDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.Borne;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

@Repository("borneDao")
public class BorneDaoJpaImpl extends GenericDaoJpaImpl<Borne, Long> implements
		BorneDaoJpa {

	@Override
	public List<Borne> findByCriteria(BorneCriteria criteria) {
		String statusCode = criteria.getStatut() == null ? null : criteria
				.getStatut().name();
		Object[] parameters = new Object[] { criteria.getCode(),
				criteria.getLibelle(), criteria.getIp(),

				criteria.getLibsite(), statusCode };
		String queryString = Queries.FIND_BORNE_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<Borne> findForCombo() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_BORNE_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Borne> findByCode(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_BORNE_BY_CODE;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Borne> findBySite(Long idSite) {
		Object[] parameters = new Object[] { idSite };
		String queryString = Queries.FIND_BORNE_BY_SITE;
		return executeQuery(queryString, parameters);
	}

}
