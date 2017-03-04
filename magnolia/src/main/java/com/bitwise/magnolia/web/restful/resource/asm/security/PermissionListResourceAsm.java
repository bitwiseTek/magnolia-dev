package com.bitwise.magnolia.web.restful.resource.asm.security;
/**
 *  
 * @author Sika Kay
 * @date 04/03/17
 *
 */
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.util.PermissionList;
import com.bitwise.magnolia.web.restful.controller.security.PermissionController;
import com.bitwise.magnolia.web.restful.resource.security.PermissionListResource;
import com.bitwise.magnolia.web.restful.resource.security.PermissionResource;

public class PermissionListResourceAsm extends ResourceAssemblerSupport<PermissionList, PermissionListResource> {

	public PermissionListResourceAsm() {
		super(PermissionController.class, PermissionListResource.class);
	}
	
	@Override
	public PermissionListResource toResource(PermissionList permissionList) {
		List<PermissionResource> resList = new PermissionResourceAsm().toResources(permissionList.getPermissions());
		PermissionListResource finalRes = new PermissionListResource();
		finalRes.setPermissions(resList);
		return finalRes;
	}

}
