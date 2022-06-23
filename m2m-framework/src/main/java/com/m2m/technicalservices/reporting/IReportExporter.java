package com.m2m.technicalservices.reporting;

import java.util.Collection;
import java.util.Map;

public interface IReportExporter {
	/**
	 * export la liste  "beanList" dans un fichier ou un "outputstream" (reportSpec) selon un model ((reportSpec) dans une sortie "reportType"  (pdf, xsl,...)
	 * @param reportSpec
	 * @param beanList
	 * @param reportType
	 */
	void export(ReportSpecification reportSpec, Collection beanList, ReportType reportType,Map<String, Object> dataMap);
   
}
