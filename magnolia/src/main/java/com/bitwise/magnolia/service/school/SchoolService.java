package com.bitwise.magnolia.service.school;

import com.bitwise.magnolia.model.school.School;

public interface SchoolService {

	//An abstract method to check if a school actually exist
	public boolean isSchoolExist(String alias);
	//An abstract method to check if a school has any valid days
	public boolean isValidDays(String alias);
	//An abstract method to retrieve the details of a school
	public School retrieveSchoolDetails(String alias);

}
