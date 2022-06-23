package com.m2m.onousc.web.commons;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;



public class PreparerImage {

	
	private BufferedImage prototypeRecto;
	private BufferedImage photoPorteur;
	private String chemin_carte_recto;
	private BufferedImage prototypeVerso;
	private BufferedImage codeBarreEtu;
	private BufferedImage imageBarre;
	private String chemin_carte_verso;
	
	private BufferedImage imagePrototype;
	private BufferedImage photoPersonne;
	private String chemin_image_imprime;
	private BufferedImage imageVerso;
	private String chemin_verso;
	
	
	
	public PreparerImage(String cheminprotoRecto, String cheminPhoto, String chemincarteRecto,
			String cheminprotoVerso, String chemincodeBarre,String chemincarteVerso) {
		try {

			this.prototypeRecto = ImageIO.read(new File(cheminprotoRecto));
			this.photoPorteur = ImageIO.read(new File(cheminPhoto));
			this.chemin_carte_recto = chemincarteRecto;
			this.prototypeVerso = ImageIO.read(new File(cheminprotoVerso));
			this.codeBarreEtu = ImageIO.read(new File(chemincodeBarre));
			this.imageBarre = ImageIO.read(new File(chemincodeBarre));
			this.chemin_carte_verso = chemincarteVerso;

		} catch (IOException e) {
			e.printStackTrace();
		
			JOptionPane.showMessageDialog(null, "Erreur préparation de Carte 1" + e, "M2MGroup", 1, null);
		}

	}
	
	public PreparerImage(String chemin, String cheminPhoto, String image_impr,String imageVerso, String chemin_verso) {
		try {

			this.imagePrototype = ImageIO.read(new URL(chemin));
			this.photoPersonne = ImageIO.read(new URL(cheminPhoto));
			this.chemin_image_imprime = image_impr;
			  this.imageVerso = ImageIO.read(new URL(imageVerso));
			  this.chemin_verso = chemin_verso;

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public PreparerImage(  String cheminPhoto, String image_impr,String chemin_verso) {
		try {

		//	this.imagePrototype = ImageIO.read(new URL(chemin));
			this.photoPersonne = ImageIO.read(new URL(cheminPhoto));
			this.chemin_image_imprime = image_impr;			  
			  this.chemin_verso = chemin_verso;

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public PreparerImage(String chemin, String image_impr) {
		try {

			this.imagePrototype = ImageIO.read(new URL(chemin));
			//this.photoPersonne = ImageIO.read(new URL(cheminPhoto));
			this.chemin_image_imprime = image_impr;
			// this.imageVerso = ImageIO.read(new URL(imageVerso));
			// this.chemin_verso = chemin_verso;

		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	public void ecrireRectoEtudiant1(int x, int y, int n, int taille,
			String numUniversite, String nom, String prenom, String nommarital,
			String INE, String date_naissance, String lieu_naissance,String AdresseEMail) { 

		try {
			
			if (nom == null || nom =="") {nom=" ";} 
			if (prenom  == null || prenom =="") {prenom=" ";}
			if (nommarital == null || nommarital =="") {nommarital=" ";}
			if (INE == null || INE =="") {INE=" ";}
			if (date_naissance == null || date_naissance =="") {date_naissance=" ";}
			if (lieu_naissance == null || lieu_naissance =="") {lieu_naissance=" ";}
			if (AdresseEMail == null || AdresseEMail =="") {AdresseEMail=" ";}
			
			Date date_exp = new Date();
			GregorianCalendar calendar = new java.util.GregorianCalendar();

			// Initialisé à la date et l'heure courrante.
			calendar.setTime(date_exp);

			calendar.add(Calendar.YEAR, 5);
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			date_exp = calendar.getTime();

			Graphics g = prototypeRecto.getGraphics();
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille+20));
			g.setColor(Color.BLACK);
			g.drawString(numUniversite.trim().toUpperCase(), x, y +30 - n);
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			g.drawString(prenom.trim().toUpperCase(), x-200, y+n);
			g.drawString(nom.trim().toUpperCase() + " " + nommarital.trim().toUpperCase(), x-200, y+ n * 2);
			g.drawString("Né(e) le " + date_naissance + ", à " + lieu_naissance.trim().toUpperCase(), x-200, y + n * 3);
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille-6));
			g.setColor(Color.BLACK);
			g.drawString(AdresseEMail.trim(), x-200, y + n * 4);
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			if (INE.trim().length() > 1 ) {
			g.drawString("INE ", x-380, y + (n * 6)+20);
			g.drawString(" : ", x-330, y + (n * 6)+20);
			g.drawString(INE.trim().toUpperCase(), x-300, y + 0 + (n * 6)+20);
			g.drawString("Date Expiration  : " + dateFormat.format(date_exp), x-380 , y + (n * 7)+30);
			g.dispose();
			}
			else {
			g.drawString("Date Expiration  : " + dateFormat.format(date_exp), x-380 , y + (n * 7)+30);
			g.dispose();
			}
			insrerImage(1);

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erreur préparation de Carte 2" + e, "M2MGroup", 1, null);
		}

	}

	public void ecrireRectoPerso1(int x, int y, int n, int taille, String Matr,String nom,
			String prenom, String marital,String structureAffect, String Classification,String grade, 
			String date_naissance, String lieu_naissance,String AdresseEMail) {

		
     try {
			
			if (Matr == null || Matr =="") {Matr=" ";} 
			if (nom  == null || nom =="") {nom=" ";}
			if (prenom == null || prenom =="") {prenom=" ";}
			if (marital == null || marital =="") {marital=" ";}
			if (structureAffect == null || structureAffect =="") {structureAffect=" ";}
			if (Classification == null || Classification =="") {Classification=" ";}
			if (grade == null || grade =="") {grade=" ";}
			if (date_naissance == null || date_naissance =="") {date_naissance=" ";}
			if (lieu_naissance == null || lieu_naissance =="") {lieu_naissance=" ";}
			if (AdresseEMail == null || AdresseEMail =="") {AdresseEMail=" ";}
			
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
			g.drawString(structureAffect.toUpperCase() + " / " + Classification.toUpperCase(), x-200, y + (n * 4));
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
			JOptionPane.showMessageDialog(null, "Erreur préparation de Carte 3" + e, "M2MGroup", 1, null);
		
		}
	}
	

	public void ecrireRectoVisiteur1(int x, int y, int n, int taille, String CNIVISITEUR
			) {// ecrire information personnel

		try {
			
			
			Graphics g = prototypeRecto.getGraphics();
			g.setFont(g.getFont().deriveFont(10));
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			g.drawString("Numéro Visiteur ", 80, y + n );
		
		    g.drawString(" : ", 280, y + n);
			
			g.setFont(g.getFont().deriveFont(12));
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			g.drawString(CNIVISITEUR.toUpperCase(), x+30, y + n);
			ImageIO.write(prototypeRecto, "bmp", new File(chemin_carte_recto));
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erreur préparation de Carte " + e, "M2MGroup", 1, null);
		}
	}

	
	public void ecrireVersoEtudiant1(String text_ucad1, String text_ucad2, String text_ucad3) {

		try {
			
			
			Graphics g1 = prototypeVerso.getGraphics();
			//g1.setFont(g1.getFont().deriveFont(12));
			g1.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, 18));
			g1.setColor(Color.BLACK);
			g1.drawString(text_ucad1, 30, 350);
			g1.drawString(text_ucad2, 45, 380);
			g1.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, 14));
			g1.setColor(Color.BLACK);
			g1.drawString(text_ucad3, 675, 560);
			g1.dispose();
			//insererCodeBarre(1);
//			appercuCarte(1);

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erreur préparation de Carte 4" + e, "M2MGroup", 1, null);
		}
	}
	
	public void ecrireVersoPerso1(String text_ucad1, String text_ucad2, String text_ucad3) {

	       try {
				
				Graphics g1 = prototypeVerso.getGraphics();
				//g1.setFont(g1.getFont().deriveFont(12));
				g1.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, 18));
				g1.setColor(Color.BLACK);
				g1.drawString(text_ucad1, 30, 350);
				g1.drawString(text_ucad2, 45, 380);
				g1.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, 14));
				g1.setColor(Color.BLACK);
				g1.drawString(text_ucad3, 675, 560);
				g1.dispose();
			//	insererCodeBarre(2);
//				appercuCarte(2);

			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erreur préparation de Carte 5" + e, "M2MGroup", 1, null);
			}
		}

	public void ecrireVersoVisiteur1(String CNIVISITEUR) {

		try {
			Graphics g1 = prototypeVerso.getGraphics();
			g1.setFont(g1.getFont().deriveFont(12));
			g1.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, 26));
			
			g1.setColor(Color.BLACK);
			g1.drawString("Carte Visiteur ", 390, 380);
			g1.dispose();

			ImageIO.write(prototypeVerso, "bmp", new File(chemin_carte_verso));
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erreur préparation de Carte 6" + e, "M2MGroup", 1, null);
		}
	}
	
	public void insrerImage1(int a) {

		final BufferedImage scaled;

		if (a == 1) {
			//scaled = new BufferedImage(300, 350, BufferedImage.TYPE_INT_RGB);
			scaled = new BufferedImage(230, 270, BufferedImage.TYPE_INT_RGB);
			Graphics g2 = prototypeRecto.getGraphics();
			Graphics g = scaled.getGraphics();
			g.drawImage(photoPorteur, 0, 0, 230, 270, null);
			g2.drawImage(scaled, 780, 360, null);
			g.dispose();
			g2.dispose();
			
		}

		else if (a == 2) {
			scaled = new BufferedImage(230, 270, BufferedImage.TYPE_INT_RGB);
			Graphics g2 = prototypeRecto.getGraphics();
			Graphics g = scaled.getGraphics();
			g.drawImage(photoPorteur, 0, 0, 230, 270, null);
			g2.drawImage(scaled, 800, 380, null);
			g.dispose();
			g2.dispose();
		}

		try {
			ImageIO.write(prototypeRecto, "bmp", new File(chemin_carte_recto));
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erreur Récupération de la Photo 7" + e, "M2MGroup", 1, null);
		}

	}
	
	  
    public void insererCodeBarre1 (int a) {
	
    	try {  

          if (a == 1) {
        
          final BufferedImage scaled;
        	  
	      scaled = new BufferedImage(327, 160, BufferedImage.TYPE_INT_RGB);
	      Graphics g2 = prototypeVerso.getGraphics();
	      Graphics g = scaled.getGraphics();
	      g.drawImage(codeBarreEtu, 0, 0, 327, 160, null);
	      g2.drawImage(scaled, 345, 410, null);
	      g.dispose();
	      g2.dispose();
         }
          ImageIO.write(prototypeVerso, "bmp", new File(chemin_carte_verso));
          
if (a == 2) {
        	  
        	  final BufferedImage scaled;
        	  
    	      scaled = new BufferedImage(300, 120, BufferedImage.TYPE_INT_RGB);
    	      Graphics g2 = prototypeRecto.getGraphics();
    	      Graphics g = scaled.getGraphics();
    	      g.drawImage(imageBarre, 0, 0, 300, 120, null);
    	      g2.drawImage(scaled, 800, 250, null);
    	      g.dispose();
    	      g2.dispose();
             }
          
       
    	   ImageIO.write(prototypeRecto, "bmp", new File(chemin_carte_recto));
	   
       } catch (IOException e) {
	   e.printStackTrace();
	   JOptionPane.showMessageDialog(null, "Erreur Récupération de code à barre 8" + e, "M2MGroup", 1, null);
       }
 
}
    
    public void ecrireInformations(int x, int y, int n, int taille,
			String numUniversite, String nom, String prenom, String marital,String cite,
			String INE , String CIN) { // ecrire information etudiant

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
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille + 5));
			g.setColor(Color.BLACK);
		//	g.drawString(numUniversite.toUpperCase(), x, y - n);
			g.drawString(nom.toUpperCase(), x - 250, y - 20);
			g.drawString(prenom.toUpperCase(), x - 250, y + n);
			g.drawString(cite.toUpperCase(), x, y + (n * 2));
			g.drawString(INE.toUpperCase(), x+400, y + (n * 3)+70);
			//g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille + 8));
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille + 7 ));
			g.setColor(Color.BLACK);
			String cname="CITÉ UNIVERSITAIRE " + marital.toUpperCase();
			
			g.drawString(cname, x-(340-((58-cname.length())*9)), y + (n * 4)+90);
			//g.drawString(dateFormat.format(date_exp), x + 450, y + (n * 4)+30);
			g.dispose();
			insrerImage(1);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
    public void ecrireInformationsCMC( DimensionCarte carte, String nom, String prenom, String marital, String naps) { // ecrire information etudiant

 		try {
 			Date date_exp = new Date();
 			GregorianCalendar calendar = new java.util.GregorianCalendar();

 			// Initialisé à la date et l'heure courrante.
 			calendar.setTime(date_exp);

 			calendar.add(Calendar.YEAR, 1);
 			DateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
 			date_exp = calendar.getTime();
 			String date = dateFormat.format(new Date());
 			
 			Graphics g = imagePrototype.getGraphics();
 			if (naps=="P")
	 		{
 				g.setFont(g.getFont().deriveFont(8)); 
	 			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, 12));
	 			g.setColor(Color.BLACK);
	 			g.drawString("EXPIER FIN",carte.getX_Expdate(), carte.getY_Expdate());
	 			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, 22));
	 			g.drawString(date,carte.getX_date(), carte.getY_date());
 			}
 			g.setFont(g.getFont().deriveFont(12));
 			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, 27));
 			g.setColor(Color.BLACK);
 		//	g.drawString(numUniversite.toUpperCase(), x, y - n);
 			g.drawString(nom.toUpperCase() +" "+prenom.toUpperCase(),carte.getX_Name(),carte.getY_Name());
 			Rectangle rect = new Rectangle(carte.getX_Imat(),carte.getY_Imat(),carte.getW_photo(),100);
 			 //g.drawString(marital.toUpperCase(), carte.getX_Imat(), carte.getY_Imat());
 			drawCenteredString( g,marital.toUpperCase(),rect);
 			//g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille + 8));
 			 	g.dispose();
 			insrerImage(1,carte);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}

 	}
     
    public void drawCenteredString(Graphics g, String text, Rectangle rect) {
        // Get the FontMetrics
    	Font font = new Font("SANS SERIF", Font.CENTER_BASELINE, 27);
    	g.setFont(font);
			g.setColor(Color.BLACK);
        FontMetrics metrics = g.getFontMetrics(font);
        // Determine the X coordinate for the text
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        // Set the font
        g.setFont(font);
        // Draw the String
        g.drawString(text, x, y);
    }
    public void ecrireInformationsCaissier(int x, int y, int n, int taille,
			String numUniversite, String nom, String prenom, String marital,String cite,
			String INE) { // ecrire information etudiant

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
			g.drawString("", 120, y);
			g.drawString("", 120, y + n);
            g.drawString("", 120, y + (n * 2));
			g.drawString("", 120, y + (n * 3));

			g.drawString("", 250, y - n);
			g.drawString("", 250, y);
			g.drawString("", 250, y + n);
		    g.drawString("", 250, y + (n * 2));
			g.drawString("", 250, y + (n * 3));
			// g.dispose();

			// Graphics g = imagePrototype.getGraphics();
			g.setFont(g.getFont().deriveFont(12));
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
		//	g.drawString(numUniversite.toUpperCase(), x, y - n);
			g.drawString(nom.toUpperCase(), x, y);
			g.drawString(prenom.toUpperCase(), x, y + n);
			g.drawString(cite.toUpperCase(), x, y + (n * 2));
			g.drawString(INE.toUpperCase(), x, y + (n * 3));
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille - 8));
			g.setColor(Color.BLACK);
			g.drawString(marital.toUpperCase(), x + 420, y + (n * 4));
			//g.drawString(dateFormat.format(date_exp), x + 450, y + (n * 4)+30);
			g.dispose();
			insrerImage(3);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	public void ecrireInformationsPerso(int x, int y, int n, int taille, String Matr,String nom,
			String prenom, String marital,String structureAffect, String Classification,String grade 
			) {// ecrire information personnel

		try {
			Date date_exp = new Date();
			GregorianCalendar calendar = new java.util.GregorianCalendar();

			// Initialisé à la date et l'heure courrante.
			calendar.setTime(date_exp);

			calendar.add(Calendar.YEAR, 10);
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			date_exp = calendar.getTime();
			System.out.println("date d'expiration personnel : "
					+ dateFormat.format(date_exp));
			
			Graphics g = imagePrototype.getGraphics();
			g.setFont(g.getFont().deriveFont(10));
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			g.drawString("Matricule ", 80, y - n );
			g.drawString("Nom & Prénom ", 80, y );
			//g.drawString("Prénom ", 80, y + n);
            g.drawString("Nom Marital ", 80, y + n);
			g.drawString("Structure ", 80, y + (n * 2));
			g.drawString("Classification ", 80, y + (n * 3));
			g.drawString("Grade ", 80, y + (n * 4));
			
			g.drawString(" : ", 280, y - n);
			g.drawString(" : ", 280, y);
		    g.drawString(" : ", 280, y + n);
			g.drawString(" : ", 280, y + (n * 2));
			g.drawString(" : ", 280, y + (n * 3));
			g.drawString(" : ", 280, y + (n * 4));
			
			
			g.setFont(g.getFont().deriveFont(12));
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			g.drawString(Matr.toUpperCase(), x+30, y - n);
			g.drawString(nom.toUpperCase()+"  "+ prenom.toUpperCase(), x+30 , y );
			//g.drawString(prenom.toUpperCase(), x, y);
			g.drawString(marital.toUpperCase(), x+30 , y + n);
			g.drawString(structureAffect.toUpperCase(), x+30, y + (n * 2));
			g.drawString(Classification.toUpperCase(), x+30, y + (n * 3));
			g.drawString(grade.toUpperCase(), x+30, y + (n * 4));

			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille - 8));
			g.setColor(Color.BLACK);
			g.drawString("Date d'Expiration ", x + 420, y + (n * 4));
			g.drawString(dateFormat.format(date_exp), x + 450, y + (n * 4)+30);
			g.dispose();
			insrerImage(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void ecrireInformationsVisiteur(int x, int y, int n, int taille, String CNIVISITEUR
			) {// ecrire information personnel

		try {
			
			
			Graphics g = imagePrototype.getGraphics();
			g.setFont(g.getFont().deriveFont(10));
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			g.drawString("Numéro Visiteur ", 80, y + n );
		
		    g.drawString(" : ", 280, y + n);
			
			g.setFont(g.getFont().deriveFont(12));
			g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
			g.setColor(Color.BLACK);
			g.drawString(CNIVISITEUR.toUpperCase(), x+30, y + n);
			ImageIO.write(imagePrototype, "bmp", new File(chemin_image_imprime));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	public void ecrireVerso(String date_Anne1, String lieu_naissance,String AdresseEMail) {

 	try {
 			Graphics g1 = imageVerso.getGraphics();
//			g1.setFont(g1.getFont().deriveFont(12));
//			g1.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, 26));
//			
 			g1.setColor(Color.BLACK);
 			g1.drawRect(150, 150, 600, 70);
 			g1.setFont(new Font("Calibri", Font.BOLD, 26)); 
 			g1.drawString(date_Anne1, 400, 200);
 			g1.drawRect(150, 220, 600, 70);
 			g1.drawRect(150, 290, 600, 70);
 			g1.setColor(Color.black);
//			g1.drawString(" ", 350, 350);
//			g1.drawString(" ", 390, 380);
//			g1.drawString(" ", 350, 410);
//			g1.drawString("  ", 435, 350);
//			g1.drawString("  ", 435, 380);
//			g1.drawString("  ", 435, 410);
//			
//			
//			g1.setColor(Color.BLACK);
//			g1.drawString(date_naissance, 460, 350);
//			g1.drawString(lieu_naissance.toUpperCase(), 460, 380);
//			g1.drawString(AdresseEMail, 460, 410);
 			g1.dispose();

		 ImageIO.write(imageVerso, "png", new File(chemin_verso));
 	} catch (IOException e) {
 		e.printStackTrace();
 	}
	}

	public void ecrireVersoVisiteur(String CNIVISITEUR) {

		try {
			Graphics g1 = imageVerso.getGraphics();
			g1.setFont(g1.getFont().deriveFont(12));
			g1.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, 26));
			
			g1.setColor(Color.BLACK);
			g1.drawString("Carte Visiteur ", 390, 380);
			g1.dispose();

			ImageIO.write(imageVerso, "bmp", new File(chemin_verso));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void insrerImage(int a) {

		final BufferedImage scaled;

		if (a == 1) {
			//scaled = new BufferedImage(300, 350, BufferedImage.TYPE_INT_RGB);
			scaled = new BufferedImage(150, 150, BufferedImage.TYPE_INT_BGR);
			Graphics g2 = imagePrototype.getGraphics();
			Graphics g = scaled.getGraphics();
			//g.drawImage(photoPersonne, 0, 0, 300, 350, null);
			g.drawImage(photoPersonne, 0, 0, 150, 150, null);
			//g2.drawImage(scaled, 660, 220, null);
			g2.drawImage(scaled, 660, 230, null);
			g.dispose();
			g2.dispose();
			
		}

		else if (a == 2) {
			//scaled = new BufferedImage(300, 350, BufferedImage.TYPE_INT_RGB);
			scaled = new BufferedImage(250, 300, BufferedImage.TYPE_3BYTE_BGR);
			Graphics g2 = imagePrototype.getGraphics();
			Graphics g = scaled.getGraphics();
			//g.drawImage(photoPersonne, 0, 0, 300, 350, null);
			g.drawImage(photoPersonne, 0, 0, 250, 300, null);
			//g2.drawImage(scaled, 660, 220, null);
			g2.drawImage(scaled, 660, 250, null);
			g.dispose();
			g2.dispose();
		}
		
		else if (a == 3) {
			//scaled = new BufferedImage(300, 350, BufferedImage.TYPE_INT_RGB);
			scaled = new BufferedImage(250, 300, BufferedImage.TYPE_3BYTE_BGR);
			Graphics g2 = imagePrototype.getGraphics();
			Graphics g = scaled.getGraphics();
			//g.drawImage(photoPersonne, 0, 0, 300, 350, null);
			//g.drawImage(photoPersonne, 0, 0, 250, 300, null);
			//g2.drawImage(scaled, 660, 220, null);
			//g2.drawImage(scaled, 660, 250, null);
			g.dispose();
			g2.dispose();
		}


		try {
			 File f = new File(this.chemin_image_imprime);
		      
		      ImageIO.write(this.imagePrototype, "png", f);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void insrerImage(int a,DimensionCarte carte) {

		final BufferedImage scaled;

		if (a == 1) {
			//scaled = new BufferedImage(300, 350, BufferedImage.TYPE_INT_RGB);
			scaled = new BufferedImage(carte.getH_photo(), carte.getW_photo(), BufferedImage.TYPE_INT_BGR);
			Graphics g2 = imagePrototype.getGraphics();
			Graphics g = scaled.getGraphics();
			//g.drawImage(photoPersonne, 0, 0, 300, 350, null);
			g.drawImage(photoPersonne, 0, 0, carte.getH_photo(), carte.getW_photo(), null);
			//g2.drawImage(scaled, 660, 220, null);
			g2.drawImage(scaled, carte.getX_photo(), carte.getY_photo(), null);
			g.dispose();
			g2.dispose();
			
		}

		else if (a == 2) {
			//scaled = new BufferedImage(300, 350, BufferedImage.TYPE_INT_RGB);
			scaled = new BufferedImage(250, 300, BufferedImage.TYPE_3BYTE_BGR);
			Graphics g2 = imagePrototype.getGraphics();
			Graphics g = scaled.getGraphics();
			//g.drawImage(photoPersonne, 0, 0, 300, 350, null);
			g.drawImage(photoPersonne, 0, 0, 250, 300, null);
			//g2.drawImage(scaled, 660, 220, null);
			g2.drawImage(scaled, 660, 250, null);
			g.dispose();
			g2.dispose();
		}
		
		else if (a == 3) {
			//scaled = new BufferedImage(300, 350, BufferedImage.TYPE_INT_RGB);
			scaled = new BufferedImage(250, 300, BufferedImage.TYPE_3BYTE_BGR);
			Graphics g2 = imagePrototype.getGraphics();
			Graphics g = scaled.getGraphics();
			//g.drawImage(photoPersonne, 0, 0, 300, 350, null);
			//g.drawImage(photoPersonne, 0, 0, 250, 300, null);
			//g2.drawImage(scaled, 660, 220, null);
			//g2.drawImage(scaled, 660, 250, null);
			g.dispose();
			g2.dispose();
		}


		try {
			 File f = new File(this.chemin_image_imprime);
		      
		      ImageIO.write(this.imagePrototype, "png", f);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

    
}
