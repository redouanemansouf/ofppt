package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.EquipementCriteria;
import com.m2m.onousc.business.referentiel.dao.EquipementDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.Equipement;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

@Repository("equipementDao")
public class EquipementDaoJpaImpl extends GenericDaoJpaImpl<Equipement, Long>
		implements EquipementDaoJpa {

	@Override
	public List<Equipement> findByCriteria(EquipementCriteria criteria) {
		String statusCode = criteria.getStatut() == null ? null : criteria
				.getStatut().name();
		Object[] parameters = new Object[] { criteria.getCode(),
				criteria.getMarque(), criteria.getFournisseur(),
				criteria.getReference(), criteria.getNumSerie(),
				criteria.getDateAchat(), criteria.getType(),
				criteria.getLibcite(), criteria.getLibrest(), statusCode };
		String queryString = Queries.FIND_EQUIPEMENT_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<Equipement> findForCombo() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_EQUIPEMENT_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Equipement> findByCode(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_EQUIPEMENT_BY_CODE;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Equipement> findByCodeCite(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_EQUIPEMENT_BY_CODE_CITE;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Equipement> findByCodeRestaurant(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_EQUIPEMENT_BY_CODE_RESTAURANT;
		return executeQuery(queryString, parameters);
	}

}
