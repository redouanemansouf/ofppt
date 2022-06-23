package com.m2m.technicalservices.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.m2m.technicalservices.dao.GenericDaoJpa;
import com.m2m.technicalservices.web.SearchConfig;

/**
 * Generic DAO JPA implementation. An EntityManager is injected by Spring
 * container. A transaction should be started by container before calling these
 * DAO services.
 * 
 * @author Younes SOUTEH
 * @param <T,PK> Table and primary key
 */
@Repository
public abstract class GenericDaoJpaImpl<T, PK> implements GenericDaoJpa<T, PK> {

	private int defaultMaxResults = DEFAULT_MAX_RESULTS;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	protected Class<T> type = null;

	@PersistenceContext
	protected EntityManager em;

	/**
	 * Empty constructor. The real type T is found with generic reflection
	 */
	protected GenericDaoJpaImpl() {
		this.type = this.getParameterizedType(this.getClass());
	}

	public void clear() {
		em.clear();
	}

	/**
	 * Generic reflection. Find and set generic type used
	 */
	private Class<T> getParameterizedType(Class clazz) {
		Class<T> specificType = null;
		ParameterizedType parameterizedType = (ParameterizedType) clazz
				.getGenericSuperclass();
		specificType = (Class<T>) parameterizedType.getActualTypeArguments()[0];
		return specificType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.skyway.spring.util.dao.JpaDao#setDefaultMaxResults(int)
	 */

	public void setDefaultMaxResults(int defaultMaxResults) {
		this.defaultMaxResults = defaultMaxResults;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.skyway.spring.util.dao.JpaDao#getDefaultMaxResults()
	 */

	public int getDefaultMaxResults() {
		return defaultMaxResults;
	}

	public void flush() {
		em.flush();
	}

	public void persist(T o) {
		em.persist(o);
	}

	public void remove(T o) {
		em.remove(o);
	}

	public void refresh(T o) {
		em.refresh(o);
	}

	public T find(PK primaryKey) {
		return em.find(type, primaryKey);
	}

	public T getReference(PK primaryKey) {
		return em.getReference(type, primaryKey);
	}

	public List<T> findAll() {
		return em.createQuery("SELECT x FROM " + type.getSimpleName() + " x")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	protected List<T> getEntityList(String queryString) {
		Query query = em.createQuery(queryString);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	protected T getSingleEntity(String queryString) {
		Query query = em.createQuery(queryString);
		return (T) query.getSingleResult();
	}

	// finder

	public T executeQueryByNameSingleResult(String queryName) {
		return (T) executeQueryByNameSingleResult(queryName, (Object[]) null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.skyway.spring.util.dao.JpaDao#executeQueryByNameSingleResult(java
	 * .lang.String, java.lang.Object[])
	 */

	@SuppressWarnings("unchecked")
	public T executeQueryByNameSingleResult(String queryName,
			Object... parameters) {
		Query query = createNamedQuery(queryName, DEFAULT_FIRST_RESULT_INDEX,
				1, parameters);
		return (T) query.getSingleResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.skyway.spring.util.dao.JpaDao#executeQueryByName(java.lang.String)
	 */

	public List<T> executeQueryByName(String queryName) {
		return executeQueryByName(queryName, DEFAULT_FIRST_RESULT_INDEX,
				getDefaultMaxResults());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.skyway.spring.util.dao.JpaDao#executeQueryByName(java.lang.String,
	 * java.lang.Integer, java.lang.Integer)
	 */

	public List<T> executeQueryByName(String queryName, Integer firstResult,
			Integer maxResults) {
		return executeQueryByName(queryName, firstResult, maxResults,
				(Object[]) null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.skyway.spring.util.dao.JpaDao#executeQueryByName(java.lang.String,
	 * java.lang.Object[])
	 */

	public List<T> executeQueryByName(String queryName, Object... parameters) {
		return executeQueryByName(queryName, DEFAULT_FIRST_RESULT_INDEX,
				getDefaultMaxResults(), parameters);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.skyway.spring.util.dao.JpaDao#executeQueryByName(java.lang.String,
	 * java.lang.Integer, java.lang.Integer, java.lang.Object[])
	 */

	public List<T> executeQueryByName(String queryName, Integer firstResult,
			Integer maxResults, Object... parameters) {
		Query query = createNamedQuery(queryName, firstResult, maxResults,
				parameters);
		return query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.skyway.spring.util.dao.JpaDao#createNamedQuery(java.lang.String,
	 * java.lang.Integer, java.lang.Integer)
	 */

	public Query createNamedQuery(String queryName, Integer firstResult,
			Integer maxResults) {
		return createNamedQuery(queryName, firstResult, maxResults,
				(Object[]) null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.skyway.spring.util.dao.JpaDao#createNamedQuery(java.lang.String,
	 * java.lang.Integer, java.lang.Integer, java.lang.Object[])
	 */

	public Query createNamedQuery(String queryName, Integer firstResult,
			Integer maxResults, Object... parameters) {
		Query query = em.createNamedQuery(queryName);
		if (parameters != null) {
			for (int i = 0; i < parameters.length; i++) {
				query.setParameter(i + 1, parameters[i]);
			}
		}

		query.setFirstResult(firstResult == null || firstResult < 0 ? DEFAULT_FIRST_RESULT_INDEX
				: firstResult);
		if (maxResults != null && maxResults > 0) {
			query.setMaxResults(maxResults);
		}

		return query;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.skyway.spring.util.dao.JpaDao#executeQuery(java.lang.String,
	 * java.lang.Integer, java.lang.Integer, java.lang.Object[])
	 */

	@SuppressWarnings("unchecked")
	public List<T> executeQuery(String queryString, Integer firstResult,
			Integer maxResults, Object... parameters) {
		Query query = createQuery(queryString, firstResult, maxResults,
				parameters);
		return query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.skyway.spring.util.dao.JpaDao#executeQuery(java.lang.String,
	 * java.lang.Object[])
	 */

	@SuppressWarnings("unchecked")
	public List<T> executeQuery(String queryString, Object... parameters) {
		Query query = createQuery(queryString, DEFAULT_FIRST_RESULT_INDEX,
				getDefaultMaxResults(), parameters);
		return query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.skyway.spring.util.dao.JpaDao#executeQuerySingleResult(java.lang.
	 * String)
	 */

	@SuppressWarnings("unchecked")
	public Object executeQuerySingleResult(String queryString) {
		return executeQuerySingleResult(queryString, (Object[]) null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.skyway.spring.util.dao.JpaDao#executeQuerySingleResult(java.lang.
	 * String, java.lang.Object[])
	 */

	@SuppressWarnings("unchecked")
	public T executeQuerySingleResult(String queryString, Object... parameters) {
		Query query = createQuerySingleResult(queryString, parameters);
		return (T) query.getSingleResult();
	}

	/*  
	 * (non-Javadoc)
	 * 
	 * @see org.skyway.spring.util.dao.JpaDao#createQuery(java.lang.String,
	 * java.lang.Integer, java.lang.Integer)
	 */

	public Query createQuery(String queryString, Integer firstResult,
			Integer maxResults) {
		return createQuery(queryString, firstResult, maxResults,
				(Object[]) null);
	}

	/**
	 * Creates a query that will return a single result by default
	 * 
	 * @param queryString
	 * @param parameters
	 * @return
	 */
	public Query createQuerySingleResult(String queryString,
			Object... parameters) {
		return createQuery(queryString, DEFAULT_FIRST_RESULT_INDEX, 1,
				parameters);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.skyway.spring.util.dao.JpaDao#createQuery(java.lang.String,
	 * java.lang.Integer, java.lang.Integer, java.lang.Object[])
	 */

	public Query createQuery(String queryString, Integer firstResult,
			Integer maxResults, Object... parameters) {
		Query query = em.createQuery(queryString);
		if (parameters != null) {
			for (int i = 0; i < parameters.length; i++) {
				query.setParameter(i + 1, parameters[i]);
			}
		}

		query.setFirstResult(firstResult == null || firstResult < 0 ? DEFAULT_FIRST_RESULT_INDEX
				: firstResult);
		if (maxResults != null && maxResults > 0) {
			query.setMaxResults(maxResults);
		}

		return query;
	}

	public List<T> findByCriteria(String queryString, SearchConfig config,
			Object... parameters) {
		if (config.getRowCount() == null) {
			String countQueryString = "Select count(*) " + queryString;
			Query countQuery = createQuerySingleResult(countQueryString,
					parameters);
			long rowCount = (Long) countQuery.getSingleResult();
			config.setRowCount(rowCount);
		}

		Query query = createQuery("Select x " + queryString,
				config.getOffset(), config.getPageSize(), parameters);
		List<T> result = query.getResultList();
		return result;
	}

	/**
	 * findByCriteria avec orderBy
	 * 
	 * @author amtarji
	 * @param queryString
	 * @param orderByClause
	 * @param config
	 * @param parameters
	 * @return
	 */
	public List<T> findByCriteria(String queryString, String orderByClause,
			SearchConfig config, Object... parameters) {
		if (config.getRowCount() == null) {
			String countQueryString = "Select count(x) " + queryString;
			Query countQuery = createQuerySingleResult(countQueryString,
					parameters);
			long rowCount = (Long) countQuery.getSingleResult();
			config.setRowCount(rowCount);
		}
		Query query = createQuery("Select x " + queryString + " "
				+ orderByClause, config.getOffset(), config.getPageSize(),
				parameters);
		List<T> result = query.getResultList();
		return result;
	}

	/**
	 * find DISTINCT elements by criteria
	 * 
	 * @param queryString
	 * @param orderByClause
	 * @param config
	 * @param distinct
	 * @param parameters
	 * @return
	 */
	@Override
	public List<T> findByCriteria(String queryString, Boolean distinct,
			String orderByClause, SearchConfig config, Object... parameters) {
		if (config.getRowCount() == null) {
			String countQueryString = (distinct != null && distinct == true ? "Select count( DISTINCT x) "
					: "Select count(x)  ")
					+ queryString;
			Query countQuery = createQuerySingleResult(countQueryString,
					parameters);
			long rowCount = (Long) countQuery.getSingleResult();
			config.setRowCount(rowCount);
		}
		String selectQuery = (distinct != null && distinct == true ? "Select DISTINCT x "
				: "Select x  ")
				+ queryString + " " + orderByClause;
		Query query = createQuery(selectQuery, config.getOffset(),
				config.getPageSize(), parameters);
		List<T> result = query.getResultList();
		return result;
	}

	public List<T> findByCriteria(String countQueryString, String joinFetchQueryString, String orderByClause,
			SearchConfig config, Object... parameters) {
		if (config.getRowCount() == null) {
			String countQueryStatement = "Select count(x) " + countQueryString;
			Query countQuery = createQuerySingleResult(countQueryStatement,
					parameters);
			long rowCount = (Long) countQuery.getSingleResult();
			config.setRowCount(rowCount);
		}
		Query query = createQuery("Select x " + joinFetchQueryString + " "
				+ orderByClause, config.getOffset(), config.getPageSize(),
				parameters);
		List<T> result = query.getResultList();
		return result;
	}
	
	
	public List<T> findAllByOrder(String orderClause)
	{
		return em.createQuery("SELECT x FROM " + type.getSimpleName() + " x"+ " " + orderClause)
				.getResultList();
	}
	
}
