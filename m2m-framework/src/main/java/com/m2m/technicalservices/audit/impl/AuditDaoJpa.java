package com.m2m.technicalservices.audit.impl;

import java.util.List;

import javassist.NotFoundException;

import org.springframework.dao.DataAccessException;

import com.m2m.technicalservices.dao.GenericDaoJpa;
import com.m2m.technicalservices.exception.TechnicalException;

/**
 * Trace management DAO interface
 * 
 * @author Younes SOUTEH
 */
public interface AuditDaoJpa extends GenericDaoJpa<TraceEntity, Integer> {

	/**
	 * Delete Trace with provided id (can't be a generic method because the
	 * primary key is not necessary an Integer)
	 * 
	 * @param idTrace
	 *            trace id to be removed
	 * @return void
	 * @throws DataAccessException
	 */
	public void insert(TraceEntity traceEntity);

	/**
	 * Find trace with provided id_object.
	 * 
	 * @return the list of trace found
	 * @throws NotFoundException
	 * @throws DataAccessException
	 * @throws TechnicalException
	 */
	public List<TraceEntity> findByIdObject(String idObject);

}