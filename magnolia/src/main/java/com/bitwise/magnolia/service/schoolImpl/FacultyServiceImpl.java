package com.bitwise.magnolia.service.schoolImpl;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 */
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitwise.magnolia.dao.school.FacultyDao;
import com.bitwise.magnolia.model.school.Faculty;
import com.bitwise.magnolia.service.school.FacultyService;
import com.bitwise.magnolia.util.FacultyList;

@Transactional
@Service("facultyService")
public class FacultyServiceImpl implements FacultyService{

	@Autowired
	private FacultyDao facultyDao;

	@Override
	public FacultyList findActiveFaculties(String schoolAlias) {
		return new FacultyList(facultyDao.findActiveFaculties(schoolAlias));
	}

	@Override
	public FacultyList findAllFaculties() {
		return new FacultyList(facultyDao.findAllFaculties());
	}

	@Override
	public Faculty findById(Long id) {
		return this.facultyDao.findByFacutltyId(id);
	}
	
}
