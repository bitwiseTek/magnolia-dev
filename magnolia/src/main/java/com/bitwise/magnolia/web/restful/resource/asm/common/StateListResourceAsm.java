package com.bitwise.magnolia.web.restful.resource.asm.common;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 *
 */
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.util.StateList;
import com.bitwise.magnolia.web.controller.common.StateController;
import com.bitwise.magnolia.web.restful.resource.common.StateListResource;
import com.bitwise.magnolia.web.restful.resource.common.StateResource;

public class StateListResourceAsm extends ResourceAssemblerSupport<StateList, StateListResource> {

	public StateListResourceAsm() {
		super(StateController.class, StateListResource.class);
	}
	
	@Override
	public StateListResource toResource(StateList stateList) {
		List<StateResource> resList = new StateResourceAsm().toResources(stateList.getStates());
		StateListResource finalRes = new StateListResource();
		finalRes.setStates(resList);
		return finalRes;
	}

}
