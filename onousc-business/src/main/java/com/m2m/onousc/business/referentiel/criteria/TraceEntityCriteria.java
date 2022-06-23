package com.m2m.onousc.business.referentiel.criteria;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import com.m2m.onousc.business.common.BaseCriteria;
import com.m2m.onousc.business.common.EntityStatus;

public class TraceEntityCriteria extends BaseCriteria implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5232121339516692853L;
	
	private String action;
	private Date dateDebaction;
	private Date dateFinaction;
	private String user;
	private String actionName;


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



	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}


	public Date getDateDebaction() {
		return dateDebaction;
	}


	public void setDateDebaction(Date dateDebaction) {
		this.dateDebaction = dateDebaction;
	}


	public Date getDateFinaction() {
		return dateFinaction;
	}


	public void setDateFinaction(Date dateFinaction) {
		this.dateFinaction = dateFinaction;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getActionName() {
		switch (action) {
		case "0":
			return "Insertion";
		case "1":
			return "Modification";
		case "2":
			return "Suppression";

		default:
			break;
		}
		return actionName;
	}


	public void setActionName(String actionName) {
		this.actionName = actionName;
	}


}
