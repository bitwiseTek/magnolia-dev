package com.bitwise.magnolia.web.restful.controller.staff;
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
import com.bitwise.magnolia.model.staff.StaffCourse;
import com.bitwise.magnolia.service.staff.StaffCourseService;
import com.bitwise.magnolia.util.StaffCourseList;
import com.bitwise.magnolia.web.restful.exception.ConflictException;
import com.bitwise.magnolia.web.restful.exception.ResourceNotFoundException;
import com.bitwise.magnolia.web.restful.resource.asm.staff.StaffCourseListResourceAsm;
import com.bitwise.magnolia.web.restful.resource.asm.staff.StaffCourseResourceAsm;
import com.bitwise.magnolia.web.restful.resource.staff.StaffCourseListResource;
import com.bitwise.magnolia.web.restful.resource.staff.StaffCourseResource;

@RestController
public class StaffCourseController {

	final Logger logger = LoggerFactory.getLogger(StaffCourseController.class);
	
	@Autowired
	private StaffCourseService staffCourseService;
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/staff/courses/"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StaffCourseListResource> findAllStaffCourses(@RequestParam(value="id", required=false) Long id) {
		StaffCourseList staffCourseList = null;
		if (id == null) {
			staffCourseList = staffCourseService.findAllCourses();
		} else {
			StaffCourse staffCourse = staffCourseService.findById(id);
			staffCourseList = new StaffCourseList(new ArrayList<StaffCourse>());
			if (staffCourse == null) {
				staffCourseList = new StaffCourseList(Arrays.asList(staffCourse));
			}
		}
		StaffCourseListResource res = new StaffCourseListResourceAsm().toResource(staffCourseList);
		return new ResponseEntity<StaffCourseListResource>(res, HttpStatus.OK);
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/staff/courses/semesters/one/{semesterId}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StaffCourseListResource> findAllStaffCoursesBySemestersOne(@PathVariable Long semesterId) {
		StaffCourseList staffCourseList = null;
		staffCourseList = staffCourseService.findAllCoursesOne(semesterId);
		if (staffCourseList != null) {
			StaffCourseListResource res = new StaffCourseListResourceAsm().toResource(staffCourseList);
			return new ResponseEntity<StaffCourseListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<StaffCourseListResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/staff/courses/semesters/two/{semesterId}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StaffCourseListResource> findAllStaffCoursesBySemestersTwo(@PathVariable Long semesterId) {
		StaffCourseList staffCourseList = null;
		staffCourseList = staffCourseService.findAllCoursesTwo(semesterId);
		if (staffCourseList != null) {
			StaffCourseListResource res = new StaffCourseListResourceAsm().toResource(staffCourseList);
			return new ResponseEntity<StaffCourseListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<StaffCourseListResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/staff/courses/attached/one/{semesterId}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StaffCourseListResource> findAllStaffCoursesAttachedBySemestersOne(@PathVariable Long semesterId) {
		StaffCourseList staffCourseList = null;
		staffCourseList = staffCourseService.findAllAttachedCoursesOne(semesterId, Boolean.TRUE);
		if (staffCourseList != null) {
			StaffCourseListResource res = new StaffCourseListResourceAsm().toResource(staffCourseList);
			return new ResponseEntity<StaffCourseListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<StaffCourseListResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/staff/courses/attached/two/{semesterId}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StaffCourseListResource> findAllStaffCoursesAttachedBySemestersTwo(@PathVariable Long semesterId) {
		StaffCourseList staffCourseList = null;
		staffCourseList = staffCourseService.findAllAttachedCoursesTwo(semesterId, Boolean.TRUE);
		if (staffCourseList != null) {
			StaffCourseListResource res = new StaffCourseListResourceAsm().toResource(staffCourseList);
			return new ResponseEntity<StaffCourseListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<StaffCourseListResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/staff/courses/completed/one/{semesterId}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StaffCourseListResource> findAllStaffCoursesCompletedBySemestersOne(@PathVariable Long semesterId) {
		StaffCourseList staffCourseList = null;
		staffCourseList = staffCourseService.findAllCompletedCoursesOne(semesterId, ApplicationConstant.COMPLETED_STATUS);
		if (staffCourseList != null) {
			StaffCourseListResource res = new StaffCourseListResourceAsm().toResource(staffCourseList);
			return new ResponseEntity<StaffCourseListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<StaffCourseListResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/staff/courses/completed/two/{semesterId}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StaffCourseListResource> findAllStaffCoursesCompletedBySemestersTwo(@PathVariable Long semesterId) {
		StaffCourseList staffCourseList = null;
		staffCourseList = staffCourseService.findAllCompletedCoursesTwo(semesterId, ApplicationConstant.COMPLETED_STATUS);
		if (staffCourseList != null) {
			StaffCourseListResource res = new StaffCourseListResourceAsm().toResource(staffCourseList);
			return new ResponseEntity<StaffCourseListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<StaffCourseListResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/staff/courses/pending/one/{semesterId}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StaffCourseListResource> findAllStaffCoursesPendingBySemestersOne(@PathVariable Long semesterId) {
		StaffCourseList staffCourseList = null;
		staffCourseList = staffCourseService.findAllPendingCoursesOne(semesterId, ApplicationConstant.PENDING_STATUS);
		if (staffCourseList != null) {
			StaffCourseListResource res = new StaffCourseListResourceAsm().toResource(staffCourseList);
			return new ResponseEntity<StaffCourseListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<StaffCourseListResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/staff/courses/pending/two/{semesterId}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StaffCourseListResource> findAllStaffCoursesPendingBySemestersTwo(@PathVariable Long semesterId) {
		StaffCourseList staffCourseList = null;
		staffCourseList = staffCourseService.findAllPendingCoursesTwo(semesterId, ApplicationConstant.PENDING_STATUS);
		if (staffCourseList != null) {
			StaffCourseListResource res = new StaffCourseListResourceAsm().toResource(staffCourseList);
			return new ResponseEntity<StaffCourseListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<StaffCourseListResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/staff/courses/{id}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StaffCourseResource> findStaffCourse(@PathVariable Long id) {
		StaffCourse staffCourse = staffCourseService.findById(id);
		if (staffCourse != null) {
			StaffCourseResource res = new StaffCourseResourceAsm().toResource(staffCourse);
			return new ResponseEntity<StaffCourseResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<StaffCourseResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/staff/courses/add"}, 
			method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StaffCourseResource> createStaffCourse(@RequestBody StaffCourseResource sentStaffCourse) {
		logger.info("Adding staff course with ID " + sentStaffCourse.getRid());
		try {
			StaffCourse staffCourse = staffCourseService.save(sentStaffCourse.toStaffCourse());
			StaffCourseResource res = new StaffCourseResourceAsm().toResource(staffCourse);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<StaffCourseResource>(res, headers, HttpStatus.CREATED);
		} catch(EntityExistsException e) {
			throw new ConflictException("Staff course already exxists");
		}
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/staff/courses/edit/{id}"}, 
			method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StaffCourseResource> updateStaff(@PathVariable Long id, @RequestBody StaffCourseResource staffCourse) {
		logger.info("Updating staff course with ID " + staffCourse.getRid());
		try {
			StaffCourse updatedStaffCourse = staffCourseService.findById(id);
			if (updatedStaffCourse != null) {
				updatedStaffCourse = staffCourseService.save(staffCourse.toStaffCourse());
				StaffCourseResource res = new StaffCourseResourceAsm().toResource(updatedStaffCourse);
				return new ResponseEntity<StaffCourseResource>(res, HttpStatus.OK);
			} else {
				return new ResponseEntity<StaffCourseResource>(HttpStatus.NOT_FOUND);
			}
		} catch(EntityDoesNotExistException e) {
			throw new ResourceNotFoundException("Staff course does not exist");
		}
	}
}
