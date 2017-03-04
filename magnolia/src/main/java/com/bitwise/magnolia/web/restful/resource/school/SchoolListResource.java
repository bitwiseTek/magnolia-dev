package com.bitwise.magnolia.web.restful.resource.school;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class SchoolListResource extends ResourceSupport {

	private List<SchoolResource> schoolResources = new ArrayList<SchoolResource>();

	public List<SchoolResource> getSchoolResources() {
		return schoolResources;
	}

	public void setSchoolResources(List<SchoolResource> schoolResources) {
		this.schoolResources = schoolResources;
	}
}
