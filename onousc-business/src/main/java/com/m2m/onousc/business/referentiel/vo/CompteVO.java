package com.m2m.onousc.business.referentiel.vo;


import com.m2m.onousc.business.referentiel.vo.transformer.CompteVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.security.UserEntity;
import com.m2m.technicalservices.web.ISearchResultVO;


public class CompteVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6405473648303833587L;

	/** matricule */
	private String username;

	/** Identifiant de nom. */

	private String nom;

	/** Libellé de prenom. */

	private String prenom;

	/** poste */

	private String poste;

	/** grade. */
	private String grade;

	private String date_embauche;

	private String tel;

	private String adr_mail;

	private String password;
	
	/** Statut. */
	private String statut;

	@Override
	public String getIdForSearch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITransformer<UserEntity, CompteVO> getTransformer() {
		return new CompteVOTransformer();
	}

	public CompteVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CompteVO(String username, String nom, String prenom, String poste,
			String grade, String date_embauche, String tel, String adr_mail,
			String password, String statut) {
		super();
		this.username = username;
		this.nom = nom;
		this.prenom = prenom;
		this.poste = poste;
		this.grade = grade;
		this.date_embauche = date_embauche;
		this.tel = tel;
		this.adr_mail = adr_mail;
		this.password = password;
		this.statut = statut;
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

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDate_embauche() {
		return date_embauche;
	}

	public void setDate_embauche(String date_embauche) {
		this.date_embauche = date_embauche;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdr_mail() {
		return adr_mail;
	}

	public void setAdr_mail(String adr_mail) {
		this.adr_mail = adr_mail;
	}



	public String getStatut() {
		return statut;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

}
