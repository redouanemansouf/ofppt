package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.ParametreGeneralCriteria;
import com.m2m.onousc.business.referentiel.model.ParametreGeneral;
import com.m2m.technicalservices.dao.GenericDaoJpa;

public interface ParametreGeneralDaoJpa  extends GenericDaoJpa<ParametreGeneral, Long>{
	
	/**
	 * Find ParametreGeneral by provided critirea.
	 * 
	 * @param criteria
	 *            the criteria
	 * @return List of parametreGeneral
	 */
	public List<ParametreGeneral> findByCriteria(ParametreGeneralCriteria criteria);

	public List<ParametreGeneral> findForCombo();

	public List<ParametreGeneral> findByCode(String code);
}