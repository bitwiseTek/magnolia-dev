package com.bitwise.magnolia.service.commonImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.bitwise.magnolia.exception.EntityDoesNotExistException;
import com.bitwise.magnolia.exception.EntityExistsException;
import com.bitwise.magnolia.model.common.StudyProgrammeCategory;
import com.bitwise.magnolia.service.common.StudyProgrammeCategoryService;
import com.bitwise.magnolia.util.ProgrammeCategoryList;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
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
	public StudyProgrammeCategory save(StudyProgrammeCategory data) {
		logger.info("Adding category with ID " + data.getId());
		StudyProgrammeCategory category = categoryDao.findByName(data.getName());
		if (category != null) {
			throw new EntityExistsException("Category already exists");
		}
		return this.categoryDao.save(data);
	}

	@Override
	@Transactional(readOnly=true)
	public List<StudyProgrammeCategory> findAllCategories() {
		return this.categoryDao.findAll();
	}

	@Override
	@Transactional(readOnly=false)
	public StudyProgrammeCategory update(StudyProgrammeCategory data) {
		StudyProgrammeCategory category = categoryDao.findById(data.getId());
		try {
			if (category != null) {
				category.setCreatedAt(data.getCreatedAt());
				category.setName(data.getName());
				category.setStatus(data.getStatus());
				category.setUpdatedAt(new SimpleDateFormat("E, dd MMM Y h:mm a").format(new Date()));
			} else {
				throw new EntityDoesNotExistException("Category does not exist");
			}
		} catch(Exception e) {
			throw new EntityDoesNotExistException("Category does not exist");
		}
		return null;
	}

}