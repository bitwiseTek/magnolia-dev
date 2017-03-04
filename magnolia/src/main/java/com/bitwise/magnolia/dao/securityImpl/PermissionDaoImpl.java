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
import com.bitwise.magnolia.dao.security.PermissionDao;
import com.bitwise.magnolia.model.security.Permission;

@Repository("permissionDao")
public class PermissionDaoImpl extends AbstractDao<Object> implements PermissionDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Permission findById(Long id) {
		return this.em.createNamedQuery("Permission.findById", Permission.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public Permission findByPermissionName(String permission) {
		TypedQuery<Permission> query = em.createNamedQuery("Permission.findByName", Permission.class).setParameter("permission", permission);
		List<Permission> permissions = query.getResultList();
		return permissions.size() == 1 ? permissions.get(0) : null;
	}

	@Override
	public List<Permission> findAllPermissions() {
		return this.em.createNamedQuery("Permission.findAll", Permission.class).getResultList();
	}

	@Override
	@Transactional
	public Permission save(Permission permission) {
		return this.em.merge(permission);
	}

}
