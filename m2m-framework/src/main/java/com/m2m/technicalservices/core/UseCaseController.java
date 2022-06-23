package com.m2m.technicalservices.core;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.m2m.technicalservices.dao.impl.GenericEntity;

/**
 * Classe abstraite devant �tre impl�menter par les Uses Case autres que Batchs
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
	 * M�thode pour r�aliser la trace d'un objet
	 */
	private void trace() {
		// NOT implemeted
	}

	/**
	 * M�thode qui g�re l'authorisation d'un acteur pour execution du usecase
	 * 
	 * @return ProcessResult
	 */
	final protected ProcessResult doAuthorisation() {
		return null;
	}

	/**
	 * M�thode pour r�aliser la validation unitaire simple
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
	 * M�thode execut� dans le preProcess et qui fait appel au converter
	 * r�alisant le formatage d'un VO vers l'objet
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
	 * M�thode qui fait appel aux pr�conditions d'un use case
	 * 
	 * @return ProcessResult
	 */
	final protected ProcessResult doCheckPrecondition() {
		return getPreconditionManager().doCheckPrecondition(this);
	}

	/**
	 * M�thode qui g�re l'acc�s concurrent
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
	 * M�thode qui fait appel au service du merge
	 * 
	 * @return ProcessResult
	 */
	// final protected ProcessResult doMerge() {
	// return MergeHelper.doMerge(this);
	// }

	/**
	 * M�thode qui fait appel au service de validation des business Rule d'un
	 * useCase
	 * 
	 * @return ProcessResult
	 */
	final protected ProcessResult doBusinessRule() {
		return getBusinessRuleManager().doValidation();
	}

	/**
	 * R�cup�ration de la classe responsable de l'impl�mentation des r�gles
	 * m�tiers pour un Use Case donn�e.
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
	 * R�cup�rer le convertisseur pour traduire la value object
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
	 * R�cup�ration de la classe responsable de la verification des
	 * preconditions avant lancement effectif du Use Case.
	 * 
	 * @return PreconditionManagerBase
	 */
	protected IPreconditionManager getPreconditionManager() {
		return new DefaultPreconditionManager();
	}

	// /**
	// * R�cup�ration de la classe responsable de la synchronisation des valeurs
	// * des attributs de l'objet m�tier r�cup�r� de la base de donn�es et
	// l'objet
	// * m�tier cr�er � partir du value object
	// *
	// * @return IMerger
	// */
	// public IMerger getMerger() {
	// return new MergerDefault();
	// }

	/**
	 * Transformer l'item en VO apr�s validation de la transaction
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
