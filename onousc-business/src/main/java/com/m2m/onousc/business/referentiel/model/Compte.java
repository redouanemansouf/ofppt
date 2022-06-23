package com.m2m.onousc.business.referentiel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;



@Entity
@Table(name = "USER_ENTITY")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "COMPTE_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class Compte extends GenericEntity implements ITracable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6561754117045385039L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	private Long id;

	/** matricule */
	private String username;

	/** Identifiant de nom. */
	@Column(name = "IN_NOM", length = 30)
	private String nom;

	/** Libellé de prenom. */
	@Column(name = "IN_PRENOM", length = 30)
	private String prenom;

	/** poste */
	@Column(name = "IN_POSTE")
	private String poste;

	/** grade. */
	@Column(name = "IN_GRADE")
	private String grade;

	@Column(name = "IN_DATEMBAUCHE")
	private String date_embauche;

	@Column(name = "IN_TEL")
	private String tel;

	@Column(name = "IN_MAIL")
	private String adr_mail;

	private String password;

	public void setId(Long id) {
		this.id = id;
	}

	/** Statut. */
	@Column(name = "IN_STATUT")
	private String statut;

	@Override
	public String getTraceInfo() {
		return this.toString();
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNameEntity() {
		return this.getClass().getName();
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

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compte(String matricule, String nom, String prenom, String poste,
			String grade, String date_embauche, String tel, String adr_mail,
			String pw, String statut) {
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

	@Override
	public String toString() {
		return "Compte [matricule=" + username + ", nom=" + nom + ", prenom="
				+ prenom + ", poste=" + poste + ", grade=" + grade
				+ ", date_embauche=" + date_embauche + ", tel=" + tel
				+ ", adr_mail=" + adr_mail + ", pw=" + password + ", statut="
				+ statut + "]";
	}

}
