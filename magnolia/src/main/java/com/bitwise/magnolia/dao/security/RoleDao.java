package com.bitwise.magnolia.dao.security;
/**
 *  
 * @author Sika Kay
 * @date 01/03/17
 *
 */
import java.util.List;

/**
 *  
 * @author Sika Kay
 * @date 01/03/17
 *
 */
import com.bitwise.magnolia.common.BaseDao;
import com.bitwise.magnolia.model.security.Role;

public interface RoleDao extends BaseDao<Object> {

	public Role findById(Long id);
	
	public Role findByRoleName(String role);
	
	public List<Role> findAllRoles();
	
	public Role save(Role role);
}
