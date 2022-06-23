package com.m2m.onousc.business.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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

public class PreparerImage {

	private BufferedImage imagePrototype;
	private BufferedImage photoPersonne;
	private String chemin_image_imprime;
	private BufferedImage imageVerso;
	private String chemin_verso;

	public PreparerImage(String chemin, String cheminPhoto, String image_impr,String imageVerso,String chemin_verso) {
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

	public void ecrireInformations(int x, int y, int n, int taille,
			String numUniversite, String nom, String prenom, String marital,
			String INE) { // ecrire information etudiant
		Date date_exp = new Date();
		GregorianCalendar calendar = new java.util.GregorianCalendar();

		// Initialisé à la date et l'heure courrante.
		calendar.setTime(date_exp);

		calendar.add(Calendar.YEAR, 5);
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
		date_exp = calendar.getTime();
	

		Graphics g = imagePrototype.getGraphics();
		g.setFont(g.getFont().deriveFont(12));
		g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
		g.setColor(Color.BLACK);
		g.drawString(numUniversite.toUpperCase(), x, y - n);
		g.drawString(nom.toUpperCase(), x, y);
		g.drawString(prenom.toUpperCase(), x, y + n);
		if(marital!=null)
		g.drawString(marital.toUpperCase(), x, y + (n * 2));
		g.drawString(INE.toUpperCase(), x, y + (n * 3));
		g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille-8));
		g.setColor(Color.GRAY);
		g.drawString(dateFormat.format(date_exp), x+450, y + (n * 4));
		g.dispose();
		insrerImage(1);
	}

	public void ecrireInformations(int x, int y, int n, int taille, String nom,
			String prenom, String marital, String grade, String structure,
			String affectation) {// ecrire information personnel
		Date date_exp = new Date();
		GregorianCalendar calendar = new java.util.GregorianCalendar();

		// Initialisé à la date et l'heure courrante.
		calendar.setTime(date_exp);

		calendar.add(Calendar.YEAR, 3);
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
		date_exp = calendar.getTime();
		System.out.println("date d'expiration personnel : "
				+ dateFormat.format(date_exp));

		Graphics g = imagePrototype.getGraphics();
		g.setFont(g.getFont().deriveFont(12));
		g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille));
		g.setColor(Color.BLACK);
		g.drawString(prenom.toUpperCase(), x, y);
		g.drawString(nom.toUpperCase(), x + 150, y);
		g.drawString(marital.toUpperCase(), x + 330, y);
		g.drawString(grade.toUpperCase(), x, y + n);
		g.drawString(structure.toUpperCase(), x, y + (n * 2));
		g.drawString(affectation.toUpperCase(), x, y + (n * 3));
		
		g.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, taille-8));
		g.setColor(Color.GRAY);
		g.drawString("Expire Le: "+dateFormat.format(date_exp), x, y + (n * 4)+20);
		g.dispose();
		insrerImage(2);
	}

	
	public void ecrireVerso(String date_naissance,String lieu_naissance){

			Graphics g1 = imageVerso.getGraphics();
			g1.setFont(g1.getFont().deriveFont(12));
			g1.setFont(new Font("SANS SERIF", Font.CENTER_BASELINE, 26));
			g1.setColor(Color.BLACK);
			g1.drawString(date_naissance,435, 350);
			g1.drawString(lieu_naissance, 460, 380);
			g1.dispose();
			
			try {
				ImageIO.write(imageVerso, "bmp", new File(chemin_verso));
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	

	public void insrerImage(int a) {

		final BufferedImage scaled;

		if (a == 1) {
			scaled = new BufferedImage(300, 350, BufferedImage.TYPE_INT_RGB);
			Graphics g2 = imagePrototype.getGraphics();
			Graphics g = scaled.getGraphics();
			g.drawImage(photoPersonne, 0, 0, 300, 350, null);
			g2.drawImage(scaled, 660, 220, null);
			g.dispose();
			g2.dispose();
		}

		else if (a == 2) {
			scaled = new BufferedImage(300, 350, BufferedImage.TYPE_INT_RGB);
			Graphics g2 = imagePrototype.getGraphics();
			Graphics g = scaled.getGraphics();
			g.drawImage(photoPersonne, 0, 0, 300, 350, null);
			g2.drawImage(scaled, 660, 220, null);
			g.dispose();
			g2.dispose();
		}

		try {
			ImageIO.write(imagePrototype, "bmp", new File(chemin_image_imprime));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
