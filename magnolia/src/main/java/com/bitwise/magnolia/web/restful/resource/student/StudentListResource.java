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

public class StudentListResource extends ResourceSupport {

	private List<StudentResource> students = new ArrayList<StudentResource>();

	public List<StudentResource> getStudents() {
		return students;
	}

	public void setStudents(List<StudentResource> students) {
		this.students = students;
	}
}
