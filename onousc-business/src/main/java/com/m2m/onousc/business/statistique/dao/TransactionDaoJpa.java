package com.m2m.onousc.business.statistique.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.TransactionCriteria;
import com.m2m.onousc.business.statistique.vo.TransactionVO;
import com.m2m.technicalservices.dao.GenericDaoJpa;

public interface TransactionDaoJpa extends GenericDaoJpa<TransactionVO, Long> {

	public List<TransactionVO> findTransactionByDay(TransactionCriteria criteria);

	public List<TransactionVO> findTransactionByMounth(
			TransactionCriteria criteria);

	public List<TransactionVO> findTransactionByYear(
			TransactionCriteria criteria);

	public List<TransactionVO> findTransactionByWeek(
			TransactionCriteria criteria);

	public List<TransactionVO> findTotalTransaction(
			TransactionCriteria criteria);
}
