package com.bitwise.magnolia.web.restful.resource.common;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 *
 */
import org.springframework.hateoas.ResourceSupport;

import com.bitwise.magnolia.model.common.LGA;
import com.bitwise.magnolia.model.common.State;

public class LGAResource extends ResourceSupport {

	public LGAResource() {
		
	}
	
	private Long rid;
	
	private String name;
	
	private String stateCode;

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

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	
	public LGA toLGA() {
		LGA lga = new LGA();
		lga.setId(rid);
		lga.setName(name);
		lga.setStateCode(new State(Long.parseLong(stateCode)));
		return lga;
	}
}
