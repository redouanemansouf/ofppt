package com.m2m.onousc.business.referentiel.dao;



import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.UniversiteCriteria;
import com.m2m.onousc.business.referentiel.model.CanalVente;
import com.m2m.onousc.business.referentiel.model.Universite;
import com.m2m.technicalservices.dao.GenericDaoJpa;
import com.m2m.technicalservices.web.SearchConfig;



public interface UniversiteDaoJpa extends GenericDaoJpa<Universite, Long>{

	/**
	 * Find Universite by provided critirea.
	 *
	 * @param code the code
	 * @param libelle the libelle
	 * @param adresseUniv the adresse universite
	 * @param nomResponsableUniv the nom responsable universite
	 * @param prenomResponsableUniv the prenom responsable universite
	 * @param numTeleUniv the numero telephone universite
	 * @param adresseEmailUniv the numero telephone universite
	 * @param staut the staut
	 * @param config the config
	 * @param sortField the sort field
	 * @param sortOrder the sort order
	 * @return List of Universite
	 */
	public List<Universite> findByCriteria(UniversiteCriteria criteria);
	
	public List<Universite> findForCombo();

	/**
	 * Find Universite By provided code.
	 *
	 * @param code the code
	 * @param config the config
	 * @return the list
	 */
	public List<Universite> findByCode(String code);
}
