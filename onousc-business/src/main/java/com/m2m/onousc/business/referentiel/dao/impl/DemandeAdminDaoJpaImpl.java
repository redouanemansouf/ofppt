package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.DemandeAdminCriteria;
import com.m2m.onousc.business.referentiel.dao.DemandeAdminDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.DemandeAdmin;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

@Repository("demandeAdminDao")
public class DemandeAdminDaoJpaImpl extends GenericDaoJpaImpl<DemandeAdmin, Long> implements DemandeAdminDaoJpa {

	@Override
	public List<DemandeAdmin> findByCriteria(DemandeAdminCriteria criteria) {
		//String statusCode = criteria.getStatut() == null ? null : criteria.getStatut().name();
		Object[] parameters = new Object[] { criteria.getBorne(), criteria.getMatricule(), criteria.getNom(),
				criteria.getPrenom(), criteria.getTypePersonnelle(), criteria.getTypeDemande()};
		String queryString = Queries.FIND_DEMANDE_ADMIN_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null
				? " order by " + criteria.getSortField() + " " + criteria.getSortOrder()
				: "";
		return findByCriteria(queryString, orderByClause, criteria.getSearchConfig(), parameters);
	}

}
