package com.bitwise.magnolia.service.security;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import com.bitwise.magnolia.model.security.Permission;
import com.bitwise.magnolia.util.PermissionList;

public interface PermissionService {

	public Permission findById(Long id);
	
	public Permission findByPermissionName(String permission);
	
	public PermissionList findAllPermissions();
	
	public Permission save(Permission permission);
}
