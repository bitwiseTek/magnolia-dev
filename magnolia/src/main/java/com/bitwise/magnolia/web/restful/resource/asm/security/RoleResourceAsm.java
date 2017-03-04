package com.bitwise.magnolia.web.restful.resource.asm.security;
/**
 *  
 * @author Sika Kay
 * @date 04/03/17
 *
 */
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.model.security.Role;
import com.bitwise.magnolia.web.restful.controller.security.RoleController;
import com.bitwise.magnolia.web.restful.resource.security.RoleResource;

public class RoleResourceAsm extends ResourceAssemblerSupport<Role, RoleResource>{

	public RoleResourceAsm() {
		super(RoleController.class, RoleResource.class);
	}
	
	@Override
	public RoleResource toResource(Role role) {
		RoleResource res = new RoleResource();
		res.setRid(role.getId());
		res.setRoles(role.getRoles());
		res.add(linkTo(methodOn(RoleController.class).findRole(role.getId())).withSelfRel());
		return res;
	}

}
