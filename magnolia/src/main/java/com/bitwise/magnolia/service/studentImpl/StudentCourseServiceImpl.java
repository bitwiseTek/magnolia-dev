package com.bitwise.magnolia.service.studentImpl;
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

import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.dao.student.StudentCourseDao;
import com.bitwise.magnolia.exception.EntityDoesNotExistException;
import com.bitwise.magnolia.exception.EntityExistsException;
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
	@Transactional(readOnly=true)
	public List<StudentCourse> findAll() {
		return this.studentCourseDao.findAllCourses();
	}

	@Override
	@Transactional(readOnly=true)
	public List<StudentCourse> findAllRegisteredOne(Long semesterId, Boolean toggle) {
		return this.studentCourseDao.findAllRegisteredCoursesOne(semesterId, Boolean.TRUE);
	}

	@Override
	@Transactional(readOnly=true)
	public List<StudentCourse> findAllRegisteredTwo(Long semesterId, Boolean toggle) {
		return this.studentCourseDao.findAllRegisteredCoursesTwo(semesterId, Boolean.TRUE);
	}

	@Override
	@Transactional(readOnly=true)
	public List<StudentCourse> findAllPendingOne(Long semesterId, String status) {
		return this.studentCourseDao.findAllPendingCoursesOne(semesterId, ApplicationConstant.PENDING_STATUS);
	}

	@Override
	@Transactional(readOnly=true)
	public List<StudentCourse> findAllPendingTwo(Long semesterId, String status) {
		return this.studentCourseDao.findAllPendingCoursesTwo(semesterId, ApplicationConstant.PENDING_STATUS);
	}

	@Override
	@Transactional(readOnly=true)
	public List<StudentCourse> findAllCompletedOne(Long semesterId, String status) {
		return this.studentCourseDao.findAllCompletedCoursesOne(semesterId, ApplicationConstant.COMPLETED_STATUS);
	}

	@Override
	@Transactional(readOnly=true)
	public List<StudentCourse> findAllCompletedTwo(Long semesterId, String status) {
		return this.studentCourseDao.findAllCompletedCoursesTwo(semesterId, ApplicationConstant.COMPLETED_STATUS);
	}

	@Override
	@Transactional(readOnly=true)
	public List<StudentCourse> findAllOne(Long semesterId) {
		return this.studentCourseDao.findAllCoursesOne(semesterId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<StudentCourse> findAllTwo(Long semesterId) {
		return this.studentCourseDao.findAllCoursesTwo(semesterId);
	}
	
	@Override
	@Transactional(readOnly=false)
	public StudentCourse save(StudentCourse data) {
		logger.info("Adding student course with ID: " + data.getId());
		StudentCourse scourse = studentCourseDao.findByBillingIdAndCourseId(data.getBilling().getId(), data.getCourse().getId());
		if (scourse != null) {
			throw new EntityExistsException("Student Course already exists");
		}
		return this.studentCourseDao.save(data);
	}

	@Override
	public StudentCourse update(StudentCourse data) {
		StudentCourse scourse = studentCourseDao.findById(data.getId());
		try {
			if (scourse != null) {
				scourse.setBilling(data.getBilling());
				scourse.setCourse(data.getCourse());
				scourse.setEndDate(data.getEndDate());
				scourse.setStartDate(data.getStartDate());
				scourse.setCourseStatus(data.getCourseStatus());
				scourse.setToggleOnOff(data.getToggleOnOff());
				scourse.setStudents(data.getStudents());
			} else {
				throw new EntityDoesNotExistException("Student Course does not exist");
			}
		} catch(Exception e) {
			throw new EntityDoesNotExistException("Student Course does not exist");
		}
		return scourse;
	}

}
