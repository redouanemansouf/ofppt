package com.m2m.technicalservices.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * @author Younes SOUTEH
 * 
 */
@SuppressWarnings("serial")
public class ValidationPhaseListener implements PhaseListener {

	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

	public void beforePhase(PhaseEvent e) {
		FacesContext facesContext = e.getFacesContext();
		UIViewRoot root = facesContext.getViewRoot();

		Iterator<String> clientIdIterator = facesContext
				.getClientIdsWithMessages();

		List<String> listMessages = new ArrayList<String>();
		while (clientIdIterator.hasNext()) {

			String clientId = clientIdIterator.next();

			if (clientId != null) {
				UIComponent component = root.findComponent(clientId);
				if (component instanceof UIInput) {
					component.getAttributes().put("styleClass", "error_field");
				}

				Iterator<FacesMessage> messageIterator = facesContext
						.getMessages(clientId);
				while (messageIterator.hasNext()) {
					FacesMessage facesMessage = (FacesMessage) messageIterator
							.next();
					listMessages.add(facesMessage.getDetail());
				}
			}

		}

		/**
		 * WARNING : Ce bloc a été commenté pour ne pas rajouter les messages de
		 * validation simple de jsf au niveau du usersession.report du
		 * usersession.report
		 */

		// UserSession userSession =
		// (UserSession)JSFUtils.getSession("userSession");
		// if (!listMessages.isEmpty()&& userSession != null) {
		// userSession.setReport(new ReportWebBean(listMessages, true));
		// }
		//
		// if (userSession != null && userSession.getReport() != null) {
		// if (userSession.getReport().isError()) {
		// RequestContext.getCurrentInstance().addCallbackParam(
		// "notValid", true);
		// }
		// String blocReport = "bloc_rapport";
		// RequestContext.getCurrentInstance().update(blocReport);
		// }

	}

	public void afterPhase(PhaseEvent e) {
	}
}