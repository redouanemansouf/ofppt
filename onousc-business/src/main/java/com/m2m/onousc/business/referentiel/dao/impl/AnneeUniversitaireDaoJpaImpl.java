package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.AnneeUniversitaireCriteria;
import com.m2m.onousc.business.referentiel.dao.AnneeUniversitaireDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.AnneeUniversitaire;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

@Repository("anneeUniversitaireDao")
public class AnneeUniversitaireDaoJpaImpl extends
		GenericDaoJpaImpl<AnneeUniversitaire, Long> implements
		AnneeUniversitaireDaoJpa {

	@Override
	public List<AnneeUniversitaire> findByCriteria(
			AnneeUniversitaireCriteria criteria) {
		String statusCode = criteria.getStatut() == null ? null : criteria
				.getStatut().name();
		Object[] parameters = new Object[] { criteria.getCode(),
				criteria.getLibelle(), criteria.getDate_debut(),
				criteria.getDate_fin(), criteria.getAnnee(), statusCode };
		String queryString = Queries.FIND_ANNEE_UNIVERSITAIRE_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<AnneeUniversitaire> findForCombo() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_ANNEE_UNIVERSITAIRE_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<AnneeUniversitaire> findByCode(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_ANNEE_UNIVERSITAIRE_BY_CODE;
		return executeQuery(queryString, parameters);
	}

	@Override
	public AnneeUniversitaire findActuelAnneeUniversitaire() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ANNEE_UNIVERSITAIRE_ACTUEL;
		return executeQuerySingleResult(queryString, parameters);
	}

}
