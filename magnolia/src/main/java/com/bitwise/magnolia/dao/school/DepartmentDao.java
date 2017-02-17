package com.bitwise.magnolia.dao;

import java.util.List;

import com.bitwise.magnolia.common.BaseDao;
import com.bitwise.magnolia.model.Department;

public interface DepartmentDao extends BaseDao<Department>{

	//Gets a list of active Departments pointing to a specific facultyId
	//apiKey is used to enforce security on api calls
	//FacultyId should exist in school's faculty table pointed by the apiKey
	List<Department> fetchActiveDepartmentsByFacultyId(String apiKey, long facultyId);

}
