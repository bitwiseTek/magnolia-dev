package com.bitwise.magnolia.util.converter;
/**
 *  
 * @author Sika Kay
 * @date 31/03/17
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.bitwise.magnolia.model.security.Permission;
import com.bitwise.magnolia.service.security.PermissionService;

@Component
public class PermissionConverter implements Converter<Object, Permission>{

	@Autowired
	private PermissionService permissionService;
	
	@Override
	public Permission convert(Object element) {
		Long id = Long.parseLong((String) element);
		Permission permission = permissionService.findById(id);
		System.err.println("Permission: " + permission);
		return permission;
	}

}
