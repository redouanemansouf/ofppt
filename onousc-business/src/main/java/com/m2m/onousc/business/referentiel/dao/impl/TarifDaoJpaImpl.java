package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.TarifCriteria;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.dao.TarifDaoJpa;
import com.m2m.onousc.business.referentiel.model.Tarif;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

/**
 * 
 * @author abousnane
 * 
 */
@Repository("tarifDao")
public class TarifDaoJpaImpl extends GenericDaoJpaImpl<Tarif, Long> implements
		TarifDaoJpa {

	@Override
	public List<Tarif> findByCriteria(TarifCriteria criteria) {
		String statusCode = criteria.getStatut() == null ? null : criteria
				.getStatut().name();
		Object[] parameters = new Object[] { criteria.getCode(),
				criteria.getLibelle(), criteria.getTarif(),
				criteria.getLibelleservice(), criteria.getLibellecatporteur(),
				statusCode };
		String queryString = Queries.FIND_TARIF_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<Tarif> findForCombo() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_TARIF_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Tarif> findByCode(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_TARIF_BY_CODE;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Tarif> findByCodeService(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_TARIF_BY_CODE_SERVICE;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Tarif> findByCodeCategoriePorteur(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_TARIF_BY_CODE_CATEGORIE_PORTEUR;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Tarif> findInReservationDetail(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_TARIF_IN_RESERVATION_DETAIL;
		return executeQuery(queryString, parameters);
	}

}
