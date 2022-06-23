package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.NoteCritereCriteria;
import com.m2m.onousc.business.referentiel.model.NoteCritere;
import com.m2m.technicalservices.dao.GenericDaoJpa;

public interface NoteCritereDaoJpa extends GenericDaoJpa<NoteCritere, Long> {

	/**
	 * Find NoteCritere by provided critirea.
	 * 
	 * @param NoteCritere
	 *            the criteria
	 * @return List of NoteCritere
	 */
	public List<NoteCritere> findByCriteria(NoteCritereCriteria criteria);

	public List<NoteCritere> findForCombo();

	public List<NoteCritere> findByCode(String code);
	
	public List<NoteCritere> findByCodeCritere(String code);
}