package com.m2m.technicalservices.core;

import java.util.HashMap;
import java.util.Map;

import javax.validation.groups.Default;

public class UserContext {

	private Map map = new HashMap();

	private static ThreadLocal threadLocal = new ThreadLocal() {
		@Override
		protected UserContext initialValue() {
			return  new UserContext();
		}
	};

	public UserContext() {
		super();
		Class<?>[] groups = {Default.class};
		map.put("vGroups", groups);
	}

	public static UserContext get() {
		return (UserContext) threadLocal.get();
	}

	public static void setSubject(Object subject) {
		get().map.put("subject", subject);
	}

	public static Object getSubject() {
		return get().map.get("subject");
	}

	public static void setClientParameters(ClientParameters params) {
		get().map.put("params", params);
	}

	public static ClientParameters getClientParameters() {
		return (ClientParameters) get().map.get("params");
	}

	public static void setEm(Object em) {
		get().map.put("em", em);
	}

	public static Object getEm() {
		return get().map.get("em");
	}

	/**
	 * Ajout des groupes pour le validateur correspondant au annotations de
	 * validation ajouter au niveau des VO
	 * 
	 * @author amtarji
	 * @param em
	 */
	public static void setValidationGroups(Class<?>[] groups) {
		get().map.put("vGroups", groups);
	}

	public static Object getValidationGroups() {
		return get().map.get("vGroups");
	}

}
