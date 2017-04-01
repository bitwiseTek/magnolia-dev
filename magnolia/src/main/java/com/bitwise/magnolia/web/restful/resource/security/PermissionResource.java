package com.bitwise.magnolia.web.restful.resource.security;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import org.springframework.hateoas.ResourceSupport;

import com.bitwise.magnolia.model.security.Permission;

public class PermissionResource extends ResourceSupport {

	public PermissionResource() {
		
	}
	
	private Long rid;
	
	private String permissions;

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	
	public Permission toPermission() {
		Permission permission = new Permission();
		permission.setId(rid);
		permission.setPermissions(permissions);
		return permission;
	}
}
