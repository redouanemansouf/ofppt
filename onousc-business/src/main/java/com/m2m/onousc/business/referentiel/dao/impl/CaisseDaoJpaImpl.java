package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.CaisseCriteria;
import com.m2m.onousc.business.referentiel.dao.CaisseDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.Caisse;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

@Repository("caisseDao")
public class CaisseDaoJpaImpl extends GenericDaoJpaImpl<Caisse, Long> implements
		CaisseDaoJpa {

	@Override
	public List<Caisse> findByCriteria(CaisseCriteria criteria) {
		String statusCode = criteria.getStatut() == null ? null : criteria
				.getStatut().name();
		Object[] parameters = new Object[] { criteria.getCode(),
				criteria.getLibelle(), criteria.getLibrest(), statusCode,criteria.getIdSite() };
		String queryString = Queries.FIND_CAISSE_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<Caisse> findForCombo() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_CAISSE_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Caisse> findByCode(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_CAISSE_BY_CODE;
		return executeQuery(queryString, parameters);
	}
	
	@Override
	public List<Caisse> findByIdSite(Long idSite) {
		Object[] parameters = new Object[] { idSite };
		String queryString = Queries.FIND_ALL_CAISSE_BY_IDSITE;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Caisse> findByLibelleCite(String libelle) {
		Object[] parameters = new Object[] { libelle };
		String queryString = Queries.FIND_CAISSE_BY_CITE;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Caisse> findByCodeRestaurant(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_CAISSE_BY_CODE_RESTAURANT;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Caisse> findCaisseListByCode(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_CAISSE_BY_CODE_RESTAURANT;
		return executeQuery(queryString, parameters);
	}

}
