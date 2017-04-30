package com.bitwise.magnolia.util;
/**
 *  
 * @author Sika Kay
 * @date 25/04/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import com.bitwise.magnolia.model.finance.BillingDetails;

public class BillingDetailsList {

	public BillingDetailsList(List<BillingDetails> details) {
		this.details = details;
	}
	
	private List<BillingDetails> details = new ArrayList<BillingDetails>();

	public List<BillingDetails> getDetails() {
		return details;
	}

	public void setDetails(List<BillingDetails> details) {
		this.details = details;
	}
}
