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
import com.m2m.onousc.business.referentiel.dao.CarteDaoJpa;
import com.m2m.onousc.business.referentiel.dao.CarteNapsDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.Carte;
import com.m2m.onousc.business.referentiel.model.CarteNaps;
import com.m2m.onousc.business.referentiel.model.CycleVie;
import com.m2m.onousc.business.referentiel.model.Personnel;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class CanalVenteDaoJpaImpl.
 * 
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
@Repository("carteNapsDao")
public class CarteNapsDaoJpaImpl extends GenericDaoJpaImpl<CarteNaps, Long> implements
		CarteNapsDaoJpa {

	@Override
	public List<CarteNaps> findCarteNapsByCriteria(CarteNapsCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getNom() , criteria.getPrenom() , 
				criteria.getNumidentite() , criteria.getMatr(), criteria.getIdSite()};
		String queryString = Queries.FIND_CARTE_NAPS_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString ,orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public CarteNaps findCarteNapsByMatricule(String matr) {
		Object[] parameters = new Object[] { matr };
		CarteNaps result=null;
		try {
			String queryString = Queries.FIND_PERSONNEL_CARTE_NAPS_BY_MATRICULE;
			result=executeQuerySingleResult(queryString, parameters);
		} catch (NoResultException e) {
			result=null;
		}
		return result;
		
	}

	@Override
	public CarteNaps findCarteNapsByID(String id) {
		Object[] parameters = new Object[] { id };
		String queryString = Queries.FIND_CARTE_NAPS_BY_ID;
		CarteNaps cartenaps=null;
		try{
			cartenaps= executeQuerySingleResult(queryString, parameters);
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return cartenaps;
		
	}

	
	
}
