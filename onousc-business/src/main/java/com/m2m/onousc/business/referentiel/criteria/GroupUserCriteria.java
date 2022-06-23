package com.m2m.onousc.business.referentiel.criteria;

import java.io.Serializable;
import java.lang.reflect.Field;

import com.m2m.onousc.business.common.BaseCriteria;
import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.technicalservices.web.SearchConfig;

/**
 * @author iissouani
 *
 */
public class GroupUserCriteria extends BaseCriteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5232121339516692853L;
	/** The first name. */
	private Long code;
	
	private String groupName;

	/** The last name. */
	private String libelle;

	/** The username. */
	private String niveau;
	private String groupePere;
	private boolean onlyGroup = true;

	public GroupUserCriteria() {
		super();
		searchConfig = new SearchConfig();
	}

	public GroupUserCriteria(Long code, String libelle, String niveau) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.niveau = niveau;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getGroupePere() {
		return groupePere;
	}

	public void setGroupePere(String groupePere) {
		this.groupePere = groupePere;
	}

	public boolean isOnlyGroup() {
		return onlyGroup;
	}

	public void setOnlyGroup(boolean onlyGroup) {
		this.onlyGroup = onlyGroup;
	}

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

}
