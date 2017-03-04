package com.bitwise.magnolia.dao.schoolImpl;
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
import com.bitwise.magnolia.dao.school.CampusDao;
import com.bitwise.magnolia.model.school.Campus;

@Repository("campusDao")
public class CampusDaoImpl extends AbstractDao<Object> implements CampusDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Campus findById(Long id) {
		return this.em.createNamedQuery("Campus.findById", Campus.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public Campus findByName(String name) {
		TypedQuery<Campus> query = em.createNamedQuery("Campus.findByName", Campus.class).setParameter("name", name);
		List<Campus> campuses = query.getResultList();
		return campuses.size() == 1 ? campuses.get(0) : null;
	}

	@Override
	public List<Campus> findAllCampuses() {
		return this.em.createNamedQuery("Campus.findAll", Campus.class).getResultList();
	}

	@Override
	public List<Campus> findCampusesBySubSchoolId(Long subSchoolId) {
		TypedQuery<Campus> query = em.createNamedQuery("Campus.findBySubSchoolId", Campus.class).setParameter("subSchoolId", subSchoolId);
		List<Campus> campuses = query.getResultList();
		return campuses;
	}

	@Override
	@Transactional
	public Campus save(Campus campus) {
		return this.em.merge(campus);
	}

}
