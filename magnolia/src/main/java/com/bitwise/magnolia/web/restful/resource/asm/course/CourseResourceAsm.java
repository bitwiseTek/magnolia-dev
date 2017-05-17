package com.bitwise.magnolia.web.restful.resource.asm.course;
/**
 *  
 * @author Sika Kay
 * @date 03/03/17
 *
 */
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.model.course.Course;
import com.bitwise.magnolia.web.restful.controller.course.CourseController;
import com.bitwise.magnolia.web.restful.resource.course.CourseResource;

public class CourseResourceAsm extends ResourceAssemblerSupport<Course, CourseResource> {

	public CourseResourceAsm() {
		super(CourseController.class, CourseResource.class);
	}
	
	@Override
	public CourseResource toResource(Course course) {
		CourseResource res = new CourseResource();
		res.setRid(course.getId());
		res.setCode(course.getCode());
		res.setName(course.getName());
		res.setDescription(course.getDescription());
		res.setOptionality(course.getOptionality());
		res.setAcademicLevel(course.getAcademicLevel());
		res.setCreditUnit(course.getCreditUnit());
		res.setStatus(course.getStatus());
		res.setCreatedAt(course.getCreatedAtString());
		res.setUpdatedAt(course.getUpdatedAtString());
		res.setCreatedBy(course.getUpdatedBy().getUsername());
		res.setUpdatedBy(course.getUpdatedBy().getUsername());
		res.setSemester(course.getSemester().getName());
		//res.setCourseLecturer(course.getCourseLecturer().getUser().getFullName());
		res.setStudyProgramme(course.getStudyProgramme().getName());
		res.add(linkTo(methodOn(CourseController.class).findCourse(course.getId())).withSelfRel());
		return res;
	}

}
