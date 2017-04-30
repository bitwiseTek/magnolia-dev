package com.bitwise.magnolia.validation;
/**
 *  
 * @author Sika Kay
 * @date 16/04/17
 *
 */
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bitwise.magnolia.model.staff.Staff;

public class StaffValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return (Staff.class).isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

}
