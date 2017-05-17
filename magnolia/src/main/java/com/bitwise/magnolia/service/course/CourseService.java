package com.bitwise.magnolia.service.course;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import java.util.List;

/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import com.bitwise.magnolia.model.course.Course;
import com.bitwise.magnolia.util.CourseList;

public interface CourseService {

	public Course findById(Long id);
	
	public Course findByName(String name);
	
	public Course findByCode(String code);
	
	public CourseList findCoursesByStaffId(Long staffId);
	
	public CourseList findCoursesByProgrammeId(Long programmeId);
	
	public CourseList findAllCourses();
	
	public List<Course> findAll();
	
	public Course save(Course data);
	
	public Course update(Course data);
}
