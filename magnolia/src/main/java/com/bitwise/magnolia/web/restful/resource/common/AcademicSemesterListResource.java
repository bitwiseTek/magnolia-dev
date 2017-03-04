package com.bitwise.magnolia.web.restful.resource.common;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class AcademicSemesterListResource extends ResourceSupport {

	private List<AcademicSemesterResource> semesters = new ArrayList<AcademicSemesterResource>();

	public List<AcademicSemesterResource> getSemesters() {
		return semesters;
	}

	public void setSemesters(List<AcademicSemesterResource> semesters) {
		this.semesters = semesters;
	}
}
