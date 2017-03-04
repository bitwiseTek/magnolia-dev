package com.bitwise.magnolia.dao.course;
/**
 *  
 * @author Sika Kay
 * @date 01/03/17
 *
 */
import java.util.List;

/**
 *  
 * @author Sika Kay
 * @date 01/03/17
 *
 */
import com.bitwise.magnolia.common.BaseDao;
import com.bitwise.magnolia.model.course.CourseLength;

public interface CourseLengthDao extends BaseDao<Object> {

	public CourseLength findById(Long id);
	
	public CourseLength findByName(String name);
	
	public List<CourseLength> findAllCourseLengths();
	
	public CourseLength save(CourseLength length);
}
