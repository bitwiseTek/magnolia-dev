package com.bitwise.magnolia.service.schoolImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityExistsException;

/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.magnolia.dao.school.FacultyDao;
import com.bitwise.magnolia.exception.EntityDoesNotExistException;
import com.bitwise.magnolia.model.school.Faculty;
import com.bitwise.magnolia.service.school.FacultyService;
import com.bitwise.magnolia.util.FacultyList;

@Transactional
@Service("facultyService")
public class FacultyServiceImpl implements FacultyService{

	@Autowired
	private FacultyDao facultyDao;

	@Override
	@Transactional(readOnly=true)
	public FacultyList findActiveFaculties(String schoolAlias) {
		return new FacultyList(facultyDao.findActiveFaculties(schoolAlias));
	}

	@Override
	@Transactional(readOnly=true)
	public FacultyList findAllFaculties() {
		return new FacultyList(facultyDao.findAllFaculties());
	}

	@Override
	@Transactional(readOnly=true)
	public Faculty findById(Long id) {
		return this.facultyDao.findByFacutltyId(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Faculty findByName(String name) {
		return this.facultyDao.findByName(name);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Faculty> findAll() {
		return this.facultyDao.findAllFaculties();
	}

	@Override
	@Transactional(readOnly=false)
	public Faculty save(Faculty data) {
		Faculty faculty = facultyDao.findByName(data.getName());
		if (faculty != null) {
			throw new EntityExistsException("Faculty already exists");
		}
		return this.facultyDao.save(data);
	}

	@Override
	@Transactional(readOnly=false)
	public Faculty update(Faculty data) {
		Faculty faculty = facultyDao.findByFacutltyId(data.getFacultyId());
		try {
			if (faculty != null) {
				faculty.setCreatedAt(data.getCreatedAt());
				faculty.setName(data.getName());
				faculty.setStatus(data.getStatus());
				faculty.setCampus(data.getCampus());
				faculty.setUpdatedAt(new SimpleDateFormat("E, dd MMM Y h:mm a").format(new Date()));
			} else {
				throw new EntityDoesNotExistException("Faculty does not exist");
			}
		} catch(Exception e) {
			throw new EntityDoesNotExistException("Faculty does not exist");
		}
		return faculty;
	}
	
}
