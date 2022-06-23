package com.m2m.onousc.business.referentiel.vo;

public class LigneInscriptionStructure {

	private String cin;
	private String dateNaissance;
	private String nom;
	private String prenom;
	private String sexe;
	private String ville;
	private String site;
	// private String boursier;
	private String email;
	private String codeMassar;
	private String typePersonelle;
	 private String typeCarte;
	 private String CodeProfil;
	 private String tele;
	 private String etablissement;
 
	public LigneInscriptionStructure() {
		super();
	}

	public LigneInscriptionStructure(String cin, String dateNaissance, String nom, String prenom, String sexe,
			String ville, String site, String email, String codeMassar, String TypePersonelle, String TypeCarte, String codeProfil, String Tele, String Etablissement) {
		super();
		this.cin = cin;
		this.dateNaissance = dateNaissance;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.ville = ville;
		this.site = site;
		this.email = email;
		this.codeMassar = codeMassar;
		this.typePersonelle = TypePersonelle;
		this.typeCarte = TypeCarte;
		this.CodeProfil = codeProfil;
		this.tele = Tele;
		this.etablissement = Etablissement;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

//	public String getBoursier() {
//
//		switch (boursier) {
//		case "C":
//			return "Complete";
//
//		case "D":
//			return "Demi";
//
//		case "A":
//			return "Aucune";
//
//		}
//		return boursier;
//
//	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodeMassar() {
		return codeMassar;
	}

	public void setCodeMassar(String codeMassar) {
		this.codeMassar = codeMassar;
	}

 
	public String getTypePersonelle() {
		return typePersonelle;
	}

	public void setTypePersonelle(String typePersonelle) {
		this.typePersonelle = typePersonelle;
	}
 

	public String getTypeCarte() {
		return typeCarte;
	}

	public void setTypeCarte(String typeCarte) {
		this.typeCarte = typeCarte;
	}

	public String getCodeProfil() {
		return CodeProfil;
	}

	public void setCodeProfil(String codeProfil) {
		CodeProfil = codeProfil;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

}
