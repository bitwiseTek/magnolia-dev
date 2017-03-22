package com.bitwise.magnolia.web.restful.controller.course;
/**
 *  
 * @author Sika Kay
 * @date 03/03/17
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
import com.bitwise.magnolia.model.course.Course;
import com.bitwise.magnolia.service.course.CourseService;
import com.bitwise.magnolia.util.CourseList;
import com.bitwise.magnolia.web.restful.exception.ConflictException;
import com.bitwise.magnolia.web.restful.exception.ErrorDetail;
import com.bitwise.magnolia.web.restful.exception.ResourceNotFoundException;
import com.bitwise.magnolia.web.restful.resource.asm.course.CourseListResourceAsm;
import com.bitwise.magnolia.web.restful.resource.asm.course.CourseResourceAsm;
import com.bitwise.magnolia.web.restful.resource.course.CourseListResource;
import com.bitwise.magnolia.web.restful.resource.course.CourseResource;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@RestController
@Api(value="courses", description="Course API")
public class CourseController {

	final Logger logger = LoggerFactory.getLogger(CourseController.class);
	
	@Autowired
	private CourseService courseService;
	
	@ApiOperation(value="Retrieves all the courses", response=Course.class, responseContainer="List")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/courses/"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CourseListResource> findAllCourses(@RequestParam(value="name", required=false) String name) {
		CourseList courseList = null;
		if (name == null) {
			courseList = courseService.findAllCourses();
		} else {
			Course course = courseService.findByName(name);
			courseList = new CourseList(new ArrayList<Course>());
			if (course == null) {
				courseList = new CourseList(Arrays.asList(course));
			}
		}
		CourseListResource res = new CourseListResourceAsm().toResource(courseList);
		return new ResponseEntity<CourseListResource>(res, HttpStatus.OK);
	}
	
	@ApiOperation(value="Retrieves a course associated with an ID", response=Course.class)
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/courses/{id}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value={@ApiResponse(code=200, message="", response=Void.class), @ApiResponse(code=404, message="Unable to find course", response=ErrorDetail.class)})
	public ResponseEntity<CourseResource> findCourse(@PathVariable Long id) {
		Course course = courseService.findById(id);
		if (course != null) {
			CourseResource res = new CourseResourceAsm().toResource(course);
			return new ResponseEntity<CourseResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<CourseResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Retrieves all the courses associated with a code", response=Course.class, responseContainer="List")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/courses?code={code}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CourseResource> findCourseByCode(@RequestParam(value="name", required=true) String code) {
		Course course = courseService.findByCode(code);
		if (course != null) {
			CourseResource res = new CourseResourceAsm().toResource(course);
			return new ResponseEntity<CourseResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<CourseResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Retrieves all the courses associated with a Programme ID", response=Course.class, responseContainer="List")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/courses/programmes/{programmeId}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CourseListResource> findAllCoursesByProgrammes(@PathVariable Long programmeId) {
		CourseList courseList = null;
		courseList = courseService.findCoursesByProgrammeId(programmeId);
		if (courseList != null) {
			CourseListResource res = new CourseListResourceAsm().toResource(courseList);
			return new ResponseEntity<CourseListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<CourseListResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Retrieves all the courses associated with a Staff ID", response=Course.class, responseContainer="List")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/courses/staff/{staffId}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CourseListResource> findAllCoursesByStaff(@PathVariable Long staffId) {
		CourseList courseList = null;
		courseList = courseService.findCoursesByStaffId(staffId);
		if (courseList != null) {
			CourseListResource res = new CourseListResourceAsm().toResource(courseList);
			return new ResponseEntity<CourseListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<CourseListResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Creates a new course", notes="The newly created course ID will be sent in the location response header")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/courses/add"}, 
			method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value={@ApiResponse(code=201, message="Course created successfully", response=Void.class), @ApiResponse(code=500, message="Error creating course", response=ErrorDetail.class)})
	public ResponseEntity<CourseResource> createCourse(@RequestBody CourseResource sentCourse) {
		logger.info("Adding course with ID " + sentCourse.getRid());
		try {
			Course course = courseService.save(sentCourse.toCourse());
			CourseResource res = new CourseResourceAsm().toResource(course);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<CourseResource>(res, headers, HttpStatus.CREATED);
		} catch(EntityExistsException e) {
			throw new ConflictException("Course already exxists");
		}
	}
	
	@ApiOperation(value="Updates a course", response=Course.class)
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/courses/edit/{id}"}, 
			method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value={@ApiResponse(code=200, message="Course updated successfully", response=Void.class), @ApiResponse(code=404, message="Unable to find course", response=ErrorDetail.class)})
	public ResponseEntity<CourseResource> updateCourse(@PathVariable Long id, @RequestBody CourseResource course) {
		logger.info("Updating course with ID " + course.getRid());
		try {
			Course updatedCourse = courseService.findById(id);
			if (updatedCourse != null) {
				updatedCourse = courseService.save(course.toCourse());
				CourseResource res = new CourseResourceAsm().toResource(updatedCourse);
				return new ResponseEntity<CourseResource>(res, HttpStatus.OK);
			} else {
				return new ResponseEntity<CourseResource>(HttpStatus.NOT_FOUND);
			}
		} catch(EntityDoesNotExistException e) {
			throw new ResourceNotFoundException("Course does not exist");
		}
	}
}
