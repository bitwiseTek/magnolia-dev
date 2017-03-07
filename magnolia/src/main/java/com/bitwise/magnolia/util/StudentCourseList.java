package com.bitwise.magnolia.util;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import com.bitwise.magnolia.model.student.StudentCourse;

public class StudentCourseList {
	
	public StudentCourseList(List<StudentCourse> studentCourses) {
		this.studentCourses = studentCourses;
	}

	private List<StudentCourse> studentCourses = new ArrayList<StudentCourse>();

	public List<StudentCourse> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCourses(List<StudentCourse> studentCourses) {
		this.studentCourses = studentCourses;
	}
}
