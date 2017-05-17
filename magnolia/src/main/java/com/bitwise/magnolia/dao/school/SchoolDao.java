package com.bitwise.magnolia.dao.school;
import java.util.List;

/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 *
 */
import com.bitwise.magnolia.model.school.School;

public interface SchoolDao {

	//An abstract method to check if a school actually exist
	public boolean isSchoolExist(String alias);
	//An abstract method to retrieve school by alias
	public School findSchoolByAlias(String alias);
	//Checks if a requested apiKey exist for a specific school
	public boolean isApiKeyExist(String apiKey);
	
	public School findById(Long id);
	
	public School findByName(String name);
	
	public List<School> findAllSchools();
	
	public School save(School school);
	
	public School update(School school);

}
