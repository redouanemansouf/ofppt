package com.m2m.onousc.web.administration;

import com.m2m.onousc.web.administration.webbean.UserEntityWebBean;

public interface IUserEntityBusDelegate {

	boolean creerUserEntity(UserEntityWebBean webBean);

	boolean supprimerUserEntity(UserEntityWebBean webBean);

	boolean modifierUserEntity(UserEntityWebBean webBean);

	boolean changerPwdForUserEntity(UserEntityWebBean webBean);

}
