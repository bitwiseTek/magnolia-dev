package com.bitwise.magnolia.web.restful.resource.asm.common;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 *
 */
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.model.common.LGA;
import com.bitwise.magnolia.web.restful.controller.common.LGAController;
import com.bitwise.magnolia.web.restful.resource.common.LGAResource;

public class LGAResourceAsm extends ResourceAssemblerSupport<LGA, LGAResource> {

	public LGAResourceAsm() {
		super(LGAController.class, LGAResource.class);
	}
	@Override
	public LGAResource toResource(LGA lga) {
		LGAResource res = new LGAResource();
		res.setRid(lga.getId());
		res.setName(lga.getName());
		res.setStateCode(lga.getStateCode().getName());
		res.add(linkTo(methodOn(LGAController.class).findLga(lga.getId())).withSelfRel());
		return res;
	}

}
