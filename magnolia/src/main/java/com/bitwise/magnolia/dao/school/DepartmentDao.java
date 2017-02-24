package com.bitwise.magnolia.dao.school;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 *
 */
import java.util.List;

import com.bitwise.magnolia.common.BaseDao;
import com.bitwise.magnolia.model.school.Department;

public interface DepartmentDao extends BaseDao<Department> {

	//Gets a list of active Departments pointing to a specific facultyId
	//apiKey is used to enforce security on api calls
	//FacultyId should exist in school's faculty table pointed by the apiKey
	public List<Department> findActiveDepartmentsByFacultyId(String apiKey, long facultyId);
	
	public List<Department> findDepartmentsByFacultyId(Long facultyId);
	
	public List<Department> findAllDepartments();
	
	public Department findByDepartmentId(Long id);
	
	public Department findByName(String name);

}
