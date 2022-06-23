package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.ControlAccesCriteria;
import com.m2m.onousc.business.referentiel.model.ControlAcces;
import com.m2m.technicalservices.dao.GenericDaoJpa;

public interface ControlAccesDaoJpa extends GenericDaoJpa<ControlAcces, Long> {

	public List<ControlAcces> findControlAccesByCriteria(
			ControlAccesCriteria criteria);
	
	public List<ControlAcces> findControlAccesAccesPrincip(
			ControlAccesCriteria criteria);

}
