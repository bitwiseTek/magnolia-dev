package com.bitwise.magnolia.service.school;
import java.util.List;

import com.bitwise.magnolia.model.school.Department;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 *
 */
import com.bitwise.magnolia.util.DepartmentList;

public interface DepartmentService {

	//Gets a list of active Departments pointing to a specific facultyId
	//apiKey is used to enforce security on api calls
	//FacultyId should exist in school's faculty table pointed by the apiKey
	public DepartmentList findActiveDepartmentsByFacultyId(String apiKey, Long facultyId);
	
	public DepartmentList findDepartmentsByFacultyId(Long facultyId);
	
	public DepartmentList findAllDepartments();
	
	public List<Department> findAll();
	
	public Department findByDepartmentId(Long id);
	
	public Department findByName(String name);

}
