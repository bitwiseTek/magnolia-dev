package com.bitwise.magnolia.web.restful.controller.school;
import java.net.URI;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 *
 */
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
import com.bitwise.magnolia.exception.EntityExistsException;
import com.bitwise.magnolia.model.school.Faculty;
import com.bitwise.magnolia.service.school.FacultyService;
import com.bitwise.magnolia.util.FacultyList;
import com.bitwise.magnolia.web.restful.exception.ConflictException;
import com.bitwise.magnolia.web.restful.exception.ErrorDetail;
import com.bitwise.magnolia.web.restful.resource.asm.school.FacultyListResourceAsm;
import com.bitwise.magnolia.web.restful.resource.asm.school.FacultyResourceAsm;
import com.bitwise.magnolia.web.restful.resource.school.FacultyListResource;
import com.bitwise.magnolia.web.restful.resource.school.FacultyResource;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@RestController
@Api(value="faculties", description="Faculty API")
public class FacultyController {

	final Logger logger = LoggerFactory.getLogger(FacultyController.class);
	
	@Autowired
	private FacultyService facultyService;
	
	@ApiOperation(value="Retrieves all the faculties", response=Faculty.class, responseContainer="List")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/faculties/"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FacultyListResource> findAllFaculties(@RequestParam(value="name", required=false) String name) {
		FacultyList facList = null;
		if (name == null) {
			facList = facultyService.findAllFaculties();
		} else {
			Faculty faculty = facultyService.findByName(name);
			facList = new FacultyList(new ArrayList<Faculty>());
			if (faculty == null) {
				facList = new FacultyList(Arrays.asList(faculty));
			}
		}
		FacultyListResource res = new FacultyListResourceAsm().toResource(facList);
		return new ResponseEntity<FacultyListResource>(res, HttpStatus.OK);
	}
	
	@ApiOperation(value="Retrieves a faculty associated with an ID", response=Faculty.class)
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/faculties/{id}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FacultyResource> findFaculty(@PathVariable Long id) {
		Faculty faculty = facultyService.findById(id);
		if (faculty != null) {
			FacultyResource res = new FacultyResourceAsm().toResource(faculty);
			return new ResponseEntity<FacultyResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<FacultyResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Creates a new faculty", notes="The newly created faculty ID will be sent in the location response header")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/faculties/add"}, 
			method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value={@ApiResponse(code=201, message="Campus created successfully", response=Void.class), @ApiResponse(code=500, message="Error creating faculty", response=ErrorDetail.class)})
	public ResponseEntity<FacultyResource> createFaculty(@RequestBody FacultyResource sentFaculty) {
		logger.info("Adding faculty with ID " + sentFaculty.getRid());
		try {
			Faculty faculty = facultyService.save(sentFaculty.toFaculty());
			FacultyResource res = new FacultyResourceAsm().toResource(faculty);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<FacultyResource>(res, headers, HttpStatus.CREATED);
		} catch(EntityExistsException e) {
			throw new ConflictException("Faculty already exists");
		}
	}
}
