/*
* GererNationalite.java
*
* Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
*/
package com.m2m.onousc.business.referentiel.uc;

import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.dao.GroupUserDaoJpa;
import com.m2m.onousc.business.referentiel.dao.MenuDaoJpa;
import com.m2m.onousc.business.referentiel.dao.UserEntityDaoJpa;
import com.m2m.onousc.business.referentiel.dao.WinMenuDaoJpa;
import com.m2m.onousc.business.referentiel.rule.UserEntityBusinessRuleManager;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.utils.EmailUtility;
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
@Service("ADMINISTRATION_GererUserEntity_UC")
public class GererUserEntity extends UseCaseController {

	/* (non-Javadoc)   
	 * @see com.m2m.technicalServices.core.UseCaseController#getBusinessRuleManager()
	 */
	@Autowired
	WinMenuDaoJpa windaoJpa;

	@Autowired
	MenuDaoJpa mendaoJpa;

	@Autowired
	GroupUserDaoJpa groupUserdao;
	
	@Autowired
	UserEntityDaoJpa userdao;

	
	@Override
	protected IBusinessRuleManager getBusinessRuleManager() {
		return  new UserEntityBusinessRuleManager();
	}

	/* (non-Javadoc)
	 * @see com.m2m.technicalServices.core.UseCaseController#business()
	 */
	@Override
	protected ProcessResult business() {
		UserEntity subjet = (UserEntity) UserContext.getSubject();
		if(UserContext.getClientParameters().getSousCommand().equals("creerUserEntity")){
			//creation winmenu
			subjet.setFirstConnection(true);
			subjet.setPwdAffectation(new Date());
			createWinMenuForUser(); 
			Envoyer_Mail(subjet.getUsername(), subjet.getPassword(), subjet.getEmail());
		}
		if(UserContext.getClientParameters().getSousCommand().equals(Constantes.SOUS_COMMAND_CHANGEPWD_USER_ENTITY)|| 
					UserContext.getClientParameters().getSousCommand().equals("creerUserEntity")){
			try {
				subjet.setPassword(userdao.encrypt(subjet.getPassword()));
				subjet.setStatut(EntityStatus.ENABLED.toString());  
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
		}

		if(UserContext.getClientParameters().getSousCommand().equals(Constantes.SOUS_COMMAND_SUPPRIMER_USER_ENTITY)){
			deleteAssociatedWinMenus();
		}  
		return null;
	}
	
	
	 private void createWinMenuForUser() {
		UserEntity subjet = (UserEntity) UserContext.getSubject();
		List<WinMenu>  winMenus = windaoJpa.findWinMenuByGroup(subjet.getGroupname());
		for (WinMenu winMenu : winMenus) {
			WinMenu newWin = new WinMenu(winMenu);
			newWin.setOperateur(subjet.getUsername());
			newWin.setType("O");
			winMenu.setStatut(EntityStatus.ENABLED.toString());   
			windaoJpa.persist(newWin);  
		}
		 
//		windaoJpa.persist(new WinMenu("000001", "REF", "REFERENTIEL", null, subjet.getUsername(), "type"));
//		windaoJpa.persist(new WinMenu("000002", "ENRET", "ENROLLEMENT ETUDIANT", null, subjet.getUsername(), "type"));
//		windaoJpa.persist(new WinMenu("000003", "RES", "RESERVATION", null, subjet.getUsername(), "type"));
//		windaoJpa.persist(new WinMenu("000004", "CYC", "GESTION DE CYCLE DE VIE", null, subjet.getUsername(), "type"));
//		windaoJpa.persist(new WinMenu("000005", "ADM", "ADMINISTRATION DU SYSTÈME", null, subjet.getUsername(), "type"));
//		windaoJpa.persist(new WinMenu("000006", "DEL", "DÉLIVRANCE DES CARTES", null, subjet.getUsername(), "type"));
//		windaoJpa.persist(new WinMenu("000007", "LOG", "LOG ET TRAÇABILITÉ", null, subjet.getUsername(), "type")); 
//		windaoJpa.persist(new WinMenu("000008", "EDI", "EDITION", null, subjet.getUsername(), "type"));     
		
		
	}

	void Envoyer_Mail(String Login,String Password,String mail)
	 {
		ReferentielService referentielService = (ReferentielService) BeansLookuper
				.lookup("referentielService");
			List<String> data = referentielService.getDataMessagerie();
			String host=data.get(0);
			String port=data.get(1);
			String userName=data.get(2);
			String password=data.get(3); 
		
			String message="<fond color=#0A1875>Bonjour, </fond><br>";
			message+="<br>";
			message+="<br>";
			message+="<fond color=#0A1875>Vous  trouvez ci dessous votre Login et mot de passe pour accéder votre espace MXCAMPUS benguerir </fond><br>";
			message+="<br>";
			message+="Login  :"+Login+"<br>";
			message+="Mot de passe    :"+Password+"<br>";
			message+="<br>";
			message+=" <b>Cordialement, </b>  <br>";
//			message +="<b> SERVICE SOCIAL OCP </b> <br>";
			message+="<br>";
	
			message+="<fond color=#0A1875>Cet email est généré automatiquement , veuillez ne pas répondre </fond>";
		
		
			
			
			String recep[] ={mail}; 
			
			try { 
				EmailUtility.sendEmail(host, port, userName, password,recep, "Service université benguerir : données d'authentification", message,null);
		
			} catch (AddressException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			} catch (GeneralSecurityException e) {
				e.printStackTrace();
			}

	 }


	
	private void deleteAssociatedWinMenus(){
		List<WinMenu> winmenus= windaoJpa.findAll();
		UserEntity subject = (UserEntity) UserContext.getSubject();
		for (WinMenu winMenu : winmenus) {
			if(subject.getUsername().equals(winMenu.getOperateur())){
				winMenu.setStatut(EntityStatus.DELETED.toString());  
				windaoJpa.persist(winMenu);  
			}
		}
	}
	
}  
