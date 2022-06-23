package com.m2m.onousc.business.reservation.dao;

/**
 * The Interface Queries.
 */
public interface Queries {

	// Canaux Vente
	/** The find canal vente by criteria. */
	String FIND_CANAL_VENTE_BY_CRITERIA = "From CanalVente x where ( UPPER(x.libelle) like UPPER(?1) or ?1 is null  )"
			+ " and ( UPPER(x.description) like UPPER(?2) or ?2 is null ) and (  ?3 is null or x.statut = ?3  ) and  x.statut !='DELETED' ";

	/** The find all canal vente for combo. */
	String FIND_ALL_CANAL_VENTE_FOR_COMBO = "SELECT x FROM  CanalVente x WHERE x.statut = 'ENABLED' ";

	/** The find canal vente by code. */
	String FIND_CANAL_VENTE_BY_CODE = "SELECT x FROM  CanalVente x WHERE x.code like ?1 and x.statut != 'DELETED' ";

}
