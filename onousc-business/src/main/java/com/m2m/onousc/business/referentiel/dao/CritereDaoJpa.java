package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.CritereCriteria;
import com.m2m.onousc.business.referentiel.model.Critere;
import com.m2m.technicalservices.dao.GenericDaoJpa;

public interface CritereDaoJpa extends GenericDaoJpa<Critere, Long> {

	/**
	 * Find Critere by provided critirea.
	 * 
	 * @param Critere
	 *            the criteria
	 * @return List of Critere
	 */
	public List<Critere> findByCriteria(CritereCriteria criteria);

	public List<Critere> findForCombo();

	public List<Critere> findByCode(String code);
}