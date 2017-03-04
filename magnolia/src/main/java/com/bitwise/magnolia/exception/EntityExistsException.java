package com.bitwise.magnolia.exception;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
public class EntityExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EntityExistsException() {
		super();
	}

	public EntityExistsException(String message) {
		super(message);
	}
	
	public EntityExistsException(String message, Throwable cause) {
		super(message, cause);
	}
}
