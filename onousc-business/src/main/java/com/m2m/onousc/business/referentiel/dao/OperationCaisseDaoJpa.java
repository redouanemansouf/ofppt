package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.OperCaisseCriteria;
import com.m2m.onousc.business.referentiel.model.OperationCaisse;
import com.m2m.technicalservices.dao.GenericDaoJpa;

public interface OperationCaisseDaoJpa extends
		GenericDaoJpa<OperationCaisse, Long> {

	/**
	 * Find OperationCaisse by provided critirea.
	 * 
	 * @param criteria
	 *            the criteria
	 * @return List of operationCaisse
	 */
	public List<OperationCaisse> findByCriteria(OperCaisseCriteria criteria);

	public List<OperationCaisse> findByCodeCaisse(String code);

	public double findSoldeByMatricule(String matr);
	
	public void persisthisto(String matricule, Float montant, Float solde);

	public void persisthistoDecharge(String matricule, Float montant,
			Float solde);
}
