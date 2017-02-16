package com.bitwise.magnolia.dao;

import com.bitwise.magnolia.common.BaseDao;
import com.bitwise.magnolia.model.School;

public interface SchoolDao extends BaseDao<Object>{

	//An abstract method to check if a school actually exist
	boolean isSchoolExist(String alias);
	//An abstract method to retrieve school by alias
	School findSchoolByAlias(String alias);
	//Checks if a requested apiKey exist for a specific school
	boolean isApiKeyExist(String apiKey);

}
