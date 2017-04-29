package com.bitwise.magnolia.validation;
/**
 *  
 * @author Sika Kay
 * @date 16/04/17
 *
 */
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bitwise.magnolia.model.student.Student;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return (Student.class).isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
	}

}
