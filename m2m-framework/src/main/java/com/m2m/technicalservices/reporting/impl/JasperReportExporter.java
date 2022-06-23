package com.m2m.technicalservices.reporting.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import com.m2m.technicalservices.exception.TechnicalException;
import com.m2m.technicalservices.log.ILogger;
import com.m2m.technicalservices.log.impl.SL4JLogger;
import com.m2m.technicalservices.reporting.IReportExporter;
import com.m2m.technicalservices.reporting.ReportExportException;
import com.m2m.technicalservices.reporting.ReportSpecification;
import com.m2m.technicalservices.reporting.ReportType;

public class JasperReportExporter implements IReportExporter {

	private ILogger logger = SL4JLogger.getInstance(JasperReportExporter.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.framework.technicalservices.reporting.IReportExporter#export(
	 * com.m2m.framework.technicalservices.reporting.ReportSpecification,
	 * java.util.List, com.m2m.framework.technicalservices.reporting.ReportType)
	 */

	public void export(ReportSpecification reportSpec, Collection beanList,
			ReportType reportType,Map<String, Object> dataMap) throws ReportExportException {

		try {
			InputStream inputStream = null;

			inputStream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream(reportSpec.getModel()) ; 

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource( 
					beanList);


			if(dataMap==null){
				dataMap = new HashMap<String, Object>();
			}

			JasperDesign jasperDesign;
			jasperDesign = JRXmlLoader.load(inputStream);
			JasperReport jasperReport = JasperCompileManager
					.compileReport(jasperDesign);
			JasperPrint jasperPrint = null;
			if(beanList==null || beanList.isEmpty()){
				jasperPrint = JasperFillManager.fillReport(   
						jasperReport, dataMap, new JREmptyDataSource());
			}else{
				jasperPrint = JasperFillManager.fillReport(
					jasperReport, dataMap, beanColDataSource);
			}
				

			if (reportSpec.getOutputFile() != null) {
				export(jasperPrint, FacesContext.getCurrentInstance().getExternalContext().getRealPath(reportSpec.getOutputFile()), reportType);
			} else { 
				export(jasperPrint, reportSpec.getOutputStream(), reportType);
			}

		} catch (JRException e) {
			logger.error("jasperReport export problem", e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void export(JasperPrint jasperPrint, String exportFile,
			ReportType reportType) throws JRException {

		if (reportType.equals(ReportType.PDF)) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, exportFile
					+ ".pdf");

		}
		if (reportType.equals(ReportType.PPT)) {
			JRPptxExporter  exporter = new JRPptxExporter ();
	        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, exportFile+ ".csv");
            exporter.exportReport();
		}
		if (reportType.equals(ReportType.DOCX)) {
			JRDocxExporter  exporter = new  JRDocxExporter (); 
	        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, exportFile+ ".docx");
            exporter.exportReport();
		}
		if (reportType.equals(ReportType.CSV)) {
			JRCsvExporter exporter = new JRCsvExporter();
	        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, exportFile+ ".csv");
            exporter.exportReport();
		}
		
		 

		if (reportType.equals(ReportType.HTML)) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint, exportFile
					+ ".html");
		}

		if (reportType.equals(ReportType.XML)) {
			JasperExportManager.exportReportToXmlFile(jasperPrint, exportFile
					+ ".xml", false);
		}

		if (reportType.equals(ReportType.XLS)) {
			JRXlsxExporter exporter = new JRXlsxExporter();
			FileOutputStream out2 = null;
			
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE, exportFile
					+ ".xls");
			// excel parameter
			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
					Boolean.FALSE);
			exporter.setParameter(
					JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
					Boolean.TRUE); 
			exporter.setParameter(
					JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,
					Boolean.FALSE);
			 ByteArrayOutputStream baos = new ByteArrayOutputStream();
		     exporter.setParameter( JRExporterParameter.OUTPUT_STREAM, baos);

			exporter.exportReport();
			try {
				out2 = new FileOutputStream(new File(exportFile+".xls"));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block  
				e1.printStackTrace();
			}
			  try {
				out2.write(baos.toByteArray());
				out2.flush();
				out2.close(); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void export(JasperPrint jasperPrint, OutputStream outputStream,
			ReportType reportType) throws JRException {

		if (reportType.equals(ReportType.PDF)) {
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
	        exporter.exportReport(); 
//			JasperExportManager.exportReportToPdfFile(jasperPrint, outputStream
//					+ ".pdf");

		}
		if (reportType.equals(ReportType.CSV)) {
			JRCsvExporter exporter = new JRCsvExporter();
	        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
            exporter.exportReport();
		}
		if (reportType.equals(ReportType.PPT)) {
			JRPptxExporter  exporter = new JRPptxExporter ();
	        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
            exporter.exportReport();
		}
		if (reportType.equals(ReportType.DOCX)) {
			JRDocxExporter  exporter = new  JRDocxExporter ();
	        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
            exporter.exportReport();
		}
		if (reportType.equals(ReportType.HTML)) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint,
					outputStream + ".html");
		}

		if (reportType.equals(ReportType.XLS)) {
			JRXlsxExporter exporter = new JRXlsxExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,
					outputStream);
			// excel parameter
			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
					Boolean.FALSE);
			exporter.setParameter(
					JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
					Boolean.TRUE);
			exporter.setParameter(
					JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,
					Boolean.FALSE);

			exporter.exportReport();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,
					outputStream);
			// excel parameter
			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
					Boolean.FALSE);
			exporter.setParameter(
					JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
					Boolean.TRUE);
			exporter.setParameter(
					JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,
					Boolean.FALSE);

			exporter.exportReport();
		}

		if (reportType.equals(ReportType.XML)) {
			JasperExportManager.exportReportToXmlStream(jasperPrint,
					outputStream);
		}

		if (reportType.equals(ReportType.HTML)) {
			throw new TechnicalException("not implemented");
		}

		
	}

}
