package com.m2m.technicalservices.security.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.m2m.technicalservices.log.ILogger;
import com.m2m.technicalservices.log.impl.SL4JLogger;
import com.m2m.technicalservices.security.AuthenticationException;
import com.m2m.technicalservices.security.AutorizationException;
import com.m2m.technicalservices.security.ISecurityManager;

public class SecurityManagerImpl implements ISecurityManager {
	
	private ILogger logger = SL4JLogger
			.getInstance(SecurityManagerImpl.class);
	
	private AuthenticationManager authenticationManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.technicalservices.security.ISecurityManager#checkAccess
	 * (java.lang.String[])
	 */
	public boolean checkAccess(String[] roles) throws AutorizationException {
		boolean result = false;
		for (GrantedAuthority authority : SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities()) {
			String userRole = authority.getAuthority();
			for (String role : roles) {
				if (role.equals(userRole)) {
					result = true;
					break;
				}
			}
			if (result) {
				break;
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.technicalservices.security.ISecurityManager#authenticate
	 * (java.lang.String, java.lang.String)
	 */
	public Authentication authenticate(String username, String password)
			throws AuthenticationException {
		// Authentication authentication =
		// authenticationManager.authenticate(new
		// UsernamePasswordAuthenticationToken(username, password));
		// SecurityContextHolder.getContext().setAuthentication(authentication);
		// return authentication.isAuthenticated();
		Authentication authentication = new UsernamePasswordAuthenticationToken(
				username, password);
		try {
			authentication = authenticationManager.authenticate(authentication);
			SecurityContextHolder.getContext()
					.setAuthentication(authentication);
		} catch (BadCredentialsException e) {
			logger.error(e.getMessage(),e);
			throw new AuthenticationException(e.getMessage(),e);
		}
		return authentication;

		// if(StringUtil.isBlank((String) authentication.getPrincipal()) ||
		// StringUtil.isBlank((String) authentication.getCredentials())){
		// throw new BadCredentialsException("Invalid username/password");
		// }
		// User user = null;
		// GrantedAuthority[] grantedAuthorities = null;
		// try{
		// user = userManagerService.getUser((String)
		// authentication.getPrincipal(), (String)
		// authentication.getCredentials());
		// }
		// catch(InvalidCredentialsException ex){
		// throw new BadCredentialsException(ex.getMessage());
		// }
		// catch(Exception e){
		// throw new
		// AuthenticationServiceException("Currently we are unable to process your request. Kindly try again later.");
		// }
		// if (user != null) {
		// List<Role> roles = user.getAssociatedRoles();
		// grantedAuthorities = new GrantedAuthority[roles.size()];
		// for (int i = 0; i &lt; roles.size(); i++) {
		// Role role = roles.get(i);
		// GrantedAuthority authority = new
		// GrantedAuthorityImpl(role.getRoleCode());
		// grantedAuthorities[i] = authority;
		// }
		// }
		// else{
		// throw new BadCredentialsException("Invalid username/password");
		// }
		// return new UsernamePasswordAuthenticationToken(user,
		// authentication.getCredentials(), grantedAuthorities);
		//

	}
	public void setAuthenticationManager(
			AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}
}
