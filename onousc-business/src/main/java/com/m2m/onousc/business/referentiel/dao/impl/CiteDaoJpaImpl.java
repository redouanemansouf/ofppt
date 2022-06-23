package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.CiteCriteria;
import com.m2m.onousc.business.referentiel.dao.CiteDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.Cite;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

/**
 * 
 * @author abousnane
 * 
 */
@Repository("citeDao")
public class CiteDaoJpaImpl extends GenericDaoJpaImpl<Cite, Long> implements
		CiteDaoJpa {

	@Override
	public List<Cite> findByCriteria(CiteCriteria criteria) {
		String statusCode = criteria.getStatut() == null ? null : criteria
				.getStatut().name();
		Object[] parameters = new Object[] { criteria.getCode(),
				criteria.getLibelle(), criteria.getLibuniv(),
				criteria.getAdresseCite(), criteria.getNomResponsableCite(),
				criteria.getPrenomResponsableCite(), criteria.getNumTeleCite(),
				criteria.getAdresseEmailCite(), criteria.getLibelleville(),
				statusCode };

		String queryString = Queries.FIND_CITE_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<Cite> findForCombo() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_CITE_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Cite> findByCode(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_CITE_BY_CODE;
		return executeQuery(queryString, parameters);

	}

	@Override
	public List<Cite> findByUniversite(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_CITE_BY_CODE_UNIVERSITE;
		return executeQuery(queryString, parameters);
	}

}
