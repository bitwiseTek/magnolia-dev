package com.bitwise.magnolia.service.security;
import java.util.List;

/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import com.bitwise.magnolia.model.security.Permission;
import com.bitwise.magnolia.util.PermissionList;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
public interface PermissionService {

	public Permission findById(Long id);
	
	public Permission findByPermissionName(String permission);
	
	public PermissionList findAllPermissions();
	
	public List<Permission> findAll();
	
	public Permission save(Permission data);
	
	public Permission update(Permission data);
}
