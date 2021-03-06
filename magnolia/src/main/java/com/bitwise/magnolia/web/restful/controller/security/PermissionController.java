package com.bitwise.magnolia.web.restful.controller.security;
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
import com.bitwise.magnolia.model.security.Permission;
import com.bitwise.magnolia.service.security.PermissionService;
import com.bitwise.magnolia.util.PermissionList;
import com.bitwise.magnolia.web.restful.exception.ConflictException;
import com.bitwise.magnolia.web.restful.exception.ErrorDetail;
import com.bitwise.magnolia.web.restful.exception.ResourceNotFoundException;
import com.bitwise.magnolia.web.restful.resource.asm.security.PermissionListResourceAsm;
import com.bitwise.magnolia.web.restful.resource.asm.security.PermissionResourceAsm;
import com.bitwise.magnolia.web.restful.resource.security.PermissionListResource;
import com.bitwise.magnolia.web.restful.resource.security.PermissionResource;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@RestController
@Api(value="permissions", description="Permission API")
public class PermissionController {

	final Logger logger = LoggerFactory.getLogger(PermissionController.class);
	
	@Autowired
	private PermissionService permissionService;
	
	@ApiOperation(value="Retrieves all the permissions", response=Permission.class, responseContainer="List")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/permissions/"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PermissionListResource> findAllPermissions(@RequestParam(value="name", required=false) String permission) {
		PermissionList permList = null;
		if (permission == null) {
			permList = permissionService.findAllPermissions();
		} else {
			Permission perm = permissionService.findByPermissionName(permission);
			permList = new PermissionList(new ArrayList<Permission>());
			if (perm == null) {
				permList = new PermissionList(Arrays.asList(perm));
			}
		}
		PermissionListResource res = new PermissionListResourceAsm().toResource(permList);
		return new ResponseEntity<PermissionListResource>(res, HttpStatus.OK);
	}
	
	@ApiOperation(value="Retrieves permission associated with an ID", response=Permission.class)
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/permissions/{id}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PermissionResource> findPermission(@PathVariable Long id) {
		Permission perm = permissionService.findById(id);
		if (perm != null) {
			PermissionResource res = new PermissionResourceAsm().toResource(perm);
			return new ResponseEntity<PermissionResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<PermissionResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Creates a new permission", notes="The newly created permission ID will be sent in the location response header")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/permissions/add"}, 
			method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value={@ApiResponse(code=201, message="Permission created successfully", response=Void.class), @ApiResponse(code=500, message="Error creating permission", response=ErrorDetail.class)})
	public ResponseEntity<PermissionResource> createPermission(@RequestBody PermissionResource sentPerm) {
		logger.info("Adding permission with ID " + sentPerm.getRid());
		try {
			Permission perm = permissionService.save(sentPerm.toPermission());
			PermissionResource res = new PermissionResourceAsm().toResource(perm);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<PermissionResource>(res, headers, HttpStatus.CREATED);
		} catch(EntityExistsException e) {
			throw new ConflictException("Permission already exists");
		}
	}
	
	@ApiOperation(value="Updates a permission", response=Permission.class)
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/permissions/edit/{id}"}, 
			method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value={@ApiResponse(code=200, message="Permission updated successfully", response=Void.class), @ApiResponse(code=404, message="Unable to find permission", response=ErrorDetail.class)})
	public ResponseEntity<PermissionResource> updatePermission(@PathVariable Long id, @RequestBody PermissionResource perm) {
		logger.info("Updating permission with ID " + perm.getRid());
		try {
			Permission updatedPerm = permissionService.findById(id);
			if (updatedPerm != null) {
				updatedPerm = permissionService.save(perm.toPermission());
				PermissionResource res = new PermissionResourceAsm().toResource(updatedPerm);
				return new ResponseEntity<PermissionResource>(res, HttpStatus.OK);
			} else {
				return new ResponseEntity<PermissionResource>(HttpStatus.NOT_FOUND);
			}
		} catch(EntityDoesNotExistException e) {
			throw new ResourceNotFoundException("Permission does not exist");
		}
	}
}
