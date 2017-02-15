package com.bitwise.magnolia.dao.school;

import java.util.List;

import com.bitwise.magnolia.dao.common.BaseDao;
import com.bitwise.magnolia.domain.school.Department;

public interface DepartmentDao extends BaseDao<Department>{

	//Gets a list of active Departments pointing to a specific facultyId
	//apiKey is used to enforce security on api calls
	//FacultyId should exist in school's faculty table pointed by the apiKey
	List<Department> fetchActiveDepartmentsByFacultyId(String apiKey, long facultyId);

}
