package com.bitwise.magnolia.web.restful.controller.finance;
/**
 *  
 * @author Sika Kay
 * @date 25/04/17
 *
 */
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.exception.EntityDoesNotExistException;
import com.bitwise.magnolia.exception.EntityExistsException;
import com.bitwise.magnolia.model.finance.BillingDetails;
import com.bitwise.magnolia.model.user.User;
import com.bitwise.magnolia.service.email.EmailService;
import com.bitwise.magnolia.service.finance.BillingDetailsService;
import com.bitwise.magnolia.util.BillingDetailsList;
import com.bitwise.magnolia.web.restful.exception.ConflictException;
import com.bitwise.magnolia.web.restful.exception.ErrorDetail;
import com.bitwise.magnolia.web.restful.exception.ResourceNotFoundException;
import com.bitwise.magnolia.web.restful.resource.asm.finance.BillingDetailsListResourceAsm;
import com.bitwise.magnolia.web.restful.resource.asm.finance.BillingDetailsResourceAsm;
import com.bitwise.magnolia.web.restful.resource.finance.BillingDetailsListResource;
import com.bitwise.magnolia.web.restful.resource.finance.BillingDetailsResource;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@RestController
@Api(value="billingDetails", description="Billing Details API")
public class BillingDetailsController {
	
	final Logger logger = LoggerFactory.getLogger(BillingDetailsController.class);
	
	@Autowired
	private BillingDetailsService billingService;
	
	@Autowired
	private EmailService emailService;
	
	//@PreAuthorize("hasRole('MANAGER') or hasRole('ACCOUNTANT')")
	@ApiOperation(value="Retrieves all the billing details", response=BillingDetails.class, responseContainer="List")		
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/billing/details/"}, 		
	method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)		
	public ResponseEntity<BillingDetailsListResource> findAllBills(@RequestParam(value="id", required=false) Long id) {			
		BillingDetailsList billingList = null;
		if (id == null) {					
			billingList = billingService.findAllBills();
		} else {				
			BillingDetails billing = billingService.findByStudentId(id);
			billingList = new BillingDetailsList(new ArrayList<BillingDetails>());				
			if (billing != null) {
				billingList = new BillingDetailsList(Arrays.asList(billing));				
			} 
		}
		BillingDetailsListResource res = new BillingDetailsListResourceAsm().toResource(billingList);				
		return new ResponseEntity<BillingDetailsListResource>(res, HttpStatus.OK);		
	}
	
	//@PreAuthorize("hasRole('MANAGER') or hasRole('ACCOUNTANT')")
	@ApiOperation(value="Retrieves a bill associated with an ID", response=BillingDetails.class)
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/billing/details/{id}"}, 
	method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BillingDetailsResource> findBilling(@PathVariable("id") Long id) {
		BillingDetails billing = billingService.findById(id);
		if (billing != null) {
			BillingDetailsResource res = new BillingDetailsResourceAsm().toResource(billing);
			return new ResponseEntity<BillingDetailsResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<BillingDetailsResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	//@PreAuthorize("hasRole('MANAGER') or hasRole('ACCOUNTANT')")
	@ApiOperation(value="Retrieves all the billing details", response=BillingDetails.class, responseContainer="List")		
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/billing/details/status/{status}"}, 		
	method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)		
	public ResponseEntity<BillingDetailsListResource> findAllCompletedBills(@PathVariable("status") String status) {			
		BillingDetailsList billingList = null;
		billingList = billingService.findAllCompletedBills(status);
		if (billingList != null) {					
			BillingDetailsListResource res = new BillingDetailsListResourceAsm().toResource(billingList);				
			return new ResponseEntity<BillingDetailsListResource>(res, HttpStatus.OK);
		} else {				
			return new ResponseEntity<BillingDetailsListResource>(HttpStatus.NOT_FOUND);
		}		
	}
	
	//@PreAuthorize("hasRole('STUDENT')")
	@ApiOperation(value="Creates a new bill", notes="The newly created bill ID will be sent in the location response header")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/billing/details/pay"}, 
	method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value={@ApiResponse(code=201, message="Bill created successfully", response=Void.class), @ApiResponse(code=500, message="Error creating bill", response=ErrorDetail.class)})
	public ResponseEntity<BillingDetailsResource> createBilling(@RequestBody BillingDetailsResource sentBilling) {
		try {
			BillingDetails createdBilling = billingService.save(sentBilling.toBilling());
			BillingDetailsResource res = new BillingDetailsResourceAsm().toResource(createdBilling);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<BillingDetailsResource>(res, headers, HttpStatus.CREATED);
		} catch(EntityExistsException ex) {
			throw new ConflictException("Billing has already been initiated");
		}
	}
	
	//@PreAuthorize("hasRole('MANAGER') or hasRole('ACCOUNTANT')")
	@ApiOperation(value="Updates a bill", response=User.class)
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/billing/details/{id}"}, 
	method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value={@ApiResponse(code=200, message="Billing updated successfully", response=Void.class), @ApiResponse(code=404, message="Unable to find bill", response=ErrorDetail.class)})
	public ResponseEntity<BillingDetails> updateBilling(@PathVariable Long id, @RequestBody BillingDetails updatedBilling) throws MessagingException {
		logger.info("Updating bill with ID " + updatedBilling.getId());
		try {
			updatedBilling = billingService.findById(id);
			if (updatedBilling != null) {
				billingService.update(updatedBilling);
				this.emailService.sendUpdateAdminBillingEmail(updatedBilling.getUserId().getPrimaryEmail(), updatedBilling);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch(EntityDoesNotExistException e) {
			throw new ResourceNotFoundException("Bill does not exist");
		}
	}
}
