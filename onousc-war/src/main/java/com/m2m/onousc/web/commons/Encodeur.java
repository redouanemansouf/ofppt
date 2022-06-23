package com.m2m.onousc.web.commons;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.smartcardio.Card;
import javax.smartcardio.CardChannel;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;
import javax.smartcardio.TerminalFactory;
import javax.swing.JOptionPane;

public class Encodeur {

	private CardChannel channel;
	private Card card;
	private TerminalFactory factory;
	private List<CardTerminal> terminals;
	CardTerminal terminal;
	boolean CardIsPresent;

	public Encodeur() {

	}

	public boolean verifierLecteur() {
		boolean res = false;
		boolean lecteur = false;
		int indice_terminal = -1;
		factory = TerminalFactory.getDefault();

		try {
			// while (!lecteur) {
			try {
				Thread.sleep(200);
				terminals = factory.terminals().list();
				for (int i = 0; i < terminals.size(); i++) {
					terminal = terminals.get(i);
					indice_terminal = i;
					lecteur = true;

				}

			} catch (CardException e) {
				lecteur = false;
			}
			// }
			if (lecteur)
				terminal = terminals.get(indice_terminal);

			res = true;

			System.out.println("terminal.getName() : " + terminal.getName());

			AppletWeb.resultat += "terminal.getName() : " + terminal.getName() + "\n";

			CardIsPresent = terminal.isCardPresent();

			while (!CardIsPresent) {
				Thread.sleep(500);
				CardIsPresent = terminal.isCardPresent();
			}

			System.out.println("CardIsPresent  " + CardIsPresent);
			AppletWeb.resultat += "CardIsPresent  " + CardIsPresent + "\n";


			if (CardIsPresent) {
				card = terminal.connect("*");
				channel = card.getBasicChannel();

				res = true;
			} else {

				res = false;
			}

			//JOptionPane.showMessageDialog(null, terminal.isCardPresent());

		} catch (Exception e) {
			res = false;
			e.printStackTrace();
			// AppletWeb.resultat += "*********Aucun lecteur trouvée\n";
			AppletWeb.resultat += "Vérife lecteur exception \n";
		}
		return res;

	}

	// public boolean connexionCarte() throws CardException {
	// // connexion à la carte
	//
	// CardIsPresent = false;
	//
	// CardIsPresent = terminal.isCardPresent();
	// System.out.println("Lecteur: " + terminal.getName());
	//
	// if (CardIsPresent) {
	//
	// try {
	//
	// card = terminal.connect("*"); // establish a connection with the
	// // card
	// channel = card.getBasicChannel();
	//
	// } catch (Exception e) {
	//
	// System.out.println(e);
	// }
	// } else {
	// System.out.println("CardIsPresent " + CardIsPresent);
	// }
	// return CardIsPresent;
	// }

	public boolean encoder(String information, String type) { // ecrire
		// information
		// sur la puce
		boolean rep = false;
		if (information == null)
			return rep;
		loadKey();
		switch (type) {

		// Ecrire Information Etudiants

		case "IDENTIFICATION_ETU": {
			byte[] blocs = { (byte) 0x01 };
			ecrire(blocs, decomposer(information, 1));
			System.out.println("Ecrire IDENTIFICATION_ETU");
		}
		break;

		case "NOM_ETU": {
			byte[] blocs = { (byte) 0x02, (byte) 0x04, (byte) 0x05, (byte) 0x06 };
			ecrire(blocs, decomposer(information, 4));
			System.out.println("Ecrire NOM");
		}
		break;

		case "PRENOM_ETU": {
			byte[] blocs = { (byte) 0x08, (byte) 0x09, (byte) 0x0A, (byte) 0x0C };
			ecrire(blocs, decomposer(information, 4));
		}
		break;

		case "MARITAL_ETU": {
			byte[] blocs = { (byte) 0x0D, (byte) 0x0E };
			ecrire(blocs, decomposer(information, 2));
		}
		break;

		case "SEXE_BOURSE_BU_COUD_DATENAISSANCE_ETU": {
			byte[] blocs = { (byte) 0x10 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "LIEU_NAISS_ETU": {
			byte[] blocs = { (byte) 0x11, (byte) 0x12 };
			ecrire(blocs, decomposer(information, 2));
		}
		break;

		case "CNI_ETU": {
			byte[] blocs = { (byte) 0x14 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "INE_ETU": {
			byte[] blocs = { (byte) 0x15 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "NATIONALITE_ETU": {
			byte[] blocs = { (byte) 0x16, (byte) 0x18 };
			ecrire(blocs, decomposer(information, 2));
		}
		break;

		case "EMAIL_ETU": {
			byte[] blocs = { (byte) 0x19, (byte) 0x1A, (byte) 0x1C };
			ecrire(blocs, decomposer(information, 3));
		}
		break;

		case "ETABLISSEMENT_1_ETU": {
			byte[] blocs = { (byte) 0x1D, (byte) 0x1E, (byte) 0x20, (byte) 0x21 };
			ecrire(blocs, decomposer(information, 4));
		}
		break;

		case "ETABLISSEMENT_2_ETU": {
			byte[] blocs = { (byte) 0x22, (byte) 0x24, (byte) 0x25, (byte) 0x26 };
			ecrire(blocs, decomposer(information, 4));
		}
		break;

		case "SECTION_1_ETU": {
			byte[] blocs = { (byte) 0x28, (byte) 0x29, (byte) 0x2A };
			ecrire(blocs, decomposer(information, 3));
		}
		break;
		case "SECTION_2_ETU": {
			byte[] blocs = { (byte) 0x2C, (byte) 0x2D, (byte) 0x2E };
			ecrire(blocs, decomposer(information, 3));
		}
		break;

		case "ANNEE_ACAD": {
			byte[] blocs = { (byte) 0x30 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "DATE_DELCARTEETU": {
			byte[] blocs = { (byte) 0x31 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "DATE_EXPCARTEETU": {
			byte[] blocs = { (byte) 0x32 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "INFO_SERVICEETU": {
			byte[] blocs = { (byte) 0x34, (byte) 0x35, (byte) 0x36 };
			ecrire(blocs, decomposer(information, 3));
		}
		break;

		case "DMAJ_SERVICEETU": {
			byte[] blocs = { (byte) 0x38 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		// Fin Ecrire Information Etudiants

		////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// Ecrire Information Personnel

		case "IDENTIFICATION_PERS": {
			byte[] blocs = { (byte) 0x01 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "NOM_PERS": {
			byte[] blocs = { (byte) 0x02, (byte) 0x04, (byte) 0x05, (byte) 0x06 };
			ecrire(blocs, decomposer(information, 4));
		}
		break;

		case "PRENOM_PERS": {
			byte[] blocs = { (byte) 0x08, (byte) 0x09, (byte) 0x0A, (byte) 0x0C };
			ecrire(blocs, decomposer(information, 4));
		}
		break;

		case "MARITAL_PERS": {
			byte[] blocs = { (byte) 0x0D, (byte) 0x0E };
			ecrire(blocs, decomposer(information, 2));
		}
		break;

		case "SEXE_DATENAISSANCE_PERS": {
			byte[] blocs = { (byte) 0x10 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "LIEUNAISS_PERS": {
			byte[] blocs = { (byte) 0x11, (byte) 0x12 };
			ecrire(blocs, decomposer(information, 2));
		}
		break;

		case "CNI_PERS": {
			byte[] blocs = { (byte) 0x14 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "NATIONALITE_PERS": {
			byte[] blocs = { (byte) 0x16, (byte) 0x18 };
			ecrire(blocs, decomposer(information, 2));
		}
		break;

		case "EMAIL_PERS": {
			byte[] blocs = { (byte) 0x19, (byte) 0x1A, (byte) 0x1C };
			ecrire(blocs, decomposer(information, 3));
		}
		break;

		case "STRUCTURE_PERS": {
			byte[] blocs = { (byte) 0x1D, (byte) 0x1E };
			ecrire(blocs, decomposer(information, 2));
		}
		break;

		case "CLASSIFICATION_PERS": {
			byte[] blocs = { (byte) 0x20, (byte) 0x21 };
			ecrire(blocs, decomposer(information, 2));
		}
		break;

		case "GRADE_PERS": {
			byte[] blocs = { (byte) 0x22, (byte) 0x24 };
			ecrire(blocs, decomposer(information, 2));
		}
		break;

		case "DATEEMBAUCHE_PERS": {
			byte[] blocs = { (byte) 0x25 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "NUM_EMPLOI_PERS": {
			byte[] blocs = { (byte) 0x26 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "DATE_DELCARTEPERS": {
			byte[] blocs = { (byte) 0x31 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "DATE_EXPCARTEPERS": {
			byte[] blocs = { (byte) 0x32 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "INFO_SERVICEPERS": {
			byte[] blocs = { (byte) 0x34, (byte) 0x35, (byte) 0x36 };
			ecrire(blocs, decomposer(information, 3));
		}
		break;

		case "DMAJ_SERVICEPERS": {
			byte[] blocs = { (byte) 0x38 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		// Fin Ecrire Information Personnel

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// Ecrire Information Visiteur

		case "IDENTIFICATION_VISITEUR": {
			byte[] blocs = { (byte) 0x01 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "NOM_VISITEUR": {
			byte[] blocs = { (byte) 0x02, (byte) 0x04, (byte) 0x05, (byte) 0x06 };
			ecrire(blocs, decomposer(information, 4));
		}
		break;

		case "PRENOM_VISITEUR": {
			byte[] blocs = { (byte) 0x08, (byte) 0x09, (byte) 0x0A, (byte) 0x0C };
			ecrire(blocs, decomposer(information, 4));
		}
		break;

		case "NOMMARITAL_VISITEUR": {
			byte[] blocs = { (byte) 0x0D, (byte) 0x0E };
			ecrire(blocs, decomposer(information, 2));
		}
		break;

		case "SEXE_DATENAISSANCE_VISITEUR": {
			byte[] blocs = { (byte) 0x10 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "LIEUNAI_VISITEUR": {
			byte[] blocs = { (byte) 0x11, (byte) 0x12 };
			ecrire(blocs, decomposer(information, 2));
		}
		break;

		case "CNI_VISITEUR": {
			byte[] blocs = { (byte) 0x14 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "DATEDEB_VISITEUR": {
			byte[] blocs = { (byte) 0x31 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "DATEFIN_VISITEUR": {
			byte[] blocs = { (byte) 0x32 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "NATIONALITE_VISITEUR": {
			byte[] blocs = { (byte) 0x16, (byte) 0x18 };
			ecrire(blocs, decomposer(information, 2));
		}
		break;

		case "ENTITEPROV_VISITEUR": {
			byte[] blocs = { (byte) 0x19, (byte) 0x1A, (byte) 0x1C };
			ecrire(blocs, decomposer(information, 3));
		}
		break;

		case "FONCTION_VISITEUR": {
			byte[] blocs = { (byte) 0x1D, (byte) 0x1E };
			ecrire(blocs, decomposer(information, 2));
		}
		break;

		case "STRUCTUREACC_VISITEUR": {
			byte[] blocs = { (byte) 0x20, (byte) 0x21 };
			ecrire(blocs, decomposer(information, 2));
		}
		break;

		case "OBJETVISIT_VISITEUR": {
			byte[] blocs = { (byte) 0x22, (byte) 0x24, (byte) 0x25, (byte) 0x26 };
			ecrire(blocs, decomposer(information, 4));
		}
		break;

		case "INFOSERVICE_VISITEUR": {
			byte[] blocs = { (byte) 0x34, (byte) 0x35, (byte) 0x36 };
			ecrire(blocs, decomposer(information, 3));
		}
		break;

		case "DATEMAJSERVICE_VISITEUR": {
			byte[] blocs = { (byte) 0x38 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		// Fin Ecrire Information Visiteur

		default:
			System.out.println("Encodeur: aucun choix effectué");
		}
		rep = true;

		return rep;

	}


	public boolean encode(String information, String type) { // ecrire
		// information
		// sur la puce
		boolean rep = false;
		if (information == null)
			return rep;
		loadKey();
		switch (type) {

		// Ecrire Information Etudiants

		case "NCIN_ETU": {
			byte[] blocs = { (byte) 0x01 };
			ecrire(blocs, decomposer(information, 1));
			System.out.println("Ecrire N°CIN");
		}
		break;
		
		case "DNAIS_ETU": {
			byte[] blocs = { (byte) 0x02 };
			ecrire(blocs, decomposer(information, 1));
			System.out.println("Ecrire Date NAISSANCE");
		}
		break;

		case "NOM_ETU": {
			byte[] blocs = {  (byte) 0x04, (byte) 0x05, (byte) 0x06 };
			ecrire(blocs, decomposer(information, 3));
			System.out.println("Ecrire NOM");
		}
		break;

		case "PRENOM_ETU": {
			byte[] blocs = { (byte) 0x08, (byte) 0x09 };
			ecrire(blocs, decomposer(information, 2));
		}
		break;

		case "ID_ETU": {
			byte[] blocs = { (byte) 0x0A };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "SEXE_ETU": {
			byte[] blocs = { (byte) 0x0C };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "CITE_ETU": {
			byte[] blocs = { (byte) 0x0D };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "ETAB_ETU": {
			byte[] blocs = { (byte) 0x0E };
			ecrire(blocs, decomposer(information, 1));
		}
		break;


		case "NATIONALITE_ETU": {
			byte[] blocs = { (byte) 0x10 };
			ecrire(blocs, decomposer(information, 2));
		}
		break;
		
		case "STATUT": {
			byte[] blocs = { (byte) 0x11 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;
		
		case "DATE_EXPCARTE": {
			byte[] blocs = { (byte) 0x12 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;
		
		// Fin Ecrire Information Etudiants

		////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// Ecrire Information Personnel

		case "IDENTIFICATION_PERS": {
			byte[] blocs = { (byte) 0x01 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "NOM_PERS": {
			byte[] blocs = { (byte) 0x02, (byte) 0x04, (byte) 0x05, (byte) 0x06 };
			ecrire(blocs, decomposer(information, 4));
		}
		break;

		case "PRENOM_PERS": {
			byte[] blocs = { (byte) 0x08, (byte) 0x09, (byte) 0x0A, (byte) 0x0C };
			ecrire(blocs, decomposer(information, 4));
		}
		break;

		case "MARITAL_PERS": {
			byte[] blocs = { (byte) 0x0D, (byte) 0x0E };
			ecrire(blocs, decomposer(information, 2));
		}
		break;

		case "SEXE_DATENAISSANCE_PERS": {
			byte[] blocs = { (byte) 0x10 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "LIEUNAISS_PERS": {
			byte[] blocs = { (byte) 0x11, (byte) 0x12 };
			ecrire(blocs, decomposer(information, 2));
		}
		break;

		case "CNI_PERS": {
			byte[] blocs = { (byte) 0x14 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "NATIONALITE_PERS": {
			byte[] blocs = { (byte) 0x16, (byte) 0x18 };
			ecrire(blocs, decomposer(information, 2));
		}
		break;

		case "EMAIL_PERS": {
			byte[] blocs = { (byte) 0x19, (byte) 0x1A, (byte) 0x1C };
			ecrire(blocs, decomposer(information, 3));
		}
		break;

		case "STRUCTURE_PERS": {
			byte[] blocs = { (byte) 0x1D, (byte) 0x1E };
			ecrire(blocs, decomposer(information, 2));
		}
		break;

		case "CLASSIFICATION_PERS": {
			byte[] blocs = { (byte) 0x20, (byte) 0x21 };
			ecrire(blocs, decomposer(information, 2));
		}
		break;

		case "GRADE_PERS": {
			byte[] blocs = { (byte) 0x22, (byte) 0x24 };
			ecrire(blocs, decomposer(information, 2));
		}
		break;

		case "DATEEMBAUCHE_PERS": {
			byte[] blocs = { (byte) 0x25 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "NUM_EMPLOI_PERS": {
			byte[] blocs = { (byte) 0x26 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "DATE_DELCARTEPERS": {
			byte[] blocs = { (byte) 0x31 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "DATE_EXPCARTEPERS": {
			byte[] blocs = { (byte) 0x32 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "INFO_SERVICEPERS": {
			byte[] blocs = { (byte) 0x34, (byte) 0x35, (byte) 0x36 };
			ecrire(blocs, decomposer(information, 3));
		}
		break;

		case "DMAJ_SERVICEPERS": {
			byte[] blocs = { (byte) 0x38 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		// Fin Ecrire Information Personnel

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// Ecrire Information Visiteur

		case "IDENTIFICATION_VISITEUR": {
			byte[] blocs = { (byte) 0x01 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "NOM_VISITEUR": {
			byte[] blocs = { (byte) 0x02, (byte) 0x04, (byte) 0x05, (byte) 0x06 };
			ecrire(blocs, decomposer(information, 4));
		}
		break;

		case "PRENOM_VISITEUR": {
			byte[] blocs = { (byte) 0x08, (byte) 0x09, (byte) 0x0A, (byte) 0x0C };
			ecrire(blocs, decomposer(information, 4));
		}
		break;

		case "NOMMARITAL_VISITEUR": {
			byte[] blocs = { (byte) 0x0D, (byte) 0x0E };
			ecrire(blocs, decomposer(information, 2));
		}
		break;

		case "SEXE_DATENAISSANCE_VISITEUR": {
			byte[] blocs = { (byte) 0x10 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "LIEUNAI_VISITEUR": {
			byte[] blocs = { (byte) 0x11, (byte) 0x12 };
			ecrire(blocs, decomposer(information, 2));
		}
		break;

		case "CNI_VISITEUR": {
			byte[] blocs = { (byte) 0x14 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "DATEDEB_VISITEUR": {
			byte[] blocs = { (byte) 0x31 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "DATEFIN_VISITEUR": {
			byte[] blocs = { (byte) 0x32 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		case "NATIONALITE_VISITEUR": {
			byte[] blocs = { (byte) 0x16, (byte) 0x18 };
			ecrire(blocs, decomposer(information, 2));
		}
		break;

		case "ENTITEPROV_VISITEUR": {
			byte[] blocs = { (byte) 0x19, (byte) 0x1A, (byte) 0x1C };
			ecrire(blocs, decomposer(information, 3));
		}
		break;

		case "FONCTION_VISITEUR": {
			byte[] blocs = { (byte) 0x1D, (byte) 0x1E };
			ecrire(blocs, decomposer(information, 2));
		}
		break;

		case "STRUCTUREACC_VISITEUR": {
			byte[] blocs = { (byte) 0x20, (byte) 0x21 };
			ecrire(blocs, decomposer(information, 2));
		}
		break;

		case "OBJETVISIT_VISITEUR": {
			byte[] blocs = { (byte) 0x22, (byte) 0x24, (byte) 0x25, (byte) 0x26 };
			ecrire(blocs, decomposer(information, 4));
		}
		break;

		case "INFOSERVICE_VISITEUR": {
			byte[] blocs = { (byte) 0x34, (byte) 0x35, (byte) 0x36 };
			ecrire(blocs, decomposer(information, 3));
		}
		break;

		case "DATEMAJSERVICE_VISITEUR": {
			byte[] blocs = { (byte) 0x38 };
			ecrire(blocs, decomposer(information, 1));
		}
		break;

		// Fin Ecrire Information Visiteur

		default:
			System.out.println("Encodeur: aucun choix effectué");
		}
		rep = true;

		return rep;

	}

	public byte[] decomposer(String info, int taille) {
		int n;
		int t = taille * 16;
		if (info.length() < t) {
			n = t - info.length();
			for (int i = 0; i < n; i++)
				info += " ";
		}
		return info.getBytes();
	}

	public void ecrire(byte[] bloc, byte[] data) {
		int nbrBloc = bloc.length;
		int k;

		for (int i = 0; i < nbrBloc; i++) {

			authentification((byte) bloc[i]);
			byte[] apduArray = new byte[21];
			apduArray[0] = (byte) 0xFF;
			apduArray[1] = (byte) 0xD6;
			apduArray[2] = (byte) 0X00;
			apduArray[3] = (byte) bloc[i];
			apduArray[4] = (byte) 16;
			k = 0;
			for (int j = i * 16; j < (i + 1) * 16; j++) {
				apduArray[5 + k] = data[j];
				k++;
			}
			executeCommande(apduArray, "ecrire");
		}

	}

	public String lecture(byte[] blocs) {// lecture depuis la puce

		String rep = "";
		for (int i = 0; i < blocs.length; i++) {
			authentification(blocs[i]);
			byte[] apduArray = { (byte) 0xFF, (byte) 0xB0, 0x00, blocs[i], (byte) 0x10 };
			rep += executeCommande(apduArray, "lecture");
		}
		return rep;
	}

	public void loadKey() { // chargement de clé
		byte[] apduArray = { (byte) 0xFF, (byte) 0x82, (byte) 0x20, (byte) 0x00, (byte) 0x06, (byte) 0xFF, (byte) 0xFF,
				(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF };
		executeCommande(apduArray, "loadKey");
	}

	public void authentification(byte bloc) { // authentification de bloc
		byte[] apduArray = { (byte) 0xFF, (byte) 0x86, (byte) 0x00, (byte) 0x00, (byte) 0x05, (byte) 0x01, (byte) 0x00,
				bloc, (byte) 0x60, (byte) 0x00 };
		executeCommande(apduArray, "authentification");
	}

	public String executeCommande(byte[] apduArray, String type) { // executer
		// commande
		// sur la
		// puce
		CommandAPDU GetData = new CommandAPDU(apduArray);
		ResponseAPDU cardResponseAPDU;
		String value = "";

		try {
			cardResponseAPDU = channel.transmit(GetData);
			value = new String(cardResponseAPDU.getData(), "UTF-8");

			System.out.println("--" + type + ": \t\t Nr: " + cardResponseAPDU.getNr() + " SW: "
					+ cardResponseAPDU.getSW() + " SW1 :" + cardResponseAPDU.getSW1() + " Data: " + value);

		} catch (CardException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return value;

	}

}
