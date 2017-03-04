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

import com.bitwise.magnolia.model.school.School;
import com.bitwise.magnolia.model.school.SubSchool;

public class SubSchoolResource extends ResourceSupport {

	public SubSchoolResource() {
		
	}
	
	private Long rid;
	
	private String name;
	
	private String status;
	
	private String createdAt;
	
	private String type;
	
	private String address;
	
	private String school;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	public SubSchool toSubSchool() {
		SubSchool subSchool = new SubSchool();
		subSchool.setSubSchoolId(rid);
		subSchool.setAddress(address);
		subSchool.setStatus(status);
		subSchool.setCreatedAt(new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()));
		subSchool.setType(type);
		subSchool.setSchool(new School(Long.parseLong(school)));
		return subSchool;
	}
}
