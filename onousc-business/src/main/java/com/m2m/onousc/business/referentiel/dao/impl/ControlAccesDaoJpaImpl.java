package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.ControlAccesCriteria;
import com.m2m.onousc.business.referentiel.dao.ControlAccesDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.ControlAcces;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

@Repository("controlAccesDao")
public class ControlAccesDaoJpaImpl extends
		GenericDaoJpaImpl<ControlAcces, Long> implements ControlAccesDaoJpa {

	@Override
	public List<ControlAcces> findControlAccesByCriteria(
			ControlAccesCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getMatricule(),
				criteria.getDateAcces(), criteria.getHeureAcces(),
				criteria.getDateDebut(), criteria.getDateFin(),criteria.getTourniquet() };
		String queryString = Queries.FIND_CONTROLACCES_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<ControlAcces> findControlAccesAccesPrincip(
			ControlAccesCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getMatricule(),
				criteria.getDateAcces(), criteria.getHeureAcces(),
				criteria.getDateDebut(), criteria.getDateFin(),criteria.getTourniquet() };
		String queryString = Queries.FIND_CONTROLACCES_ACCESPRINCIPAL;
		String orderByClause = criteria.getSortField() != null ? " order by heureAcces "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

}
