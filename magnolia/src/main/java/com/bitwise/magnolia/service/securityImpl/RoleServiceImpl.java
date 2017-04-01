package com.bitwise.magnolia.service.securityImpl;
import java.util.List;

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

import com.bitwise.magnolia.dao.security.RoleDao;
import com.bitwise.magnolia.exception.EntityDoesNotExistException;
import com.bitwise.magnolia.exception.EntityExistsException;
import com.bitwise.magnolia.model.security.Role;
import com.bitwise.magnolia.service.security.RoleService;
import com.bitwise.magnolia.util.RoleList;

@Transactional
@Service("roleService")
public class RoleServiceImpl implements RoleService {

	final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
	
	@Autowired
	private RoleDao roleDao;

	@Override
	@Transactional(readOnly=true)
	public Role findById(Long id) {
		return this.roleDao.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Role findByRoleName(String role) {
		return this.roleDao.findByRoleName(role);
	}

	@Override
	@Transactional(readOnly=true)
	public RoleList findAllRoles() {
		return new RoleList(this.roleDao.findAllRoles());
	}

	@Override
	@Transactional(readOnly=false)
	public Role save(Role data) {
		logger.info("Adding role with ID " + data.getId());
		Role role = roleDao.findByRoleName(data.getRoles());
		if (role != null) {
			throw new EntityExistsException("Role already exists");
		}
		return this.roleDao.save(data);
	}

	@Override
	public List<Role> findAll() {
		return this.roleDao.findAllRoles();
	}
	
	@Override
	@Transactional(readOnly=false)
	public Role update(Role data) {
		Role role = roleDao.findById(data.getId());
		try {
			if (role != null) {
				role.setRoles(data.getRoles());
				role.setPermissions(data.getPermissions());
			} else {
				throw new EntityDoesNotExistException("Role does not exist");
			}
			
		} catch(Exception e) {
			throw new EntityDoesNotExistException("Role does not exist");
		}
		return role;
	}
}
