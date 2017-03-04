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

public class CourseLengthListResource extends ResourceSupport {

	private List<CourseLengthResource> lengths = new ArrayList<CourseLengthResource>();

	public List<CourseLengthResource> getLengths() {
		return lengths;
	}

	public void setLengths(List<CourseLengthResource> lengths) {
		this.lengths = lengths;
	}
}
