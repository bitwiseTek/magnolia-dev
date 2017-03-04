package com.bitwise.magnolia.web.restful.resource.student;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class StudentCourseListResource extends ResourceSupport {

	private List<StudentCourseResource> studentCourses = new ArrayList<StudentCourseResource>();

	public List<StudentCourseResource> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCourses(List<StudentCourseResource> studentCourses) {
		this.studentCourses = studentCourses;
	}
}
