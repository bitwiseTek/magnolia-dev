package com.bitwise.magnolia.model.support;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.bitwise.magnolia.model.common.StudyProgramme;
import com.bitwise.magnolia.model.school.Department;
import com.bitwise.magnolia.model.student.Student;
import com.bitwise.magnolia.model.user.User;

@Component
public class StudentBuilder extends EntityBuilder<Student> {

	@Override
	void initProduct() {
		this.product = new Student();
	}
	
	public StudentBuilder user(User user) {
		this.product.setUser(user);
		return this;
	}
	
	public StudentBuilder programme(StudyProgramme programme) {
		this.product.setStudyProgramme(programme);
		return this;
	}
	
	public StudentBuilder department(Department dept) {
		this.product.setStudentDepartment(dept);
		return this;
	}
	
	public StudentBuilder student(String studentId, String studyEndReason, String studyEndText, String studyStatus, Boolean lodging, 
			String participationType, String enrolmentType, String apiKey, String status, DateTime startDate, DateTime actualEndDate,
			DateTime programmeEndDate) {
		this.product.setStudentId(studentId);
		this.product.setStudyEndReason(studyEndReason);
		this.product.setStudyEndText(studyEndText);
		this.product.setStudyStatus(studyStatus);
		this.product.setLodging(lodging);
		this.product.setParticipationType(participationType);
		this.product.setCourseEnrolmentType(enrolmentType);
		this.product.setApiKey(apiKey);
		this.product.setStatus(status);
		this.product.setStartDate(startDate);
		this.product.setActualEndDate(actualEndDate);
		this.product.setProgrammeEndDate(programmeEndDate);
		return this;
	}

	@Override
	Student assembleProduct() {
		return this.product;
	}

}
