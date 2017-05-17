package com.bitwise.magnolia.validation;
/**
 *  
 * @author Sika Kay
 * @date 05/05/17
 *
 */
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bitwise.magnolia.model.finance.BillingDetails;

public class BillingValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return (BillingDetails.class).isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

}
