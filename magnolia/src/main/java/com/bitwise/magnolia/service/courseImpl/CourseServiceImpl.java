package com.bitwise.magnolia.service.courseImpl;
/**
 *  
 * @author Sika Kay
 * @date 26/02/17
 *
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.magnolia.dao.course.CourseDao;
import com.bitwise.magnolia.model.course.Course;
import com.bitwise.magnolia.service.course.CourseService;
import com.bitwise.magnolia.util.CourseList;

@Transactional
@Service("courseService")
public class CourseServiceImpl implements CourseService {

	final Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);
	
	@Autowired
	private CourseDao courseDao;
	
	@Override
	@Transactional(readOnly=true)
	public Course findById(Long id) {
		return this.courseDao.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Course findByName(String name) {
		return this.courseDao.findByName(name);
	}

	@Override
	@Transactional(readOnly=true)
	public Course findByCode(String code) {
		return this.courseDao.findByCode(code);
	}

	@Override
	@Transactional(readOnly=true)
	public CourseList findCoursesByStaffId(Long staffId) {
		return new CourseList(this.courseDao.findCoursesByStaffId(staffId));
	}

	@Override
	@Transactional(readOnly=true)
	public CourseList findCoursesByProgrammeId(Long programmeId) {
		return new CourseList(this.courseDao.findCoursesByProgrammeId(programmeId));
	}

	@Override
	@Transactional(readOnly=true)
	public CourseList findAllCourses() {
		return new CourseList(this.courseDao.findAllCourses());
	}

	@Override
	@Transactional(readOnly=false)
	public Course save(Course course) {
		logger.info("Adding course with ID " + course.getId());
		return this.courseDao.save(course);
	}

}
