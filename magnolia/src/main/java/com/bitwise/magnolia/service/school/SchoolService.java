package com.bitwise.magnolia.service.school;
/**
 *  
 * @author Sika Kay
 * @date 01/03/17
 *
 */
import com.bitwise.magnolia.model.school.School;
import com.bitwise.magnolia.util.SchoolList;

public interface SchoolService {

	//An abstract method to check if a school actually exist
	public boolean isSchoolExist(String alias);
	//An abstract method to check if a school has any valid days
	public boolean isValidDays(String alias);
	//An abstract method to retrieve the details of a school
	public School retrieveSchoolDetails(String alias);
	
	public School findById(Long id);
	
	public School findByName(String name);
	
	public SchoolList findAllSchools();
	
	public School save(School school);

}
