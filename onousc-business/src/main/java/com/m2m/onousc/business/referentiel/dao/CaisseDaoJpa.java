package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.CaisseCriteria;
import com.m2m.onousc.business.referentiel.model.Caisse;
import com.m2m.technicalservices.dao.GenericDaoJpa;

public interface CaisseDaoJpa extends GenericDaoJpa<Caisse, Long>{

	/**
	 * Find Caisse by provided critirea.
	 *
	 * @param criteria the criteria
	 * @return List of caisse
	 */
	public List<Caisse> findByCriteria(CaisseCriteria criteria);

	public List<Caisse> findForCombo();

	public List<Caisse> findByCode(String code);
	
	public List<Caisse> findByLibelleCite(String libelle);
	
	public List<Caisse> findByCodeRestaurant(String code);
	
	public List<Caisse> findCaisseListByCode(String code);

	List<Caisse> findByIdSite(Long idSite);
}
