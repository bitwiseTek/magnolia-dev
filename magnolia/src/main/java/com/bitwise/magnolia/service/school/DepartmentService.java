package com.bitwise.magnolia.service;

import com.bitwise.magnolia.common.Response;

public interface DepartmentService {

	//Gets a list of active Departments pointing to a specific facultyId
	//apiKey is used to enforce security on api calls
	//FacultyId should exist in school's faculty table pointed by the apiKey
	Response getActiveDepartmentsByFacultyId(String apiKey, long facultyId);

}
