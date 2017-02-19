package com.bitwise.magnolia.dao.user;
/**
 *  
 * @author Sika Kay
 * @date 17/02/17
 *
 */
import java.util.List;

import com.bitwise.magnolia.common.BaseDao;
import com.bitwise.magnolia.model.user.User;

public interface UserDao extends BaseDao<User> {

	public User findById(long id);
	
	public User findByUsername(String username);
	
	public User findBySystemId(String systemId);
	
	public List<User> findAllUsers();
	
	public List<User> findAllActiveUsers(String status);
	
	public List<User> findAllUsersByStates(String state);
	
	public List<User> findAllUsersByLGAs(String lga);
}
