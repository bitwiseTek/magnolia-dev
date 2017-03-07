package com.bitwise.magnolia.util;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import com.bitwise.magnolia.model.staff.StaffCourse;

public class StaffCourseList {

	public StaffCourseList(List<StaffCourse> staffCourse) {
		this.staffCourse = staffCourse;
	}
	private List<StaffCourse> staffCourse = new ArrayList<StaffCourse>();
	
	public List<StaffCourse> getStaffCourse() {
		return staffCourse;
	}
	public void setStaffCourse(List<StaffCourse> staffCourse) {
		this.staffCourse = staffCourse;
	}
}
