package com.bitwise.magnolia.service.security;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import com.bitwise.magnolia.model.security.Role;
import com.bitwise.magnolia.util.RoleList;

public interface RoleService {

	public Role findById(Long id);
	
	public Role findByRoleName(String role);
	
	public RoleList findAllRoles();
	
	public Role save(Role role);
}
