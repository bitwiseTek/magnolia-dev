package com.bitwise.magnolia.dao.school;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 *
 */
import java.util.List;

import com.bitwise.magnolia.common.BaseDao;
import com.bitwise.magnolia.model.school.Faculty;

public interface FacultyDao extends BaseDao<Faculty> {

	//Gets a list of active Faculties with type @see #Faculty 
	public List<Faculty> findActiveFaculties(String schoolAlias);
	
	public List<Faculty> findAllFaculties();
	
	public Faculty findByFacutltyId(Long id);
	
	public Faculty findByName(String name);
	
	public Faculty save(Faculty faculty);
	
}
