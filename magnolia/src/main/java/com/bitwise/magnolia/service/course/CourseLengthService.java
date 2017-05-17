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
 * @date 02/03/17
 *
 */
import com.bitwise.magnolia.model.course.CourseLength;
import com.bitwise.magnolia.util.CourseLengthList;

public interface CourseLengthService {

	public CourseLength findById(Long id);
	
	public CourseLength findByName(String name);
	
	public CourseLengthList findAllCourseLengths();
	
	public List<CourseLength> findAll();
	
	public CourseLength save(CourseLength data);
	
	public CourseLength update(CourseLength data);
}
