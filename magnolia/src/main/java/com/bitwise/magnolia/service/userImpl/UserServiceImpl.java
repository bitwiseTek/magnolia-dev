package com.bitwise.magnolia.service.userImpl;
import java.util.List;

/**
 *  
 * @author Sika Kay
 * @date 18/02/17
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.magnolia.common.Utils;
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
	private BCryptPasswordEncoder passwordEncoder;
	
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
	public void delete(User user) {
		this.userDao.delete(user);
	}
	
	@Override
	@Transactional(readOnly=true)
	public User getAccount(String username) {
		return this.userDao.findByUsername(username);
	}

	@Override
	@Transactional(readOnly=true)
	public User findByEmailAndToken(String email, String token) {
		return this.userDao.findByEmailAndToken(email, token);
	}

	@Override
	@Transactional(readOnly=true)
	public User findByUsernameAndEmail(String username, String email) {
		return this.userDao.findByUsernameAndEmail(username, email);
	}

	@Override
	@Transactional(readOnly=true)
	public List<User> findAll() {
		return this.userDao.findAllUsers();
	}

	@Override
	@Transactional(readOnly=false)
	public User save(User data) {
		User user = userDao.findByUsernameAndEmail(data.getUsername(), data.getPrimaryEmail());
		if (user != null) {
			throw new EntityExistsException("Account already exists");
		}
		data.setPassword(this.passwordEncoder.encode(data.getTempPassword()));
		return this.userDao.save(data);
		
	}

	@Override
	@Transactional(readOnly=false)
	public void deleteByUsername(String username) {
		this.userDao.deleteByUsername(username);
	}

	@Override
	@Transactional(readOnly=false)
	public User update(User data) {
		User user = userDao.findById(data.getId());
		try {
			if (user != null) {
				user.setUsername(data.getUsername());
				user.setTempPassword(data.getTempPassword());
				user.setPassword(this.passwordEncoder.encode(data.getTempPassword()));
				user.setBirthday(data.getBirthday());
				user.setCreatedAt(data.getCreatedAt());
				user.setFirstName(data.getFirstName());
				user.setLastName(data.getLastName());
				user.setLastLogin(data.getLastLogin());
				user.setLastLogout(data.getLastLogout());
				user.setLga(data.getLga());
				user.setMiddleName(data.getMiddleName());
				user.setOneTimeToken(Utils.generateUUID());
				user.setPhotoBase64(data.getPhotoBase64());
				user.setPrimaryEmail(data.getPrimaryEmail());
				user.setPrimaryNumber(data.getPrimaryNumber());
				user.setRecoveryTime(data.getRecoveryTime());
				user.setRecoveryToken(data.getRecoveryToken());
				user.setRoles(data.getRoles());
				user.setSystemId(data.getSystemId());
				user.setSecondaryEmail(data.getSecondaryEmail());
				user.setSecondaryNumber(data.getSecondaryNumber());
				user.setSecretQuestion(data.getSecretQuestion());
				user.setSecretAnswer(data.getSecretAnswer());
				user.setSex(data.getSex());
				user.setState(data.getState());
				user.setStatus(data.getStatus());
				user.setStreetAddress(data.getStreetAddress());
			} else {
				throw new EntityDoesNotExistException("Account does not exist");
			}
		} catch(Exception e) {
			throw new EntityDoesNotExistException("Account does not exist");
		}
		return user;
	}
}