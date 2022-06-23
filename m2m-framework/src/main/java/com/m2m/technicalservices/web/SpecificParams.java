/*
 * SpecificParams.java
 *
 * Copyright (c) 1990-2017 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.technicalservices.web;

/**
 * The Interface SpecificParams.
 * 
 * @version 1.0 4 avr. 2017
 * @author sbchi
 */
public interface SpecificParams {

	/** The agence id. */
	String AGENCE_ID = "agenceId";

	/** The agence libelle. */
	String AGENCE_LIBELLE = "agenceLibelle";

	/** The is desactiver delais enregistrement bagage. */
	String isDesactiverDelaisEnregistrementBagage = "isDesactiverDelaisEnregistrementBagage";

	/** The data to print. */
	String DATA_TO_PRINT = "DATA_TO_PRINT";

	/** The key for print. */
	String KEY_FOR_PRINT = "KEY_FOR_PRINT";

	/** The ready. */
	String READY = "READY";

	/** The state print. */
	String STATE_PRINT = "STATE_PRINT";

	/** The user session. */
	String USER_SESSION = "userSession";

	/** The user session tmp. */
	String USER_SESSION_TMP = "USER_SESSION_TMP";

	String TYPE_ERROR_PRINT = "TYPE_ERROR_PRINT";

	String STATE_PRINTER = "STATE_PRINTER";
	
	/** The data to print. */
	String DATA_TO_SEND = "DATA_TO_SEND";
	String ERROR_MESSAGE = "ERROR_MESSAGE";
	String STATE_FINISHED = "STATE_FINISHED";
	String ABORT="ABORT";
	String WHILE="WHILE";
	String CONTINUE="CONTINUE";
	
	String UPLOADED_DATA = "UPLOADED_DATA";
	String CARD_UID= "CARD_UID";
	

}