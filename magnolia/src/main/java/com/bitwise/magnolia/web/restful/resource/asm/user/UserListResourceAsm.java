package com.bitwise.magnolia.web.restful.resource.asm.user;
/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 *
 */
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.util.UserList;
import com.bitwise.magnolia.web.restful.controller.user.UserController;
import com.bitwise.magnolia.web.restful.resource.user.UserListResource;
import com.bitwise.magnolia.web.restful.resource.user.UserResource;

public class UserListResourceAsm extends ResourceAssemblerSupport<UserList, UserListResource>{

	public UserListResourceAsm() {
		super(UserController.class, UserListResource.class);
	}
	
	@Override
	public UserListResource toResource(UserList userList) {
		List<UserResource> resList = new UserResourceAsm().toResources(userList.getUsers());
		UserListResource finalRes = new UserListResource();
		finalRes.setUsers(resList);
		return finalRes;
	}

}
