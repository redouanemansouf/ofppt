/*
 * AdministrationMBean.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.administration.mbean;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.criteria.UserEntityCriteria;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.business.utils.EmailUtility;
import com.m2m.onousc.business.utils.RandomStringGenerator;
import com.m2m.onousc.business.utils.Utils;
import com.m2m.onousc.web.administration.impl.UserEntityBusDelegate;
import com.m2m.onousc.web.administration.webbean.UserEntityWebBean;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.technicalservices.core.User;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.tools.StringUtils;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;
import com.m2m.technicalservices.web.UserSession;
import com.m2m.technicalservices.web.UserSessionHelper;

/**
 * The Class AdministrationMBean.
 * 
 * @version 1.0 9 oct. 2015
 * 
 * @author iissouani
 *
 */
@ManagedBean
@ViewScoped
public class UserEntityMBean extends BaseMBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -148933612381819373L;

	private UserEntityWebBean webBean = new UserEntityWebBean();

	/** The referentiel service. */
	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");

	public String getUserConnecte() {
		String user = UserSessionHelper.getUserConecte().getCode();
		return user == null ? "" : user;
	}

	public void init() {
		webBean = new UserEntityWebBean();
		webBean.setGroups(referentielService.findAllgroup());
		webBean.setListSite(referentielService.findAllSite());

	}

	public void resetWebBeanVO() {
		webBean.setVo(new UserEntityVO());
	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<UserEntityVO>());
	}

	/**
	 * Creer.
	 */
	public void creer() {
		clearReport();
		UserEntityBusDelegate delegate = new UserEntityBusDelegate();
		error = delegate.creerUserEntity(webBean);
		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_CREATE_1", null);
			JSFUtils.contextExecute("_hideDialog()");
		}
		feedReport();
	}

	/**
	 * Modifier
	 */
	public void modifier() {
		clearReport();
		UserEntityBusDelegate delegate = new UserEntityBusDelegate();
		webBean.getVo().setPassword1(webBean.getVo().getPassword());
		error = delegate.modifierUserEntity(webBean);
		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_EDIT", null);
			JSFUtils.contextExecute("_hideDialog()");
		}
		feedReport();
	}

	/**
	 * Supprimer
	 */
	public void supprimer() {
		clearReport();
		UserEntityBusDelegate delegate = new UserEntityBusDelegate();
		error = delegate.supprimerUserEntity(webBean);
		if (error) {
			JSFUtils.contextExecute("_errorDialog()");
		} else {
			addPrezMsgInfo("MESSAGE_SUCCESS_DELETE", null);
		}
		feedReport();
	}

	public void changerPWD() {
		clearReport();
		if (controlePwd())
			return;

		UserEntityVO user = referentielService.findUserByCode(UserSessionHelper.getUserConecte().getCode());
		if (user != null && webBean.getPassword2().equals(user.getPassword())) {
			addCollectorErrorMessage("NEW_PASSWORD_IS_THE_SAME_AS_OLD", null);
			return;
		}
		webBean.setVo(user);
		webBean.getVo().setPassword(webBean.getPassword2());
		webBean.getVo().setPwdAffectation(new Date());
		webBean.getVo().setFirstConnection(false);

		UserEntityBusDelegate delegate = new UserEntityBusDelegate();
		error = delegate.changerPwdForUserEntity(webBean);
		if (!error) {
			addPrezMsgInfo("PWD_SUCCESS_EDIT", null);
			JSFUtils.contextExecute("_hideDialog()");
		}
		feedReport();
		if (!error)
			JSFUtils.redirect("/mxcampus/pages/espaces.xhtml?faces-redirect=true");
	}

	private boolean controlePwd() {
		if (!webBean.getPassword2().equals(webBean.getVo().getPassword1())) {
			addCollectorErrorMessage("PASSWORDS_IS_NOT_THE_SAME");
			return true;
		}

		String errorControle = Utils.controlePWD(webBean.getPassword2());
		if (errorControle == null)
			return false;
		switch (errorControle) {
		case "0":
			addCollectorErrorMessage("PASSWORD_MUST_CONTAIN_BETWEEN620");
			return true;
		case "1":
			addCollectorErrorMessage("PASSWORD_MUST_CONTAIN_BETWEEN620");
			return true;
		case "2":
			addCollectorErrorMessage("PASSWORD_MUST_CONTAIN_ANUMBER");
			return true;
		case "3":
			addCollectorErrorMessage("PASSWORD_MUST_CONTAIN_ALETTER");
			return true;

		default:
			break;
		}

		return false;
	}

	public void getMyPassword() throws Exception {
		String email = webBean.getEmail();
		if (StringUtils.isEmpty(email))
			return;
		UserEntityCriteria userCriteria = new UserEntityCriteria();
		userCriteria.setEmail(email);
		List<UserEntityVO> users = referentielService.findUserByCriteria(userCriteria);
		if (users.size() != 0) {
			UserEntityVO usersgroup = referentielService.findUserByCode(users.get(0).getUsername());
		}
		if (users == null || users.size() == 0) {
			addCollectorErrorMessage("EMAIL_DOESNT_EXIST");
			return;

		}

		UserEntityVO userEntityVO = users.get(0);
		String newpwd = RandomStringGenerator.generateRandomString(8, RandomStringGenerator.Mode.ALPHANUMERIC);
		userEntityVO.setPwdAffectation(new Date());
		userEntityVO.setPassword(newpwd);
		userEntityVO.setFirstConnection(true);
		if (users.size() != 0) {
			UserEntityVO usersgroup = referentielService.findUserByCode(users.get(0).getUsername());
			userEntityVO.setGroupname(usersgroup.getGroupname());
		}

		webBean.setVo(userEntityVO);

		UserEntityBusDelegate delegate = new UserEntityBusDelegate();
		UserSession userSession1 = new UserSession();
		User user = new User();
		user.setCode(userEntityVO.getUsername());
		userSession1.setUserConecte(user);
		JSFUtils.putSession("userSession", userSession1);
		this.userSession = userSession1;
		clearReport();
		error = delegate.changerPwdForUserEntity(webBean);
		Envoyer_Mail(userEntityVO.getUsername(), newpwd, webBean.getEmail());
		feedReport();
		JSFUtils.putSession("userSession", null);
		if (!error)
			JSFUtils.redirect("login.xhtml?faces-redirect=true");
	}

	void Envoyer_Mail(String Login, String Password, String mail) {
		List<String> data = referentielService.getDataMessagerie();
		String host = data.get(0);
		String port = data.get(1);
		String userName = data.get(2);
		String password = data.get(3);

		String message = "<fond color=#0A1875>Bonjour, </fond><br>";
		message += "<br>";
		message += "<br>";
		message += "<fond color=#0A1875>Vous  trouvez ci dessous votre Login et mot de passe pour accéder à votre espace université mohammed 6 polytechnique </fond><br>";
		message += "<br>";
		message += "Login  :" + Login + "<br>";
		message += "Mot de passe    :" + Password + "<br>";
		message += "<br>";
		message += " <b>Cordialement, </b>  <br>";
		message += "<b> SERVICE UM6P </b> <br>";
		message += "<br>";

		message += "<fond color=#0A1875>Cet email est généré automatiquement , veuillez ne pas répondre </fond>";

		String recep[] = { mail };

		try {
			EmailUtility.sendEmail(host, port, userName, password, recep,
					"Service université mohammed 6 polytechnique : données d'authentification", message, null);

		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @return
	 */
	public UserEntityWebBean getWebBean() {
		return webBean;
	}

	/**
	 * @param webBean
	 */
	public void setWebBean(UserEntityWebBean webBean) {
		this.webBean = webBean;
	}

	@Override
	protected boolean isAutorise() {
		if (JSFUtils.getRequestURI().contains("pwdOublie") || JSFUtils.getRequestURI().contains("inscription"))
			return true;
		return hasEcran(Constantes.CODE_ADM_USER_ENTITY);
	}
}
