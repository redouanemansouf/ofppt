package com.m2m.onousc.business.referentiel.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;

@Entity
@Table(name = "IMPORT_INSCRIPTION" )
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "IMPORT_INSCRIPTION_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class ImportInscription extends GenericEntity implements ITracable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2458999743949705135L;
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "ID")
	private Long id;
	@Column(name = "CIN")	
	private String cin;
	@Column(name = "MOTIF_REJET")	
	private String motifRejet;
	@Column(name = "USERNAME")	
	private String userName;
	@Column(name = "DATE_OPERATION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOperation;
	@Column(name = "CMASSAR")
	private String codeMassar;

	public ImportInscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImportInscription(Long id, String cin, String motifRejet,
			String userName, Date dateOperation , String codeMassar) {
		super();
		this.id = id;
		this.cin = cin;
		this.motifRejet = motifRejet;
		this.userName = userName;
		this.dateOperation = dateOperation;
		this.codeMassar = codeMassar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getMotifRejet() {
		return motifRejet;
	}

	public void setMotifRejet(String motifRejet) {
		this.motifRejet = motifRejet;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	@Override
	public String toString() {
		return "ImportInscription [id=" + id + ", cin=" + cin + ", motifRejet="
				+ motifRejet + ", userName=" + userName + ", dateOperation="
				+ dateOperation + "]";
	}

	@Override
	public String getTraceInfo() {
		return this.toString();
	}

	@Override
	public String getNameEntity() {
		return this.getClass().getName();
	}

	public String getCodeMassar() {
		return codeMassar;
	}

	public void setCodeMassar(String codeMassar) {
		this.codeMassar = codeMassar;
	}

}
