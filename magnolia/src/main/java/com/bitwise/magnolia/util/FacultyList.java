package com.bitwise.magnolia.util;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import com.bitwise.magnolia.model.school.Faculty;

public class FacultyList {

	public FacultyList(List<Faculty> faculties) {
		this.faculties = faculties;
	}
	
	private List<Faculty> faculties = new ArrayList<Faculty>();

	public List<Faculty> getFaculties() {
		return faculties;
	}

	public void setFaculties(List<Faculty> faculties) {
		this.faculties = faculties;
	}
}
