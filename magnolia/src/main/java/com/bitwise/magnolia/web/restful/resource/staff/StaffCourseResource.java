package com.bitwise.magnolia.web.restful.resource.staff;
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
import com.bitwise.magnolia.model.staff.StaffCourse;

public class StaffCourseResource extends ResourceSupport {

	public StaffCourseResource() {
		
	}
	
	private Long rid;
	
	private String courseStatus;
	
	private String startDate;
	
	private String endDate;
	
	private Boolean toggleOnOff;
	
	private String course;

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
	
	public StaffCourse toStaffCourse() {
		StaffCourse staffCourse = new StaffCourse();
		staffCourse.setId(rid);
		staffCourse.setCourseStatus(ApplicationConstant.PENDING_STATUS);
		staffCourse.setStartDate(new DateTime(DateTime.now()));
		staffCourse.setEndDate(new DateTime(DateTime.now().plusDays(90)));
		staffCourse.setCourse(new Course(Long.parseLong(course)));
		staffCourse.setToggleOnOff(Boolean.FALSE);
		return staffCourse;
	}
}
