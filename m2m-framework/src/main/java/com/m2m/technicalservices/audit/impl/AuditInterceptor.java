package com.m2m.technicalservices.audit.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.m2m.technicalservices.core.UserContext;
import com.m2m.technicalservices.log.ILogger;
import com.m2m.technicalservices.log.impl.SL4JLogger;
import com.m2m.technicalservices.spring.BeansLookuper;

public class AuditInterceptor extends EmptyInterceptor implements
		InitializingBean, DisposableBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6783285088618553303L;

	private static final ILogger LOGGER = SL4JLogger
			.getInstance(AuditInterceptor.class);

	private AuditDaoJpa dao;

	private Set<TraceEntity> requests = new HashSet<TraceEntity>();

	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) throws CallbackException {

		LOGGER.info("onSave");

		if (entity instanceof ITracable) {
			String userID = UserContext.getClientParameters().getUser()
					.getCode();
			TraceEntity traceEntity = getTraceEntity(AuditAction.CREATE,
					((ITracable) entity).getId(),
					((ITracable) entity).getTraceInfo(),
					((ITracable) entity).getNameEntity(), null, userID);
			requests.add(traceEntity);
		}
		return false;
	}

	public boolean onFlushDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) throws CallbackException {

		LOGGER.info("onFlushDirty");

		if (entity instanceof ITracable) {
			String tracableafter = null;
			String userID = UserContext.getClientParameters().getUser()
					.getCode();
			TraceEntity traceEntity = getTraceEntity(AuditAction.UPDATE,
					((ITracable) entity).getId(),
					((ITracable) entity).getTraceInfo(),
					((ITracable) entity).getNameEntity(), tracableafter, userID);
			requests.add(traceEntity);
		}
		return false;
	}

	public void onDelete(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {

		LOGGER.info("onDelete");

		if (entity instanceof ITracable) {
			String userID = UserContext.getClientParameters().getUser()
					.getCode();
			TraceEntity traceEntity = getTraceEntity(AuditAction.DELETE,
					((ITracable) entity).getId(),
					((ITracable) entity).getTraceInfo(),
					((ITracable) entity).getNameEntity(), null, userID);
			requests.add(traceEntity);
		}
	}

	/**
	 * called before commit into database
	 */
	@SuppressWarnings("rawtypes")
	public void preFlush(Iterator iterator) {
		LOGGER.info("preFlush");
	}

	/**
	 * called after committed into database
	 */
	public void beforeTransactionCompletion(Transaction tx) {

		dao = (AuditDaoJpa) BeansLookuper.lookup("auditDAO");

		LOGGER.info("beforeTransactionCompletion, postFlush");

		try {

			for (Iterator<TraceEntity> it = requests.iterator(); it.hasNext();) {
				TraceEntity traceEntity = it.next();
				LOGGER.info("beforeTransactionCompletion, postFlush - insert");
				dao.insert(traceEntity);
				dao.flush();
			}
		} catch (Exception e) {
			LOGGER.error("Error d'insertion de Trace", e);

		} finally {
			requests.clear();
		}
	}

	public AuditDaoJpa getDao() {
		return dao;
	}

	public void setDao(AuditDaoJpa dao) {
		this.dao = dao;
	}

	private static TraceEntity getTraceEntity(int action, Long id,
			String tracablebefore, String nameEntity, String tracableafter,
			String userID) {

		TraceEntity traceEntity = new TraceEntity();
		traceEntity.setAction(action);
		traceEntity.setId_Entity(id);
		traceEntity.setTraceInfoIn(tracablebefore);
		traceEntity.setTraceInfoOut(tracableafter);
		traceEntity.setUserID(userID);
		traceEntity.setActionWhen(new Date());
		traceEntity.setNameEntity(nameEntity);
		return traceEntity;
	}

	public void destroy() throws Exception {
		// Auto-generated method stub
	}

	public void afterPropertiesSet() throws Exception {
		// Auto-generated method stub
	}

}
