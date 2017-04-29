package com.bitwise.magnolia.web.restful.controller.user;
/**
 *  
 * @author Sika Kay
 * @date 18/02/17
 *
 */
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.exception.EntityDoesNotExistException;
import com.bitwise.magnolia.exception.EntityExistsException;
import com.bitwise.magnolia.model.user.User;
import com.bitwise.magnolia.service.email.EmailService;
import com.bitwise.magnolia.service.user.UserService;
import com.bitwise.magnolia.util.UserList;
import com.bitwise.magnolia.web.restful.exception.ConflictException;
import com.bitwise.magnolia.web.restful.exception.ErrorDetail;
import com.bitwise.magnolia.web.restful.exception.ResourceNotFoundException;
import com.bitwise.magnolia.web.restful.resource.asm.user.UserListResourceAsm;
import com.bitwise.magnolia.web.restful.resource.asm.user.UserResourceAsm;
import com.bitwise.magnolia.web.restful.resource.user.UserListResource;
import com.bitwise.magnolia.web.restful.resource.user.UserResource;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@RestController
@Api(value="users", description="User API")
public class UserController {

	final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;
	
	//@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@ApiOperation(value="Retrieves all the users", response=User.class, responseContainer="List")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/users/"}, 
	method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserListResource> findAllUsers(@RequestParam(value="username", required=false) String username) {
		UserList userList = null;
		if (username == null) {
			userList = userService.findAllUsers();
		} else {
			User user = userService.findByUsername(username);
			userList = new UserList(new ArrayList<User>());
			if (user != null) {
				userList = new UserList(Arrays.asList(user));
			} 
		}
		UserListResource res = new UserListResourceAsm().toResource(userList);
		return new ResponseEntity<UserListResource>(res, HttpStatus.OK);
	}
	
	@ApiOperation(value="Retrieves a user associated with an ID", response=User.class)
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/users/{id}"}, 
	method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResource> findUser(@PathVariable Long id) {
		User user = userService.findById(id);
		if (user != null) {
			UserResource res = new UserResourceAsm().toResource(user);
			return new ResponseEntity<UserResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<UserResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	//@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@ApiOperation(value="Retrieves all the users that are active", response=User.class, responseContainer="List")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/users/status/{status}"}, 
	method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserListResource> findAllActiveUsers(@PathVariable("status") String status) {
		UserList userList = null;
		userList = userService.findAllActiveUsers(status);
		if (userList != null) {
			UserListResource res = new UserListResourceAsm().toResource(userList);
			return new ResponseEntity<UserListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<UserListResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@ApiOperation(value="Retrieves all the users associated with a State ID", response=User.class, responseContainer="List")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/users/states/{stateId}"}, 
	method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserListResource> findAllUsersByStates(@PathVariable("stateId") Long stateId) {
		UserList userList = null;
		userList = userService.findAllUsersByStateId(stateId);
		if (userList != null) {
			UserListResource res = new UserListResourceAsm().toResource(userList);
			return new ResponseEntity<UserListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<UserListResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@ApiOperation(value="Retrieves all the users associated with an LGA ID", response=User.class, responseContainer="List")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/users/lgas/{lgaId}"}, 
	method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserListResource> findAllUsersByLGAs(@PathVariable("lgaId") Long lgaId) {
		UserList userList = null;
		userList = userService.findAllUsersByLGAId(lgaId);
		if (userList != null) {
			UserListResource res = new UserListResourceAsm().toResource(userList);
			return new ResponseEntity<UserListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<UserListResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Creates a new user", notes="The newly created user ID will be sent in the location response header")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/users/register"}, 
	method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value={@ApiResponse(code=201, message="User created successfully", response=Void.class), @ApiResponse(code=500, message="Error creating user", response=ErrorDetail.class)})
	public ResponseEntity<UserResource> createUser(@RequestBody UserResource sentUser) throws MessagingException {
		try {
			User createdUser = userService.save(sentUser.toUser());
			this.emailService.sendEmailWithAttachment(sentUser.getPrimaryEmail(), sentUser);
			UserResource res = new UserResourceAsm().toResource(createdUser);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<UserResource>(res, headers, HttpStatus.CREATED);
		} catch(EntityExistsException ex) {
			throw new ConflictException("User already exists");
		}
	}
	
	@ApiOperation(value="Updates a user", response=User.class)
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/users/{id}"}, 
	method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value={@ApiResponse(code=200, message="User updated successfully", response=Void.class), @ApiResponse(code=404, message="Unable to find user", response=ErrorDetail.class)})
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) /*throws MessagingException*/ {
		logger.info("Updating user with ID " + updatedUser.getId());
		try {
			updatedUser = userService.findById(id);
			if (updatedUser != null) {
				userService.updateProfile(updatedUser);
				//this.emailService.sendUpdateEmail(updatedUser.getPrimaryEmail(), updatedUser);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch(EntityDoesNotExistException e) {
			throw new ResourceNotFoundException("Account does not exist");
		}
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN')")
	@ApiOperation(value="Deletes a user", response=User.class)
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/users/{id}"}, 
	method = RequestMethod.DELETE)
	@ApiResponses(value={@ApiResponse(code=200, message="User deleted successfully", response=Void.class), @ApiResponse(code=404, message="Unable to find user", response=ErrorDetail.class)})
	public ResponseEntity<UserResource> deleteUser(@PathVariable("id") Long id) {
        logger.info("Fetching & Deleting User with id " + id);
        User user = userService.findById(id);
        if (user == null) {
            logger.info("Unable to delete user with id " + id + " not found");
            return new ResponseEntity<UserResource>(HttpStatus.NOT_FOUND);
        } else {
        	this.userService.delete(user);
            return new ResponseEntity<UserResource>(HttpStatus.NO_CONTENT);
        }
    }
}
