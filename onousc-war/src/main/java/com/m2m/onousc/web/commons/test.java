package com.m2m.onousc.web.commons;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PreparerImage pi = null;
		String photo = "file:C:/Carte_UCAD/Photos_Porteurs/Etudiants/15.jpg";
		String imageGenereRecto = "C:/Carte_UCAD/Cartes_PreImprimees/Etudiants/Carte_Etudiant_Recto_15.bmp";
		String imageGenereVerso = "C:/Carte_UCAD/Cartes_PreImprimees/Etudiants/Carte_Etudiant_Verso_15.bmp";
		String chemin = "file:C:/Carte_UCAD/Prototypes/Etudiants/carte-gold-devise.png";
		pi = new PreparerImage(chemin, photo, imageGenereRecto,chemin, imageGenereVerso);

		 
	}

}
