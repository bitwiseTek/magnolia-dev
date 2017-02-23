package com.bitwise.magnolia.web.restful.resource.user;
/**
 *  
 * @author Sika Kay
 * @date 18/02/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class UserListResource extends ResourceSupport {

	private List<UserResource> users = new ArrayList<UserResource>();

	public List<UserResource> getUsers() {
		return users;
	}

	public void setUsers(List<UserResource> users) {
		this.users = users;
	}
	
	
}
