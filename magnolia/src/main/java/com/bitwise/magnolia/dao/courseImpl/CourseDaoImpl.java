package com.bitwise.magnolia.dao.courseImpl;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.bitwise.magnolia.common.AbstractDao;
import com.bitwise.magnolia.dao.course.CourseDao;
import com.bitwise.magnolia.model.course.Course;

@Repository("courseDao")
public class CourseDaoImpl extends AbstractDao<Object> implements CourseDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Course findById(Long id) {
		return this.em.createNamedQuery("Course.findById", Course.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public Course findByName(String name) {
		TypedQuery<Course> query = em.createNamedQuery("Course.findByName", Course.class).setParameter("name", name);
		List<Course> courses = query.getResultList();
		return courses.size() == 1 ? courses.get(0) : null;
	}

	@Override
	public Course findByCode(String code) {
		TypedQuery<Course> query = em.createNamedQuery("Course.findByCode", Course.class).setParameter("code", code);
		List<Course> courses = query.getResultList();
		return courses.size() == 1 ? courses.get(0) : null;
	}

	@Override
	public List<Course> findCoursesByStaffId(Long staffId) {
		TypedQuery<Course> query = em.createNamedQuery("Course.findByStaffId", Course.class).setParameter("staffId", staffId);
		List<Course> courses = query.getResultList();
		return courses;
	}

	@Override
	public List<Course> findCoursesByProgrammeId(Long programmeId) {
		TypedQuery<Course> query = em.createNamedQuery("Course.findByProgrammeId", Course.class).setParameter("programmeId", programmeId);
		List<Course> courses = query.getResultList();
		return courses;
	}

	@Override
	public List<Course> findAllCourses() {
		return this.em.createNamedQuery("Course.findAll", Course.class).getResultList();
	}

	@Override
	@Transactional
	public Course save(Course course) {
		return this.em.merge(course);
	}

}
