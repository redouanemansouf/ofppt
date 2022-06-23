package com.m2m.onousc.web.edition.mbean;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

import com.m2m.onousc.business.referentiel.criteria.ControlAccesCriteria;
import com.m2m.onousc.business.referentiel.criteria.PersonnelCriteria;
import com.m2m.onousc.business.referentiel.model.ControlAcces;
import com.m2m.onousc.business.referentiel.model.Personnel;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.SearchConfig;


@ManagedBean
@ViewScoped
public class EtatPersonnel {
	
	
	
	ReferentielService referentielService = (ReferentielService) BeansLookuper
			.lookup("referentielService");
	
	public void writePersonnelToFile()
			throws Exception {

		SearchConfig configuration = new SearchConfig();
	
		PersonnelCriteria criteria=new PersonnelCriteria(null, null, null, null, null, null, null , null, null , configuration);
		criteria.setSearchConfig(configuration);
		
		List<Personnel> ListPersonnel=referentielService.findPersonnelByCriteria(criteria);
	
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("Liste Acces personnel");
		HSSFRow hder = sheet.createRow(0);
		hder.setHeight((short) 600);

		CellStyle styl = wb.createCellStyle();
		styl.setAlignment(styl.ALIGN_CENTER);

		HSSFFont fon = wb.createFont();
		fon.setFontName(HSSFFont.FONT_ARIAL);
		fon.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		fon.setFontHeightInPoints((short) 16);
		fon.setColor(IndexedColors.GREEN.getIndex());
		fon.setItalic(false);
		fon.setCharSet(30);
		styl.setFont(fon);
		Cell ce = hder.createCell((short) 1);
		ce.setCellValue("ETAT PERSONNEL AVEC PROFIL");

		sheet.addMergedRegion(new CellRangeAddress(0, // first row (0-based)
				0, // last row (0-based)
				1, // first column (0-based)
				5 // last column (0-based)
		));
		ce.setCellStyle(styl);

		// ///////////////////////

		HSSFRow header = sheet.createRow(1);
		// header.setHeight((short)400);
		CellStyle style = wb.createCellStyle();
		HSSFFont font = wb.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		// font.setColor(HSSFFont.BOLDWEIGHT_BOLD);
		style.setFont(font);
		style.setBorderLeft((short) 6);
		style.setBorderRight((short) 6);
		style.setBorderTop((short) 6);
		style.setBorderBottom((short) 6);

		java.util.Iterator<Personnel> iterator = ListPersonnel.iterator();
		int rowIndex = 2;
		while (iterator.hasNext()) {
			Personnel personnel = iterator.next();
			Row row = sheet.createRow(rowIndex++);
			Cell cell0 = row.createCell(0);
			cell0.setCellValue(personnel.getMatr());
			Cell cell1 = row.createCell(1);
			cell1.setCellValue(personnel.getNom()+" "+personnel.getPrenom());

			Cell cell2 = row.createCell(2);
			cell2.setCellValue(personnel .getNumidentite());
			Cell cell3 = row.createCell(3);
			Cell cell4 = row.createCell(4);
           if(personnel.getProfil()!=null)
           {
			cell3.setCellValue(personnel.getProfil().getCode());
			cell4.setCellValue(personnel.getProfil().getLibelle());
           }
           else
           {
   			cell3.setCellValue("");
   			cell4.setCellValue("");
           }
			cell0.setCellStyle(style);
			cell1.setCellStyle(style);
			cell2.setCellStyle(style);
			cell3.setCellStyle(style);
			cell4.setCellStyle(style);
			

		}

		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		cellStyle.setFillPattern(CellStyle.FINE_DOTS);
		HSSFFont fonts = wb.createFont();
		fonts.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// fonts.setColor(HSSFFont.BOLDWEIGHT_BOLD);
		fonts.setColor(IndexedColors.WHITE.getIndex());

		cellStyle.setFont(fonts);

		cellStyle.setBorderLeft((short) 6);
		cellStyle.setBorderRight((short) 6);
		cellStyle.setBorderTop((short) 6);
		cellStyle.setBorderBottom((short) 6);

		HSSFCell cell0 = header.createCell(0);
		cell0.setCellValue("Matricule");
		cell0.setCellStyle(cellStyle);
		HSSFCell cell1 = header.createCell(1);
		cell1.setCellValue("Nom/Prénom");
		cell1.setCellStyle(cellStyle);
		HSSFCell cell2 = header.createCell(2);
		cell2.setCellValue("CNI");
		cell2.setCellStyle(cellStyle);

		HSSFCell cell3 = header.createCell(3);
		cell3.setCellValue("Code Profil");
		cell3.setCellStyle(cellStyle);

		HSSFCell cell4 = header.createCell(4);
		cell4.setCellValue("Libellé Profil");
		cell4.setCellStyle(cellStyle);
		

		sheet.setColumnWidth(0, 2000);

		sheet.setColumnWidth(1, 7000);
		sheet.setColumnWidth(2, 4000);
		sheet.setColumnWidth(3, 2000);
		sheet.setColumnWidth(4, 7000);
		int somme=0;
		for (int j = 2; j < sheet.getPhysicalNumberOfRows(); j++) {
			Row row = sheet.getRow(j);
			Cell cell = row.getCell(1);
			somme += 1;
			
		}

		Cell c = null;
		CellStyle cs = wb.createCellStyle();
		cs.setFillForegroundColor(IndexedColors.LIME.getIndex());
		cs.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cs.setBorderLeft((short) 6);
		cs.setBorderRight((short) 6);
		cs.setBorderTop((short) 6);
		cs.setBorderBottom((short) 6);
		cs.setFont(font);
		Row row = sheet.createRow(sheet.getPhysicalNumberOfRows() + 2);
		c = row.createCell(0);
		c.setCellValue("TOTAL");
		c.setCellStyle(cs);
		sheet.setColumnWidth(0, 8500);
		c = row.createCell(1);
		c.setCellValue(somme);
		c.setCellStyle(cs);
		sheet.setColumnWidth(0, 8500);

		
		SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
		String date = fmt.format(new Date());
		FileOutputStream fos = new FileOutputStream(new File(
				"C://ACCES_OCP//PERSONNEL//ETAT_PERSONNEL_" + date + ".xls"));

		
		wb.write(fos);

		fos.close();
		System.out.println(" written successfully");

	}


}
