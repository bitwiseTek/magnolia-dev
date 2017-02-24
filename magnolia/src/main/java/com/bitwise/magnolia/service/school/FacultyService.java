package com.bitwise.magnolia.service.school;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 *
 */
import com.bitwise.magnolia.model.school.Faculty;
import com.bitwise.magnolia.util.FacultyList;

public interface FacultyService {

	/**
	 * Gets all active faculties
	 * @see #Response
	 * @param schoolAlias
	 * @return
	 */
	public FacultyList findActiveFaculties(String schoolAlias);
	
	public FacultyList findAllFaculties();
	
	public Faculty findById(Long id);
	
	public Faculty findByName(String name);
	
}
