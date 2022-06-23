package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.MotifOppositionCriteria;
import com.m2m.onousc.business.referentiel.model.MotifOpposition;
import com.m2m.technicalservices.dao.GenericDaoJpa;

public interface MotifOppositionDaoJpa  extends GenericDaoJpa<MotifOpposition, Long>{
	
	/**
	 * Find MotifOpposition by provided critirea.
	 * 
	 * @param criteria
	 *            the criteria
	 * @return List of motifOpposition
	 */
	public List<MotifOpposition> findByCriteria(MotifOppositionCriteria criteria);

	public List<MotifOpposition> findForCombo();

	public List<MotifOpposition> findByCode(String code);
}
