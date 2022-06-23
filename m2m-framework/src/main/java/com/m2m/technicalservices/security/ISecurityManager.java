package com.m2m.technicalservices.security;

import org.springframework.security.core.Authentication;

public interface ISecurityManager {
	/**
	 * check functionality access
	 * @param roles
	 * @return
	 * @throws AutorizationException
	 */
	boolean checkAccess(String[] roles) throws AutorizationException;
	/**
	 * check authentication
	 * @param login
	 * @param passwd
	 * @return
	 * @throws AuthenticationException
	 */
	Authentication authenticate(String login, String passwd) throws AuthenticationException;
}
