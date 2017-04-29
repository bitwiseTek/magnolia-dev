package com.bitwise.magnolia.web.restful.resource.finance;
/**
 *  
 * @author Sika Kay
 * @date 25/04/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class BillingDetailsListResource extends ResourceSupport {

	private List<BillingDetailsResource> billingDetails = new ArrayList<BillingDetailsResource>();

	public List<BillingDetailsResource> getBillingDetails() {
		return billingDetails;
	}

	public void setBillingDetails(List<BillingDetailsResource> billingDetails) {
		this.billingDetails = billingDetails;
	}
}
