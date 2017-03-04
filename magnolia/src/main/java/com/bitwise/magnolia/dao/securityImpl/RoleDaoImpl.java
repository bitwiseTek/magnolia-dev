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

import org.springframework.stereotype.Repository;

import com.bitwise.magnolia.common.AbstractDao;
import com.bitwise.magnolia.dao.security.RoleDao;
import com.bitwise.magnolia.model.security.Role;

@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Object> implements RoleDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Role findById(Long id) {
		return this.em.createNamedQuery("Role.findById", Role.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public Role findByRoleName(String role) {
		TypedQuery<Role> query = em.createNamedQuery("Role.findByName", Role.class).setParameter("role", role);
		List<Role> roles = query.getResultList();
		return roles.size() == 1 ? roles.get(0) : null;
	}

	@Override
	public List<Role> findAllRoles() {
		return this.em.createNamedQuery("Role.findAll", Role.class).getResultList();
	}

	@Override
	@Transactional
	public Role save(Role role) {
		return this.em.merge(role);
	}

}
