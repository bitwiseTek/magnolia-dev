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
import com.bitwise.magnolia.model.security.Role;
import com.bitwise.magnolia.service.security.RoleService;
import com.bitwise.magnolia.util.RoleList;
import com.bitwise.magnolia.web.restful.exception.ConflictException;
import com.bitwise.magnolia.web.restful.exception.ErrorDetail;
import com.bitwise.magnolia.web.restful.exception.ResourceNotFoundException;
import com.bitwise.magnolia.web.restful.resource.asm.security.RoleListResourceAsm;
import com.bitwise.magnolia.web.restful.resource.asm.security.RoleResourceAsm;
import com.bitwise.magnolia.web.restful.resource.security.RoleListResource;
import com.bitwise.magnolia.web.restful.resource.security.RoleResource;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@RestController
@Api(value="roles", description="Role API")
public class RoleController {

	final Logger logger = LoggerFactory.getLogger(RoleController.class);
	
	@Autowired
	private RoleService roleService;
	
	@ApiOperation(value="Retrieves all the roles", response=Role.class, responseContainer="List")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/roles/"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RoleListResource> findAllRoles(@RequestParam(value="name", required=false) String role) {
		RoleList roleList = null;
		if (role == null) {
			roleList = roleService.findAllRoles();
		} else {
			Role reqRole = roleService.findByRoleName(role);
			roleList = new RoleList(new ArrayList<Role>());
			if (reqRole == null) {
				roleList = new RoleList(Arrays.asList(reqRole));
			}
		}
		RoleListResource res = new RoleListResourceAsm().toResource(roleList);
		return new ResponseEntity<RoleListResource>(res, HttpStatus.OK);
	}
	
	@ApiOperation(value="Retrieves a role associated with an ID", response=Role.class)
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/roles/{id}"}, 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RoleResource> findRole(@PathVariable Long id) {
		Role role = roleService.findById(id);
		if (role != null) {
			RoleResource res = new RoleResourceAsm().toResource(role);
			return new ResponseEntity<RoleResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<RoleResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Creates a new role", notes="The newly created role ID will be sent in the location response header")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/roles/add"}, 
			method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value={@ApiResponse(code=201, message="Role created successfully", response=Void.class), @ApiResponse(code=500, message="Error creating role", response=ErrorDetail.class)})
	public ResponseEntity<RoleResource> createRole(@RequestBody RoleResource sentRole) {
		logger.info("Adding role with ID " + sentRole.getRid());
		try {
			Role role = roleService.save(sentRole.toRole());
			RoleResource res = new RoleResourceAsm().toResource(role);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<RoleResource>(res, headers, HttpStatus.CREATED);
		} catch(EntityExistsException e) {
			throw new ConflictException("Role already exists");
		}
	}
	
	@ApiOperation(value="Updates a role", response=Role.class)
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/roles/edit/{id}"}, 
			method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value={@ApiResponse(code=200, message="Role updated successfully", response=Void.class), @ApiResponse(code=404, message="Unable to find role", response=ErrorDetail.class)})
	public ResponseEntity<RoleResource> updateRole(@PathVariable Long id, @RequestBody RoleResource role) {
		logger.info("Updating role with ID " + role.getRid());
		try {
			Role updatedRole = roleService.findById(id);
			if (updatedRole != null) {
				updatedRole = roleService.save(role.toRole());
				RoleResource res = new RoleResourceAsm().toResource(updatedRole);
				return new ResponseEntity<RoleResource>(res, HttpStatus.OK);
			} else {
				return new ResponseEntity<RoleResource>(HttpStatus.NOT_FOUND);
			}
		} catch(EntityDoesNotExistException e) {
			throw new ResourceNotFoundException("Role does not exist");
		}
	}
}
