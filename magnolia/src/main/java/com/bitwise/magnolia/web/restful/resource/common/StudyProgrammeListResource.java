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

public class StudyProgrammeListResource extends ResourceSupport {

	private List<StudyProgrammeResource> programmes = new ArrayList<StudyProgrammeResource>();

	public List<StudyProgrammeResource> getProgrammes() {
		return programmes;
	}

	public void setProgrammes(List<StudyProgrammeResource> programmes) {
		this.programmes = programmes;
	}
}
