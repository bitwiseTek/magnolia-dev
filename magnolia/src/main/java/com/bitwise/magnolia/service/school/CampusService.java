package com.bitwise.magnolia.service.school;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import com.bitwise.magnolia.model.school.Campus;
import com.bitwise.magnolia.util.CampusList;

public interface CampusService {

	public Campus findById(Long id);
	
	public Campus findByName(String name);
	
	public CampusList findAllCampuses();
	
	public CampusList findCampusesBySubSchoolId(Long id);
	
	public Campus save(Campus campus);
}
