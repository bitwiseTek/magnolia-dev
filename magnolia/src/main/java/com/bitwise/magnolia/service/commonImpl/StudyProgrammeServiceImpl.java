package com.bitwise.magnolia.service.commonImpl;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
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

import com.bitwise.magnolia.dao.common.StudyProgrammeDao;
import com.bitwise.magnolia.model.common.StudyProgramme;
import com.bitwise.magnolia.service.common.StudyProgrammeService;
import com.bitwise.magnolia.util.ProgrammeList;

@Transactional
@Service("programmeService")
public class StudyProgrammeServiceImpl implements StudyProgrammeService {

	final Logger logger = LoggerFactory.getLogger(StudyProgrammeServiceImpl.class);
	
	@Autowired
	private StudyProgrammeDao programmeDao;
	
	@Override
	@Transactional(readOnly=true)
	public StudyProgramme findById(Long id) {
		return this.programmeDao.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public StudyProgramme findByName(String name) {
		return this.programmeDao.findByName(name);
	}

	@Override
	@Transactional(readOnly=true)
	public StudyProgramme findByCode(String code) {
		return this.programmeDao.findByCode(code);
	}

	@Override
	@Transactional(readOnly=true)
	public ProgrammeList findProgrammesByDepartmentId(Long deptId) {
		return new ProgrammeList(this.programmeDao.findProgrammesByDepartmentId(deptId));
	}

	@Override
	@Transactional(readOnly=true)
	public ProgrammeList findAllProgrammes() {
		return new ProgrammeList(this.programmeDao.findAllProgrammes());
	}

	@Override
	@Transactional(readOnly=false)
	public StudyProgramme save(StudyProgramme programme) {
		logger.info("Adding/Updating study programme with ID " + programme.getId());
		return this.programmeDao.save(programme);
	}

	@Override
	@Transactional(readOnly=true)
	public List<StudyProgramme> findAll() {
		return this.programmeDao.findAllProgrammes();
	}

}
