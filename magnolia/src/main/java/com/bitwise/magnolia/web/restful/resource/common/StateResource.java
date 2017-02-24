package com.bitwise.magnolia.web.restful.resource.common;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 *
 */
import org.springframework.hateoas.ResourceSupport;

import com.bitwise.magnolia.model.common.State;

public class StateResource extends ResourceSupport {

	public StateResource() {
		
	}
	
	private Long rid;
	
	private String name;

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public State toState() {
		State state = new State();
		state.setId(rid);
		state.setName(name);
		return state;
	}
}
