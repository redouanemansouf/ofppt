package com.m2m.onousc.business.statistique.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.OperationCaisseCriteria;
import com.m2m.onousc.business.referentiel.criteria.StatistiqueCriteria;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.statistique.dao.StatistiqueDaoJpa;
import com.m2m.onousc.business.statistique.vo.StatistiqueJourVO;
import com.m2m.onousc.business.statistique.vo.TransactionVO;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;
import com.m2m.technicalservices.web.SearchConfig;

@Repository("statistiqueDao")
public class StatistiqueDaoJpaImpl extends
		GenericDaoJpaImpl<StatistiqueJourVO, Long> implements StatistiqueDaoJpa {

	@Override
	public List<StatistiqueJourVO> findNbreReservationByCriteria(
			StatistiqueCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getDateDebut(),
				criteria.getDateFin(), criteria.getLibrestaurant(),
				criteria.getLibcite() };
		String queryString = Queries.FIND_STATISTIQUE_BY_JOUR;
		String orderByClause = " GROUP BY dateOperation, restaurant.cite.libelle, restaurant.libelle ORDER BY dateOperation";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<StatistiqueJourVO> findNbreConsommationByCriteria(
			StatistiqueCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getDateDebut(),
				criteria.getDateFin(), criteria.getLibrestaurant(),
				criteria.getLibcite() };
		String queryString = Queries.FIND_STATISTIQUE_BY_JOUR_2;
		String orderByClause = " GROUP BY r.dateService, r.reservation.restaurant.cite.libelle, r.reservation.restaurant.libelle ORDER BY r.dateService, SUM(t.tarif)";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<StatistiqueJourVO> findByCriteria(String queryString,
			String orderByClause, SearchConfig config, Object... parameters) {
		List<StatistiqueJourVO> liststatistiques = new ArrayList<StatistiqueJourVO>();
		Query query = createQuery(queryString + " " + orderByClause, null,
				null, parameters);
		@SuppressWarnings("unchecked")
		List<Object[]> result = query.getResultList();
		if (orderByClause
				.equals(" GROUP BY dateOperation, restaurant.cite.libelle, restaurant.libelle ORDER BY dateOperation"))
			for (Object[] resultElement : result) {
				liststatistiques.add(new StatistiqueJourVO(
						(Date) resultElement[0], (Long) resultElement[1],
						new Long(0), 0.0, 0, 0, 0, (String) resultElement[2],
						(String) resultElement[3]));
			}
		else if (orderByClause
				.equals(" GROUP BY r.dateService, r.reservation.restaurant.cite.libelle, r.reservation.restaurant.libelle ORDER BY r.dateService, SUM(t.tarif)")) {
			for (Object[] resultElement : result) {
				liststatistiques.add(new StatistiqueJourVO(
						(Date) resultElement[0], new Long(0),
						(Long) resultElement[1], (Double) resultElement[2], 0,
						0, 0, (String) resultElement[3],
						(String) resultElement[4]));
			}
		} else if (orderByClause
				.equals(" GROUP BY YEAR(r.dateService),MONTH(r.dateService), r.reservation.restaurant.cite.libelle, r.reservation.restaurant.libelle ORDER BY r.dateService, SUM(t.tarif)")) {
			for (Object[] resultElement : result) {
				liststatistiques
						.add(new StatistiqueJourVO((Date) resultElement[2],
								new Long(0), (Long) resultElement[3],
								(Double) resultElement[4],
								(Integer) resultElement[0],
								(Integer) resultElement[1], 0,
								(String) resultElement[5],
								(String) resultElement[6]));
			}
		} else if (orderByClause
				.equals(" GROUP BY YEAR(r.dateService), r.reservation.restaurant.cite.libelle, r.reservation.restaurant.libelle ORDER BY r.dateService, SUM(t.tarif)")) {
			for (Object[] resultElement : result) {
				liststatistiques.add(new StatistiqueJourVO(
						(Date) resultElement[1], new Long(0),
						(Long) resultElement[2], (Double) resultElement[3],
						(Integer) resultElement[0], 0, 0,
						(String) resultElement[4], (String) resultElement[5]));
			}
		} else {
			for (Object[] resultElement : result) {
				liststatistiques.add(new StatistiqueJourVO(
						(Date) resultElement[2], new Long(0),
						(Long) resultElement[3], (Double) resultElement[4],
						(Integer) resultElement[0], 0,
						(Integer) resultElement[1], (String) resultElement[5],
						(String) resultElement[6]));
			}
		}

		return liststatistiques;
	}

	public List<TransactionVO> findTrByCriteria(String queryString,
			String orderByClause, SearchConfig config, Object... parameters) {
		List<TransactionVO> listtrans = new ArrayList<TransactionVO>();
		Query query = createQuery(queryString + " " + orderByClause, null,
				null, parameters);
		List<Object[]> result = query.getResultList();
		// for (Object[] resultElement : result) {
		// listtrans.add(new TransactionVO((String) resultElement[0],
		// (Double) resultElement[1], (String) resultElement[2]));
		// }

		return listtrans;
	}

	@Override
	public List<StatistiqueJourVO> findStatistiqueByMounth(
			StatistiqueCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getDateDebut(),
				criteria.getDateFin(), criteria.getLibrestaurant(),
				criteria.getLibcite() };
		String queryString = Queries.FIND_STATISTIQUE_BY_MOIS;
		String orderByClause = " GROUP BY YEAR(r.dateService),MONTH(r.dateService), r.reservation.restaurant.cite.libelle, r.reservation.restaurant.libelle ORDER BY r.dateService, SUM(t.tarif)";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<StatistiqueJourVO> findStatistiqueByYear(
			StatistiqueCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getDateDebut(),
				criteria.getDateFin(), criteria.getLibrestaurant(),
				criteria.getLibcite() };
		String queryString = Queries.FIND_STATISTIQUE_BY_ANNEE;
		String orderByClause = " GROUP BY YEAR(r.dateService), r.reservation.restaurant.cite.libelle, r.reservation.restaurant.libelle ORDER BY r.dateService, SUM(t.tarif)";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<StatistiqueJourVO> findStatistiqueByWeek(
			StatistiqueCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getDateDebut(),
				criteria.getDateFin(), criteria.getLibrestaurant(),
				criteria.getLibcite() };
		String queryString = Queries.FIND_STATISTIQUE_BY_WEEK;
		String orderByClause = " GROUP BY YEAR(r.dateService),WEEKOFYEAR(r.dateService), r.reservation.restaurant.cite.libelle, r.reservation.restaurant.libelle ORDER BY r.dateService, SUM(t.tarif)";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public Long findNbreJourConsommation() {
		String queryString = Queries.FIND_NBR_JOUR_CONSOMMATION;
		Query query = createQuery(queryString, null, null, null);
		Object result = query.getSingleResult();
		return (Long) result;
	}

	@Override
	public List<TransactionVO> findTotalTransaction(
			OperationCaisseCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getLibcaisse(),
				criteria.getLibresto(), criteria.getDateOperation(),
				criteria.getCodeetu(), criteria.getType() };
		String queryString = Queries.FIND_TOTALE_TRANSACTION;
		String orderByClause = " GROUP BY x.typeOperation";
		return findTrByCriteria(queryString, orderByClause, null, parameters);

	}
}
