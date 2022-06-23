package com.m2m.onousc.web.statistique;

/*
 * ReferentielSrvPresentation.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.OperationCaisseCriteria;
import com.m2m.onousc.business.referentiel.criteria.StatistiqueCriteria;
import com.m2m.onousc.business.referentiel.criteria.TransactionCriteria;
import com.m2m.onousc.business.statistique.vo.StatistiqueJourVO;
import com.m2m.onousc.business.statistique.vo.TransactionVO;

public interface StatistiqueSrvPresentation {

	static final String codeMaroc = "504";

	/**
	 * Find all statistique.
	 * 
	 * @return the list
	 */
	List<StatistiqueJourVO> findAllStatistiqueJour(StatistiqueCriteria criteria);

	Long findNbreJourConsommation();

	List<TransactionVO> findTotalTransaction(OperationCaisseCriteria criteria);

	List<TransactionVO> findAllTransaction(TransactionCriteria criteria);

}