package com.m2m.technicalservices.core;

import java.util.ArrayList;
import java.util.List;

public class ProcessResult {

	private Object data;

	private List<ProcessMsg> messages = new ArrayList<ProcessMsg>();

	private int typeMessage = Constantes.TYPE_MESSAGE_INFO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder buffer = new StringBuilder("");
		if (messages != null && !messages.isEmpty()) {
			for (final ProcessMsg m : messages) {
				buffer.append(m.getKey()).append(";");
			}
		}
		return buffer.toString();
	}

	public List<ProcessMsg> getMessages() {
		return messages;
	}

	public void setMessages(List<ProcessMsg> messages) {
		this.messages = messages;
	}

	public void addMessage(ProcessMsg message) {
		if (message == null) {
			return;
		}
		this.messages.add(message);
		typeMessage = message.getTypeMessage();
	}

	public boolean noMessages() {
		return messages.isEmpty();
	}

	public boolean noData() {
		return data == null;
	}

	public void setTypeMessage(int typeMsg) {
		typeMessage = typeMsg;
	}

	public int getTypeMessage() {
		return typeMessage;
	}

	public boolean isMessageInfo() {
		final int typeMsg = getTypeMessage();
		return Constantes.TYPE_MESSAGE_INFO == typeMsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isMsgError() {
		if (messages == null || messages.isEmpty()) {
			return false;
		}
		final int typeMsg = getTypeMessage();
		return Constantes.TYPE_MESSAGE_ERREUR == typeMsg;
	}

	public void addMessages(ProcessResult result) {
		if (result == null) {
			result = new ProcessResult();
		}
		for (ProcessMsg msg : result.getMessages()) {
			addMessage(msg);
		}
	}

}
