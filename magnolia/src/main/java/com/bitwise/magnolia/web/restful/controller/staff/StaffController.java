package com.bitwise.magnolia.web.restful.controller.staff;
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
import com.bitwise.magnolia.model.staff.Staff;
import com.bitwise.magnolia.service.staff.StaffService;
import com.bitwise.magnolia.util.StaffList;
import com.bitwise.magnolia.web.restful.exception.ConflictException;
import com.bitwise.magnolia.web.restful.exception.ErrorDetail;
import com.bitwise.magnolia.web.restful.exception.ResourceNotFoundException;
import com.bitwise.magnolia.web.restful.resource.asm.staff.StaffListResourceAsm;
import com.bitwise.magnolia.web.restful.resource.asm.staff.StaffResourceAsm;
import com.bitwise.magnolia.web.restful.resource.staff.StaffListResource;
import com.bitwise.magnolia.web.restful.resource.staff.StaffResource;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@RestController
@Api(value="staff", description="Staff API")
public class StaffController {

	final Logger logger = LoggerFactory.getLogger(StaffController.class);
	
	@Autowired
	private StaffService staffService;
	
	@ApiOperation(value="Retrieves all the staff", response=Staff.class, responseContainer="List")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/staff/"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StaffListResource> findAllStaff(@RequestParam(value="staffId", required=false) String staffId) {
		StaffList staffList = null;
		if (staffId == null) {
			staffList = staffService.findAllStaff();
		} else {
			Staff staff = staffService.findByStaffId(staffId);
			staffList = new StaffList(new ArrayList<Staff>());
			if (staff == null) {
				staffList = new StaffList(Arrays.asList(staff));
			}
		}
		StaffListResource res = new StaffListResourceAsm().toResource(staffList);
		return new ResponseEntity<StaffListResource>(res, HttpStatus.OK);
	}
	
	@ApiOperation(value="Retrieves staff associated with an ID", response=Staff.class)
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/staff/{id}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StaffResource> findStaff(@PathVariable Long id) {
		Staff staff = staffService.findById(id);
		if (staff != null) {
			StaffResource res = new StaffResourceAsm().toResource(staff);
			return new ResponseEntity<StaffResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<StaffResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Retrieves all the staff associated with a Department ID", response=Staff.class, responseContainer="List")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/staff/departments/{deptId}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StaffListResource> findAllStaffByDepartments(@PathVariable Long deptId) {
		StaffList staffList = null;
		staffList = staffService.findStaffByDepartmentId(deptId);
		if (staffList != null) {
			StaffListResource res = new StaffListResourceAsm().toResource(staffList);
			return new ResponseEntity<StaffListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<StaffListResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Creates a new staff", notes="The newly created staff ID will be sent in the location response header")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/staff/add"}, 
			method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value={@ApiResponse(code=201, message="Staff created successfully", response=Void.class), @ApiResponse(code=500, message="Error creating staff", response=ErrorDetail.class)})
	public ResponseEntity<StaffResource> createStaff(@RequestBody StaffResource sentStaff) {
		logger.info("Adding staff with ID " + sentStaff.getRid());
		try {
			Staff staff = staffService.save(sentStaff.toStaff());
			StaffResource res = new StaffResourceAsm().toResource(staff);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<StaffResource>(res, headers, HttpStatus.CREATED);
		} catch(EntityExistsException e) {
			throw new ConflictException("Staff already exxists");
		}
	}
	
	@ApiOperation(value="Updates a Department", response=Staff.class)
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/staff/edit/{id}"}, 
			method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value={@ApiResponse(code=200, message="Staff updated successfully", response=Void.class), @ApiResponse(code=404, message="Unable to find staff", response=ErrorDetail.class)})
	public ResponseEntity<StaffResource> updateStaff(@PathVariable Long id, @RequestBody StaffResource staff) {
		logger.info("Updating staff with ID " + staff.getRid());
		try {
			Staff updatedStaff = staffService.findById(id);
			if (updatedStaff != null) {
				updatedStaff = staffService.save(staff.toStaff());
				StaffResource res = new StaffResourceAsm().toResource(updatedStaff);
				return new ResponseEntity<StaffResource>(res, HttpStatus.OK);
			} else {
				return new ResponseEntity<StaffResource>(HttpStatus.NOT_FOUND);
			}
		} catch(EntityDoesNotExistException e) {
			throw new ResourceNotFoundException("Staff does not exist");
		}
	}
}
