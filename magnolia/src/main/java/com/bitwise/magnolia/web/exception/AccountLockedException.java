package com.bitwise.magnolia.web.exception;
/**
 *  
 * @author Sika Kay
 * @date 19/02/17
 *
 */
import org.springframework.security.core.AuthenticationException;

public class AccountLockedException extends AuthenticationException {

	private static final long serialVersionUID = 1L;
	
	private String code;
	
	public AccountLockedException(String message, String code) {
		super(message);
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
}
