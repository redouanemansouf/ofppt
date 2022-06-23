package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.EquipementCriteria;
import com.m2m.onousc.business.referentiel.model.Equipement;
import com.m2m.technicalservices.dao.GenericDaoJpa;

public interface EquipementDaoJpa extends GenericDaoJpa<Equipement, Long> {

	/**
	 * Find Equipement by provided critirea.
	 * 
	 * @param criteria
	 *            the criteria
	 * @return List of equipement
	 */
	public List<Equipement> findByCriteria(EquipementCriteria criteria);

	public List<Equipement> findForCombo();

	public List<Equipement> findByCode(String code);
	
	public List<Equipement> findByCodeCite(String code);
	
	public List<Equipement> findByCodeRestaurant(String code);

}
