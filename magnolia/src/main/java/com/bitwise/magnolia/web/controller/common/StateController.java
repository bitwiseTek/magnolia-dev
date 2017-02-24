package com.bitwise.magnolia.web.controller.common;
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
import com.bitwise.magnolia.model.common.State;
import com.bitwise.magnolia.service.common.StateService;
import com.bitwise.magnolia.util.StateList;
import com.bitwise.magnolia.web.restful.resource.asm.common.StateListResourceAsm;
import com.bitwise.magnolia.web.restful.resource.asm.common.StateResourceAsm;
import com.bitwise.magnolia.web.restful.resource.common.StateListResource;
import com.bitwise.magnolia.web.restful.resource.common.StateResource;

@RestController
public class StateController {

	final Logger logger = LoggerFactory.getLogger(StateController.class);
	
	@Autowired
	private StateService stateService;
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/states/"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StateListResource> findAllStates(@RequestParam(value="name", required=false) String name) {
		StateList stateList = null;
		if (name == null) {
			stateList = stateService.findAllStates();
		} else {
			State state = stateService.findByName(name);
			stateList = new StateList(new ArrayList<State>());
			if (state != null) {
				stateList = new StateList(Arrays.asList(state));
			}
		}
		StateListResource res = new StateListResourceAsm().toResource(stateList);
		return new ResponseEntity<StateListResource>(res, HttpStatus.OK);
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/states/{id}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StateResource> findState(@PathVariable Long id) {
		State state = stateService.findById(id);
		if (state != null) {
			StateResource res = new StateResourceAsm().toResource(state);
			return new ResponseEntity<StateResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<StateResource>(HttpStatus.NOT_FOUND);
		}
	}
}
