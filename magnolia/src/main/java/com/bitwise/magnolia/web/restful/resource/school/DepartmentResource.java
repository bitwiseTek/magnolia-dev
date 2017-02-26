package com.bitwise.magnolia.web.restful.resource.school;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 *
 */
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

import com.bitwise.magnolia.model.school.Department;
import com.bitwise.magnolia.model.school.Faculty;

public class DepartmentResource extends ResourceSupport {

	public DepartmentResource() {
		
	}
	
	private Long rid;
	
	private String name;
	
	private String status;
	
	private String createdAt;
	
	private String updatedAt;
	
	private String faculty;

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	
	public Department toDepartment() {
		Department dept = new Department();
		dept.setDepartmentId(rid);
		dept.setCreatedAt(new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()));
		dept.setUpdatedAt(new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()));
		dept.setName(name);
		dept.setStatus(status);
		dept.setFaculty(new Faculty(Long.parseLong(faculty)));
		return dept;
	}
}
