package com.bitwise.magnolia.validation;
/**
 *  
 * @author Sika Kay
 * @date 01/05/17
 *
 */
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bitwise.magnolia.model.school.Campus;

public class CampusValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return (Campus.class).isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

}
