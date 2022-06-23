package com.m2m.onousc.business.statistique.service;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.OperationCaisseCriteria;
import com.m2m.onousc.business.referentiel.criteria.StatistiqueCriteria;
import com.m2m.onousc.business.referentiel.criteria.TransactionCriteria;
import com.m2m.onousc.business.statistique.vo.StatistiqueJourVO;
import com.m2m.onousc.business.statistique.vo.TransactionVO;

public interface StatistiqueService {

	public List<StatistiqueJourVO> findStatistiqueByCriteria(
			StatistiqueCriteria criteria);

	public List<StatistiqueJourVO> findStatistiqueByMounth(
			StatistiqueCriteria criteria);

	public List<StatistiqueJourVO> findStatistiqueByYear(
			StatistiqueCriteria criteria);

	public List<StatistiqueJourVO> findStatistiqueByWeek(
			StatistiqueCriteria criteria);
	
	public Long findNbreJourConsommation();
	
	public List<TransactionVO> findTotalTransaction(OperationCaisseCriteria criteria);
	
	public List<TransactionVO> findTransactionByDay(
			TransactionCriteria criteria);
	
	public List<TransactionVO> findTransactionByMounth(
			TransactionCriteria criteria);

	public List<TransactionVO> findTransactionByYear(
			TransactionCriteria criteria);

	public List<TransactionVO> findTransactionByWeek(
			TransactionCriteria criteria);
}
