package com.m2m.technicalservices.core;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.m2m.technicalservices.dao.impl.GenericEntity;

/**
 * Classe abstraite devant être implémenter par les Uses Case autres que Batchs
 * 
 * @author Younes SOUTEH
 * 
 */
public abstract class UseCaseController implements IUseCaseController {

	@PersistenceContext
	protected EntityManager em;

	public final ProcessResult process() {
		ProcessResult processResult = preProcess();
		if (processResult != null && processResult.isMsgError()) {
			rollback();
			return processResult;
		}

		processResult = executeLogic();
		if (processResult != null && processResult.isMsgError()) {
			rollback();
			return processResult;
		}
		fillVO();
		processResult.setData(UserContext.getSubject());
		return processResult;
	}

	private void rollback() {
		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	}

	/**
	 * 
	 * @return
	 */
	protected final ProcessResult preProcess() {
		ProcessResult processResult = doAuthorisation();
		if (processResult != null && processResult.isMsgError()) {
			return processResult;
		}

		processResult = this.doValidationUnitaireSimple();
		if (processResult != null && processResult.isMsgError()) {
			return processResult;
		}

		// Appel du converter
		processResult = this.doFormat();
		if (processResult != null && processResult.isMsgError()) {
			return processResult;
		}
		// Remplacer le Vo par l'objet issues apres formattage
		UserContext.setSubject(processResult.getData());
		// check condition
		processResult = this.doCheckPrecondition();

		if (processResult != null && processResult.isMsgError()) {
			return processResult;
		}
		return null;
	}

	/**
	 * 
	 * @return
	 */
	protected final ProcessResult executeLogic() {
		UserContext.setEm(em);
		final ProcessResult globalResult = new ProcessResult();

		ProcessResult processResult = this.doCheckConcurrentAccess();
		if (processResult != null && processResult.isMsgError()) {
			return processResult;
		}

		processResult = this.doBusinessRule();
		if (processResult != null && processResult.isMsgError()) {
			return processResult;
		} else {
			globalResult.addMessages(processResult);
		}

		processResult = this.business();
		if (processResult != null && processResult.isMsgError()) {
			return processResult;
		} else {
			globalResult.addMessages(processResult);
		}
		Object subject = UserContext.getSubject();
		if (subject instanceof Collection) {
			for (final Object o : (Collection) subject) {
				em.merge(o);
			}
		} else {
			subject = em.merge(subject);
			UserContext.setSubject(subject);
		}

		businessTrace();

		return globalResult;
	}

	private void businessTrace() {
		// TODO Auto-generated method stub

	}

	/**
	 * Méthode pour réaliser la trace d'un objet
	 */
	private void trace() {
		// NOT implemeted
	}

	/**
	 * Méthode qui gére l'authorisation d'un acteur pour execution du usecase
	 * 
	 * @return ProcessResult
	 */
	final protected ProcessResult doAuthorisation() {
		return null;
	}

	/**
	 * Méthode pour réaliser la validation unitaire simple
	 * 
	 * @return ProcessResult
	 */
	final protected ProcessResult doValidationUnitaireSimple() {
		return getValidator().doValidationSimple();
	}

	protected IValidator getValidator() {
		return new ValidatorImpl();
	}

	/**
	 * Méthode executé dans le preProcess et qui fait appel au converter
	 * réalisant le formatage d'un VO vers l'objet
	 * 
	 * @return ProcessResult
	 */
	@SuppressWarnings("unchecked")
	protected ProcessResult doFormat() {
		/**
		 * @author amtarji: cas de plusieur VO
		 */
		ProcessResult processResult = new ProcessResult();
		Object subject = UserContext.getSubject();
		if (subject instanceof Collection) {
			List<ValueObject> vos = (List<ValueObject>) UserContext
					.getSubject();
			List<GenericEntity> models = getTransformer().vo2Model(vos);
			processResult.setData(models);
		} else {
			ValueObject vo = (ValueObject) UserContext.getSubject();
			GenericEntity model = getTransformer().vo2Model(vo);
			processResult.setData(model);
		}
		return processResult;
	}

	/**
	 * Méthode qui fait appel aux préconditions d'un use case
	 * 
	 * @return ProcessResult
	 */
	final protected ProcessResult doCheckPrecondition() {
		return getPreconditionManager().doCheckPrecondition(this);
	}

	/**
	 * Méthode qui gére l'accès concurrent
	 * 
	 * @return ProcessResult
	 */
	final protected ProcessResult doCheckConcurrentAccess() {
		return getConcurrentAccessManager().doCheckConcurrentAccess(this);
	}

	protected IConcurrentAccessManager getConcurrentAccessManager() {
		// TODO Auto-generated method stub
		return new DefaultConcurrentAccessManager();
	}

	/**
	 * Méthode qui fait appel au service du merge
	 * 
	 * @return ProcessResult
	 */
	// final protected ProcessResult doMerge() {
	// return MergeHelper.doMerge(this);
	// }

	/**
	 * Méthode qui fait appel au service de validation des business Rule d'un
	 * useCase
	 * 
	 * @return ProcessResult
	 */
	final protected ProcessResult doBusinessRule() {
		return getBusinessRuleManager().doValidation();
	}

	/**
	 * Récupération de la classe responsable de l'implémentation des règles
	 * métiers pour un Use Case donnée.
	 * 
	 * @return IBusinessRule
	 */
	protected abstract IBusinessRuleManager getBusinessRuleManager();

	/**
	 * Logic metier du Use Case
	 * 
	 * @return ProcessResult
	 */
	abstract protected ProcessResult business();

	/**
	 * Récupérer le convertisseur pour traduire la value object
	 * 
	 * @return IValueObbjectConverter
	 */
	protected ITransformer getTransformer() {
		/**
		 * @author amtarji cas de plusieur vos
		 */
		if (UserContext.getClientParameters().isOnCollection()) {
			return UserContext.getClientParameters().getVos().get(0)
					.getTransformer();
		} else {
			return UserContext.getClientParameters().getVo().getTransformer();
		}
	}

	/**
	 * Récupération de la classe responsable de la verification des
	 * preconditions avant lancement effectif du Use Case.
	 * 
	 * @return PreconditionManagerBase
	 */
	protected IPreconditionManager getPreconditionManager() {
		return new DefaultPreconditionManager();
	}

	// /**
	// * Récupération de la classe responsable de la synchronisation des valeurs
	// * des attributs de l'objet métier récupéré de la base de données et
	// l'objet
	// * métier créer à partir du value object
	// *
	// * @return IMerger
	// */
	// public IMerger getMerger() {
	// return new MergerDefault();
	// }

	/**
	 * Transformer l'item en VO après validation de la transaction
	 */
	/**
	 * @author amtarji ajout du cas de pluseur VO
	 */
	@SuppressWarnings("unchecked")
	protected void fillVO() {
		Object subject = UserContext.getSubject();
		if (subject instanceof Collection) {
			List<GenericEntity> models = (List<GenericEntity>) UserContext
					.getSubject();
			UserContext.setSubject(getTransformer().model2VO(models));
		} else {
			GenericEntity model = (GenericEntity) UserContext.getSubject();
			UserContext.setSubject(getTransformer().model2VO(model));
		}
	}

}
