package com.bitwise.magnolia.dao.studentImpl;
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
import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.dao.student.StudentCourseDao;
import com.bitwise.magnolia.model.student.StudentCourse;

@Repository("studentCourseDao")
public class StudentCourseDaoImpl extends AbstractDao<Object> implements StudentCourseDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public StudentCourse findById(Long id) {
		return this.em.createNamedQuery("StudentCourse.findById", StudentCourse.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public List<StudentCourse> findAllRegisteredCoursesOne(Long semesterId, Boolean toggle) {
		TypedQuery<StudentCourse> query = em.createNamedQuery("StudentCourse.findAllRegisterdOne", StudentCourse.class).setParameter("semesterId", semesterId).setParameter("toggle", Boolean.TRUE);
		List<StudentCourse> studentCourses = query.getResultList();
		return studentCourses;
	}

	@Override
	public List<StudentCourse> findAllRegisteredCoursesTwo(Long semesterId, Boolean toggle) {
		TypedQuery<StudentCourse> query = em.createNamedQuery("StudentCourse.findAllRegisterdTwo", StudentCourse.class).setParameter("semesterId", semesterId).setParameter("toggle", Boolean.TRUE);
		List<StudentCourse> studentCourses = query.getResultList();
		return studentCourses;
	}

	@Override
	public List<StudentCourse> findAllPendingCoursesOne(Long semesterId, String status) {
		TypedQuery<StudentCourse> query = em.createNamedQuery("StudentCourse.findAllPendingOne", StudentCourse.class).setParameter("semesterId", semesterId).setParameter("status", ApplicationConstant.PENDING_STATUS);
		List<StudentCourse> studentCourses = query.getResultList();
		return studentCourses;
	}

	@Override
	public List<StudentCourse> findAllPendingCoursesTwo(Long semesterId, String status) {
		TypedQuery<StudentCourse> query = em.createNamedQuery("StudentCourse.findAllPendingTwo", StudentCourse.class).setParameter("semesterId", semesterId).setParameter("status", ApplicationConstant.PENDING_STATUS);
		List<StudentCourse> studentCourses = query.getResultList();
		return studentCourses;
	}

	@Override
	public List<StudentCourse> findAllCompletedCoursesOne(Long semesterId, String status) {
		TypedQuery<StudentCourse> query = em.createNamedQuery("StudentCourse.findAllCompletedOne", StudentCourse.class).setParameter("semesterId", semesterId).setParameter("status", ApplicationConstant.COMPLETED_STATUS);
		List<StudentCourse> studentCourses = query.getResultList();
		return studentCourses;
	}

	@Override
	public List<StudentCourse> findAllCompletedCoursesTwo(Long semesterId, String status) {
		TypedQuery<StudentCourse> query = em.createNamedQuery("StudentCourse.findAllCompletedTwo", StudentCourse.class).setParameter("semesterId", semesterId).setParameter("status", ApplicationConstant.COMPLETED_STATUS);
		List<StudentCourse> studentCourses = query.getResultList();
		return studentCourses;
	}

	@Override
	public List<StudentCourse> findAllCoursesOne(Long semesterId) {
		TypedQuery<StudentCourse> query = em.createNamedQuery("StudentCourse.findAllOne", StudentCourse.class).setParameter("semesterId", semesterId);
		List<StudentCourse> studentCourses = query.getResultList();
		return studentCourses;
	}

	@Override
	public List<StudentCourse> findAllCoursesTwo(Long semesterId) {
		TypedQuery<StudentCourse> query = em.createNamedQuery("StudentCourse.findAllTwo", StudentCourse.class).setParameter("semesterId", semesterId);
		List<StudentCourse> studentCourses = query.getResultList();
		return studentCourses;
	}

	@Override
	public List<StudentCourse> findAllCourses() {
		return this.em.createNamedQuery("StudentCourse.findAll", StudentCourse.class).getResultList();
	}

	@Override
	@Transactional
	public StudentCourse save(StudentCourse sc) {
		return this.em.merge(sc);
	}

}
