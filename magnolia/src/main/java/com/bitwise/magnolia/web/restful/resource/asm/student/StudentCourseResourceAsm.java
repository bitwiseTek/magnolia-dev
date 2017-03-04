package com.bitwise.magnolia.web.restful.resource.asm.student;
/**
 *  
 * @author Sika Kay
 * @date 04/03/17
 *
 */
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.model.student.StudentCourse;
import com.bitwise.magnolia.web.restful.controller.student.StudentCourseController;
import com.bitwise.magnolia.web.restful.resource.student.StudentCourseResource;

public class StudentCourseResourceAsm extends ResourceAssemblerSupport<StudentCourse, StudentCourseResource> {

	public StudentCourseResourceAsm() {
		super(StudentCourseController.class, StudentCourseResource.class);
	}
	
	@Override
	public StudentCourseResource toResource(StudentCourse studentCourse) {
		StudentCourseResource res = new StudentCourseResource();
		res.setRid(studentCourse.getId());
		res.setToggleOnOff(studentCourse.getToggleOnOff());
		res.setCourseStatus(studentCourse.getCourseStatus());
		res.setStartDate(studentCourse.getStartDateString());
		res.setEndDate(studentCourse.getEndDateString());
		res.setCourse(studentCourse.getCourse().getName());
		res.add(linkTo(methodOn(StudentCourseController.class).findStudentCourse(studentCourse.getId())).withSelfRel());
		return res;
	}

}
