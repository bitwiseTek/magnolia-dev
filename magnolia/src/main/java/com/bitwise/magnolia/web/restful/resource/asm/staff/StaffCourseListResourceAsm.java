package com.bitwise.magnolia.web.restful.resource.asm.staff;
/**
 *  
 * @author Sika Kay
 * @date 04/03/17
 *
 */
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.util.StaffCourseList;
import com.bitwise.magnolia.web.restful.controller.staff.StaffCourseController;
import com.bitwise.magnolia.web.restful.resource.staff.StaffCourseListResource;
import com.bitwise.magnolia.web.restful.resource.staff.StaffCourseResource;

public class StaffCourseListResourceAsm extends ResourceAssemblerSupport<StaffCourseList, StaffCourseListResource> {

	public StaffCourseListResourceAsm() {
		super(StaffCourseController.class, StaffCourseListResource.class);
	}

	@Override
	public StaffCourseListResource toResource(StaffCourseList staffCourseList) {
		List<StaffCourseResource> resList = new StaffCourseResourceAsm().toResources(staffCourseList.getStaffCourse());
		StaffCourseListResource finalRes = new StaffCourseListResource();
		finalRes.setStaffCourses(resList);
		return finalRes;
	}
}
