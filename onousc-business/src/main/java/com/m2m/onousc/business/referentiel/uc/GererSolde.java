package com.m2m.onousc.business.referentiel.uc;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2m.onousc.business.referentiel.dao.OperationCaisseDaoJpa;
import com.m2m.onousc.business.referentiel.dao.SoldeDaoJpa;
import com.m2m.onousc.business.referentiel.model.OperationCaisse;
import com.m2m.onousc.business.referentiel.model.Solde;
import com.m2m.onousc.business.referentiel.rule.CanalVenteBusinessRuleManager;
import com.m2m.technicalservices.core.IBusinessRuleManager;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.core.UseCaseController;
import com.m2m.technicalservices.core.UserContext;

@Service("REFERENTIEL_GererSolde_UC")
public class GererSolde extends UseCaseController{

	@Autowired
	private SoldeDaoJpa soldeDaoJpa;

	@Autowired
	private OperationCaisseDaoJpa operationCaisseDaoJpa;

	@Override
	protected IBusinessRuleManager getBusinessRuleManager() {
		return new CanalVenteBusinessRuleManager();
	}

	@Override
	protected ProcessResult business() {
		// carte
					Solde sub = (Solde) UserContext.getSubject();

				 
					UserContext.setSubject(sub);

					 OperationCaisse operation = new OperationCaisse();
					 operation.setDateOperation(new Date());
					 operation.setMatricule(sub.getMatr());
					 operation.setMontant(Double.valueOf(sub.getInit()));
					 operation.setSite(sub.getSite());
					 operation.setTypeOperation("R");
					 
					soldeDaoJpa.getEm().merge(sub);
					operationCaisseDaoJpa.persist(operation);
		return null;
	}


}
 
 