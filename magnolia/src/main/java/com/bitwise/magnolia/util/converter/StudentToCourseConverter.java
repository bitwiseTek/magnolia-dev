package com.bitwise.magnolia.util.converter;
/**
 *  
 * @author Sika Kay
 * @date 31/03/17
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.bitwise.magnolia.model.student.Student;
import com.bitwise.magnolia.service.student.StudentService;

@Component
public class StudentToCourseConverter implements Converter<Object, Student> {

	@Autowired
	private StudentService studentService;
	
	@Override
	public Student convert(Object element) {
		Long id = Long.parseLong((String)element);
		Student student = studentService.findById(id);
		System.out.println("Student: " + student);
		return student;
	}

}
