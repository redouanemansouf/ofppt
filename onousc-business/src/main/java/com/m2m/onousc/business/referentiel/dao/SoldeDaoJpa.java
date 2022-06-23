/*
 * CarteDaoJpa.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.CarteCriteria;
import com.m2m.onousc.business.referentiel.criteria.CarteNapsCriteria;
import com.m2m.onousc.business.referentiel.criteria.CycleVieCriteria;
import com.m2m.onousc.business.referentiel.criteria.LotCarteCriteria;
import com.m2m.onousc.business.referentiel.criteria.SoldeCriteria;
import com.m2m.onousc.business.referentiel.model.Carte;
import com.m2m.onousc.business.referentiel.model.CarteNaps;
import com.m2m.onousc.business.referentiel.model.CycleVie;
import com.m2m.onousc.business.referentiel.model.Personnel;
import com.m2m.onousc.business.referentiel.model.Solde;
import com.m2m.technicalservices.dao.GenericDaoJpa;

/**
 * The Interface CanalVenteDaoJpa.
 * 
 * @version 1.0 18 févr. 2015
 * @author msadik
 */
public interface SoldeDaoJpa extends GenericDaoJpa<Solde, Long> {

	public List<Solde> findSoldeByCriteria(SoldeCriteria criteria);
	


}
