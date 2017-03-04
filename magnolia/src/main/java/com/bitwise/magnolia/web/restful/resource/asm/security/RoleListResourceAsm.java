package com.bitwise.magnolia.web.restful.resource.asm.security;
/**
 *  
 * @author Sika Kay
 * @date 04/03/17
 *
 */
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.util.RoleList;
import com.bitwise.magnolia.web.restful.controller.security.RoleController;
import com.bitwise.magnolia.web.restful.resource.security.RoleListResource;
import com.bitwise.magnolia.web.restful.resource.security.RoleResource;

public class RoleListResourceAsm extends ResourceAssemblerSupport<RoleList, RoleListResource> {

	public RoleListResourceAsm() {
		super(RoleController.class, RoleListResource.class);
	}
	
	@Override
	public RoleListResource toResource(RoleList roleList) {
		List<RoleResource> resList = new RoleResourceAsm().toResources(roleList.getRoles());
		RoleListResource finalRes = new RoleListResource();
		finalRes.setRoles(resList);
		return finalRes;
	}

}
