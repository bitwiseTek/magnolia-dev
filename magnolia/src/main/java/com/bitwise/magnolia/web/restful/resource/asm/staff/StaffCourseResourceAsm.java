package com.bitwise.magnolia.web.restful.resource.asm.staff;
/**
 *  
 * @author Sika Kay
 * @date 04/03/17
 *
 */
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.model.staff.StaffCourse;
import com.bitwise.magnolia.web.restful.controller.staff.StaffCourseController;
import com.bitwise.magnolia.web.restful.resource.staff.StaffCourseResource;

public class StaffCourseResourceAsm extends ResourceAssemblerSupport<StaffCourse, StaffCourseResource> {

	public StaffCourseResourceAsm() {
		super(StaffCourseController.class, StaffCourseResource.class);
	}
	
	@Override
	public StaffCourseResource toResource(StaffCourse staffCourse) {
		StaffCourseResource res = new StaffCourseResource();
		res.setRid(staffCourse.getId());
		res.setToggleOnOff(staffCourse.getToggleOnOff());
		res.setCourseStatus(staffCourse.getCourseStatus());
		res.setStartDate(staffCourse.getStartDateString());
		res.setEndDate(staffCourse.getEndDateString());
		res.setCourse(staffCourse.getCourse().getName());
		return res;
	}

}
