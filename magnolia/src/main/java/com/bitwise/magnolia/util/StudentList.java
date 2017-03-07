package com.bitwise.magnolia.util;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import com.bitwise.magnolia.model.student.Student;

public class StudentList {

	public StudentList(List<Student> students) {
		this.students = students;
	}
	
	private List<Student> students = new ArrayList<Student>();

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
