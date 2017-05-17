package com.bitwise.magnolia.service.school;
import java.util.List;

/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import com.bitwise.magnolia.model.school.Campus;
import com.bitwise.magnolia.util.CampusList;
/**
 *  
 * @author Sika Kay
 * @date 25/03/17
 *
 */
public interface CampusService {

	public Campus findById(Long id);
	
	public Campus findByName(String name);
	
	public List<Campus> findAll();
	
	public CampusList findAllCampuses();
	
	public CampusList findCampusesBySubSchoolId(Long id);
	
	public Campus save(Campus data);
	
	public Campus update(Campus data);
}
