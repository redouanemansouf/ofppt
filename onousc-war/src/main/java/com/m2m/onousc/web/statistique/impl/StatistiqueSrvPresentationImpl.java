package com.m2m.onousc.web.statistique.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2m.onousc.business.referentiel.criteria.OperationCaisseCriteria;
import com.m2m.onousc.business.referentiel.criteria.StatistiqueCriteria;
import com.m2m.onousc.business.referentiel.criteria.TransactionCriteria;
import com.m2m.onousc.business.statistique.service.StatistiqueService;
import com.m2m.onousc.business.statistique.vo.StatistiqueJourVO;
import com.m2m.onousc.business.statistique.vo.TransactionVO;
import com.m2m.onousc.web.statistique.StatistiqueSrvPresentation;

@Service("statistiqueSrvPresentation")
public class StatistiqueSrvPresentationImpl implements
		StatistiqueSrvPresentation, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -306081226311555509L;
	@Autowired
	StatistiqueService statistiqueService;

	@Override
	public List<StatistiqueJourVO> findAllStatistiqueJour(
			StatistiqueCriteria criteria) {
		if (criteria.getType() == 0)
			return statistiqueService.findStatistiqueByCriteria(criteria);
		else if (criteria.getType() == 2)
			return statistiqueService.findStatistiqueByMounth(criteria);
		else if (criteria.getType() == 3)
			return statistiqueService.findStatistiqueByYear(criteria);
		else
			return statistiqueService.findStatistiqueByWeek(criteria);
	}

	@Override
	public Long findNbreJourConsommation() {
		return statistiqueService.findNbreJourConsommation();
	}

	@Override
	public List<TransactionVO> findTotalTransaction(
			OperationCaisseCriteria criteria) {
		return statistiqueService.findTotalTransaction(criteria);
	}

	@Override
	public List<TransactionVO> findAllTransaction(TransactionCriteria criteria) {
		if (criteria.getType() == 0)
			return statistiqueService.findTransactionByDay(criteria);
		else if (criteria.getType() == 2)
			return statistiqueService.findTransactionByMounth(criteria);
		else if (criteria.getType() == 3)
			return statistiqueService.findTransactionByYear(criteria);
		else
			return statistiqueService.findTransactionByWeek(criteria);
	}

}
