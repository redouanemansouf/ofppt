package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m2m.onousc.business.referentiel.criteria.ConsultCaisseCriteria;
import com.m2m.onousc.business.referentiel.dao.ConsultCaisseDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.ConsultCaisse;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

@Repository("consultCaisseDao")
public class ConsultCaisseDaoJpaImpl extends
		GenericDaoJpaImpl<ConsultCaisse, Long> implements
		ConsultCaisseDaoJpa {

	
	@Override
	public List<ConsultCaisse> findByCriteria(ConsultCaisseCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getDateDebut(),criteria.getDateFin(),
				criteria.getMatricule(),criteria.getTypeOperation(), criteria.getIdcaisse()};
		String queryString = Queries.FIND_TRANSACTIONC_BY_CRITER;
		//String orderByClause = " GROUP BY x.caisse.restaurant.libelle";
		String orderByClause=" ORDER  BY x.dateOperation";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}
	

	@Override
	public List<ConsultCaisse> findByCodeCaisse(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_OPERATION_CAISSE_BY_CODE_CAISSE;
		return executeQuery(queryString, parameters);
	}


}
