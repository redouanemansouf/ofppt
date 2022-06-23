package com.m2m.technicalservices.security.impl;

import java.util.List;

import com.m2m.technicalservices.dao.GenericDaoJpa;
import com.m2m.technicalservices.security.Permission;
import com.m2m.technicalservices.security.WinMenu;

public interface AutorizationDAOJpa extends GenericDaoJpa<WinMenu,String>{

	List<Permission> listPermission(String codeOperateur);
	
}
