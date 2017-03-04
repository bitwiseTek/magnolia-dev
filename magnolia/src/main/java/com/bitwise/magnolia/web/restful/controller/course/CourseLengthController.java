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
import com.bitwise.magnolia.model.course.CourseLength;
import com.bitwise.magnolia.service.course.CourseLengthService;
import com.bitwise.magnolia.util.CourseLengthList;
import com.bitwise.magnolia.web.restful.exception.ConflictException;
import com.bitwise.magnolia.web.restful.exception.ResourceNotFoundException;
import com.bitwise.magnolia.web.restful.resource.asm.course.CourseLengthListResourceAsm;
import com.bitwise.magnolia.web.restful.resource.asm.course.CourseLengthResourceAsm;
import com.bitwise.magnolia.web.restful.resource.course.CourseLengthListResource;
import com.bitwise.magnolia.web.restful.resource.course.CourseLengthResource;

@RestController
public class CourseLengthController {

	final Logger logger = LoggerFactory.getLogger(CourseLengthController.class);
	
	@Autowired
	private CourseLengthService lengthService;
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/lengths/"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CourseLengthListResource> findAllLengths(@RequestParam(value="name", required=false) String name) {
		CourseLengthList lengthList = null;
		if (name == null) {
			lengthList = lengthService.findAllCourseLengths();
		} else {
			CourseLength length = lengthService.findByName(name);
			lengthList = new CourseLengthList(new ArrayList<CourseLength>());
			if (length == null) {
				lengthList = new CourseLengthList(Arrays.asList(length));
			}
		}
		CourseLengthListResource res = new CourseLengthListResourceAsm().toResource(lengthList);
		return new ResponseEntity<CourseLengthListResource>(res, HttpStatus.OK);
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/lengths/{id}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CourseLengthResource> findLength(@PathVariable Long id) {
		CourseLength length = lengthService.findById(id);
		if (length != null) {
			CourseLengthResource res = new CourseLengthResourceAsm().toResource(length);
			return new ResponseEntity<CourseLengthResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<CourseLengthResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/lengths/add"}, 
			method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CourseLengthResource> createLength(@RequestBody CourseLengthResource sentLength) {
		logger.info("Adding course length with ID " + sentLength.getRid());
		try {
			CourseLength length = lengthService.save(sentLength.toLength());
			CourseLengthResource res = new CourseLengthResourceAsm().toResource(length);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<CourseLengthResource>(res, headers, HttpStatus.CREATED);
		} catch(EntityExistsException e) {
			throw new ConflictException("Course Length already exxists");
		}
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/lengths/edit/{id}"}, 
			method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CourseLengthResource> updateLength(@PathVariable Long id, @RequestBody CourseLengthResource length) {
		logger.info("Updating course length with ID " + length.getRid());
		try {
			CourseLength updatedLength = lengthService.findById(id);
			if (updatedLength != null) {
				updatedLength = lengthService.save(length.toLength());
				CourseLengthResource res = new CourseLengthResourceAsm().toResource(updatedLength);
				return new ResponseEntity<CourseLengthResource>(res, HttpStatus.OK);
			} else {
				return new ResponseEntity<CourseLengthResource>(HttpStatus.NOT_FOUND);
			}
		} catch(EntityDoesNotExistException e) {
			throw new ResourceNotFoundException("Course Length does not exist");
		}
	}
}
