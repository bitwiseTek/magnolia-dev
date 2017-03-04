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

public class CampusListResource extends ResourceSupport {

	private List<CampusResource> campuses = new ArrayList<CampusResource>();

	public List<CampusResource> getCampuses() {
		return campuses;
	}

	public void setCampuses(List<CampusResource> campuses) {
		this.campuses = campuses;
	}
}
