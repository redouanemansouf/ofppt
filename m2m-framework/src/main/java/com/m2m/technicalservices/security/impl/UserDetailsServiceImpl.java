package com.m2m.technicalservices.security.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2m.technicalservices.log.ILogger;
import com.m2m.technicalservices.log.impl.SL4JLogger;
import com.m2m.technicalservices.security.RoleEntity;
import com.m2m.technicalservices.security.UserEntity;

/**
 * An incomplete implementation of Spring Security's UserDetailsService...
 */
@Service("userDetailService")
public class UserDetailsServiceImpl implements UserDetailsService {

	private ILogger logger = SL4JLogger
			.getInstance(UserDetailsServiceImpl.class);
	private SecurityDaoJpa securityDaoJpa;

	@Transactional
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		if (username == null || username.isEmpty()) {
			logger.error("Empty username");
			throw new UsernameNotFoundException("Empty username");
		}
		// Load user from database
		UserEntity userEntity = securityDaoJpa.findByUserName(username);

		List<GrantedAuthority> authorities = toGrantedAuthorities(userEntity
				.getRoles());
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		User user = new User(username, userEntity.getPassword(), enabled,
				accountNonExpired, credentialsNonExpired, accountNonLocked,
				authorities);
		return user;
	}

	private List<GrantedAuthority> toGrantedAuthorities(Set<RoleEntity> roles) {
		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(
				roles.size());
		for (RoleEntity role : roles) {
			result.add(new GrantedAuthorityImpl(role.getRole()));
		}
		return result;
	}

	public SecurityDaoJpa getSecurityDaoJpa() {
		return securityDaoJpa;
	}

	public void setSecurityDaoJpa(SecurityDaoJpa securityDaoJpa) {
		this.securityDaoJpa = securityDaoJpa;
	}
}
