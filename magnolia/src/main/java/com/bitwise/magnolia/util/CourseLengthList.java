package com.bitwise.magnolia.util;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import com.bitwise.magnolia.model.course.CourseLength;

public class CourseLengthList {
	
	public CourseLengthList(List<CourseLength> lengths) {
		this.lengths = lengths;
	}

	private List<CourseLength> lengths = new ArrayList<CourseLength>();

	public List<CourseLength> getLengths() {
		return lengths;
	}

	public void setLengths(List<CourseLength> lengths) {
		this.lengths = lengths;
	}
}
