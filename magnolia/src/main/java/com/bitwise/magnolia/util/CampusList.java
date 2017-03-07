package com.bitwise.magnolia.util;
/**
 *  
 * @author Sika Kay
 * @date 01/03/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import com.bitwise.magnolia.model.school.Campus;

public class CampusList {

	public CampusList(List<Campus> campuses) {
		this.campuses = campuses;
	}
	
	private List<Campus> campuses = new ArrayList<Campus>();

	public List<Campus> getCampuses() {
		return campuses;
	}

	public void setCampuses(List<Campus> campuses) {
		this.campuses = campuses;
	}
}
