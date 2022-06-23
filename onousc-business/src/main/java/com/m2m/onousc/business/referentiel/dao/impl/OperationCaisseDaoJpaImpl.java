package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m2m.onousc.business.referentiel.criteria.OperCaisseCriteria;
import com.m2m.onousc.business.referentiel.criteria.OperationCaisseCriteria;
import com.m2m.onousc.business.referentiel.dao.OperationCaisseDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.OperationCaisse;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

@Repository("operationCaisseDao")
public class OperationCaisseDaoJpaImpl extends
		GenericDaoJpaImpl<OperationCaisse, Long> implements
		OperationCaisseDaoJpa {

	/*@Override
	public List<OperationCaisse> findByCriteria(OperationCaisseCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getLibcaisse(),
				criteria.getLibresto(), criteria.getDateOperation(),
				criteria.getCodeetu(), criteria.getLibcite(),
				criteria.getCaissiercode(), criteria.getType() };
		String queryString = Queries.FIND_TRANSACTION_BY_CRITERIA;
		//String orderByClause = " GROUP BY x.caisse.restaurant.libelle";
		String orderByClause="";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	*/
	
	@Override
	public List<OperationCaisse> findByCriteria(OperCaisseCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getDateDebut(),criteria.getDateFin(),
				criteria.getMatricule(),criteria.getTypeOperation(), criteria.getIdcaisse(), criteria.getIdSite()};
		String queryString = Queries.FIND_TRANSACTION_BY_CRITER;
		//String orderByClause = " GROUP BY x.caisse.restaurant.libelle";
//		String orderByClause=" ORDER  BY x.dateOperation";
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";	
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}
	
	
	
	
	@Override
	public List<OperationCaisse> findByCodeCaisse(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_OPERATION_CAISSE_BY_CODE_CAISSE;
		return executeQuery(queryString, parameters);
	}

	@Override
	@Transactional
	public void persisthisto(String matricule, Float montant, Float solde) {
		OperationCaisse oper=new OperationCaisse();
		//oper.setId(10002L);
		oper.setDateOperation(new Date());
		oper.setMatricule(matricule);
		oper.setMontant(solde.doubleValue()+montant.doubleValue());
		oper.setSolde(montant.doubleValue());
		oper.setTypeOperation("R");
		getEm().merge(oper);
	}

	@Override
	@Transactional
	public void persisthistoDecharge(String matricule, Float montant,
			Float solde) {
		OperationCaisse oper=new OperationCaisse();
		//oper.setId(10002L);
		oper.setDateOperation(new Date());
		oper.setMatricule(matricule);
		oper.setMontant(montant.doubleValue());
		oper.setSolde(solde.doubleValue()-montant.doubleValue());
		oper.setTypeOperation("V");
		getEm().persist(oper);
		
	}




	@Override
	public double findSoldeByMatricule(String matr) {
		Object[] parameters = new Object[] { matr };
		String queryString = Queries.FIND_SOLDE_BY_MATR;
		List<OperationCaisse> caisse = null;
		caisse= executeQuery(queryString,0,1, parameters);
		if(caisse != null && caisse.size()>0){
			if(caisse.get(0).getTypeOperation().equals("R"))
			return caisse.get(0).getMontant();
			else if(caisse.get(0).getTypeOperation().equals("V")) 
			return caisse.get(0).getMontant()-caisse.get(0).getSolde();
			else 
			return caisse.get(0).getMontant()+caisse.get(0).getSolde();

		} else {
			return 0L;
		}
		
	}

}
