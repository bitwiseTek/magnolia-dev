package com.bitwise.magnolia.web.restful.resource.school;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class DepartmentListResource extends ResourceSupport {

	private List<DepartmentResource> departments = new ArrayList<DepartmentResource>();

	public List<DepartmentResource> getDepartments() {
		return departments;
	}

	public void setDepartments(List<DepartmentResource> departments) {
		this.departments = departments;
	}
}
