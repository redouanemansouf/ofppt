package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.CaissierCriteria;
import com.m2m.onousc.business.referentiel.dao.CaissierDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.Caissier;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

@Repository("caissierDao")
public class CaissierDaoJpaImpl extends GenericDaoJpaImpl<Caissier, Long>
		implements CaissierDaoJpa {

	@Override
	public List<Caissier> findByCriteria(CaissierCriteria criteria) {
		String statusCode = criteria.getStatut() == null ? null : criteria
				.getStatut().name();
		Object[] parameters = new Object[] { criteria.getCode(),
				criteria.getNom(), criteria.getPrenom(), criteria.getNumTele(),
				criteria.getAdresseEmail(), criteria.getLibellecaisse(),
				statusCode,criteria.getIdSite() };
		String queryString = Queries.FIND_CAISSIER_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<Caissier> findForCombo() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_CAISSIER_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Caissier> findByCode(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_CAISSIER_BY_CODE;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Caissier> findByNumcarte(String numcarte) {
		Object[] parameters = new Object[] { numcarte };
		String queryString = Queries.FIND_CAISSIER_BY_NUMCARTE;
		return executeQuery(queryString, parameters);
	}

}
