package com.bitwise.magnolia.service.userImpl;
/**
 *  
 * @author Sika Kay
 * @date 18/02/17
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.magnolia.dao.user.UserDao;
import com.bitwise.magnolia.exception.EntityDoesNotExistException;
import com.bitwise.magnolia.exception.EntityExistsException;
import com.bitwise.magnolia.model.user.User;
import com.bitwise.magnolia.service.user.UserService;
import com.bitwise.magnolia.util.UserList;


@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional(readOnly=true)
	public User findById(Long id) {
		return this.userDao.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public User findByUsername(String username) {
		return this.userDao.findByUsername(username);
	}

	@Override
	@Transactional(readOnly=true)
	public UserList findAllUsers() {
		return new UserList(userDao.findAllUsers());
	}

	@Override
	@Transactional(readOnly=true)
	public UserList findAllActiveUsers(String status) {
		return new UserList(userDao.findAllActiveUsers(status));
	}

	@Override
	@Transactional(readOnly=true)
	public UserList findAllUsersByStateId(Long stateId) {
		return new UserList(userDao.findAllUsersByStateId(stateId));
	}

	@Override
	@Transactional(readOnly=true)
	public UserList findAllUsersByLGAId(Long lgaId) {
		return new UserList(userDao.findAllUsersByLGAId(lgaId));
	}

	@Override
	@Transactional(readOnly=false)
	public User save(User data) {
		User user = userDao.findByUsername(data.getUsername());
		if (user != null) {
			throw new EntityExistsException("Account already exists");
		}
		return this.userDao.save(data);
	}
	
	@Override
	@Transactional(readOnly=false)
	public void delete(User user) {
		this.userDao.delete(user);
	}

	@Override
	public User update(User data) {
		User user = userDao.findById(data.getId());
		if (user == null) {
			throw new EntityDoesNotExistException("Account does not exist");
		}
		return userDao.save(data);
	}
	
	@Override
	@Transactional(readOnly=true)
	public User getAccount(String username) {
		return this.userDao.findByUsername(username);
	}
}
