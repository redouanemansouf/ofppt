package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.DemandeAdminCriteria;
import com.m2m.onousc.business.referentiel.model.DemandeAdmin;
import com.m2m.technicalservices.dao.GenericDaoJpa;

public interface DemandeAdminDaoJpa extends GenericDaoJpa<DemandeAdmin, Long> {

	/**
	 * Find DemandeAdmin by provided critirea.
	 *
	 * @param criteria the criteria
	 * @return List of DemandeAdmin
	 */
	public List<DemandeAdmin> findByCriteria(DemandeAdminCriteria criteria);
}
