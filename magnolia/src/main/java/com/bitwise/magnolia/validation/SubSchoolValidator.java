package com.bitwise.magnolia.validation;
/**
 *  
 * @author Sika Kay
 * @date 01/05/17
 *
 */
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bitwise.magnolia.model.school.SubSchool;

public class SubSchoolValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return (SubSchool.class).isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
	}

}
