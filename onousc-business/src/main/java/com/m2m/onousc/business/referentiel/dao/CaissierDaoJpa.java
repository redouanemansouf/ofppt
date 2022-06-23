package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.CaissierCriteria;
import com.m2m.onousc.business.referentiel.model.Caissier;
import com.m2m.technicalservices.dao.GenericDaoJpa;

public interface CaissierDaoJpa extends GenericDaoJpa<Caissier, Long> {

	/**
	 * Find Caissier by provided critirea.
	 * 
	 * @param criteria
	 *            the criteria
	 * @return List of Caissier
	 */
	public List<Caissier> findByCriteria(CaissierCriteria criteria);

	public List<Caissier> findForCombo();

	public List<Caissier> findByCode(String code);
	
	public List<Caissier> findByNumcarte(String numcarte);

}
