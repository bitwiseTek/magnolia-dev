package com.bitwise.magnolia.model.support;
/**
 *  
 * @author Sika Kay
 * @date 06/03/17
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.magnolia.model.security.Permission;

@Component
public class PermissionBuilder extends EntityBuilder<Permission> {

	@Override
	void initProduct() {
		this.product = new Permission();
	}
	
	public PermissionBuilder permission(String permission) {
		this.product.setPermissions(permission);
		return this;
	}

	@Override
	Permission assembleProduct() {
		return this.product;
	}

}
