package com.bitwise.magnolia.dao.schoolImpl;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import com.bitwise.magnolia.common.AbstractDao;
import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.dao.school.SchoolDao;
import com.bitwise.magnolia.model.school.School;

@Repository("schoolDao")
public class SchoolDaoImpl extends AbstractDao<Long, School> implements SchoolDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean isSchoolExist(String alias) {
		String sql = "select s from School s where s.alias = :alias and s.status = :status";
		School school = (School) this.em.createQuery(sql)
														 .setParameter("alias", alias)
														 .setParameter("status", ApplicationConstant.ACTIVE_STATUS)
														 .getSingleResult();
		if(school != null){
			return true;
		}
		return false;
	}

	@Override
	public School findSchoolByAlias(String alias) {
		String sql = "select s from School s where s.alias = :alias and s.status = :status";
		TypedQuery<School> query = em.createQuery(sql, School.class)
														 .setParameter("alias", alias)
														 .setParameter("status", ApplicationConstant.ACTIVE_STATUS);
		List<School> schools = query.getResultList();
		School school = schools.size() == 1 ? schools.get(0) : null;
		if (school != null) {
			Hibernate.initialize(school.getSubSchoolList());
		}
		return school;
	}

	@Override
	public boolean isApiKeyExist(String apiKey) {
		String sql = "select s from School s where s.status = :status and s.apiKey = :apiKey";
		return ((School) this.em.createQuery(sql)
												.setParameter("status", ApplicationConstant.ACTIVE_STATUS)
												.setParameter("apiKey", apiKey)
												.getSingleResult()) == null ? false : true;
	}

	@Override
	public School findById(Long id) {
		return this.em.createNamedQuery("School.findById", School.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public School findByName(String name) {
		TypedQuery<School> query = em.createNamedQuery("School.findByName", School.class).setParameter("name", name);
		List<School> schools = query.getResultList();
		return schools.size() == 1 ? schools.get(0) : null;
	}

	@Override
	public List<School> findAllSchools() {
		return this.em.createNamedQuery("School.findAll", School.class).getResultList();
	}

	@Override
	@Transactional
	public School save(School school) {
		return this.em.merge(school);
	}

}
