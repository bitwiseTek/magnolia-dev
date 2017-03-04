package com.bitwise.magnolia.service.commonImpl;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.magnolia.dao.common.StudyProgrammeCategoryDao;
import com.bitwise.magnolia.model.common.StudyProgrammeCategory;
import com.bitwise.magnolia.service.common.StudyProgrammeCategoryService;
import com.bitwise.magnolia.util.ProgrammeCategoryList;

@Transactional
@Service("programmeCategoryService")
public class StudyProgrammeCategoryServiceImpl implements StudyProgrammeCategoryService {

	final Logger logger = LoggerFactory.getLogger(StudyProgrammeCategoryServiceImpl.class);
	
	@Autowired
	private StudyProgrammeCategoryDao categoryDao;
	
	@Override
	@Transactional(readOnly=true)
	public StudyProgrammeCategory findById(Long id) {
		return this.categoryDao.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public StudyProgrammeCategory findByName(String name) {
		return this.categoryDao.findByName(name);
	}

	@Override
	@Transactional(readOnly=true)
	public ProgrammeCategoryList findAll() {
		return new ProgrammeCategoryList(this.categoryDao.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public StudyProgrammeCategory save(StudyProgrammeCategory category) {
		logger.info("Adding category with ID " + category.getId());
		return this.categoryDao.save(category);
	}

}
