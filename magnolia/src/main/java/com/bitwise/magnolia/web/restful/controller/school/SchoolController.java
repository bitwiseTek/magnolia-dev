package com.bitwise.magnolia.web.restful.controller.school;
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
import com.bitwise.magnolia.model.school.School;
import com.bitwise.magnolia.service.school.SchoolService;
import com.bitwise.magnolia.util.SchoolList;
import com.bitwise.magnolia.web.restful.exception.ConflictException;
import com.bitwise.magnolia.web.restful.exception.ErrorDetail;
import com.bitwise.magnolia.web.restful.exception.ResourceNotFoundException;
import com.bitwise.magnolia.web.restful.resource.asm.school.SchoolListResourceAsm;
import com.bitwise.magnolia.web.restful.resource.asm.school.SchoolResourceAsm;
import com.bitwise.magnolia.web.restful.resource.school.SchoolListResource;
import com.bitwise.magnolia.web.restful.resource.school.SchoolResource;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@RestController
@Api(value="schools", description="School API")
public class SchoolController {

	final Logger logger = LoggerFactory.getLogger(SchoolController.class);
	
	@Autowired
	private SchoolService schoolService;
	
	@ApiOperation(value="Retrieves all the schools", response=School.class, responseContainer="List")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/schools/"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SchoolListResource> findAllSchools(@RequestParam(value="name", required=false) String name) {
		SchoolList schoolList = null;
		if (name == null) {
			schoolList = schoolService.findAllSchools();
		} else {
			School school = schoolService.findByName(name);
			schoolList = new SchoolList(new ArrayList<School>());
			if (school == null) {
				schoolList = new SchoolList(Arrays.asList(school));
			}
		}
		SchoolListResource res = new SchoolListResourceAsm().toResource(schoolList);
		return new ResponseEntity<SchoolListResource>(res, HttpStatus.OK);
	}
	
	@ApiOperation(value="Retrieves a school with an associated ID", response=School.class)
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/schools/{id}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SchoolResource> findSchool(@PathVariable Long id) {
		School school = schoolService.findById(id);
		if (school != null) {
			SchoolResource res = new SchoolResourceAsm().toResource(school);
			return new ResponseEntity<SchoolResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<SchoolResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Creates a new school", notes="The newly created school ID will be sent in the location response header")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/schools/add"}, 
			method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value={@ApiResponse(code=201, message="School created successfully", response=Void.class), @ApiResponse(code=500, message="Error creating school", response=ErrorDetail.class)})
	public ResponseEntity<SchoolResource> createSchool(@RequestBody SchoolResource sentSchool) {
		logger.info("Adding school with ID " + sentSchool.getRid());
		try {
			School school = schoolService.save(sentSchool.toSchool());
			SchoolResource res = new SchoolResourceAsm().toResource(school);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<SchoolResource>(res, headers, HttpStatus.CREATED);
		} catch(EntityExistsException e) {
			throw new ConflictException("School already exxists");
		}
	}
	
	@ApiOperation(value="Updates a school", response=School.class)
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/schools/edit/{id}"}, 
			method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value={@ApiResponse(code=200, message="School updated successfully", response=Void.class), @ApiResponse(code=404, message="Unable to find school", response=ErrorDetail.class)})
	public ResponseEntity<SchoolResource> updateSchool(@PathVariable Long id, @RequestBody SchoolResource school) {
		logger.info("Updating school with ID " + school.getRid());
		try {
			School updatedSchool = schoolService.findById(id);
			if (updatedSchool != null) {
				updatedSchool = schoolService.save(school.toSchool());
				SchoolResource res = new SchoolResourceAsm().toResource(updatedSchool);
				return new ResponseEntity<SchoolResource>(res, HttpStatus.OK);
			} else {
				return new ResponseEntity<SchoolResource>(HttpStatus.NOT_FOUND);
			}
		} catch(EntityDoesNotExistException e) {
			throw new ResourceNotFoundException("School does not exist");
		}
	}
}
