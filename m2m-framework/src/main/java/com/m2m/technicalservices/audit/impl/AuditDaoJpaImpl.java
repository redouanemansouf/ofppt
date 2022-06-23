package com.m2m.technicalservices.audit.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

/**
 * trace DAO implementation
 * 
 * @author Younes SOUTEH
 */
@Repository("auditDAO")
public class AuditDaoJpaImpl extends GenericDaoJpaImpl<TraceEntity, Integer>
		implements AuditDaoJpa {

	public List<TraceEntity> findByIdObject(String idObject) {
		String queryString = "select x from TraceEntity x where x.id_Entity ='"
				+ idObject + "'";
		return getEntityList(queryString);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void insert(TraceEntity traceEntity) {
		persist(traceEntity);
	}

}