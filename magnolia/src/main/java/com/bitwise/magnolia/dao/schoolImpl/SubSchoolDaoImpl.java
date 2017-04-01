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
import com.bitwise.magnolia.dao.school.SubSchoolDao;
import com.bitwise.magnolia.model.school.SubSchool;

@Repository("subSchoolDao")
public class SubSchoolDaoImpl extends AbstractDao<Long, SubSchool> implements SubSchoolDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public SubSchool findById(Long id) {
		return this.em.createNamedQuery("SubSchool.findById", SubSchool.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public SubSchool findByName(String name) {
		TypedQuery<SubSchool> query = em.createNamedQuery("SubSchool.findByName", SubSchool.class).setParameter("name", name);
		List<SubSchool> subSchools = query.getResultList();
		return subSchools.size() == 1 ? subSchools.get(0) : null;
	}

	@Override
	public List<SubSchool> findSubSchoolsBySchoolId(Long schoolId) {
		TypedQuery<SubSchool> query = em.createNamedQuery("SubSchool.findBySchoolId", SubSchool.class).setParameter("schoolId", schoolId);
		List<SubSchool> subSchools = query.getResultList();
		return subSchools;
	}

	@Override
	public List<SubSchool> findAllSubSchools() {
		return this.em.createNamedQuery("SubSchool.findAll", SubSchool.class).getResultList();
	}

	@Override
	@Transactional
	public SubSchool save(SubSchool school) {
		return this.em.merge(school);
	}

}
