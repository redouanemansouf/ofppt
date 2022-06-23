package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.TarifCriteria;
import com.m2m.onousc.business.referentiel.model.Tarif;
import com.m2m.technicalservices.dao.GenericDaoJpa;

/**
 * 
 * @author abousnane
 *
 */
public interface TarifDaoJpa extends GenericDaoJpa<Tarif, Long> {

	/**
	 * Find Taif by provided critirea.
	 *
	 * @param criteria the criteria
	 * @return List of Taif
	 */
	public List<Tarif> findByCriteria(TarifCriteria criteria);

	public List<Tarif> findForCombo();

	public List<Tarif> findByCode(String code);
	
	public List<Tarif> findByCodeService(String code);
	
	public List<Tarif> findByCodeCategoriePorteur(String code);
	
	public List<Tarif> findInReservationDetail(String code);
	
}