package com.bitwise.magnolia.dao.commonImpl;
/**
 *  
 * @author Sika Kay
 * @date 26/02/17
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.bitwise.magnolia.common.AbstractDao;
import com.bitwise.magnolia.dao.common.AcademicSemesterDao;
import com.bitwise.magnolia.model.common.AcademicSemester;

@Repository("semesterDao")
public class AcademicSemesterDaoImpl extends AbstractDao<Object> implements AcademicSemesterDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public AcademicSemester findById(Long id) {
		return this.em.createNamedQuery("AcademicSemester.findById", AcademicSemester.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public List<AcademicSemester> findAll() {
		return this.em.createNamedQuery("AcademicSemester.findAll", AcademicSemester.class).getResultList();
	}

	@Override
	@Transactional
	public AcademicSemester save(AcademicSemester semester) {
		return this.em.merge(semester);
	}

	@Override
	public AcademicSemester findByName(String name) {
		TypedQuery<AcademicSemester> query = em.createNamedQuery("AcademicSemester.findByName", AcademicSemester.class).setParameter("name", name);
		List<AcademicSemester> semesters = query.getResultList();
		return semesters.size() == 1 ? semesters.get(0) : null;
	}

}
