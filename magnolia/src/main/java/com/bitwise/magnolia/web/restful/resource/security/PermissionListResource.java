package com.bitwise.magnolia.web.restful.resource.security;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class PermissionListResource extends ResourceSupport {

	private List<PermissionResource> permissions = new ArrayList<PermissionResource>();

	public List<PermissionResource> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<PermissionResource> permissions) {
		this.permissions = permissions;
	}
}
