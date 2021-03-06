package com.bitwise.magnolia.web.restful.controller.common;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
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
import com.bitwise.magnolia.model.common.StudyProgramme;
import com.bitwise.magnolia.service.common.StudyProgrammeService;
import com.bitwise.magnolia.util.ProgrammeList;
import com.bitwise.magnolia.web.restful.exception.ConflictException;
import com.bitwise.magnolia.web.restful.exception.ErrorDetail;
import com.bitwise.magnolia.web.restful.exception.ResourceNotFoundException;
import com.bitwise.magnolia.web.restful.resource.asm.common.StudyProgrammeListResourceAsm;
import com.bitwise.magnolia.web.restful.resource.asm.common.StudyProgrammeResourceAsm;
import com.bitwise.magnolia.web.restful.resource.common.StudyProgrammeListResource;
import com.bitwise.magnolia.web.restful.resource.common.StudyProgrammeResource;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@RestController
@Api(value="studyProgrammes", description="Study Programme API")
public class StudyProgrammeController {

final Logger logger = LoggerFactory.getLogger(StudyProgrammeController.class);
	
	@Autowired
	private StudyProgrammeService programmeService;
	
	@ApiOperation(value="Retrieves all the study programmes", response=StudyProgramme.class, responseContainer="List")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/programmes/"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudyProgrammeListResource> findAllProgrammes(@RequestParam(value="name", required=false) String name) {
		ProgrammeList programmeList = null;
		if (name == null) {
			programmeList = programmeService.findAllProgrammes();
		} else {
			StudyProgramme programme = programmeService.findByName(name);
			programmeList = new ProgrammeList(new ArrayList<StudyProgramme>());
			if (programme == null) {
				programmeList = new ProgrammeList(Arrays.asList(programme));
			}
		}
		StudyProgrammeListResource res = new StudyProgrammeListResourceAsm().toResource(programmeList);
		return new ResponseEntity<StudyProgrammeListResource>(res, HttpStatus.OK);
	}
	
	@ApiOperation(value="Retrieves the study programme associated with an ID", response=StudyProgramme.class)
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/programmes/{id}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudyProgrammeResource> findProgramme(@PathVariable Long id) {
		StudyProgramme programme = programmeService.findById(id);
		if (programme != null) {
			StudyProgrammeResource res = new StudyProgrammeResourceAsm().toResource(programme);
			return new ResponseEntity<StudyProgrammeResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<StudyProgrammeResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Retrieves the study programme associated with a Code ID", response=StudyProgramme.class)
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/programmes?code={code}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudyProgrammeResource> findProgrammeByCode(@RequestParam(value="name", required=true) String code) {
		StudyProgramme programme = programmeService.findByCode(code);
		if (programme != null) {
			code = programme.getCode();
			StudyProgrammeResource res = new StudyProgrammeResourceAsm().toResource(programme);
			return new ResponseEntity<StudyProgrammeResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<StudyProgrammeResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Retrieves all the study programmes associated with a Department ID", response=StudyProgramme.class, responseContainer="List")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/programmes/departments/{deptId}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudyProgrammeListResource> findProgrammesByDepartments(@PathVariable Long deptId) {
		ProgrammeList programmeList = null;
		programmeList = programmeService.findProgrammesByDepartmentId(deptId);
		if (programmeList != null) {
			StudyProgrammeListResource res = new StudyProgrammeListResourceAsm().toResource(programmeList);
			return new ResponseEntity<StudyProgrammeListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<StudyProgrammeListResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Creates a new study programme", notes="The newly created programme ID will be sent in the location response header")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/programmes/add"}, 
			method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value={@ApiResponse(code=201, message="Programme created successfully", response=Void.class), @ApiResponse(code=500, message="Error creating programme", response=ErrorDetail.class)})
	public ResponseEntity<StudyProgrammeResource> createProgramme(@RequestBody StudyProgrammeResource sentProgramme) {
		logger.info("Adding programme with ID " + sentProgramme.getRid());
		try {
			StudyProgramme programme = programmeService.save(sentProgramme.toProgramme());
			StudyProgrammeResource res = new StudyProgrammeResourceAsm().toResource(programme);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<StudyProgrammeResource>(res, headers, HttpStatus.CREATED);
		} catch(EntityExistsException e) {
			throw new ConflictException("Programme already exxists");
		}
	}
	
	@ApiOperation(value="Updates study programme", response=StudyProgramme.class)
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/programmes/edit/{id}"}, 
			method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value={@ApiResponse(code=200, message="Programme updated successfully", response=Void.class), @ApiResponse(code=404, message="Unable to find programme", response=ErrorDetail.class)})
	public ResponseEntity<StudyProgrammeResource> updateProgramme(@PathVariable Long id, @RequestBody StudyProgrammeResource programme) {
		logger.info("Updating programme with ID " + programme.getRid());
		try {
			StudyProgramme updatedProgramme = programmeService.findById(id);
			if (updatedProgramme != null) {
				updatedProgramme = programmeService.save(programme.toProgramme());
				StudyProgrammeResource res = new StudyProgrammeResourceAsm().toResource(updatedProgramme);
				return new ResponseEntity<StudyProgrammeResource>(res, HttpStatus.OK);
			} else {
				return new ResponseEntity<StudyProgrammeResource>(HttpStatus.NOT_FOUND);
			}
		} catch(EntityDoesNotExistException e) {
			throw new ResourceNotFoundException("Programme does not exist");
		}
	}
}
