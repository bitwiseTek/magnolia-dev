package com.bitwise.magnolia.exception;

public class UserDoesNotExistException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public UserDoesNotExistException() {
	}

	public UserDoesNotExistException(String message) {
		super(message);
	}
	
	public UserDoesNotExistException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public UserDoesNotExistException(Throwable cause) {
		super(cause);
	}

}
