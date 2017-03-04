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

import com.bitwise.magnolia.dao.common.AcademicSemesterDao;
import com.bitwise.magnolia.model.common.AcademicSemester;
import com.bitwise.magnolia.service.common.AcademicSemesterService;
import com.bitwise.magnolia.util.SemesterList;

@Transactional
@Service("semesterService")
public class AcademicSemesterServiceImpl implements AcademicSemesterService {

	final Logger logger = LoggerFactory.getLogger(AcademicSemesterServiceImpl.class);
	
	@Autowired
	private AcademicSemesterDao semesterDao;
	
	@Override
	@Transactional(readOnly=true)
	public AcademicSemester findById(Long id) {
		return this.semesterDao.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public SemesterList findAll() {
		return new SemesterList(this.semesterDao.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public AcademicSemester save(AcademicSemester semester) {
		logger.info("Adding/Updating semester with ID " + semester.getId());
		return this.semesterDao.save(semester);
	}

	@Override
	@Transactional(readOnly=true)
	public AcademicSemester findByName(String name) {
		return this.semesterDao.findByName(name);
	}

}
