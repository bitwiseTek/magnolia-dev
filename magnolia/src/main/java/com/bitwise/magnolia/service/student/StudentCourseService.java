package com.bitwise.magnolia.service.student;
import java.util.List;

/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import com.bitwise.magnolia.model.student.StudentCourse;
import com.bitwise.magnolia.util.StudentCourseList;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
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
	
	public List<StudentCourse> findAll();
	
	public List<StudentCourse> findAllRegisteredOne(Long semesterId, Boolean toggle);
	
	public List<StudentCourse> findAllRegisteredTwo(Long semesterId, Boolean toggle);
	
	public List<StudentCourse> findAllPendingOne(Long semesterId, String status);
	
	public List<StudentCourse> findAllPendingTwo(Long semesterId, String status);
	
	public List<StudentCourse> findAllCompletedOne(Long semesterId, String status);
	
	public List<StudentCourse> findAllCompletedTwo(Long semesterId, String status);
	
	public List<StudentCourse> findAllOne(Long semesterId);
	
	public List<StudentCourse> findAllTwo(Long semesterId);
	
	public StudentCourse save(StudentCourse data);
	
	public StudentCourse update(StudentCourse data);

}
