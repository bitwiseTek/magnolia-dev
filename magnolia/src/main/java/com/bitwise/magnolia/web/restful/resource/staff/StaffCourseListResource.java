package com.bitwise.magnolia.web.restful.resource.staff;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class StaffCourseListResource extends ResourceSupport {

	private List<StaffCourseResource> staffCourses = new ArrayList<StaffCourseResource>();

	public List<StaffCourseResource> getStaffCourses() {
		return staffCourses;
	}

	public void setStaffCourses(List<StaffCourseResource> staffCourses) {
		this.staffCourses = staffCourses;
	}
}
