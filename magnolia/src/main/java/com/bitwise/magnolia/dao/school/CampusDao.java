package com.bitwise.magnolia.dao.school;
/**
 *  
 * @author Sika Kay
 * @date 01/03/17
 *
 */
import java.util.List;

import com.bitwise.magnolia.model.school.Campus;

public interface CampusDao {

	public Campus findById(Long id);
	
	public Campus findByName(String name);
	
	public List<Campus> findAllCampuses();
	
	public List<Campus> findCampusesBySubSchoolId(Long subSchoolId);
	
	public Campus save(Campus campus);
	
	public Campus update(Campus campus);
}
