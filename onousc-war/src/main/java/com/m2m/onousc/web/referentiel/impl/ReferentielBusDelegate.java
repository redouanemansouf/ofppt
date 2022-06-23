/*
 * ReferentielBusDelegate.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.referentiel.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.groups.Default;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.vo.AdherentVO;
import com.m2m.onousc.business.referentiel.vo.AnneeUniversitaireVO;
import com.m2m.onousc.business.referentiel.vo.BorneVO;
import com.m2m.onousc.business.referentiel.vo.CaisseVO;
import com.m2m.onousc.business.referentiel.vo.CaissierVO;
import com.m2m.onousc.business.referentiel.vo.CanalVenteVO;
import com.m2m.onousc.business.referentiel.vo.CarteNapsVO;
import com.m2m.onousc.business.referentiel.vo.CarteVO;
import com.m2m.onousc.business.referentiel.vo.CategoriePorteurVO;
import com.m2m.onousc.business.referentiel.vo.CiteVO;
import com.m2m.onousc.business.referentiel.vo.CritereVO;
import com.m2m.onousc.business.referentiel.vo.CycleVieVO;
import com.m2m.onousc.business.referentiel.vo.DemandeAdminVO;
import com.m2m.onousc.business.referentiel.vo.DetailProfilVO;
import com.m2m.onousc.business.referentiel.vo.EquipementVO;
import com.m2m.onousc.business.referentiel.vo.EtudiantVO;
import com.m2m.onousc.business.referentiel.vo.EvenementVO;
import com.m2m.onousc.business.referentiel.vo.FiliereVO;
import com.m2m.onousc.business.referentiel.vo.ImportInscriptionVO;
import com.m2m.onousc.business.referentiel.vo.InscriptionVO;
import com.m2m.onousc.business.referentiel.vo.JoursFerieVO;
import com.m2m.onousc.business.referentiel.vo.MonitoringEchangeVO;
import com.m2m.onousc.business.referentiel.vo.MotifMainLeveeVO;
import com.m2m.onousc.business.referentiel.vo.MotifOppositionVO;
import com.m2m.onousc.business.referentiel.vo.NoteCritereVO;
import com.m2m.onousc.business.referentiel.vo.ParametreGeneralVO;
import com.m2m.onousc.business.referentiel.vo.PersonnelVO;
import com.m2m.onousc.business.referentiel.vo.PlafondVO;
import com.m2m.onousc.business.referentiel.vo.ProduitVO;
import com.m2m.onousc.business.referentiel.vo.ProfilPorteurVO;
import com.m2m.onousc.business.referentiel.vo.RestaurantVO;
import com.m2m.onousc.business.referentiel.vo.ServiceVO;
import com.m2m.onousc.business.referentiel.vo.SiteVO;
import com.m2m.onousc.business.referentiel.vo.SoldeVO;
import com.m2m.onousc.business.referentiel.vo.TarifVO;
import com.m2m.onousc.business.referentiel.vo.TourniquetVO;
import com.m2m.onousc.business.referentiel.vo.UniversiteVO;
import com.m2m.onousc.web.referentiel.IReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.webbean.AdherentWebBean;
import com.m2m.onousc.web.referentiel.webbean.AnneeUniversitaireWebBean;
import com.m2m.onousc.web.referentiel.webbean.BorneWebBean;
import com.m2m.onousc.web.referentiel.webbean.CaisseWebBean;
import com.m2m.onousc.web.referentiel.webbean.CaissierWebBean;
import com.m2m.onousc.web.referentiel.webbean.CanalVenteWebBean;
import com.m2m.onousc.web.referentiel.webbean.CarteWebBean;
import com.m2m.onousc.web.referentiel.webbean.CategoriePorteurWebBean;
import com.m2m.onousc.web.referentiel.webbean.CiteWebBean;
import com.m2m.onousc.web.referentiel.webbean.CritereWebBean;
import com.m2m.onousc.web.referentiel.webbean.CycleVieWebBean;
import com.m2m.onousc.web.referentiel.webbean.DemandeAdminWebBean;
import com.m2m.onousc.web.referentiel.webbean.DetailProfilWebBean;
import com.m2m.onousc.web.referentiel.webbean.EquipementWebBean;
import com.m2m.onousc.web.referentiel.webbean.EtudiantWebBean;
import com.m2m.onousc.web.referentiel.webbean.EvenementWebBean;
import com.m2m.onousc.web.referentiel.webbean.FiliereWebBean;
import com.m2m.onousc.web.referentiel.webbean.InscriptionWebBean;
import com.m2m.onousc.web.referentiel.webbean.JoursFerieWebBean;
import com.m2m.onousc.web.referentiel.webbean.MotifMainLeveeWebBean;
import com.m2m.onousc.web.referentiel.webbean.MotifOppositionWebBean;
import com.m2m.onousc.web.referentiel.webbean.NoteCritereWebBean;
import com.m2m.onousc.web.referentiel.webbean.OppositionAdhWebBean;
import com.m2m.onousc.web.referentiel.webbean.OppositionWebBean;
import com.m2m.onousc.web.referentiel.webbean.ParametreGeneralWebBean;
import com.m2m.onousc.web.referentiel.webbean.PersonnelWebBean;
import com.m2m.onousc.web.referentiel.webbean.PlafondWebBean;
import com.m2m.onousc.web.referentiel.webbean.ProduitWebBean;
import com.m2m.onousc.web.referentiel.webbean.ProfilPorteurWebBean;
import com.m2m.onousc.web.referentiel.webbean.RestaurantWebBean;
import com.m2m.onousc.web.referentiel.webbean.ServiceWebBean;
import com.m2m.onousc.web.referentiel.webbean.SiteWebBean;
import com.m2m.onousc.web.referentiel.webbean.SoldeWebBean;
import com.m2m.onousc.web.referentiel.webbean.TarifWebBean;
import com.m2m.onousc.web.referentiel.webbean.TourniquetWebBean;
import com.m2m.onousc.web.referentiel.webbean.UniversiteWebBean;
import com.m2m.technicalservices.core.User;
import com.m2m.technicalservices.core.UserContext;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.BaseBusDelegate;

public class ReferentielBusDelegate extends BaseBusDelegate implements IReferentielBusDelegate {

	/**
	 * Instantiates a new referentiel bus delegate.
	 */
	public ReferentielBusDelegate() {

		domaine = "REFERENTIEL";
		/*
		 * Toujours initier le groupe de validation
		 */
		Class<?>[] groups = { Default.class };
		UserContext.setValidationGroups(groups);
	}

	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");

	/**
	 * Creer canal vente.
	 * 
	 * @param webBean the web bean
	 * @return true, if successful
	 */
	@Override
	public boolean creerCanalVente(CanalVenteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CANAL_VENTE;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_CANAL_VENTE;
		CanalVenteVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.ENABLED);
		CanalVenteVO returnVO = (CanalVenteVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}
	
	@Override
	public boolean refabriquerCarte(CarteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CARTE;
		String sousCommand = Constantes.SOUS_COMMAND_REFABRIQUER_CARTE;
		CarteVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.RESCIND);
		CarteVO returnVO = (CarteVO) executeCommand(vo, command,
				sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}
	
	
	@Override
	public boolean carteMainLevee(OppositionWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CARTE;
		String sousCommand = Constantes.SOUS_COMMAND_CARTE_MAIN_LEVEE;
		CarteVO vo = webBean.getVo();
				
		CarteVO returnVO = (CarteVO) executeCommand(vo, command,
				sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	/**
	 * Modifier canal vente.
	 * 
	 * @param webBean the web bean
	 * @return true, if successful
	 */
	@Override
	public boolean modifierCanalVente(CanalVenteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CANAL_VENTE;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_CANAL_VENTE;
		CanalVenteVO vo = webBean.getVo();
		CanalVenteVO returnVO = (CanalVenteVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	/**
	 * Supprimer canal vente.
	 * 
	 * @param webBean the web bean
	 * @return true, if successful
	 */
	@Override
	public boolean supprimerCanalVente(CanalVenteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CANAL_VENTE;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_CANAL_VENTE;
		CanalVenteVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		CanalVenteVO returnVO = (CanalVenteVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	/**
	 * Activer canal vente.
	 * 
	 * @param webBean the web bean
	 * @return true, if successful
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean activerCanalVente(CanalVenteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CANAL_VENTE;
		String sousCommand = Constantes.SOUS_COMMAND_ACTIVER_CANAL_VENTE;
		List<CanalVenteVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (CanalVenteVO vo : vos) {
				vo.setStatut(EntityStatus.ENABLED);
			}
			List<CanalVenteVO> returnVOs = (List<CanalVenteVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}

		return error;
	}

	/**
	 * Desactiver canal vente.
	 * 
	 * @param webBean the web bean
	 * @return true, if successful
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean desactiverCanalVente(CanalVenteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CANAL_VENTE;
		String sousCommand = Constantes.SOUS_COMMAND_DESACTIVER_CANAL_VENTE;
		List<CanalVenteVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (CanalVenteVO vo : vos) {
				vo.setStatut(EntityStatus.DISABLED);
			}
			List<CanalVenteVO> returnVOs = (List<CanalVenteVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	/**
	 * Supprimer collection canal vente.
	 * 
	 * @param webBean the web bean
	 * @return true, if successful
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean supprimerCollectionCanalVente(CanalVenteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CANAL_VENTE;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_COLLECTION_CANAL_VENTE;
		List<CanalVenteVO> vos = webBean.getSelectedVOs();
		if (!webBean.getSelectedVOs().isEmpty()) {
			for (CanalVenteVO vo : vos) {
				vo.setStatut(EntityStatus.DELETED);
			}
			List<CanalVenteVO> returnVOs = (List<CanalVenteVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	public boolean creerSite(SiteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_SITE;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_SITE;
		SiteVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.ENABLED);
		SiteVO returnVO = (SiteVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	/**
	 * Modifier Site.
	 * 
	 * @param webBean the web bean
	 * @return true, if successful
	 */
	@Override
	public boolean modifierSite(SiteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_SITE;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_SITE;
		SiteVO vo = webBean.getVo();
		SiteVO returnVO = (SiteVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	/**
	 * Supprimer Site.
	 * 
	 * @param webBean the web bean
	 * @return true, if successful
	 */
	@Override
	public boolean supprimerSite(SiteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_SITE;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_SITE;
		SiteVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		SiteVO returnVO = (SiteVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	/*************** Universite **************/

	/**
	 * Creer universite.
	 * 
	 * @param webBean the web bean
	 * @return true, if successful
	 */
	@Override
	public boolean creeUniversite(UniversiteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_UNIVERSITE;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_UNIVERSITE;
		UniversiteVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.ENABLED);
		UniversiteVO returnVO = (UniversiteVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean creerEtudiant(EtudiantWebBean webBean) {
		String command = Constantes.COMMAND_GERER_ETUDIANT;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_ETUDIANT;
		EtudiantVO vo = webBean.getVo();
//		if(!vo.getResident()){
//			vo.setRevenu(vo.getNoteCritereVOs().get(0).getMin()+"-"+vo.getNoteCritereVOs().get(0).getMax());
//		vo.setNbrfresoeur(vo.getNoteCritereVOs().get(1).getMin()+"-"+vo.getNoteCritereVOs().get(1).getMax());
//		vo.setNote(((vo.getNoteCritereVOs().get(0).getNote() * vo
//				.getNoteCritereVOs().get(0).getCritereVO().getCoefficient()) + (vo
//				.getNoteCritereVOs().get(1).getNote() * vo.getNoteCritereVOs()
//				.get(1).getCritereVO().getCoefficient()))
//				/ (vo.getNoteCritereVOs().get(0).getCritereVO()
//						.getCoefficient() + vo.getNoteCritereVOs().get(1)
//						.getCritereVO().getCoefficient()));}
		// else vo.setNote(0F);
		vo.setStatut(EntityStatus.ENABLED);
		EtudiantVO returnVO = (EtudiantVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean applyRnvEtudiant(EtudiantWebBean webBean) {
		String command = Constantes.COMMAND_GERER_ETUDIANT;
		String sousCommand = Constantes.SOUS_COMMAND_APPLY_RENEWAL;
		EtudiantVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.RENEWED);
		EtudiantVO returnVO = (EtudiantVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean supprimerEtudiant(EtudiantWebBean webBean) {
		String command = Constantes.COMMAND_GERER_ETUDIANT;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_ETUDIANT;
		EtudiantVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		EtudiantVO returnVO = (EtudiantVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean modifierEtudiant(EtudiantWebBean webBean) {
		String command = Constantes.COMMAND_GERER_ETUDIANT;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_ETUDIANT;
		EtudiantVO vo = webBean.getVo();
		EtudiantVO returnVO = (EtudiantVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean supprimerCollectionEtudiant(EtudiantWebBean webBean) {
		String command = Constantes.COMMAND_GERER_ETUDIANT;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_COLLECTION_ETUDIANT;
		List<EtudiantVO> vos = webBean.getSelectedVOs();
		if (!webBean.getSelectedVOs().isEmpty()) {
			for (EtudiantVO vo : vos) {
				vo.setStatut(EntityStatus.DELETED);
			}
			List<EtudiantVO> returnVOs = (List<EtudiantVO>) executeCommand(vos, command, sousCommand);

			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	public boolean personnaliserCollectionEtudiant(EtudiantWebBean webBean) {
		String command = Constantes.COMMAND_GERER_ETUDIANT;
		String sousCommand = Constantes.SOUS_COMMAND_PERSONNALISER_COLLECTION_ETUDIANT;
		List<EtudiantVO> vos = webBean.getSelectedVOs();
		if (!webBean.getSelectedVOs().isEmpty()) {
			for (EtudiantVO vo : vos) {
				vo.setStatut(EntityStatus.PERSONALIZED);
			}
			List<EtudiantVO> returnVOs = (List<EtudiantVO>) executeCommand(vos, command, sousCommand);

			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	public boolean validerCollectionEtudiant(EtudiantWebBean webBean) {
		String command = Constantes.COMMAND_GERER_ETUDIANT;
		String sousCommand = Constantes.SOUS_COMMAND_VALIDATE_COLLECTION_ETUDIANT;
		List<EtudiantVO> vos = webBean.getSelectedVOs();
		if (!webBean.getSelectedVOs().isEmpty()) {
			for (EtudiantVO vo : vos) {
				vo.setStatut(EntityStatus.VALIDATED);
			}
			List<EtudiantVO> returnVOs = (List<EtudiantVO>) executeCommand(vos, command, sousCommand);

			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	public boolean validateEtudiant(EtudiantWebBean webBean) {
		String command = Constantes.COMMAND_GERER_ETUDIANT;
		String sousCommand = Constantes.SOUS_COMMAND_VALIDATE_ETUDIANT;
		EtudiantVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.VALIDATED);
		EtudiantVO returnVO = (EtudiantVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;

	}

	@Override
	public boolean supprimerCollectionUniversite(UniversiteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_UNIVERSITE;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_COLLECTION_UNIVERSITE;
		List<UniversiteVO> vos = webBean.getSelectedVOs();
		if (!webBean.getSelectedVOs().isEmpty()) {
			for (UniversiteVO vo : vos) {
				vo.setStatut(EntityStatus.DELETED);
			}
			List<UniversiteVO> returnVOs = (List<UniversiteVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	public boolean desactiverUniversite(UniversiteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_UNIVERSITE;
		String sousCommand = Constantes.SOUS_COMMAND_DESACTIVER_UNIVERSITE;
		List<UniversiteVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (UniversiteVO vo : vos) {
				vo.setStatut(EntityStatus.DISABLED);
			}

			List<UniversiteVO> returnVOs = (List<UniversiteVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	public boolean activerUniversite(UniversiteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_UNIVERSITE;
		String sousCommand = Constantes.SOUS_COMMAND_ACTIVER_UNIVERSITE;
		List<UniversiteVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (UniversiteVO vo : vos) {
				vo.setStatut(EntityStatus.ENABLED);
			}
			List<UniversiteVO> returnVOs = (List<UniversiteVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}

		return error;
	}

	@Override
	public boolean supprimerUniversite(UniversiteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_UNIVERSITE;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_UNIVERSITE;
		UniversiteVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		UniversiteVO returnVO = (UniversiteVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean modifierUniversite(UniversiteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_UNIVERSITE;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_UNIVERSITE;
		UniversiteVO vo = webBean.getVo();
		UniversiteVO returnVO = (UniversiteVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	/******************** cite ****************************/
	@Override
	public boolean creeCite(CiteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CITE;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_CITE;
		CiteVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.ENABLED);
		CiteVO returnVO = (CiteVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean supprimerCollectionCite(CiteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CITE;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_COLLECTION_CITE;
		List<CiteVO> vos = webBean.getSelectedVOs();
		if (!webBean.getSelectedVOs().isEmpty()) {
			for (CiteVO vo : vos) {
				vo.setStatut(EntityStatus.DELETED);
			}

			List<CiteVO> returnVOs = (List<CiteVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	public boolean desactiverCite(CiteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CITE;
		String sousCommand = Constantes.SOUS_COMMAND_DESACTIVER_CITE;
		List<CiteVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (CiteVO vo : vos) {
				vo.setStatut(EntityStatus.DISABLED);
			}

			List<CiteVO> returnVOs = (List<CiteVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	public boolean activerCite(CiteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CITE;
		String sousCommand = Constantes.SOUS_COMMAND_ACTIVER_CITE;
		List<CiteVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (CiteVO vo : vos) {
				vo.setStatut(EntityStatus.ENABLED);
			}

			List<CiteVO> returnVOs = (List<CiteVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}

		return error;
	}

	@Override
	public boolean supprimerCite(CiteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CITE;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_CITE;
		CiteVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		CiteVO returnVO = (CiteVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean modifierCite(CiteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CITE;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_CITE;
		CiteVO vo = webBean.getVo();
		CiteVO returnVO = (CiteVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean desactiverEtudiant(EtudiantWebBean webBean) {
		String command = Constantes.COMMAND_GERER_ETUDIANT;
		String sousCommand = Constantes.SOUS_COMMAND_DESACTIVER_ETUDIANT;
		EtudiantVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.CLOSED);
		EtudiantVO returnVO = (EtudiantVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;

	}

	public boolean validateEtudiantRNV(EtudiantWebBean webBean) {
		String command = Constantes.COMMAND_GERER_ETUDIANT;
		String sousCommand = Constantes.SOUS_COMMAND_VALIDATE_ETUDIANT_RNV;
		EtudiantVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.VALIDATED);
		// vo.setRenouvellement(false);
		EtudiantVO returnVO = (EtudiantVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	/********************** JoursFerie **************************/
	@Override
	public boolean creerJoursFerie(JoursFerieWebBean webBean) {
		String command = Constantes.COMMAND_GERER_JOURS_FERIE;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_JOURS_FERIE;
		JoursFerieVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.ENABLED);
		JoursFerieVO returnVO = (JoursFerieVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean supprimerCollectionJoursFerie(JoursFerieWebBean webBean) {
		String command = Constantes.COMMAND_GERER_JOURS_FERIE;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_COLLECTION_JOURS_FERIE;
		List<JoursFerieVO> vos = webBean.getSelectedVOs();
		if (!webBean.getSelectedVOs().isEmpty()) {
			for (JoursFerieVO vo : vos) {
				vo.setStatut(EntityStatus.DELETED);
			}

			List<JoursFerieVO> returnVOs = (List<JoursFerieVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	public boolean desactiverJoursFerie(JoursFerieWebBean webBean) {
		String command = Constantes.COMMAND_GERER_JOURS_FERIE;
		String sousCommand = Constantes.SOUS_COMMAND_DESACTIVER_JOURS_FERIE;
		List<JoursFerieVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (JoursFerieVO vo : vos) {
				vo.setStatut(EntityStatus.DISABLED);
			}

			List<JoursFerieVO> returnVOs = (List<JoursFerieVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	public boolean activerJoursFerie(JoursFerieWebBean webBean) {
		String command = Constantes.COMMAND_GERER_JOURS_FERIE;
		String sousCommand = Constantes.SOUS_COMMAND_ACTIVER_JOURS_FERIE;
		List<JoursFerieVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (JoursFerieVO vo : vos) {
				vo.setStatut(EntityStatus.ENABLED);
			}

			List<JoursFerieVO> returnVOs = (List<JoursFerieVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}

		return error;
	}

	@Override
	public boolean supprimerJoursFerie(JoursFerieWebBean webBean) {
		String command = Constantes.COMMAND_GERER_JOURS_FERIE;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_JOURS_FERIE;
		JoursFerieVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		JoursFerieVO returnVO = (JoursFerieVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean modifierJoursFerie(JoursFerieWebBean webBean) {
		String command = Constantes.COMMAND_GERER_JOURS_FERIE;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_JOURS_FERIE;
		JoursFerieVO vo = webBean.getVo();
		JoursFerieVO returnVO = (JoursFerieVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	/******************** Tarif ****************************/

	@Override
	public boolean creerTarif(TarifWebBean webBean) {
		String command = Constantes.COMMAND_GERER_TARIF;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_TARIF;
		TarifVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.ENABLED);
		TarifVO returnVO = (TarifVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean supprimerCollectionTarif(TarifWebBean webBean) {
		String command = Constantes.COMMAND_GERER_TARIF;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_COLLECTION_TARIF;
		List<TarifVO> vos = webBean.getSelectedVOs();
		if (!webBean.getSelectedVOs().isEmpty()) {
			for (TarifVO vo : vos) {
				vo.setStatut(EntityStatus.DELETED);
			}

			List<TarifVO> returnVOs = (List<TarifVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	public boolean desactiverTarif(TarifWebBean webBean) {
		String command = Constantes.COMMAND_GERER_TARIF;
		String sousCommand = Constantes.SOUS_COMMAND_DESACTIVER_TARIF;
		List<TarifVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (TarifVO vo : vos) {
				vo.setStatut(EntityStatus.DISABLED);
			}

			List<TarifVO> returnVOs = (List<TarifVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	public boolean activerTarif(TarifWebBean webBean) {
		String command = Constantes.COMMAND_GERER_TARIF;
		String sousCommand = Constantes.SOUS_COMMAND_ACTIVER_TARIF;
		List<TarifVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (TarifVO vo : vos) {
				vo.setStatut(EntityStatus.ENABLED);
			}

			List<TarifVO> returnVOs = (List<TarifVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}

		return error;
	}

	@Override
	public boolean supprimerTarif(TarifWebBean webBean) {
		String command = Constantes.COMMAND_GERER_TARIF;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_TARIF;
		TarifVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		TarifVO returnVO = (TarifVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean modifierTarif(TarifWebBean webBean) {
		String command = Constantes.COMMAND_GERER_TARIF;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_TARIF;
		TarifVO vo = webBean.getVo();
		TarifVO returnVO = (TarifVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	/******************** Service ****************************/
	@Override
	public boolean creerService(ServiceWebBean webBean) {
		String command = Constantes.COMMAND_GERER_SERVICE;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_SERVICE;
		ServiceVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.ENABLED);
		ServiceVO returnVO = (ServiceVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean supprimerCollectionService(ServiceWebBean webBean) {
		String command = Constantes.COMMAND_GERER_SERVICE;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_COLLECTION_SERVICE;
		List<ServiceVO> vos = webBean.getSelectedVOs();
		if (!webBean.getSelectedVOs().isEmpty()) {
			for (ServiceVO vo : vos) {
				vo.setStatut(EntityStatus.DELETED);
			}

			List<ServiceVO> returnVOs = (List<ServiceVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	public boolean desactiverService(ServiceWebBean webBean) {
		String command = Constantes.COMMAND_GERER_SERVICE;
		String sousCommand = Constantes.SOUS_COMMAND_DESACTIVER_SERVICE;
		List<ServiceVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (ServiceVO vo : vos) {
				vo.setStatut(EntityStatus.DISABLED);
			}

			List<ServiceVO> returnVOs = (List<ServiceVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	public boolean activerService(ServiceWebBean webBean) {
		String command = Constantes.COMMAND_GERER_SERVICE;
		String sousCommand = Constantes.SOUS_COMMAND_ACTIVER_SERVICE;
		List<ServiceVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (ServiceVO vo : vos) {
				vo.setStatut(EntityStatus.ENABLED);
			}

			List<ServiceVO> returnVOs = (List<ServiceVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}

		return error;
	}

	@Override
	public boolean supprimerService(ServiceWebBean webBean) {
		String command = Constantes.COMMAND_GERER_SERVICE;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_SERVICE;
		ServiceVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		ServiceVO returnVO = (ServiceVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean modifierService(ServiceWebBean webBean) {
		String command = Constantes.COMMAND_GERER_SERVICE;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_SERVICE;
		ServiceVO vo = webBean.getVo();
		ServiceVO returnVO = (ServiceVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean personnaliserEtudiant(EtudiantWebBean webBean) {
		String command = Constantes.COMMAND_GERER_ETUDIANT;
		String sousCommand = Constantes.SOUS_COMMAND_PERSONNALISER_ETUDIANT;
		EtudiantVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.PERSONALIZED);
		EtudiantVO returnVO = (EtudiantVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	/******************** Caisse ****************************/
	@Override
	public boolean creerCaisse(CaisseWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CAISSE;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_CAISSE;
		CaisseVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.ENABLED);
		CaisseVO returnVO = (CaisseVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean supprimerCollectionCaisse(CaisseWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CAISSE;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_COLLECTION_CAISSE;
		List<CaisseVO> vos = webBean.getSelectedVOs();
		if (!webBean.getSelectedVOs().isEmpty()) {
			for (CaisseVO vo : vos) {
				vo.setStatut(EntityStatus.DELETED);
			}

			List<CaisseVO> returnVOs = (List<CaisseVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean desactiverCaisse(CaisseWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CAISSE;
		String sousCommand = Constantes.SOUS_COMMAND_DESACTIVER_CAISSE;
		List<CaisseVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (CaisseVO vo : vos) {
				vo.setStatut(EntityStatus.DISABLED);
			}

			List<CaisseVO> returnVOs = (List<CaisseVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean activerCaisse(CaisseWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CAISSE;
		String sousCommand = Constantes.SOUS_COMMAND_ACTIVER_CAISSE;
		List<CaisseVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (CaisseVO vo : vos) {
				vo.setStatut(EntityStatus.ENABLED);
			}

			List<CaisseVO> returnVOs = (List<CaisseVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}

		return error;
	}

	@Override
	public boolean supprimerCaisse(CaisseWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CAISSE;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_CAISSE;
		CaisseVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		CaisseVO returnVO = (CaisseVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean modifierCaisse(CaisseWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CAISSE;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_CAISSE;
		CaisseVO vo = webBean.getVo();
		CaisseVO returnVO = (CaisseVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	/******************** Restaurant ****************************/
	@Override
	public boolean creerRestaurant(RestaurantWebBean webBean) {
		String command = Constantes.COMMAND_GERER_RESTAURANT;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_RESTAURANT;
		RestaurantVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.ENABLED);
		RestaurantVO returnVO = (RestaurantVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean supprimerCollectionRestaurant(RestaurantWebBean webBean) {
		String command = Constantes.COMMAND_GERER_RESTAURANT;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_COLLECTION_RESTAURANT;
		List<RestaurantVO> vos = webBean.getSelectedVOs();
		if (!webBean.getSelectedVOs().isEmpty()) {
			for (RestaurantVO vo : vos) {
				vo.setStatut(EntityStatus.DELETED);
			}

			List<RestaurantVO> returnVOs = (List<RestaurantVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean desactiverRestaurant(RestaurantWebBean webBean) {
		String command = Constantes.COMMAND_GERER_RESTAURANT;
		String sousCommand = Constantes.SOUS_COMMAND_DESACTIVER_RESTAURANT;
		List<RestaurantVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (RestaurantVO vo : vos) {
				vo.setStatut(EntityStatus.DISABLED);
			}

			List<RestaurantVO> returnVOs = (List<RestaurantVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean activerRestaurant(RestaurantWebBean webBean) {
		String command = Constantes.COMMAND_GERER_RESTAURANT;
		String sousCommand = Constantes.SOUS_COMMAND_ACTIVER_RESTAURANT;
		List<RestaurantVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (RestaurantVO vo : vos) {
				vo.setStatut(EntityStatus.ENABLED);
			}

			List<RestaurantVO> returnVOs = (List<RestaurantVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}

		return error;
	}

	@Override
	public boolean supprimerRestaurant(RestaurantWebBean webBean) {
		String command = Constantes.COMMAND_GERER_RESTAURANT;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_RESTAURANT;
		RestaurantVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		RestaurantVO returnVO = (RestaurantVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean modifierRestaurant(RestaurantWebBean webBean) {
		String command = Constantes.COMMAND_GERER_RESTAURANT;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_RESTAURANT;
		RestaurantVO vo = webBean.getVo();
		RestaurantVO returnVO = (RestaurantVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	/******************** Plafond ****************************/
	@Override
	public boolean creerPlafond(PlafondWebBean webBean) {
		String command = Constantes.COMMAND_GERER_PLAFOND;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_PLAFONDT;
		PlafondVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.ENABLED);
		PlafondVO returnVO = (PlafondVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean supprimerCollectionPlafond(PlafondWebBean webBean) {
		String command = Constantes.COMMAND_GERER_PLAFOND;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_COLLECTION_PLAFOND;
		List<PlafondVO> vos = webBean.getSelectedVOs();
		if (!webBean.getSelectedVOs().isEmpty()) {
			for (PlafondVO vo : vos) {
				vo.setStatut(EntityStatus.DELETED);
			}

			List<PlafondVO> returnVOs = (List<PlafondVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean desactiverPlafond(PlafondWebBean webBean) {
		String command = Constantes.COMMAND_GERER_PLAFOND;
		String sousCommand = Constantes.SOUS_COMMAND_DESACTIVER_PLAFOND;
		List<PlafondVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (PlafondVO vo : vos) {
				vo.setStatut(EntityStatus.DISABLED);
			}

			List<PlafondVO> returnVOs = (List<PlafondVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean activerPlafond(PlafondWebBean webBean) {
		String command = Constantes.COMMAND_GERER_PLAFOND;
		String sousCommand = Constantes.SOUS_COMMAND_ACTIVER_PLAFOND;
		List<PlafondVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (PlafondVO vo : vos) {
				vo.setStatut(EntityStatus.ENABLED);
			}

			List<PlafondVO> returnVOs = (List<PlafondVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}

		return error;
	}

	@Override
	public boolean supprimerPlafond(PlafondWebBean webBean) {
		String command = Constantes.COMMAND_GERER_PLAFOND;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_PLAFOND;
		PlafondVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		PlafondVO returnVO = (PlafondVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean modifierPlafond(PlafondWebBean webBean) {
		String command = Constantes.COMMAND_GERER_PLAFOND;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_PLAFOND;
		PlafondVO vo = webBean.getVo();
		PlafondVO returnVO = (PlafondVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	/******************** AnneeUniversitaire ****************************/
	@Override
	public boolean creerAnneeUniversitaire(AnneeUniversitaireWebBean webBean) {
		String command = Constantes.COMMAND_GERER_ANNEE_UNIVERSITAIRE;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_ANNEE_UNIVERSITAIRE;
		AnneeUniversitaireVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.ENABLED);
		AnneeUniversitaireVO returnVO = (AnneeUniversitaireVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean supprimerCollectionAnneeUniversitaire(AnneeUniversitaireWebBean webBean) {
		String command = Constantes.COMMAND_GERER_ANNEE_UNIVERSITAIRE;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_COLLECTION_ANNEE_UNIVERSITAIRE;
		List<AnneeUniversitaireVO> vos = webBean.getSelectedVOs();
		if (!webBean.getSelectedVOs().isEmpty()) {
			for (AnneeUniversitaireVO vo : vos) {
				vo.setStatut(EntityStatus.DELETED);
			}

			List<AnneeUniversitaireVO> returnVOs = (List<AnneeUniversitaireVO>) executeCommand(vos, command,
					sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean desactiverAnneeUniversitaire(AnneeUniversitaireWebBean webBean) {
		String command = Constantes.COMMAND_GERER_ANNEE_UNIVERSITAIRE;
		String sousCommand = Constantes.SOUS_COMMAND_DESACTIVER_ANNEE_UNIVERSITAIRE;
		List<AnneeUniversitaireVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (AnneeUniversitaireVO vo : vos) {
				vo.setStatut(EntityStatus.DISABLED);
			}

			List<AnneeUniversitaireVO> returnVOs = (List<AnneeUniversitaireVO>) executeCommand(vos, command,
					sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean activerAnneeUniversitaire(AnneeUniversitaireWebBean webBean) {
		String command = Constantes.COMMAND_GERER_ANNEE_UNIVERSITAIRE;
		String sousCommand = Constantes.SOUS_COMMAND_ACTIVER_ANNEE_UNIVERSITAIRE;
		List<AnneeUniversitaireVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (AnneeUniversitaireVO vo : vos) {
				vo.setStatut(EntityStatus.ENABLED);
			}

			List<AnneeUniversitaireVO> returnVOs = (List<AnneeUniversitaireVO>) executeCommand(vos, command,
					sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}

		return error;
	}

	@Override
	public boolean supprimerAnneeUniversitaire(AnneeUniversitaireWebBean webBean) {
		String command = Constantes.COMMAND_GERER_ANNEE_UNIVERSITAIRE;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_ANNEE_UNIVERSITAIRE;
		AnneeUniversitaireVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		AnneeUniversitaireVO returnVO = (AnneeUniversitaireVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean modifierAnneeUniversitaire(AnneeUniversitaireWebBean webBean) {
		String command = Constantes.COMMAND_GERER_ANNEE_UNIVERSITAIRE;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_ANNEE_UNIVERSITAIRE;
		AnneeUniversitaireVO vo = webBean.getVo();
		AnneeUniversitaireVO returnVO = (AnneeUniversitaireVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	/******************** MotifOpposition ****************************/
	@Override
	public boolean creerMotifOpposition(MotifOppositionWebBean webBean) {
		String command = Constantes.COMMAND_GERER_MOTIF_OPPOSITION;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_MOTIF_OPPOSITION;
		MotifOppositionVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.ENABLED);
		MotifOppositionVO returnVO = (MotifOppositionVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean supprimerCollectionMotifOpposition(MotifOppositionWebBean webBean) {
		String command = Constantes.COMMAND_GERER_MOTIF_OPPOSITION;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_COLLECTION_MOTIF_OPPOSITION;
		List<MotifOppositionVO> vos = webBean.getSelectedVOs();
		if (!webBean.getSelectedVOs().isEmpty()) {
			for (MotifOppositionVO vo : vos) {
				vo.setStatut(EntityStatus.DELETED);
			}

			List<MotifOppositionVO> returnVOs = (List<MotifOppositionVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean desactiverMotifOpposition(MotifOppositionWebBean webBean) {
		String command = Constantes.COMMAND_GERER_MOTIF_OPPOSITION;
		String sousCommand = Constantes.SOUS_COMMAND_DESACTIVER_MOTIF_OPPOSITION;
		List<MotifOppositionVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (MotifOppositionVO vo : vos) {
				vo.setStatut(EntityStatus.DISABLED);
			}

			List<MotifOppositionVO> returnVOs = (List<MotifOppositionVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean activerMotifOpposition(MotifOppositionWebBean webBean) {
		String command = Constantes.COMMAND_GERER_MOTIF_OPPOSITION;
		String sousCommand = Constantes.SOUS_COMMAND_ACTIVER_MOTIF_OPPOSITION;
		List<MotifOppositionVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (MotifOppositionVO vo : vos) {
				vo.setStatut(EntityStatus.ENABLED);
			}

			List<MotifOppositionVO> returnVOs = (List<MotifOppositionVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}

		return error;
	}

	@Override
	public boolean supprimerMotifOpposition(MotifOppositionWebBean webBean) {
		String command = Constantes.COMMAND_GERER_MOTIF_OPPOSITION;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_MOTIF_OPPOSITION;
		MotifOppositionVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		MotifOppositionVO returnVO = (MotifOppositionVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean modifierMotifOpposition(MotifOppositionWebBean webBean) {
		String command = Constantes.COMMAND_GERER_MOTIF_OPPOSITION;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_MOTIF_OPPOSITION;
		MotifOppositionVO vo = webBean.getVo();
		MotifOppositionVO returnVO = (MotifOppositionVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	/******************** MotifMainLevee ****************************/
	@Override
	public boolean creerMotifMainLevee(MotifMainLeveeWebBean webBean) {
		String command = Constantes.COMMAND_GERER_MOTIF_MAIN_LEVEE;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_MOTIF_MAIN_LEVEE;
		MotifMainLeveeVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.ENABLED);
		MotifMainLeveeVO returnVO = (MotifMainLeveeVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean supprimerCollectionMotifMainLevee(MotifMainLeveeWebBean webBean) {
		String command = Constantes.COMMAND_GERER_MOTIF_MAIN_LEVEE;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_COLLECTION_MOTIF_MAIN_LEVEE;
		List<MotifMainLeveeVO> vos = webBean.getSelectedVOs();
		if (!webBean.getSelectedVOs().isEmpty()) {
			for (MotifMainLeveeVO vo : vos) {
				vo.setStatut(EntityStatus.DELETED);
			}

			List<MotifMainLeveeVO> returnVOs = (List<MotifMainLeveeVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean desactiverMotifMainLevee(MotifMainLeveeWebBean webBean) {
		String command = Constantes.COMMAND_GERER_MOTIF_MAIN_LEVEE;
		String sousCommand = Constantes.SOUS_COMMAND_DESACTIVER_MOTIF_MAIN_LEVEE;
		List<MotifMainLeveeVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (MotifMainLeveeVO vo : vos) {
				vo.setStatut(EntityStatus.DISABLED);
			}

			List<MotifMainLeveeVO> returnVOs = (List<MotifMainLeveeVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean activerMotifMainLevee(MotifMainLeveeWebBean webBean) {
		String command = Constantes.COMMAND_GERER_MOTIF_MAIN_LEVEE;
		String sousCommand = Constantes.SOUS_COMMAND_ACTIVER_MOTIF_MAIN_LEVEE;
		List<MotifMainLeveeVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (MotifMainLeveeVO vo : vos) {
				vo.setStatut(EntityStatus.ENABLED);
			}

			List<MotifMainLeveeVO> returnVOs = (List<MotifMainLeveeVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}

		return error;
	}

	@Override
	public boolean supprimerMotifMainLevee(MotifMainLeveeWebBean webBean) {
		String command = Constantes.COMMAND_GERER_MOTIF_MAIN_LEVEE;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_MOTIF_MAIN_LEVEE;
		MotifMainLeveeVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		MotifMainLeveeVO returnVO = (MotifMainLeveeVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean modifierMotifMainLevee(MotifMainLeveeWebBean webBean) {
		String command = Constantes.COMMAND_GERER_MOTIF_MAIN_LEVEE;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_MOTIF_MAIN_LEVEE;
		MotifMainLeveeVO vo = webBean.getVo();
		MotifMainLeveeVO returnVO = (MotifMainLeveeVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	/******************** CategoriePorteur ****************************/
	@Override
	public boolean creerCategoriePorteur(CategoriePorteurWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CATEGORIE_PORTEUR;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_CATEGORIE_PORTEUR;
		CategoriePorteurVO vo = webBean.getVo();
		vo.setDated(webBean.getVo().getDated());
		vo.setDatef(webBean.getVo().getDatef());
		vo.setStatut(EntityStatus.ENABLED);
		CategoriePorteurVO returnVO = (CategoriePorteurVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean supprimerCollectionCategoriePorteur(CategoriePorteurWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CATEGORIE_PORTEUR;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_COLLECTION_CATEGORIE_PORTEUR;
		List<CategoriePorteurVO> vos = webBean.getSelectedVOs();
		if (!webBean.getSelectedVOs().isEmpty()) {
			for (CategoriePorteurVO vo : vos) {
				vo.setStatut(EntityStatus.DELETED);
			}

			List<CategoriePorteurVO> returnVOs = (List<CategoriePorteurVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean desactiverCategoriePorteur(CategoriePorteurWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CATEGORIE_PORTEUR;
		String sousCommand = Constantes.SOUS_COMMAND_DESACTIVER_CATEGORIE_PORTEUR;
		List<CategoriePorteurVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (CategoriePorteurVO vo : vos) {
				vo.setStatut(EntityStatus.DISABLED);
			}

			List<CategoriePorteurVO> returnVOs = (List<CategoriePorteurVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean activerCategoriePorteur(CategoriePorteurWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CATEGORIE_PORTEUR;
		String sousCommand = Constantes.SOUS_COMMAND_ACTIVER_CATEGORIE_PORTEUR;
		List<CategoriePorteurVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (CategoriePorteurVO vo : vos) {
				vo.setStatut(EntityStatus.ENABLED);
			}

			List<CategoriePorteurVO> returnVOs = (List<CategoriePorteurVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}

		return error;
	}

	@Override
	public boolean supprimerCategoriePorteur(CategoriePorteurWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CATEGORIE_PORTEUR;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_CATEGORIE_PORTEUR;
		CategoriePorteurVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		CategoriePorteurVO returnVO = (CategoriePorteurVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean modifierCategoriePorteur(CategoriePorteurWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CATEGORIE_PORTEUR;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_CATEGORIE_PORTEUR;
		CategoriePorteurVO vo = webBean.getVo();
		CategoriePorteurVO returnVO = (CategoriePorteurVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	/******************** ParametreGeneral ****************************/
	@Override
	public boolean creerParametreGeneral(ParametreGeneralWebBean webBean) {
		String command = Constantes.COMMAND_GERER_PARAMETRE_GENERAL;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_PARAMETRE_GENERAL;
		ParametreGeneralVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.ENABLED);
		ParametreGeneralVO returnVO = (ParametreGeneralVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean supprimerCollectionParametreGeneral(ParametreGeneralWebBean webBean) {
		String command = Constantes.COMMAND_GERER_PARAMETRE_GENERAL;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_COLLECTION_PARAMETRE_GENERAL;
		List<ParametreGeneralVO> vos = webBean.getSelectedVOs();
		if (!webBean.getSelectedVOs().isEmpty()) {
			for (ParametreGeneralVO vo : vos) {
				vo.setStatut(EntityStatus.DELETED);
			}

			List<ParametreGeneralVO> returnVOs = (List<ParametreGeneralVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean desactiverParametreGeneral(ParametreGeneralWebBean webBean) {
		String command = Constantes.COMMAND_GERER_PARAMETRE_GENERAL;
		String sousCommand = Constantes.SOUS_COMMAND_DESACTIVER_PARAMETRE_GENERAL;
		List<ParametreGeneralVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (ParametreGeneralVO vo : vos) {
				vo.setStatut(EntityStatus.DISABLED);
			}

			List<ParametreGeneralVO> returnVOs = (List<ParametreGeneralVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean activerParametreGeneral(ParametreGeneralWebBean webBean) {
		String command = Constantes.COMMAND_GERER_PARAMETRE_GENERAL;
		String sousCommand = Constantes.SOUS_COMMAND_ACTIVER_PARAMETRE_GENERAL;
		List<ParametreGeneralVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (ParametreGeneralVO vo : vos) {
				vo.setStatut(EntityStatus.ENABLED);
			}

			List<ParametreGeneralVO> returnVOs = (List<ParametreGeneralVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}

		return error;
	}

	@Override
	public boolean supprimerParametreGeneral(ParametreGeneralWebBean webBean) {
		String command = Constantes.COMMAND_GERER_PARAMETRE_GENERAL;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_PARAMETRE_GENERAL;
		ParametreGeneralVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		ParametreGeneralVO returnVO = (ParametreGeneralVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean modifierParametreGeneral(ParametreGeneralWebBean webBean) {
		String command = Constantes.COMMAND_GERER_PARAMETRE_GENERAL;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_PARAMETRE_GENERAL;
		ParametreGeneralVO vo = webBean.getVo();
		ParametreGeneralVO returnVO = (ParametreGeneralVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean delivrerCarte(CycleVieWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CYCLE_VIE;
		String sousCommand = Constantes.SOUS_COMMAND_DELIVRER_CYCLE_VIE;
		CycleVieVO vo = webBean.getVo();
		// vo.setStatut(EntityStatus.DILVRED);
		// vo.setStatut(EntityStatus.DILVRED);
		CycleVieVO returnVO = (CycleVieVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean delivrerCollectionCarte(CycleVieWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CYCLE_VIE;
		String sousCommand = Constantes.SOUS_COMMAND_DELIVRER_COLLECTION_CYCLE_VIE;
		List<CycleVieVO> vos = webBean.getSelectedVOs();
		if (!webBean.getSelectedVOs().isEmpty()) {
//			for (CycleVieVO vo : vos) {
//				vo.setStatut(EntityStatus.DILVRED);
//			}
			List<CycleVieVO> returnVOs = (List<CycleVieVO>) executeCommand(vos, command, sousCommand);

			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	/******************** Tourniquet ****************************/
	@Override
	public boolean creerTourniquet(TourniquetWebBean webBean) {
		String command = Constantes.COMMAND_GERER_TOURNIQUET;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_TOURNIQUET;
		TourniquetVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.ENABLED);
		TourniquetVO returnVO = (TourniquetVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean supprimerCollectionTourniquet(TourniquetWebBean webBean) {
		String command = Constantes.COMMAND_GERER_TOURNIQUET;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_COLLECTION_TOURNIQUET;
		List<TourniquetVO> vos = webBean.getSelectedVOs();
		if (!webBean.getSelectedVOs().isEmpty()) {
			for (TourniquetVO vo : vos) {
				vo.setStatut(EntityStatus.DELETED);
			}

			List<TourniquetVO> returnVOs = (List<TourniquetVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean desactiverTourniquet(TourniquetWebBean webBean) {
		String command = Constantes.COMMAND_GERER_TOURNIQUET;
		String sousCommand = Constantes.SOUS_COMMAND_DESACTIVER_TOURNIQUET;
		List<TourniquetVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (TourniquetVO vo : vos) {
				vo.setStatut(EntityStatus.DISABLED);
			}

			List<TourniquetVO> returnVOs = (List<TourniquetVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean activerTourniquet(TourniquetWebBean webBean) {
		String command = Constantes.COMMAND_GERER_TOURNIQUET;
		String sousCommand = Constantes.SOUS_COMMAND_ACTIVER_TOURNIQUET;
		List<TourniquetVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (TourniquetVO vo : vos) {
				vo.setStatut(EntityStatus.ENABLED);
			}

			List<TourniquetVO> returnVOs = (List<TourniquetVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}

		return error;
	}

	@Override
	public boolean supprimerTourniquet(TourniquetWebBean webBean) {
		String command = Constantes.COMMAND_GERER_TOURNIQUET;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_TOURNIQUET;
		TourniquetVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		TourniquetVO returnVO = (TourniquetVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean modifierTourniquet(TourniquetWebBean webBean) {
		String command = Constantes.COMMAND_GERER_TOURNIQUET;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_TOURNIQUET;
		TourniquetVO vo = webBean.getVo();
		TourniquetVO returnVO = (TourniquetVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	/******************** Equipement ****************************/
	@Override
	public boolean creerEquipement(EquipementWebBean webBean) {
		String command = Constantes.COMMAND_GERER_EQUIPEMENT;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_EQUIPEMENT;
		EquipementVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.ENABLED);
		EquipementVO returnVO = (EquipementVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean supprimerCollectionEquipement(EquipementWebBean webBean) {
		String command = Constantes.COMMAND_GERER_EQUIPEMENT;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_COLLECTION_EQUIPEMENT;
		List<EquipementVO> vos = webBean.getSelectedVOs();
		if (!webBean.getSelectedVOs().isEmpty()) {
			for (EquipementVO vo : vos) {
				vo.setStatut(EntityStatus.DELETED);
			}

			List<EquipementVO> returnVOs = (List<EquipementVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean desactiverEquipement(EquipementWebBean webBean) {
		String command = Constantes.COMMAND_GERER_EQUIPEMENT;
		String sousCommand = Constantes.SOUS_COMMAND_DESACTIVER_EQUIPEMENT;
		List<EquipementVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (EquipementVO vo : vos) {
				vo.setStatut(EntityStatus.DISABLED);
			}

			List<EquipementVO> returnVOs = (List<EquipementVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean activerEquipement(EquipementWebBean webBean) {
		String command = Constantes.COMMAND_GERER_EQUIPEMENT;
		String sousCommand = Constantes.SOUS_COMMAND_ACTIVER_EQUIPEMENT;
		List<EquipementVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (EquipementVO vo : vos) {
				vo.setStatut(EntityStatus.ENABLED);
			}

			List<EquipementVO> returnVOs = (List<EquipementVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}

		return error;
	}

	@Override
	public boolean supprimerEquipement(EquipementWebBean webBean) {
		String command = Constantes.COMMAND_GERER_EQUIPEMENT;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_EQUIPEMENT;
		EquipementVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		EquipementVO returnVO = (EquipementVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean modifierEquipement(EquipementWebBean webBean) {
		String command = Constantes.COMMAND_GERER_EQUIPEMENT;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_EQUIPEMENT;
		EquipementVO vo = webBean.getVo();
		EquipementVO returnVO = (EquipementVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	/**************************** Caissier ********************************/
	@Override
	public boolean creeCaissier(CaissierWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CAISSIER;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_CAISSIER;
		CaissierVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.ENABLED);
		CaissierVO returnVO = (CaissierVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean supprimerCollectionCaissier(CaissierWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CAISSIER;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_COLLECTION_CAISSIER;
		List<CaissierVO> vos = webBean.getSelectedVOs();
		if (!webBean.getSelectedVOs().isEmpty()) {
			for (CaissierVO vo : vos) {
				vo.setStatut(EntityStatus.DELETED);
			}
			List<CaissierVO> returnVOs = (List<CaissierVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean desactiverCaissier(CaissierWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CAISSIER;
		String sousCommand = Constantes.SOUS_COMMAND_DESACTIVER_CAISSIER;
		List<CaissierVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (CaissierVO vo : vos) {
				vo.setStatut(EntityStatus.DISABLED);
			}

			List<CaissierVO> returnVOs = (List<CaissierVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean activerCaissier(CaissierWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CAISSIER;
		String sousCommand = Constantes.SOUS_COMMAND_ACTIVER_CAISSIER;
		List<CaissierVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (CaissierVO vo : vos) {
				vo.setStatut(EntityStatus.ENABLED);
			}
			List<CaissierVO> returnVOs = (List<CaissierVO>) executeCommand(vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}

		return error;
	}

	@Override
	public boolean supprimerCaissier(CaissierWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CAISSIER;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_CAISSIER;
		CaissierVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		CaissierVO returnVO = (CaissierVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean modifierCaissier(CaissierWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CAISSIER;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_CAISSIER;
		CaissierVO vo = webBean.getVo();
		CaissierVO returnVO = (CaissierVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean personnaliserCaissier(CaissierWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CAISSIER;
		String sousCommand = Constantes.SOUS_COMMAND_PERSONNALISER_CAISSIER;
		CaissierVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.PERSONALIZED);
		CaissierVO returnVO = (CaissierVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	/**************************** Critere ********************************/
	@Override
	public boolean creeCritere(CritereWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CRITERE;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_CRITERE;
		CritereVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.ENABLED);
		CritereVO returnVO = (CritereVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean supprimerCritere(CritereWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CRITERE;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_CRITERE;
		CritereVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		CritereVO returnVO = (CritereVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean modifierCritere(CritereWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CRITERE;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_CRITERE;
		CritereVO vo = webBean.getVo();
		CritereVO returnVO = (CritereVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean creeNoteCritere(NoteCritereWebBean webBean) {
		String command = Constantes.COMMAND_GERER_NOTE_CRITERE;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_NOTE_CRITERE;
		NoteCritereVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.ENABLED);
		NoteCritereVO returnVO = (NoteCritereVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean supprimerNoteCritere(NoteCritereWebBean webBean) {
		String command = Constantes.COMMAND_GERER_NOTE_CRITERE;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_NOTE_CRITERE;
		NoteCritereVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		NoteCritereVO returnVO = (NoteCritereVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean modifierNoteCritere(NoteCritereWebBean webBean) {
		String command = Constantes.COMMAND_GERER_NOTE_CRITERE;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_NOTE_CRITERE;
		NoteCritereVO vo = webBean.getVo();
		NoteCritereVO returnVO = (NoteCritereVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	/************************ Borne **********************/
	@Override
	public boolean creeBorne(BorneWebBean webBean) {
		String command = Constantes.COMMAND_GERER_BORNE;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_BORNE;
		BorneVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.ENABLED);
		BorneVO returnVO = (BorneVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean supprimerBorne(BorneWebBean webBean) {
		String command = Constantes.COMMAND_GERER_BORNE;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_BORNE;
		BorneVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		BorneVO returnVO = (BorneVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean modifierBorne(BorneWebBean webBean) {
		String command = Constantes.COMMAND_GERER_BORNE;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_BORNE;
		BorneVO vo = webBean.getVo();
		BorneVO returnVO = (BorneVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean mettreEnOpposition(CycleVieWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CYCLE_VIE;
		String sousCommand = Constantes.SOUS_COMMAND_METTRE_EN_OPPOSITION;
		CycleVieVO vo = webBean.getVo();
		vo.setDateOperation(new Date());
		vo.setStatut(EntityStatus.ENABLED);
		// vo.setStatut(EntityStatus.DILVRED);
		CycleVieVO returnVO = (CycleVieVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean delivrer_Carte(CarteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CYCLE_VIE;
		String sousCommand = Constantes.SOUS_COMMAND_DELIVRER_CYCLE_VIE;
		CarteVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELIVRED);
		// vo.setStatut(EntityStatus.DILVRED);
		CarteVO returnVO = (CarteVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean delivrerCollectionCarte(CarteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CARTE;
		String sousCommand = Constantes.SOUS_COMMAND_DELIVRER_LOT;
		List<CarteVO> vos = webBean.getVoLot();

		for (CarteVO vo : vos) {
			vo.setStatut(EntityStatus.DELIVRED);
		}
		List<CarteVO> returnVOs = (List<CarteVO>) executeCommand(vos, command, sousCommand);

		return error;
	}

	/*********************************************************************************************************************/
	/***********************
	 * PARTIE OCP /
	 *********************************************************************************************************************/

	@Override
	public boolean creerPersonnel(PersonnelWebBean webBean) {

		String command = Constantes.COMMAND_GERER_PERSONNEL;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_PERSONNEL;
		PersonnelVO vo = webBean.getVo();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		System.out.println(formatter.format(date));
		vo.setDateEmbauche(date);
		CarteNapsVO mtr = referentielService.findCarteNapsByMatricule(webBean.getVo().getMatr());
		vo.setNumCarte(mtr.getNumcarte());
		vo.setStatut(EntityStatus.PERSONALIZED);
		PersonnelVO returnVO = (PersonnelVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean supprimerPersonnel(PersonnelWebBean webBean) {
		String command = Constantes.COMMAND_GERER_PERSONNEL;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_PERSONNEL;
		PersonnelVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		PersonnelVO returnVO = (PersonnelVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean supprimerCollectionPersonnel(PersonnelWebBean webBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifierPersonnel(PersonnelWebBean webBean) {
		String command = Constantes.COMMAND_GERER_PERSONNEL;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_PERSONNEL;
		PersonnelVO vo = webBean.getVo();
		PersonnelVO pvo = referentielService.findPersonnelByMatr(vo.getMatr());
		if (pvo.getStatut() == EntityStatus.ENABLED) {
			vo.setStatut(EntityStatus.ENABLED);
		}
		if (pvo.getStatut() == EntityStatus.PERSONALIZED) {
			vo.setStatut(EntityStatus.PERSONALIZED);
		}
		CarteNapsVO mtr = referentielService.findCarteNapsByMatricule(webBean.getVo().getMatr());
		vo.setNumCarte(mtr.getNumcarte());
		vo.setDateEmbauche(pvo.getDateEmbauche());
		PersonnelVO returnVO = (PersonnelVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean modifierPersonnelMass(PersonnelVO vo) {
		String command = Constantes.COMMAND_GERER_PERSONNEL;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_PERSONNEL;
		PersonnelVO returnVO = (PersonnelVO) executeCommand(vo, command, sousCommand);
		if (!error) {

		}
		return error;
	}

	@Override
	public boolean validerCollectionPersonnel(PersonnelWebBean webBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validatePersonnel(PersonnelWebBean webBean) {
		String command = Constantes.COMMAND_GERER_PERSONNEL;
		String sousCommand = Constantes.SOUS_COMMAND_VALIDATE_PERSONNEL;
		PersonnelVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.VALIDATED);
		PersonnelVO returnVO = (PersonnelVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean validatePersonnelOp(PersonnelWebBean webBean) {
		String command = Constantes.COMMAND_GERER_PERSONNEL;
		String sousCommand = Constantes.SOUS_COMMAND_VALIDATE_PERSONNEL_OPP;
		PersonnelVO vo = webBean.getVo();

		String sequence = "";
		sequence = vo.getNumCarte().replaceAll(147851 + "" + String.format("%010d", Integer.parseInt(vo.getMatr())),
				"");
		if (sequence.equals("")) {
			vo.setNumCarte(147851 + "" + String.format("%010d", vo.getId()));
		} else {
			sequence = Integer.parseInt(vo.getNumCarte().substring(0, 8)) + 1 + "" + String.format("%08d", vo.getId());
			vo.setNumCarte(sequence);
		}
		vo.setStatut(EntityStatus.VALIDATED);
		PersonnelVO returnVO = (PersonnelVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean desactiverPersonnel(PersonnelWebBean webBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean personnaliserPersonnel(PersonnelWebBean webBean) {
		String command = Constantes.COMMAND_GERER_PERSONNEL;
		String sousCommand = Constantes.SOUS_COMMAND_PERSONNALISER_PERSONNEL;
		PersonnelVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.PERSONALIZED);
		PersonnelVO returnVO = (PersonnelVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean creerAdherent(AdherentWebBean webBean) {
		String command = Constantes.COMMAND_GERER_ADHERENT;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_ADHERENT;
		AdherentVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.VALIDATED);
//		vo.setNumCarte(147851 + ""
//		+ String.format("%010d", vo.getId()));
		AdherentVO returnVO = (AdherentVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean supprimerAdherent(AdherentWebBean webBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimerCollectionAdherent(AdherentWebBean webBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifierAdherent(AdherentWebBean webBean) {
		String command = Constantes.COMMAND_GERER_ADHERENT;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_ADHERENT;
		AdherentVO vo = webBean.getVo();
		AdherentVO returnVO = (AdherentVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean validerCollectionAdherent(AdherentWebBean webBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateAdherent(AdherentWebBean webBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean desactiverAdherent(AdherentWebBean webBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean personnaliserAdherent(AdherentWebBean webBean) {
		String command = Constantes.COMMAND_GERER_ADHERENT;
		String sousCommand = Constantes.SOUS_COMMAND_PERSONNALISER_ADHERENT;
		AdherentVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.PERSONALIZED);
		AdherentVO returnVO = (AdherentVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean creerDetailProfil(DetailProfilWebBean webBean) {
		String command = Constantes.COMMAND_GERER_DETAILPROFIL;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_DETAILPROFIL;
		DetailProfilVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.ENABLED);
		DetailProfilVO returnVO = (DetailProfilVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean supprimerCollectionDetailProfil(DetailProfilWebBean webBean) {
		String command = Constantes.COMMAND_GERER_DETAILPROFIL;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_DETAILPROFIL;
		DetailProfilVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		DetailProfilVO returnVO = (DetailProfilVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean supprimerDetailProfil(DetailProfilWebBean webBean) {
		String command = Constantes.COMMAND_GERER_DETAILPROFIL;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_DETAILPROFIL;
		DetailProfilVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		DetailProfilVO returnVO = (DetailProfilVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean modifierDetailProfil(DetailProfilWebBean webBean) {
		String command = Constantes.COMMAND_GERER_DETAILPROFIL;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_DETAILPROFIL;
		DetailProfilVO vo = webBean.getVo();
		DetailProfilVO returnVO = (DetailProfilVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean creerProduit(ProduitWebBean webBean) {
		String command = Constantes.COMMAND_GERER_PRODUIT;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_PRODUIT;
		ProduitVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.ENABLED);
		ProduitVO returnVO = (ProduitVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean supprimerCollectionProduit(ProduitWebBean webBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimerProduit(ProduitWebBean webBean) {
		String command = Constantes.COMMAND_GERER_PRODUIT;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_PRODUIT;
		ProduitVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		ProduitVO returnVO = (ProduitVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean modifierProduit(ProduitWebBean webBean) {
		String command = Constantes.COMMAND_GERER_PRODUIT;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_PRODUIT;
		ProduitVO vo = webBean.getVo();
		ProduitVO returnVO = (ProduitVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean modifierStatusProduit(ProduitWebBean webBean) {
		String command = Constantes.COMMAND_GERER_PRODUIT;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_PRODUIT;
		ProduitVO vo = webBean.getVo();
		if (vo.getStatut().equals(EntityStatus.ENABLED)) {
			vo.setStatut(EntityStatus.DISABLED);
		} else {
			vo.setStatut(EntityStatus.ENABLED);
		}
		ProduitVO returnVO = (ProduitVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean rechargerPersonnel(PersonnelWebBean webBean) {
		String command = Constantes.COMMAND_GERER_PERSONNEL;
		String sousCommand = Constantes.SOUS_COMMAND_RECHARGER_PERSONNEL;
		PersonnelVO vo = webBean.getVo();
		// vo.setStatut(EntityStatus.VALIDATED);
		PersonnelVO returnVO = (PersonnelVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean creerEvenement(EvenementWebBean webBean) {
		String command = Constantes.COMMAND_GERER_EVENEMENT;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_EVENEMENT;
		EvenementVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.ENABLED);
		EvenementVO returnVO = (EvenementVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean supprimerCollectionEvenement(EvenementWebBean webBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimerEvenement(EvenementWebBean webBean) {
		String command = Constantes.COMMAND_GERER_EVENEMENT;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_EVENEMENT;
		EvenementVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		EvenementVO returnVO = (EvenementVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean modifierEvenement(EvenementWebBean webBean) {
		String command = Constantes.COMMAND_GERER_EVENEMENT;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_EVENEMENT;
		EvenementVO vo = webBean.getVo();
		EvenementVO returnVO = (EvenementVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean mettreCartePersoEnOpposition(OppositionWebBean webBean) {
//		String command = Constantes.COMMAND_GERER_CARTE;
//		String sousCommand = Constantes.SOUS_COMMAND_METTRE_CARTE_PERSO_EN_OPPOSITION;
		String command = Constantes.COMMAND_GERER_PERSONNEL;
		String sousCommand = Constantes.SOUS_COMMAND_METTRE_PERSONNEL_OPP;
		CarteVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.OPPOSED);
		CarteVO returnVO = (CarteVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}

		return error;
	}

	@Override
	public boolean cartePersoMainLevee(OppositionWebBean webBean) {
		String command = Constantes.COMMAND_GERER_PERSONNEL;
		String sousCommand = Constantes.SOUS_COMMAND_CARTE_PERSO_MAIN_LEVEE;
		CarteVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.PERSONALIZED);
		CarteVO returnVO = (CarteVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean mettreCarteAdhEnOpposition(OppositionAdhWebBean webBeanAdh) {
		String command = Constantes.COMMAND_GERER_ADHERENT;
		String sousCommand = Constantes.SOUS_COMMAND_METTRE_ADHERENT_OPP;
		AdherentVO vo = webBeanAdh.getVo();
		vo.setStatut(EntityStatus.OPPOSED);
		AdherentVO returnVO = (AdherentVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBeanAdh.setVo(returnVO);
		}

		return error;
	}

	@Override
	public boolean carteAdhMainLevee(OppositionAdhWebBean webBeanAdh) {
		String command = Constantes.COMMAND_GERER_ADHERENT;
		String sousCommand = Constantes.SOUS_COMMAND_CARTE_ADH_MAIN_LEVEE;
		AdherentVO vo = webBeanAdh.getVo();
		vo.setStatut(EntityStatus.VALIDATED);
		AdherentVO returnVO = (AdherentVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBeanAdh.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean validateAdherentOp(AdherentWebBean webBeanAdh) {
		String command = Constantes.COMMAND_GERER_ADHERENT;
		String sousCommand = Constantes.SOUS_COMMAND_VALIDATE_ADHERENT_OPP;
		AdherentVO vo = webBeanAdh.getVo();

		String sequence = "";
		sequence = vo.getNumCarte().replaceAll(147851 + "" + String.format("%010d", Integer.parseInt(vo.getMatr())),
				"");
		if (sequence.equals("")) {
			vo.setNumCarte(147851 + "" + String.format("%010d", vo.getId()));
		} else {
			sequence = Integer.parseInt(vo.getNumCarte().substring(0, 8)) + 1 + "" + String.format("%08d", vo.getId());
			vo.setNumCarte(sequence);
		}
		vo.setStatut(EntityStatus.VALIDATED);
		AdherentVO returnVO = (AdherentVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBeanAdh.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean creerCarteNaps(CarteNapsVO vo, User user) {
		String command = Constantes.COMMAND_GERER_CARTENAPS;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_CARTENAPS;

		CarteNapsVO returnVO = (CarteNapsVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			vo = returnVO;
		}
		return error;
	}

	@Override
	public boolean creerProfilPorteur(ProfilPorteurWebBean webBean) {
		String command = Constantes.COMMAND_GERER_PROFIL_PORTEUR;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_PROFIL_PORTEUR;
		ProfilPorteurVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.ENABLED);
		ProfilPorteurVO returnVO = (ProfilPorteurVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean modifierProfilPorteur(ProfilPorteurWebBean webBean) {
		String command = Constantes.COMMAND_GERER_PROFIL_PORTEUR;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_PROFIL_PORTEUR;
		ProfilPorteurVO vo = webBean.getVo();
		ProfilPorteurVO returnVO = (ProfilPorteurVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean supprimerProfilPorteur(ProfilPorteurWebBean webBean) {
		String command = Constantes.COMMAND_GERER_PROFIL_PORTEUR;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_PROFIL_PORTEUR;
		ProfilPorteurVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		ProfilPorteurVO returnVO = (ProfilPorteurVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean ajoutMassImportPerso(CarteNapsVO vo) {
		String command = Constantes.COMMAND_GERER_CARTENAPS;
		String sousCommand = Constantes.SOUS_COMMAND_MODIFIER_CARTENAPS;
		vo.setStatut(EntityStatus.DISABLED);
		CarteNapsVO returnVO = (CarteNapsVO) executeCommand(vo, command, sousCommand);
		if (!error) {

		}
		return error;
	}

	@Override
	public boolean creerPersoFromCarteNaps(PersonnelVO vo) {
		String command = Constantes.COMMAND_GERER_PERSONNEL;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_PERSONNEL;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		System.out.println(formatter.format(date));
		vo.setDateEmbauche(date);
		PersonnelVO returnVO = (PersonnelVO) executeCommand(vo, command, sousCommand);
		if (!error) {

		}
		return error;
	}

	@Override
	public boolean modifierCarteNaps(CarteNapsVO vo) {
		String command = Constantes.COMMAND_GERER_CARTENAPS;
		String sousCommand = Constantes.SOUS_COMMAND_MODIFIER_CARTENAPS;
		CarteNapsVO returnVO = (CarteNapsVO) executeCommand(vo, command, sousCommand);
		if (!error) {

		}
		return error;
	}

	@Override
	public boolean creerFiliere(FiliereWebBean webBean) {
		String command = Constantes.COMMAND_GERER_FILIERE;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_FILIERE;
		FiliereVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.ENABLED);
		FiliereVO returnVO = (FiliereVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	/**
	 * Modifier Filiere.
	 * 
	 * @param webBean the web bean
	 * @return true, if successful
	 */
	@Override
	public boolean modifierFiliere(FiliereWebBean webBean) {
		String command = Constantes.COMMAND_GERER_FILIERE;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_FILIERE;
		FiliereVO vo = webBean.getVo();
		FiliereVO returnVO = (FiliereVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	/**
	 * Supprimer Filiere.
	 * 
	 * @param webBean the web bean
	 * @return true, if successful
	 */
	@Override
	public boolean supprimerFiliere(FiliereWebBean webBean) {
		String command = Constantes.COMMAND_GERER_FILIERE;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_FILIERE;
		FiliereVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		FiliereVO returnVO = (FiliereVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@Override
	public boolean creerMonitoringEchange(InscriptionWebBean webBean) {
		String command = Constantes.COMMAND_GERER_MONITORING_ECHANGE;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_MONITORING_ECHANGE;

		MonitoringEchangeVO rvo = (MonitoringEchangeVO) executeCommand(webBean.getVo(), command, sousCommand);

		if (!error) {
			webBean.setVo(rvo);
		}
		return error;
	}

	@Override
	public boolean creerInscription(List<InscriptionVO> list, User user) {
		String command = Constantes.COMMAND_GERER_INSCRIPTION;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_INSCRIPTION;
		executeCommandThreadSeperated(list, command, sousCommand, user);

		return error;
	}

	@Override
	public boolean creerImportInscription(List<ImportInscriptionVO> list, User user) {
		String command = Constantes.COMMAND_GERER_IMPORT_INSCRIPTION;
		String sousCommand = Constantes.SOUS_COMMAND_IMPORT_INSCRIPTION;
		executeCommandThreadSeperated(list, command, sousCommand, user);

		return error;
	}

	@Override
	public boolean creerEtudiantByInscription(List<EtudiantVO> list, User user) {
		String command = Constantes.COMMAND_GERER_ETUDIANT_INSCRIPTION;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_ETUDIANT_INSCRIPTION;
		executeCommandThreadSeperated(list, command, sousCommand, user);
		return error;
	}
	
	@Override
	public boolean mettreCarteEnOpposition(OppositionWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CARTE;
		String sousCommand = Constantes.SOUS_COMMAND_METTRE_CARTE_EN_OPPOSITION;
		CarteVO vo = webBean.getVo();
				
		CarteVO returnVO = (CarteVO) executeCommand(vo, command,
				sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		
		return error;
	}
	 
	@Override
	public boolean AddSolde(SoldeWebBean webBean) {
		String command = Constantes.COMMAND_GERER_SOLDE;
		String sousCommand = Constantes.SOUS_COMMAND_METTRE_AJOURS;
		SoldeVO vo = webBean.getVo();
				
		SoldeVO returnVO = (SoldeVO) executeCommand(vo, command,
				sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		
		return error;
	}
	@Override
	public boolean validerDemandeAdmin(DemandeAdminWebBean webBean) {
		String command = Constantes.COMMAND_GERER_ETUDIANT;
		String sousCommand = Constantes.SOUS_COMMAND_VALIDATE_ETUDIANT;
		DemandeAdminVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.VALIDATED);
		DemandeAdminVO returnVO = (DemandeAdminVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;

	}
	
	@Override
	public boolean rejeterDemandeAdmin(DemandeAdminWebBean webBean) {
		String command = Constantes.COMMAND_GERER_ETUDIANT;
		String sousCommand = Constantes.SOUS_COMMAND_VALIDATE_ETUDIANT;
		DemandeAdminVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.REJECTED);
		DemandeAdminVO returnVO = (DemandeAdminVO) executeCommand(vo, command, sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;

	}

	/*********************************************************************************************************************/
	/***********************
	 * Fin PARTIE OFPPT /
	 *********************************************************************************************************************/
}
