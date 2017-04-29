package com.bitwise.magnolia.web.restful.resource.asm.finance;
/**
 *  
 * @author Sika Kay
 * @date 25/04/17
 *
 */
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.util.BillingDetailsList;
import com.bitwise.magnolia.web.restful.controller.finance.BillingDetailsController;
import com.bitwise.magnolia.web.restful.resource.finance.BillingDetailsListResource;
import com.bitwise.magnolia.web.restful.resource.finance.BillingDetailsResource;

public class BillingDetailsListResourceAsm extends ResourceAssemblerSupport<BillingDetailsList, BillingDetailsListResource> {

	public BillingDetailsListResourceAsm() {
		super(BillingDetailsController.class, BillingDetailsListResource.class);
	}
	
	@Override
	public BillingDetailsListResource toResource(BillingDetailsList billingList) {
		List<BillingDetailsResource> resList = new BillingDetailsResourceAsm().toResources(billingList.getDetails());
		BillingDetailsListResource finalRes = new BillingDetailsListResource();
		finalRes.setBillingDetails(resList);
		return finalRes;
	}

	
}
