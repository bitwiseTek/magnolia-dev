package com.bitwise.magnolia.util;
/**
 *  
 * @author Sika Kay
 * @date 01/03/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import com.bitwise.magnolia.model.common.StudyProgrammeCategory;

public class ProgrammeCategoryList {

	public ProgrammeCategoryList(List<StudyProgrammeCategory> categories) {
		this.categories = categories;
	}
	
	private List<StudyProgrammeCategory> categories = new ArrayList<StudyProgrammeCategory>();

	public List<StudyProgrammeCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<StudyProgrammeCategory> categories) {
		this.categories = categories;
	}
}
