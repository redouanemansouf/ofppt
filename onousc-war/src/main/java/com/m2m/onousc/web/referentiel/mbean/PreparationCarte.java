package com.m2m.onousc.web.referentiel.mbean;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;


public class PreparationCarte {

	private BufferedImage prototypeRecto;
	private BufferedImage photoPorteur;
	private String chemin_carte_recto;
	private BufferedImage prototypeVerso;
	private BufferedImage codeBarreEtu;
	private String chemin_carte_verso;
	private BufferedImage imagePrototype;



	public void PreparerImage(String cheminprotoRecto, String cheminPhoto, String chemincarteRecto,
			String cheminprotoVerso, String chemincodeBarre,String chemincarteVerso) {
		try {

			this.prototypeRecto = ImageIO.read(new File(cheminprotoRecto));
			this.photoPorteur = ImageIO.read(new File(cheminPhoto));
			this.chemin_carte_recto = chemincarteRecto;
			this.prototypeVerso = ImageIO.read(new File(cheminprotoVerso));
			this.codeBarreEtu = ImageIO.read(new File(chemincodeBarre));
			this.chemin_carte_verso = chemincarteVerso;

		} catch (IOException e) {
			e.printStackTrace();

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur de récupération des images : " + e, "Erreur de récupération des images : " + e);
			FacesContext.getCurrentInstance().addMessage( null, message );

		}

	}


	public void PreparerImageVisiteur(String cheminprotoRecto, String chemincarteRecto,
			String cheminprotoVerso, String chemincarteVerso) {
		try {

			this.prototypeRecto = ImageIO.read(new File(cheminprotoRecto));
			this.chemin_carte_recto = chemincarteRecto;
			this.prototypeVerso = ImageIO.read(new File(cheminprotoVerso));
			this.chemin_carte_verso = chemincarteVerso;

		} catch (IOException e) {
			e.printStackTrace();

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur de récupération des images : "+e, "Erreur de récupération des images : "+e);
			FacesContext.getCurrentInstance().addMessage( null, message );

		}

	}


	public void ecrireRectoEtudiant(int x, int y, int n, int taille,
			String numUniversite, String nom, String prenom, String nommarital,
			String INE, String date_naissance, String lieu_naissance,String AdresseEMail,String AnneeAcademique,String CodeEtablissement) { 

		try {

			if (nom == null || nom =="") {nom=" ";} 
			if (prenom  == null || prenom =="") {prenom=" ";}
			if (nommarital == null || nommarital =="") {nommarital=" ";}
			//if (INE == null || INE =="") {INE=" ";}
			if (date_naissance == null || date_naissance =="") {date_naissance=" ";}
			if (lieu_naissance == null || lieu_naissance =="") {lieu_naissance=" ";}
			//if (AdresseEMail == null || AdresseEMail =="") {AdresseEMail=" ";}
			//if (CodeEtablissement == null || CodeEtablissement =="") {CodeEtablissement=" ";}


			Date date_exp = new Date();
			GregorianCalendar calendar = new java.util.GregorianCalendar();
			//
			//			// Initialisé à la date et l'heure courrante.
			calendar.setTime(date_exp);

			calendar.add(Calendar.YEAR, 3);
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			date_exp = calendar.getTime();


			Graphics g = prototypeRecto.getGraphics();
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille+30));
			g.setColor(Color.WHITE);
			g.drawString(CodeEtablissement.trim().toUpperCase(), x-85, y -75- n);
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			g.drawString(""+numUniversite.trim().toUpperCase(), x-180, y+ (n*2)+50);
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			g.drawString(""+nom.trim().toUpperCase(), x-180,  y+ (n*2)+105);
			g.drawString(""+prenom.trim().toUpperCase() , x-180, y+ (n*2)+164);
		 	g.drawString("" + nommarital.trim(), x-200, y + (n * 3)+155);
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			g.drawString(date_naissance  , x-200, y + (n * 4)+180);
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			if (INE.trim().length() > 1 ) {
				g.drawString(INE.trim(), x-330, y + (n * 4)+278);
				//g.drawString(INE.trim(), x-250, y + (n * 4)+270);
				//	g.drawString(" : ", x-330, y + (n * 6)+20);
				//g.drawString(INE.trim().toUpperCase(), x-300, y + 0 + (n * 6)+20);
				g.drawString(dateFormat.format(date_exp), x+300, y + (n * 4)+274);
				//g.drawString(AnneeAcademique.trim(), x-70 , y + (n * 7)+30);
				g.dispose();
			}
			else {
				//g.drawString("Date Expiration  : " + dateFormat.format(date_exp), x-380 , y + (n * 7)+30);
				g.drawString(AnneeAcademique.trim(), x-70 , y + (n * 7)+30);
				g.dispose();
			}
			insrerImage(1);

		} catch (Exception e) {
			e.printStackTrace();

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur préparation de Carte Recto Etudiant : " + e, "Erreur préparation de Carte Recto Etudiant : " + e);
			FacesContext.getCurrentInstance().addMessage( null, message );

		}

	}
	
	public void ecrireRectoEtudiantR(int x, int y, int n, int taille,
			String numUniversite, String nom, String prenom, String nommarital,
			String INE, String date_naissance, String lieu_naissance,String AdresseEMail,String AnneeAcademique,String CodeEtablissement) { 

		try {

			if (nom == null || nom =="") {nom=" ";} 
			if (prenom  == null || prenom =="") {prenom=" ";}
			if (nommarital == null || nommarital =="") {nommarital=" ";}
			//if (INE == null || INE =="") {INE=" ";}
			if (date_naissance == null || date_naissance =="") {date_naissance=" ";}
			if (lieu_naissance == null || lieu_naissance =="") {lieu_naissance=" ";}
			//if (AdresseEMail == null || AdresseEMail =="") {AdresseEMail=" ";}
			//if (CodeEtablissement == null || CodeEtablissement =="") {CodeEtablissement=" ";}


			Date date_exp = new Date();
			GregorianCalendar calendar = new java.util.GregorianCalendar();
			//
			//			// Initialisé à la date et l'heure courrante.
			calendar.setTime(date_exp);

			calendar.add(Calendar.YEAR, 3);
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			date_exp = calendar.getTime();


			Graphics g = prototypeRecto.getGraphics();
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille+30));
			g.setColor(Color.WHITE);
			g.drawString(CodeEtablissement.trim().toUpperCase(), x-85, y -75- n);
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			g.drawString(""+numUniversite.trim().toUpperCase(), x-170, y+ (n*2)+67);
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			g.drawString(""+nom.trim().toUpperCase(), x-170,  y+ (n*2)+127);
			g.drawString(""+prenom.trim().toUpperCase() , x-170, y+ (n*2)+187);
			g.drawString("" + nommarital.trim(), x-200, y + (n * 3)+155);
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			if (INE.trim().length() > 1 ) {
				g.drawString(INE.trim(), x-330, y + (n * 4)+278);
				//g.drawString(INE.trim(), x-250, y + (n * 4)+270);
				//	g.drawString(" : ", x-330, y + (n * 6)+20);
				//g.drawString(INE.trim().toUpperCase(), x-300, y + 0 + (n * 6)+20);
				g.drawString(dateFormat.format(date_exp), x+300, y + (n * 4)+274);
				//g.drawString(AnneeAcademique.trim(), x-70 , y + (n * 7)+30);
				g.dispose();
			}
			else {
				//g.drawString("Date Expiration  : " + dateFormat.format(date_exp), x-380 , y + (n * 7)+30);
				g.drawString(AnneeAcademique.trim(), x-70 , y + (n * 7)+30);
				g.dispose();
			}
			insrerImage(1);

		} catch (Exception e) {
			e.printStackTrace();

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur préparation de Carte Recto Etudiant : " + e, "Erreur préparation de Carte Recto Etudiant : " + e);
			FacesContext.getCurrentInstance().addMessage( null, message );

		}

	}


	public void ecrireRectoPerso(int x, int y, int n, int taille, String Matr,String nom,
			String prenom, String marital,String structureAffect, String Classification,String grade, 
			String date_naissance, String lieu_naissance,String AdresseEMail) {


		try {

			if (Matr == null || Matr =="") {Matr=" ";} 
			if (nom  == null || nom =="") {nom=" ";}
			if (prenom == null || prenom =="") {prenom=" ";}
			if (grade == null || grade =="") {grade=" ";}
			if (date_naissance == null || date_naissance =="") {date_naissance=" ";}
			if (lieu_naissance == null || lieu_naissance =="") {lieu_naissance=" ";}


			Date date_exp = new Date();
			GregorianCalendar calendar = new java.util.GregorianCalendar();

			calendar.setTime(date_exp);

			calendar.add(Calendar.YEAR, 10);
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			date_exp = calendar.getTime();

			Graphics g = prototypeRecto.getGraphics();
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille+35));
			g.setColor(Color.BLACK);
			g.drawString(Matr.trim().toUpperCase(), x+275, y - 42);
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			g.drawString(prenom.trim().toUpperCase(), x-200, y + n);
			g.drawString(nom.trim().toUpperCase() + " " + marital.trim().toUpperCase(), x-200, y+ n * 2);
			g.drawString("Né(e) le " + date_naissance + ", à " + lieu_naissance.trim().toUpperCase(), x-200, y + n * 3);
			//g.drawString(structureAffect.toUpperCase() + " / " + Classification.toUpperCase(), x-200, y + (n * 4));
			g.drawString(grade.toUpperCase(), x-200, y + 0 + (n * 5));
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille-6));
			g.setColor(Color.BLACK);
			g.drawString(AdresseEMail.trim(), x-200, y + n * 6);
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			g.drawString("Date Expiration  : " + dateFormat.format(date_exp), x-370 , y + (n * 7)+30);
			g.dispose();
			insrerImage(2);

		} catch (Exception e) {
			e.printStackTrace();

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur préparation de Carte Recto Personnel : " + e, "Erreur préparation de Carte Recto Personnel : "+ e);
			FacesContext.getCurrentInstance().addMessage( null, message );



		}
	}




	public void ecrireInformations(int x, int y, int n, int taille,
			String matricule, String nom, String prenom, String marital,String dateNaiss,
			String INE) { // ecrire information personnel

		try {
			Date date_exp = new Date();
			GregorianCalendar calendar = new java.util.GregorianCalendar();

			// Initialisé à la date et l'heure courrante.
			calendar.setTime(date_exp);

			calendar.add(Calendar.YEAR, 1);
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			date_exp = calendar.getTime();

			Graphics g = imagePrototype.getGraphics();
			g.setFont(g.getFont().deriveFont(10));
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			//g.drawString("ID Etudiant ", 120, y - n);
			g.drawString(" ", 120, y);
			g.drawString(" ", 120, y + n);
			g.drawString(" ", 120, y + (n * 2));
			g.drawString(" ", 120, y + (n * 3));

			g.drawString("  ", 250, y - n);
			g.drawString(" ", 250, y);
			g.drawString(" ", 250, y + n);
			g.drawString(" ", 250, y + (n * 2));
			g.drawString(" ", 250, y + (n * 3));
			// g.dispose();

			// Graphics g = imagePrototype.getGraphics();
			g.setFont(g.getFont().deriveFont(12));
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			g.drawString(matricule.toUpperCase(), x, y - n);
			g.drawString(nom.toUpperCase(), x, y);
			g.drawString(prenom.toUpperCase(), x, y + n);
			g.drawString(dateNaiss.toUpperCase(), x, y + (n * 2));
			g.drawString(INE.toUpperCase(), x, y + (n * 3));
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille - 8));
			g.setColor(Color.BLACK);
			g.drawString(marital.toUpperCase(), x + 420, y + (n * 4));
			//g.drawString(dateFormat.format(date_exp), x + 450, y + (n * 4)+30);
			g.dispose();
			insrerImage(1);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	public void ecrireRectoVisiteur(int x, int y, int n, int taille, String NumeroCarte
			) {

		try {


			Graphics g = prototypeRecto.getGraphics();
			g.setFont(g.getFont().deriveFont(10));
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			g.drawString("Carte Numéro  : " + " "+ NumeroCarte, x, y );
			ImageIO.write(prototypeRecto, "bmp", new File(chemin_carte_recto));

		} catch (IOException e) {
			e.printStackTrace();


			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur préparation de Carte Recto Visiteur : " + e, "Erreur préparation de Carte Recto Visiteur : " + e);
			FacesContext.getCurrentInstance().addMessage( null, message );

		}
	}


	public void ecrireVersoEtudiant(String text_ucad1, String text_ucad2, String text_ucad3, String text_ucad4) {

		try {


			Graphics g1 = prototypeVerso.getGraphics();
			g1.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, 20));
			g1.setColor(Color.BLACK);
			g1.drawString(text_ucad1, 30, 340);
			g1.drawString(text_ucad2, 30, 370);
			g1.drawString(text_ucad3, 180, 400);
			g1.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, 20));
			g1.setColor(Color.BLACK);
			g1.drawString(text_ucad4, 570, 30);
			g1.dispose();
			insererCodeBarre(1);

		} catch (Exception e) {
			e.printStackTrace();

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur préparation de Carte Verso Etudiant : " + e, "Erreur préparation de Carte Verso Etudiant : " + e);
			FacesContext.getCurrentInstance().addMessage( null, message );

		}
	}

	public void ecrireVersoPerso(String text_ucad1, String text_ucad2, String text_ucad3, String text_ucad4) {

		try {


			Graphics g1 = prototypeVerso.getGraphics();
			g1.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, 20));
			g1.setColor(Color.BLACK);
			g1.drawString(text_ucad1, 30, 340);
			g1.drawString(text_ucad2, 30, 370);
			g1.drawString(text_ucad3, 180, 400);
			g1.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, 20));
			g1.setColor(Color.BLACK);
			g1.drawString(text_ucad4, 570, 30);
			g1.dispose();
			ImageIO.write(prototypeVerso, "bmp", new File(chemin_carte_verso));
		} catch (IOException e) {
			e.printStackTrace();

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur préparation de Carte Verso Personnel : " + e, "Erreur préparation de Carte Verso Personnel : " + e);
			FacesContext.getCurrentInstance().addMessage( null, message );

		}

	}

	public void ecrireVersoVisiteur(String text_ucad1, String text_ucad2, String text_ucad3, String text_ucad4) {

		try {


			Graphics g1 = prototypeVerso.getGraphics();
			g1.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, 20));
			g1.setColor(Color.BLACK);
			g1.drawString(text_ucad1, 30, 340);
			g1.drawString(text_ucad2, 185, 370);
			g1.drawString(text_ucad3, 300, 400);
			g1.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, 20));
			g1.setColor(Color.BLACK);
			g1.drawString(text_ucad4, 570, 30);
			g1.dispose();
			ImageIO.write(prototypeVerso, "bmp", new File(chemin_carte_verso));
		} catch (IOException e) {
			e.printStackTrace();

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur préparation de Carte Verso Visiteur : " + e, "Erreur préparation de Carte Verso Visiteur : " + e);
			FacesContext.getCurrentInstance().addMessage( null, message );
		}
	}

	public void insrerImage(int a) {

		final BufferedImage scaled;


		if (a == 1) {

			scaled = new BufferedImage(	210, 230, BufferedImage.TYPE_INT_RGB);
			Graphics g2 = prototypeRecto.getGraphics();
			Graphics g = scaled.getGraphics();
			g.drawImage(photoPorteur, 0, 0, 210, 230, null);
			g2.drawImage(scaled, 26, 25, null);
			g.dispose();
			g2.dispose();


		}

		else if (a == 2) {
			scaled = new BufferedImage(270, 300, BufferedImage.TYPE_INT_RGB);
			Graphics g2 = prototypeRecto.getGraphics();
			Graphics g = scaled.getGraphics();
			g.drawImage(photoPorteur, 0, 0, 270, 300, null);
			g2.drawImage(scaled, 755, 340, null);
			g.dispose();
			g2.dispose();
		}

		try {
			ImageIO.write(prototypeRecto, "bmp", new File(chemin_carte_recto));
		} catch (IOException e) {
			e.printStackTrace();

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur Récupération de la Photo : " + e, "Erreur Récupération de la Photo : " + e);
			FacesContext.getCurrentInstance().addMessage( null, message );

		}

	}

	public void insererCodeBarre (int a) {

		try {  

			if (a == 1) {

				final BufferedImage scaled;

				scaled = new BufferedImage(400, 160, BufferedImage.TYPE_INT_RGB);
				Graphics g2 = prototypeVerso.getGraphics();
				Graphics g = scaled.getGraphics();
				g.drawImage(codeBarreEtu, 0, 0, 400, 160, null);
				g2.drawImage(scaled, 315, 410, null);
				g.dispose();
				g2.dispose();
			}
			ImageIO.write(prototypeVerso, "bmp", new File(chemin_carte_verso));

			if (a == 2) {


			}


			ImageIO.write(prototypeRecto, "bmp", new File(chemin_carte_recto));

		} catch (IOException e) {
			e.printStackTrace();

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur Récupération de code à barre : " + e, "Erreur Récupération de code à barre : " + e);
			FacesContext.getCurrentInstance().addMessage( null, message );

		}

	}
	public void ecrireRectoAdherent(int x, int y, int n, int taille,
			String numUniversite, String nom, String prenom, String nommarital,
			String INE, String date_naissance, String lieu_naissance,String AdresseEMail,String AnneeAcademique,String CodeEtablissement) { 

		try {

			if (nom == null || nom =="") {nom=" ";} 
			if (prenom  == null || prenom =="") {prenom=" ";}
			if (nommarital == null || nommarital =="") {nommarital=" ";}
			//if (INE == null || INE =="") {INE=" ";}
			if (date_naissance == null || date_naissance =="") {date_naissance=" ";}
			if (lieu_naissance == null || lieu_naissance =="") {lieu_naissance=" ";}
			//if (AdresseEMail == null || AdresseEMail =="") {AdresseEMail=" ";}
			//if (CodeEtablissement == null || CodeEtablissement =="") {CodeEtablissement=" ";}


			Date date_exp = new Date();
			GregorianCalendar calendar = new java.util.GregorianCalendar();
			//
			//			// Initialisé à la date et l'heure courrante.
			calendar.setTime(date_exp);

			calendar.add(Calendar.YEAR, 3);
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			date_exp = calendar.getTime();


			Graphics g = prototypeRecto.getGraphics();
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille+30));
			g.setColor(Color.WHITE);
			g.drawString(CodeEtablissement.trim().toUpperCase(), x-85, y -75- n);
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			g.drawString(""+numUniversite.trim().toUpperCase(), x-180, y+105);
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			g.drawString(""+nom.trim().toUpperCase(), x-180, y+(n*2)+100);
			g.drawString(""+prenom.trim().toUpperCase() , x-180, y+ (n*2)+155);
			g.drawString("" + nommarital.trim(), x-180, y + (n * 3)+172);
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			g.drawString(date_naissance  , x-300, y + (n * 4)+180);
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			if (INE.trim().length() > 1 ) {
				g.drawString(INE.trim(), x-330, y + (n * 4)+278);
				//g.drawString(INE.trim(), x-250, y + (n * 4)+270);
				//	g.drawString(" : ", x-330, y + (n * 6)+20);
				//g.drawString(INE.trim().toUpperCase(), x-300, y + 0 + (n * 6)+20);
				g.drawString(dateFormat.format(date_exp), x+300, y + (n * 4)+274);
				//g.drawString(AnneeAcademique.trim(), x-70 , y + (n * 7)+30);
				g.dispose();
			}
			else {
				//g.drawString("Date Expiration  : " + dateFormat.format(date_exp), x-380 , y + (n * 7)+30);
				g.drawString(AnneeAcademique.trim(), x-70 , y + (n * 7)+30);
				g.dispose();
			}
			insrerImage(1);

		} catch (Exception e) {
			e.printStackTrace();

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur préparation de Carte Recto Etudiant : " + e, "Erreur préparation de Carte Recto Etudiant : " + e);
			FacesContext.getCurrentInstance().addMessage( null, message );

		}
	}

	public void ecrireRectoAdherentEnf(int x, int y, int n, int taille,
			String numUniversite, String nom, String prenom, String nommarital,
			String INE, String date_naissance, String lieu_naissance,String AdresseEMail,String AnneeAcademique,String CodeEtablissement) { 

		try {

			if (nom == null || nom =="") {nom=" ";} 
			if (prenom  == null || prenom =="") {prenom=" ";}
			if (nommarital == null || nommarital =="") {nommarital=" ";}
			//if (INE == null || INE =="") {INE=" ";}
			if (date_naissance == null || date_naissance =="") {date_naissance=" ";}
			if (lieu_naissance == null || lieu_naissance =="") {lieu_naissance=" ";}
			//if (AdresseEMail == null || AdresseEMail =="") {AdresseEMail=" ";}
			//if (CodeEtablissement == null || CodeEtablissement =="") {CodeEtablissement=" ";}


			Date date_exp = new Date();
			GregorianCalendar calendar = new java.util.GregorianCalendar();
			//
			//			// Initialisé à la date et l'heure courrante.
			calendar.setTime(date_exp);

			calendar.add(Calendar.YEAR, 3);
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			date_exp = calendar.getTime();


			Graphics g = prototypeRecto.getGraphics();
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille+30));
			g.setColor(Color.WHITE);
			g.drawString(CodeEtablissement.trim().toUpperCase(), x-100, y -75- n);
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			g.drawString(""+numUniversite.trim().toUpperCase(), x-100, y+118);
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			g.drawString(""+nom.trim().toUpperCase(), x-100, y+(n*2)+104);
			g.drawString(""+prenom.trim().toUpperCase() , x-100, y+ (n*2)+151);
			g.drawString("" + nommarital.trim(), x-100, y + (n * 3)+171);
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			g.drawString(date_naissance  , x-100, y + (n * 4)+191);
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			if (INE.trim().length() > 1 ) {
				g.drawString(INE.trim(), x-330, y + (n * 4)+278);
				//g.drawString(INE.trim(), x-250, y + (n * 4)+270);
				//	g.drawString(" : ", x-330, y + (n * 6)+20);
				//g.drawString(INE.trim().toUpperCase(), x-300, y + 0 + (n * 6)+20);
				g.drawString(dateFormat.format(date_exp), x+300, y + (n * 4)+274);
				//g.drawString(AnneeAcademique.trim(), x-70 , y + (n * 7)+30);
				g.dispose();
			}
			else {
				//g.drawString("Date Expiration  : " + dateFormat.format(date_exp), x-380 , y + (n * 7)+30);
				g.drawString(AnneeAcademique.trim(), x-70 , y + (n * 7)+30);
				g.dispose();
			}
			insrerImage(1);

		} catch (Exception e) {
			e.printStackTrace();

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur préparation de Carte Recto Etudiant : " + e, "Erreur préparation de Carte Recto Etudiant : " + e);
			FacesContext.getCurrentInstance().addMessage( null, message );

		}

	}
	public void ecrireRectoAdherentEnff(int x, int y, int n, int taille,
			String numUniversite, String nom, String prenom, String nommarital,
			String INE, String date_naissance, String lieu_naissance,String AdresseEMail,String AnneeAcademique,String CodeEtablissement) { 

		try {

			if (nom == null || nom =="") {nom=" ";} 
			if (prenom  == null || prenom =="") {prenom=" ";}
			if (nommarital == null || nommarital =="") {nommarital=" ";}
			//if (INE == null || INE =="") {INE=" ";}
			if (date_naissance == null || date_naissance =="") {date_naissance=" ";}
			if (lieu_naissance == null || lieu_naissance =="") {lieu_naissance=" ";}
			//if (AdresseEMail == null || AdresseEMail =="") {AdresseEMail=" ";}
			//if (CodeEtablissement == null || CodeEtablissement =="") {CodeEtablissement=" ";}


			Date date_exp = new Date();
			GregorianCalendar calendar = new java.util.GregorianCalendar();
			//
			//			// Initialisé à la date et l'heure courrante.
			calendar.setTime(date_exp);

			calendar.add(Calendar.YEAR, 3);
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			date_exp = calendar.getTime();


			Graphics g = prototypeRecto.getGraphics();
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille+30));
			g.setColor(Color.WHITE);
			g.drawString(CodeEtablissement.trim().toUpperCase(), x-100, y -75- n);
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			g.drawString(""+numUniversite.trim().toUpperCase(), x+40, y+138);
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			g.drawString(""+nom.trim().toUpperCase(), x+40, y+(n*2)+128);
			g.drawString(""+prenom.trim().toUpperCase() , x+40, y+ (n*2)+169);
			g.drawString("" + nommarital.trim(), x+40, y + (n * 3)+185);
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			g.drawString(date_naissance  , x+40, y + (n * 4)+190);
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			if (INE.trim().length() > 1 ) {
				g.drawString(INE.trim(), x-330, y + (n * 4)+278);
				//g.drawString(INE.trim(), x-250, y + (n * 4)+270);
				//	g.drawString(" : ", x-330, y + (n * 6)+20);
				//g.drawString(INE.trim().toUpperCase(), x-300, y + 0 + (n * 6)+20);
				g.drawString(dateFormat.format(date_exp), x+300, y + (n * 4)+274);
				//g.drawString(AnneeAcademique.trim(), x-70 , y + (n * 7)+30);
				g.dispose();
			}
			else {
				//g.drawString("Date Expiration  : " + dateFormat.format(date_exp), x-380 , y + (n * 7)+30);
				g.drawString(AnneeAcademique.trim(), x-70 , y + (n * 7)+30);
				g.dispose();
			}
			insrerImage(1);

		} catch (Exception e) {
			e.printStackTrace();

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur préparation de Carte Recto Etudiant : " + e, "Erreur préparation de Carte Recto Etudiant : " + e);
			FacesContext.getCurrentInstance().addMessage( null, message );

		}

	}

}
