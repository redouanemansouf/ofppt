package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.BorneCriteria;
import com.m2m.onousc.business.referentiel.model.Borne;
import com.m2m.technicalservices.dao.GenericDaoJpa;

public interface BorneDaoJpa extends GenericDaoJpa<Borne, Long> {

	/**
	 * Find Borne by provided critirea.
	 * 
	 * @param criteria
	 *            the criteria
	 * @return List of Borne
	 */
	public List<Borne> findByCriteria(BorneCriteria criteria);

	public List<Borne> findForCombo();

	public List<Borne> findByCode(String code);

	public List<Borne> findBySite(Long idSite);
}
