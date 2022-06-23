package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.MotifMainLeveeCriteria;
import com.m2m.onousc.business.referentiel.model.MotifMainLevee;
import com.m2m.technicalservices.dao.GenericDaoJpa;

public interface MotifMainLeveeDaoJpa  extends GenericDaoJpa<MotifMainLevee, Long>{
	
	/**
	 * Find MotifMainLevee by provided critirea.
	 * 
	 * @param criteria
	 *            the criteria
	 * @return List of motifMainLevee
	 */
	public List<MotifMainLevee> findByCriteria(MotifMainLeveeCriteria criteria);

	public List<MotifMainLevee> findForCombo();

	public List<MotifMainLevee> findByCode(String code);
}
