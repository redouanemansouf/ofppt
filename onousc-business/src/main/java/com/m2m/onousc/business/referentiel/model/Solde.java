package com.m2m.onousc.business.referentiel.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;

/**
 * 
 * @author msadik
 */
@Entity
@Table(name = "SOLDE")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "SOLDE_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class Solde extends GenericEntity implements ITracable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2759578458407247080L;

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "SLD_id")
	private Long id;

	@Column(name = "SLD_MATR")
	private String matr;

	@Column(name = "SLD_DATE")
	private Date date;

	@Column(name = "SLD_MAJ")
	private String maj;

	@Column(name = "SLD_INIT")
	private String init;

	@ManyToOne
	@JoinColumn(name = "SLD_SITE", referencedColumnName = "SITE_id")
	private Site site;

   private String nom;

   private String prenom;

	public String getMatr() {
		return matr;
	}

	public void setMatr(String matr) {
		this.matr = matr;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMaj() {
		return maj;
	}

	public void setMaj(String maj) {
		this.maj = maj;
	}

	public String getInit() {
		return init;
	}

	public void setInit(String init) {
		this.init = init;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Solde() {

	}

	public Solde(Long id, String matr, Date date, String maj, String init) {
		super();
		this.id = id;
		this.matr = matr;
		this.date = date;
		this.maj = maj;
		this.init = init;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String getTraceInfo() {
		return toString();
	}

	@Override
	public String toString() {
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Solde other = (Solde) obj;
		if (id == null) {
			if (other.id != null)	
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String getNameEntity() {
		return getClass().getName();
	}

	 
 

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
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

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

}
