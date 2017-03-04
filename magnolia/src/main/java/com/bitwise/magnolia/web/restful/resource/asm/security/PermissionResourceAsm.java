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

import com.bitwise.magnolia.model.security.Permission;
import com.bitwise.magnolia.web.restful.controller.security.PermissionController;
import com.bitwise.magnolia.web.restful.resource.security.PermissionResource;

public class PermissionResourceAsm extends ResourceAssemblerSupport<Permission, PermissionResource>{

	public PermissionResourceAsm() {
		super(PermissionController.class, PermissionResource.class);
	}
	
	@Override
	public PermissionResource toResource(Permission permission) {
		PermissionResource res = new PermissionResource();
		res.setRid(permission.getId());
		res.setPermission(permission.getPermissions());
		res.add(linkTo(methodOn(PermissionController.class).findPermission(permission.getId())).withSelfRel());
		return res;
	}

}
