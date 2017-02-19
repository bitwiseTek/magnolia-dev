package com.bitwise.magnolia.web.security;
/**
 *  
 * @author Sika Kay
 * @date 19/02/17
 *
 */
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.bitwise.magnolia.model.user.User;

@Component
public class MagnoliaUserContext {

	public User getCurrentUser() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication auth = securityContext.getAuthentication();
		if (auth == null || auth.getPrincipal() == null || auth.getPrincipal().equals("anonymousUser")) {
			return null;
		}
		return (User) auth.getPrincipal();
	}
	
	public void setCurrentUser(User user) {
		Authentication auth = new UsernamePasswordAuthenticationToken(user, user.getPassword());
		SecurityContextHolder.getContext().setAuthentication(auth);
	}
}
