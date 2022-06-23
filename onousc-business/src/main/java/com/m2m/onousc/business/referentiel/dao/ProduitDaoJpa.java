/*
 * CanalVenteDaoJpa.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.ProduitCriteria;
import com.m2m.onousc.business.referentiel.model.Produit;
import com.m2m.technicalservices.dao.GenericDaoJpa;

// TODO: Auto-generated Javadoc
/**
 * The Interface
 * 
 * @version 1.0 18 févr. 2015
 * @author msadik
 */
public interface ProduitDaoJpa extends GenericDaoJpa<Produit, Long> {

	public List<Produit> findProduitByCriteria(ProduitCriteria criteria);
	public List<Produit>  findProduitByFamille(Long id);
	public Produit  findProduitByCodeBar(String codeBar);
	public List<Produit> findProduitListByCode(String code);

}
