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

public class RoleListResource extends ResourceSupport {

	private List<RoleResource> roles = new ArrayList<RoleResource>();

	public List<RoleResource> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleResource> roles) {
		this.roles = roles;
	}
}
