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

public class SubSchoolListResource extends ResourceSupport {

	private List<SubSchoolResource> schools = new ArrayList<SubSchoolResource>();

	public List<SubSchoolResource> getSchools() {
		return schools;
	}

	public void setSchools(List<SubSchoolResource> schools) {
		this.schools = schools;
	}
}
