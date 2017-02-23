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

	public User findById(Long id);
	
	public User findByUsername(String username);
	
	public User findBySystemId(String systemId);
	
	public User save(User user);
	
	public void delete(User user);
	
	public List<User> findAllUsers();
	
	public List<User> findAllActiveUsers(String status);
	
	public List<User> findAllUsersByStateId(Long stateId);
	
	public List<User> findAllUsersByLGAId(Long lgaId);
}
