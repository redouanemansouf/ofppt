package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.CaissierCriteria;
import com.m2m.onousc.business.referentiel.criteria.ClotureCaisseCriteria;
import com.m2m.onousc.business.referentiel.model.Caissier;
import com.m2m.onousc.business.referentiel.model.ClotureCaisse;
import com.m2m.technicalservices.dao.GenericDaoJpa;

public interface ClotureCaisseDaoJpa extends GenericDaoJpa<ClotureCaisse, Long> {


	
	public List<ClotureCaisse> findByCriteria(ClotureCaisseCriteria criteria);


}
