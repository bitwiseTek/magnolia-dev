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
import com.bitwise.magnolia.model.school.SubSchool;
import com.bitwise.magnolia.service.school.SubSchoolService;
import com.bitwise.magnolia.util.SubSchoolList;
import com.bitwise.magnolia.web.restful.exception.ConflictException;
import com.bitwise.magnolia.web.restful.exception.ErrorDetail;
import com.bitwise.magnolia.web.restful.exception.ResourceNotFoundException;
import com.bitwise.magnolia.web.restful.resource.asm.school.SubSchoolListResourceAsm;
import com.bitwise.magnolia.web.restful.resource.asm.school.SubSchoolResourceAsm;
import com.bitwise.magnolia.web.restful.resource.school.SubSchoolListResource;
import com.bitwise.magnolia.web.restful.resource.school.SubSchoolResource;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@RestController
@Api(value="subschools", description="Sub-School API")
public class SubSchoolController {

	final Logger logger = LoggerFactory.getLogger(SubSchoolController.class);
	
	@Autowired
	private SubSchoolService subSchoolService;
	
	@ApiOperation(value="Retrieves all the sub-schools", response=SubSchool.class, responseContainer="List")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/subschools/"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SubSchoolListResource> findAllSubSchools(@RequestParam(value="name", required=false) String name) {
		SubSchoolList subSchoolList = null;
		if (name == null) {
			subSchoolList = subSchoolService.findAllSubSchools();
		} else {
			SubSchool subSchool = subSchoolService.findByName(name);
			subSchoolList = new SubSchoolList(new ArrayList<SubSchool>());
			if (subSchool == null) {
				subSchoolList = new SubSchoolList(Arrays.asList(subSchool));
			}
		}
		SubSchoolListResource res = new SubSchoolListResourceAsm().toResource(subSchoolList);
		return new ResponseEntity<SubSchoolListResource>(res, HttpStatus.OK);
	}
	
	@ApiOperation(value="Retrieves sub-school associated with an ID", response=SubSchool.class)
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/subschools/{id}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SubSchoolResource> findSubSchool(@PathVariable Long id) {
		SubSchool subSchool = subSchoolService.findById(id);
		if (subSchool != null) {
			SubSchoolResource res = new SubSchoolResourceAsm().toResource(subSchool);
			return new ResponseEntity<SubSchoolResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<SubSchoolResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Retrieves all the sub-schools associated with a School ID", response=SubSchool.class, responseContainer="List")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/subschools/schools/{schoolId}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SubSchoolListResource> findAllSubSchoolsBySchools(@PathVariable Long schoolId) {
		SubSchoolList subSchoolList = null;
		subSchoolList = subSchoolService.findSubSchoolsBySchoolId(schoolId);
		if (subSchoolList != null) {
			SubSchoolListResource res = new SubSchoolListResourceAsm().toResource(subSchoolList);
			return new ResponseEntity<SubSchoolListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<SubSchoolListResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Creates a new sub-school", notes="The newly created sub-school ID will be sent in the location response header")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/subschools/add"}, 
			method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value={@ApiResponse(code=201, message="Sub-School created successfully", response=Void.class), @ApiResponse(code=500, message="Error creating sub-school", response=ErrorDetail.class)})
	public ResponseEntity<SubSchoolResource> createSubSchool(@RequestBody SubSchoolResource sentSubSchool) {
		logger.info("Adding sub-school with ID " + sentSubSchool.getRid());
		try {
			SubSchool subSchool = subSchoolService.save(sentSubSchool.toSubSchool());
			SubSchoolResource res = new SubSchoolResourceAsm().toResource(subSchool);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<SubSchoolResource>(res, headers, HttpStatus.CREATED);
		} catch(EntityExistsException e) {
			throw new ConflictException("Sub-School already exxists");
		}
	}
	
	@ApiOperation(value="Updates a sub-school", response=SubSchool.class)
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/subschools/edit/{id}"}, 
			method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value={@ApiResponse(code=200, message="Sub-School updated successfully", response=Void.class), @ApiResponse(code=404, message="Unable to find sub-school", response=ErrorDetail.class)})
	public ResponseEntity<SubSchoolResource> updateSubSchool(@PathVariable Long id, @RequestBody SubSchoolResource subSchool) {
		logger.info("Updating sub-school with ID " + subSchool.getRid());
		try {
			SubSchool updatedSubSchool = subSchoolService.findById(id);
			if (updatedSubSchool != null) {
				updatedSubSchool = subSchoolService.save(subSchool.toSubSchool());
				SubSchoolResource res = new SubSchoolResourceAsm().toResource(updatedSubSchool);
				return new ResponseEntity<SubSchoolResource>(res, HttpStatus.OK);
			} else {
				return new ResponseEntity<SubSchoolResource>(HttpStatus.NOT_FOUND);
			}
		} catch(EntityDoesNotExistException e) {
			throw new ResourceNotFoundException("Sub-School does not exist");
		}
	}
}
