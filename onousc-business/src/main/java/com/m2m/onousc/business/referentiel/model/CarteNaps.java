package com.m2m.onousc.business.referentiel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;

/**
 * 
 * @author msadik
 */
@Entity
@Table(name = "CARTE_NAPS")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "CARTE_NAPS_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class CarteNaps extends GenericEntity implements ITracable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2759578458407247080L;

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "id")
	private Long id;

	@Column(name = "NOMPRENOM")
	private String nomprenom;

	@Column(name = "NOM")
	private String nom;

	@Column(name = "PRENOM")
	private String prenom;

	@Column(name = "NUMIDENTITE")
	private String numidentite;

	@Column(name = "TELEPHONE")
	private String tel;

	@Column(name = "ETABLISSEMENT")
	private String etab;

	@Column(name = "MATR")
	private String matr;

	@Column(name = "NUM_CARTE")
	private String numcarte;

	@Column(name = "MOTIF_REJET")
	private String motifRejet;

	@Column(name = "STATUT")
	@Enumerated(EnumType.STRING)
	private EntityStatus statut;

	@ManyToOne
	@JoinColumn(name = "SITE", referencedColumnName = "SITE_id")
	private Site site;

	public String getMotifRejet() {
		return motifRejet;
	}

	public void setMotifRejet(String motifRejet) {
		this.motifRejet = motifRejet;
	}

	public String getMatr() {
		return matr;
	}

	public void setMatr(String matr) {
		this.matr = matr;
	}

	public EntityStatus getStatut() {
		return statut;
	}

	public String getNumcarte() {
		return numcarte;
	}

	public void setNumcarte(String numcarte) {
		this.numcarte = numcarte;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	public CarteNaps() {

	}
	
	public CarteNaps(Long id, String nomprenom, String nom, String prenom, String numidentite, String tel, String etab,
			String matr, String numcarte, String motifRejet, EntityStatus statut, Site site) {
		super();
		this.id = id;
		this.nomprenom = nomprenom;
		this.nom = nom;
		this.prenom = prenom;
		this.numidentite = numidentite;
		this.tel = tel;
		this.etab = etab;
		this.matr = matr;
		this.numcarte = numcarte;
		this.motifRejet = motifRejet;
		this.statut = statut;
		this.site = site;
	}

	public String getNomprenom() {
		return nomprenom;
	}

	public void setNomprenom(String nomprenom) {
		this.nomprenom = nomprenom;
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

	public String getNumidentite() {
		return numidentite;
	}

	public void setNumidentite(String numidentite) {
		this.numidentite = numidentite;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEtab() {
		return etab;
	}

	public void setEtab(String etab) {
		this.etab = etab;
	}

	public void setId(Long id) {
		this.id = id;
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
		CarteNaps other = (CarteNaps) obj;
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

	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}
}
