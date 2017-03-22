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
import com.bitwise.magnolia.model.school.Department;
import com.bitwise.magnolia.service.school.DepartmentService;
import com.bitwise.magnolia.util.DepartmentList;
import com.bitwise.magnolia.web.restful.resource.asm.school.DepartmentListResourceAsm;
import com.bitwise.magnolia.web.restful.resource.asm.school.DepartmentResourceAsm;
import com.bitwise.magnolia.web.restful.resource.school.DepartmentListResource;
import com.bitwise.magnolia.web.restful.resource.school.DepartmentResource;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController
@Api(value="departments", description="Department API")
public class DepartmentController {

	final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentService deptService;
	
	@ApiOperation(value="Retrieves all the departments", response=Department.class, responseContainer="List")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/departments/"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DepartmentListResource> findAllDepartments(@RequestParam(value="name", required=false) String name) {
		DepartmentList deptList = null;
		if (name == null) {
			deptList = deptService.findAllDepartments();
		} else {
			Department dept = deptService.findByName(name);
			deptList = new DepartmentList(new ArrayList<Department>());
			if (dept != null) {
				deptList = new DepartmentList(Arrays.asList(dept));
			}
		}
		DepartmentListResource res = new DepartmentListResourceAsm().toResource(deptList);
		return new ResponseEntity<DepartmentListResource>(res, HttpStatus.OK);
	}
	
	@ApiOperation(value="Retrieves a department associated with an ID", response=Department.class)
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/departments/{id}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DepartmentResource> findDept(@PathVariable Long id) {
		Department dept = deptService.findByDepartmentId(id);
		if (dept != null) {
			DepartmentResource res = new DepartmentResourceAsm().toResource(dept);
			return new ResponseEntity<DepartmentResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<DepartmentResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Retrieves all the departments associated with a Faculty ID", response=Department.class, responseContainer="List")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/departments/faculties/{facultyId}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DepartmentListResource> findAllDepartmentsByFaculties(@PathVariable Long facultyId) {
		DepartmentList deptList = null;
		deptList = deptService.findDepartmentsByFacultyId(facultyId);
		if (deptList != null) {
			DepartmentListResource res = new DepartmentListResourceAsm().toResource(deptList);
			return new ResponseEntity<DepartmentListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<DepartmentListResource>(HttpStatus.NOT_FOUND);
		}
	}
}
