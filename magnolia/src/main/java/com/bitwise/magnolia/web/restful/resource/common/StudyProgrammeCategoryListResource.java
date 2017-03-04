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

public class StudyProgrammeCategoryListResource extends ResourceSupport {

	private List<StudyProgrammeCategoryResource> categories = new ArrayList<StudyProgrammeCategoryResource>();

	public List<StudyProgrammeCategoryResource> getCategories() {
		return categories;
	}

	public void setCategories(List<StudyProgrammeCategoryResource> categories) {
		this.categories = categories;
	}
}
