package com.bitwise.magnolia.web.restful.resource.asm.finance;
/**
 *  
 * @author Sika Kay
 * @date 25/04/17
 *
 */
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.model.finance.BillingDetails;
import com.bitwise.magnolia.web.restful.controller.finance.BillingDetailsController;
import com.bitwise.magnolia.web.restful.resource.finance.BillingDetailsResource;

public class BillingDetailsResourceAsm extends ResourceAssemblerSupport<BillingDetails, BillingDetailsResource> {

	public BillingDetailsResourceAsm() {
		super(BillingDetailsController.class, BillingDetailsResource.class);
	}
	
	@Override
	public BillingDetailsResource toResource(BillingDetails billing) {
		BillingDetailsResource res = new BillingDetailsResource();
		res.setRid(billing.getId());
		//res.setEmailAddress(billing.getEmailAddress().getUser().getPrimaryEmail());
		res.setFeesAmount(billing.getFeesAmount());
		//res.setLga(billing.getLga().getUser().getLga().getName());
		res.setNotes(billing.getNotes());
		res.setPaymentMethod(billing.getPaymentMethod());
		res.setPaymentReference(billing.getPaymentReference());
		//res.setPersonName(billing.getPersonName().getUser().getFullName());
		//res.setReferenceNumber(billing.getReferenceNumber());
		res.setResponseCode(billing.getResponseCode());
		res.setSemester(billing.getSemester().getSession());
		//res.setStudyProgramme(billing.getStudyProgramme().getStudyProgramme().getName());
		//res.setState(billing.getState().getUser().getState().getName());
		res.setStatement(billing.getStatement());
		res.setStatus(billing.getStatus());
		//res.setStreetAddress(billing.getStreetAddress().getUser().getStreetAddress());
		res.setStudentId(billing.getStudentId().getStudentId());
		res.setUserId(billing.getUserId().getUsername());
		res.setPaidAt(billing.getPaidAtString());
		res.add(linkTo(methodOn(BillingDetailsController.class).findBilling(billing.getId())).withSelfRel());
		return res;
	}

}
