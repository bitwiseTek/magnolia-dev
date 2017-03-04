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

import com.bitwise.magnolia.dao.security.RoleDao;
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
	public Role save(Role role) {
		logger.info("Adding role with ID " + role.getId());
		return this.roleDao.save(role);
	}
	
}
