package com.m2m.onousc.business.referentiel.dao;


import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.CiteCriteria;
import com.m2m.onousc.business.referentiel.model.Cite;
import com.m2m.technicalservices.dao.GenericDaoJpa;




public interface CiteDaoJpa extends GenericDaoJpa<Cite, Long>{
	
	/**
	 * Find Cite by provided critirea.
	 *
	 * @param code the code
	 * @param libelle the libelle
	 * @param universite the universite
	 * @param adresseCite the adresse Cite
	 * @param nomResponsableCite the nom responsable Cite
	 * @param prenomResponsableCite the prenom responsable Cite
	 * @param numTeleCite the numero telephone Cite
	 * @param adresseEmailCite the adresse email cite
	 * @param staut the staut
	 * @param config the config
	 * @param sortField the sort field
	 * @param sortOrder the sort order
	 * @return List of Cite
	 */
	public List<Cite> findByCriteria(CiteCriteria criteria);
	
	public List<Cite> findForCombo();

	/**
	 * Find Cite By provided code.
	 *
	 * @param code the code
	 * @param config the config
	 * @return the list
	 */
	public List<Cite> findByCode(String code);
	
	public List<Cite> findByUniversite(String code);
}
