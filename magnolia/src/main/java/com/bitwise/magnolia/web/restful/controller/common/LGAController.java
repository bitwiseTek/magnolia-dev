package com.bitwise.magnolia.web.restful.controller.common;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 *
 */
import java.util.ArrayList;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.model.common.LGA;
import com.bitwise.magnolia.service.common.LGAService;
import com.bitwise.magnolia.util.LGAList;
import com.bitwise.magnolia.web.restful.exception.ErrorDetail;
import com.bitwise.magnolia.web.restful.resource.asm.common.LGAListResourceAsm;
import com.bitwise.magnolia.web.restful.resource.asm.common.LGAResourceAsm;
import com.bitwise.magnolia.web.restful.resource.common.LGAListResource;
import com.bitwise.magnolia.web.restful.resource.common.LGAResource;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@RestController
@Api(value="lgas", description="LGA API")
public class LGAController {

	final Logger logger = LoggerFactory.getLogger(LGAController.class);
	
	@Autowired
	private LGAService lgaService;
	
	@ApiOperation(value="Retrieves all the lgas", response=LGA.class, responseContainer="List")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/lgas/"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LGAListResource> findAllLGAs(@RequestParam(value="name", required=false) String name) {
		LGAList lgaList = null;
		if (name == null) {
			lgaList = lgaService.findAllLGAs();
		} else {
			LGA lga = lgaService.findByName(name);
			lgaList = new LGAList(new ArrayList<LGA>());
			if (lga == null) {
				lgaList = new LGAList(Arrays.asList(lga));
			}
		}
		LGAListResource res = new LGAListResourceAsm().toResource(lgaList);
		return new ResponseEntity<LGAListResource>(res, HttpStatus.OK);
	}
	
	@ApiOperation(value="Retrieves an lga associated with an ID", response=LGA.class)
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/lgas/{id}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value={@ApiResponse(code=200, message="", response=Void.class), @ApiResponse(code=404, message="Unable to find lga", response=ErrorDetail.class)})
	public ResponseEntity<LGAResource> findLga(@PathVariable Long id) {
		LGA lga = lgaService.findById(id);
		if (lga != null) {
			LGAResource res = new LGAResourceAsm().toResource(lga);
			return new ResponseEntity<LGAResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<LGAResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Retrieves all the lgas associated with a State ID", response=LGA.class, responseContainer="List")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/lgas/states/{stateId}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LGAListResource> findAllLGAsByStates(@PathVariable Long stateId) {
		LGAList lgaList = null;
		lgaList = lgaService.findLGAsByStateId(stateId);
		if (lgaList != null) {
			LGAListResource resList = new LGAListResourceAsm().toResource(lgaList);
			return new ResponseEntity<LGAListResource>(resList, HttpStatus.OK);
		} else {
			return new ResponseEntity<LGAListResource>(HttpStatus.NOT_FOUND);
		}
	}
}
