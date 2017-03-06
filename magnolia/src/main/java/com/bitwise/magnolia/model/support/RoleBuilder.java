package com.bitwise.magnolia.model.support;
/**
 *  
 * @author Sika Kay
 * @date 06/03/17
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.magnolia.model.security.Permission;
import com.bitwise.magnolia.model.security.Role;

@Component
public class RoleBuilder extends EntityBuilder<Role> {

	@Override
	void initProduct() {
		this.product = new Role();	
	}
	
	public RoleBuilder role(String role) {
		this.product.setRoles(role);
		return this;
	}
	
	public RoleBuilder roleWithPermissions(Permission permission, Role... roles) {
		this.product.getPermissions().add(permission);
		for (Role role : roles) {
			role.getPermissions().add(permission);
	}
	return this;
}

	@Override
	Role assembleProduct() {
		return this.product;
	}

}
