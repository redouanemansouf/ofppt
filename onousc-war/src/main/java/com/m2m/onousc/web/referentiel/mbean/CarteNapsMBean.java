package com.m2m.onousc.web.referentiel.mbean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.common.FieldsControler;
import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.criteria.CarteNapsCriteria;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.CarteNapsVO;
import com.m2m.onousc.business.referentiel.vo.PersonnelVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.business.utils.Utils;
import com.m2m.onousc.web.referentiel.IReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.impl.ReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.webbean.CarteNapsWebBean;
import com.m2m.technicalservices.log.ILogger;
import com.m2m.technicalservices.log.impl.SL4JLogger;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;
import com.m2m.technicalservices.web.UserSession;

import au.com.bytecode.opencsv.CSVWriter;

/**
 * The Class PersonnelMBean.
 */
@ManagedBean
@ViewScoped
public class CarteNapsMBean extends BaseMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6226164679887561384L;

	private static final ILogger LOGGER = SL4JLogger.getInstance(CarteNapsMBean.class);

	int imp = 0;
	int rejet = 0;

	List<File> resultList = new ArrayList<File>();

	List<String> filenameslst = new ArrayList<String>();

	private static final String IMPORT_INSCRIPTION_START = "MESSAGE_IMPORT_SUCCES";

	/** Directory where to download logs for local **/
//	File directory = new File("C:\\FichiersMX\\rejets\\");
	/** Directory where to download logs for 172.19.34.20 **/
	File directory = new File("/home/amalha/FichiersMX/rejets");
	/** Directory where to download logs for UM6P **/
//	 File directory = new File("/home/napsadmin/FichiersMX/rejets");

	File file = new File("");

	String flname;

	public String getFlname() {
		return flname;
	}

	public void setFlname(String flname) {
		this.flname = flname;
	}

	public File getDirectory() {
		return directory;
	}

	public void setDirectory(File directory) {
		this.directory = directory;
	}

	public List<String> getFilenameslst() {
		return filenameslst;
	}

	public void setFilenameslst(List<String> filenameslst) {
		this.filenameslst = filenameslst;
	}

	public List<File> getResultList() {
		return resultList;
	}

	// public HashMap<Integer, String> getFilenameslst() {
	// return filenameslst;
	// }

	// public void setFilenameslst(HashMap<Integer, String> filenameslst) {
	// this.filenameslst = filenameslst;
	// }

	public void setResultList(List<File> resultList) {
		this.resultList = resultList;
	}

	IReferentielBusDelegate delegate = new ReferentielBusDelegate();
	/** Directory where imported CSV are stored **/
//	private static final String path_root = "C:\\FichiersMX\\imports\\";
//	 private static final String path_root =
//	 "/home/napsadmin/FichiersMX/imports/";
	private static final String path_root = "/home/amalha/FichiersMX/imports/";

	// private static final String path_rejet = "C:\\FichiersMX\\rejets";

//	private CarteNapsWebBean webBean = new CarteNapsWebBean();
	private CarteNapsWebBean webBean;

	public CarteNapsWebBean getWebBean() {
		return webBean;
	}

	public void setWebBean(CarteNapsWebBean webBean) {
		this.webBean = webBean;
	}

	ReferentielSrvPresentation referentielSrvPresentation = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");

	private UserSession userSesion;
	private UserEntityVO userEntityVo;
	boolean fichierOK = false;

	private CarteNapsCriteria carteNapsCriteria;

	ReferentielService referentielSrc = (ReferentielService) BeansLookuper.lookup("referentielService");

	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");

	UserEntityVO user = referentielService.findUserEntityByCode(userSession.getUserConecte().getCode());

	public void init() {
		setUserSesion((UserSession) JSFUtils.getSession("userSession"));
		userEntityVo = referentielSrvPresentation.findUserByCode(userSession.getUserConecte().getCode());

		carteNapsCriteria = new CarteNapsCriteria();
		webBean = new CarteNapsWebBean();
		webBean.setListSiteForCombo(referentielService.findAllSite());

		// File directory = new File("C:\\FichiersMX");

		// get all the files from a directory
		File[] fList = directory.listFiles();
		if (fList != null) {
			resultList.addAll(Arrays.asList(fList));

			for (File f : fList) {

				String current_file = f.getAbsolutePath();
				if (f.isFile()) {
					System.out.println(current_file);
					filenameslst.add(current_file);
				}

			}
		}

		// File[] fList = directory.listFiles();
		// resultList.addAll(Arrays.asList(fList));
		//
		// for (int i=0;i<fList.length;i++) {
		//
		// String current_file = fList[i].getAbsolutePath();
		// if (fList[i].isFile()) {
		// System.out.println(current_file);
		// filenameslst.put(i, current_file);
		// }
		//
		// }

	}

	public void importFichierMXListener(FileUploadEvent event) {
		clearReport();
		String filename = FilenameUtils.getBaseName(event.getFile().getFileName());
		// String filename = "fichier.csv";
		try {
			// Path folder = Paths.get(path_root);
			Path folder = Paths.get(path_root);
			// String filename =
			// FilenameUtils.getBaseName(event.getFile().getFileName());

			String extension = FilenameUtils.getExtension(event.getFile().getFileName());
			Path file = Files.createTempFile(folder, filename + "-", "." + extension);

			InputStream input = event.getFile().getInputstream();
			Files.copy(input, file, StandardCopyOption.REPLACE_EXISTING);

			filename = file.getFileName().toString();
			// //////////////////////////////////////////
			final File importedFile = new File(path_root + filename);
			if (importedFile != null) {
				final UserSession finalUserSesion = userSession;
				final String finalPath = importedFile.getPath();

				try {
					analyserFichier(importedFile, finalUserSesion, finalPath);
					// addPrezMsgInfo(IMPORT_INSCRIPTION_START, null);
//							 FacesContext.getCurrentInstance();
//							 System.out.println(FacesContext.getCurrentInstance());
//							 FacesContext.getCurrentInstance().addMessage(null,
//							 new FacesMessage(FacesMessage.SEVERITY_ERROR,
//							 "Error!", "Import Done"));
//							JOptionPane.showMessageDialog(null, "Le fichier à été importé");

				} catch (Exception e) {
					e.printStackTrace();

				}

//				FacesContext.getCurrentInstance().addMessage(null,
//						 new FacesMessage(FacesMessage.SEVERITY_INFO,
//						 "Le fichier à été importé"
//								 +"Nombre de ligne valide "+imp+"/br"+"Nombre de ligne invalide " +rejet, "Import Done"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		feedReport();
	}

	public void analyserFichier(File importedFile, UserSession userSession, String importedFilePath)
			throws IOException {
		Object methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		webBean.setImportedFile(importedFile);
		FileReader fr = new FileReader(importedFile);
		BufferedReader br = new BufferedReader(fr);
		long lineNumber = 0;

		String line;
		CSVWriter writer;
		CSVWriter writerRejet;

		try {
			/** Création log pour local **/
//			File fichier = Utils.creerFichir("fichierMXimports.csv",
//					"C:\\FichiersMX\\imports\\", "csv");
//			webBean.setFileRejet(Utils.creerFichir("fichierMXRejets.csv",
//					"C:\\FichiersMX\\rejets\\", "csv"));

			/** Création log pour 172.19.34.20 **/
			File fichier = Utils.creerFichir("fichierMXimports.csv", "/home/amalha/FichiersMX/imports/", "csv");
			webBean.setFileRejet(Utils.creerFichir("fichierMXRejets.csv", "/home/amalha/FichiersMX/rejets/", "csv"));

			/** Création log pour server client UM6P **/
//			 File fichier = Utils.creerFichir("fichierMXimports.csv",
//			 "/home/napsadmin/FichiersMX/imports/", "csv");
//			 webBean.setFileRejet(Utils.creerFichir("fichierMXRejets.csv",
//			 "/home/napsadmin/FichiersMX/rejets/", "csv"));

			writer = new CSVWriter(new FileWriter(fichier), ';', CSVWriter.NO_QUOTE_CHARACTER);
			writerRejet = new CSVWriter(new FileWriter(webBean.getFileRejet()), ';', CSVWriter.NO_QUOTE_CHARACTER);

			LOGGER.error("Start analysing ME");

			while ((line = br.readLine()) != null) {
				if (lineNumber == 0) {
					lineNumber++;
					continue;
				}
				String[] tabs = line.split(";", -1);
				CarteNapsVO vo = new CarteNapsVO();
				UserEntityVO user = referentielService.findUserEntityByCode(userSession.getUserConecte().getCode());
				if (user.getSiteVO() != null)
					vo.setSiteVO(user.getSiteVO());
				if (tabs.length != 8) {
					if (tabs[0] != null) {
						vo.setNomprenom(tabs[0]);
					}
					// vo.setNomprenom(tabs[0]);
					// vo.setNom(tabs[1]);
					// vo.setPrenom(tabs[2]);
					// vo.setNumidentite(tabs[3]);
					// vo.setTel(tabs[4]);
					// vo.setEtab(tabs[5]);
					// vo.setMatr(tabs[6]);
					// vo.setNumcarte(tabs[7]);
					vo.setMotifRejet("erreur Nombre de champs de la Ligne N° " + lineNumber);
					webBean.setNbrLignesRejets(1 + webBean.getNbrLignesRejets());
					webBean.getListRejets().add(vo);
					vo.setNumcarte("Nombre de champ invalide");
					// vo.setMotifRejet("Nombre de champ invalide dans la ligne "
					// +webBean.getNbrLignesRejets());
					rejet = rejet + 1;
					ecrireLigneFichier(writerRejet, webBean.getFileRejet(), vo);
					continue;
				} else {
					CarteNapsStructure row = new CarteNapsStructure();
					row.setNomprenom(tabs[0]);
					row.setNom(tabs[1]);
					row.setPrenom(tabs[2]);
					row.setNumidentite(tabs[3]);
					row.setTel(tabs[4]);
					row.setEtab(tabs[5]);
					row.setMatr(tabs[6]);
					row.setNumcarte(tabs[7]);

					// Pattern.compile("^[0-9]{1,2}(.[0-9]{1,2})?$");
					Pattern p = Pattern.compile("^[0,\\+]+[0]*[0-9]{9,15}$");

					/** Partie contrôle des champs **/

					// ///NOMPRENOM

					if (!FieldsControler.isBlank(row.getNomprenom())) {

						if (row.getNomprenom().length() < 2) {
							vo.setNomprenom(row.getNomprenom() + " -INVALIDE");
							vo.setMotifRejet("Nom et prenom invalide");

						} else {

							vo.setNomprenom(row.getNomprenom());

							// ////NOM

							if (!FieldsControler.isBlank(row.getNom())) {
								if (row.getNom().length() < 2) {
									vo.setNom(row.getNom() + "-INVALIDE");
									vo.setMotifRejet(" Nom invalide");

								}

								else {
									vo.setNom(row.getNom());

									// ///PRENOM

									if (!FieldsControler.isBlank(row.getPrenom())) {
										if (row.getPrenom().length() < 2) {
											vo.setPrenom(row.getPrenom() + "-INVALIDE");
											vo.setMotifRejet("Prenom invalide");

										}

										else {
											vo.setPrenom(row.getPrenom());

											// //NUM IDENTITE

											if (!FieldsControler.isBlank(row.getNumidentite().replaceAll("\\s+", ""))) {
												if (row.getNumidentite().replaceAll("\\s+", "").length() < 2) {
													vo.setNumidentite(row.getNumidentite() + "-INVALIDE");
													vo.setMotifRejet("Num ID invalide");

												}

												else {
													vo.setNumidentite(row.getNumidentite().replaceAll("\\s+", ""));
													// //Tel
													// a.replaceAll("\\s+","");
													String notel = row.getTel().replaceAll("\\s+", "");
													if (!FieldsControler.isBlank(notel)) {
														Matcher mTel = p.matcher(notel);
														boolean matchFoundTel = mTel.matches();
														if (!matchFoundTel) {
															vo.setTel(row.getTel() + "-INVALIDE");
															vo.setMotifRejet("Tel invalide");

														}

														else {
															vo.setTel(notel);
															// Etablissement
															if (!FieldsControler
																	.isBlank(row.getEtab().replaceAll("\\s+", ""))) {

																if (row.getEtab().replaceAll("\\s+", "").length() < 2) {
																	vo.setEtab(row.getEtab() + "-INVALIDE");
																	vo.setMotifRejet("Etablissement invalide");

																} else {
																	vo.setEtab(row.getEtab().replaceAll("\\s+", ""));

																	// Matricule
																	if (!FieldsControler.isBlank(
																			row.getMatr().replaceAll("\\s+", ""))) {
																		CarteNapsVO verifMatr = referentielSrvPresentation
																				.findCarteNapsByMatricule(
																						row.getMatr());

																		if (verifMatr != null) {
																			vo.setMatr(row.getMatr()
																					+ " -INVALIDE / DOUBLON");
																			vo.setMotifRejet(
																					"Matricule invalide/doublons");

																		} else {
																			vo.setMatr(row.getMatr().replaceAll("\\s+",
																					""));

																			// num
																			// carte

																			if (!FieldsControler
																					.isBlank(row.getNumcarte()
																							.replaceAll("\\s+", ""))) {

																				if (row.getNumcarte()
																						.replaceAll("\\s+", "")
																						.length() > 16
																						|| row.getNumcarte()
																								.replaceAll("\\s+", "")
																								.length() < 16) {
																					vo.setNumcarte(row.getNumcarte()
																							+ "-INVALIDE");
																					vo.setMotifRejet(
																							"Numero carte invalide");

																				} else {
																					vo.setNumcarte(row.getNumcarte()
																							.replaceAll("\\s+", ""));
																				}
																			}
																		}
																	}
																}

															}
														}
													} else {
														vo.setTel(row.getTel() + "-INVALIDE");
														vo.setMotifRejet("Tel invalide");
													}

												}
											} else {
												vo.setNumidentite(row.getNumidentite() + "-INVALIDE");
												vo.setMotifRejet("Num ID invalide");
											}
										}
									} else {
										vo.setPrenom(row.getPrenom() + "-INVALIDE");
										vo.setMotifRejet("Prenom invalide");
									}
								}
							} else {
								vo.setNom(row.getNom() + "-INVALIDE");
								vo.setMotifRejet(" Nom invalide");
							}

						}
					}

					else {
						vo.setNomprenom(row.getNomprenom() + " -INVALIDE");
						vo.setMotifRejet("Nom et prenom invalide");

					}

				}

				if (vo.getMotifRejet() == null) {
					webBean.setNbrLignesValides(webBean.getNbrLignesValides() + 1);
					vo.setStatut(EntityStatus.ENABLED);
					imp = imp + 1;
				} else {
					webBean.setNbrLignesRejets(webBean.getNbrLignesRejets() + 1);
					vo.setStatut(EntityStatus.DISABLED);
					webBean.getListRejets().add(vo);
					ecrireLigneFichier(writerRejet, webBean.getFileRejet(), vo);
					rejet = rejet + 1;
				}

//				FacesContext.getCurrentInstance().addMessage(null,
//						 new FacesMessage(FacesMessage.SEVERITY_INFO,
//						 "Le fichier à été importé"
//								 +"Nombre de ligne valide "+imp+"/br"+"Nombre de ligne invalide " +rejet, "Import Done"));

				webBean.getListLignes().add(vo);
				ecrireLigneFichier(writer, fichier, vo);

			}
			br.close();
			br = null;
			// InsererListe ????
			if (webBean.getListLignes().size() != 0) {
				insererListe(webBean, userSession);

				webBean.getListLignes().clear();

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		if (br != null) {
			br.close();
			br = null;
		}

//		FacesContext.getCurrentInstance().addMessage(null,
//				 new FacesMessage(FacesMessage.SEVERITY_INFO,
//				 "Le fichier à été importé"
//						 +"Nombre de ligne valide "+imp+"/br"+"Nombre de ligne invalide " +rejet, "Import Done"));
	}

	public void ecrireLigneFichier(CSVWriter writer, File fichier, CarteNapsVO ligne) {
		try {
			writer.writeNext(new String[] { ligne.getNomprenom(), ligne.getNom(), ligne.getPrenom(),
					ligne.getNumidentite(), ligne.getTel(), ligne.getEtab(), ligne.getMatr(), ligne.getNumcarte() });
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insererListe(CarteNapsWebBean webBean, UserSession userSession) {

//		for (CarteNapsVO line : webBean.getListLignes()) {
//
//			error = delegate.creerCarteNaps(line, userSession.getUserConecte());
//			if (error) {
//				continue;
//			}
//			if (!error) {
//				addPrezMsgInfo("MESSAGE_SUCCESS_EDIT", null);
//
//			}
//			if (line.getMotifRejet() != null) {
//				continue;
//			}
//
//		}
		/** Inserer les lignes individuel dans la table d'imports **/
		for (CarteNapsVO line : webBean.getListLignes()) {
			clearReport();
			error = delegate.creerCarteNaps(line, userSession.getUserConecte());
			if (error) {
				continue;
			}
			if (!error) {

			}

			feedReport();
			if (line.getMotifRejet() != null) {
				continue;
			}

		}

		showMessage();

	}

	/** Message après import **/
	public void message() {

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Le fichier à été importé :", "Import Done"));

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,

				"Nombre de lignes importées :	" + imp, "Import Done"));

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Nombre de lignes rejetées :	" + rejet, "Import Done"));
	}

	/** lire le repertoire des rejets **/
	public void readrep() {

		try {
			File f = new File("C:\\FichiersMX");

			FilenameFilter filter = new FilenameFilter() {
				@Override
				public boolean accept(File f, String name) {
					// We want to find only .c files
					return name.endsWith(".c");
				}
			};

			// Note that this time we are using a File class as an array,
			// instead of String
			File[] files = f.listFiles(filter);

			// Get the names of the files by using the .getName() method
			for (int i = 0; i < files.length; i++) {
				System.out.println(files[i].getName());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	/** Méthode pour telecharger les fichiers rejets **/
	public void downloadFile(Integer selectedIndex) {
		File file = new File(filenameslst.get(selectedIndex));
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
		response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
		response.setContentLength((int) file.length());
		FileInputStream input = null;
		try {
			int i = 0;
			input = new FileInputStream(file);
			byte[] buffer = new byte[1024];
			while ((i = input.read(buffer)) != -1) {
				response.getOutputStream().write(buffer);
				response.getOutputStream().flush();
			}
			facesContext.responseComplete();
			facesContext.renderResponse();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (input != null) {
					input.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void recupfile() {
		filenameslst.toString();
	}

	public UserSession getUserSession() {
		return userSession;
	}

	public void setUserSession(UserSession userSession) {
		this.userSession = userSession;
	}

	public boolean isFichierOK() {
		return fichierOK;
	}

	public void setFichierOK(boolean fichierOK) {
		this.fichierOK = fichierOK;
	}

	public UserEntityVO getUserEntityVo() {
		return userEntityVo;
	}

	public void setUserEntityVo(UserEntityVO userEntityVo) {
		this.userEntityVo = userEntityVo;
	}

	public UserSession getUserSesion() {
		return userSesion;
	}

	public void setUserSesion(UserSession userSesion) {
		this.userSesion = userSesion;
	}

	public void resetWebBeanVO() {
		webBean.setVo(new CarteNapsVO());
	}

	/**
	 * methode modifier plusieurs personnel depuis l'import jusqu'a la table
	 * personnel
	 **/
	public void modifiermass() {
		clearReport();

		webBean.getVo();
		webBean.getSelectedVOs().size();
		for (CarteNapsVO impo : webBean.getSelectedVOs()) {
			impo.setCategorie(webBean.getVo().getCategorie());
			PersonnelVO p = new PersonnelVO();
			p.setNom(impo.getNom());
			p.setPrenom(impo.getPrenom());
			p.setMatr(impo.getMatr());
			p.setNumidentite(impo.getNumidentite());
			p.setTelephone(impo.getTel());
			p.setEtab(impo.getEtab());
			p.setNumcarte(impo.getNumcarte());
			p.setStatut(EntityStatus.PERSONALIZED);
			p.setCategorie(impo.getCategorie());
			ReferentielBusDelegate delegate = new ReferentielBusDelegate();
			ReferentielBusDelegate delegate2 = new ReferentielBusDelegate();

			error = delegate.creerPersoFromCarteNaps(p);
//			impo.setId(webBean.getVo().getId());
			impo.setStatut(EntityStatus.DISABLED);
			error = delegate2.modifierCarteNaps(impo);

		}

		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_EDIT", null);

		}
		feedReport();
	}

	public CarteNapsCriteria getCarteNapsCriteria() {
		return carteNapsCriteria;
	}

	public void setCarteNapsCriteria(CarteNapsCriteria carteNapsCriteria) {
		this.carteNapsCriteria = carteNapsCriteria;
	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<CarteNapsVO>());
	}

	public void showMessage() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Le fichier à été importé :"));

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nombre de lignes importées :	" + imp));

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nombre de lignes rejetées :	" + rejet));

	}

	/** methode d'accès et de droit a l'écran **/
	@Override
	protected boolean isAutorise() {
		return hasEcran(Constantes.CODE_IMP_PERSO_IMP);
	}

	public UserEntityVO getUser() {
		return user;
	}

	public void setUser(UserEntityVO user) {
		this.user = user;
	}

}
