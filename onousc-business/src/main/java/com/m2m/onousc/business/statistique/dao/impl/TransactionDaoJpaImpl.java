package com.m2m.onousc.business.statistique.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.TransactionCriteria;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.statistique.dao.TransactionDaoJpa;
import com.m2m.onousc.business.statistique.vo.TransactionVO;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;
import com.m2m.technicalservices.web.SearchConfig;

@Repository("transactionDao")
public class TransactionDaoJpaImpl extends
		GenericDaoJpaImpl<TransactionVO, Long> implements TransactionDaoJpa {

	@Override
	public List<TransactionVO> findTransactionByDay(TransactionCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getDateDebut(),
				criteria.getDateFin(), criteria.getLibrestaurant(),
				criteria.getLibcite(), criteria.getTypeOperation(),
				criteria.getCodeetu() };
		String queryString = Queries.FIND_TRANSACTION_BY_JOUR;
		String orderByClause = " GROUP BY dateOperation, typeOperation, caisse.restaurant.cite.libelle, caisse.restaurant.libelle";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<TransactionVO> findTransactionByMounth(
			TransactionCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getDateDebut(),
				criteria.getDateFin(), criteria.getLibrestaurant(),
				criteria.getLibcite(), criteria.getTypeOperation(),
				criteria.getCodeetu() };
		String queryString = Queries.FIND_TRANSACTION_BY_MOIS;
		String orderByClause = " GROUP BY YEAR(dateOperation), MONTH(dateOperation), typeOperation, caisse.restaurant.cite.libelle, caisse.restaurant.libelle";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<TransactionVO> findTransactionByYear(
			TransactionCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getDateDebut(),
				criteria.getDateFin(), criteria.getLibrestaurant(),
				criteria.getLibcite(), criteria.getTypeOperation(),
				criteria.getCodeetu() };
		String queryString = Queries.FIND_TRANSACTION_BY_ANNEE;
		String orderByClause = " GROUP BY YEAR(dateOperation), typeOperation, caisse.restaurant.cite.libelle, caisse.restaurant.libelle";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<TransactionVO> findTransactionByWeek(
			TransactionCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getDateDebut(),
				criteria.getDateFin(), criteria.getLibrestaurant(),
				criteria.getLibcite(), criteria.getTypeOperation(),
				criteria.getCodeetu() };
		String queryString = Queries.FIND_TRANSACTION_BY_SEMAINE;
		String orderByClause = " GROUP BY WEEKOFYEAR(dateOperation), YEAR(dateOperation), typeOperation, caisse.restaurant.cite.libelle, caisse.restaurant.libelle";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<TransactionVO> findTotalTransaction(TransactionCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionVO> findByCriteria(String queryString,
			String orderByClause, SearchConfig config, Object... parameters) {
		List<TransactionVO> listtransaction = new ArrayList<TransactionVO>();
		Query query = createQuery(queryString + " " + orderByClause, null,
				null, parameters);
		@SuppressWarnings("unchecked")
		List<Object[]> result = query.getResultList();
		if (orderByClause
				.equals(" GROUP BY dateOperation, typeOperation, caisse.restaurant.cite.libelle, caisse.restaurant.libelle"))
			for (Object[] resultElement : result) {
				listtransaction.add(new TransactionVO(
						(String) resultElement[1], (Double) resultElement[2],
						(String) resultElement[3], (String) resultElement[4],
						(Date) resultElement[0], 0, 0, 0));
			}
		else if (orderByClause
				.equals(" GROUP BY YEAR(dateOperation), MONTH(dateOperation), typeOperation, caisse.restaurant.cite.libelle, caisse.restaurant.libelle")) {
			for (Object[] resultElement : result) {
				listtransaction.add(new TransactionVO(
						(String) resultElement[3], (Double) resultElement[4],
						(String) resultElement[5], (String) resultElement[6],
						(Date) resultElement[2], (Integer) resultElement[0],
						(Integer) resultElement[1], 0));
			}
		} else if (orderByClause
				.equals(" GROUP BY YEAR(dateOperation), typeOperation, caisse.restaurant.cite.libelle, caisse.restaurant.libelle")) {
			for (Object[] resultElement : result) {
				listtransaction.add(new TransactionVO(
						(String) resultElement[2], (Double) resultElement[3],
						(String) resultElement[4], (String) resultElement[5],
						(Date) resultElement[1], (Integer) resultElement[0], 0,
						0));
			}

		} else {
			for (Object[] resultElement : result) {
				listtransaction.add(new TransactionVO(
						(String) resultElement[3], (Double) resultElement[4],
						(String) resultElement[5], (String) resultElement[6],
						(Date) resultElement[2], (Integer) resultElement[0], 0,
						(Integer) resultElement[1]));
			}
		}

		return listtransaction;
	}

}
