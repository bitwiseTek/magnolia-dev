package com.bitwise.magnolia.web.restful.resource.student;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import org.joda.time.DateTime;
import org.springframework.hateoas.ResourceSupport;

import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.common.Utils;
import com.bitwise.magnolia.model.common.StudyProgramme;
import com.bitwise.magnolia.model.school.Department;
import com.bitwise.magnolia.model.student.Student;
import com.bitwise.magnolia.model.user.User;

public class StudentResource extends ResourceSupport {

	public StudentResource() {
		
	}
	
	private Long rid;
	
	private String apiKey;
	
	private String enrolmentType;
	
	private Boolean lodging;
	
	private String partType;
	
	private String programmeEndDate;
	
	private String actualEndDate;
	
	private String startDate;
	
	private String status;
	
	private String studentId;
	
	private String endReason;
	
	private String endText;
	
	private String studyStatus;
	
	private String studyProgramme;
	
	private String studentDepartment;
	
	private String user;

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getEnrolmentType() {
		return enrolmentType;
	}

	public void setEnrolmentType(String enrolmentType) {
		this.enrolmentType = enrolmentType;
	}

	public Boolean getLodging() {
		return lodging;
	}

	public void setLodging(Boolean lodging) {
		this.lodging = lodging;
	}

	public String getPartType() {
		return partType;
	}

	public void setPartType(String partType) {
		this.partType = partType;
	}

	public String getProgrammeEndDate() {
		return programmeEndDate;
	}

	public void setProgrammeEndDate(String programmeEndDate) {
		this.programmeEndDate = programmeEndDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getActualEndDate() {
		return actualEndDate;
	}

	public void setActualEndDate(String actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getEndReason() {
		return endReason;
	}

	public void setEndReason(String endReason) {
		this.endReason = endReason;
	}

	public String getEndText() {
		return endText;
	}

	public void setEndText(String endText) {
		this.endText = endText;
	}

	public String getStudyStatus() {
		return studyStatus;
	}

	public void setStudyStatus(String studyStatus) {
		this.studyStatus = studyStatus;
	}

	public String getStudyProgramme() {
		return studyProgramme;
	}

	public void setStudyProgramme(String studyProgramme) {
		this.studyProgramme = studyProgramme;
	}

	public String getStudentDepartment() {
		return studentDepartment;
	}

	public void setStudentDepartment(String studentDepartment) {
		this.studentDepartment = studentDepartment;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public Student toStudent() {
		Student student = new Student();
		student.setId(rid);
		student.setApiKey(Utils.randomString(30));
		student.setStatus(status);
		student.setStudyEndReason(endReason);
		student.setStudyEndText(endText);
		student.setStudentId("STD".concat("/").concat(org.joda.time.format.DateTimeFormat.forPattern("yyyy").print(new DateTime(DateTime.now()))).concat("/").concat(new Department().getCode()).concat("/").concat(new User().getId().toString()));
		student.setCourseEnrolmentType(enrolmentType);
		student.setParticipationType(partType);
		student.setStartDate(new DateTime(DateTime.now()));
		student.setProgrammeEndDate(new StudyProgramme().getEndDate());
		student.setStudyStatus(ApplicationConstant.INVIEW_STATUS);
		student.setActualEndDate(new StudyProgramme().getEndDate());
		student.setLodging(Boolean.TRUE);
		student.setStudyProgramme(new StudyProgramme(Long.parseLong(studyProgramme)));
		student.setStudentDepartment(new Department(Long.parseLong(studentDepartment)));
		student.setUser(new User(Long.parseLong(user)));
		return student;
	}
}
