package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.ConsultCaisseCriteria;
import com.m2m.onousc.business.referentiel.model.ConsultCaisse;
import com.m2m.technicalservices.dao.GenericDaoJpa;

public interface ConsultCaisseDaoJpa extends
		GenericDaoJpa<ConsultCaisse, Long> {

	/**
	 * Find OperationCaisse by provided critirea.
	 * 
	 * @param criteria
	 *            the criteria
	 * @return List of operationCaisse
	 */
	public List<ConsultCaisse> findByCriteria(ConsultCaisseCriteria criteria);

	public List<ConsultCaisse> findByCodeCaisse(String code);

}
