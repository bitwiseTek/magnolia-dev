package com.bitwise.magnolia.web.restful.resource.asm.user;
/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 *
 */
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.bitwise.magnolia.model.user.User;
import com.bitwise.magnolia.web.restful.controller.user.UserController;
import com.bitwise.magnolia.web.restful.resource.user.UserResource;

public class UserResourceAsm extends ResourceAssemblerSupport<User, UserResource>{

	public UserResourceAsm() {
		super(UserController.class, UserResource.class);
	}
	
	@Override
	public UserResource toResource(User user) {
		UserResource res = new UserResource();
		res.setRid(user.getId());
		res.setSystemId(user.getSystemId());
		res.setUsername(user.getUsername());
		res.setPassword(user.getPassword());
		res.setTempPassword(user.getTempPassword());
		res.setPrimaryEmail(user.getPrimaryEmail());
		res.setPrimaryNumber(user.getPrimaryNumber());
		res.setSecondaryEmail(user.getSecondaryEmail());
		res.setSecondaryNumber(user.getSecondaryNumber());
		res.setStatus(user.getStatus());
		res.setFirstName(user.getFirstName());
		res.setLastName(user.getLastName());
		res.setMiddleName(user.getMiddleName());
		res.setOneTimeToken(user.getOneTimeToken());
		res.setSex(user.getSex());
		res.setSecretQuestion(user.getSecretQuestion());
		res.setSecretAnswer(user.getSecretAnswer());
		res.setPhotoBase64(user.getPhotoBase64());
		res.setStreetAddress(user.getStreetAddress());
		res.setBirthday(user.getBirthday());
		res.setState(user.getState().getName());
		res.setLga(user.getLga().getName());
		res.setLastLogin(user.getLastLogin());
		res.setLastLogout(user.getLastLogout());
		res.setCreatedAt(user.getCreatedAt());
		res.add(linkTo(methodOn(UserController.class).findUser(user.getId())).withSelfRel());
		return res;
	}

}
