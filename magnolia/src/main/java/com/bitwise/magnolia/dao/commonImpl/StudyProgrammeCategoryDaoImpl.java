package com.bitwise.magnolia.dao.commonImpl;
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
import com.bitwise.magnolia.dao.common.StudyProgrammeCategoryDao;
import com.bitwise.magnolia.model.common.StudyProgrammeCategory;

@Repository("studyProgrammeCategoryDao")
public class StudyProgrammeCategoryDaoImpl extends AbstractDao<Long, StudyProgrammeCategory> implements StudyProgrammeCategoryDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public StudyProgrammeCategory findById(Long id) {
		return this.em.createNamedQuery("StudyProgrammeCategory.findById", StudyProgrammeCategory.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public StudyProgrammeCategory findByName(String name) {
		TypedQuery<StudyProgrammeCategory> query = em.createNamedQuery("StudyProgrammeCategory.findByName", StudyProgrammeCategory.class).setParameter("name", name);
		List<StudyProgrammeCategory> categories = query.getResultList();
		return categories.size() == 1 ? categories.get(0) : null;
	}

	@Override
	public List<StudyProgrammeCategory> findAll() {
		return this.em.createNamedQuery("StudyProgrammeCategory.findAll", StudyProgrammeCategory.class).getResultList();
	}

	@Override
	@Transactional
	public StudyProgrammeCategory save(StudyProgrammeCategory category) {
		return this.em.merge(category);
	}

}
