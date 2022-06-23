package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.TourniquetCriteria;
import com.m2m.onousc.business.referentiel.model.Tourniquet;
import com.m2m.technicalservices.dao.GenericDaoJpa;

public interface TourniquetDaoJpa extends GenericDaoJpa<Tourniquet, Long>{

	/**
	 * Find Tourniquet by provided critirea.
	 *
	 * @param criteria the criteria
	 * @return List of tourniquet
	 */
	public List<Tourniquet> findByCriteria(TourniquetCriteria criteria);

	public List<Tourniquet> findForCombo();

	public List<Tourniquet> findByCode(String code);
	
	public List<Tourniquet> findByCodeRestaurant(String code);

}
