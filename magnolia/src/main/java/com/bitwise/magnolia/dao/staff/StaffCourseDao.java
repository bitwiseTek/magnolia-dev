package com.bitwise.magnolia.dao.staff;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import java.util.List;

import com.bitwise.magnolia.model.staff.StaffCourse;

public interface StaffCourseDao {

	public StaffCourse findById(Long id);
	
	public List<StaffCourse> findAllAttachedCoursesOne(Long semesterId, Boolean toggle);
	
	public List<StaffCourse> findAllAttachedCoursesTwo(Long semesterId, Boolean toggle);
	
	public List<StaffCourse> findAllPendingCoursesOne(Long semesterId, String status);
	
	public List<StaffCourse> findAllPendingCoursesTwo(Long semesterId, String status);
	
	public List<StaffCourse> findAllCompletedCoursesOne(Long semesterId, String status);
	
	public List<StaffCourse> findAllCompletedCoursesTwo(Long semesterId, String status);
	
	public List<StaffCourse> findAllCoursesOne(Long semesterId);
	
	public List<StaffCourse> findAllCoursesTwo(Long semesterId);
	
	public List<StaffCourse> findAllCourses();
	
	public StaffCourse save(StaffCourse sc);
}
