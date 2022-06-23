/**
 * 
 */
package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.model.Compte;
import com.m2m.technicalservices.dao.GenericDaoJpa;
import com.m2m.technicalservices.web.SearchConfig;

/**
 * @author msetati
 *
 */
public interface CompteDaoJpa extends GenericDaoJpa<Compte, Long>{
	public List<Compte> findByCode(String matricule, SearchConfig config);
}
