package com.bitwise.magnolia.service.securityImpl;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.magnolia.dao.security.PermissionDao;
import com.bitwise.magnolia.model.security.Permission;
import com.bitwise.magnolia.service.security.PermissionService;
import com.bitwise.magnolia.util.PermissionList;

@Transactional
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

	final Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);
	
	@Autowired
	private PermissionDao permissionDao;

	@Override
	@Transactional(readOnly=true)
	public Permission findById(Long id) {
		return this.permissionDao.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Permission findByPermissionName(String permission) {
		return this.permissionDao.findByPermissionName(permission);
	}

	@Override
	@Transactional(readOnly=true)
	public PermissionList findAllPermissions() {
		return new PermissionList(this.permissionDao.findAllPermissions());
	}

	@Override
	@Transactional(readOnly=false)
	public Permission save(Permission permission) {
		logger.info("Adding permission with ID " + permission.getId());
		return this.permissionDao.save(permission);
	}
	
}
