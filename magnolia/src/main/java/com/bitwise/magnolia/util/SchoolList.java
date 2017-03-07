package com.bitwise.magnolia.util;
/**
 *  
 * @author Sika Kay
 * @date 01/03/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import com.bitwise.magnolia.model.school.School;

public class SchoolList {

	public SchoolList(List<School> schools) {
		this.schools = schools;
	}
	private List<School> schools = new ArrayList<School>();
	public List<School> getSchools() {
		return schools;
	}
	public void setSchools(List<School> schools) {
		this.schools = schools;
	}
}
