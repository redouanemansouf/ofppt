package com.m2m.onousc.business.statistique.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.OperationCaisseCriteria;
import com.m2m.onousc.business.referentiel.criteria.StatistiqueCriteria;
import com.m2m.onousc.business.statistique.vo.StatistiqueJourVO;
import com.m2m.onousc.business.statistique.vo.TransactionVO;
import com.m2m.technicalservices.dao.GenericDaoJpa;

public interface StatistiqueDaoJpa extends
		GenericDaoJpa<StatistiqueJourVO, Long> {

	public List<StatistiqueJourVO> findNbreConsommationByCriteria(
			StatistiqueCriteria criteria);

	public List<StatistiqueJourVO> findNbreReservationByCriteria(
			StatistiqueCriteria criteria);

	public List<StatistiqueJourVO> findStatistiqueByMounth(
			StatistiqueCriteria criteria);

	public List<StatistiqueJourVO> findStatistiqueByYear(
			StatistiqueCriteria criteria);

	public List<StatistiqueJourVO> findStatistiqueByWeek(
			StatistiqueCriteria criteria);
	
	public Long findNbreJourConsommation();
	
	public List<TransactionVO>  findTotalTransaction(OperationCaisseCriteria criteria);
}
