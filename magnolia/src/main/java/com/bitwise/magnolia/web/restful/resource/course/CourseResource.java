package com.bitwise.magnolia.web.restful.resource.course;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import org.joda.time.DateTime;
import org.springframework.hateoas.ResourceSupport;

import com.bitwise.magnolia.model.common.AcademicSemester;
import com.bitwise.magnolia.model.common.StudyProgramme;
import com.bitwise.magnolia.model.course.Course;
import com.bitwise.magnolia.model.staff.Staff;
import com.bitwise.magnolia.model.user.User;

public class CourseResource extends ResourceSupport {

	public CourseResource() {
		
	}
	
	private Long rid;
	
	private String name;
	
	private String code;
	
	private String status;
	
	private String description;
	
	private Integer academicLevel;
	
	private Double creditUnit;
	
	private String optionality;
	
	private String createdAt;
	
	private String updatedAt;
	
	private String createdBy;
	
	private String updatedBy;
	
	private String courseLecturer;
	
	private String semester;
	
	private String studyProgramme;

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

	public Integer getAcademicLevel() {
		return academicLevel;
	}

	public void setAcademicLevel(Integer academicLevel) {
		this.academicLevel = academicLevel;
	}

	public Double getCreditUnit() {
		return creditUnit;
	}

	public void setCreditUnit(Double creditUnit) {
		this.creditUnit = creditUnit;
	}

	public String getOptionality() {
		return optionality;
	}

	public void setOptionality(String optionality) {
		this.optionality = optionality;
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

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getCourseLecturer() {
		return courseLecturer;
	}

	public void setCourseLecturer(String courseLecturer) {
		this.courseLecturer = courseLecturer;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getStudyProgramme() {
		return studyProgramme;
	}

	public void setStudyProgramme(String studyProgramme) {
		this.studyProgramme = studyProgramme;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Course toCourse() {
		Course course = new Course();
		course.setId(rid);
		course.setCode(code);
		course.setName(name);
		course.setStatus(status);
		course.setDescription(description);
		course.setAcademicLevel(academicLevel);
		course.setOptionality(optionality);
		course.setCreditUnit(creditUnit);
		course.setCreatedAt(new DateTime(DateTime.now()));
		course.setUpdatedAt(new DateTime(DateTime.now()));
		course.setCreatedBy(new User(Long.parseLong(createdBy)));
		course.setUpdatedBy(new User(Long.parseLong(updatedBy)));
		course.setCourseLecturer(new Staff(Long.parseLong(courseLecturer)));
		course.setSemester(new AcademicSemester(Long.parseLong(semester)));
		course.setStudyProgramme(new StudyProgramme(Long.parseLong(studyProgramme)));
		return course;
	}
}
