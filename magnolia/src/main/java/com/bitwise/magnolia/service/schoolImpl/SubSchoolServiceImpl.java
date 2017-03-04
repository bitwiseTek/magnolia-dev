package com.bitwise.magnolia.service.schoolImpl;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.magnolia.dao.school.SubSchoolDao;
import com.bitwise.magnolia.model.school.SubSchool;
import com.bitwise.magnolia.service.school.SubSchoolService;
import com.bitwise.magnolia.util.SubSchoolList;

@Transactional
@Service("subSchoolService")
public class SubSchoolServiceImpl implements SubSchoolService {

	final Logger logger = LoggerFactory.getLogger(SubSchoolServiceImpl.class);
	
	@Autowired
	private SubSchoolDao subSchoolDao;

	@Override
	@Transactional(readOnly=true)
	public SubSchool findById(Long id) {
		return this.subSchoolDao.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public SubSchool findByName(String name) {
		return this.subSchoolDao.findByName(name);
	}

	@Override
	@Transactional(readOnly=true)
	public SubSchoolList findSubSchoolsBySchoolId(Long id) {
		return new SubSchoolList(this.subSchoolDao.findSubSchoolsBySchoolId(id));
	}

	@Override
	@Transactional(readOnly=true)
	public SubSchoolList findAllSubSchools() {
		return new SubSchoolList(this.subSchoolDao.findAllSubSchools());
	}

	@Override
	@Transactional(readOnly=false)
	public SubSchool save(SubSchool school) {
		logger.info("Adding subschool with ID " + school.getSubSchoolId());
		return this.subSchoolDao.save(school);
	}
}
