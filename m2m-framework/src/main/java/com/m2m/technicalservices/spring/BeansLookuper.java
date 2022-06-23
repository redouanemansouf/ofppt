package com.m2m.technicalservices.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Récupération des services spring par nom du service
 * 
 * @author Younes SOUTEH
 * 
 */
public final class BeansLookuper {

	private static ApplicationContext applicationContext;

	private BeansLookuper() {
	}

	// static {
	// applicationContext = new ClassPathXmlApplicationContext(
	// "classpath*:**/applicationContext.xml");
	//
	//
	// }

	/**
	 * Recuperer un bean depuis le contexte Spring
	 * 
	 * @param nomService
	 * @return
	 */
	public static Object lookup(String name) {
		if (applicationContext == null) {
			applicationContext = new ClassPathXmlApplicationContext(
					"classpath*:**/applicationContext.xml");
		}
		return applicationContext.getBean(name);
	}

	/**
	 * @param appCtx
	 *            the applicationContext to set
	 */
	public static void setApplicationContext(ApplicationContext appCtx) {
		applicationContext = appCtx;
	}
}
