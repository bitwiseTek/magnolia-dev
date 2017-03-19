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
import com.bitwise.magnolia.web.restful.exception.ResourceNotFoundException;
import com.bitwise.magnolia.web.restful.resource.asm.user.UserListResourceAsm;
import com.bitwise.magnolia.web.restful.resource.asm.user.UserResourceAsm;
import com.bitwise.magnolia.web.restful.resource.user.UserListResource;
import com.bitwise.magnolia.web.restful.resource.user.UserResource;

@RestController
public class UserController {

	final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;
	
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
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/user/register"}, 
	method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
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
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/users/{id}"}, 
	method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResource> updateUser(@PathVariable Long id, @RequestBody UserResource user) {
		logger.info("Updating user with ID " + user.getRid());
		try {
			User updatedUser = userService.findById(id);
			if (updatedUser != null) {
				updatedUser = userService.update(user.toUser());
				UserResource res = new UserResourceAsm().toResource(updatedUser);
				return new ResponseEntity<UserResource>(res, HttpStatus.OK);
			} else {
				return new ResponseEntity<UserResource>(HttpStatus.NOT_FOUND);
			}
		} catch(EntityDoesNotExistException e) {
			throw new ResourceNotFoundException("Account does not exist");
		}
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/users/{id}"}, 
	method = RequestMethod.DELETE)
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
