package com.bitwise.magnolia.web.restful.resource.asm.common;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 *
 */
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.bitwise.magnolia.model.common.State;
import com.bitwise.magnolia.web.controller.common.StateController;
import com.bitwise.magnolia.web.restful.resource.common.StateResource;

public class StateResourceAsm extends ResourceAssemblerSupport<State, StateResource> {

	public StateResourceAsm() {
		super(StateController.class, StateResource.class);
	}
	
	@Override
	public StateResource toResource(State state) {
		StateResource res = new StateResource();
		res.setRid(state.getId());
		res.setName(state.getName());
		res.add(linkTo(methodOn(StateController.class).findState(state.getId())).withSelfRel());
		return res;
	}

}
