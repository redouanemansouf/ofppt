package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.AnneeUniversitaireCriteria;
import com.m2m.onousc.business.referentiel.model.AnneeUniversitaire;
import com.m2m.technicalservices.dao.GenericDaoJpa;

public interface AnneeUniversitaireDaoJpa extends GenericDaoJpa<AnneeUniversitaire, Long>{

	/**
	 * Find AnneeUniversitaire by provided critirea.
	 * 
	 * @param criteria
	 *            the criteria
	 * @return List of anneeUniversitaire
	 */
	public List<AnneeUniversitaire> findByCriteria(AnneeUniversitaireCriteria criteria);

	public List<AnneeUniversitaire> findForCombo();

	public List<AnneeUniversitaire> findByCode(String code);
	
	public AnneeUniversitaire findActuelAnneeUniversitaire();

}
