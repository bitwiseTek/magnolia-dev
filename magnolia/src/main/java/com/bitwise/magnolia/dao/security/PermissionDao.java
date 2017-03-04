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
import com.bitwise.magnolia.model.security.Permission;

public interface PermissionDao extends BaseDao<Object> {

	public Permission findById(Long id);
	
	public Permission findByPermissionName(String permission);
	
	public List<Permission> findAllPermissions();
	
	public Permission save(Permission permission);
}
