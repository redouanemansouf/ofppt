/*
 * GererCanalVente.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.uc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.dao.CarteDaoJpa;
import com.m2m.onousc.business.referentiel.dao.CycleVieDaoJpa;
import com.m2m.onousc.business.referentiel.dao.PersonnelDaoJpa;
import com.m2m.onousc.business.referentiel.model.Carte;
import com.m2m.onousc.business.referentiel.model.CarteNaps;
import com.m2m.onousc.business.referentiel.model.CycleVie;
import com.m2m.onousc.business.referentiel.model.Personnel;
import com.m2m.onousc.business.referentiel.rule.PersonnelBusinessRuleManager;
import com.m2m.onousc.business.referentiel.service.AdministrationService;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.technicalservices.core.IBusinessRuleManager;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.core.UseCaseController;
import com.m2m.technicalservices.core.UserContext;
import com.m2m.technicalservices.spring.BeansLookuper;

/**
 * The Class GererCanalVente.
 * 
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
@Service("REFERENTIEL_GererPersonnel_UC")
public class GererPersonnel extends UseCaseController {
	
	ReferentielService referentielService = (ReferentielService) BeansLookuper
			.lookup("referentielService");

	@Autowired
	CarteDaoJpa carteDaoJpa;
	
	@Autowired
	CycleVieDaoJpa cycleVieDaoJpa;
	
	@Autowired
	PersonnelDaoJpa personnelDaoJpa;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.technicalservices.core.UseCaseController#getBusinessRuleManager()
	 */
	@Override
	protected IBusinessRuleManager getBusinessRuleManager() {
		return new PersonnelBusinessRuleManager();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.core.UseCaseController#business()
	 */
	@Override
	protected ProcessResult business() {
		if (UserContext.getClientParameters().getSousCommand()
				.equals(Constantes.SOUS_COMMAND_PERSONNALISER_PERSONNEL)) {
			Carte carte = new Carte();
			Personnel subjet = (Personnel) UserContext.getSubject();
			//carte.setNumPorteur(subjet);
			carte.setNumSerie((subjet.getId() * 43) + "");
			carte.setOperation("Fabrication");
//			carte.setNumeroCarte(147851 + ""
//					+ String.format("%010d", Integer.parseInt(subjet.getMatr())) + "0");
			carte.setNumeroCarte(147851 + ""
					+ String.format("%010d", subjet.getId()));
			carte.setOperateur(subjet.getMatr());
		//	carte.setDateExpiration(subjet.getAnneeUniversitaire().getDate_fin());
			carte.setStatut(EntityStatus.ENABLED);
//			carte.setSolde(0.0);
			carteDaoJpa.persist(carte);

		}
		
		
		if (UserContext.getClientParameters().getSousCommand()
				.equals(Constantes.SOUS_COMMAND_PERSONNALISER_PERSONNEL)) {

			CycleVie cycleVie = new CycleVie();
			Personnel subjet = (Personnel) UserContext.getSubject();
			cycleVie.setDateOperation(new Date());
			cycleVie.setOperateur(subjet.getMatr());
			cycleVie.setNumSerie((subjet.getId() * 43) + "");
			cycleVie.setOperation("Fabrication");
			cycleVie.setStatut(EntityStatus.ENABLED);
			cycleVieDaoJpa.persist(cycleVie);
			
		}
		
		
		if (UserContext.getClientParameters().getSousCommand()
				.equals(Constantes.SOUS_COMMAND_PERSONNALISER_PERSONNEL)) {

			List<String> params=new ArrayList<String>();
			Personnel subjet = (Personnel) UserContext.getSubject();
			
			String fichier="C:\\Carte_OCP\\Divers\\Params.txt";
				
			try{
				
				InputStream ips=new FileInputStream(fichier); 
				InputStreamReader ipsr=new InputStreamReader(ips);
				BufferedReader br=new BufferedReader(ipsr);
				String ligne;
				while ((ligne=br.readLine())!=null){
					System.out.println(ligne);
					params.add(ligne);
				}
				
				br.close(); 
				File file=new File(fichier);
				file.delete();
			}		
			catch (Exception e){
				System.out.println(e.toString());
			}
				subjet.setUid(params.get(0));
				subjet.setNumCarte(params.get(1));
			personnelDaoJpa.getEm().merge(subjet);
			
		}
		
		if (UserContext.getClientParameters().getSousCommand()
				.equals(Constantes.SOUS_COMMAND_VALIDATE_PERSONNEL_OPP)) {

			
			CycleVie cycleVie = new CycleVie();
			Personnel subjet = (Personnel) UserContext.getSubject();
			cycleVie.setDateOperation(new Date());
			cycleVie.setOperateur(subjet.getMatr());
			cycleVie.setNumSerie(subjet.getNumCarte());
			cycleVie.setOperation("Refabrication");
			cycleVie.setStatut(EntityStatus.ENABLED);
			cycleVieDaoJpa.persist(cycleVie);
			
			Carte carte = new Carte();
			
			carte.setNumSerie((subjet.getId() * 43) + "");
			carte.setOperation("Refabrication");
			carte.setNumeroCarte(subjet.getNumCarte());
			carte.setOperateur(subjet.getMatr());
			carte.setStatut(EntityStatus.ENABLED);
			carteDaoJpa.persist(carte);			
			
			
		}		
		
		if (UserContext.getClientParameters().getSousCommand()
				.equals(Constantes.SOUS_COMMAND_METTRE_PERSONNEL_OPP)) {

			
			CycleVie cycleVie = new CycleVie();
			Personnel subjet = (Personnel) UserContext.getSubject();
			cycleVie.setDateOperation(new Date());
			cycleVie.setOperateur(subjet.getMatr());
			cycleVie.setNumSerie(subjet.getNumCarte());
			cycleVie.setOperation("Opposition");
			cycleVie.setStatut(EntityStatus.ENABLED);
			cycleVieDaoJpa.persist(cycleVie);
			
			Carte carte = new Carte();

			carte.setNumSerie((subjet.getId() * 43) + "");
			carte.setOperation("Opposition");
			carte.setNumeroCarte(subjet.getNumCarte());
			carte.setOperateur(subjet.getMatr());
			carte.setStatut(EntityStatus.ENABLED);
			carteDaoJpa.persist(carte);
			
			
		}		
		
		if (UserContext.getClientParameters().getSousCommand()
				.equals(Constantes.SOUS_COMMAND_CARTE_PERSO_MAIN_LEVEE)) {

			
			CycleVie cycleVie = new CycleVie();
			Personnel subjet = (Personnel) UserContext.getSubject();
			cycleVie.setDateOperation(new Date());
			cycleVie.setOperateur(subjet.getMatr());
			cycleVie.setNumSerie(subjet.getNumCarte());
			cycleVie.setOperation("Main levee");
			cycleVie.setStatut(EntityStatus.ENABLED);
			cycleVieDaoJpa.persist(cycleVie);
			
			Carte carte = new Carte();

			carte.setNumSerie((subjet.getId() * 43) + "");
			carte.setOperation("Main levee");
			carte.setNumeroCarte(subjet.getNumCarte());
			carte.setOperateur(subjet.getMatr());
			carte.setStatut(EntityStatus.ENABLED);
			carteDaoJpa.persist(carte);
			
			
		}
		if (UserContext.getClientParameters().getSousCommand()
				.equals(Constantes.SOUS_COMMAND_CREER_PERSONNEL)) {

			
			Personnel subjet = (Personnel) UserContext.getSubject();
			CarteNaps naps = referentielService.findCarteNapsByMatricule(subjet.getMatr());
			
			naps.setStatut(EntityStatus.DISABLED);
			 em.merge(naps);
			
			
		}
	return null;
	}

}
