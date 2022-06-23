package com.m2m.onousc.web.referentiel.mbean;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;

import au.com.bytecode.opencsv.CSVWriter;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.common.FieldsControler;
import com.m2m.onousc.business.referentiel.model.CategoriePorteur;
import com.m2m.onousc.business.referentiel.vo.AnneeUniversitaireVO;
import com.m2m.onousc.business.referentiel.vo.CategoriePorteurVO;
import com.m2m.onousc.business.referentiel.vo.EtudiantVO;
import com.m2m.onousc.business.referentiel.vo.ImportInscriptionVO;
import com.m2m.onousc.business.referentiel.vo.InscriptionVO;
import com.m2m.onousc.business.referentiel.vo.LigneInscriptionStructure;
import com.m2m.onousc.business.referentiel.vo.MonitoringEchangeVO;
import com.m2m.onousc.business.referentiel.vo.RestaurantVO;
import com.m2m.onousc.business.referentiel.vo.SiteVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.business.referentiel.vo.VilleVO;

import com.m2m.onousc.web.commons.UnzipUtility;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.impl.ReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.search.ImportInscriptionSearchMBean;
import com.m2m.onousc.web.referentiel.webbean.InscriptionWebBean;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;
import com.m2m.technicalservices.web.UserSession;

@ManagedBean
@ViewScoped
public class InscriptionMBean extends BaseMBean {

	/**
	 * 
	 */

	private static final long serialVersionUID = 4952046077043799287L;

	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");

	private InscriptionWebBean webBean = new InscriptionWebBean();
	private List<InscriptionVO> inscriptionVOs;
	private List<ImportInscriptionVO> importInscriptionVOs;

	private final String PROBLEME_COPY_FILE = "Problème d'Import de Fichier";
	private final String PROBLEME_CITE = "IMPORT_INSCRIPTION_CISTE ";
	private static final String IMPORT_INSCRIPTION_START = "IMPORT_INSCRIPTION_START";
	/*
	 * private static final String path_root = "C:\\Fichiers des Inscription\\";
	 * private static final String path_upload =
	 * "C:\\Carte_UCAD\\Photos_Porteurs\\UPLOAD\\"; private static final String
	 * path_rejet = "C:\\Fichiers des Inscription\\Rejet\\";
	 */
	private static final String path_root = "/opt/Fichiers des Inscription";
	private static final String path_upload = "/opt/Carte_UCAD/Photos_Porteurs/UPLOAD/";
	private static final String path_rejet = "/opt/Fichiers des Inscription/Rejet/";

	@ManagedProperty("#{importInscriptionSearchMBean}")
	private ImportInscriptionSearchMBean importInscriptionSearchMBean;

	private AnneeUniversitaireVO anneeUniversitaireVO;

	private String message;

	private String fileRejectPath;

	public void init() {

		UserSession userSesion = (UserSession) JSFUtils.getSession("userSession");

		importInscriptionSearchMBean.getCriteria().setUserName(userSesion.getUserConecte().getCode());

		importInscriptionSearchMBean.run();
	}

	public void insertInscriptionListener(FileUploadEvent event) {
		clearReport();
		UserSession userSesion = (UserSession) JSFUtils.getSession("userSession");
		UserEntityVO userEntityVO = referentielService.findUserByCode(userSesion.getUserConecte().getCode());

		ReferentielBusDelegate delegate = new ReferentielBusDelegate();

		importInscriptionVOs = new ArrayList<ImportInscriptionVO>();
		try {
			Path folder = Paths.get(path_root);
			Path folderImg = Paths.get(path_upload);
			String fileCSV = "";
			String filename = FilenameUtils.getBaseName(event.getFile().getFileName());
			String extension = FilenameUtils.getExtension(event.getFile().getFileName());
			Path file = Files.createTempFile(folder, filename + "-", "." + extension);

			InputStream input = event.getFile().getInputstream();
			Files.copy(input, file, StandardCopyOption.REPLACE_EXISTING);

			UnzipUtility unzipper = new UnzipUtility();
			try {
				fileCSV = unzipper.unzip(file.toString(), folder.toString(), folderImg.toString());
			} catch (Exception ex) {
				// some errors occurred
				ex.printStackTrace();
			}
			File f = new File(fileCSV);

			MonitoringEchangeVO echange = new MonitoringEchangeVO();

			echange.setEntite(userEntityVO.getGroupname());
			echange.setTypeFichier("INSCRIPTION");
			echange.setDateImport(new Date());
			echange.setResponsable(userSesion.getUserConecte().getCode());
			echange.setPath(f.getPath());
			webBean.setVo(echange);
			error = delegate.creerMonitoringEchange(webBean);
			final File ff = f;
			final UserSession userSesion1 = userSesion;
			final String pathh = f.getPath();
			if (!error) {

//				class OneShotTask implements Runnable {
//
//					OneShotTask() {
//					}
//
//					public void run() {
//						try {
//							uploadInscription(ff, userSesion1, pathh);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//				}
//				Thread t = new Thread(new OneShotTask());
//				t.start();
				uploadInscription(ff, userSesion1, pathh, userEntityVO.getSiteVO().getId());
				addPrezMsgInfo(IMPORT_INSCRIPTION_START, null);
				importInscriptionSearchMBean.run();
			}
		} catch (Exception e) {
			e.printStackTrace();
			addInfoMessage(PROBLEME_COPY_FILE, FacesMessage.SEVERITY_ERROR);
		}

		feedReport();
	}

	private static byte[] readContentIntoByteArray(File file) {
		FileInputStream fileInputStream = null;
		byte[] bFile = new byte[(int) file.length()];
		try {
			// convert file into array of bytes
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bFile;
	}

	public void exportExemple() {
		Path folder = Paths.get(path_root);
		File importReject = new File(folder + "//exemple.csv");
		String filename = importReject.getName();
		if (importReject.exists() && !importReject.isDirectory() && importReject.length() != 0) {
			byte[] exportContent = readContentIntoByteArray(importReject);
			FacesContext fc = FacesContext.getCurrentInstance();
			ExternalContext ec = fc.getExternalContext();
			ec.responseReset();
			ec.setResponseContentType("text/plain");
			ec.setResponseContentLength(exportContent.length);
			String attachmentName = "attachment; filename=\"" + filename + ".csv\"";
			ec.setResponseHeader("Content-Disposition", attachmentName);
			try {
				OutputStream output = ec.getResponseOutputStream();
				Streams.copy(new ByteArrayInputStream(exportContent), output, false);
			} catch (IOException ex) {
				ex.printStackTrace();
			}

			fc.responseComplete();
		}
	}
	public void exportExempleZip() {
		Path folder = Paths.get(path_root);
		File importReject = new File(folder + "//exemple.zip");
		String filename = importReject.getName();
		if (importReject.exists() && !importReject.isDirectory() && importReject.length() != 0) {
			byte[] exportContent = readContentIntoByteArray(importReject);
			FacesContext fc = FacesContext.getCurrentInstance();
			ExternalContext ec = fc.getExternalContext();
			ec.responseReset();
			ec.setResponseContentType("text/plain");
			ec.setResponseContentLength(exportContent.length);
			String attachmentName = "attachment; filename=\"" + filename + "\"";
			ec.setResponseHeader("Content-Disposition", attachmentName);
			try {
				OutputStream output = ec.getResponseOutputStream();
				Streams.copy(new ByteArrayInputStream(exportContent), output, false);
			} catch (IOException ex) {
				ex.printStackTrace();
			}

			fc.responseComplete();
		}
	}
	public void exportDoc() {
		Path folder = Paths.get(path_root);
		File importReject = new File(folder + "//doc.docx");
		String filename = importReject.getName();
		if (importReject.exists() && !importReject.isDirectory() && importReject.length() != 0) {
			byte[] exportContent = readContentIntoByteArray(importReject);
			FacesContext fc = FacesContext.getCurrentInstance();
			ExternalContext ec = fc.getExternalContext();
			ec.responseReset();
			ec.setResponseContentType("application/vnd.openxmlformats-officedocument.presentationml.presentation");
			ec.setResponseContentLength(exportContent.length);
			String attachmentName = "attachment; filename=\"" + filename + ".docx\"";
			ec.setResponseHeader("Content-Disposition", attachmentName);
			try {
				OutputStream output = ec.getResponseOutputStream();
				Streams.copy(new ByteArrayInputStream(exportContent), output, false);
			} catch (IOException ex) {
				ex.printStackTrace();
			}

			fc.responseComplete();
		}
	}

	public void export() {

		
		System.out.print(fileRejectPath);
		File importReject = new File(fileRejectPath);
		String filename = importReject.getName();
		if (importReject.exists() && !importReject.isDirectory() && importReject.length() != 0) {
			byte[] exportContent = readContentIntoByteArray(importReject);
			FacesContext fc = FacesContext.getCurrentInstance();
			ExternalContext ec = fc.getExternalContext();
			ec.responseReset();
			ec.setResponseContentType("text/plain");
			ec.setResponseContentLength(exportContent.length);
			String attachmentName = "attachment; filename=\"" + filename + ".csv\"";
			ec.setResponseHeader("Content-Disposition", attachmentName);
			try {
				OutputStream output = ec.getResponseOutputStream();
				Streams.copy(new ByteArrayInputStream(exportContent), output, false);
			} catch (IOException ex) {
				ex.printStackTrace();
			}

			fc.responseComplete();
		}
	}

	@SuppressWarnings("unused")
	public void uploadInscription(File file, UserSession userSesion, String path, long site) throws IOException {
		clearReport();
		SiteVO siteVO = null;
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		inscriptionVOs = new ArrayList<InscriptionVO>();
		importInscriptionVOs = new ArrayList<ImportInscriptionVO>();
		anneeUniversitaireVO = referentielService.findActuelAnneeUniversitaire();
		siteVO = referentielService.findSite(site);
		RestaurantVO restaurantVO = null;
		/**
		 * Create a csv file of rejects lines
		 */
		Path folder = Paths.get(path_rejet);
		String filename = FilenameUtils.getBaseName("rejet_inscription");
		Path fileReject = Files.createTempFile(folder, filename + "-", "." + "csv");
		fileRejectPath = fileReject.toString();
		File freject = new File(fileReject.toString());

		/**
		 * Create a csv file of rejects lines
		 */

		CSVWriter writer = new CSVWriter(new FileWriter(freject.getPath()), ';', CSVWriter.NO_QUOTE_CHARACTER);

		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		int i = 0;
		int nbrLingImporter = 0;
		int nbrLingRejete = 0;
		int nbrCNEerr = 0;
		int nbrSautLigne = 0;
		int nbrdoub = 0;
		for (String line = br.readLine(); line != null; line = br.readLine()) {
			if (i == 0) {
				i = i + 1;
				continue;
			}
			if (siteVO == null) {
				writer.writeNext(
						new String[] { line, "Problème d'Import!! Compte n'est pas affecté a une restaurant" });
				break;
			}
			List<RestaurantVO> restaurantVOtemp= referentielService.findRestaurantBySite(siteVO.getId());
			 if (restaurantVOtemp != null) {
				 if (restaurantVOtemp.size() > 0) {
					 restaurantVO = restaurantVOtemp.get(0);
					}  
			 }

			 
//			 if (restaurantVOtemp != null) {
//				  restaurantVO = citeVO.getRestaurantVo();
//					if (restaurantVO == null) {
//						addInfoMessage(PROBLEME_COPY_FILE, FacesMessage.SEVERITY_ERROR);
//						return;
//					}
//				}
			InscriptionVO inscriptionVO = null;
			ImportInscriptionVO importInscriptionVO = null;
			EtudiantVO etudiantVO = null;

			VilleVO villeVO = null;

			/*
			 * 
			 * 
			 * */
			String[] tabs = line.split(";", -1);
			if (tabs.length == 12) {
				tabs = new String[] { tabs[0], tabs[1], tabs[2], tabs[3], tabs[4], tabs[5], tabs[6], tabs[7], tabs[8],
						tabs[9], tabs[10] , tabs[11] };
			}
			if (tabs.length == 12) {

				LigneInscriptionStructure ligneInscriptionStructure = new LigneInscriptionStructure();

				ligneInscriptionStructure.setCin(tabs[0].replace(" ", "")); // non fournis
				ligneInscriptionStructure.setDateNaissance(tabs[1]);
				ligneInscriptionStructure.setNom(tabs[2]);
				ligneInscriptionStructure.setPrenom(tabs[3]);
				ligneInscriptionStructure.setSexe(tabs[4]);
				
				ligneInscriptionStructure.setCodeProfil(tabs[5]);
				ligneInscriptionStructure.setSite(String.valueOf(siteVO.getId())); // non fournis
				// ligneInscriptionStructure.setBoursier(tabs[7]); // email
				ligneInscriptionStructure.setEmail(tabs[6]);
				ligneInscriptionStructure.setCodeMassar(tabs[7].replace(" ", ""));
				 
				ligneInscriptionStructure.setTypeCarte(tabs[8]);
				ligneInscriptionStructure.setTypePersonelle(tabs[9]);
				ligneInscriptionStructure.setTele(tabs[10]);
				ligneInscriptionStructure.setEtablissement(tabs[11]);

				if (!FieldsControler.isAlphaNumeric(ligneInscriptionStructure.getCin())) {

					importInscriptionVO = new ImportInscriptionVO();
					importInscriptionVO.setCin(ligneInscriptionStructure.getCin());
					importInscriptionVO.setMotifRejet("CIN Invalide");
					importInscriptionVO.setUserName(userSesion.getUserConecte().getCode());
					importInscriptionVO.setDateOperation(new Date());

					importInscriptionVOs.add(importInscriptionVO);

					nbrLingRejete++;
					nbrCNEerr++;
					i++;

					writer.writeNext(new String[] { tabs[0], tabs[1], tabs[2], tabs[3], tabs[4], tabs[5], tabs[6],
							tabs[7], tabs[8], tabs[9],tabs[10],tabs[11], "CIN Invalide" });
					continue;
				}

				Date dateNaissance = FieldsControler.extractDateFromString(ligneInscriptionStructure.getDateNaissance(),
						"dd/MM/yyyy");

				if (dateNaissance == null) {

					if (importInscriptionVO == null) {
						importInscriptionVO = new ImportInscriptionVO();
						importInscriptionVO.setCin(ligneInscriptionStructure.getCin());
						importInscriptionVO.setMotifRejet("DateNaissance Invalide");
						importInscriptionVO.setUserName(userSesion.getUserConecte().getCode());
						importInscriptionVO.setDateOperation(new Date());
					} else {
						importInscriptionVO.setMotifRejet(importInscriptionVO.getMotifRejet() + "_" + "DateNaissance Invalide");
					}
					
					 
				}

				if (FieldsControler.isBlank(ligneInscriptionStructure.getNom())) {

					if (importInscriptionVO == null) {
						importInscriptionVO = new ImportInscriptionVO();
						importInscriptionVO.setCin(ligneInscriptionStructure.getCin());
						importInscriptionVO.setMotifRejet("Nom Invalid");
						importInscriptionVO.setUserName(userSesion.getUserConecte().getCode());
						importInscriptionVO.setDateOperation(new Date());
					} else {
						importInscriptionVO.setMotifRejet(importInscriptionVO.getMotifRejet() + "_" + "Nom Invalid");
					}
				}
				if (FieldsControler.isBlank(ligneInscriptionStructure.getPrenom())) {

					if (importInscriptionVO == null) {
						importInscriptionVO = new ImportInscriptionVO();
						importInscriptionVO.setCin(ligneInscriptionStructure.getCin());
						importInscriptionVO.setMotifRejet("Prénom Invalid");
						importInscriptionVO.setUserName(userSesion.getUserConecte().getCode());
						importInscriptionVO.setDateOperation(new Date());
					} else {
						importInscriptionVO.setMotifRejet(importInscriptionVO.getMotifRejet() + "_" + "Prénom Invalid");
					}
				}

				if (!"F".equals(ligneInscriptionStructure.getSexe()) && !"M".equals(ligneInscriptionStructure.getSexe())
						&& !"Fille".equals(ligneInscriptionStructure.getSexe())
						&& !"Garçon".equals(ligneInscriptionStructure.getSexe())) {

					if (importInscriptionVO == null) {
						importInscriptionVO = new ImportInscriptionVO();
						importInscriptionVO.setCin(ligneInscriptionStructure.getCin());
						importInscriptionVO.setMotifRejet("Genre Invalid");
						importInscriptionVO.setUserName(userSesion.getUserConecte().getCode());
						importInscriptionVO.setDateOperation(new Date());
					} else {
						importInscriptionVO.setMotifRejet(importInscriptionVO.getMotifRejet() + "_" + "Genre Invalid");
					}
				}
				
				if (FieldsControler.isBlank(ligneInscriptionStructure.getCodeProfil())) {

					if (importInscriptionVO == null) {
						importInscriptionVO = new ImportInscriptionVO();
						importInscriptionVO.setCin(ligneInscriptionStructure.getCin());
						importInscriptionVO.setMotifRejet("Code Profil Invalid");
						importInscriptionVO.setUserName(userSesion.getUserConecte().getCode());
						importInscriptionVO.setDateOperation(new Date());
					} else {
						importInscriptionVO.setMotifRejet(importInscriptionVO.getMotifRejet() + "_" + "Code Profil Invalid");
					} 
				}
				 

				if (!"".equals(ligneInscriptionStructure.getEmail())
						&& !ligneInscriptionStructure.getEmail().isEmpty()) {
					if (!FieldsControler.isMailValide(ligneInscriptionStructure.getEmail())) {

						if (importInscriptionVO == null) {
							importInscriptionVO = new ImportInscriptionVO();
							importInscriptionVO.setCin(ligneInscriptionStructure.getCin());
							importInscriptionVO.setMotifRejet("EMail Invalid");
							importInscriptionVO.setUserName(userSesion.getUserConecte().getCode());
							importInscriptionVO.setDateOperation(new Date());
						} else {
							importInscriptionVO
									.setMotifRejet(importInscriptionVO.getMotifRejet() + "_" + "EMail Invalid");
						}
					}
				}

				if (!FieldsControler.isAlphaNumeric(ligneInscriptionStructure.getCodeMassar())
						|| ligneInscriptionStructure.getCodeMassar().length() != 10) {
					if (importInscriptionVO == null) {
						importInscriptionVO = new ImportInscriptionVO();
						importInscriptionVO.setCin(ligneInscriptionStructure.getCin());
						importInscriptionVO.setMotifRejet("Code Massar Invalid");
						importInscriptionVO.setUserName(userSesion.getUserConecte().getCode());
						importInscriptionVO.setDateOperation(new Date());
					} else {
						importInscriptionVO
								.setMotifRejet(importInscriptionVO.getMotifRejet() + "_" + "Code Massar Invalid");
					}

				}

				if (!"N".equals(ligneInscriptionStructure.getTypeCarte())
						&& !"P".equals(ligneInscriptionStructure.getTypeCarte()) ) {

					if (importInscriptionVO == null) {
						importInscriptionVO = new ImportInscriptionVO();
						importInscriptionVO.setCin(ligneInscriptionStructure.getCin());
						importInscriptionVO.setMotifRejet("Type Carte Invalid");
						importInscriptionVO.setUserName(userSesion.getUserConecte().getCode());
						importInscriptionVO.setDateOperation(new Date());
					} else {
						importInscriptionVO
								.setMotifRejet(importInscriptionVO.getMotifRejet() + "_" + "Type Carte Invalid");
					}
				}
				if (!"E".equals(ligneInscriptionStructure.getTypePersonelle())
						&& !"S".equals(ligneInscriptionStructure.getTypePersonelle()) ) {

					if (importInscriptionVO == null) {
						importInscriptionVO = new ImportInscriptionVO();
						importInscriptionVO.setCin(ligneInscriptionStructure.getCin());
						importInscriptionVO.setMotifRejet("Catégorie  Invalid");
						importInscriptionVO.setUserName(userSesion.getUserConecte().getCode());
						importInscriptionVO.setDateOperation(new Date());
					} else {
						importInscriptionVO
								.setMotifRejet(importInscriptionVO.getMotifRejet() + "_" + "Catégorie  Invalid");
					}
				}
				if ("".equals(ligneInscriptionStructure.getTele()) ) {

					if (importInscriptionVO == null) {
						importInscriptionVO = new ImportInscriptionVO();
						importInscriptionVO.setCin(ligneInscriptionStructure.getCin());
						importInscriptionVO.setMotifRejet("Téléphone  Invalid");
						importInscriptionVO.setUserName(userSesion.getUserConecte().getCode());
						importInscriptionVO.setDateOperation(new Date());
					} else {
						importInscriptionVO
								.setMotifRejet(importInscriptionVO.getMotifRejet() + "_" + "Téléphone  Invalid");
					}
				}
				if ("".equals(ligneInscriptionStructure.getEtablissement()) ) {

					if (importInscriptionVO == null) {
						importInscriptionVO = new ImportInscriptionVO();
						importInscriptionVO.setCin(ligneInscriptionStructure.getCin());
						importInscriptionVO.setMotifRejet("Etablissement  Invalid");
						importInscriptionVO.setUserName(userSesion.getUserConecte().getCode());
						importInscriptionVO.setDateOperation(new Date());
					} else {
						importInscriptionVO
								.setMotifRejet(importInscriptionVO.getMotifRejet() + "_" + "Etablissement  Invalid");
					}
				}
				List<CategoriePorteurVO> cat = referentielService
						.findCategoriePorteurListByCode(ligneInscriptionStructure.getCodeProfil());
				
				
				if (cat.size()==0 ) {

					if (importInscriptionVO == null) {
						importInscriptionVO = new ImportInscriptionVO();
						importInscriptionVO.setCin(ligneInscriptionStructure.getCin());
						importInscriptionVO.setMotifRejet("Code Profil Invalid");
						importInscriptionVO.setUserName(userSesion.getUserConecte().getCode());
						importInscriptionVO.setDateOperation(new Date());
					} else {
						importInscriptionVO
								.setMotifRejet(importInscriptionVO.getMotifRejet() + "_" + "Code Profil Invalid");
					}
				}
				
				
				
				if (importInscriptionVO == null) {
					try {
						etudiantVO = referentielService
								.findResidentStudentForInscription(ligneInscriptionStructure.getCin());
					} catch (Exception e) {

					}

					if (etudiantVO == null) {
						etudiantVO = referentielService
								.findResidentStudentForInscriptionMassar(ligneInscriptionStructure.getCodeMassar());
					}
					
					
					
				
					if (etudiantVO == null) {

						if (!recordWaitingForPersiste(inscriptionVOs, ligneInscriptionStructure.getCin())
								&& !recordWaitingForPersisteMassar(inscriptionVOs,
										ligneInscriptionStructure.getCodeMassar())) {

							if ("F".equals(ligneInscriptionStructure.getSexe())) {
								ligneInscriptionStructure.setSexe("F");
							} else {
								ligneInscriptionStructure.setSexe("M");
							}

						
							inscriptionVO = new InscriptionVO(ligneInscriptionStructure.getCin(), dateNaissance,
									ligneInscriptionStructure.getNom(), ligneInscriptionStructure.getPrenom(),
									ligneInscriptionStructure.getSexe(), EntityStatus.ENABLED, path, siteVO.getVille(),
									siteVO, restaurantVO, restaurantVO != null ? restaurantVO.getVilleVO() : null,
									ligneInscriptionStructure.getEmail(), anneeUniversitaireVO,
									ligneInscriptionStructure.getCodeMassar(),
									ligneInscriptionStructure.getTypePersonelle(),ligneInscriptionStructure.getEtablissement(),
									ligneInscriptionStructure.getCodeProfil(),ligneInscriptionStructure.getTele(),ligneInscriptionStructure.getTypeCarte());
							if (inscriptionVO != null) {
								inscriptionVOs.add(inscriptionVO);
								nbrLingImporter++;
							}

						} else {
							writer.writeNext(new String[] { tabs[0], tabs[1], tabs[2], tabs[3], tabs[4], tabs[5],
									tabs[6], tabs[7], tabs[8], tabs[9],tabs[10],tabs[11], "Redondance de CIN ou Code Massar" });
							nbrLingRejete++;
							nbrdoub++;
						}
						/************************************************/

						/************************************************/
					} else {

						String messageErreur = "";

						switch (etudiantVO.getStatut()) {
						case ENABLED:
							messageErreur = "Etudiant ayant une demande en cours";
							break;
						case VALIDATED:
							messageErreur = "Etudiant ayant une demande validée";
							break;
						default:
							messageErreur = "Etudiant déjà inscrit";
							break;
						}

						importInscriptionVO = new ImportInscriptionVO();
						importInscriptionVO.setCin(ligneInscriptionStructure.getCin());
						importInscriptionVO.setMotifRejet(messageErreur);
						importInscriptionVO.setUserName(userSesion.getUserConecte().getCode());
						importInscriptionVO.setDateOperation(new Date());
						importInscriptionVO.setCodeMassar(ligneInscriptionStructure.getCodeMassar());

					}

				}

				if (importInscriptionVO != null) {
					nbrLingRejete++;
					importInscriptionVOs.add(importInscriptionVO);
					writer.writeNext(new String[] { tabs[0], tabs[1], tabs[2], tabs[3], tabs[4], tabs[5], tabs[6],
							tabs[7], tabs[8], tabs[9],tabs[10],tabs[11], importInscriptionVO.getMotifRejet() });
				}

				if (inscriptionVOs.size() == 1000) {
					error = delegate.creerInscription(inscriptionVOs, userSesion.getUserConecte());
					inscriptionVOs.clear();
				}

				if (importInscriptionVOs.size() == 1000) {
					error = delegate.creerImportInscription(importInscriptionVOs, userSesion.getUserConecte());
					importInscriptionVOs.clear();

				}

			} else {

				writer.writeNext(new String[] { line, "Problème de Saut de Ligne" });
				nbrSautLigne++;
				nbrLingRejete++;
			}
			i++;
		}

		br.close();
		writer.close();

		if (inscriptionVOs.size() != 0) {
			error = delegate.creerInscription(inscriptionVOs, userSesion.getUserConecte());
			inscriptionVOs.clear();

		}
		if (importInscriptionVOs.size() != 0) {
			error = delegate.creerImportInscription(importInscriptionVOs, userSesion.getUserConecte());
			importInscriptionVOs.clear();

		}

		message = "<fond color=#0A1875>Bonjour, </fond><br>";
		message += "<br>";
		message += "<br>";
		message += "<fond color=#0A1875>Vous trouvez ci-dessous l'état de l'import du Fichier des Inscriptions</fond><br>";
		message += "<br>";
		message += "<fond color=#0A1875>Nombre Total de Lignes sur le Fichier  : " + (nbrLingImporter + nbrLingRejete)
				+ "</fond><br>";
		message += "<fond color=#0A1875>Nombre de Lignes Importées : " + nbrLingImporter + "</fond><br>";
		message += "<fond color=#0A1875>Nombre de Lignes Rejetées : " + nbrLingRejete + "</fond><br>";
		message += "<br>";
		message += "<fond color=#0A1875>Détail sur les lignes Rejetées : " + "</fond><br>";
		message += "<br>";
		message += " " + " " + " " + "-" + " "
				+ "<fond color=#0A1875>Nombre de lignes avec erreur de Contrôle de Données  : "
				+ (nbrLingRejete - nbrCNEerr - nbrSautLigne - nbrdoub) + " " + "</fond><br>";
		message += "<br>";
		message += " " + " " + " " + "-" + " " + "<fond color=#0A1875>Nombre de lignes avec la CIN erronée  : "
				+ nbrCNEerr + " " + "</fond><br>";
		message += "<br>";
		message += " " + " " + " " + "-" + " "
				+ "<fond color=#0A1875>Nombre de lignes avec problème de saut de ligne  : " + nbrSautLigne + " "
				+ "</fond><br>";
		message += "<br>";
		message += " " + " " + " " + "-" + " "
				+ "<fond color=#0A1875>Nombre de lignes avec problème de redondance de la CIN  : " + nbrdoub + " "
				+ "</fond><br>";
		message += "<br>";
		message += "<br>";
		message += "<fond color=#0A1875>Cet email est généré automatiquement, Veuillez ne pas répondre </fond>";

	}

	public boolean recordWaitingForPersiste(List<InscriptionVO> list, String cin) {
		boolean existe = false;
		for (InscriptionVO record : list) {
			if (record.getCin().equals(cin)) {
				return true;
			}
		}
		return existe;
	}

	public boolean recordWaitingForPersisteMassar(List<InscriptionVO> list, String massar) {
		boolean existe = false;
		for (InscriptionVO record : list) {
			if (record.getCodeMassar().equals(massar)) {
				return true;
			}
		}
		return existe;
	}

	public ImportInscriptionSearchMBean getImportInscriptionSearchMBean() {
		return importInscriptionSearchMBean;
	}

	public void setImportInscriptionSearchMBean(ImportInscriptionSearchMBean importInscriptionSearchMBean) {
		this.importInscriptionSearchMBean = importInscriptionSearchMBean;
	}

	public String getFileRejectPath() {
		return fileRejectPath;
	}

	public void setFileRejectPath(String fileRejectPath) {
		this.fileRejectPath = fileRejectPath;
	}

}
