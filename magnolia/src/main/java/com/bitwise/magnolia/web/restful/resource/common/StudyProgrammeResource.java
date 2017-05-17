package com.bitwise.magnolia.web.restful.resource.common;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import org.joda.time.DateTime;
import org.springframework.hateoas.ResourceSupport;

import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.model.common.StudyProgramme;
import com.bitwise.magnolia.model.common.StudyProgrammeCategory;
import com.bitwise.magnolia.model.course.CourseLength;
import com.bitwise.magnolia.model.school.Department;
import com.bitwise.magnolia.model.user.User;

public class StudyProgrammeResource extends ResourceSupport {

	public StudyProgrammeResource() {
		
	}
	
	private Long rid;
	
	private String name;
	
	private String code;
	
	private String status;
	
	private String description;
	
	private Integer programDays;
	
	private Integer participants;
	
	private Integer maxParticipants;
	
	private String createdAt;
	
	private String updatedAt;
	
	private String endDate;
	
	private String createdBy;
	
	private String updatedBy;
	
	private String category;
	
	private String courseLength;
	
	private String department;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getProgramDays() {
		return programDays;
	}

	public void setProgramDays(Integer programDays) {
		this.programDays = programDays;
	}

	public Integer getParticipants() {
		return participants;
	}

	public void setParticipants(Integer participants) {
		this.participants = participants;
	}

	public Integer getMaxParticipants() {
		return maxParticipants;
	}

	public void setMaxParticipants(Integer maxParticipants) {
		this.maxParticipants = maxParticipants;
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

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCourseLength() {
		return courseLength;
	}

	public void setCourseLength(String courseLength) {
		this.courseLength = courseLength;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}	
	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public StudyProgramme toProgramme() {
		StudyProgramme programme = new StudyProgramme();
		programme.setId(rid);
		programme.setCode(code);
		programme.setName(name);
		programme.setStatus(ApplicationConstant.ACTIVE_STATUS);
		programme.setDescription(description);
		programme.setMaxParticipationCount(maxParticipants);
		programme.setParticipants(participants);
		programme.setProgramDays(programDays);
		programme.setUpdatedAt(new DateTime(DateTime.now()));
		programme.setCreatedAt(new DateTime(DateTime.now()));
		programme.setEndDate(new DateTime(DateTime.now().plusDays(programDays)));
		programme.setCreatedBy(new User(Long.parseLong(createdBy)));
		programme.setUpdatedBy(new User(Long.parseLong(updatedBy)));
		programme.setCategory(new StudyProgrammeCategory(Long.parseLong(category)));
		programme.setCourseLength(new CourseLength(Long.parseLong(courseLength)));
		programme.setDepartment(new Department(Long.parseLong(department)));
		return programme;
	}
}
