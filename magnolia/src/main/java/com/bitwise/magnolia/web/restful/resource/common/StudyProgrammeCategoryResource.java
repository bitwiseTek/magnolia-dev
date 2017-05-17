package com.bitwise.magnolia.web.restful.resource.common;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.model.common.StudyProgrammeCategory;

public class StudyProgrammeCategoryResource extends ResourceSupport {

	public StudyProgrammeCategoryResource() {
		
	}
	
	private Long rid;
	
	private String name;
	
	private String status;
	
	private String createdAt;
	
	private String updatedAt;

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
	
	public StudyProgrammeCategory toCategory() {
		StudyProgrammeCategory category = new StudyProgrammeCategory();
		category.setId(rid);
		category.setName(name);
		category.setStatus(ApplicationConstant.ACTIVE_STATUS);
		category.setCreatedAt(new SimpleDateFormat("E, dd MMM Y h:mm a").format(new Date()));
		category.setUpdatedAt(new SimpleDateFormat("E, dd MMM Y h:mm a").format(new Date()));
		return category;
	}
}
