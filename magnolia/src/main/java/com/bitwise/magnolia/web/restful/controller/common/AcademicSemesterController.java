package com.bitwise.magnolia.web.restful.controller.common;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import java.util.ArrayList;
import java.util.Arrays;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.bitwise.magnolia.model.common.AcademicSemester;
import com.bitwise.magnolia.service.common.AcademicSemesterService;
import com.bitwise.magnolia.util.SemesterList;
import com.bitwise.magnolia.web.restful.exception.ErrorDetail;
import com.bitwise.magnolia.web.restful.exception.ResourceNotFoundException;
import com.bitwise.magnolia.web.restful.resource.asm.common.AcademicSemesterListResourceAsm;
import com.bitwise.magnolia.web.restful.resource.asm.common.AcademicSemesterResourceAsm;
import com.bitwise.magnolia.web.restful.resource.common.AcademicSemesterListResource;
import com.bitwise.magnolia.web.restful.resource.common.AcademicSemesterResource;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponses;
import com.wordnik.swagger.annotations.ApiResponse;

@RestController
@Api(value="semesters", description="Semesters API")
public class AcademicSemesterController {

	final Logger logger = LoggerFactory.getLogger(AcademicSemesterController.class);
	
	@Autowired
	private AcademicSemesterService semesterService;
	
	@ApiOperation(value="Retrieves all the semesters", response=AcademicSemester.class, responseContainer="List")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/semesters/"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AcademicSemesterListResource> findAllSemesters(@RequestParam(value="name", required=false) String name) {
		SemesterList semList = null;
		if (name == null) {
			semList = semesterService.findAll();
		} else {
			AcademicSemester semester = semesterService.findByName(name);
			semList = new SemesterList(new ArrayList<AcademicSemester>());
			if (semester == null) {
				semList = new SemesterList(Arrays.asList(semester));
			}
		}
		AcademicSemesterListResource res = new AcademicSemesterListResourceAsm().toResource(semList);
		return new ResponseEntity<AcademicSemesterListResource>(res, HttpStatus.OK);
	}
	
	@ApiOperation(value="Retrieves a semester associated with an ID", response=AcademicSemester.class)
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/semesters/{id}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value={@ApiResponse(code=200, message="", response=Void.class), @ApiResponse(code=404, message="Unable to find semester", response=ErrorDetail.class)})
	public ResponseEntity<AcademicSemesterResource> findSemester(@PathVariable Long id) {
		AcademicSemester semester = semesterService.findById(id);
		if (semester != null) {
			AcademicSemesterResource res = new AcademicSemesterResourceAsm().toResource(semester);
			return new ResponseEntity<AcademicSemesterResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<AcademicSemesterResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Updating an existing semester", response=AcademicSemester.class)
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/semesters/{id}"}, 
			method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value={@ApiResponse(code=200, message="Semester updated successfully", response=Void.class), @ApiResponse(code=404, message="Unable to find semester", response=ErrorDetail.class)})
	public ResponseEntity<AcademicSemesterResource> updateSemester(@PathVariable Long id, @RequestBody AcademicSemester updatedSemester) {
		logger.info("Updating Semester with ID " + updatedSemester.getId());
		try {
			updatedSemester = semesterService.findById(id);
			if (updatedSemester != null) {
				updatedSemester.setUpdatedAt(new DateTime(DateTime.now()));
				this.semesterService.save(updatedSemester);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch(Exception e) {
			throw new ResourceNotFoundException("Semester does not exist");
		}
	}
}
