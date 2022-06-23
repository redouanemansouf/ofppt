package com.m2m.technicalservices.dao.impl;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * Generic Class for whole persistent model. Manage optimistic lock with version
 * field, name field and toString() method
 * 
 * @author @Younes SOUTEH
 */
@MappedSuperclass
public abstract class GenericEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * version for optimistic lock
	 */
	// @Version
	@Transient
	protected int version;

	/* getter/setter */

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
