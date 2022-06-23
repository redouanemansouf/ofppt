package com.m2m.technicalservices.reporting;

import java.io.OutputStream;

public class ReportSpecification {
	private String model;
	private String outputFile;
	private OutputStream outputStream;
	
	public ReportSpecification(String model,String outputFile){
		this.model = model;
		this.outputFile = outputFile;
	}
	
	public ReportSpecification(String model,OutputStream outputStream){
		this.model = model;
		this.outputStream = outputStream;
	}
	
	public String getOutputFile() {
		return outputFile;
	}

	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}

	public OutputStream getOutputStream() {
		return outputStream;
	}

	public void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}
