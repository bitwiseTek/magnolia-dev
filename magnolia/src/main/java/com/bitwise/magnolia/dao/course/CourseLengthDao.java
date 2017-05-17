package com.bitwise.magnolia.dao.course;
/**
 *  
 * @author Sika Kay
 * @date 01/03/17
 *
 */
import java.util.List;

import com.bitwise.magnolia.model.course.CourseLength;

public interface CourseLengthDao {

	public CourseLength findById(Long id);
	
	public CourseLength findByName(String name);
	
	public List<CourseLength> findAllCourseLengths();
	
	public CourseLength save(CourseLength length);
	
	public CourseLength update(CourseLength length);
}
