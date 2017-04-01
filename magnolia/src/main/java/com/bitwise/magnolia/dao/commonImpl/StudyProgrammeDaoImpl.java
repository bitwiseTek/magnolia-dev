
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
import com.bitwise.magnolia.dao.common.StudyProgrammeDao;
import com.bitwise.magnolia.model.common.StudyProgramme;

@Repository("programmeDao")
public class StudyProgrammeDaoImpl extends AbstractDao<Long, StudyProgramme> implements StudyProgrammeDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public StudyProgramme findById(Long id) {
		return this.em.createNamedQuery("StudyProgramme.findById", StudyProgramme.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public StudyProgramme findByName(String name) {
		TypedQuery<StudyProgramme> query = em.createNamedQuery("StudyProgramme.findByName", StudyProgramme.class).setParameter("name", name);
		List<StudyProgramme> programmes = query.getResultList();
		return programmes.size() == 1 ? programmes.get(0) : null;
	}

	@Override
	public StudyProgramme findByCode(String code) {
		TypedQuery<StudyProgramme> query = em.createNamedQuery("StudyProgramme.findByCode", StudyProgramme.class).setParameter("code", code);
		List<StudyProgramme> programmes = query.getResultList();
		return programmes.size() == 1 ? programmes.get(0) : null;
	}

	@Override
	public List<StudyProgramme> findProgrammesByDepartmentId(Long deptId) {
		TypedQuery<StudyProgramme> query = em.createNamedQuery("StudyProgramme.findByDepartmentId", StudyProgramme.class).setParameter("deptId", deptId);
		List<StudyProgramme> programmes = query.getResultList();
		return programmes;
	}

	@Override
	@Transactional
	public StudyProgramme save(StudyProgramme programme) {
		return this.em.merge(programme);
	}

	@Override
	public List<StudyProgramme> findAllProgrammes() {
		return this.em.createNamedQuery("StudyProgramme.findAll", StudyProgramme.class).getResultList();
	}

	@Override
	public List<StudyProgramme> findByCategoryId(Long categoryId) {
		TypedQuery<StudyProgramme> query = em.createNamedQuery("StudyProgramme.findByCategoryId", StudyProgramme.class).setParameter("categoryId", categoryId);
		List<StudyProgramme> programmes = query.getResultList();
		return programmes;
	}

}
