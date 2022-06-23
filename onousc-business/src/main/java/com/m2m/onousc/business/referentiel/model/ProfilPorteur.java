package com.m2m.onousc.business.referentiel.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;

/**
 * 
 * @author msadik
 */
@Entity
@Table(name = "PROFIL_PORTEUR")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "PROFIL_PORTEUR_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class ProfilPorteur extends GenericEntity implements ITracable {

	/**
	 * 
	 */
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7936736477987299847L;

	/**
	 * 
	 */
	

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "ID")
	private Long id;

	@Column(name = "CODE")
	private String code;

	@Column(name = "LIBELLE")
	private String libelle;

	@Column(name = "CATEGORIE")
	private String categorie;

	@Column(name = "RATIO")
	private Integer ratio;
	
	@Column(name = "STATUT")
    @Enumerated(EnumType.STRING)
    private EntityStatus statut;


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Integer getRatio() {
		return ratio;
	}

	public void setRatio(Integer ratio) {
		this.ratio = ratio;
	}

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	public ProfilPorteur() {

	}

	public ProfilPorteur(Long id,String code , String libelle , String categorie , Integer ratio , EntityStatus statut) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.categorie = categorie;
		this.ratio = ratio;
		this.statut = statut;
	
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
		ProfilPorteur other = (ProfilPorteur) obj;
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
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	

}
