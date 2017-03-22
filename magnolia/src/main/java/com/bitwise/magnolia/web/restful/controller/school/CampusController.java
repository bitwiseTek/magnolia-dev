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
import com.bitwise.magnolia.model.school.Campus;
import com.bitwise.magnolia.service.school.CampusService;
import com.bitwise.magnolia.util.CampusList;
import com.bitwise.magnolia.web.restful.exception.ConflictException;
import com.bitwise.magnolia.web.restful.exception.ErrorDetail;
import com.bitwise.magnolia.web.restful.exception.ResourceNotFoundException;
import com.bitwise.magnolia.web.restful.resource.asm.school.CampusListResourceAsm;
import com.bitwise.magnolia.web.restful.resource.asm.school.CampusResourceAsm;
import com.bitwise.magnolia.web.restful.resource.school.CampusListResource;
import com.bitwise.magnolia.web.restful.resource.school.CampusResource;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@RestController
@Api(value="campuses", description="Campus API")
public class CampusController {

	final Logger logger = LoggerFactory.getLogger(CampusController.class);
	
	@Autowired
	private CampusService campusService;
	
	@ApiOperation(value="Retrieves all the campuses", response=Campus.class, responseContainer="List")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/campuses/"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CampusListResource> findAllCampuses(@RequestParam(value="name", required=false) String name) {
		CampusList campusList = null;
		if (name == null) {
			campusList = campusService.findAllCampuses();
		} else {
			Campus campus = campusService.findByName(name);
			campusList = new CampusList(new ArrayList<Campus>());
			if (campus == null) {
				campusList = new CampusList(Arrays.asList(campus));
			}
		}
		CampusListResource res = new CampusListResourceAsm().toResource(campusList);
		return new ResponseEntity<CampusListResource>(res, HttpStatus.OK);
	}
	
	@ApiOperation(value="Retrieves a campus associated with an ID", response=Campus.class)
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/campuses/{id}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CampusResource> findCampus(@PathVariable Long id) {
		Campus campus = campusService.findById(id);
		if (campus != null) {
			CampusResource res = new CampusResourceAsm().toResource(campus);
			return new ResponseEntity<CampusResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<CampusResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Retrieves a campus associated with a SubSchool ID", response=Campus.class, responseContainer="List")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/campuses/subschools/{subSchoolId}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CampusListResource> findAllCampusesBySubSchools(@PathVariable Long subSchoolId) {
		CampusList campusList = null;
		campusList = campusService.findCampusesBySubSchoolId(subSchoolId);
		if (campusList != null) {
			CampusListResource res = new CampusListResourceAsm().toResource(campusList);
			return new ResponseEntity<CampusListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<CampusListResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Creates a new campus", notes="The newly created campus ID will be sent in the location response header")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/campuses/add"}, 
			method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value={@ApiResponse(code=201, message="Campus created successfully", response=Void.class), @ApiResponse(code=500, message="Error creating campus", response=ErrorDetail.class)})
	public ResponseEntity<CampusResource> createCampus(@RequestBody CampusResource sentCampus) {
		logger.info("Adding campus with ID " + sentCampus.getRid());
		try {
			Campus campus = campusService.save(sentCampus.toCampus());
			CampusResource res = new CampusResourceAsm().toResource(campus);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<CampusResource>(res, headers, HttpStatus.CREATED);
		} catch(EntityExistsException e) {
			throw new ConflictException("Campus already exxists");
		}
	}
	
	@ApiOperation(value="Updates a campus", response=Campus.class)
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/campuses/edit/{id}"}, 
			method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value={@ApiResponse(code=200, message="Campus updated successfully", response=Void.class), @ApiResponse(code=404, message="Unable to find campus", response=ErrorDetail.class)})
	public ResponseEntity<CampusResource> updateCampus(@PathVariable Long id, @RequestBody CampusResource course) {
		logger.info("Updating campus with ID " + course.getRid());
		try {
			Campus updatedCampus = campusService.findById(id);
			if (updatedCampus != null) {
				updatedCampus = campusService.save(course.toCampus());
				CampusResource res = new CampusResourceAsm().toResource(updatedCampus);
				return new ResponseEntity<CampusResource>(res, HttpStatus.OK);
			} else {
				return new ResponseEntity<CampusResource>(HttpStatus.NOT_FOUND);
			}
		} catch(EntityDoesNotExistException e) {
			throw new ResourceNotFoundException("Campus does not exist");
		}
	}
}
