package com.m2m.technicalservices.core;

import org.springframework.transaction.annotation.Transactional;




/**
 * L’interface IUseCaseController représente l’interface commune à implémenter
 * par l’ensemble des Uses Cases. Le point d’entrée de cette interface qui est
 * la méthode « Result process() » est marqué avec l’annotation Spring @Transactional
 * pour permettre à Spring de gérer la transaction applicative.
 * 
 * @author Younes SOUTEH
 * 
 */
public interface IUseCaseController {
	/**
	 * Point d'entree pour les Uses Cases
	 * 
	 * @return Result
	 */
	@Transactional
	ProcessResult process();	
	
}
