package com.bitwise.magnolia.validation;
/**
 *  
 * @author Sika Kay
 * @date 01/05/17
 *
 */
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bitwise.magnolia.model.course.Course;

public class CourseValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return (Course.class).isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

}
