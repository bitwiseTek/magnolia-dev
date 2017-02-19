package com.bitwise.magnolia.web.restful.controller.user;
import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *  
 * @author Sika Kay
 * @date 18/02/17
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.common.Response;
import com.bitwise.magnolia.service.email.EmailService;
import com.bitwise.magnolia.service.user.UserService;
import com.bitwise.magnolia.vo.user.UserVo;

@RestController
public class UserController {

	final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/users",
			"**/*" + ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/users"}, 
	method = RequestMethod.GET, consumes = "application/json")
	public Response findAllUsers(){
		Response response = new Response();
		response = userService.findAllUsers();
		return response;
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/users/active",
			"**/*" + ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/users/active"}, 
	method = RequestMethod.GET, consumes = "application/json")
	public Response findAllActiveUsers(String status){
		Response response = new Response();
		response = userService.findAllActiveUsers(status);
		return response;
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/users/state",
			"**/*" + ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/users/state"}, 
	method = RequestMethod.GET, consumes = "application/json")
	public Response findAllUsersByStates(String state){
		Response response = new Response();
		response = userService.findAllUsersByStates(state);
		return response;
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/users/lga",
			"**/*" + ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/users/lga"}, 
	method = RequestMethod.GET, consumes = "application/json")
	public Response findAllUsersByLGAs(String lga){
		Response response = new Response();
		response = userService.findAllUsersByLGAs(lga);
		return response;
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/user/register",
			"**/*" + ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/user/register"}, 
	method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> handleUpdate(@RequestBody UserVo userVo) throws MessagingException {
		logger.info("Signing up new user....");
		Response response = new Response();
		response = userService.validateUser(userVo);
		this.emailService.sendEmailWithAttachment(userVo.getPrimaryEmail(), userVo);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
}
