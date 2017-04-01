package com.bitwise.magnolia.service.security;
import java.util.List;

/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import com.bitwise.magnolia.model.security.Role;
import com.bitwise.magnolia.util.RoleList;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
public interface RoleService {

	public Role findById(Long id);
	
	public Role findByRoleName(String role);
	
	public RoleList findAllRoles();
	
	public List<Role> findAll();
	
	public Role save(Role data);
	
	public Role update(Role data);
}
