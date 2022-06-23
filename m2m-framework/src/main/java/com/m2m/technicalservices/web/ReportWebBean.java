package com.m2m.technicalservices.web;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage.Severity;

public class ReportWebBean {
	private boolean error;
	/**
	 * changed from list<String> to Map<severity,String>  #amtarji
	 */
	//list<String>  listMessages = new ArrayList<>();
	private Map<Severity,String> listMessages = new HashMap<>();
	
	public ReportWebBean(Map<Severity,String> listMessages ,boolean isError){
		this.listMessages = listMessages;
		this.error = isError;
	}
	public ReportWebBean(){
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public Map<Severity, String> getListMessages() {
		return listMessages;
	}
	public void setListMessages(Map<Severity, String> listMessages) {
		this.listMessages = listMessages;
	}
	public boolean isRendred(){
		return listMessages.size() > 0;
	}
	
	public boolean isSingleMsg() {
		return listMessages!=null && listMessages.size() == 1;
	}
}
