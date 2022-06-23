//
//package com.m2m.technicalservices.security.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
//import com.m2m.applicationBlanche.model.persistent.RoleEntity;
//import com.m2m.applicationBlanche.model.persistent.UserEntity;
//import com.m2m.technicalservices.log.ILogger;
//import com.m2m.technicalservices.log.impl.SL4JLogger;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ldap.core.DirContextOperations;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.GrantedAuthorityImpl;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
//import org.springframework.stereotype.Service;
//
///**
// * An incomplete implementation of Spring Security's UserDetailsService...
// */
////@Service
//public class MyAuthoritiesPopulator implements LdapAuthoritiesPopulator  {
//
//    private ILogger logger = SL4JLogger.getInstance(MyAuthoritiesPopulator.class);
//    @Autowired
//    private SecurityDaoJpa securityDaoJpa; 
//
//    public List<GrantedAuthority> getGrantedAuthorities(
//			DirContextOperations userData, String username) {
//    		
//		// if (username == null || username.isEmpty()) {
//	    if (username == null ) {
//        	logger.error("Empty username");
//            throw new UsernameNotFoundException("Empty username"); 
//        }
//        //Load user from database
//        UserEntity userEntity = securityDaoJpa.findByUserName(username);
//
//        return toGrantedAuthorities((userEntity).getRoles());
//
//	}
//
//
//
//    private List<GrantedAuthority> toGrantedAuthorities(Set<RoleEntity> roles) {
//    	List<GrantedAuthority> result = new ArrayList<GrantedAuthority>();
//
//        for (RoleEntity role: roles){
//        	result.add(new GrantedAuthorityImpl(role.getRole()));        	
//        }            
//        return result;
//    }
//    
//    public SecurityDaoJpa getSecurityDaoJpa() {
//		return securityDaoJpa;
//	}
//
//	public void setSecurityDaoJpa(SecurityDaoJpa securityDaoJpa) {
//		this.securityDaoJpa = securityDaoJpa;
//	}    
//}
