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
import com.bitwise.magnolia.model.common.StudyProgrammeCategory;
import com.bitwise.magnolia.model.course.CourseLength;
import com.bitwise.magnolia.model.school.Department;
import com.bitwise.magnolia.model.user.User;

@Component
public class StudyProgrammeBuilder extends EntityBuilder<StudyProgramme> {

	@Override
	void initProduct() {
		this.product = new StudyProgramme();
	}
	
	public StudyProgrammeBuilder category(StudyProgrammeCategory category) {
		this.product.setCategory(category);
		return this;
	}
	
	public StudyProgrammeBuilder courseLength(CourseLength courseLength) {
		this.product.setCourseLength(courseLength);
		return this;
	}
	
	public StudyProgrammeBuilder department(Department department) {
		this.product.setDepartment(department);
		return this;
	}
	
	public StudyProgrammeBuilder user(User createdBy, User updatedBy) {
		this.product.setCreatedBy(createdBy);
		this.product.setUpdatedBy(updatedBy);
		return this;
	}
	
	public StudyProgrammeBuilder programme(String name, String status, String code, String description,  Integer participants, 
			Integer maxParticipationCount, DateTime createdAt, DateTime updatedAt, Integer programDays, DateTime endDate) {
		this.product.setName(name);
		this.product.setStatus(status);
		this.product.setCode(code);
		this.product.setDescription(description);
		this.product.setParticipants(participants);
		this.product.setMaxParticipationCount(maxParticipationCount);
		this.product.setCreatedAt(createdAt);
		this.product.setUpdatedAt(updatedAt);
		this.product.setProgramDays(programDays);
		this.product.setEndDate(endDate);
		return this;
	}

	@Override
	StudyProgramme assembleProduct() {
		return this.product;
	}

}
