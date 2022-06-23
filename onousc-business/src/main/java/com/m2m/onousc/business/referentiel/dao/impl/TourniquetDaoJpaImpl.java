package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.TourniquetCriteria;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.dao.TourniquetDaoJpa;
import com.m2m.onousc.business.referentiel.model.Tourniquet;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

@Repository("tourniquetDao")
public class TourniquetDaoJpaImpl extends GenericDaoJpaImpl<Tourniquet, Long>
		implements TourniquetDaoJpa {

	@Override
	public List<Tourniquet> findByCriteria(TourniquetCriteria criteria) {
		String statusCode = criteria.getStatut() == null ? null : criteria
				.getStatut().name();
		Object[] parameters = new Object[] { criteria.getCode(),
				criteria.getLibelle(), criteria.getLibrest(),
				criteria.getReference(), statusCode };
		String queryString = Queries.FIND_TOURNIQUET_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<Tourniquet> findForCombo() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_TOURNIQUET_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Tourniquet> findByCode(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_TOURNIQUET_BY_CODE;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Tourniquet> findByCodeRestaurant(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_TOURNIQUET_BY_CODE_RESTAURANT;
		return executeQuery(queryString, parameters);
	}

}
