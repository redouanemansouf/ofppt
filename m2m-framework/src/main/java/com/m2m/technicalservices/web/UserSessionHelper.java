package com.m2m.technicalservices.web;

import com.m2m.technicalservices.core.User;

public class UserSessionHelper {

	private UserSessionHelper() {
	}

	public static User getUserConecte() {
		UserSession userSession = (UserSession) JSFUtils
				.getSession("userSession");
		return userSession.getUserConecte();
	}
	
	public static void putSpecificParam(String key, Object data) {
		UserSession userSession = (UserSession) JSFUtils
				.getSession(SpecificParams.USER_SESSION);
		userSession.getSpecificParams().put(key, data);
	}
	
	public static Object getSpecificParam(String paramKey) {
		UserSession userSession = (UserSession) JSFUtils
				.getSession(SpecificParams.USER_SESSION);
		return userSession.getSpecificParams().get(paramKey);
	}
	
}
