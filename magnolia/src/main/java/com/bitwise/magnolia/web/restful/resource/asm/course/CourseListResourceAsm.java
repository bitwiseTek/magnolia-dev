package com.bitwise.magnolia.web.restful.resource.asm.course;
/**
 *  
 * @author Sika Kay
 * @date 03/03/17
 *
 */
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.util.CourseList;
import com.bitwise.magnolia.web.restful.controller.course.CourseController;
import com.bitwise.magnolia.web.restful.resource.course.CourseListResource;
import com.bitwise.magnolia.web.restful.resource.course.CourseResource;

public class CourseListResourceAsm extends ResourceAssemblerSupport<CourseList, CourseListResource>{

	public CourseListResourceAsm() {
		super(CourseController.class, CourseListResource.class);
	}
	
	@Override
	public CourseListResource toResource(CourseList courseList) {
		List<CourseResource> resList = new CourseResourceAsm().toResources(courseList.getCourses());
		CourseListResource finalRes = new CourseListResource();
		finalRes.setCourses(resList);
		return finalRes;
	}

}
