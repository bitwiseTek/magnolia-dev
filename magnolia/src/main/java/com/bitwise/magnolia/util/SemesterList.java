package com.bitwise.magnolia.util;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import com.bitwise.magnolia.model.common.AcademicSemester;

public class SemesterList {

	public SemesterList(List<AcademicSemester> semesters) {
		this.semesters = semesters;
	}
	
	private List<AcademicSemester> semesters = new ArrayList<AcademicSemester>();

	public List<AcademicSemester> getSemesters() {
		return semesters;
	}

	public void setSemesters(List<AcademicSemester> semesters) {
		this.semesters = semesters;
	}
}
