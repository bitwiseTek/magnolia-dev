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

import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.model.school.Campus;
import com.bitwise.magnolia.model.school.Faculty;

public class FacultyResource extends ResourceSupport {

	public FacultyResource() {
		
	}
	
	private Long rid;
	
	private String name;
	
	private String status;
	
	private String createdAt;
	
	private String updatedAt;
	
	private String campus;

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

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}
	
	public Faculty toFaculty() {
		Faculty faculty = new Faculty();
		faculty.setFacultyId(rid);
		faculty.setCreatedAt(new SimpleDateFormat("E, dd MMM Y h:mm a").format(new Date()));
		faculty.setUpdatedAt(new SimpleDateFormat("E, dd MMM Y h:mm a").format(new Date()));
		faculty.setName(name);
		faculty.setStatus(ApplicationConstant.ACTIVE_STATUS);
		faculty.setCampus(new Campus(Long.parseLong(campus)));
		return faculty;
	}
}
