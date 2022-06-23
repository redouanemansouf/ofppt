package com.m2m.onousc.business.referentiel.model;

import java.util.Date;

import javax.persistence.Basic;
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
import com.m2m.onousc.business.utils.Utils;
import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;

@Entity
@Table(name = "REF_EVENEMENT")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "EVEN_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class Evenement extends GenericEntity implements ITracable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1680229123179199010L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "EVE_ID")
	private Long id;

	@Column(name = "EVE_CODE")
	private String code;

	@Column(name = "EVE_DESC")
	private String description;

	@Column(name = "EVE_ETAT")
	private String etat;

	
	@Column(name = "EVE_DATE_DEBUT")
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	@Column(name = "EVE_DATE_FIN")
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	
	@Column(name = "EVE_PRIORITE")
	private String priorite;

	
	@Column(name = "EVE_STATUT")
	@Enumerated(EnumType.STRING)
	private EntityStatus statut;
	

	


	public Evenement() {
		
	}


	public Evenement(Long id, String code, String description, String etat,
			Date dateDebut, Date dateFin, EntityStatus statut) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
		this.etat = etat;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.statut = statut;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
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


	public EntityStatus getStatut() {
		return statut;
	}


	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}


	@Override
	public String getTraceInfo() {
		// TODO Auto-generated method stub
		return toString();
	}


	


	@Override
	public String toString() {
		return "Evenement [id=" + id + ", code=" + code + ", description="
				+ description + ", etat=" + etat + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", statut=" + statut + "]";
	}


	public String getPriorite() {
		return priorite;
	}


	public void setPriorite(String priorite) {
		this.priorite = priorite;
	}


	@Override
	public String getNameEntity() {
		return Evenement.class.toString();
	}

	
	
	
	
	
}
