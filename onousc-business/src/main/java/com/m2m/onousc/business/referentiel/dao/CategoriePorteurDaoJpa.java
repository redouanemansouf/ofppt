package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.CategoriePorteurCriteria;
import com.m2m.onousc.business.referentiel.model.CategoriePorteur;
import com.m2m.technicalservices.dao.GenericDaoJpa;

public interface CategoriePorteurDaoJpa  extends GenericDaoJpa<CategoriePorteur, Long>{
	
	/**
	 * Find CategoriePorteur by provided critirea.
	 * 
	 * @param criteria
	 *            the criteria
	 * @return List of categoriePorteur
	 */
	public List<CategoriePorteur> findByCriteria(CategoriePorteurCriteria criteria);

	public List<CategoriePorteur> findForCombo();

	public List<CategoriePorteur> findByCode(String code);
}
