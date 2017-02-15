package com.bitwise.magnolia.web.restful.exceptions;
/**
 *  
 * @author Sika Kay
 * @date 05/05/16
 *
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ConflictException() {
	}
	
	public ConflictException(String message) {
		super(message);
	}
	
	public ConflictException(String message, Throwable cause) {
		super(message, cause);
	}

}
