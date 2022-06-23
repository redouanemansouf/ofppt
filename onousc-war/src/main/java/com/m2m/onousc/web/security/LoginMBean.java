/*
 * LoginMBean.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.security;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

import com.m2m.onousc.business.referentiel.dao.SiteDaoJpa;
import com.m2m.onousc.business.referentiel.dao.UserEntityDaoJpa;
import com.m2m.onousc.business.referentiel.model.Site;
import com.m2m.technicalservices.core.User;
import com.m2m.technicalservices.security.UserEntity;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.tools.ConvertUtil;
import com.m2m.technicalservices.tools.DateUtil;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;
import com.m2m.technicalservices.web.UserSession;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginMBean.
 *
 * @version 1.0 24 nov. 2014
 * @author aelhachimi
 */
@ManagedBean
@ViewScoped
public class LoginMBean extends BaseMBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3321709864106072685L;

	/** The user name. */
	private String userName;

	/** The password. */
	private String password;

	private String chaineLastAccess;
	
	private String nomPage;
	private UserEntityDaoJpa userEntityDaoJpa= (UserEntityDaoJpa) BeansLookuper
			.lookup("userDao");
	@Override
	public void init(){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = request.getSession(false);
		boolean loginURLs = request.getRequestURI().endsWith("login.xhtml") || request.getRequestURI().equals("/mxcampus/");
		if(loginURLs &&(session!= null && session.getAttribute("userSession") != null)){ 
			JSFUtils.redirect("/mxcampus/pages/espaces.xhtml?faces-redirect=true");
			LastAccessedDate();
			
		}
		
		
		
		if (JSFUtils.getCurentUrlView().contains("gestionPersonnel.xhtml"))  { 
			
			this.setNomPage("ENROLEMENT PERSONNEL");
			
		}
		
		if (JSFUtils.getCurentUrlView().contains("majPersonnel.xhtml"))  { 
			
			this.setNomPage("ENROLEMENT PERSONNEL");
			
		}

		if (JSFUtils.getCurentUrlView().contains("listeEnrolement.xhtml"))  { 
	
			this.setNomPage("GESTION DES ENROLEMENTS");
	
		}
		
		if (JSFUtils.getCurentUrlView().contains("listeImported.xhtml"))  { 
			
			this.setNomPage("GESTION DES ENROLEMENTS");
	
		}

		if (JSFUtils.getCurentUrlView().contains("listerFamProduit.xhtml"))  { 
	
			this.setNomPage("GESTION DES VENTES");
	
		}

		if (JSFUtils.getCurentUrlView().contains("listerProduit.xhtml"))  { 
	
			this.setNomPage("GESTION DES VENTES");
	
		}

		if (JSFUtils.getCurentUrlView().contains("consultRecharge.xhtml"))  { 
	
			this.setNomPage("CONSULTATION DES OPERATIONS");
	
		}

		if (JSFUtils.getCurentUrlView().contains("listerRestaurant.xhtml"))  { 
	
			this.setNomPage("GESTION DES RESTAURANTS");
	
		}

		if (JSFUtils.getCurentUrlView().contains("listerCaisse.xhtml"))  { 
	
			this.setNomPage("GESTION DES RESTAURANTS");
	
		}

		if (JSFUtils.getCurentUrlView().contains("listerCaissier.xhtml"))  { 
	
			this.setNomPage("GESTION DES RESTAURANTS");
	
		}

		if (JSFUtils.getCurentUrlView().contains("listerOppoPerso.xhtml"))  { 
	
			this.setNomPage("OPPOSITION PERSONNEL");
	
		}
		
		if (JSFUtils.getCurentUrlView().contains("import.xhtml"))  { 
			
			this.setNomPage("IMPORT PERSONNEL");
	
		}
		
		if (JSFUtils.getCurentUrlView().contains("liste.xhtml"))  { 
			
			this.setNomPage("IMPORT PERSONNEL");
	
		}
		
		if (JSFUtils.getCurentUrlView().contains("browse.xhtml"))  { 
			
			this.setNomPage("IMPORT PERSONNEL");
	
		}
		
		if (JSFUtils.getCurentUrlView().contains("gestionProfilPorteur.xhtml"))  { 
			
			this.setNomPage("GESTION PROFIL PORTEUR");
	
		}
		
		if (JSFUtils.getCurentUrlView().contains("ConsultSolde.xhtml"))  { 
			
			this.setNomPage("CONSULTATION SOLDE");
	
		}
		
		if (JSFUtils.getCurentUrlView().contains("listerUserEntity.xhtml"))  { 
			
			this.setNomPage("ADMINISTRATION DU SYSTEME");
	
		}
		
		if (JSFUtils.getCurentUrlView().contains("listerWinMenu.xhtml"))  { 
			
			this.setNomPage("ADMINISTRATION DU SYSTEME");
	
		}
		
		if (JSFUtils.getCurentUrlView().contains("listerTrace.xhtml"))  { 
			
			this.setNomPage("ADMINISTRATION DU SYSTEME");
	
		}
	}
	/**
	 * Do login.
	 *
	 * @return the string
	 * @throws Exception 
	 */
	public String doLogin() throws Exception {
		AuthenticationManager authenticationManager = (AuthenticationManager) BeansLookuper
				.lookup("authenticationManager");
		try {
			String pwd = userEntityDaoJpa.encrypt(getPassword());   
//			String pwd = getPassword();   
			Authentication request = new UsernamePasswordAuthenticationToken(
					this.getUserName(),pwd );
			Authentication result = authenticationManager.authenticate(request);
			SecurityContextHolder.getContext().setAuthentication(result);
		} catch (AuthenticationException e) { 

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Utilisateur ou mot de passe incorrect"));
			return null;
		}
		// create bean UerSession
		UserSession userSesion = new UserSession();
		User user = new User();
		user.setCode(userName);
		//user.setLibelle(libelle);
		userSesion.setUserConecte(user);
		UserEntity userEntity = userEntityDaoJpa.findByCode(userName);
		SiteDaoJpa SiteDaoJpa= (SiteDaoJpa) BeansLookuper
				.lookup("siteDaoJpa");
		if(userEntity.getSite() !=null) {
		Site site = SiteDaoJpa.find(userEntity.getSite());
		user.setSite(site.getLibelle());
		}
		userSesion.setUserConecte(user);
		JSFUtils.putSession("userSession", userSesion); 
		if(isTheFirstTime() || isPWDChangedThreeMAgo()){
			return "/public/inscription.xhtml?faces-redirect=true";
		}  
		LastAccessedDate();
		return "/pages/espaces.xhtml?faces-redirect=true";   
		
	}

	private boolean isPWDChangedThreeMAgo() {
		//UserEntity user = userEntityDaoJpa.findByCode(userName);
		//Date pwdAffectation = user.getPwdAffectation();
		//if(pwdAffectation==null) return true;  
		//Date date = DateUtil.addMois(pwdAffectation, 3);
		//if((new Date()).after(date)) return true; 
		return false;
	}

	private boolean isTheFirstTime() {
		UserEntityDaoJpa userEntityDaoJpa= (UserEntityDaoJpa) BeansLookuper
				.lookup("userDao");
		UserEntity user = userEntityDaoJpa.findByCode(userName);
		if(user!=null) return user.isFirstConnection(); 
		return false;
	}


	public void doLogout(){ 
		userName=null;
		UserSession userSesion = null;
		JSFUtils.putSession("userSession", userSesion);
	    SecurityContextHolder.clearContext();
	    FacesContext fc = FacesContext.getCurrentInstance();
	    HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);      

	    fc.getExternalContext().getSessionMap().clear();

	    session.invalidate();   
	    JSFUtils.redirect("/mxcampus/public/login.xhtml?faces-redirect=true");       
	}
	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	
public void LastAccessedDate(){
	
		String d = ConvertUtil.dateToString(new Date(), "d MMM YYYY");
		String h = ConvertUtil.dateToString(new Date(), "HH:mm");
		this.setChaineLastAccess("Le "+d+" à "+h);
		

		}
	
	
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName
	 *            the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password
	 *            the new password
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	public String disconnect()
	{
		 FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	        return "/public/login.xhtml?faces-redirect=true";
	}
	public String getChaineLastAccess() {
		return chaineLastAccess;
	}
	public void setChaineLastAccess(String chaineLastAccess) {
		this.chaineLastAccess = chaineLastAccess;
	}
	public String getNomPage() {
		return nomPage;
	}
	public void setNomPage(String nomPage) {
		this.nomPage = nomPage;
	}
	
	
	
}
