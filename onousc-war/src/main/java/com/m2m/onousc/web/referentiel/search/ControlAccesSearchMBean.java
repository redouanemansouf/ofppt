package com.m2m.onousc.web.referentiel.search;

import java.io.File;
import java.io.FileInputStream;
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
import com.m2m.onousc.business.referentiel.model.ControlAcces;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.web.edition.mbean.CopySheets;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.AbstractSearchMBean;
import com.m2m.technicalservices.web.SearchConfig;

@ManagedBean
@ViewScoped
public class ControlAccesSearchMBean extends AbstractSearchMBean{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6572482313764601053L;
	private ControlAccesCriteria criteria=new ControlAccesCriteria();
	ReferentielService referentielService = (ReferentielService) BeansLookuper
			.lookup("referentielService");
	
	public ControlAccesSearchMBean(){
		search = new ControlAccesSearch();
		searchCriteria = criteria;
		initData();
	}
	
	public void initData(){
		//criteria.setTourniquet(null);
		searchCriteria = criteria;
		run();
	}
	@Override
	public void resetSearchCriteria() {
		criteria = new ControlAccesCriteria();
		searchCriteria = criteria;
	}

	public ControlAccesCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(ControlAccesCriteria criteria) {
		this.criteria = criteria;
	}

	
	
	
	public void writeAccesListToFile(Long tourniquet, String name)
			throws Exception {

		SearchConfig configuration = new SearchConfig();
		criteria.setSearchConfig(configuration);
		criteria.setTourniquet(tourniquet);
		List<ControlAcces> ListControlAcces = referentielService
				.findControlAccesByCriteria(criteria);
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("Liste Acces_" + name);
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
		ce.setCellValue("ETAT ACCES " + name);

		sheet.addMergedRegion(new CellRangeAddress(0, // first row (0-based)
				0, // last row (0-based)
				4, // first column (0-based)
				7// last column (0-based)
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
		java.util.Iterator<ControlAcces> iterator = ListControlAcces.iterator();

		int rowIndex = 2;
		while (iterator.hasNext()) {
			ControlAcces country = iterator.next();
			Row row = sheet.createRow(rowIndex++);
			Cell cell0 = row.createCell(0);
			cell0.setCellValue(country.getMatricule());
			Cell cell1 = row.createCell(1);
			cell1.setCellValue(fmtD.format(country.getDateAcces()));

			Cell cell2 = row.createCell(2);
			cell2.setCellValue(fmtH.format(country.getHeureAcces()));

			Cell cell3 = row.createCell(3);
			cell3.setCellValue(country.getTourniquet().getLibelle());

			Cell cell4 = row.createCell(4);
			cell4.setCellValue(country.getTourniquet().getType());
			
			Cell cell5 = row.createCell(5);
			cell5.setCellValue((referentielService.findPersonnelByMatr(country.getMatricule()).getNom()+"  "+referentielService.findPersonnelByMatr(country.getMatricule()).getPrenom()));

			Cell cell6 = row.createCell(6);
		if(referentielService.findPersonnelByMatr(country.getMatricule()).getProfil()!=null)
			cell6.setCellValue((referentielService.findPersonnelByMatr(country.getMatricule()).getProfil().getLibelle()));

			cell0.setCellStyle(style);
			cell1.setCellStyle(style);
			cell2.setCellStyle(style);
			cell3.setCellStyle(style);
			cell4.setCellStyle(style);
			cell5.setCellStyle(style);
			cell6.setCellStyle(style);

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
		cell2.setCellValue("Heure d'accés ");
		cell2.setCellStyle(cellStyle);

		HSSFCell cell3 = header.createCell(3);
		cell3.setCellValue("Tourniquet");
		cell3.setCellStyle(cellStyle);

		HSSFCell cell4 = header.createCell(4);
		cell4.setCellValue("Type");
		cell4.setCellStyle(cellStyle);
		
		HSSFCell cell5 = header.createCell(5);
		cell5.setCellValue("Nom/Prénom");
		cell5.setCellStyle(cellStyle);
		
		HSSFCell cell6 = header.createCell(6);
		cell6.setCellValue("Profil");
		cell6.setCellStyle(cellStyle);

		sheet.setColumnWidth(0, 4000);

		sheet.setColumnWidth(1, 4000);
		sheet.setColumnWidth(2, 4000);
		sheet.setColumnWidth(3, 7000);
		sheet.setColumnWidth(4, 3000);
		sheet.setColumnWidth(5, 7000);
		sheet.setColumnWidth(6, 7000);
		
		System.err.println("Nombre of row:"+sheet.getPhysicalNumberOfRows());

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
				"C://ETATS//ACCES_" + name + "_" + date + ".xls"));

		wb.write(fos);

		fos.close();
		System.out.println(" written successfully");

	}
	
public void fusionner() throws Exception {
		
		writeAccesListToFile(1L, "BUVETTE ZERKTOUNI DROIT");
		writeAccesListToFile(2L, "BUVETTE MOULAY DRISS");
		writeAccesListToFile(5L, "SALLE COUVERTE DROIT");
		writeAccesListToFile(6L, "SALLE COUVERTE GAUCHE");
		writeAccesListToFile(7L, "BUVETTE ZERKTOUNI GAUCHE");
		writeAccesListToFile(9L, "BIBLIOTHEQUE DROIT");
		writeAccesListToFile(10L, "BIBLIOTHEQUE GAUCHE");
		writeAccesListToFile(11L, "PORTE  PRINCIPAL ENTREE");
		writeAccesListToFile(12L, "PMR BIBLIOTHEQUE");
		writeAccesListToFile(13L, "PMR SALLE COUVERTTE");
		writeAccesListToFile(14L, "PORTE  PRINCIPAL SORTIE");

		SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
		String date = fmt.format(new Date());

		FileInputStream file = new FileInputStream(new File("C://ETATS//ACCES_BUVETTE ZERKTOUNI DROIT_" + date + ".xls"));
		HSSFWorkbook classeur = new HSSFWorkbook(file);
		HSSFSheet feuille = classeur.getSheetAt(0);

		FileInputStream Synthese = new FileInputStream(new File("C://ETATS//ACCES_BUVETTE MOULAY DRISS_" + date + ".xls"));
		HSSFWorkbook clasSynthese = new HSSFWorkbook(Synthese);
		HSSFSheet feuSynthese = clasSynthese.getSheetAt(0);

		FileInputStream fileSolde = new FileInputStream(new File(
				"C://ETATS//ACCES_SALLE COUVERTE DROIT_" + date + ".xls"));
		HSSFWorkbook clasSolde = new HSSFWorkbook(fileSolde);
		HSSFSheet feuiSolde = clasSolde.getSheetAt(0);

		FileInputStream fileRecharg = new FileInputStream(new File(
				"C://ETATS//ACCES_SALLE COUVERTE GAUCHE_" + date + ".xls"));
		HSSFWorkbook clasRecharge = new HSSFWorkbook(fileRecharg);
		HSSFSheet feuiRecharge = clasRecharge.getSheetAt(0);

		FileInputStream fileCycleVie = new FileInputStream(new File(
				"C://ETATS//ACCES_BIBLIOTHEQUE DROIT_" + date + ".xls"));
		HSSFWorkbook clasCyclVie = new HSSFWorkbook(fileCycleVie);
		HSSFSheet feuiCycleVie = clasCyclVie.getSheetAt(0);

		FileInputStream fileSynthRes = new FileInputStream(new File("C://ETATS//ACCES_BIBLIOTHEQUE GAUCHE_" + date + ".xls"));
		HSSFWorkbook clasSynRes = new HSSFWorkbook(fileSynthRes);
		HSSFSheet feuiSynRes = clasSynRes.getSheetAt(0);
		
		FileInputStream filePentree = new FileInputStream(new File(
				"C://ETATS//ACCES_PORTE  PRINCIPAL ENTREE_" + date + ".xls"));
		HSSFWorkbook clasEntreePrincipal = new HSSFWorkbook(filePentree);
		HSSFSheet feuiEntrePrin = clasEntreePrincipal.getSheetAt(0);
		
		FileInputStream filePmrB= new FileInputStream(new File(
				"C://ETATS//ACCES_PMR BIBLIOTHEQUE_" + date + ".xls"));
		HSSFWorkbook clasPmrB = new HSSFWorkbook(filePmrB);
		HSSFSheet feuiPmrB = clasPmrB.getSheetAt(0);
		
		FileInputStream filePmrSC = new FileInputStream(new File(
				"C://ETATS//ACCES_PMR SALLE COUVERTTE_" + date + ".xls"));
		HSSFWorkbook clasfilePmrSC = new HSSFWorkbook(filePmrSC);
		HSSFSheet feuiclasfilePmrSC = clasfilePmrSC.getSheetAt(0);
		FileInputStream filePortePrincipalSortie = new FileInputStream(new File(
				"C://ETATS//ACCES_PORTE  PRINCIPAL SORTIE_" + date + ".xls"));
		HSSFWorkbook clasPortPrincSortie = new HSSFWorkbook(filePortePrincipalSortie);
		HSSFSheet feuiclasfilePortPrincSort = clasPortPrincSortie.getSheetAt(0);
		// new File("D://Solde"+date+".xls"));
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet1 = wb.createSheet("PORTE  PRINCIPAL ENTREE");
		HSSFSheet sheet2 = wb.createSheet("PORTE  PRINCIPAL SORTIE");
		HSSFSheet sheet3 = wb.createSheet("BUVETTE ZERKTOUNI DROIT");
		HSSFSheet sheet4 = wb.createSheet("BUVETTE ZERKTOUNI GAUCHE");
		HSSFSheet sheet5 = wb.createSheet("BUVETTE MOULAY DRISS");
		HSSFSheet sheet6 = wb.createSheet("BIBLIOTHEQUE DROIT");
		HSSFSheet sheet7 = wb.createSheet("BIBLIOTHEQUE GAUCHEE");
		HSSFSheet sheet8 = wb.createSheet("PMR BIBLIOTHEQUEE");
		HSSFSheet sheet9 = wb.createSheet("SALLE COUVERTE DROIT");
		HSSFSheet sheet10 = wb.createSheet("PMR SALLE COUVERTTE");
		CopySheets.copySheets(sheet1, feuiEntrePrin);
		CopySheets.copySheets(sheet2, feuiclasfilePortPrincSort);
		CopySheets.copySheets(sheet3, feuille);
		CopySheets.copySheets(sheet4, feuiRecharge);
		CopySheets.copySheets(sheet5, feuSynthese);
		CopySheets.copySheets(sheet6, feuiCycleVie);
		CopySheets.copySheets(sheet7, feuiSynRes);
		CopySheets.copySheets(sheet8, feuiPmrB);
		CopySheets.copySheets(sheet9, feuiSolde);
		CopySheets.copySheets(sheet10, feuiclasfilePmrSC);
	
		FileOutputStream o = new FileOutputStream(new File("C://ACCES_OCP//ETAT_ACCES_" + date
				+ ".xls"));
		wb.write(o);
		o.close();

	}

public void executeExcel(){
	try {
		fusionner();
	} catch (Exception e) {
e.printStackTrace();
	}
}

}
