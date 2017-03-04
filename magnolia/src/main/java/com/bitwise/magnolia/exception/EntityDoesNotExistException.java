package com.bitwise.magnolia.exception;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
public class EntityDoesNotExistException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public EntityDoesNotExistException() {
	}

	public EntityDoesNotExistException(String message) {
		super(message);
	}
	
	public EntityDoesNotExistException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public EntityDoesNotExistException(Throwable cause) {
		super(cause);
	}

}
