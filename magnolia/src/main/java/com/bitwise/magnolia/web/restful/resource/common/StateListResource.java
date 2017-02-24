package com.bitwise.magnolia.web.restful.resource.common;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class StateListResource extends ResourceSupport {

	private List<StateResource> states = new ArrayList<StateResource>();

	public List<StateResource> getStates() {
		return states;
	}

	public void setStates(List<StateResource> states) {
		this.states = states;
	}
}
