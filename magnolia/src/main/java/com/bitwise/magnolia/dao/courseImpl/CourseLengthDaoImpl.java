package com.bitwise.magnolia.dao.courseImpl;
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
import com.bitwise.magnolia.dao.course.CourseLengthDao;
import com.bitwise.magnolia.model.course.CourseLength;

@Repository("courseLengthDao")
public class CourseLengthDaoImpl extends AbstractDao<Long, CourseLength> implements CourseLengthDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public CourseLength findById(Long id) {
		return this.em.createNamedQuery("CourseLength.findById", CourseLength.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public CourseLength findByName(String name) {
		TypedQuery<CourseLength> query = em.createNamedQuery("CourseLength.findByName", CourseLength.class).setParameter("name", name);
		List<CourseLength> lengths = query.getResultList();
		return lengths.size() == 1 ? lengths.get(0) : null;
	}

	@Override
	public List<CourseLength> findAllCourseLengths() {
		return this.em.createNamedQuery("CourseLength.findAll", CourseLength.class).getResultList();
	}

	@Override
	@Transactional
	public CourseLength save(CourseLength length) {
		return this.em.merge(length);
	}

}
