package com.bitwise.magnolia.service.studentImpl;
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

import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.dao.student.StudentCourseDao;
import com.bitwise.magnolia.model.student.StudentCourse;
import com.bitwise.magnolia.service.student.StudentCourseService;
import com.bitwise.magnolia.util.StudentCourseList;

@Transactional
@Service("studentCourseService")
public class StudentCourseServiceImpl implements StudentCourseService {
	
	final Logger logger = LoggerFactory.getLogger(StudentCourseServiceImpl.class);

	@Autowired
	private StudentCourseDao studentCourseDao;
	
	@Override
	@Transactional(readOnly=true)
	public StudentCourse findById(Long id) {
		return this.studentCourseDao.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public StudentCourseList findAllRegisteredCoursesOne(Long semesterId, Boolean toggle) {
		return new StudentCourseList(this.studentCourseDao.findAllRegisteredCoursesOne(semesterId, Boolean.TRUE));
	}

	@Override
	@Transactional(readOnly=true)
	public StudentCourseList findAllRegisteredCoursesTwo(Long semesterId, Boolean toggle) {
		return new StudentCourseList(this.studentCourseDao.findAllRegisteredCoursesTwo(semesterId, Boolean.TRUE));
	}

	@Override
	@Transactional(readOnly=true)
	public StudentCourseList findAllPendingCoursesOne(Long semesterId, String status) {
		return new StudentCourseList(this.studentCourseDao.findAllPendingCoursesOne(semesterId, ApplicationConstant.PENDING_STATUS));
	}

	@Override
	@Transactional(readOnly=true)
	public StudentCourseList findAllPendingCoursesTwo(Long semesterId, String status) {
		return new StudentCourseList(this.studentCourseDao.findAllPendingCoursesTwo(semesterId, ApplicationConstant.PENDING_STATUS));
	}

	@Override
	@Transactional(readOnly=true)
	public StudentCourseList findAllCompletedCoursesOne(Long semesterId, String status) {
		return new StudentCourseList(this.studentCourseDao.findAllCompletedCoursesOne(semesterId, ApplicationConstant.COMPLETED_STATUS));
	}

	@Override
	@Transactional(readOnly=true)
	public StudentCourseList findAllCompletedCoursesTwo(Long semesterId, String status) {
		return new StudentCourseList(this.studentCourseDao.findAllCompletedCoursesOne(semesterId, ApplicationConstant.COMPLETED_STATUS));
	}

	@Override
	@Transactional(readOnly=true)
	public StudentCourseList findAllCoursesOne(Long semesterId) {
		return new StudentCourseList(this.studentCourseDao.findAllCoursesOne(semesterId));
	}

	@Override
	@Transactional(readOnly=true)
	public StudentCourseList findAllCoursesTwo(Long semesterId) {
		return new StudentCourseList(this.studentCourseDao.findAllCoursesOne(semesterId));
	}

	@Override
	@Transactional(readOnly=true)
	public StudentCourseList findAllCourses() {
		return new StudentCourseList(this.studentCourseDao.findAllCourses());
	}

	@Override
	@Transactional(readOnly=false)
	public StudentCourse save(StudentCourse sc) {
		logger.info("Adding student course with ID: " + sc.getId());
		return this.studentCourseDao.save(sc);
	}

}
