package com.m2m.technicalservices.audit.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import com.m2m.technicalservices.dao.impl.GenericEntity;

@Entity
@Table(name = "TRACE")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "TRACE_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class TraceEntity extends GenericEntity {

	// id de l'objet trace

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "ID")
	private Long id;

	// user
	@Column
	private String userID;

	// action insert=1, update=2, delete=3
	@Column
	private int action;

	// quant
	@Column
	private Date actionWhen;

	// id de l'objet a trace
	@Column
	private Long id_Entity;

	// entity name
	@Column
	private String nameEntity;

	public String getNameEntity() {
		return nameEntity;
	}

	public void setNameEntity(String nameEntity) {
		this.nameEntity = nameEntity;
	}

	// etat avant
	@Column(name = "traceInfo")
	private String traceInfoIn;

	// etat apres dans le cas d'un update, sinon il sera null
	// @Column(name="traceInfoNew")
	@Transient
	private String traceInfoOut;

	// getter/setter
	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTraceInfoIn() {
		return traceInfoIn;
	}

	public void setTraceInfoIn(String traceInfoIn) {
		this.traceInfoIn = traceInfoIn;
	}

	public String getTraceInfoOut() {
		return traceInfoOut;
	}

	public void setTraceInfoOut(String traceInfoOut) {
		this.traceInfoOut = traceInfoOut;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public Date getActionWhen() {
		return actionWhen;
	}

	public void setActionWhen(Date when) {
		this.actionWhen = when;
	}

	

	public Long getId_Entity() {
		return id_Entity;
	}

	public void setId_Entity(Long id_Entity) {
		this.id_Entity = id_Entity;
	}

	@Override
	public String toString() {
		return "TraceEntity [" + "idObject=" + id + ", userID=" + userID
				+ ", action=" + action + ", when=" + actionWhen
				+ ", traceInfoIn=" + traceInfoIn + ", traceInfoOut="
				+ traceInfoOut + "]";
	}
}
