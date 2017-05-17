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
import com.bitwise.magnolia.model.course.Course;
import com.bitwise.magnolia.model.finance.BillingDetails;
import com.bitwise.magnolia.model.student.StudentCourse;

public class StudentCourseResource extends ResourceSupport {

	public StudentCourseResource() {
		
	}
	
	private Long rid;
	
	private String courseStatus;
	
	private String startDate;
	
	private String endDate;
	
	private Boolean toggleOnOff;
	
	private String course;
	
	private String billing;

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Boolean getToggleOnOff() {
		return toggleOnOff;
	}

	public void setToggleOnOff(Boolean toggleOnOff) {
		this.toggleOnOff = toggleOnOff;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	public String getBilling() {
		return billing;
	}

	public void setBilling(String billing) {
		this.billing = billing;
	}

	public StudentCourse toStudentCourse() {
		StudentCourse studentCourse = new StudentCourse();
		studentCourse.setId(rid);
		studentCourse.setCourseStatus(ApplicationConstant.PENDING_STATUS);
		studentCourse.setStartDate(new DateTime(DateTime.now()));
		studentCourse.setEndDate(new DateTime(DateTime.now().plusDays(90)));
		studentCourse.setCourse(new Course(Long.parseLong(course)));
		studentCourse.setToggleOnOff(Boolean.FALSE);
		studentCourse.setBilling(new BillingDetails(Long.parseLong(billing)));
		return studentCourse;
	}
}
