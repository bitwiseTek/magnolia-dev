package com.bitwise.magnolia.web.security;
/**
 *  
 * @author Sika Kay
 * @date 19/02/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bitwise.magnolia.model.security.Permission;
import com.bitwise.magnolia.model.security.Role;
import com.bitwise.magnolia.model.user.User;
import com.bitwise.magnolia.service.user.UserService;
import com.bitwise.magnolia.web.exception.AccountLockedException;

@Service("magnoliaUserDetailsService")
public class MagnoliaUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService authService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (StringUtils.isBlank(username)) {
			throw new UsernameNotFoundException("Username was empty");
		}
		
		User systemUser = authService.getAccount(username);
		
		if (systemUser == null) {
			throw new UsernameNotFoundException(String.format("User with Username %s does not exist", username));
		}
		
		if (systemUser.getStatus().equals("pedning")) {
			try {
				throw new AccountLockedException("User Account is still under review, check email for updates", "validation.user.locked");
			} catch (AccountLockedException e) {
				e.printStackTrace();
			}
		}
		
		if (systemUser.getStatus().equals("inactive")) {
			try {
				throw new AccountLockedException("User Account is has been deactivated", "validation.user.locked");
			} catch (AccountLockedException e) {
				e.printStackTrace();
			}
		}
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		for (Role role : systemUser.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoles()));
			for (Permission permission : role.getPermissions()) {
				grantedAuthorities.add(new SimpleGrantedAuthority(permission.getPermissions()));
			}
		}
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(systemUser.getUsername(), systemUser.getPassword(), grantedAuthorities);
		return userDetails;
	}

}
