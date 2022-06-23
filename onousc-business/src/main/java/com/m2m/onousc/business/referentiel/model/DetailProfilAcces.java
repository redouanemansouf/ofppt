package com.m2m.onousc.business.referentiel.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;

/**
 * 
 * @author msadik
 */
@Entity
@Table(name = "DETAIL_PROFIL")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "DETAIL_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class DetailProfilAcces extends GenericEntity implements ITracable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6275913194424068289L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "id")
	private Long id;

	@Column(name = "TRANCHE", length = 9)
	private String tranche;

	@Column(name = "JOUR", length = 40)
	private String jour;

	@Column(name = "DATE_DEBUT")
	@Temporal(TemporalType.TIME)
	private Date dateDebut;
	
	@Column(name = "TOLERANCE_DD")
	private Integer toleranceDateDebut;
	
	@Column(name = "TOLERANCE_DF")
	private Integer toleranceDateFin;

	@Column(name = "DATE_FIN")
	@Temporal(TemporalType.TIME)
	private Date dateFin;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PROFIL")
	private Critere profil;

	@Column(name = "STATUT")
	@Enumerated(EnumType.STRING)
	private EntityStatus statut;

	public DetailProfilAcces() {

	}

	

	



	public DetailProfilAcces(Long id, String tranche, String jour,
			Date dateDebut, Integer toleranceDateDebut,
			Integer toleranceDateFin, Date dateFin, Critere profil,
			EntityStatus statut) {
		super();
		this.id = id;
		this.tranche = tranche;
		this.jour = jour;
		this.dateDebut = dateDebut;
		this.toleranceDateDebut = toleranceDateDebut;
		this.toleranceDateFin = toleranceDateFin;
		this.dateFin = dateFin;
		this.profil = profil;
		this.statut = statut;
	}







	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTranche() {
		return tranche;
	}

	public void setTranche(String tranche) {
		this.tranche = tranche;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	

	public Date getDateDebut() {
		return dateDebut;
	}



	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}



	public Date getDateFin() {
		return dateFin;
	}



	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}



	public Critere getProfil() {
		return profil;
	}

	public void setProfil(Critere profil) {
		this.profil = profil;
	}

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	

	@Override
	public String toString() {
		return "DetailProfilAcces [id=" + id + ", tranche=" + tranche
				+ ", jour=" + jour + ", dateDebut=" + dateDebut + ", dateFin="
				+ dateFin + ", profil=" + profil + ", statut=" + statut + "]";
	}



	public Integer getToleranceDateDebut() {
		return toleranceDateDebut;
	}



	public void setToleranceDateDebut(Integer toleranceDateDebut) {
		this.toleranceDateDebut = toleranceDateDebut;
	}



	public Integer getToleranceDateFin() {
		return toleranceDateFin;
	}



	public void setToleranceDateFin(Integer toleranceDateFin) {
		this.toleranceDateFin = toleranceDateFin;
	}



	@Override
	public String getTraceInfo() {
		return toString();
	}

	@Override
	public String getNameEntity() {
		return getClass().getName();
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
		DetailProfilAcces other = (DetailProfilAcces) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
