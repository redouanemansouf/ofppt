/*
 * SemaineUniversitaireDaoJpaImpl.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.reservation.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.SemaineUniversitaire;
import com.m2m.onousc.business.reservation.dao.SemaineUniversitaireDaoJpa;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

/**
 * The Class SemaineUniversitaireDaoJpaImpl.
 * 
 * @version 1.0 9 oct. 2015
 * @author mbenboubker
 */
@Repository("semaineUniversitaireDao")
public class SemaineUniversitaireDaoJpaImpl extends
		GenericDaoJpaImpl<SemaineUniversitaire, Long> implements
		SemaineUniversitaireDaoJpa {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.reservation.dao.SemaineUniversitaireDaoJpa#
	 * findForCombo()
	 */
	@Override
	public List<SemaineUniversitaire> findForCombo() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_SEMAINE_UNIVERSITAIRE_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.reservation.dao.SemaineUniversitaireDaoJpa#findById
	 * (long)
	 */
	@Override
	public SemaineUniversitaire findById(long idSemaineUniversitaire) {
		Object[] parameters = new Object[] { idSemaineUniversitaire };
		String queryString = Queries.FIND_SEMAINE_UNIVERSITAIRE_BY_ID;
		return executeQuerySingleResult(queryString, parameters);
	}

}
