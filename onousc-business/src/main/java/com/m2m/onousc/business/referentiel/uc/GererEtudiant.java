/*
 * GererCanalVente.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.uc;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.dao.CarteDaoJpa;
import com.m2m.onousc.business.referentiel.dao.CycleVieDaoJpa;
import com.m2m.onousc.business.referentiel.dao.SoldeDaoJpa;
import com.m2m.onousc.business.referentiel.dao.UserEntityDaoJpa;
import com.m2m.onousc.business.referentiel.model.Carte;
import com.m2m.onousc.business.referentiel.model.CycleVie;
import com.m2m.onousc.business.referentiel.model.Etudiants;
import com.m2m.onousc.business.referentiel.model.Solde;
import com.m2m.onousc.business.referentiel.rule.CanalVenteBusinessRuleManager;
import com.m2m.onousc.business.referentiel.rule.EtudiantBusinessRuleManager;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.utils.EmailUtility;
import com.m2m.technicalservices.core.IBusinessRuleManager;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.core.UseCaseController;
import com.m2m.technicalservices.core.UserContext;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.tools.StringUtils;
import com.m2m.technicalservices.web.SpecificParams;
import com.m2m.technicalservices.web.UserSessionHelper;

/**
 * The Class GererCanalVente.
 * 
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
@Service("REFERENTIEL_GererEtudiant_UC")
public class GererEtudiant extends UseCaseController {

	@Autowired
	private UserEntityDaoJpa userEntityDaoJpa;

	@Autowired
	private CycleVieDaoJpa cycleVieDaoJpa;

	@Autowired
	private CarteDaoJpa carteDaoJpa;

	ReferentielService referentielService = (ReferentielService) BeansLookuper.lookup("referentielService");
	@Autowired
	private SoldeDaoJpa soldeDaoJpa;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.technicalservices.core.UseCaseController#getBusinessRuleManager()
	 */
	@Override
	protected IBusinessRuleManager getBusinessRuleManager() {
		return new EtudiantBusinessRuleManager();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.core.UseCaseController#business()
	 */
	@Override
	protected ProcessResult business() {

		if (UserContext.getClientParameters().getSousCommand().equals("valideretudiant")) {
			Carte carte = new Carte();
			Etudiants subjet = (Etudiants) UserContext.getSubject();
			carte.setNumPorteur(subjet);
			carte.setNumSerie((subjet.getId() * 43) + "0");
			carte.setOperation("ENCOURS");
			carte.setNumeroCarte(1697 + "" + subjet.getSite().getCode() + subjet.getId() + "0");
			carte.setDateExpiration(subjet.getAnneeUniversitaire().getDate_fin());
			carte.setStatut(EntityStatus.ENABLED);
			carte.setSolde(0.0);
			carteDaoJpa.persist(carte);

		}

		if (UserContext.getClientParameters().getSousCommand().equals(Constantes.SOUS_COMMAND_VALIDATE_ETUDIANT)) {
			CycleVie cycleVie = new CycleVie();
			Etudiants subjet = (Etudiants) UserContext.getSubject();
			cycleVie.setDateOperation(new Date());
			cycleVie.setNumPorteur(subjet);
			cycleVie.setNumSerie((subjet.getId() * 43) + "");
			cycleVie.setOperation("Demande nouvelle carte");
			System.out.println("id" + subjet.getId());

			cycleVie.setOperateur(referentielService.findCarteByEtud(subjet.getId()).getNumeroCarte());
			cycleVie.setStatut(EntityStatus.ENABLED);
			cycleVieDaoJpa.persist(cycleVie);
		}
		if (UserContext.getClientParameters().getSousCommand().equals("Personnaliseretudiant")) {

			CycleVie cycleVie = new CycleVie();
			Etudiants subjet = (Etudiants) UserContext.getSubject();
			cycleVie.setDateOperation(new Date());
			cycleVie.setNumPorteur(subjet);
			cycleVie.setNumSerie((subjet.getId() * 43) + "");
			cycleVie.setOperation("Fabrication");
			cycleVie.setStatut(EntityStatus.ENABLED);
			cycleVie.setOperateur(referentielService.findCarteByEtud(subjet.getId()).getNumeroCarte());

			cycleVieDaoJpa.persist(cycleVie);
			if (subjet.getTypeCarte()!="N")
			{

			Solde sub = new Solde();
			sub.setDate(new Date());
			sub.setInit("0");
			sub.setMaj("0");
			sub.setMatr(subjet.getCodeMassar());
			sub.setNom(subjet.getNom());
			sub.setPrenom(subjet.getPrenom());
			sub.setSite(subjet.getSite());
			soldeDaoJpa.persist(sub);
			}
			// Envoyer_Mail(user.getUsername(), user.getPassword(),
			// user.getEmail());
		}
		if (UserContext.getClientParameters().getSousCommand().equals("Personnaliseretudiant")) {
			String cardUid = (String)UserSessionHelper
					.getSpecificParam(SpecificParams.CARD_UID);
			Carte carte = new Carte();
			Etudiants subjet = (Etudiants) UserContext.getSubject();
			carte = referentielService.findCarteByEtud(subjet.getId());
			carte.setStatut(EntityStatus.PERSONALIZED);
			carte.setNumSerie(cardUid);
			cycleVieDaoJpa.getEm().merge(carte);
			// Envoyer_Mail(user.getUsername(), user.getPassword(),
			// user.getEmail());
		}

		if (UserContext.getClientParameters().getSousCommand().equals("creerEtudiant")) {

			Etudiants subjet = (Etudiants) UserContext.getSubject();
			Envoyer_Mail_Notif(subjet.getEmail());

		}

		if (UserContext.getClientParameters().getSousCommand()
				.equals(Constantes.SOUS_COMMAND_VALIDATE_COLLECTION_ETUDIANT)) {

			Object subject = UserContext.getSubject();
			if (subject instanceof Collection) {
				for (final Object o : (Collection) subject) {
					Etudiants etudiants = (Etudiants) o;
					Carte carte = new Carte();
					carte.setNumPorteur(etudiants);
					carte.setNumSerie((etudiants.getId() * 43) + "");
					carte.setOperation("ENCOURS");
					carte.setNumeroCarte(1697 + "" + etudiants.getSite().getCode() + etudiants.getId() + "0");
					carte.setDateExpiration(etudiants.getAnneeUniversitaire().getDate_fin());
					carte.setStatut(EntityStatus.ENABLED);
					carte.setSolde(0.0);
					carteDaoJpa.persist(carte);
				}
			} else {
				Carte carte = new Carte();
				Etudiants etudiants = (Etudiants) UserContext.getSubject();
				carte.setNumPorteur(etudiants);
				carte.setNumSerie((etudiants.getId() * 43) + "");
				carte.setOperation("ENCOURS");
				carte.setNumeroCarte(1697 + "" + etudiants.getSite().getCode() + etudiants.getId() + "0");
				carte.setDateExpiration(etudiants.getAnneeUniversitaire().getDate_fin());
				carte.setStatut(EntityStatus.ENABLED);
				carte.setSolde(0.0);
				carteDaoJpa.persist(carte);
			}

		}
		if (UserContext.getClientParameters().getSousCommand()
				.equals(Constantes.SOUS_COMMAND_VALIDATE_COLLECTION_ETUDIANT)) {

			Object subject = UserContext.getSubject();
			if (subject instanceof Collection) {
				for (final Object o : (Collection) subject) {
					Etudiants etudiants = (Etudiants) o;
					CycleVie cycleVie = new CycleVie();
					cycleVie.setDateOperation(new Date());
					cycleVie.setNumPorteur(etudiants);
					cycleVie.setNumSerie((etudiants.getId() * 43) + "");
					cycleVie.setOperation("Demande nouvelle carte");
					cycleVie.setOperateur(referentielService.findCarteByEtud(etudiants.getId()).getNumeroCarte());
					cycleVie.setStatut(EntityStatus.ENABLED);
					cycleVieDaoJpa.persist(cycleVie);

				}
			} else {
				CycleVie cycleVie = new CycleVie();
				Etudiants etudiants = (Etudiants) UserContext.getSubject();
				cycleVie.setDateOperation(new Date());
				cycleVie.setNumPorteur(etudiants);
				cycleVie.setNumSerie((etudiants.getId() * 43) + "");
				cycleVie.setOperation("Demande nouvelle carte");
				cycleVie.setStatut(EntityStatus.ENABLED);
				cycleVieDaoJpa.persist(cycleVie);
			}

		}

		if (UserContext.getClientParameters().getSousCommand()
				.equals(Constantes.SOUS_COMMAND_PERSONNALISER_COLLECTION_ETUDIANT)) {

			Object subject = UserContext.getSubject();
			if (subject instanceof Collection) {
				for (final Object o : (Collection) subject) {
					Etudiants etudiants = (Etudiants) o;
					CycleVie cycleVie = new CycleVie();
					cycleVie.setDateOperation(new Date());
					cycleVie.setNumPorteur(etudiants);
					cycleVie.setNumSerie((etudiants.getId() * 43) + "");
					cycleVie.setOperation("Fabrication");
					cycleVie.setOperateur(referentielService.findCarteByEtud(etudiants.getId()).getNumeroCarte());

					cycleVie.setStatut(EntityStatus.ENABLED);
					cycleVieDaoJpa.persist(cycleVie);

				}
			} else {
				CycleVie cycleVie = new CycleVie();
				Etudiants etudiants = (Etudiants) UserContext.getSubject();
				cycleVie.setDateOperation(new Date());
				cycleVie.setNumPorteur(etudiants);
				cycleVie.setNumSerie((etudiants.getId() * 43) + "");
				cycleVie.setOperation("Fabrication");
				cycleVie.setStatut(EntityStatus.ENABLED);
				cycleVie.setOperateur(referentielService.findCarteByEtud(etudiants.getId()).getNumeroCarte());
				cycleVieDaoJpa.persist(cycleVie);
			}

		}
		if (UserContext.getClientParameters().getSousCommand()
				.equals(Constantes.SOUS_COMMAND_PERSONNALISER_COLLECTION_ETUDIANT)) {

			Object subject = UserContext.getSubject();
			if (subject instanceof Collection) {
				int maxLot = 0;
				List<Etudiants> etudsList = new ArrayList<Etudiants>((Collection) subject);
				Etudiants etud_lot = etudsList.get(0);
				System.out.println("CODE****" + etud_lot.getSite().getCode() + "\n");
				System.out.println(referentielService.findMaxLotCarte(etud_lot.getSite().getCode()));

				maxLot = Integer.parseInt(referentielService.findMaxLotCarte(etud_lot.getSite().getCode()).substring(4))
						+ 1;
				for (final Object o : (Collection) subject) {

					Etudiants etudiants = (Etudiants) o;
					Carte carte = new Carte();

					carte = referentielService.findCarteByEtud(etudiants.getId());
					carte.setOperateur(String.format("%04d", etudiants.getSite().getCode()) + "" + maxLot);
					carte.setStatut(EntityStatus.PERSONALIZED);
					carteDaoJpa.getEm().merge(carte);
				}
			} else {
				Carte carte = new Carte();
				Etudiants etudiants = (Etudiants) UserContext.getSubject();
				Carte carte1 = new Carte();
				carte1 = referentielService.findCarteByEtud(etudiants.getId());
				carte.setStatut(EntityStatus.PERSONALIZED);
				carteDaoJpa.getEm().merge(carte1);
			}

		}

		if (UserContext.getClientParameters().getSousCommand().equals(Constantes.SOUS_COMMAND_APPLY_RENEWAL)) {

			Carte carte = null;
			Etudiants subjet = (Etudiants) UserContext.getSubject();
			carte = referentielService.findCarteByEtud(subjet.getId());
			// subjet.setRenouvellement(false);
			subjet.setStatut(EntityStatus.PERSONALIZED);

			// etudiantDaoJpa.persist(subjet);
			// String msg = "<fond color=#0A1875>Votre carte étudiant est prête.
			// </fond><br>";
			// referentielService.Envoyer_Mail_Notif(subjet.getEmail(),
			// subjet.getNdemande(), msg);

			CycleVie cycleVie = new CycleVie();
			cycleVie.setDateOperation(new Date());
			cycleVie.setNumPorteur(subjet);
			cycleVie.setNumSerie(carte.getNumSerie());
			cycleVie.setOperateur(carte.getNumeroCarte());
			cycleVie.setOperation("Renouvellement");
			cycleVie.setStatut(EntityStatus.ENABLED);
			cycleVieDaoJpa.persist(cycleVie);

		}

		if (UserContext.getClientParameters().getSousCommand().equals(Constantes.SOUS_COMMAND_EDITER_ETUDIANT)) {

			Carte carte = null;
			CycleVie cycleVie = new CycleVie();
			Etudiants subjet = (Etudiants) UserContext.getSubject();
			if (!subjet.getStatut().equals(EntityStatus.ENABLED)) {
				carte = referentielService.findCarteByEtud(subjet.getId());

				if (carte != null) {

					carte.setStatut(EntityStatus.SUSPENDED);
					carte.setOperation("MODIFIER");
					carte = carteDaoJpa.getEm().merge(carte);

					cycleVie.setDateOperation(new Date());
					cycleVie.setNumPorteur(subjet);
					cycleVie.setNumSerie(carte.getNumSerie());
					cycleVie.setOperateur(carte.getNumeroCarte());
					cycleVie.setOperation("Modification de la carte");
					cycleVie.setStatut(EntityStatus.ENABLED);
					cycleVieDaoJpa.persist(cycleVie);

					subjet.setStatut(EntityStatus.ENABLED);

				}
			}

			else {
				subjet.setStatut(EntityStatus.ENABLED);
				// subjet = etudiantDaoJpa.getEm().merge(subjet);
			}

		}

		return null;

	}

	void Envoyer_Mail_Notif(String mail) {
		List<String> data = referentielService.getDataConnection();
		String host = data.get(0);
		String port = data.get(2);
		String userName = data.get(1);
		String password = data.get(3);
		String message = "<fond color=#0A1875>Bonjour, </fond><br>";
		message += "<br>";
		message += "<br>";
		message += "<fond color=#0A1875>Votre demande a été  envoyée au service onousc  pour le traitemant . </fond><br>";
		message += "<br>";
		message += "<br>";
		message += " <b>Cordialement, </b>  <br>";
		message += "<b> SERVICE ONOUSC </b> <br>";
		message += "<br>";

		message += "<fond color=#0A1875>Cet email est généré automatiquement ,Veuillez ne pas répondre </fond>";

		String recep[] = { mail };

		try {
			EmailUtility.sendEmail(host, port, userName, password, recep, "Service Onousc", message, null);

		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}

	}

}
