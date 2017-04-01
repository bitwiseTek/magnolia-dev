package com.bitwise.magnolia.util.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.bitwise.magnolia.model.student.StudentCourse;
import com.bitwise.magnolia.service.student.StudentCourseService;

@Component
public class StudentToSubjectConverter implements Converter<Object, StudentCourse> {

	@Autowired
	private StudentCourseService courseStudentService;
	
	@Override
	public StudentCourse convert(Object element) {
		Long id = Long.parseLong((String)element);
		StudentCourse student = courseStudentService.findById(id);
		System.out.println("Student: " +student);
		return student;
	}

}
