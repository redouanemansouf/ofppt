package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.PlafondCriteria;
import com.m2m.onousc.business.referentiel.model.Plafond;
import com.m2m.technicalservices.dao.GenericDaoJpa;

public interface PlafondDaoJpa extends GenericDaoJpa<Plafond, Long>{

	/**
	 * Find Plafond by provided critirea.
	 *
	 * @param criteria the criteria
	 * @return List of plafond
	 */
	public List<Plafond> findByCriteria(PlafondCriteria criteria);

	public List<Plafond> findForCombo();

	public List<Plafond> findByCode(String code);
}
