package com.m2m.onousc.business.statistique.service.impl;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2m.onousc.business.referentiel.criteria.OperationCaisseCriteria;
import com.m2m.onousc.business.referentiel.criteria.StatistiqueCriteria;
import com.m2m.onousc.business.referentiel.criteria.TransactionCriteria;
import com.m2m.onousc.business.statistique.dao.StatistiqueDaoJpa;
import com.m2m.onousc.business.statistique.dao.TransactionDaoJpa;
import com.m2m.onousc.business.statistique.service.StatistiqueService;
import com.m2m.onousc.business.statistique.vo.StatistiqueJourVO;
import com.m2m.onousc.business.statistique.vo.TransactionVO;

@Service("statistiqueService")
public class StatistiqueServiceImpl implements StatistiqueService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4387033543673628440L;

	@Autowired
	private StatistiqueDaoJpa statistiqueDaoJpa;
	@Autowired
	private TransactionDaoJpa transactionDaoJpa;

	@Override
	public List<StatistiqueJourVO> findStatistiqueByCriteria(
			StatistiqueCriteria criteria) {
		List<StatistiqueJourVO> listnbrres = statistiqueDaoJpa
				.findNbreReservationByCriteria(criteria);
		List<StatistiqueJourVO> listnbrconso = statistiqueDaoJpa
				.findNbreConsommationByCriteria(criteria);
		for (StatistiqueJourVO str : listnbrconso) {
			int indice = findStatistiqueJourVOByDate(listnbrres, str);
			if (indice == -1)
				listnbrres.add(str);
			else {
				listnbrres.get(indice).setNbreRepasConsomme(
						str.getNbreRepasConsomme());
				listnbrres.get(indice).setMontantRepasConsomme(
						str.getMontantRepasConsomme());
			}
		}
		Collections.sort(listnbrres);
		return listnbrres;
	}

	int findStatistiqueJourVOByDate(List<StatistiqueJourVO> listst,
			StatistiqueJourVO r) {
		int i = 0;
		for (StatistiqueJourVO sj : listst) {
			if (sj.getDateOperation().compareTo(r.getDateOperation()) == 0
					&& sj.getCite().compareTo(r.getCite()) == 0
					&& sj.getResto().compareTo(r.getResto()) == 0)
				return i;
			i++;
		}

		return -1;
	}

	@Override
	public List<StatistiqueJourVO> findStatistiqueByMounth(
			StatistiqueCriteria criteria) {
		return statistiqueDaoJpa.findStatistiqueByMounth(criteria);
	}

	@Override
	public List<StatistiqueJourVO> findStatistiqueByYear(
			StatistiqueCriteria criteria) {
		return statistiqueDaoJpa.findStatistiqueByYear(criteria);
	}

	@Override
	public List<StatistiqueJourVO> findStatistiqueByWeek(
			StatistiqueCriteria criteria) {
		return statistiqueDaoJpa.findStatistiqueByWeek(criteria);
	}

	@Override
	public Long findNbreJourConsommation() {
		return statistiqueDaoJpa.findNbreJourConsommation();
	}

	@Override
	public List<TransactionVO> findTotalTransaction(
			OperationCaisseCriteria criteria) {
		return statistiqueDaoJpa.findTotalTransaction(criteria);
	}

	@Override
	public List<TransactionVO> findTransactionByDay(TransactionCriteria criteria) {
		return transactionDaoJpa.findTransactionByDay(criteria);
	}

	@Override
	public List<TransactionVO> findTransactionByMounth(
			TransactionCriteria criteria) {
		return transactionDaoJpa.findTransactionByMounth(criteria);
	}

	@Override
	public List<TransactionVO> findTransactionByYear(
			TransactionCriteria criteria) {
		return transactionDaoJpa.findTransactionByYear(criteria);
	}

	@Override
	public List<TransactionVO> findTransactionByWeek(
			TransactionCriteria criteria) {
		return transactionDaoJpa.findTransactionByWeek(criteria);
	}

}
