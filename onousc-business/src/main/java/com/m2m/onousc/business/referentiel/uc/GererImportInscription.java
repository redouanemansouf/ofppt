package com.m2m.onousc.business.referentiel.uc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2m.onousc.business.referentiel.dao.ImportInscriptionDaoJpa;
import com.m2m.onousc.business.referentiel.model.ImportInscription;
import com.m2m.onousc.business.referentiel.rule.ImportInscriptionBusinessRuleManager;
import com.m2m.technicalservices.core.IBusinessRuleManager;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.core.UseCaseController;
import com.m2m.technicalservices.core.UserContext;

@Service("REFERENTIEL_GererImportInscription_UC")
public class GererImportInscription extends UseCaseController {

	@Autowired
	ImportInscriptionDaoJpa importInscriptionDaoJpa;

	@Override
	protected IBusinessRuleManager getBusinessRuleManager() {
		return new ImportInscriptionBusinessRuleManager();
	}

	@Override
	protected ProcessResult business() {
		ProcessResult processResult = new ProcessResult();

		if (UserContext.getClientParameters().isOnCollection()) {
			@SuppressWarnings("unchecked")
			List<ImportInscription> models = (List<ImportInscription>) UserContext.getSubject();

			for (ImportInscription imp : models) {
				ImportInscription importInscription = importInscriptionDaoJpa.findByCin(imp.getCin());
				if (importInscription != null) {
					this.em.remove(importInscription);
				}
			}
		}

		return processResult;
	}

}
