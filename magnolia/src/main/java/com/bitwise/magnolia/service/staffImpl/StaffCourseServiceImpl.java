package com.bitwise.magnolia.service.staffImpl;
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
import com.bitwise.magnolia.dao.staff.StaffCourseDao;
import com.bitwise.magnolia.model.staff.StaffCourse;
import com.bitwise.magnolia.service.staff.StaffCourseService;
import com.bitwise.magnolia.util.StaffCourseList;

@Transactional
@Service("staffCourseService")
public class StaffCourseServiceImpl implements StaffCourseService {

	final Logger logger = LoggerFactory.getLogger(StaffCourseServiceImpl.class);
	
	@Autowired
	private StaffCourseDao staffCourseDao;
	
	@Override
	@Transactional(readOnly=true)
	public StaffCourse findById(Long id) {
		return this.staffCourseDao.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public StaffCourseList findAllAttachedCoursesOne(Long semesterId, Boolean toggle) {
		return new StaffCourseList(this.staffCourseDao.findAllAttachedCoursesOne(semesterId, Boolean.TRUE));
	}

	@Override
	@Transactional(readOnly=true)
	public StaffCourseList findAllAttachedCoursesTwo(Long semesterId, Boolean toggle) {
		return new StaffCourseList(this.staffCourseDao.findAllAttachedCoursesTwo(semesterId, Boolean.TRUE));
	}

	@Override
	@Transactional(readOnly=true)
	public StaffCourseList findAllPendingCoursesOne(Long semesterId, String status) {
		return new StaffCourseList(this.staffCourseDao.findAllPendingCoursesOne(semesterId, ApplicationConstant.PENDING_STATUS));
	}

	@Override
	@Transactional(readOnly=true)
	public StaffCourseList findAllPendingCoursesTwo(Long semesterId, String status) {
		return new StaffCourseList(this.staffCourseDao.findAllPendingCoursesTwo(semesterId, ApplicationConstant.PENDING_STATUS));
	}

	@Override
	@Transactional(readOnly=true)
	public StaffCourseList findAllCompletedCoursesOne(Long semesterId, String status) {
		return new StaffCourseList(this.staffCourseDao.findAllCompletedCoursesOne(semesterId, ApplicationConstant.COMPLETED_STATUS));
	}

	@Override
	@Transactional(readOnly=true)
	public StaffCourseList findAllCompletedCoursesTwo(Long semesterId, String status) {
		return new StaffCourseList(this.staffCourseDao.findAllCompletedCoursesTwo(semesterId, ApplicationConstant.COMPLETED_STATUS));
	}

	@Override
	@Transactional(readOnly=true)
	public StaffCourseList findAllCoursesOne(Long semesterId) {
		return new StaffCourseList(this.staffCourseDao.findAllCoursesOne(semesterId));
	}

	@Override
	@Transactional(readOnly=true)
	public StaffCourseList findAllCoursesTwo(Long semesterId) {
		return new StaffCourseList(this.staffCourseDao.findAllCoursesTwo(semesterId));
	}

	@Override
	@Transactional(readOnly=true)
	public StaffCourseList findAllCourses() {
		return new StaffCourseList(this.staffCourseDao.findAllCourses());
	}

	@Override
	@Transactional(readOnly=false)
	public StaffCourse save(StaffCourse sc) {
		logger.info("Attaching staff to course with ID " + sc.getId());
		return this.staffCourseDao.save(sc);
	}

}
