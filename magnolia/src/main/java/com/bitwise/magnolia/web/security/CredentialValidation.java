package com.bitwise.magnolia.web.security;
/**
 *  
 * @author Sika Kay
 * @date 19/02/17
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.bitwise.magnolia.model.user.User;
import com.bitwise.magnolia.service.user.UserService;

@Component
public class CredentialValidation {
	
	protected Log log = LogFactory.getLog(CredentialValidation.class);
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Environment env;
	
	public User validateUsernameAndPassword(String username, CharSequence password) {
		User user = this.userService.getAccount(username);
		if (!credentialsMatch(password, user)) {
			log.info(env.getProperty("validation.signin.invalid"));
			throw new BadCredentialsException(env.getProperty("validation.signin.invalid"));
		}
		return user;
	}
	
	private boolean credentialsMatch(CharSequence password, User user) {
		return user != null && password != null && user.getPassword() != null && this.passwordEncoder.matches(password, user.getPassword());
	}

}
