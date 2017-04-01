package com.bitwise.magnolia.service.user;
/**
 *  
 * @author Sika Kay
 * @date 18/02/17
 *
 */
import java.util.List;

import com.bitwise.magnolia.model.user.User;
import com.bitwise.magnolia.util.UserList;

public interface UserService {

	public User findById(Long id);
	
	public User findByUsername(String username);
	
	public User findByUsernameAndEmail(String username, String email);
	
	public User findByEmailAndToken(String email, String token);
	
	public List<User> findAll();
	
	public UserList findAllUsers();
	
	public UserList findAllActiveUsers(String status);
	
	public UserList findAllUsersByStateId(Long stateId);
	
	public UserList findAllUsersByLGAId(Long lgaId);
	
	public User getAccount(String username);
	
	public User save(User data);
	
	public void delete(User user);
	
	public void deleteByUsername(String username);
	
	public User update(User data);
}
