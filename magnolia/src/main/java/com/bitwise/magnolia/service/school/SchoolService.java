package com.bitwise.magnolia.service.school;

import com.bitwise.magnolia.dao.common.Response;

public interface SchoolService {

	//An abstract method to check if a school actually exist
	boolean isSchoolExist(String alias);
	//An abstract method to check if a school has any valid days
	boolean isValidDays(String alias);
	//An abstract method to retrieve the details of a school
	Response retrieveSchoolDetails(String alias);

}
