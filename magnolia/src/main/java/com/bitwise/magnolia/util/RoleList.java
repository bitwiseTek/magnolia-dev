package com.bitwise.magnolia.util;
/**
 *  
 * @author Sika Kay
 * @date 01/03/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import com.bitwise.magnolia.model.security.Role;

public class RoleList {

	public RoleList(List<Role> roles) {
		this.roles = roles;
	}
	
	private List<Role> roles = new ArrayList<Role>();

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
