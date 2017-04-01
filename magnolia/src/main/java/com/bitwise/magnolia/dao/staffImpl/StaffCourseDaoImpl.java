package com.bitwise.magnolia.dao.staffImpl;
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
import com.bitwise.magnolia.dao.staff.StaffCourseDao;
import com.bitwise.magnolia.model.staff.StaffCourse;

@Repository("staffCourseDao")
public class StaffCourseDaoImpl extends AbstractDao<Long, StaffCourse> implements StaffCourseDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public StaffCourse findById(Long id) {
		return this.em.createNamedQuery("StaffCourse.findById", StaffCourse.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public List<StaffCourse> findAllAttachedCoursesOne(Long semesterId, Boolean toggle) {
		TypedQuery<StaffCourse> query = em.createNamedQuery("StaffCourse.findAllAttachedOne", StaffCourse.class).setParameter("semesterId", semesterId).setParameter("toggle", Boolean.TRUE);
		List<StaffCourse> staffCourses = query.getResultList();
		return staffCourses;
	}

	@Override
	public List<StaffCourse> findAllAttachedCoursesTwo(Long semesterId, Boolean toggle) {
		TypedQuery<StaffCourse> query = em.createNamedQuery("StaffCourse.findAllAttachedTwo", StaffCourse.class).setParameter("semesterId", semesterId).setParameter("toggle", Boolean.TRUE);
		List<StaffCourse> staffCourses = query.getResultList();
		return staffCourses;
	}

	@Override
	public List<StaffCourse> findAllPendingCoursesOne(Long semesterId, String status) {
		TypedQuery<StaffCourse> query = em.createNamedQuery("StaffCourse.findAllPendingOne", StaffCourse.class).setParameter("semesterId", semesterId).setParameter("status", ApplicationConstant.PENDING_STATUS);
		List<StaffCourse> staffCourses = query.getResultList();
		return staffCourses;
	}

	@Override
	public List<StaffCourse> findAllPendingCoursesTwo(Long semesterId, String status) {
		TypedQuery<StaffCourse> query = em.createNamedQuery("StaffCourse.findAllPendingTwo", StaffCourse.class).setParameter("semesterId", semesterId).setParameter("status", ApplicationConstant.PENDING_STATUS);
		List<StaffCourse> staffCourses = query.getResultList();
		return staffCourses;
	}

	@Override
	public List<StaffCourse> findAllCompletedCoursesOne(Long semesterId, String status) {
		TypedQuery<StaffCourse> query = em.createNamedQuery("StaffCourse.findAllCompletedOne", StaffCourse.class).setParameter("semesterId", semesterId).setParameter("status", ApplicationConstant.COMPLETED_STATUS);
		List<StaffCourse> staffCourses = query.getResultList();
		return staffCourses;
	}

	@Override
	public List<StaffCourse> findAllCompletedCoursesTwo(Long semesterId, String status) {
		TypedQuery<StaffCourse> query = em.createNamedQuery("StaffCourse.findAllCompletedTwo", StaffCourse.class).setParameter("semesterId", semesterId).setParameter("status", ApplicationConstant.COMPLETED_STATUS);
		List<StaffCourse> staffCourses = query.getResultList();
		return staffCourses;
	}

	@Override
	public List<StaffCourse> findAllCoursesOne(Long semesterId) {
		TypedQuery<StaffCourse> query = em.createNamedQuery("StaffCourse.findAllOne", StaffCourse.class).setParameter("semesterId", semesterId);
		List<StaffCourse> staffCourses = query.getResultList();
		return staffCourses;
	}

	@Override
	public List<StaffCourse> findAllCoursesTwo(Long semesterId) {
		TypedQuery<StaffCourse> query = em.createNamedQuery("StaffCourse.findAllTwo", StaffCourse.class).setParameter("semesterId", semesterId);
		List<StaffCourse> staffCourses = query.getResultList();
		return staffCourses;
	}

	@Override
	public List<StaffCourse> findAllCourses() {
		TypedQuery<StaffCourse> query = em.createNamedQuery("StaffCourse.findAll", StaffCourse.class);
		List<StaffCourse> staffCourses = query.getResultList();
		return staffCourses;
	}

	@Override
	@Transactional
	public StaffCourse save(StaffCourse sc) {
		return this.em.merge(sc);
	}

}
