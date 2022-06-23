package com.m2m.technicalservices.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROLE_ENTITY")

public class RoleEntity {

	@Id
	@Column(name= "authority" )
	private String role;

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
