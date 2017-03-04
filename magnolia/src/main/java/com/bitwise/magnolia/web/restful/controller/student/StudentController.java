package com.bitwise.magnolia.web.restful.controller.student;
/**
 *  
 * @author Sika Kay
 * @date 04/03/17
 *
 */
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.exception.EntityDoesNotExistException;
import com.bitwise.magnolia.exception.EntityExistsException;
import com.bitwise.magnolia.model.student.Student;
import com.bitwise.magnolia.service.student.StudentService;
import com.bitwise.magnolia.util.StudentList;
import com.bitwise.magnolia.web.restful.exception.ConflictException;
import com.bitwise.magnolia.web.restful.exception.ResourceNotFoundException;
import com.bitwise.magnolia.web.restful.resource.asm.student.StudentListResourceAsm;
import com.bitwise.magnolia.web.restful.resource.asm.student.StudentResourceAsm;
import com.bitwise.magnolia.web.restful.resource.student.StudentListResource;
import com.bitwise.magnolia.web.restful.resource.student.StudentResource;

@RestController
public class StudentController {
	
	final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/students/"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentListResource> findAllStudents(@RequestParam(value="studentId", required=false) String studentId) {
		StudentList studentList = null;
		if (studentId == null) {
			studentList = studentService.findAllStudents();
		} else {
			Student student = studentService.findByStudentId(studentId);
			studentList = new StudentList(new ArrayList<Student>());
			if (student == null) {
				studentList = new StudentList(Arrays.asList(student));
			}
		}
		StudentListResource res = new StudentListResourceAsm().toResource(studentList);
		return new ResponseEntity<StudentListResource>(res, HttpStatus.OK);
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/students/{id}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResource> findStudent(@PathVariable Long id) {
		Student student = studentService.findById(id);
		if (student != null) {
			StudentResource res = new StudentResourceAsm().toResource(student);
			return new ResponseEntity<StudentResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<StudentResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/students/departments/{deptId}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentListResource> findAllStudentsByDepartments(@PathVariable Long deptId) {
		StudentList studentList = null;
		studentList = studentService.findStudentsByDepartmentId(deptId);
		if (studentList != null) {
			StudentListResource res = new StudentListResourceAsm().toResource(studentList);
			return new ResponseEntity<StudentListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<StudentListResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/students/programmes/{programmeId}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentListResource> findAllStudentsByProgrammess(@PathVariable Long programmeId) {
		StudentList studentList = null;
		studentList = studentService.findStudentsByProgrammeId(programmeId);
		if (studentList != null) {
			StudentListResource res = new StudentListResourceAsm().toResource(studentList);
			return new ResponseEntity<StudentListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<StudentListResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/students/add"}, 
			method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResource> createStudent(@RequestBody StudentResource sentStudent) {
		logger.info("Adding student with ID " + sentStudent.getRid());
		try {
			Student student = studentService.save(sentStudent.toStudent());
			StudentResource res = new StudentResourceAsm().toResource(student);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<StudentResource>(res, headers, HttpStatus.CREATED);
		} catch(EntityExistsException e) {
			throw new ConflictException("Student already exxists");
		}
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/students/edit/{id}"}, 
			method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResource> updateStudent(@PathVariable Long id, @RequestBody StudentResource student) {
		logger.info("Updating student with ID " + student.getRid());
		try {
			Student updatedStudent = studentService.findById(id);
			if (updatedStudent != null) {
				updatedStudent = studentService.save(student.toStudent());
				StudentResource res = new StudentResourceAsm().toResource(updatedStudent);
				return new ResponseEntity<StudentResource>(res, HttpStatus.OK);
			} else {
				return new ResponseEntity<StudentResource>(HttpStatus.NOT_FOUND);
			}
		} catch(EntityDoesNotExistException e) {
			throw new ResourceNotFoundException("Student does not exist");
		}
	}
	
}
