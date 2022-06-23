/*
 * ReservationMBean.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.edition.mbean;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.model.StreamedContent;

import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.criteria.EtudiantCriteria;
import com.m2m.onousc.business.referentiel.model.CycleVie;
import com.m2m.onousc.business.referentiel.model.Etudiants;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.reservation.vo.ReservationVO;
import com.m2m.onousc.web.edition.EditionSrvPresentation;
import com.m2m.onousc.web.edition.webbean.EditionWebBean;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.technicalservices.reporting.ReportSpecification;
import com.m2m.technicalservices.reporting.ReportType;
import com.m2m.technicalservices.reporting.impl.JasperReportExporter;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.tools.DateUtil;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.SearchConfig;
import com.m2m.technicalservices.web.UserSessionHelper;

/**
 * The Class ReservationMBean.
 * 
 * @version 1.0 19 oct. 2015
 * @author iissouani
 */
@ManagedBean
@ViewScoped
public class EditionMBean extends BaseMBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -148933612381819373L;

	/** The web bean. */
	EditionWebBean webBean = new EditionWebBean();

	EditionSrvPresentation editionService = (EditionSrvPresentation) BeansLookuper
			.lookup("editionSrvPresentation");

	/** The type reservation. */
	private String typeReservation = "JOUR";

	/** The action. */
	private String action;

	private StreamedContent streamedContent;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.web.BaseMBean#init()
	 */
	public void init() {
	}

	/**
	 * Gets the user connecte.
	 * 
	 * @return the user connecte
	 */
	public String getUserConnecte() {
		String user = UserSessionHelper.getUserConecte().getCode();
		return user == null ? "" : user;
	}


	/**
	 * Gets the web bean.
	 * 
	 * @return the web bean
	 */
	public EditionWebBean getWebBean() {
		return webBean;
	}

	
	public void getNbreDemande() {
		JasperReportExporter jasperExporter = new JasperReportExporter();
		ReportSpecification reportSpec = new ReportSpecification("resources/reports/Leaf_Grey.jrxml", "resources/reports/test4"); 
		List<Etudiants> beanList = new ArrayList<Etudiants>();    
		SearchConfig config = new SearchConfig();
		ReferentielService referentielService = (ReferentielService) BeansLookuper
				.lookup("referentielService");
		EtudiantCriteria criteria = new EtudiantCriteria();
		criteria.setSearchConfig(config);
		criteria.setSortField(null);
		criteria.setSortOrder(null);
		beanList.addAll(referentielService.findByCriteria(criteria));       
		Map<String, Object> dataMap = new HashMap<String,Object>();
		dataMap.put("ReportTitle", "Liste des Nouvelles Cartes");
		dataMap.put("author", "ISSOUANI");
		String realPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/images/");      
		dataMap.put("realPath", realPath);
		jasperExporter.export(reportSpec, beanList, ReportType.PDF,dataMap);
	}
	
	public void getListeOfCartes() throws IOException {
		if(webBean.getDate_debut().after(webBean.getDate_fin())){
			addCollectorErrorMessage("DATE_DEBUT_POSTERIEURE_DATE_FIN"); 
			return ;
		} 
		
		String reportTitle = "Liste des Nouvelles Cartes";
		String author = "M2MGroup";
//		String path = "resources/reports/";   
		String pathJrxml = "resources/reports/report_Carte.jrxml"; 
		ReferentielService referentielService = (ReferentielService) BeansLookuper
				.lookup("referentielService");
		List<CycleVie> beanList = new ArrayList<CycleVie>();    
		ReportType reportType = ReportType.PDF;
		if("XLS".equals(webBean.getType_fichier())){
			reportType = ReportType.XLS;
		} 
		beanList.addAll(referentielService.findByCycleVieByDate(webBean.getDate_debut(),webBean.getDate_fin())); 

		JasperReportExporter jasperExporter = new JasperReportExporter();
		FacesContext fc = FacesContext.getCurrentInstance();
	    ExternalContext ec = fc.getExternalContext();
	   
	    ec.responseReset();
	    ec.setResponseContentType("application/pdf");
	    String fileName = "Liste des cartes.pdf";
		ec.setResponseHeader("Content-Disposition", "attachment; filename=\""
	    + fileName);
	   
        OutputStream output = ec.getResponseOutputStream();
       
		Map<String, Object> dataMap = new HashMap<String,Object>();
		ReportSpecification reportSpec = new ReportSpecification(pathJrxml, output); 
		dataMap.put("ReportTitle", reportTitle);    
		dataMap.put("author", author);
		String realPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/images/");      
		dataMap.put("realPath", realPath);
		
//		generateStreamedContent(dataMap, reportType, path+fileJrxml, beanList);    
		jasperExporter.export(reportSpec, beanList, reportType,dataMap);
		fc.responseComplete();  
	}

	
	
	public void getListeOfReservations() throws IOException {
		//declare variables
		if(webBean.getDate_debut().after(webBean.getDate_fin())){
			addCollectorErrorMessage("DATE_DEBUT_POSTERIEURE_DATE_FIN");
			return ; 
		} 
		JasperReportExporter jasperExporter = new JasperReportExporter();
		String reportTitle = "Liste des Réservations";
		String author = "M2MGroup";
//		String path = "resources/reports/";
		String pathJrxml = "resources/reports/report_res.jrxml";      
		String fileOutput = "test4";
		/** The referentiel service. */
		ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
				.lookup("referentielSrvPresentation");
		List<ReservationVO> beanList = new ArrayList<ReservationVO>();      
		ReportType reportType = ReportType.PDF;
		if("XLS".equals(webBean.getType_fichier())){
			reportType = ReportType.XLS;  
		} 
		
		beanList.addAll(referentielService.findByReservationByDate(webBean.getDate_debut(),webBean.getDate_fin()));
		FacesContext fc = FacesContext.getCurrentInstance(); 
	    ExternalContext ec = fc.getExternalContext();
	   
	    ec.responseReset();
	    ec.setResponseContentType("application/pdf");
	    String fileName = "Liste des Réservations.pdf";  
		ec.setResponseHeader("Content-Disposition", "attachment; filename=\""
	    + fileName);
	   
        OutputStream output = ec.getResponseOutputStream(); 
       
		Map<String, Object> dataMap = new HashMap<String,Object>();
		ReportSpecification reportSpec = new ReportSpecification(pathJrxml, output); 
		dataMap.put("ReportTitle", reportTitle);
		dataMap.put("author", author); 
		String realPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/images/");      
		dataMap.put("realPath", realPath);
		
		jasperExporter.export(reportSpec, beanList, reportType,dataMap);
		fc.responseComplete();  
	}
	
	

	public void getListeOfDemandes() throws IOException {

		JasperReportExporter jasperExporter = new JasperReportExporter();  
		String reportTitle = "Liste des Demandes";
		String author = "M2MGroup";
//		String path = "resources/reports/";
		String fileJrxml = "resources/reports/Simple_Blue.jrxml";     
		ReferentielService referentielService = (ReferentielService) BeansLookuper
				.lookup("referentielService");
		List<Etudiants> beanList = new ArrayList<Etudiants>();     
		ReportType reportType = ReportType.PDF;
		
		beanList.addAll(referentielService.findEtudiantByStatus(webBean.getStatus()));     
		Map<String, Object> dataMap = new HashMap<String,Object>();  
//		jasperExporter.export(reportSpec, beanList, reportType,dataMap);
		FacesContext fc = FacesContext.getCurrentInstance();
	    ExternalContext ec = fc.getExternalContext();
	   
	    ec.responseReset();
	    ec.setResponseContentType("application/pdf");
	    String fileName = "Liste des Demandes.pdf";
		ec.setResponseHeader("Content-Disposition", "attachment; filename=\""
	    + fileName);
	   
        OutputStream output = ec.getResponseOutputStream();
        ReportSpecification reportSpec = new ReportSpecification(fileJrxml, output); 
		dataMap.put("ReportTitle", reportTitle);     
		dataMap.put("author", author);
		String realPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/images/");      
		dataMap.put("realPath", realPath);
		jasperExporter.export(reportSpec, beanList, reportType,dataMap);
		fc.responseComplete();
		
	}
	
//	private void generateStreamedContent(Map<String, Object> dataMap,
//            ReportType reportType, String pathFileJrxml, Collection beanList) {
//     JasperReportExporter jasperExporter = new JasperReportExporter();
//
//     ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//     ReportSpecification reportSpec = new ReportSpecification(
//                   pathFileJrxml, out);
//
//     jasperExporter.export(reportSpec, beanList, reportType, dataMap);
//
//     streamedContent = new DefaultStreamedContent(new ByteArrayInputStream(
//                   out.toByteArray()));
//	}

	public void generateReportDetailOperationCaisse() throws IOException {
	       
        JasperReportExporter jasperExporter = new JasperReportExporter();
        Map<String, Object> dataMap = new HashMap<String, Object>();
       
        String path = "resources/jasper/";
       
        ReportType reportType = ReportType.PDF;
        String fileJrxml = "detailOperationCaisse.jrxml";
       
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
       
        ec.responseReset();
        ec.setResponseContentType("application/pdf");
        ec.setResponseHeader("Content-Disposition", "attachment; filename=\""
        + "detail.pdf");
       
        OutputStream output = ec.getResponseOutputStream();
       
        ReportSpecification reportSpec = new ReportSpecification(path
        + fileJrxml, output);
       
//        jasperExporter.export(reportSpec, getWebBean().getVo().getOperations(),
//        reportType, dataMap);  
       
        fc.responseComplete();
        }


	
	/**
	 * Sets the web bean.
	 * 
	 * @param webBean
	 *            the new web bean
	 */
	public void setWebBean(EditionWebBean webBean) {
		this.webBean = webBean;
	}

	/**
	 * Gets the type reservation.
	 * 
	 * @return the type reservation
	 */
	public String getTypeReservation() {
		return typeReservation;
	}

	/**
	 * Sets the type reservation.
	 * 
	 * @param typeReservation
	 *            the new type reservation
	 */
	public void setTypeReservation(String typeReservation) {
		this.typeReservation = typeReservation;
	}

	/**
	 * Gets the action.
	 * 
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * Sets the action.
	 * 
	 * @param action
	 *            the new action
	 */
	public void setAction(String action) {
		this.action = action;
	}
	
	/**
	 * @return
	 */
	public static Date currentDate(){ 
		return DateUtil.currentDate();
	}

	public StreamedContent getStreamedContent() {
		return streamedContent;
	}

	public void setStreamedContent(StreamedContent streamedContent) {
		this.streamedContent = streamedContent;
	}
	
//	@Override
//	protected boolean isAutorise() {
//		return hasEcran(Constantes.CODE_EDI);  
//	}
}
