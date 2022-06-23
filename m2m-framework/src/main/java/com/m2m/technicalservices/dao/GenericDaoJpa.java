package com.m2m.technicalservices.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;

import com.m2m.technicalservices.web.SearchConfig;

/**
 * Generic interface for a JPA persistence service
 * <p>
 * All exceptions are RuntimeException (@see
 * org.springframework.dao.DataAccessException)
 * 
 * @author Younes SOUTEH.com
 * 
 * @param <T,PK> Table and primary key
 */
public interface GenericDaoJpa<T, PK> {

	/**
	 * For all queries executed by this class, it is assumed that the desired
	 * first row in the returned results is the actual first row returned by the
	 * database. In methods that allow for the first row to be set, if null or a
	 * negative number is passed, then this default value is used.
	 */
	public static final int DEFAULT_FIRST_RESULT_INDEX = 0;

	/**
	 * This is the default value used for initially determining the maximum
	 * number of rows returned in result sets for methods in this class where
	 * the maximum number of results is not passed as a parameter.
	 * 
	 * @see getDefaultMaxResults()
	 */
	public static final int DEFAULT_MAX_RESULTS = 8000;

	/**
	 * Set the default number of results to be returned by this class for all
	 * methods that do not specify maxResults as a parameter. If you set this
	 * value to null or to a number <= 0, then the result sets will never be
	 * constrained and a massive result set may be returned.
	 * 
	 * @see getDefaultMaxResults()
	 * 
	 * @param defaultMaxResults
	 */
	public void setDefaultMaxResults(int defaultMaxResults);

	/**
	 * For all methods in this class where no maximum number of rows is
	 * specified, this is the default maximum number of rows that will be
	 * returned as a result. In methods that allow you to pass a maxResults,
	 * this value is ignored. Passing null or a number <= 0 to such methods will
	 * result in no constraints against the maximum rows returned and a massive
	 * result set may be returned.
	 * 
	 * @see DEFAULT_MAX_RESULTS
	 */
	public int getDefaultMaxResults();

	/**
	 * Synchronise entityManager objects in database
	 * 
	 * @throws DataAccessException
	 */
	public void flush();

	/**
	 * Refresh persistent object
	 * 
	 * @param o
	 * @throws DataAccessException
	 */
	public void refresh(T o);

	/**
	 * persist an object in database
	 * 
	 * @param o
	 *            the persistent object to be persisted
	 * @throws DataAccessException
	 */
	public void persist(T o);

	/**
	 * Remove an object from database
	 * 
	 * @param o
	 *            the persistent object to be removed
	 * @throws DataAccessException
	 */
	public void remove(T o);

	/**
	 * load a persistent object with specified id, return null if it does not
	 * exist
	 * 
	 * @param id
	 *            the persistent object id
	 * @return T the persistent object found in database
	 * @throws DataAccessException
	 */
	public T find(PK id);

	/**
	 * load a persistent object with specified id, throw an exception if it does
	 * not exist
	 * 
	 * @param id
	 *            the persistent object id
	 * @return T the persistent object found in database
	 * @throws DataAccessException
	 */
	public T getReference(PK id);

	/**
	 * load all persistent objects specified by DAO component
	 * 
	 * @return List list of persistent objects
	 * @throws DataAccessException
	 */
	public List<T> findAll();
	
	public List<T> findAllByOrder(String orderClause);

	/**
	 * Execute the {@link java.persistence.NamedQuery} with the specified name
	 * and get back a single {@link java.persistence.Entity}. This assumes that
	 * no parameters are needed for execution of the named query.
	 * 
	 * @param <T>
	 *            the type for the {@link java.persistence.Entity} to be
	 *            returned
	 * @param queryName
	 *            the name of the query to execute
	 * @return the {@link java.persistence.Entity}
	 */
	public T executeQueryByNameSingleResult(String queryName);

	/**
	 * Execute the {@link java.persistence.NamedQuery} with the specified name,
	 * passing the specified parameters, and get back the single
	 * {@link java.persistence.Entity} result.
	 * 
	 * @param <T>
	 *            the type for the {@link java.persistence.Entity} to be
	 *            returned
	 * @param queryName
	 *            the name of the query to execute
	 * @param parameters
	 *            the parameters bound into the query to be executed
	 * @return the {@link java.persistence.Entity}
	 */
	public T executeQueryByNameSingleResult(String queryName,
			Object... parameters);

	/**
	 * Execute the {@link java.persistence.NamedQuery} with the specified name
	 * and get back a {@link List} of {@link java.persistence.Entity}. This
	 * assumes that no parameters are needed for execution of the named query.
	 * 
	 * @see DEFAULT_FIRST_RESULT_INDEX
	 * @see getDefaultMaxResults()
	 * 
	 * @param <T>
	 *            the type for the {@link java.persistence.Entity} to be
	 *            returned
	 * @param queryName
	 *            the name of the query to execute
	 * @return the {@link List} of {@link java.persistence.Entity} that result
	 */
	public List<T> executeQueryByName(String queryName);

	/**
	 * Execute the {@link java.persistence.NamedQuery} with the specified name
	 * and get back a {@link List} of {@link java.persistence.Entity}. This
	 * assumes that no parameters are needed for execution of the named query.
	 * 
	 * @see DEFAULT_FIRST_RESULT_INDEX
	 * @see getDefaultMaxResults()
	 * 
	 * @param <T>
	 *            the type for the {@link java.persistence.Entity} to be
	 *            returned
	 * @param queryName
	 *            the name of the query to execute
	 * @param firstResult
	 *            the first row to be returned
	 * @param maxResults
	 *            the maximum number of rows to be returned
	 * @return the {@link List} of {@link java.persistence.Entity} that result
	 */
	public List<T> executeQueryByName(String queryName, Integer firstResult,
			Integer maxResults);

	/**
	 * Execute the {@link java.persistence.NamedQuery} with the specified name,
	 * passing the specified parameters, and get back a {@link List} of
	 * {@link java.persistence.Entity}.
	 * 
	 * @see DEFAULT_FIRST_RESULT_INDEX
	 * @see getDefaultMaxResults()
	 * 
	 * @param <T>
	 *            the type for the {@link java.persistence.Entity} to be
	 *            returned
	 * @param queryName
	 *            the name of the query to execute
	 * @param parameters
	 *            the parameters bound into the query to be executed
	 * @return the {@link List} of {@link java.persistence.Entity} that result
	 */
	public List<T> executeQueryByName(String queryName, Object... parameters);

	/**
	 * Execute the {@link java.persistence.NamedQuery} with the specified name,
	 * passing the specified parameters, and get back a {@link List} of
	 * {@link java.persistence.Entity}.
	 * 
	 * @see DEFAULT_FIRST_RESULT_INDEX
	 * @see getDefaultMaxResults()
	 * 
	 * @param <T>
	 *            the type for the {@link java.persistence.Entity} to be
	 *            returned
	 * @param queryName
	 *            the name of the query to execute
	 * @param firstResult
	 *            the first row to be returned
	 * @param maxResults
	 *            the maximum number of rows to be returned
	 * @param parameters
	 *            the parameters bound into the query to be executed
	 * @return the {@link List} of {@link java.persistence.Entity} that result
	 */
	public List<T> executeQueryByName(String queryName, Integer firstResult,
			Integer maxResults, Object... parameters);

	/**
	 * Execute the passed JPQL query and get back a single
	 * {@link java.persistence.Entity}. This assumes that no parameters are
	 * needed for execution of the query.
	 * 
	 * @param <T>
	 *            the type for the {@link java.persistence.Entity} to be
	 *            returned
	 * @param queryString
	 *            the JPQL query
	 * @return the {@link java.persistence.Entity}
	 */
	public Object executeQuerySingleResult(String queryString);

	/**
	 * Execute the passed JPQL query, passing the specified parameters, and get
	 * back the single {@link java.persistence.Entity} result.
	 * 
	 * @param <T>
	 *            the type for the {@link java.persistence.Entity} to be
	 *            returned
	 * @param queryString
	 *            the JPQL query
	 * @param parameters
	 *            the parameters bound into the query to be executed
	 * @return the {@link java.persistence.Entity}
	 */
	public T executeQuerySingleResult(String queryString, Object... parameters);

	/**
	 * Execute the passed JPQL query and get back a {@link List} of
	 * {@link java.persistence.Entity}. This assumes that no parameters are
	 * needed for execution of the query.
	 * 
	 * @see DEFAULT_FIRST_RESULT_INDEX
	 * @see getDefaultMaxResults()
	 * 
	 * @param <T>
	 *            the type for the {@link java.persistence.Entity} to be
	 *            returned
	 * @param queryString
	 *            the JPQL query
	 * @param parameters
	 *            the parameters bound into the query to be executed
	 * @return the {@link List} of {@link java.persistence.Entity}
	 */
	public List<T> executeQuery(String queryString, Object... parameters);

	/**
	 * Execute the passed JPQL query and get back a {@link List} of
	 * {@link java.persistence.Entity}. This assumes that no parameters are
	 * needed for execution of the query.
	 * 
	 * @see DEFAULT_FIRST_RESULT_INDEX
	 * @see getDefaultMaxResults()
	 * 
	 * @param <T>
	 *            the type for the {@link java.persistence.Entity} to be
	 *            returned
	 * @param queryString
	 *            the JPQL query
	 * @param firstResult
	 *            the first row to be returned
	 * @param maxResults
	 *            the maximum number of rows to be returned
	 * @param parameters
	 *            the parameters bound into the query to be executed
	 * @return the {@link List} of {@link java.persistence.Entity}
	 */
	public List<T> executeQuery(String queryString, Integer firstResult,
			Integer maxResults, Object... parameters);

	/**
	 * Creates a {@link Query} for the specified
	 * {@link java.persistence.NamedQuery} and sets up the result handling for
	 * that query to start with the specified first row and contain a maximum
	 * number of results. This assumes that no parameters are needed for
	 * execution of the named query.
	 * 
	 * @see DEFAULT_FIRST_RESULT_INDEX
	 * @see getDefaultMaxResults()
	 * 
	 * @param queryName
	 *            the name of the query to create
	 * @param firstResult
	 *            the first row to be returned
	 * @param maxResults
	 *            the maximum number of rows to be returned
	 * @return the {@link Query}
	 */
	public Query createNamedQuery(String queryName, Integer firstResult,
			Integer maxResults);

	/**
	 * Creates a {@link Query} for the specified
	 * {@link java.persistence.NamedQuery} with the passed parameters bound and
	 * sets up the result handling for that query to start with the specified
	 * first row and contain a maximum number of results.
	 * 
	 * @param queryName
	 *            the name of the query to create
	 * @param firstResult
	 *            the first row to be returned
	 * @param maxResults
	 *            the maximum number of rows to be returned
	 * @param parameters
	 *            the parameters bound into the query
	 * @return the {@link Query}
	 */
	public Query createNamedQuery(String queryName, Integer firstResult,
			Integer maxResults, Object... parameters);

	/**
	 * Creates a query that will return a single result by default
	 * 
	 * @param queryString
	 * @param parameters
	 * @return
	 */
	public Query createQuerySingleResult(String queryString,
			Object... parameters);

	/**
	 * Creates a {@link Query} for the passed JPQL string and sets up the result
	 * handling for that query to start with the specified first row and contain
	 * a maximum number of results. This assumes that no parameters are needed
	 * for execution of the named query.
	 * 
	 * @param queryString
	 *            the JPQL string used to create the {@link Query}
	 * @param firstResult
	 *            the first row to be returned
	 * @param maxResults
	 *            the maximum number of rows to be returned
	 * @return the {@link Query}
	 */
	public Query createQuery(String queryString, Integer firstResult,
			Integer maxResults);

	/**
	 * Creates a {@link Query} for the passed JPQL string with the passed
	 * parameters bound and sets up the result handling for that query to start
	 * with the specified first row and contain a maximum number of results.
	 * 
	 * @param queryString
	 *            the JPQL string used to create the {@link Query}
	 * @param firstResult
	 *            the first row to be returned
	 * @param maxResults
	 *            the maximum number of rows to be returned
	 * @param parameters
	 *            the parameters bound into the query
	 * @return the {@link Query}
	 */
	public Query createQuery(String queryString, Integer firstResult,
			Integer maxResults, Object... parameters);

	/**
	 * Each DAO can decide whether the object passed can be merged using the
	 * .merge() method Generally speaking, Objects whos primary keys are auto
	 * generated must be passed to the persist method in order to have their
	 * primary keys fields filled in.
	 * 
	 * @param o
	 * @return
	 */
	public void clear();

	/**
	 * search by criteria
	 * 
	 * @param queryString
	 * @param parameters
	 * @param config
	 * @return
	 */
	List<T> findByCriteria(String queryString, SearchConfig config,
			Object... parameters);

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
	public List<T> findByCriteria(String queryString, Boolean distinct,
			String orderByClause, SearchConfig config, Object... parameters);

	public EntityManager getEm();

	public void setEm(EntityManager em);

}
