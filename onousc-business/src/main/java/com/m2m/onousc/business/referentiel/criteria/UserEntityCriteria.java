package com.m2m.onousc.business.referentiel.criteria;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import javax.persistence.Id;

import com.m2m.onousc.business.common.BaseCriteria;
import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.common.WebUtils;
import com.m2m.technicalservices.web.SearchConfig;

public class UserEntityCriteria extends BaseCriteria implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5232121339516692853L;
	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The username. */
	private String username;

	/** The statut. */
	private String statutt;

	private String groupname;
	
	private String email;
	/**
	 * 
	 */
	public UserEntityCriteria() {
		super();
		this.username = null;
		this.lastName = null;
		this.firstName = null;
		this.statutt = null;
		this.groupname = null;
	}

	public UserEntityCriteria(String username, String firstName,
			String lastName, EntityStatus statut,String groupname,SearchConfig config) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.statutt = statut.toString();
		this.groupname = groupname;
		this.setSearchConfig(config);
		this.setSortField(null);
		this.setSortOrder(null);
	}

	@SuppressWarnings("rawtypes")
	public void activeCriteria() {
		boolean filter = false;
		for (Field field : this.getClass().getDeclaredFields()) {
			Class t = field.getType();
			Object v = null;
			try {
				v = field.get(this);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TO-DO
			}
			if (t == EntityStatus.class && v != null) {
				filter = true;
				break;
			} else if (!t.isPrimitive() && !"sortField".equals(field)
					&& !"sortOrder".equals(field) && v != null) {
				filter = true;
				break;
			}
		}
		if (getStatut() != null)
			filter = true;

		setActiveFilter(filter);

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatutt() {
		return statutt;
	}

	public void setStatutt(String statut) {
		this.statutt = statut;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
