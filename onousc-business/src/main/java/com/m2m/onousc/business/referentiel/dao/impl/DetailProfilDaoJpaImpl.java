/*
 * CarteDaoJpaImpl.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.CarteCriteria;
import com.m2m.onousc.business.referentiel.criteria.DetailProfilCriteria;
import com.m2m.onousc.business.referentiel.criteria.LotCarteCriteria;
import com.m2m.onousc.business.referentiel.criteria.PersonnelCriteria;
import com.m2m.onousc.business.referentiel.dao.CarteDaoJpa;
import com.m2m.onousc.business.referentiel.dao.DetailProfilDaoJpa;
import com.m2m.onousc.business.referentiel.dao.PersonnelDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.Caisse;
import com.m2m.onousc.business.referentiel.model.Carte;
import com.m2m.onousc.business.referentiel.model.CycleVie;
import com.m2m.onousc.business.referentiel.model.DetailProfilAcces;
import com.m2m.onousc.business.referentiel.model.Personnel;
import com.m2m.onousc.business.referentiel.model.Produit;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class CanalVenteDaoJpaImpl.
 * 
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
@Repository("detailprofilDao")
public class DetailProfilDaoJpaImpl extends GenericDaoJpaImpl<DetailProfilAcces, Long> implements
		DetailProfilDaoJpa {

	

	
	@Override
	public List<DetailProfilAcces> findDetailProfilByCriteria(
			DetailProfilCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getTranche(),
				criteria.getJour(), criteria.getDateDebut(),
				criteria.getDateFin(),criteria.getProfil(),criteria.getLibelleP() };
		String queryString = Queries.FIND_DETAILPROFIL_BY_CRITERIA;
		String orderByClause=" order by jour DESC ";
		return findByCriteria(queryString ,orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<DetailProfilAcces> findDetailProfilByprofil(String code) {
		Object[] parameters = new Object[] {code};
		String queryString = Queries.FIND_DETAILPROFIL_BY_profil;
		return executeQuery(queryString, parameters);
	}
	
	

	
}
