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

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import com.bitwise.magnolia.common.AbstractDao;
import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.dao.student.StudentCourseDao;
import com.bitwise.magnolia.model.student.StudentCourse;

@Repository("studentCourseDao")
public class StudentCourseDaoImpl extends AbstractDao<Long, StudentCourse> implements StudentCourseDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public StudentCourse findById(Long id) {
		TypedQuery<StudentCourse> query = em.createNamedQuery("StudentCourse.findById", StudentCourse.class)
				.setParameter("id", id);
		List<StudentCourse> scourses = query.getResultList();
		StudentCourse scourse = scourses.size() == 1 ? scourses.get(0) : null;
		if (scourse != null) {
			Hibernate.initialize(scourse.getStudents());
		}
		return scourse;
	}
	
	@Override
	public StudentCourse findByBillingIdAndCourseId(Long billingId, Long courseId) {
		TypedQuery<StudentCourse> query = em.createNamedQuery("StudentCourse.findByBillingIdAndCourseId", StudentCourse.class)
				.setParameter("billingId", billingId)
				.setParameter("courseId", courseId);
		List<StudentCourse> scourses = query.getResultList();
		return scourses.size() == 1 ? scourses.get(0) : null;
	}

	@Override
	public List<StudentCourse> findAllRegisteredCoursesOne(Long semesterId, Boolean toggle) {
		TypedQuery<StudentCourse> query = em.createNamedQuery("StudentCourse.findAllRegisteredOne", StudentCourse.class).setParameter("semesterId", semesterId).setParameter("toggle", Boolean.TRUE);
		List<StudentCourse> studentCourses = query.getResultList();
		return studentCourses;
	}

	@Override
	public List<StudentCourse> findAllRegisteredCoursesTwo(Long semesterId, Boolean toggle) {
		TypedQuery<StudentCourse> query = em.createNamedQuery("StudentCourse.findAllRegisteredTwo", StudentCourse.class).setParameter("semesterId", semesterId).setParameter("toggle", Boolean.TRUE);
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
		persist(sc);
		return sc;
	}

	@Override
	@Transactional
	public StudentCourse update(StudentCourse sc) {
		merge(sc);
		return sc;
	}
}
