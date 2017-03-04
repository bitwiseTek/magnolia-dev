package com.bitwise.magnolia.service.staff;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import com.bitwise.magnolia.model.staff.StaffCourse;
import com.bitwise.magnolia.util.StaffCourseList;

public interface StaffCourseService {

	public StaffCourse findById(Long id);
	
	public StaffCourseList findAllAttachedCoursesOne(Long semesterId, Boolean toggle);
	
	public StaffCourseList findAllAttachedCoursesTwo(Long semesterId, Boolean toggle);
	
	public StaffCourseList findAllPendingCoursesOne(Long semesterId, String status);
	
	public StaffCourseList findAllPendingCoursesTwo(Long semesterId, String status);
	
	public StaffCourseList findAllCompletedCoursesOne(Long semesterId, String status);
	
	public StaffCourseList findAllCompletedCoursesTwo(Long semesterId, String status);
	
	public StaffCourseList findAllCoursesOne(Long semesterId);
	
	public StaffCourseList findAllCoursesTwo(Long semesterId);
	
	public StaffCourseList findAllCourses();
	
	public StaffCourse save(StaffCourse sc);
}
