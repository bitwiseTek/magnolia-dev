package com.bitwise.magnolia.dao.schoolImpl;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 */
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.bitwise.magnolia.common.AbstractDao;
import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.dao.school.FacultyDao;
import com.bitwise.magnolia.model.school.Faculty;

@Repository("facultyDao")
public class FacultyDaoImpl extends AbstractDao<Long, Faculty> implements FacultyDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Faculty> findActiveFaculties(String schoolAlias) {
		String sql = "select f from Faculty f where f.status = :status and f.subSchool.school.alias = :alias";
		List<?> list = this.em.createQuery(sql)
											   .setParameter("status", ApplicationConstant.ACTIVE_STATUS)
											   .setParameter("alias", schoolAlias)
											   .getResultList();
		List<Faculty> facultyList = new ArrayList<Faculty>();
		for(Object object : list){
			Faculty temp = (Faculty) object;
			facultyList.add(temp);
		}
		return facultyList;
	}

	@Override
	public List<Faculty> findAllFaculties() {
		String sql = "select f from Faculty f";
		return this.em.createQuery(sql, Faculty.class).getResultList();
	}

	@Override
	public Faculty findByFacutltyId(Long id) {
		String sql = "select f from Faculty f where f.id = :id";
		return this.em.createQuery(sql, Faculty.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public Faculty findByName(String name) {
		String sql = "select f from Faculty f where f.name = :name";
		TypedQuery<Faculty> query = em.createQuery(sql, Faculty.class).setParameter("name", name);
		List<Faculty> faculties = query.getResultList();
		return faculties.size() == 1 ? faculties.get(0) : null;
	}

	@Override
	@Transactional
	public Faculty save(Faculty faculty) {
		persist(faculty);
		return faculty;
	}

	@Override
	@Transactional
	public Faculty update(Faculty faculty) {
		merge(faculty);
		return faculty;
	}
}
