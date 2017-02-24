package com.bitwise.magnolia.web.restful.resource.asm.common;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 *
 */
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.util.LGAList;
import com.bitwise.magnolia.web.controller.common.LGAController;
import com.bitwise.magnolia.web.restful.resource.common.LGAListResource;
import com.bitwise.magnolia.web.restful.resource.common.LGAResource;

public class LGAListResourceAsm extends ResourceAssemblerSupport<LGAList, LGAListResource> {

	public LGAListResourceAsm() {
		super(LGAController.class, LGAListResource.class);
	}
	@Override
	public LGAListResource toResource(LGAList lgaList) {
		List<LGAResource> resList = new LGAResourceAsm().toResources(lgaList.getLgas());
		LGAListResource finalRes = new LGAListResource();
		finalRes.setLgas(resList);
		return finalRes;
	}

}
