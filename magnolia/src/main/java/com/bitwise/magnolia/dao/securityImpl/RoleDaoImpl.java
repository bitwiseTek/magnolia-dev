package com.bitwise.magnolia.dao.securityImpl;
/**
 *  
 * @author Sika Kay
 * @date 01/03/17
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.magnolia.common.AbstractDao;
import com.bitwise.magnolia.dao.security.RoleDao;
import com.bitwise.magnolia.model.security.Role;

@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Long, Role> implements RoleDao {

	final Logger logger = LoggerFactory.getLogger(RoleDaoImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Role findById(Long id) {
		Role role = getByKey(id);
		if (role != null) {
			Hibernate.initialize(role.getPermissions());
		}
		return role;
	}

	@Override
	public Role findByRoleName(String role) {
		TypedQuery<Role> query = em.createNamedQuery("Role.findByName", Role.class).setParameter("role", role);
		List<Role> roles = query.getResultList();
		Role userRole = roles.size() == 1 ? roles.get(0) : null;
		if (userRole != null) {
			Hibernate.initialize(userRole.getPermissions());
		}
		return userRole;
	}

	@Override
	public List<Role> findAllRoles() {
		return this.em.createNamedQuery("Role.findAll", Role.class).getResultList();
	}

	@Override
	@Transactional
	public Role save(Role role) {
		logger.info("Adding/Updating role with ID " + role.getId());
		persist(role);
		return role;
	}
}
