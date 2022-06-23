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
import com.m2m.onousc.business.referentiel.criteria.CarteNapsCriteria;
import com.m2m.onousc.business.referentiel.criteria.LotCarteCriteria;
import com.m2m.onousc.business.referentiel.criteria.ProfilPorteurCriteria;
import com.m2m.onousc.business.referentiel.dao.CarteDaoJpa;
import com.m2m.onousc.business.referentiel.dao.CarteNapsDaoJpa;
import com.m2m.onousc.business.referentiel.dao.ProfilPorteurDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.Carte;
import com.m2m.onousc.business.referentiel.model.CarteNaps;
import com.m2m.onousc.business.referentiel.model.CycleVie;
import com.m2m.onousc.business.referentiel.model.ProfilPorteur;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class CanalVenteDaoJpaImpl.
 * 
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
@Repository("profilPorteurDao")
public class ProfilPorteurDaoJpaImpl extends GenericDaoJpaImpl<ProfilPorteur, Long> implements
ProfilPorteurDaoJpa {

	@Override
	public List<ProfilPorteur> findProfilPorteurByCriteria(
			ProfilPorteurCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getCode() , criteria.getLibelle() , 
				criteria.getCategorie() , criteria.getRatio()};
		String queryString = Queries.FIND_PROFIL_PORTEUR_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString ,orderByClause,
				criteria.getSearchConfig(), parameters);
	}
	
}
