package com.m2m.onousc.web.commons;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JApplet;
import javax.swing.JOptionPane;

public class AppletWeb extends JApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String version = "Applet version : 1.0";

	public static String resultat = "....\n";
	public static boolean verifier = false;
	public static boolean actionTermine;
	public static boolean erreurCategorieCarte;
	private static Encodeur encodeur = new Encodeur();

	// Syntaxe Message JOptionPane.showMessageDialog(null, nationalite);

	// info Etudiant

	public static String catge = "E";
	public static String pine = "0000";
	public static String idEtudiant ;
	public static String nomNaissEtudiant ;
	public static String prenomEtudiant ;
	public static String nomMaritalEtudiant;
	public static String ineEtudiant;
	public static String sexeEtudiant ;
	public static String dateNaissEtudiant;
	public static String lieuNaissEtudiant;
	public static String cniEtudiant ;
	public static String nationaliteEtudiant ;
	public static String adreEmailEtudiant;
	public static String etab1Etudiant ;
	public static String etab2Etudiant;
	public static String bourseEtudiant;
	public static String nivSect1Etudiant;
	public static String nivSect2Etudiant;
	public static String annAcademiqueEtudiant;
	public static String infoBuEtudiant;
	public static String infoCoudEtudiant;
	public static String infoservicesEtudiant;
	public static String datemajservicesEtudiant;
	public static String datedelivrancecarteEtudiant;
	public static String dateexpirationcarteEtudiant;
	public static String SEXE_BOURSE_BU_COUD;
	// public String codeBarreEtudiant;
	public static String DNAIS_ETU ;
	public static String CITE_ETUD ;
	public static String Statut ;
	// info Personnel

	public static String catgp = "P";
	public static String pinp = "0000";
	public static String id;
	public static String numEmploi;
	public static String matr;
	public static String dateEmbauche;
	public static String nomNaissance;
	public static String prenom;
	public static String nomMaritalPersonnel;
	public static String sexe;
	public static String dateNaissance;
	public static String lieuNaissance;
	public static String cni;
	public static String nationalite;
	public static String email;
	public static String structAffect;
	public static String classification;
	public static String grade;
	public static String categorie;
	public static String infoservicesPersonnel;
	public static String datemajservicesPersonnel;
	public static String datedelivrancecartePersonnel;
	public static String dateexpirationcartePersonnel;

	// info Visiteur

	public static String catgv = "V";
	public static String pinv = "0000";
	public static String NomnaissanceVisiteur;
	public static String PrenomVisiteur;
	public static String NommaritalVisiteur;
	public static String SexeVisiteur;
	public static String DatedenaissanceVisiteur;
	public static String LieunaissanceVisiteur;
	public static String cnivisiteur;
	public static String DatedebutvaliditéVisiteur;
	public static String DateFinvaliditéVisiteur;
	public static String NationaliteVisiteur;
	public static String EntiteprovenanceVisiteur;
	public static String FonctionVisiteur;
	public static String StructureaccueilVisiteur;
	public static String ObjetpresenceVisiteur;
	public static String infoservicesVisiteur;
	public static String datemajservicesVisiteur;

	public static void getVersion() {
		//JOptionPane.showMessageDialog(null, version, "M2MGroup", 1, null);
	}

	public static boolean lancerPersoElectrique(final int a) {

		try {

			AccessController.doPrivileged(new PrivilegedExceptionAction<Boolean>() {
				public Boolean run() throws Exception {

					actionTermine = false;
					resultat += "Debut fonction lancerPersoElectrique\n";

					if (!encodeur.verifierLecteur())
						return false;

					if (a == 1) {

						Date date_expEtu = new Date();
						Date date_DelivEtu = new Date();
						GregorianCalendar calendarExpEtu = new java.util.GregorianCalendar();
						GregorianCalendar calendarDelivEtu = new java.util.GregorianCalendar();

						calendarDelivEtu.setTime(date_DelivEtu);
						calendarExpEtu.setTime(date_expEtu);

						calendarDelivEtu.add(Calendar.YEAR, 0);
						calendarExpEtu.add(Calendar.YEAR, 1);
						date_expEtu = calendarExpEtu.getTime();

						DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
						dateexpirationcarteEtudiant = df.format(date_expEtu);
						datedelivrancecarteEtudiant = df.format(date_DelivEtu);
						datemajservicesEtudiant = df.format(date_DelivEtu);
						/*
						 * resultat += "Lancer perso etudiant\n"; resultat +=
						 * encodeur.encoder(catge + ";" + pine+ ";" +
						 * idEtudiant,"IDENTIFICATION_ETU"); resultat +=
						 * encodeur.encoder(nomNaissEtudiant,"NOM_ETU");
						 * resultat +=
						 * encodeur.encoder(prenomEtudiant,"PRENOM_ETU");
						 * resultat += encodeur.encoder(nomMaritalEtudiant,
						 * "MARITAL_ETU"); resultat +=
						 * encodeur.encoder(sexeEtudiant + bourseEtudiant+
						 * infoBuEtudiant+ infoCoudEtudiant + ";"+
						 * dateNaissEtudiant,
						 * "SEXE_BOURSE_BU_COUD_DATENAISSANCE_ETU"); resultat +=
						 * encodeur.encoder(lieuNaissEtudiant,"LIEU_NAISS_ETU");
						 * resultat += encodeur.encoder(cniEtudiant,"CNI_ETU");
						 * resultat += encodeur.encoder(ineEtudiant,"INE_ETU");
						 * resultat += encodeur.encoder(nationaliteEtudiant,
						 * "NATIONALITE_ETU"); resultat +=
						 * encodeur.encoder(adreEmailEtudiant,"EMAIL_ETU");
						 * resultat +=
						 * encodeur.encoder(etab1Etudiant,"ETABLISSEMENT_1_ETU")
						 * ; resultat +=
						 * encodeur.encoder(etab2Etudiant,"ETABLISSEMENT_2_ETU")
						 * ; resultat +=
						 * encodeur.encoder(nivSect1Etudiant,"SECTION_1_ETU");
						 * resultat +=
						 * encodeur.encoder(nivSect2Etudiant,"SECTION_2_ETU");
						 * resultat += encodeur.encoder(annAcademiqueEtudiant,
						 * "ANNEE_ACAD"); resultat +=
						 * encodeur.encoder(datedelivrancecarteEtudiant,
						 * "DATE_DELCARTEETU"); resultat +=
						 * encodeur.encoder(dateexpirationcarteEtudiant,
						 * "DATE_EXPCARTEETU"); resultat +=
						 * encodeur.encoder(infoservicesEtudiant,
						 * "INFO_SERVICEETU"); resultat +=
						 * encodeur.encoder(datemajservicesEtudiant,
						 * "DMAJ_SERVICEETU");
						 */

						resultat += "Lancer perso etudiant\n";
						resultat += encodeur.encode(cniEtudiant, "CNI_ETU");
						resultat += encodeur.encode(DNAIS_ETU, "DNAIS_ETU");
						resultat += encodeur.encode(nomNaissEtudiant, "NOM_ETU");
						resultat += encodeur.encode(prenomEtudiant, "PRENOM_ETU");
						resultat += encodeur.encode(idEtudiant, "ID_ETU");
						resultat += encodeur.encode(sexeEtudiant, "SEXE_ETU");
						resultat += encodeur.encode(CITE_ETUD, "CITE_ETU");
						resultat += encodeur.encode(etab1Etudiant, "ETAB_ETU");
						resultat += encodeur.encode(nationaliteEtudiant, "NATIONALITE_ETU");
						resultat += encodeur.encode(Statut, "STATUT");
						resultat += encodeur.encode(dateexpirationcarteEtudiant, "DATE_EXPCARTE");
						actionTermine = true;
						init_data(1);
					}

					if (a == 2) {

						Date date_expPer = new Date();
						Date date_DelivPer = new Date();
						GregorianCalendar calendarExpPer = new java.util.GregorianCalendar();
						GregorianCalendar calendarDelivPer = new java.util.GregorianCalendar();

						calendarDelivPer.setTime(date_DelivPer);
						calendarExpPer.setTime(date_expPer);

						calendarDelivPer.add(Calendar.YEAR, 0);
						calendarExpPer.add(Calendar.YEAR, 10);
						date_expPer = calendarExpPer.getTime();

						DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
						dateexpirationcartePersonnel = df.format(date_expPer);
						datedelivrancecartePersonnel = df.format(date_DelivPer);
						datemajservicesPersonnel = df.format(date_DelivPer);

						resultat += "Lancer PersoElectrique Personnel\n";
						resultat += encodeur.encoder(catgp + ";" + pinp + ";" + matr, "IDENTIFICATION_PERS");
						resultat += encodeur.encoder(nomNaissance, "NOM_PERS");
						resultat += encodeur.encoder(prenom, "PRENOM_PERS");
						resultat += encodeur.encoder(nomMaritalPersonnel, "MARITAL_PERS");
						resultat += encodeur.encoder(sexe + ";" + dateNaissance, "SEXE_DATENAISSANCE_PERS");
						resultat += encodeur.encoder(lieuNaissance, "LIEUNAISS_PERS");
						resultat += encodeur.encoder(cni, "CNI_PERS");
						resultat += encodeur.encoder(nationalite, "NATIONALITE_PERS");
						resultat += encodeur.encoder(email, "EMAIL_PERS");
						resultat += encodeur.encoder(structAffect, "STRUCTURE_PERS");
						resultat += encodeur.encoder(classification, "CLASSIFICATION_PERS");
						resultat += encodeur.encoder(grade, "GRADE_PERS");
						resultat += encodeur.encoder(dateEmbauche, "DATEEMBAUCHE_PERS");
						resultat += encodeur.encoder(numEmploi, "NUM_EMPLOI_PERS");
						resultat += encodeur.encoder(datedelivrancecartePersonnel, "DATE_DELCARTEPERS");
						resultat += encodeur.encoder(dateexpirationcartePersonnel, "DATE_EXPCARTEPERS");
						resultat += encodeur.encoder(infoservicesPersonnel, "INFO_SERVICEPERS");
						resultat += encodeur.encoder(datemajservicesPersonnel, "DMAJ_SERVICEPERS");
						actionTermine = true;
						init_data(2);
					}

					if (a == 3) {

						resultat += "Lancer PersoElectrique Visiteur\n";
						resultat += encodeur.encoder(catgv + ";" + pinv, "IDENTIFICATION_VISITEUR");
						resultat += encodeur.encoder(NomnaissanceVisiteur, "NOM_VISITEUR");
						resultat += encodeur.encoder(PrenomVisiteur, "PRENOM_VISITEUR");
						resultat += encodeur.encoder(NommaritalVisiteur, "NOMMARITAL_VISITEUR");
						resultat += encodeur.encoder(SexeVisiteur + ";" + DatedenaissanceVisiteur,
								"SEXE_DATENAISSANCE_VISITEUR");
						resultat += encodeur.encoder(LieunaissanceVisiteur, "LIEUNAI_VISITEUR");
						resultat += encodeur.encoder(cnivisiteur, "CNI_VISITEUR");
						resultat += encodeur.encoder(DatedebutvaliditéVisiteur, "DATEDEB_VISITEUR");
						resultat += encodeur.encoder(DateFinvaliditéVisiteur, "DATEFIN_VISITEUR");
						resultat += encodeur.encoder(NationaliteVisiteur, "NATIONALITE_VISITEUR");
						resultat += encodeur.encoder(EntiteprovenanceVisiteur, "ENTITEPROV_VISITEUR");
						resultat += encodeur.encoder(FonctionVisiteur, "FONCTION_VISITEUR");
						resultat += encodeur.encoder(StructureaccueilVisiteur, "STRUCTUREACC_VISITEUR");
						resultat += encodeur.encoder(ObjetpresenceVisiteur, "OBJETVISIT_VISITEUR");
						resultat += encodeur.encoder(infoservicesVisiteur, "INFOSERVICE_VISITEUR");
						resultat += encodeur.encoder(datemajservicesVisiteur, "DATEMAJSERVICE_VISITEUR");
						actionTermine = true;
						init_data(3);
					}

					resultat += "Fin fonction lancerPersoElectrique\n";

					return true;
				}
			});

		} catch (Exception e) {
			resultat += "lancerPersoElectrique exception : " + e + "\n";
			actionTermine = false;
			return actionTermine;
		}

		return actionTermine;

	}

	public static boolean lancerLectureElectrique(final int a) {

		try {

			AccessController.doPrivileged(new PrivilegedExceptionAction<Boolean>() {
				public Boolean run() throws Exception {

					actionTermine = false;
					resultat += "Debut fonction lancerLectureElectrique\n";

					String categoriecarte = "E";

					String[] blocidentification = new String[3];
					String[] blocSexeBourseBuCoud = new String[2];
					String[] blocSexeDateNaiss = new String[2];
					String[] blocSexeDateNaissVisiteur = new String[2];

					if (!encodeur.verifierLecteur())
						return false;

					byte[] blocs = { (byte) 0x01 };

					blocidentification = encodeur.lecture(blocs).split(";");
					categoriecarte = blocidentification[0];

					if (a == 1) {

						erreurCategorieCarte = false;
						// if (!categoriecarte.equals("E")) {
						// erreurCategorieCarte = true;
						// return true;
						//
						// }
						resultat += "Lancer Lecture Etudiant\n";

						// Lecture Données Etudiants

						// idEtudiant = blocidentification[2];

						byte[] blocnomNaissEtudiant = { (byte) 0x04, (byte) 0x05, (byte) 0x06 };
						nomNaissEtudiant = encodeur.lecture(blocnomNaissEtudiant).trim();

						byte[] blocprenomEtudiant = { (byte) 0x08, (byte) 0x09 };
						prenomEtudiant = encodeur.lecture(blocprenomEtudiant).trim();
						byte[] blocCin = { (byte) 0x01 };

						cniEtudiant = encodeur.lecture(blocCin).trim();
						/*
						 * SEXE_BOURSE_BU_COUD = blocSexeBourseBuCoud[0];
						 * sexeEtudiant = SEXE_BOURSE_BU_COUD.substring(0, 1);
						 * bourseEtudiant = SEXE_BOURSE_BU_COUD.substring(1, 2);
						 * infoBuEtudiant = SEXE_BOURSE_BU_COUD.substring(2, 3);
						 * infoCoudEtudiant = SEXE_BOURSE_BU_COUD.substring(3,
						 * 4); dateNaissEtudiant = blocSexeBourseBuCoud[1];
						 */
						// sexeEtudiant

						byte[] blocDNAIS_ETU = { (byte) 0x02 };
						DNAIS_ETU = encodeur.lecture(blocDNAIS_ETU).trim();

						byte[] blocidEtudiant = { (byte) 0x0A };
						idEtudiant = encodeur.lecture(blocidEtudiant).trim();

						byte[] blocsexeEtudiant = { (byte) 0x0C };
						sexeEtudiant = encodeur.lecture(blocsexeEtudiant).trim();

						byte[] blocCITE_ETUD = { (byte) 0x0D };
						CITE_ETUD = encodeur.lecture(blocCITE_ETUD).trim();
						
						byte[] blocetab1Etudiant = { (byte) 0x0E };
						etab1Etudiant = encodeur.lecture(blocetab1Etudiant).trim();

						byte[] blocenationaliteEtudiant = {  (byte) 0x10 };
						nationaliteEtudiant = encodeur.lecture(blocenationaliteEtudiant).trim();

						byte[] blocStatut = { (byte) 0x11 };
						Statut = encodeur.lecture(blocStatut).trim();

						byte[] blocdateexpirationcarteEtudiant = { (byte) 0x12 };
						dateexpirationcarteEtudiant = encodeur.lecture(blocdateexpirationcarteEtudiant).trim();

					/*	byte[] blocannAcademiqueEtudiant = { (byte) 0x30 };
						annAcademiqueEtudiant = encodeur.lecture(blocannAcademiqueEtudiant).trim();

						byte[] blocdatedelivrancecarteEtudiant = { (byte) 0x31 };
						datedelivrancecarteEtudiant = encodeur.lecture(blocdatedelivrancecarteEtudiant).trim();

						byte[] blocdateexpirationcarteEtudiant = { (byte) 0x32 };
						dateexpirationcarteEtudiant = encodeur.lecture(blocdateexpirationcarteEtudiant).trim();

						byte[] blocinfoservicesEtudiant = { (byte) 0x34, (byte) 0x35, (byte) 0x36 };
						infoservicesEtudiant = encodeur.lecture(blocinfoservicesEtudiant).trim();

						byte[] blocdatemajservicesEtudiant = { (byte) 0x38 };
						datemajservicesEtudiant = encodeur.lecture(blocdatemajservicesEtudiant).trim();*/

						resultat += "/n" + nomNaissEtudiant+"/n" + idEtudiant+"/n" + cniEtudiant+"/n" + dateexpirationcarteEtudiant;
						actionTermine = true;

					}

					if (a == 2) {
						erreurCategorieCarte = false;
						if (!categoriecarte.equals("P")) {
							erreurCategorieCarte = true;
							return true;

						}
						resultat += "Lancer Lecture Personnel\n";

						matr = blocidentification[2];

						byte[] blocnomNaissance = { (byte) 0x02, (byte) 0x04, (byte) 0x05, (byte) 0x06 };
						nomNaissance = encodeur.lecture(blocnomNaissance).trim();

						byte[] blocprenom = { (byte) 0x08, (byte) 0x09, (byte) 0x0A, (byte) 0x0C };
						prenom = encodeur.lecture(blocprenom).trim();

						byte[] blocnomMaritalPersonnel = { (byte) 0x0D, (byte) 0x0E };
						nomMaritalPersonnel = encodeur.lecture(blocnomMaritalPersonnel).trim();

						byte[] blocSEXE_DATENAISSANCE = { (byte) 0x10 };

						blocSexeDateNaiss = encodeur.lecture(blocSEXE_DATENAISSANCE).split(";");
						sexe = blocSexeDateNaiss[0];
						dateNaissance = blocSexeDateNaiss[1];

						byte[] bloclieuNaissance = { (byte) 0x11, (byte) 0x12 };
						lieuNaissance = encodeur.lecture(bloclieuNaissance).trim();

						byte[] bloccni = { (byte) 0x14 };
						cni = encodeur.lecture(bloccni).trim();

						byte[] blocnationalite = { (byte) 0x16, (byte) 0x18 };
						nationalite = encodeur.lecture(blocnationalite).trim();

						byte[] blocemail = { (byte) 0x19, (byte) 0x1A, (byte) 0x1C };
						email = encodeur.lecture(blocemail).trim();

						byte[] blocstructAffect = { (byte) 0x1D, (byte) 0x1E };
						structAffect = encodeur.lecture(blocstructAffect).trim();

						byte[] blocclassification = { (byte) 0x20, (byte) 0x21 };
						classification = encodeur.lecture(blocclassification).trim();

						byte[] blocgrade = { (byte) 0x22, (byte) 0x24 };
						grade = encodeur.lecture(blocgrade).trim();

						byte[] blocdateEmbauche = { (byte) 0x25 };
						dateEmbauche = encodeur.lecture(blocdateEmbauche).trim();

						byte[] blocnumEmploi = { (byte) 0x26 };
						numEmploi = encodeur.lecture(blocnumEmploi).trim();

						byte[] blocdatedelivrancecartePersonnel = { (byte) 0x31 };
						datedelivrancecartePersonnel = encodeur.lecture(blocdatedelivrancecartePersonnel).trim();

						byte[] blocdateexpirationcartePersonnel = { (byte) 0x32 };
						dateexpirationcartePersonnel = encodeur.lecture(blocdateexpirationcartePersonnel).trim();

						byte[] blocinfoservicesPersonnel = { (byte) 0x34, (byte) 0x35, (byte) 0x36 };
						infoservicesPersonnel = encodeur.lecture(blocinfoservicesPersonnel).trim();

						byte[] blocdatemajservicesPersonnel = { (byte) 0x38 };
						datemajservicesPersonnel = encodeur.lecture(blocdatemajservicesPersonnel).trim();

						actionTermine = true;

					}

					if (a == 3) {

						erreurCategorieCarte = false;
						if (!categoriecarte.equals("V")) {
							erreurCategorieCarte = true;
							return true;

						}
						resultat += "Lancer Lecture Visiteur\n";

						byte[] blocNomnaissanceVisiteur = { (byte) 0x02, (byte) 0x04, (byte) 0x05, (byte) 0x06 };
						NomnaissanceVisiteur = encodeur.lecture(blocNomnaissanceVisiteur).trim();
						//JOptionPane.showMessageDialog(null, NomnaissanceVisiteur);

						byte[] blocPrenomVisiteur = { (byte) 0x08, (byte) 0x09, (byte) 0x0A, (byte) 0x0C };
						PrenomVisiteur = encodeur.lecture(blocPrenomVisiteur).trim();
						//JOptionPane.showMessageDialog(null, PrenomVisiteur);

						byte[] blocNommaritalVisiteur = { (byte) 0x0D, (byte) 0x0E };
						NommaritalVisiteur = encodeur.lecture(blocNommaritalVisiteur).trim();
					//JOptionPane.showMessageDialog(null, NommaritalVisiteur);

						byte[] blocSEXE_DATENAISSANCEVISITEUR = { (byte) 0x10 };

						blocSexeDateNaissVisiteur = encodeur.lecture(blocSEXE_DATENAISSANCEVISITEUR).split(";");
						SexeVisiteur = blocSexeDateNaissVisiteur[0];
						DatedenaissanceVisiteur = blocSexeDateNaissVisiteur[1];

						//JOptionPane.showMessageDialog(null, SexeVisiteur);
					//	JOptionPane.showMessageDialog(null, DatedenaissanceVisiteur);

						byte[] blocLieunaissanceVisiteur = { (byte) 0x11, (byte) 0x12 };
						LieunaissanceVisiteur = encodeur.lecture(blocLieunaissanceVisiteur).trim();
					///	JOptionPane.showMessageDialog(null, LieunaissanceVisiteur);

						byte[] bloccnivisiteur = { (byte) 0x14 };
						cnivisiteur = encodeur.lecture(bloccnivisiteur).trim();
					//	JOptionPane.showMessageDialog(null, cnivisiteur);

						byte[] blocNationaliteVisiteur = { (byte) 0x16, (byte) 0x18 };
						NationaliteVisiteur = encodeur.lecture(blocNationaliteVisiteur).trim();
					//	JOptionPane.showMessageDialog(null, NationaliteVisiteur);

						byte[] blocEntiteprovenanceVisiteur = { (byte) 0x19, (byte) 0x1A, (byte) 0x1C };
						EntiteprovenanceVisiteur = encodeur.lecture(blocEntiteprovenanceVisiteur).trim();
					//	JOptionPane.showMessageDialog(null, EntiteprovenanceVisiteur);

						byte[] blocFonctionVisiteur = { (byte) 0x1D, (byte) 0x1E };
						FonctionVisiteur = encodeur.lecture(blocFonctionVisiteur).trim();
					//	JOptionPane.showMessageDialog(null, FonctionVisiteur);

						byte[] blocStructureaccueilVisiteur = { (byte) 0x20, (byte) 0x21 };
						StructureaccueilVisiteur = encodeur.lecture(blocStructureaccueilVisiteur).trim();
					//	JOptionPane.showMessageDialog(null, StructureaccueilVisiteur);

						byte[] blocObjetpresenceVisiteur = { (byte) 0x22, (byte) 0x24, (byte) 0x25, (byte) 0x26 };
						ObjetpresenceVisiteur = encodeur.lecture(blocObjetpresenceVisiteur).trim();
					//	JOptionPane.showMessageDialog(null, ObjetpresenceVisiteur);

						byte[] blocDatedebutvaliditéVisiteur = { (byte) 0x31 };
						DatedebutvaliditéVisiteur = encodeur.lecture(blocDatedebutvaliditéVisiteur).trim();
					//	JOptionPane.showMessageDialog(null, DatedebutvaliditéVisiteur);

						byte[] blocDateFinvaliditéVisiteur = { (byte) 0x32 };
						DateFinvaliditéVisiteur = encodeur.lecture(blocDateFinvaliditéVisiteur).trim();
					//	JOptionPane.showMessageDialog(null, DateFinvaliditéVisiteur);

						byte[] blocinfoservicesVisiteur = { (byte) 0x34, (byte) 0x35, (byte) 0x36 };
						infoservicesVisiteur = encodeur.lecture(blocinfoservicesVisiteur).trim();
				//		JOptionPane.showMessageDialog(null, infoservicesVisiteur);

						byte[] blocdatemajservicesVisiteur = { (byte) 0x38 };
						datemajservicesVisiteur = encodeur.lecture(blocdatemajservicesVisiteur).trim();
					//	JOptionPane.showMessageDialog(null, datemajservicesVisiteur);

						actionTermine = true;

					}

					resultat += "Fin fonction lancerLectureElectrique\n";

					return true;
				}
			});

		} catch (Exception e) {
			resultat += "lancerPersoElectrique exception : " + e + "\n";
			actionTermine = false;
			return actionTermine;
		}

		return actionTermine;

	}

	public static void CapturePhoto(final int a) {

		resultat += "Debut fonction CapturePhoto\n";

		try {

			AccessController.doPrivileged(new PrivilegedExceptionAction<Boolean>() {
				public Boolean run() throws Exception {

					resultat += "lancerCapturePhoto:debut execution\n";

					if (a == 1) { // Etudiant

						AppletWeb.resultat += "Capture Photo \n";

						lancer_impression(
								"cmd /c " + "C:/Carte_UCAD/Exe_Impression/DEMO_BIOM.exe " + "E" + " " + idEtudiant);
					}

					if (a == 2) { // Personnel

						AppletWeb.resultat += "Capture Photo \n";

						lancer_impression("cmd /c " + "C:/Carte_UCAD/Exe_Impression/DEMO_BIOM.exe " + "P" + " " + matr);
					}

					resultat += "Fin fonction lancerCapturePhoto\n";
					return true;
				}
			});
		} catch (Exception e) {
			resultat += "lancerCapturePhoto exception : " + e + "\n";
			actionTermine = false;
		}

	}

	public static void lancerPersoGraphique(final int a) {

		resultat += "Debut fonction lancerPersoGraphique\n";

		try {

			AccessController.doPrivileged(new PrivilegedExceptionAction<Boolean>() {
				public Boolean run() throws Exception {

					String imageGenereRecto = null;
					String imageGenereVerso = null;
					// if (actionTermine) {
					resultat += "lancerPersoGraphique:debut execution\n";
					if (a == 1) { // etudiant
						resultat += "Lancer perso graphique etudiant\n";
						// Etudiants etud = (Etudiants) obj;
						imageGenereRecto = "C:/Carte_UCAD/Cartes_PreImprimees/Etudiants/Carte_Etudiant_Recto_"
								+ idEtudiant + ".bmp";

						imageGenereVerso = "C:/Carte_UCAD/Cartes_PreImprimees/Etudiants/Carte_Etudiant_verso_"
								+ idEtudiant + ".bmp";

						String photo = "file:C:/Carte_UCAD/Photos_Porteurs/Etudiants/" + idEtudiant + ".jpg";
						PreparerImage pi = new PreparerImage(
								"file:C:/Carte_UCAD/Prototypes/Etudiants/Carte-Etudiant_Recto.bmp", photo,
								imageGenereRecto, "file:C:/Carte_UCAD/Prototypes/Etudiants/Carte-Etudiant_Verso.bmp",
								imageGenereVerso);

						AppletWeb.resultat += "in ecrireInformations \n";
			//			pi.ecrireInformations(300, 460, 30, 22, idEtudiant, nomNaissEtudiant, prenomEtudiant,
						//		cniEtudiant, CITE_ETUD);
						AppletWeb.resultat += "in ecrireVerso \n";
						pi.ecrireVerso(dateNaissEtudiant, lieuNaissEtudiant, adreEmailEtudiant);

						init_data(1);
					}

					if (a == 2) { // personnel
						System.out.println("Lancer perso graphique personnel ");
						// Personnel per = (Personnel) obj;
						imageGenereRecto = "C:/Carte_UCAD/Cartes_PreImprimees/Professionnelles/Carte_Professionnelle_Recto_"
								+ matr + ".bmp";
						imageGenereVerso = "C:/Carte_UCAD/Cartes_PreImprimees/Professionnelles/Carte_Professionnelle_Verso_"
								+ matr + ".bmp";

						String photo = "file:C:/Carte_UCAD/Photos_Porteurs/Professionnelles/" + matr + ".jpg";
						PreparerImage pi = new PreparerImage(
								"file:C:/Carte_UCAD/Prototypes/Professionnelles/Carte-Professionnelle_Recto.bmp", photo,
								imageGenereRecto,
								"file:C:/Carte_UCAD/Prototypes/Professionnelles/Carte-Professionnelle_Verso.bmp",
								imageGenereVerso);

						AppletWeb.resultat += "in ecrireInformations \n";
						pi.ecrireInformationsPerso(300, 460, 30, 22, matr, nomNaissance, prenom, nomMaritalPersonnel,
								structAffect, classification, grade);
						pi.ecrireVerso(dateNaissance, lieuNaissance, email);

						init_data(2);

					}

					if (a == 3) { // visiteur
						System.out.println("Lancer perso graphique visiteur ");
						imageGenereRecto = "C:/Carte_UCAD/Cartes_PreImprimees/Visiteurs/Visiteur_Recto_" + cnivisiteur
								+ ".bmp";
						imageGenereVerso = "C:/Carte_UCAD/Cartes_PreImprimees/Visiteurs/Visiteur_Verso_" + cnivisiteur
								+ ".bmp";

						String photo = "file:C:/Carte_UCAD/Photos_Porteurs/Professionnelles/Photo_Professionnelle.jpg";
						PreparerImage pi = new PreparerImage(
								"file:C:/Carte_UCAD/Prototypes/Visiteurs/Carte-Visiteur_Recto.bmp", photo,
								imageGenereRecto, "file:C:/Carte_UCAD/Prototypes/Visiteurs/Carte-Visiteur_Verso.bmp",
								imageGenereVerso);

						AppletWeb.resultat += "in ecrireInformations \n";
						pi.ecrireInformationsVisiteur(300, 460, 30, 22, cnivisiteur);
						pi.ecrireVersoVisiteur(cnivisiteur);

						init_data(3);
					}

					lancer_impression("cmd /c " + "C:/Carte_UCAD/Exe_Impression/impression.exe " + imageGenereRecto
							+ " " + imageGenereVerso);
					// }

					resultat += "Fin fonction lancerPersoGraphique\n";
					return true;
				}
			});
		} catch (Exception e) {
			resultat += "lancerPersoElectrique exception : " + e + "\n";
			actionTermine = false;
		}

	}

	public static void lancer_impression(String command) {
		try {

			verifier = true;
			Runtime runtime = Runtime.getRuntime();
			Process process = runtime.exec(command);
			BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
			resultat += command + "\n";
			String line = null;
			while ((line = input.readLine()) != null) {
				System.out.println(line);
			}

			// Attendre la fin de l'execution
			int j = process.waitFor();
			if (j != 0) {

				resultat += "Une erreur est survenue " + j + "\n";
				verifier = false;
			}

		} catch (Exception ex) {
			resultat += "Error1 execution commande cmd : " + ex.getMessage();
			verifier = false;
		}

	}

	private static void init_data(final int a) {

		if (a == 1) {

			// Data Etudiant

			catge = "E";
			pine = "0000";
			idEtudiant = " ";
			nomNaissEtudiant = " ";
			prenomEtudiant = " ";
			nomMaritalEtudiant = " ";
			ineEtudiant = " ";
			sexeEtudiant = " ";
			dateNaissEtudiant = " ";
			lieuNaissEtudiant = " ";
			cniEtudiant = " ";
			nationaliteEtudiant = " ";
			adreEmailEtudiant = " ";
			etab1Etudiant = " ";
			etab2Etudiant = " ";
			bourseEtudiant = " ";
			nivSect1Etudiant = " ";
			nivSect2Etudiant = " ";
			annAcademiqueEtudiant = " ";
			infoBuEtudiant = " ";
			infoCoudEtudiant = " ";
			infoservicesEtudiant = " ";
			datemajservicesEtudiant = " ";
			datedelivrancecarteEtudiant = " ";
			dateexpirationcarteEtudiant = " ";
			DNAIS_ETU = "";
			CITE_ETUD = "";
			Statut = "";
			// info Personnel

		}

		if (a == 2) {
			// Data Personnel

			catgp = "P";
			pinp = "0000";
			id = " ";
			numEmploi = " ";
			matr = " ";
			dateEmbauche = " ";
			nomNaissance = " ";
			prenom = " ";
			nomMaritalPersonnel = " ";
			sexe = " ";
			dateNaissance = " ";
			lieuNaissance = " ";
			cni = " ";
			nationalite = " ";
			email = " ";
			structAffect = " ";
			classification = " ";
			grade = " ";
			categorie = " ";
			infoservicesPersonnel = " ";
			datemajservicesPersonnel = " ";
			datedelivrancecartePersonnel = " ";
			dateexpirationcartePersonnel = " ";

		}

		if (a == 3) {

			// Data Visteur

			catgv = "V";
			pinv = "0000";
			NomnaissanceVisiteur = " ";
			PrenomVisiteur = " ";
			NommaritalVisiteur = " ";
			SexeVisiteur = " ";
			DatedenaissanceVisiteur = " ";
			LieunaissanceVisiteur = " ";
			cnivisiteur = " ";
			DatedebutvaliditéVisiteur = " ";
			DateFinvaliditéVisiteur = " ";
			NationaliteVisiteur = " ";
			EntiteprovenanceVisiteur = " ";
			FonctionVisiteur = " ";
			StructureaccueilVisiteur = " ";
			ObjetpresenceVisiteur = " ";
			infoservicesVisiteur = " ";
			datemajservicesVisiteur = " ";

		}

	}

}