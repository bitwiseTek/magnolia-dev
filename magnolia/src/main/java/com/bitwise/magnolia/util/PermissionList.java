package com.bitwise.magnolia.util;
/**
 *  
 * @author Sika Kay
 * @date 01/03/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import com.bitwise.magnolia.model.security.Permission;

public class PermissionList {

	public PermissionList(List<Permission> permissions) {
		this.permissions = permissions;
	}
	
	private List<Permission> permissions = new ArrayList<Permission>();

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
}
