package com.bitwise.magnolia.dao.student;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import java.util.List;

import com.bitwise.magnolia.model.student.StudentCourse;

public interface StudentCourseDao {

	public StudentCourse findById(Long id);
	
	public List<StudentCourse> findAllRegisteredCoursesOne(Long semesterId, Boolean toggle);
	
	public List<StudentCourse> findAllRegisteredCoursesTwo(Long semesterId, Boolean toggle);
	
	public List<StudentCourse> findAllPendingCoursesOne(Long semesterId, String status);
	
	public List<StudentCourse> findAllPendingCoursesTwo(Long semesterId, String status);
	
	public List<StudentCourse> findAllCompletedCoursesOne(Long semesterId, String status);
	
	public List<StudentCourse> findAllCompletedCoursesTwo(Long semesterId, String status);
	
	public List<StudentCourse> findAllCoursesOne(Long semesterId);
	
	public List<StudentCourse> findAllCoursesTwo(Long semesterId);
	
	public List<StudentCourse> findAllCourses();
	
	public StudentCourse save(StudentCourse sc);
}
