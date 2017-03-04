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
import com.bitwise.magnolia.model.student.StudentCourse;
import com.bitwise.magnolia.service.student.StudentCourseService;
import com.bitwise.magnolia.util.StudentCourseList;
import com.bitwise.magnolia.web.restful.exception.ConflictException;
import com.bitwise.magnolia.web.restful.exception.ResourceNotFoundException;
import com.bitwise.magnolia.web.restful.resource.asm.student.StudentCourseListResourceAsm;
import com.bitwise.magnolia.web.restful.resource.asm.student.StudentCourseResourceAsm;
import com.bitwise.magnolia.web.restful.resource.student.StudentCourseListResource;
import com.bitwise.magnolia.web.restful.resource.student.StudentCourseResource;

@RestController
public class StudentCourseController {

	final Logger logger = LoggerFactory.getLogger(StudentCourseController.class);
	
	@Autowired
	private StudentCourseService studentCourseService;
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/students/courses/"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentCourseListResource> findAllStudentCourses(@RequestParam(value="id", required=false) Long id) {
		StudentCourseList studentCourseList = null;
		if (id == null) {
			studentCourseList = studentCourseService.findAllCourses();
		} else {
			StudentCourse studentCourse = studentCourseService.findById(id);
			studentCourseList = new StudentCourseList(new ArrayList<StudentCourse>());
			if (studentCourse == null) {
				studentCourseList = new StudentCourseList(Arrays.asList(studentCourse));
			}
		}
		StudentCourseListResource res = new StudentCourseListResourceAsm().toResource(studentCourseList);
		return new ResponseEntity<StudentCourseListResource>(res, HttpStatus.OK);
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/students/courses/semesters/one/{semesterId}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentCourseListResource> findAllStudentsCoursesBySemestersOne(@PathVariable Long semesterId) {
		StudentCourseList studentCourseList = null;
		studentCourseList = studentCourseService.findAllCoursesOne(semesterId);
		if (studentCourseList != null) {
			StudentCourseListResource res = new StudentCourseListResourceAsm().toResource(studentCourseList);
			return new ResponseEntity<StudentCourseListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<StudentCourseListResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/students/courses/semesters/two/{semesterId}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentCourseListResource> findAllStudentsCoursesBySemestersTwo(@PathVariable Long semesterId) {
		StudentCourseList studentCourseList = null;
		studentCourseList = studentCourseService.findAllCoursesTwo(semesterId);
		if (studentCourseList != null) {
			StudentCourseListResource res = new StudentCourseListResourceAsm().toResource(studentCourseList);
			return new ResponseEntity<StudentCourseListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<StudentCourseListResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/students/courses/registered/one/{semesterId}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentCourseListResource> findAllStudentsCoursesRegisteredBySemestersOne(@PathVariable Long semesterId) {
		StudentCourseList studentCourseList = null;
		studentCourseList = studentCourseService.findAllRegisteredCoursesOne(semesterId, Boolean.TRUE);
		if (studentCourseList != null) {
			StudentCourseListResource res = new StudentCourseListResourceAsm().toResource(studentCourseList);
			return new ResponseEntity<StudentCourseListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<StudentCourseListResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/students/courses/registered/two/{semesterId}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentCourseListResource> findAllStudentsCoursesRegisteredBySemestersTwo(@PathVariable Long semesterId) {
		StudentCourseList studentCourseList = null;
		studentCourseList = studentCourseService.findAllRegisteredCoursesTwo(semesterId, Boolean.TRUE);
		if (studentCourseList != null) {
			StudentCourseListResource res = new StudentCourseListResourceAsm().toResource(studentCourseList);
			return new ResponseEntity<StudentCourseListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<StudentCourseListResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/students/courses/completed/one/{semesterId}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentCourseListResource> findAllStudentsCoursesCompletedBySemestersOne(@PathVariable Long semesterId) {
		StudentCourseList studentCourseList = null;
		studentCourseList = studentCourseService.findAllCompletedCoursesOne(semesterId, ApplicationConstant.COMPLETED_STATUS);
		if (studentCourseList != null) {
			StudentCourseListResource res = new StudentCourseListResourceAsm().toResource(studentCourseList);
			return new ResponseEntity<StudentCourseListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<StudentCourseListResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/students/courses/completed/two/{semesterId}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentCourseListResource> findAllStudentsCoursesCompletedBySemestersTwo(@PathVariable Long semesterId) {
		StudentCourseList studentCourseList = null;
		studentCourseList = studentCourseService.findAllCompletedCoursesOne(semesterId, ApplicationConstant.COMPLETED_STATUS);
		if (studentCourseList != null) {
			StudentCourseListResource res = new StudentCourseListResourceAsm().toResource(studentCourseList);
			return new ResponseEntity<StudentCourseListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<StudentCourseListResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/students/courses/pending/one/{semesterId}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentCourseListResource> findAllStudentsCoursesPendingBySemestersOne(@PathVariable Long semesterId) {
		StudentCourseList studentCourseList = null;
		studentCourseList = studentCourseService.findAllPendingCoursesOne(semesterId, ApplicationConstant.PENDING_STATUS);
		if (studentCourseList != null) {
			StudentCourseListResource res = new StudentCourseListResourceAsm().toResource(studentCourseList);
			return new ResponseEntity<StudentCourseListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<StudentCourseListResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/students/courses/pending/two/{semesterId}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentCourseListResource> findAllStudentsCoursesPendingBySemestersTwo(@PathVariable Long semesterId) {
		StudentCourseList studentCourseList = null;
		studentCourseList = studentCourseService.findAllPendingCoursesTwo(semesterId, ApplicationConstant.PENDING_STATUS);
		if (studentCourseList != null) {
			StudentCourseListResource res = new StudentCourseListResourceAsm().toResource(studentCourseList);
			return new ResponseEntity<StudentCourseListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<StudentCourseListResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/students/courses/{id}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentCourseResource> findStudentCourse(@PathVariable Long id) {
		StudentCourse studentCourse = studentCourseService.findById(id);
		if (studentCourse != null) {
			StudentCourseResource res = new StudentCourseResourceAsm().toResource(studentCourse);
			return new ResponseEntity<StudentCourseResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<StudentCourseResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/students/courses/add"}, 
			method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentCourseResource> createStudentCourse(@RequestBody StudentCourseResource sentStudentCourse) {
		logger.info("Adding student course with ID " + sentStudentCourse.getRid());
		try {
			StudentCourse studentCourse = studentCourseService.save(sentStudentCourse.toStudentCourse());
			StudentCourseResource res = new StudentCourseResourceAsm().toResource(studentCourse);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<StudentCourseResource>(res, headers, HttpStatus.CREATED);
		} catch(EntityExistsException e) {
			throw new ConflictException("Student course already exxists");
		}
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/students/courses/edit/{id}"}, 
			method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentCourseResource> updateStudent(@PathVariable Long id, @RequestBody StudentCourseResource studentCourse) {
		logger.info("Updating student course with ID " + studentCourse.getRid());
		try {
			StudentCourse updatedStudentCourse = studentCourseService.findById(id);
			if (updatedStudentCourse != null) {
				updatedStudentCourse = studentCourseService.save(studentCourse.toStudentCourse());
				StudentCourseResource res = new StudentCourseResourceAsm().toResource(updatedStudentCourse);
				return new ResponseEntity<StudentCourseResource>(res, HttpStatus.OK);
			} else {
				return new ResponseEntity<StudentCourseResource>(HttpStatus.NOT_FOUND);
			}
		} catch(EntityDoesNotExistException e) {
			throw new ResourceNotFoundException("Student course does not exist");
		}
	}
}
