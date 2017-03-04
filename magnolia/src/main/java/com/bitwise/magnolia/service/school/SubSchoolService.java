package com.bitwise.magnolia.service.school;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import com.bitwise.magnolia.model.school.SubSchool;
import com.bitwise.magnolia.util.SubSchoolList;

public interface SubSchoolService {

	public SubSchool findById(Long id);
	
	public SubSchool findByName(String name);
	
	public SubSchoolList findSubSchoolsBySchoolId(Long id);
	
	public SubSchoolList findAllSubSchools();
	
	public SubSchool save(SubSchool school);
}
