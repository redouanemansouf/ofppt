package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.UniversiteCriteria;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.dao.UniversiteDaoJpa;
import com.m2m.onousc.business.referentiel.model.Universite;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

/**
 * 
 * @author abousnane
 * 
 */

@Repository("universiteDao")
public class UniversiteDaoJpaImpl extends GenericDaoJpaImpl<Universite, Long>
		implements UniversiteDaoJpa {

	@Override
	public List<Universite> findByCriteria(UniversiteCriteria criteria) {
		String statusCode = criteria.getStatut() == null ? null : criteria
				.getStatut().name();
		Object[] parameters = new Object[] { criteria.getCode(),
				criteria.getLibelle(), criteria.getAdresseUniv(),
				criteria.getNomResponsableUniv(),
				criteria.getPrenomResponsableUniv(), criteria.getNumTeleUniv(),
				criteria.getAdresseEmailUniv(), criteria.getLibelleville(), statusCode };

		String queryString = Queries.FIND_UNIVERSITE_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<Universite> findForCombo() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_UNIVERSITE_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Universite> findByCode(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_UNIVERSITE_BY_CODE;
		return executeQuery(queryString, parameters);
	}

}
