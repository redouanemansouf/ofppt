/*
 * VoGroupsInterfaces.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.vo;

import java.io.Serializable;

import com.m2m.onousc.business.referentiel.vo.VoGroupsInterfaces.AgenceWizard.AgcWizardStep;

// TODO: Auto-generated Javadoc
/**
 * The Class VoGroupsInterfaces.
 * 
 * @author amtarji Déclaration des groupes pour les validation des VO
 */
public class VoGroupsInterfaces implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4223703894706182423L;

	public interface NoValidationGroup {

	}

	/**
	 * The Interface HeureEteGroupe.
	 * 
	 * @author amtarji Group pour la validation de l'heure d'ete
	 */
	public interface HeureEteGroupe {

		/** Message personaliser selon le groupe. */
		String message = "{custom.validation.constraints.dateCompare.debutFin}";
	}

	/**
	 * le cas d'un profil canal de vente commissionaire.
	 * 
	 * @author amtarji
	 */
	public interface CommissionaireGroupe {
	}

	/**
	 * The Interface CommissionParModeReglementGroupe.
	 * 
	 * @version 1.0 19 mars 2015
	 * @author amtarji
	 */
	public interface CommissionParModeReglementGroupe {

		/** The at least one. */
		String atLeastOne = "{custom.validation.constraints.size.CommissionParModeReglementGroupe}";
	}

	/**
	 * The Interface CommissionParTypeOperationGroupe.
	 * 
	 * @version 1.0 19 mars 2015
	 * @author amtarji
	 */
	public interface CommissionParTypeOperationGroupe {

		/** The at least one. */
		String atLeastOne = "{custom.validation.constraints.size.CommissionParTypeOperationGroupe}";
	}

	/**
	 * The Interface CommissionParActiviteMetierGroupe.
	 * 
	 * @version 1.0 19 mars 2015
	 * @author amtarji
	 */
	public interface CommissionParActiviteMetierGroupe {
	}

	/**
	 * profil canal vente , prepaye.
	 * 
	 * @author amtarji
	 */
	public interface PrepayeGroupe {
	}

	/**
	 * The Interface DroitTimbreGroupe.
	 * 
	 * @version 1.0 19 mars 2015
	 * @author amtarji
	 */
	public interface DroitTimbreGroupe {

		/** The tranche incorrect. */
		String TRANCHE_INCORRECT = "{custom.validation.constraints.compareDigits.DroitTimbre}";
	}

	/**
	 * Agence.
	 * 
	 * @author amtarji
	 */
	public interface AgenceWizard {

		/**
		 * The Enum AgcWizardStep.
		 * 
		 * @version 1.0 19 mars 2015
		 * @author amtarji
		 */
		public enum AgcWizardStep {

			/** The fiche id. */
			FICHE_ID("FICHE_ID", "FICHEIDENTIFICATION"),
			/** The event param. */
			EVENT_PARAM("EVENT_PARAM", "EVENEMENTS_PARAMETRES"),
			/** The coord banq. */
			COORD_BANQ("COORD_BANQ", "COORDONEES_BANCAIRES"),
			/** The mat info. */
			MAT_INFO("MAT_INFO", "DEDUCTION_MATERIEL_INFORMATIQUES"),
			/** The prev budget. */
			PREV_BUDGET("PREV_BUDGET", "RECETTES_PREVISIONNELLES"),
			/** The pj. */
			PJ("PJ", "PIECES_JOINTES");

			private AgcWizardStep(String step, String prezKey) {
				this.step = step;
				this.prezKey = prezKey;
			}

			/** The step. */
			private String step;
			private String prezKey;

			/**
			 * Gets the step.
			 * 
			 * @return the step
			 */
			public String getStep() {
				return step;
			}

			/**
			 * Sets the step.
			 * 
			 * @param step
			 *            the new step
			 */
			public void setStep(String step) {
				this.step = step;
			}

			public String getPrezKey() {
				return prezKey;
			}

			public void setPrezKey(String prezKey) {
				this.prezKey = prezKey;
			}

		}
	}

	/**
	 * The Interface AgcFicheIdentificationGroup.
	 * 
	 * @version 1.0 19 mars 2015
	 * @author amtarji
	 */
	public interface AgcFicheIdentificationGroup {

		/** The wiz. */
		AgcWizardStep wiz = AgcWizardStep.FICHE_ID;

		/** The Constant MESSAGE_HORAIRE_SERVICE. */
		static final String MESSAGE_HORAIRE_SERVICE = "{custom.validation.constraints.debutFinService}";

		/** The Constant MESSAGE_TELEPHONES. */
		static final String MESSAGE_TELEPHONES = "{custom.validation.constraints.telephones}";

	}

	/**
	 * The Interface IdFiscaleProfilCommGroupe.
	 * 
	 * @version 1.0 19 mars 2015
	 * @author amtarji
	 */
	public interface IdFiscaleProfilCommGroup {

		/** The Constant MESSAGE_ID_FISCAL. */
		static final String MESSAGE_ID_FISCAL = "{custom.validation.constraints.agcIdFiscale}";
	}

	/**
	 * The Interface AgcEvenementParamsGroup.
	 * 
	 * @version 1.0 19 mars 2015
	 * @author amtarji
	 */
	public interface AgcEvenementParamsGroup {

		/** The wiz. */
		AgcWizardStep wiz = AgcWizardStep.EVENT_PARAM;

		/** The Constant MESSAGE_DATE_OUV_DATE_PROD. */
		static final String MESSAGE_DATE_OUV_DATE_PROD = "{custom.validation.constraints.debutOuvProd}";

	}

	/**
	 * The Interface DateOuvertureProdGroup.
	 * 
	 * @version 1.0 19 mars 2015
	 * @author amtarji
	 */
	public interface DateOuvertureProdGroup {
	}

	/**
	 * The Interface AgcCoordBancaireGroup.
	 * 
	 * @version 1.0 19 mars 2015
	 * @author amtarji
	 */
	public interface AgcCoordBancaireGroup {

		/** The wiz. */
		AgcWizardStep wiz = AgcWizardStep.COORD_BANQ;

	}

	/**
	 * The Interface AgenceBancaireCommissionnaireGroupe.
	 * 
	 * @version 1.0 19 mars 2015
	 * @author amtarji
	 */
	public interface AgenceBancaireCommissionnaireGroupe {

		/** The Constant AGENCE_COMM_COMPTE. */
		static final String AGENCE_COMM_COMPTE = "{custom.validation.constraints.agenceBancaireCommissionnaire}";
	}

	/**
	 * The Interface AgcMaterielInfosGroup.
	 * 
	 * @version 1.0 19 mars 2015
	 * @author amtarji
	 */
	public interface AgcMaterielInfosGroup {

		/** The wiz. */
		AgcWizardStep wiz = AgcWizardStep.MAT_INFO;

		/** The Constant MESSAGE_DEDUCTIONS. */
		static final String MESSAGE_DEDUCTIONS = "{custom.validation.constraints.deductions}";

		/** The Constant MESSAGE_MTERIAUX. */
		static final String MESSAGE_MTERIAUX = "{custom.validation.constraints.materiaux}";
	}

	/**
	 * The Interface AgcPrevisionsBudgetaireGroup.
	 * 
	 * @version 1.0 19 mars 2015
	 * @author amtarji
	 */
	public interface AgcPrevisionsBudgetaireGroup {

		/** The wiz. */
		AgcWizardStep wiz = AgcWizardStep.PREV_BUDGET;

		/** The Constant MESSAGE_RECETTE_IU. */
		static final String MESSAGE_RECETTE_IU = "{custom.validation.constraints.recettesIU}";

		/** The Constant MESSAGE_RECETTE_IN. */
		static final String MESSAGE_RECETTE_IN = "{custom.validation.constraints.recetteIN}";
	}

	/**
	 * The Interface AgcPieceJointeGroup.
	 * 
	 * @version 1.0 19 mars 2015
	 * @author amtarji
	 */
	public interface AgcPieceJointeGroup {

		/** The wiz. */
		AgcWizardStep wiz = AgcWizardStep.PJ;

		/** The Constant MESSAGE_RECETTE_IU. */
		static final String MESSAGE_RECETTE_IU = "{custom.validation.constraints.pieveJointAgcContrat}";
	}

	/**
	 * The Interface DateFinNonPreciseGroupe.
	 * 
	 * @version 1.0 19 mars 2015
	 * @author amtarji
	 */
	public interface DateFinNonPreciseGroupe {
	}
}
