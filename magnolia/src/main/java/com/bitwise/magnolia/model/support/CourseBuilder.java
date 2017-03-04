package com.bitwise.magnolia.model.support;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.bitwise.magnolia.model.common.AcademicSemester;
import com.bitwise.magnolia.model.common.StudyProgramme;
import com.bitwise.magnolia.model.course.Course;
import com.bitwise.magnolia.model.staff.Staff;
import com.bitwise.magnolia.model.user.User;

@Component
public class CourseBuilder extends EntityBuilder<Course> {

	@Override
	void initProduct() {
		this.product = new Course();
	}
	
	public CourseBuilder user(User createdBy, User updatedBy) {
		this.product.setCreatedBy(createdBy);
		this.product.setUpdatedBy(updatedBy);
		return this;
	}
	
	public CourseBuilder staff(Staff courseLecturer) {
		this.product.setCourseLecturer(courseLecturer);
		return this;
	}
	
	public CourseBuilder programme(StudyProgramme programme) {
		this.product.setStudyProgramme(programme);
		return this;
	}
	
	public CourseBuilder semester(AcademicSemester semester) {
		this.product.setSemester(semester);
		return this;
	}
	
	public CourseBuilder course(String name, String status, String code, String description, String optionality, 
			Integer academicLevel, Double creditUnit, DateTime createdAt, DateTime updatedAt) {
		this.product.setName(name);
		this.product.setCode(code);
		this.product.setStatus(status);
		this.product.setDescription(description);
		this.product.setOptionality(optionality);
		this.product.setAcademicLevel(academicLevel);
		this.product.setCreditUnit(creditUnit);
		this.product.setCreatedAt(createdAt);
		this.product.setUpdatedAt(updatedAt);
		return this;
	}

	@Override
	Course assembleProduct() {
		return this.product;
	}

}
