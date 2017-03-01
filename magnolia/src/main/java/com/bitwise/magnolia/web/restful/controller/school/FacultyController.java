package com.bitwise.magnolia.web.restful.controller.school;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.model.school.Faculty;
import com.bitwise.magnolia.service.school.FacultyService;
import com.bitwise.magnolia.util.FacultyList;
import com.bitwise.magnolia.web.restful.resource.asm.school.FacultyListResourceAsm;
import com.bitwise.magnolia.web.restful.resource.asm.school.FacultyResourceAsm;
import com.bitwise.magnolia.web.restful.resource.school.FacultyListResource;
import com.bitwise.magnolia.web.restful.resource.school.FacultyResource;

@RestController
public class FacultyController {

	final Logger logger = LoggerFactory.getLogger(FacultyController.class);
	
	@Autowired
	private FacultyService facultyService;
	
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
}
