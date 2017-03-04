package com.bitwise.magnolia.web.restful.resource.course;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class CourseListResource extends ResourceSupport {

	private List<CourseResource> courses = new ArrayList<CourseResource>();

	public List<CourseResource> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseResource> courses) {
		this.courses = courses;
	}
}
