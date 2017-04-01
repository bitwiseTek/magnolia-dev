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

import com.bitwise.magnolia.model.security.Role;
import com.bitwise.magnolia.service.security.RoleService;

@Component
public class RoleConverter implements Converter<Object, Role> 	{

	@Autowired
	private RoleService roleService;
	
	@Override
	public Role convert(Object element) {
		Long id = Long.parseLong((String) element);
		Role role = roleService.findById(id);
		System.err.println("Role: " + role);
		return role;
	}

}
