package com.bitwise.magnolia.util;
/**
 *  
 * @author Sika Kay
 * @date 18/02/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import com.bitwise.magnolia.model.user.User;

public class UserList {

	public UserList(List<User> userList) {
		this.users = userList;
	}
	
	private List<User> users = new ArrayList<User>();

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
