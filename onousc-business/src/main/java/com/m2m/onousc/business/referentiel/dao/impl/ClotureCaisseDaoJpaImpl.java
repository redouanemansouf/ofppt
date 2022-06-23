package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.ClotureCaisseCriteria;
import com.m2m.onousc.business.referentiel.dao.ClotureCaisseDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.ClotureCaisse;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

@Repository("clotureDao")
public class ClotureCaisseDaoJpaImpl extends
		GenericDaoJpaImpl<ClotureCaisse, Long> implements ClotureCaisseDaoJpa {

	@Override
	public List<ClotureCaisse> findByCriteria(ClotureCaisseCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getCaisse(),
				criteria.getCaissier(), criteria.getDateCloture() };
		String queryString = Queries.FIND_CLOTURE_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

}
