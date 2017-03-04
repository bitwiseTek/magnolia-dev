package com.bitwise.magnolia.web.restful.resource.security;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import org.springframework.hateoas.ResourceSupport;

import com.bitwise.magnolia.model.security.Role;

public class RoleResource extends ResourceSupport {

	public RoleResource() {
		
	}
	
	private Long rid;
	
	private String roles;

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	public Role toRole() {
		Role role = new Role();
		role.setId(rid);
		role.setRoles(roles);
		return role;
	}
}
