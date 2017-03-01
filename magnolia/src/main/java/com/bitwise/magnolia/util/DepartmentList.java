package com.bitwise.magnolia.util;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import com.bitwise.magnolia.model.school.Department;

public class DepartmentList {

	public DepartmentList(List<Department> departments) {
		this.departments = departments;
	}
	
	private List<Department> departments = new ArrayList<Department>();

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
}
