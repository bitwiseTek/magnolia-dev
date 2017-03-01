package com.bitwise.magnolia.web.restful.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bitwise.magnolia.service.student.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
}
