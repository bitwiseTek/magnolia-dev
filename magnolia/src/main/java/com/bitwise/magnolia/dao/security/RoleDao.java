package com.bitwise.magnolia.dao.security;
/**
 *  
 * @author Sika Kay
 * @date 01/03/17
 *
 */
import java.util.List;

import com.bitwise.magnolia.model.security.Role;

public interface RoleDao {

	public Role findById(Long id);
	
	public Role findByRoleName(String role);
	
	public Role save(Role role);
	
	public List<Role> findAllRoles();
}
