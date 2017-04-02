package com.bitwise.magnolia.web.security;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
/**
 *  
 * @author Sika Kay
 * @date 19/02/17
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.model.user.User;
import com.bitwise.magnolia.service.user.UserService;

@Component
public class CredentialValidation {
	
	protected Logger logger = LoggerFactory.getLogger(CredentialValidation.class);
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Environment env;
	
	public User validateUsernameAndPassword(String username, CharSequence password) {
		User user = this.userService.getAccount(username);
		if (!credentialsMatch(password, user)) {
			logger.info(env.getProperty("validation.signin.invalid"));
			throw new BadCredentialsException(env.getProperty("validation.signin.invalid"));
		}
		if (user.getStatus().equals(ApplicationConstant.PENDING_STATUS)) {
			logger.info(env.getProperty("users.login.locked"));
			throw new LockedException(env.getProperty("users.login.locked"));
		}
		if (user.getStatus().equals(ApplicationConstant.INACTIVE_STATUS)) {
			logger.info(env.getProperty("users.login.deactivated"));
			throw new DisabledException(env.getProperty("users.login.deactivated"));
		}
		user.setLastLogin(new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()));
		user.setLastLogout(org.joda.time.format.DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss").print(DateTime.now().minusMinutes(19)));
		this.userService.update(user);
		return user;
	}
	
	private boolean credentialsMatch(CharSequence password, User user) {
		return user != null && password != null && user.getPassword() != null && this.passwordEncoder.matches(password, user.getPassword());
	}

}
