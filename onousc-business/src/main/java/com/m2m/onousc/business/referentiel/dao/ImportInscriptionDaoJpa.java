package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.ImportCriteria;
import com.m2m.onousc.business.referentiel.model.ImportInscription;
import com.m2m.technicalservices.dao.GenericDaoJpa;

public interface ImportInscriptionDaoJpa extends GenericDaoJpa<ImportInscription, Long>{
	
	List<ImportInscription> findByCriteria(ImportCriteria criteria);
	ImportInscription findByCin(String cin);
	ImportInscription findByMassar(String codeMassar);

}
