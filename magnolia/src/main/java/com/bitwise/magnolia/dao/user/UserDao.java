package com.bitwise.magnolia.dao.user;
/**
 *  
 * @author Sika Kay
 * @date 17/02/17
 *
 */
import java.util.List;

import com.bitwise.magnolia.model.user.User;

public interface UserDao {

	public User findById(Long id);
	
	public User findByUsername(String username);
	
	public User findBySystemId(String systemId);
	
	public User findByUsernameAndEmail(String username, String email);
	
	public User findByEmailAndToken(String email, String token);
	
	public User save(User user);
	
	public User update(User user);
	
	public void deleteByUsername(String username);
	
	public void delete(User user);
	
	public List<User> findAllUsers();
	
	public List<User> findAllActiveUsers(String status);
	
	public List<User> findAllUsersByStateId(Long stateId);
	
	public List<User> findAllUsersByLGAId(Long lgaId);
}
