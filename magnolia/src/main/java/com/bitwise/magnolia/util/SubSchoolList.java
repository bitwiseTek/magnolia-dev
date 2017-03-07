package com.bitwise.magnolia.util;
/**
 *  
 * @author Sika Kay
 * @date 01/03/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import com.bitwise.magnolia.model.school.SubSchool;

public class SubSchoolList {

	public SubSchoolList(List<SubSchool> subSchools) {
		this.subSchools = subSchools;
	}
	
	private List<SubSchool> subSchools = new ArrayList<SubSchool>();

	public List<SubSchool> getSubSchools() {
		return subSchools;
	}

	public void setSubSchools(List<SubSchool> subSchools) {
		this.subSchools = subSchools;
	}
}
