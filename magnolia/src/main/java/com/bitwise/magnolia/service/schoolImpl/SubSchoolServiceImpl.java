package com.bitwise.magnolia.service.schoolImpl;
import java.util.List;

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
import com.bitwise.magnolia.exception.EntityDoesNotExistException;
import com.bitwise.magnolia.exception.EntityExistsException;
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
	public SubSchool save(SubSchool data) {
		logger.info("Adding subschool with ID " + data.getSubSchoolId());
		SubSchool school = subSchoolDao.findByName(data.getName());
		if (school != null) {
			throw new EntityExistsException("SubSchool already exists");
		}
		return this.subSchoolDao.save(data);
	}

	@Override
	@Transactional(readOnly=true)
	public List<SubSchool> findAll() {
		return this.subSchoolDao.findAllSubSchools();
	}

	@Override
	@Transactional(readOnly=false)
	public SubSchool update(SubSchool data) {
		SubSchool school = subSchoolDao.findById(data.getSubSchoolId());
		try {
			if (school != null) {
				school.setAddress(data.getAddress());
				school.setCreatedAt(data.getCreatedAt());
				school.setName(data.getName());
				school.setStatus(data.getStatus());
				school.setType(data.getType());
				school.setSchool(data.getSchool());
			} else {
				throw new EntityDoesNotExistException("SubSchool does not exist");
			}
		} catch(Exception e) {
			throw new EntityDoesNotExistException("SubSchool does not exist");
		}
		return school;
	}
}
