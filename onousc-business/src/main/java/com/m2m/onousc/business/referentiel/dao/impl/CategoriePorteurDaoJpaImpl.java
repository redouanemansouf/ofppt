package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.CategoriePorteurCriteria;
import com.m2m.onousc.business.referentiel.dao.CategoriePorteurDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.CategoriePorteur;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

@Repository("categoriePorteurDao")
public class CategoriePorteurDaoJpaImpl extends GenericDaoJpaImpl<CategoriePorteur, Long>
		implements CategoriePorteurDaoJpa {

	@Override
	public List<CategoriePorteur> findByCriteria(CategoriePorteurCriteria criteria) {
		String statusCode = criteria.getStatut() == null ? null : criteria.getStatut().name();
		Object[] parameters = new Object[] { criteria.getCode(), criteria.getLibelle(), criteria.getCategorie(),
				criteria.getRatio(), criteria.getPlafJour(), criteria.getDated(), criteria.getDatef(), statusCode,
				criteria.getIdSite() };
		String queryString = Queries.FIND_CATEGORIE_PORTEUR_BY_CRITERIA;
//		String orderByClause = criteria.getSortField() != null ? " order by "
//				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		String orderByClause = criteria.getSortField() != null
				? " order by " + criteria.getSortField() + " " + criteria.getSortOrder()
				: "";
		return findByCriteria(queryString, orderByClause, criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<CategoriePorteur> findForCombo() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_CATEGORIE_PORTEUR_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<CategoriePorteur> findByCode(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_CATEGORIE_PORTEUR_BY_CODE;
		return executeQuery(queryString, parameters);
	}

}
