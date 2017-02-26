package com.bitwise.magnolia.web.restful.resource.school;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class FacultyListResource extends ResourceSupport {

	private List<FacultyResource> faculties = new ArrayList<FacultyResource>();

	public List<FacultyResource> getFaculties() {
		return faculties;
	}

	public void setFaculties(List<FacultyResource> faculties) {
		this.faculties = faculties;
	}
}
