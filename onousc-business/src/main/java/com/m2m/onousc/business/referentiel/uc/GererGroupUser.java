/*
* GererWinMenu.java
*
* Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
*/
package com.m2m.onousc.business.referentiel.uc;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.dao.GroupUserDaoJpa;
import com.m2m.onousc.business.referentiel.dao.UserEntityDaoJpa;
import com.m2m.onousc.business.referentiel.dao.WinMenuDaoJpa;
import com.m2m.onousc.business.referentiel.model.Adherent;
import com.m2m.onousc.business.referentiel.model.Carte;
import com.m2m.onousc.business.referentiel.model.GroupUser;
import com.m2m.onousc.business.referentiel.rule.WinMenuBusinessRuleManager;
import com.m2m.onousc.business.referentiel.service.AdministrationService;
import com.m2m.technicalservices.core.IBusinessRuleManager;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.core.UseCaseController;
import com.m2m.technicalservices.core.UserContext;
import com.m2m.technicalservices.security.UserEntity;
import com.m2m.technicalservices.security.WinMenu;
import com.m2m.technicalservices.spring.BeansLookuper;



/**
 * The Class GererUserEntity.
 *
 * @version 1.0 24 nov. 2014
 * @author iissouani
 */
@Service("ADMINISTRATION_GererGroupUser_UC")
public class GererGroupUser extends UseCaseController {

	AdministrationService administrationService = (AdministrationService) BeansLookuper
			.lookup("administrationService");
	
	@PersistenceContext
    protected EntityManager em;

	
	@Autowired
	WinMenuDaoJpa windaoJpa;
	
	@Autowired
	UserEntityDaoJpa userentityDaoJpa;
	
	@Autowired
	GroupUserDaoJpa groupuserDaoJpa;

	/* (non-Javadoc)   
	 * @see com.m2m.technicalServices.core.UseCaseController#getBusinessRuleManager()
	 */
	@Override
	protected IBusinessRuleManager getBusinessRuleManager() {
		return  new WinMenuBusinessRuleManager();
	}

	/* (non-Javadoc)
	 * @see com.m2m.technicalServices.core.UseCaseController#business()
	 */
	@Override
	protected ProcessResult business() {
		if (UserContext.getClientParameters().getSousCommand()
				.equals(Constantes.SOUS_COMMAND_CREER_GROUP_USER)) {

			GroupUser subjet = (GroupUser) UserContext.getSubject();
			WinMenu creation1 = new WinMenu();
			
			//first page
			creation1.setOperateur(subjet.getGroupname());
			creation1.setAbbrev("UE");
			creation1.setCode("000001");
			creation1.setLibelle("USER ENTITY");
			creation1.setActif(false);
			creation1.setDroitConsult(false);
			creation1.setDroitCreat(false);
			creation1.setDroitModif(false);
			creation1.setDroitSuppr(false);
			creation1.setLangue("FR");
			creation1.setStatut(EntityStatus.ENABLED.toString());
			creation1.setType("G");

			windaoJpa.persist(creation1);

			WinMenu creation2 = new WinMenu();
			//second page
			creation2.setOperateur(subjet.getGroupname());
			creation2.setAbbrev("WING");
			creation2.setCode("000013");
			creation2.setLibelle("GESTION DROIT");
			creation2.setActif(false);
			creation2.setDroitConsult(false);
			creation2.setDroitCreat(false);
			creation2.setDroitModif(false);
			creation2.setDroitSuppr(false);
			creation2.setLangue("FR");
			creation2.setStatut(EntityStatus.ENABLED.toString());
			creation2.setType("G");

			windaoJpa.persist(creation2);

			WinMenu creation3 = new WinMenu();
			//third page
			creation3.setOperateur(subjet.getGroupname());
			creation3.setAbbrev("CSLTS");
			creation3.setCode("000002");
			creation3.setLibelle("CONSULTATION SOLDE");
			creation3.setActif(false);
			creation3.setDroitConsult(false);
			creation3.setDroitCreat(false);
			creation3.setDroitModif(false);
			creation3.setDroitSuppr(false);
			creation3.setLangue("FR");
			creation3.setStatut(EntityStatus.ENABLED.toString());
			creation3.setType("G");
			
			
			windaoJpa.persist(creation3);
			
			WinMenu creation4 = new WinMenu();
			
			//fourth page
			creation4.setOperateur(subjet.getGroupname());
			creation4.setAbbrev("GPP");
			creation4.setCode("000003");
			creation4.setLibelle("GESTION PROFIL PORTEUR");
			creation4.setActif(false);
			creation4.setDroitConsult(false);
			creation4.setDroitCreat(false);
			creation4.setDroitModif(false);
			creation4.setDroitSuppr(false);
			creation4.setLangue("FR");
			creation4.setStatut(EntityStatus.ENABLED.toString());
			creation4.setType("G");
			
			
			windaoJpa.persist(creation4);
			
			WinMenu creation5 = new WinMenu();
			
			//fifth page
			creation5.setOperateur(subjet.getGroupname());
			creation5.setAbbrev("IP");
			creation5.setCode("000004");
			creation5.setLibelle("IMPORT PERSONNEL");
			creation5.setActif(false);
			creation5.setDroitConsult(false);
			creation5.setDroitCreat(false);
			creation5.setDroitModif(false);
			creation5.setDroitSuppr(false);
			creation5.setLangue("FR");
			creation5.setStatut(EntityStatus.ENABLED.toString());
			creation5.setType("G");
			
			
			windaoJpa.persist(creation5);
			
			WinMenu creation6 = new WinMenu();
			
			//sixth page
			creation6.setOperateur(subjet.getGroupname());
			creation6.setAbbrev("OP");
			creation6.setCode("000005");
			creation6.setLibelle("OPPOSITION PERSONNEL");
			creation6.setActif(false);
			creation6.setDroitConsult(false);
			creation6.setDroitCreat(false);
			creation6.setDroitModif(false);
			creation6.setDroitSuppr(false);
			creation6.setLangue("FR");
			creation6.setStatut(EntityStatus.ENABLED.toString());
			creation6.setType("G");
			
			
			windaoJpa.persist(creation6);
			
			WinMenu creation7 = new WinMenu();
			
			//seventh page
			creation7.setOperateur(subjet.getGroupname());
			creation7.setAbbrev("GR");
			creation7.setCode("000006");
			creation7.setLibelle("GESTION RESTAURANT");
			creation7.setActif(false);
			creation7.setDroitConsult(false);
			creation7.setDroitCreat(false);
			creation7.setDroitModif(false);
			creation7.setDroitSuppr(false);
			creation7.setLangue("FR");
			creation7.setStatut(EntityStatus.ENABLED.toString());
			creation7.setType("G");
			
			
			windaoJpa.persist(creation7);
			
			WinMenu creation8 = new WinMenu();
			
			//eight page
			creation8.setOperateur(subjet.getGroupname());
			creation8.setAbbrev("CDO");
			creation8.setCode("000007");
			creation8.setLibelle("CONSULTATION DES OPERATIONS");
			creation8.setActif(false);
			creation8.setDroitConsult(false);
			creation8.setDroitCreat(false);
			creation8.setDroitModif(false);
			creation8.setDroitSuppr(false);
			creation8.setLangue("FR");
			creation8.setStatut(EntityStatus.ENABLED.toString());
			creation8.setType("G");
			
			
			windaoJpa.persist(creation8);
			
			WinMenu creation9 = new WinMenu();
			
			//nine page
			creation9.setOperateur(subjet.getGroupname());
			creation9.setAbbrev("GDV");
			creation9.setCode("000008");
			creation9.setLibelle("GESTION DES VENTES");
			creation9.setActif(false);
			creation9.setDroitConsult(false);
			creation9.setDroitCreat(false);
			creation9.setDroitModif(false);
			creation9.setDroitSuppr(false);
			creation9.setLangue("FR");
			creation9.setStatut(EntityStatus.ENABLED.toString());
			creation9.setType("G");
			
			
			windaoJpa.persist(creation9);
			
			WinMenu creation10 = new WinMenu();
			
			//tenth page
			creation10.setOperateur(subjet.getGroupname());
			creation10.setAbbrev("GDE");
			creation10.setCode("000009");
			creation10.setLibelle("GESTION DES ENROLEMENTS");
			creation10.setActif(false);
			creation10.setDroitConsult(false);
			creation10.setDroitCreat(false);
			creation10.setDroitModif(false);
			creation10.setDroitSuppr(false);
			creation10.setLangue("FR");
			creation10.setStatut(EntityStatus.ENABLED.toString());
			creation10.setType("G");
			
			
			windaoJpa.persist(creation10);
			
			WinMenu creation11 = new WinMenu();

			
//			//eleventh page
			creation11.setOperateur(subjet.getGroupname());
			creation11.setAbbrev("GDP");
			creation11.setCode("000011");
			creation11.setLibelle("ENROLLEMENT PERSONNEL");
			creation11.setActif(false);
			creation11.setDroitConsult(false);
			creation11.setDroitCreat(false);
			creation11.setDroitModif(false);
			creation11.setDroitSuppr(false);
			creation11.setLangue("FR");
			creation11.setStatut(EntityStatus.ENABLED.toString());
			creation11.setType("G");
			
			
			windaoJpa.persist(creation11);
		
			
			

		}
		
		if (UserContext.getClientParameters().getSousCommand()
				.equals(Constantes.SOUS_COMMAND_MODIFIER_GROUP_USER)) {
			
			GroupUser subjet = (GroupUser) UserContext.getSubject();
			
			
			
			List<UserEntity> users = administrationService.findUserByGroup(subjet.getLibelle());
			
			List<WinMenu> winmenus = administrationService.findWinMenuByGroupList(subjet.getLibelle());
			
			if(users.size() != 0)
			{
				List<UserEntity> modifiedUsers = new ArrayList<UserEntity>();

				
				for(int i = 0 ; i>=users.size() ; i++)
				{
					modifiedUsers.get(i).setGroupname(subjet.getGroupname());
					
                    em.merge(modifiedUsers.get(i));
				}
			}
			if(winmenus.size() != 0)
			{
				List<WinMenu> modifiedWinMenus = new ArrayList<WinMenu>();

				
				for(int i = 0 ; i>=winmenus.size() ; i++)
				{
					modifiedWinMenus.get(i).setOperateur(subjet.getGroupname());
					
                    em.merge(modifiedWinMenus.get(i));
				}
			}
			
			
			
		}
		return null;
	}
	


}  
