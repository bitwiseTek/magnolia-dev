package com.bitwise.magnolia.validation;
/**
 *  
 * @author Sika Kay
 * @date 18/03/17
 *
 */
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bitwise.magnolia.model.user.User;

public class UserValidator implements Validator {
	
	public boolean supports(Class<?> clazz) {
		return (User.class).isAssignableFrom(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "username", "required", new Object[] {"Username"});
		ValidationUtils.rejectIfEmpty(errors, "password", "required", new Object[] {"Password"});
		ValidationUtils.rejectIfEmpty(errors, "secretAnswer", "required", new Object[] {"Secret Answer"});
	}

}
