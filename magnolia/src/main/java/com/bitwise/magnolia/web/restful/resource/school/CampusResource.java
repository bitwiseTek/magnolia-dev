package com.bitwise.magnolia.web.restful.resource.school;
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
import com.bitwise.magnolia.model.school.Campus;
import com.bitwise.magnolia.model.school.SubSchool;

public class CampusResource extends ResourceSupport {

	public CampusResource() {
		
	}
	
	private Long rid;
	
	private String name;
	
	private String status;
	
	private String createdAt;
	
	private String updatedAt;
	
	private String subSchool;

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

	public String getSubSchool() {
		return subSchool;
	}

	public void setSubSchool(String subSchool) {
		this.subSchool = subSchool;
	}
	
	public Campus toCampus() {
		Campus campus = new Campus();
		campus.setCampusId(rid);
		campus.setName(name);
		campus.setStatus(ApplicationConstant.ACTIVE_STATUS);
		campus.setCreatedAt(new SimpleDateFormat("E, dd MMM Y h:mm a").format(new Date()));
		campus.setUpdatedAt(new SimpleDateFormat("E, dd MMM Y h:mm a").format(new Date()));
		campus.setSubSchool(new SubSchool(Long.parseLong(subSchool)));
		return campus;
	}
}
