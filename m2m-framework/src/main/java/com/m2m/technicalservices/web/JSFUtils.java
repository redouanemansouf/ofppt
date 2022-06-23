package com.m2m.technicalservices.web;

import java.io.IOException;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.context.RequestContext;

public class JSFUtils {

	private static final String SCRIPT_OPEN_POPUP = "window.open('%s', '%s', 'scrollbars=yes,resizable=yes,width=%s,height=%s,menubar=no,toolbar=no').moveTo(400,0);";

	private JSFUtils() {
	}

	public static void put(String key, Object value) {
		(FacesContext.getCurrentInstance().getExternalContext().getRequestMap())
				.put(key, value);
	}

	public static Object get(String key) {
		return (FacesContext.getCurrentInstance().getExternalContext()
				.getRequestMap()).get(key);
	}

	public static String getParam(String key) {
		return (FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap()).get(key);
	}

	public static Object getViewScopedMBean(final String beanName) {
		Object bean = null;
		try {
			bean = FacesContext.getCurrentInstance().getViewRoot().getViewMap()
					.get(beanName);
		} catch (RuntimeException e) {
			throw new FacesException(e.getMessage(), e);
		}
		return bean;
	}

	public static Object getSessionScopedMBean(final String beanName) {
		Object mBean = null;
		try {
			ExternalContext externalContext = FacesContext.getCurrentInstance()
					.getExternalContext();
			mBean = externalContext.getSessionMap().get(beanName);
		} catch (RuntimeException e) {
			throw new FacesException(e.getMessage(), e);
		}
		return mBean;
	}

	public static void putInView(String key, Object value) {
		FacesContext.getCurrentInstance().getViewRoot().getViewMap()
				.put(key, value);
	}

	public static void putSession(String key, Object value) {
		(FacesContext.getCurrentInstance().getExternalContext().getSessionMap())
				.put(key, value);
	}

	public static Object getSession(String key) {
		Map<String, Object> mapSession = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		Object value = mapSession.get(key);
		return value;
	}

	public static void removeFormSession(String key) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.remove(key);
	}

	public static Object getAndRemoveFromSession(String key) {
		Object value = FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get(key);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.remove(key);
		return value;
	}

	public static Object getFormRequetOrSession(String key) {
		Object obj = get(key);
		if (obj == null) {
			obj = getAndRemoveFromSession(key);
		}
		return obj;
	}

	public static void openWindow(String view, String windowId, int width,
			int height) {
		String absolutView = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestContextPath()
				+ view;
		RequestContext.getCurrentInstance().execute(
				String.format(SCRIPT_OPEN_POPUP, absolutView, windowId, width,
						height));
	}

	/**
	 * method execute context #amtarji
	 */
	public static void contextExecute(String function) {
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute(function);
	}

	public static Flash getFlash() {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getFlash();
	}

	public static void putInFlash(String key, Object value) {
		(FacesContext.getCurrentInstance().getExternalContext().getFlash())
				.put(key, value);
	}

	public static Object getFromFlash(String key) {
		return (FacesContext.getCurrentInstance().getExternalContext()
				.getFlash()).get(key);
	}

	public static void redirect(String url) {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect(url);
		} catch (IOException e) {
		}
	}
	
	public static String getRequestURI(){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		return request.getRequestURI();
	}
	
	
	
	public static String getCurentUrlView() {
		HttpServletRequest origRequest = (HttpServletRequest) (FacesContext
				.getCurrentInstance().getExternalContext().getRequest());
		return origRequest.getRequestURI();
	}

	
	
	
}
