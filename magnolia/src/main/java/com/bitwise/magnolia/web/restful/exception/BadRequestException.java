package com.bitwise.magnolia.web.restful.exception;
/**
 *  
 * @author Sika Kay
 * @date 05/05/16
 *
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public BadRequestException() {
	}
	
	public BadRequestException(String message) {
		super(message);
	}
	
	public BadRequestException(String message, Throwable cause) {
		super(message, cause);
	}

}
