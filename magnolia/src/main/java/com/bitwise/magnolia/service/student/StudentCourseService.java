package com.bitwise.magnolia.service.student;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import com.bitwise.magnolia.model.student.StudentCourse;
import com.bitwise.magnolia.util.StudentCourseList;

public interface StudentCourseService {

	public StudentCourse findById(Long id);
	
	public StudentCourseList findAllRegisteredCoursesOne(Long semesterId, Boolean toggle);
	
	public StudentCourseList findAllRegisteredCoursesTwo(Long semesterId, Boolean toggle);
	
	public StudentCourseList findAllPendingCoursesOne(Long semesterId, String status);
	
	public StudentCourseList findAllPendingCoursesTwo(Long semesterId, String status);
	
	public StudentCourseList findAllCompletedCoursesOne(Long semesterId, String status);
	
	public StudentCourseList findAllCompletedCoursesTwo(Long semesterId, String status);
	
	public StudentCourseList findAllCoursesOne(Long semesterId);
	
	public StudentCourseList findAllCoursesTwo(Long semesterId);
	
	public StudentCourseList findAllCourses();
	
	public StudentCourse save(StudentCourse sc);

}
