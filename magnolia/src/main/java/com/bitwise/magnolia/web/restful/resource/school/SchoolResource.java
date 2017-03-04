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

import com.bitwise.magnolia.common.Utils;
import com.bitwise.magnolia.model.school.School;

public class SchoolResource extends ResourceSupport {

	public SchoolResource() {
		
	}
	
	private Long rid;
	
	private String schoolName;
	
	private String alias;
	
	private String apiKey;
	
	private String email;
	
	private String schoolAddress;
	
	private String schoolLogo;
	
	private String website;
	
	private Integer validDays;
	
	private String createdAt;
	
	private String status;

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}

	public String getSchoolLogo() {
		return schoolLogo;
	}

	public void setSchoolLogo(String schoolLogo) {
		this.schoolLogo = schoolLogo;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Integer getValidDays() {
		return validDays;
	}

	public void setValidDays(Integer validDays) {
		this.validDays = validDays;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public School toSchool() {
		School school = new School();
		school.setSchoolId(rid);
		school.setSchoolAddress(schoolAddress);
		school.setAlias(alias);
		school.setApiKey(Utils.randomString(30));
		school.setCreatedAt(new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()));
		school.setEmail(email);
		school.setStatus(status);
		school.setSchoolLogo(schoolLogo);
		school.setValidDays(validDays);
		school.setWebsite(website);
		school.setSchoolName(schoolName);
		return school;
	}
}
