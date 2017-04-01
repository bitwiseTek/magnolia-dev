package com.bitwise.magnolia.dao.course;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import java.util.List;

import com.bitwise.magnolia.model.course.Course;

public interface CourseDao {

	public Course findById(Long id);
	
	public Course findByName(String name);
	
	public Course findByCode(String code);
	
	public List<Course> findCoursesByStaffId(Long staffId);
	
	public List<Course> findCoursesByProgrammeId(Long programmeId);
	
	public List<Course> findAllCourses();
	
	public Course save(Course course);
}
