package com.m2m.technicalservices.web;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import com.m2m.technicalservices.core.ProcessMsg;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.log.ILogger;
import com.m2m.technicalservices.log.impl.SL4JLogger;

public class MessageHelper {

	private static final ILogger LOGGER = SL4JLogger
			.getInstance(MessageHelper.class);

	public static final String PREZ_BUNDLE = "prezmsg";
	public static final String BUS_BUNDLE = "busmsg";

	private MessageHelper() {
	}

	public static void processPrezMesssage(ProcessResult result) {
		processBusinessMesssage(result, PREZ_BUNDLE);
	}

	public static void processPrezMesssage(ProcessMsg msg, int typeMsg) {
		ProcessResult processResult = new ProcessResult();
		processResult.addMessage(msg);
		processResult.setTypeMessage(typeMsg);
		processPrezMesssage(processResult);
	}

	public static void processBusinessMesssage(ProcessResult result) {
		processBusinessMesssage(result, BUS_BUNDLE);
	}

	private static void processBusinessMesssage(ProcessResult result,
			String bundle) {
		List<ProcessMsg> messages = result.getMessages();
		if (messages != null && !messages.isEmpty()) {
			boolean isError = com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR == result
					.getTypeMessage();
			UserSession userSession = (UserSession) JSFUtils
					.getSession("userSession");
			ReportWebBean reportWebBean = userSession.getReport();
			/**
			 * modificiation pour JSF message #amtarji
			 */
			// List<String> listMessages = new ArrayList<String>();
			Map<Severity, String> listMessages = new HashMap<>();
			if (reportWebBean != null) {
				listMessages = reportWebBean.getListMessages();
				// Réinitialier la liste des messages au niveau du report
				// listMessages = new ArrayList<String>();
				if (listMessages == null) {
					// listMessages = new ArrayList<String>();
					listMessages = new HashMap<>();
				}
			}

			for (ProcessMsg processMsg : messages) {
				/*
				 * suite modificiation pour JSF message #amtarji
				 */
				String msg = null;
				if (processMsg.isKeyIsMessage()) {
					msg = processMsg.getKey();
				} else {
					msg = getMessage(processMsg, bundle);
				}
				// listMessages.add(msg);

				listMessages.put(processMsg.getSeverity(), msg);
			}

			userSession.setReport(new ReportWebBean(listMessages, isError));
		}

	}

	private static String getMessage(ProcessMsg processMsg,
			String resourceBundleKey) {
		return getResourceBundleString(processMsg.getKey(),
				processMsg.getInfos(), resourceBundleKey);
	}

	public static String getResourceBundleString(String resourceBundleKey,
			Object[] params, String bundleName) throws MissingResourceException {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ResourceBundle bundle = facesContext.getApplication()
				.getResourceBundle(facesContext, bundleName);
		String msg = null;
		try {
			String resource = bundle.getString(resourceBundleKey);
			MessageFormat formatter = new MessageFormat(resource);
			msg = formatter.format(params);

		} catch (MissingResourceException ex) {
			LOGGER.error(" resourceBundleKey : " + resourceBundleKey
					+ " not found " + ex.getMessage(), ex);

		} catch (Exception ex) {

			LOGGER.error(" resourceBundleKey : " + resourceBundleKey
					+ " not found " + ex.getMessage(), ex);

		}
		return msg;
	}
}
