package com.bitwise.magnolia.dao.security;
/**
 *  
 * @author Sika Kay
 * @date 01/03/17
 *
 */
import java.util.List;

import com.bitwise.magnolia.model.security.Permission;

public interface PermissionDao {

	public Permission findById(Long id);
	
	public Permission findByPermissionName(String permission);
	
	public List<Permission> findAllPermissions();
	
	public Permission save(Permission permission);
}
