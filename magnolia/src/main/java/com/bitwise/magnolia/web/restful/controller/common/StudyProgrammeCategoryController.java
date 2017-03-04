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
import com.bitwise.magnolia.model.common.StudyProgrammeCategory;
import com.bitwise.magnolia.service.common.StudyProgrammeCategoryService;
import com.bitwise.magnolia.util.ProgrammeCategoryList;
import com.bitwise.magnolia.web.restful.exception.ConflictException;
import com.bitwise.magnolia.web.restful.exception.ResourceNotFoundException;
import com.bitwise.magnolia.web.restful.resource.asm.common.StudyProgrammeCategoryListResourceAsm;
import com.bitwise.magnolia.web.restful.resource.asm.common.StudyProgrammeCategoryResourceAsm;
import com.bitwise.magnolia.web.restful.resource.common.StudyProgrammeCategoryListResource;
import com.bitwise.magnolia.web.restful.resource.common.StudyProgrammeCategoryResource;

@RestController
public class StudyProgrammeCategoryController {

	final Logger logger = LoggerFactory.getLogger(StudyProgrammeCategoryController.class);
	
	@Autowired
	private StudyProgrammeCategoryService categoryService;
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/categories/"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudyProgrammeCategoryListResource> findAllCategories(@RequestParam(value="name", required=false) String name) {
		ProgrammeCategoryList categoryList = null;
		if (name == null) {
			categoryList = categoryService.findAll();
		} else {
			StudyProgrammeCategory category = categoryService.findByName(name);
			categoryList = new ProgrammeCategoryList(new ArrayList<StudyProgrammeCategory>());
			if (category == null) {
				categoryList = new ProgrammeCategoryList(Arrays.asList(category));
			}
		}
		StudyProgrammeCategoryListResource res = new StudyProgrammeCategoryListResourceAsm().toResource(categoryList);
		return new ResponseEntity<StudyProgrammeCategoryListResource>(res, HttpStatus.OK);
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/categories/{id}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudyProgrammeCategoryResource> findCategory(@PathVariable Long id) {
		StudyProgrammeCategory category = categoryService.findById(id);
		if (category != null) {
			StudyProgrammeCategoryResource res = new StudyProgrammeCategoryResourceAsm().toResource(category);
			return new ResponseEntity<StudyProgrammeCategoryResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<StudyProgrammeCategoryResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/categories/add"}, 
			method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudyProgrammeCategoryResource> createCategory(@RequestBody StudyProgrammeCategoryResource sentCategory) {
		logger.info("Adding study programme category with ID " + sentCategory.getRid());
		try {
			StudyProgrammeCategory category = categoryService.save(sentCategory.toCategory());
			StudyProgrammeCategoryResource res = new StudyProgrammeCategoryResourceAsm().toResource(category);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<StudyProgrammeCategoryResource>(res, headers, HttpStatus.CREATED);
		} catch(EntityExistsException e) {
			throw new ConflictException("Category already exists");
		}
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/categories/edit/{id}"}, 
			method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudyProgrammeCategoryResource> updateCategory(@PathVariable Long id, StudyProgrammeCategoryResource category) {
		logger.info("Updating study programme category with ID " + category.getRid());
		try {
			StudyProgrammeCategory updatedCategory = categoryService.findById(id);
			if (updatedCategory != null) {
				updatedCategory = categoryService.save(category.toCategory());
				StudyProgrammeCategoryResource res = new StudyProgrammeCategoryResourceAsm().toResource(updatedCategory);
				return new ResponseEntity<StudyProgrammeCategoryResource>(res, HttpStatus.OK);
			} else {
				return new ResponseEntity<StudyProgrammeCategoryResource>(HttpStatus.NOT_FOUND);
			}
		} catch(EntityDoesNotExistException e) {
			throw new ResourceNotFoundException("Category does not exist");
		}
	}
}
