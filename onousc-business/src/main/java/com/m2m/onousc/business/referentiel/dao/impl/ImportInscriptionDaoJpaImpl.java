package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.ImportCriteria;
import com.m2m.onousc.business.referentiel.dao.ImportInscriptionDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.ImportInscription;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

@Repository("importInscriptionDaoJpa")
public class ImportInscriptionDaoJpaImpl extends GenericDaoJpaImpl<ImportInscription, Long>
		implements ImportInscriptionDaoJpa {

	@Override
	public List<ImportInscription> findByCriteria(ImportCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getCin(), criteria.getCodeMassar(), criteria.getUserName() };
		String queryString = Queries.FIND_IMPORT_INSCRIPTION_BY_CRITERIA;

		String orderByClause = criteria.getSortField() != null
				? " order by " + criteria.getSortField() + " " + criteria.getSortOrder()
				: "";
		return findByCriteria(queryString, orderByClause, criteria.getSearchConfig(), parameters);
	}

	@Override
	public ImportInscription findByCin(String cin) {
		ImportInscription imp = null;
		Object[] parameters = new Object[] { cin };
		String queryString = Queries.FIND_IMPORT_INSCRIPTION_BY_CIN;
		try {
			imp = executeQuerySingleResult(queryString, parameters);
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imp;
	}

	@Override
	public ImportInscription findByMassar(String codeMassar) {
		ImportInscription imp = null;
		Object[] parameters = new Object[] { codeMassar };
		String queryString = Queries.FIND_IMPORT_INSCRIPTION_BY_CODE_MASSAR;
		try {
			imp = executeQuerySingleResult(queryString, parameters);
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return imp;
	}
}