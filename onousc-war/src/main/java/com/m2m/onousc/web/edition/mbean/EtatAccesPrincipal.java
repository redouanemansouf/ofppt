package com.m2m.onousc.web.edition.mbean;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;




import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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
import com.m2m.onousc.business.referentiel.model.ControlAcces;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.SearchConfig;

@ManagedBean
@ViewScoped
public class EtatAccesPrincipal {
	
	ReferentielService referentielService = (ReferentielService) BeansLookuper
			.lookup("referentielService");
	
	public void writeAccesListToFile()
			throws Exception {

		SearchConfig configuration = new SearchConfig();
		ControlAccesCriteria criteri = new ControlAccesCriteria(null, null,
				null, null, null, null);
		criteri.setSearchConfig(configuration);
		List<ControlAcces> ListControlAcces = referentielService
				.findControlAccesAccesPrincip(criteri);
		List<String> list_matr=new ArrayList<String>();
		for(ControlAcces ca:ListControlAcces)
		{
			list_matr.add(ca.getMatricule());
		}
		list_matr = new ArrayList<String>(new LinkedHashSet<String>(list_matr));
		System.out.println("List"+list_matr.size());
		List<EtatAccesPrin> list_principal=new ArrayList<>();
		int size=0;
		for(String matricule:list_matr)
		{
			ControlAccesCriteria criteria = new ControlAccesCriteria(matricule, null,
					null, null, null, null);
			SearchConfig config = new SearchConfig();
			criteria.setSearchConfig(config);
			ListControlAcces = referentielService
					.findControlAccesAccesPrincip(criteria);
		
			      size=ListControlAcces.size();
			     System.out.println("Size"+size);
				EtatAccesPrin aprincip=new EtatAccesPrin();
				aprincip.setMatricule(matricule);
				if(size>0)
				aprincip.setHeureAccesE1(ListControlAcces.get(0).getHeureAcces());
				if((size-1)>0)
				aprincip.setHeureAccesS1(ListControlAcces.get(1).getHeureAcces());
				if((size-2)>0)
				aprincip.setHeureAccesE2(ListControlAcces.get(2).getHeureAcces());
				if((size-3)>0)
				aprincip.setHeureAccesS2(ListControlAcces.get(3).getHeureAcces());
				if((size-4)>0)
				aprincip.setHeureAccesE3(ListControlAcces.get(4).getHeureAcces());
				if((size-5)>0)
				aprincip.setHeureAccesS3(ListControlAcces.get(5).getHeureAcces());
				if((size-6)>0)
				aprincip.setHeureAccesE4(ListControlAcces.get(6).getHeureAcces());
				if((size-7)>0)
				aprincip.setHeureAccesS4(ListControlAcces.get(7).getHeureAcces());
				if((size-8)>0)
				aprincip.setHeureAccesE5(ListControlAcces.get(8).getHeureAcces());
				if((size-9)>0)
				aprincip.setHeureAccesS5(ListControlAcces.get(9).getHeureAcces());
				if((size-10)>0)
				aprincip.setHeureAccesE6(ListControlAcces.get(10).getHeureAcces());
				if((size-11)>0)
				aprincip.setHeureAccesS6(ListControlAcces.get(11).getHeureAcces());
				if((size-12)>0)
				aprincip.setHeureAccesE7(ListControlAcces.get(12).getHeureAcces());
				if((size-13)>0)
				aprincip.setHeureAccesS7(ListControlAcces.get(13).getHeureAcces());
				if((size-14)>0)
				aprincip.setHeureAccesE8(ListControlAcces.get(14).getHeureAcces());
				if((size-15)>0)
				aprincip.setHeureAccesS8(ListControlAcces.get(15).getHeureAcces());
				if((size-16)>0)
				aprincip.setHeureAccesE9(ListControlAcces.get(16).getHeureAcces());
				if((size-17)>0)
				aprincip.setHeureAccesS9(ListControlAcces.get(17).getHeureAcces());
				if((size-18)>0)
				aprincip.setHeureAccesE10(ListControlAcces.get(18).getHeureAcces());
				if((size-19)>0)
				aprincip.setHeureAccesS10(ListControlAcces.get(19).getHeureAcces());
				list_principal.add(aprincip);
			
			
		}
		System.out.println("ListPrincipal"+list_principal.size());
		
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("Liste Acces_Principal");
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
		ce.setCellValue("ETAT ACCES Principal" );

		sheet.addMergedRegion(new CellRangeAddress(0, // first row (0-based)
				0, // last row (0-based)
				5, // first column (0-based)
				20 // last column (0-based)
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

		SimpleDateFormat fmtD = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat fmtH = new SimpleDateFormat("HH:mm");
		java.util.Iterator<EtatAccesPrin> iterator = list_principal.iterator();

		int rowIndex = 2;
		while (iterator.hasNext()) {
			EtatAccesPrin country = iterator.next();
			Row row = sheet.createRow(rowIndex++);
			
			Cell cell0 = row.createCell(0);
			cell0.setCellValue(country.getMatricule());
			
			Cell cell1 = row.createCell(1);
			cell1.setCellValue(fmtD.format(new Date()));
           
			Cell cell2 = row.createCell(2);
			 if(country.getHeureAccesE1()!=null)
			cell2.setCellValue(fmtH.format(country.getHeureAccesE1()));

			Cell cell3 = row.createCell(3);
			 if(country.getHeureAccesS1()!=null)
			cell3.setCellValue(fmtH.format(country.getHeureAccesS1()));

			Cell cell4 = row.createCell(4);
			 if(country.getHeureAccesE2()!=null)
			cell4.setCellValue(fmtH.format(country.getHeureAccesE2()));
			
			Cell cell5 = row.createCell(5);
			 if(country.getHeureAccesS2()!=null)
			cell5.setCellValue(fmtH.format(country.getHeureAccesS2()));
			
			Cell cell6 = row.createCell(6);
			 if(country.getHeureAccesE3()!=null)
			cell6.setCellValue(fmtH.format(country.getHeureAccesE3()));
			
			Cell cell7 = row.createCell(7);
			 if(country.getHeureAccesS3()!=null)
			cell7.setCellValue(fmtH.format(country.getHeureAccesS3()));
			
			Cell cell8 = row.createCell(8);
			 if(country.getHeureAccesE4()!=null)
			cell8.setCellValue(fmtH.format(country.getHeureAccesE4()));
			
			Cell cell9 = row.createCell(9);
			 if(country.getHeureAccesS4()!=null)
			cell9.setCellValue(fmtH.format(country.getHeureAccesS4()));
			
			Cell cell10 = row.createCell(10);
			 if(country.getHeureAccesE5()!=null)
			cell10.setCellValue(fmtH.format(country.getHeureAccesE5()));
			
			Cell cell11 = row.createCell(11);
			 if(country.getHeureAccesS5()!=null)
			cell11.setCellValue(fmtH.format(country.getHeureAccesS5()));
			
			Cell cell12 = row.createCell(12);
			 if(country.getHeureAccesE6()!=null)
			cell12.setCellValue(fmtH.format(country.getHeureAccesE6()));
			
			Cell cell13 = row.createCell(13);
			 if(country.getHeureAccesS6()!=null)
			cell13.setCellValue(fmtH.format(country.getHeureAccesS6()));
			
			Cell cell14 = row.createCell(14);
			 if(country.getHeureAccesE7()!=null)
			cell14.setCellValue(fmtH.format(country.getHeureAccesE7()));
			
			Cell cell15 = row.createCell(15);
			 if(country.getHeureAccesS7()!=null)
			cell15.setCellValue(fmtH.format(country.getHeureAccesS7()));
			
			Cell cell16 = row.createCell(16);
			 if(country.getHeureAccesE8()!=null)
			cell16.setCellValue(fmtH.format(country.getHeureAccesE8()));
			
			Cell cell17 = row.createCell(17);
			 if(country.getHeureAccesS8()!=null)
			cell17.setCellValue(fmtH.format(country.getHeureAccesS8()));
			
			Cell cell18 = row.createCell(18);
			 if(country.getHeureAccesE9()!=null)
			cell18.setCellValue(fmtH.format(country.getHeureAccesE9()));
			
			Cell cell19 = row.createCell(19);
			 if(country.getHeureAccesS9()!=null)
			cell19.setCellValue(fmtH.format(country.getHeureAccesS9()));
			 
			 Cell cell20 = row.createCell(20);
			 if(country.getHeureAccesE10()!=null)
			cell20.setCellValue(fmtH.format(country.getHeureAccesE10()));
			
			Cell cell21 = row.createCell(21);
			 if(country.getHeureAccesS10()!=null)
			cell21.setCellValue(fmtH.format(country.getHeureAccesS10()));
			
			
		
			

	/*		Cell cell6 = row.createCell(6);
		if(referentielService.findPersonnelByMatr(country.getMatricule()).getProfil()!=null)
			cell6.setCellValue((referentielService.findPersonnelByMatr(country.getMatricule()).getProfil().getLibelle()));
		*/	
			cell0.setCellStyle(style);
			cell1.setCellStyle(style);
			cell2.setCellStyle(style);
			cell3.setCellStyle(style);
			cell4.setCellStyle(style);
			cell5.setCellStyle(style);
			cell6.setCellStyle(style);
			
			cell7.setCellStyle(style);
			cell8.setCellStyle(style);
			cell9.setCellStyle(style);
			cell10.setCellStyle(style);
			cell11.setCellStyle(style);
			cell12.setCellStyle(style);
			
			cell13.setCellStyle(style);
			cell14.setCellStyle(style);
			cell15.setCellStyle(style);
			cell16.setCellStyle(style);
			cell17.setCellStyle(style);
			cell18.setCellStyle(style);
			cell19.setCellStyle(style);
			cell20.setCellStyle(style);
			cell21.setCellStyle(style);
			
		

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
		cell1.setCellValue("Date d'accés");
		cell1.setCellStyle(cellStyle);
		HSSFCell cell2 = header.createCell(2);
		cell2.setCellValue("E1 ");
		cell2.setCellStyle(cellStyle);

		HSSFCell cell3 = header.createCell(3);
		cell3.setCellValue("S1 ");
		cell3.setCellStyle(cellStyle);

		HSSFCell cell4 = header.createCell(4);
		cell4.setCellValue("E2 ");
		cell4.setCellStyle(cellStyle);
		
		HSSFCell cell5 = header.createCell(5);
		cell5.setCellValue("S2");
		cell5.setCellStyle(cellStyle);
		
		HSSFCell cell6 = header.createCell(6);
		cell6.setCellValue("E3 ");
		cell6.setCellStyle(cellStyle);
		
		HSSFCell cell7 = header.createCell(7);
		cell7.setCellValue("S3 ");
		cell7.setCellStyle(cellStyle);
		
		HSSFCell cell8 = header.createCell(8);
		cell8.setCellValue("E4 ");
		cell8.setCellStyle(cellStyle);
		
		HSSFCell cell9 = header.createCell(9);
		cell9.setCellValue("S4 ");
		cell9.setCellStyle(cellStyle);
		
		HSSFCell cell10 = header.createCell(10);
		cell10.setCellValue("E5 ");
		cell10.setCellStyle(cellStyle);
		
		HSSFCell cell11 = header.createCell(11);
		cell11.setCellValue("S5 ");
		cell11.setCellStyle(cellStyle);
		
		HSSFCell cell12 = header.createCell(12);
		cell12.setCellValue("E6 ");
		cell12.setCellStyle(cellStyle);
		
		HSSFCell cell13 = header.createCell(13);
		cell13.setCellValue("S6 ");
		cell13.setCellStyle(cellStyle);
		
		HSSFCell cell14 = header.createCell(14);
		cell14.setCellValue("E7 ");
		cell14.setCellStyle(cellStyle);
		
		HSSFCell cell15 = header.createCell(15);
		cell15.setCellValue("S7 ");
		cell15.setCellStyle(cellStyle);
		
		HSSFCell cell16 = header.createCell(16);
		cell16.setCellValue("E8 ");
		cell16.setCellStyle(cellStyle);
		
		HSSFCell cell17 = header.createCell(17);
		cell17.setCellValue("S8 ");
		cell17.setCellStyle(cellStyle);
		
		HSSFCell cell18 = header.createCell(18);
		cell18.setCellValue("E9 ");
		cell18.setCellStyle(cellStyle);
		
		HSSFCell cell19 = header.createCell(19);
		cell19.setCellValue("S9 ");
		cell19.setCellStyle(cellStyle);
		
		HSSFCell cell20 = header.createCell(20);
		cell20.setCellValue("E10 ");
		cell20.setCellStyle(cellStyle);
		
		HSSFCell cell21 = header.createCell(21);
		cell21.setCellValue("S10 ");
		cell21.setCellStyle(cellStyle);
		

		sheet.setColumnWidth(0, 1500);

		sheet.setColumnWidth(1, 3200);
		sheet.setColumnWidth(2, 2200);
		sheet.setColumnWidth(3, 2200);
		sheet.setColumnWidth(4, 2200);
		sheet.setColumnWidth(5, 2200);
		sheet.setColumnWidth(6, 2200);
		sheet.setColumnWidth(7, 2200);
		sheet.setColumnWidth(8, 2200);
		sheet.setColumnWidth(9, 2200);
		sheet.setColumnWidth(10, 2200);
		sheet.setColumnWidth(11, 2200);
		sheet.setColumnWidth(12, 2200);
		sheet.setColumnWidth(13, 2200);
		sheet.setColumnWidth(14, 2200);
		sheet.setColumnWidth(15, 2200);
		sheet.setColumnWidth(16, 2200);
		sheet.setColumnWidth(17, 2200);
		sheet.setColumnWidth(18, 2200);
		sheet.setColumnWidth(19, 2200);
		sheet.setColumnWidth(20, 2200);
		sheet.setColumnWidth(21, 2200);
		
		
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
				"C://ETATS//ACCES_Principal_"+ date + ".xls"));

		
		wb.write(fos);

		fos.close();
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "LA GENERATION EFFECTUEE, VOIR LE RAPPORT SUR C:/ETATS/ ", "LA GENERATION EFFECTUEE, VOIR LE RAPPORT SUR C:/ETATS/"));
		System.out.println(" written successfully");

	}


}
