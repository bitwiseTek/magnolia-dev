package com.bitwise.magnolia.service.userImpl;
/**
 *  
 * @author Sika Kay
 * @date 18/02/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.common.Response;
import com.bitwise.magnolia.common.Utils;
import com.bitwise.magnolia.dao.user.UserDao;
import com.bitwise.magnolia.model.common.LGA;
import com.bitwise.magnolia.model.common.State;
import com.bitwise.magnolia.model.user.User;
import com.bitwise.magnolia.service.user.UserService;
import com.bitwise.magnolia.vo.user.UserVo;


@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public Response findById(long id) {
		Response response = new Response();
		try {
			User user = userDao.findById(id);
			if (user != null) {
				UserVo vo = new UserVo();
				vo.setId(user.getId());
				vo.setSystemId(user.getSystemId());
				vo.setBirthday(user.getBirthday());
				vo.setFirstName(user.getFirstName());
				vo.setLastName(user.getLastName());
				vo.setMiddleName(user.getMiddleName());
				vo.setOneTimeToken(user.getOneTimeToken());
				vo.setPhotoBase64(user.getPhotoBase64());
				vo.setPassword(user.getPassword());
				vo.setPrimaryEmail(user.getPrimaryEmail());
				vo.setPrimaryNumber(user.getPrimaryNumber());
				vo.setSecondaryEmail(user.getSecondaryEmail());
				vo.setSecondaryNumber(user.getSecondaryNumber());
				vo.setSecretAnswer(user.getSecretAnswer());
				vo.setSecretQuestion(user.getSecretQuestion());
				vo.setSex(user.getSex());
				vo.setStatus(user.getStatus());
				vo.setState(vo.getState());
				vo.setLga(vo.getLga());
				vo.setUsername(user.getUsername());
				vo.setStreetAddress(user.getStreetAddress());

				response.setSuccess(true);
				response.setObject(vo);
			} else {
				response.setSuccess(false);
				response.setMessage("User does not exist");
			}
		} catch(Exception e) {
			response.setSuccess(false);
			response.setMessage("User does not exist");
			System.err.println("ERROR:: " + this.getClass().getSimpleName());
		}
		return response;
	}

	@Override
	public Response findByUsername(String username) {
		Response response = new Response();
		try {
			User user = userDao.findByUsername(username);
			if (user != null) {
				UserVo vo = new UserVo();
				vo.setId(user.getId());
				vo.setSystemId(user.getSystemId());
				vo.setBirthday(user.getBirthday());
				vo.setFirstName(user.getFirstName());
				vo.setLastName(user.getLastName());
				vo.setMiddleName(user.getMiddleName());
				vo.setOneTimeToken(user.getOneTimeToken());
				vo.setPhotoBase64(user.getPhotoBase64());
				vo.setPassword(user.getPassword());
				vo.setPrimaryEmail(user.getPrimaryEmail());
				vo.setPrimaryNumber(user.getPrimaryNumber());
				vo.setSecondaryEmail(user.getSecondaryEmail());
				vo.setSecondaryNumber(user.getSecondaryNumber());
				vo.setSecretAnswer(user.getSecretAnswer());
				vo.setSecretQuestion(user.getSecretQuestion());
				vo.setSex(user.getSex());
				vo.setStatus(user.getStatus());
				vo.setState(vo.getState());
				vo.setLga(vo.getLga());
				vo.setUsername(user.getUsername());
				vo.setStreetAddress(user.getStreetAddress());

				response.setSuccess(true);
				response.setObject(vo);
			} else {
				response.setSuccess(false);
				response.setMessage("User does not exist");
			}
		} catch(Exception e) {
			response.setSuccess(false);
			response.setMessage("User does not exist");
			System.err.println("ERROR:: " + this.getClass().getSimpleName());
		}
		return response;

	}

	@Override
	public Response findAllUsers() {
		Response response = new Response();
		try {
			List<User> usersList = userDao.findAllUsers();
			if (usersList != null && usersList.size() > 0) {
				List<UserVo> voList = new ArrayList<UserVo>();
				for (User user : usersList) {
					UserVo vo = new UserVo();
					vo.setId(user.getId());
					vo.setSystemId(user.getSystemId());
					vo.setBirthday(user.getBirthday());
					vo.setFirstName(user.getFirstName());
					vo.setLastName(user.getLastName());
					vo.setMiddleName(user.getMiddleName());
					vo.setOneTimeToken(user.getOneTimeToken());
					vo.setPhotoBase64(user.getPhotoBase64());
					vo.setPassword(user.getPassword());
					vo.setPrimaryEmail(user.getPrimaryEmail());
					vo.setPrimaryNumber(user.getPrimaryNumber());
					vo.setSecondaryEmail(user.getSecondaryEmail());
					vo.setSecondaryNumber(user.getSecondaryNumber());
					vo.setSecretAnswer(user.getSecretAnswer());
					vo.setSecretQuestion(user.getSecretQuestion());
					vo.setSex(user.getSex());
					vo.setStatus(user.getStatus());
					vo.setState(vo.getState());
					vo.setLga(vo.getLga());
					vo.setUsername(user.getUsername());
					vo.setStreetAddress(user.getStreetAddress());
					voList.add(vo);
				}

				response.setSuccess(true);
				response.setObject(voList);
			} else {
				response.setSuccess(false);
				response.setMessage("Users not found");
			}
		} catch(Exception e) {
			response.setSuccess(false);
			response.setMessage("Users not found");
			System.err.println("ERROR:: " + this.getClass().getSimpleName());
		}
		return response;

	}

	@Override
	public Response findAllActiveUsers(String status) {
		Response response = new Response();
		try {
			List<User> usersList = userDao.findAllActiveUsers(status);
			if (usersList != null && usersList.size() > 0) {
				List<UserVo> voList = new ArrayList<UserVo>();
				for (User user : usersList) {
					UserVo vo = new UserVo();
					vo.setId(user.getId());
					vo.setSystemId(user.getSystemId());
					vo.setBirthday(user.getBirthday());
					vo.setFirstName(user.getFirstName());
					vo.setLastName(user.getLastName());
					vo.setMiddleName(user.getMiddleName());
					vo.setOneTimeToken(user.getOneTimeToken());
					vo.setPhotoBase64(user.getPhotoBase64());
					vo.setPassword(user.getPassword());
					vo.setPrimaryEmail(user.getPrimaryEmail());
					vo.setPrimaryNumber(user.getPrimaryNumber());
					vo.setSecondaryEmail(user.getSecondaryEmail());
					vo.setSecondaryNumber(user.getSecondaryNumber());
					vo.setSecretAnswer(user.getSecretAnswer());
					vo.setSecretQuestion(user.getSecretQuestion());
					vo.setSex(user.getSex());
					vo.setStatus(user.getStatus());
					vo.setState(vo.getState());
					vo.setLga(vo.getLga());
					vo.setUsername(user.getUsername());
					vo.setStreetAddress(user.getStreetAddress());
					voList.add(vo);
				}

				response.setSuccess(true);
				response.setObject(voList);
			} else {
				response.setSuccess(false);
				response.setMessage("Active users not found");
			}
		} catch(Exception e) {
			response.setSuccess(false);
			response.setMessage("Active users not found");
			System.err.println("ERROR:: " + this.getClass().getSimpleName());
		}
		return response;
	}

	@Override
	public Response findAllUsersByStates(String state) {
		Response response = new Response();
		try {
			List<User> usersList = userDao.findAllUsersByStates(state);
			if (usersList != null && usersList.size() > 0) {
				List<UserVo> voList = new ArrayList<UserVo>();
				for (User user : usersList) {
					UserVo vo = new UserVo();
					vo.setId(user.getId());
					vo.setSystemId(user.getSystemId());
					vo.setBirthday(user.getBirthday());
					vo.setFirstName(user.getFirstName());
					vo.setLastName(user.getLastName());
					vo.setMiddleName(user.getMiddleName());
					vo.setOneTimeToken(user.getOneTimeToken());
					vo.setPhotoBase64(user.getPhotoBase64());
					vo.setPassword(user.getPassword());
					vo.setPrimaryEmail(user.getPrimaryEmail());
					vo.setPrimaryNumber(user.getPrimaryNumber());
					vo.setSecondaryEmail(user.getSecondaryEmail());
					vo.setSecondaryNumber(user.getSecondaryNumber());
					vo.setSecretAnswer(user.getSecretAnswer());
					vo.setSecretQuestion(user.getSecretQuestion());
					vo.setSex(user.getSex());
					vo.setStatus(user.getStatus());
					vo.setState(vo.getState());
					vo.setLga(vo.getLga());
					vo.setUsername(user.getUsername());
					vo.setStreetAddress(user.getStreetAddress());
					voList.add(vo);
				}

				response.setSuccess(true);
				response.setObject(voList);
			} else {
				response.setSuccess(false);
				response.setMessage("No users in this state");
			}
		} catch(Exception e) {
			response.setSuccess(false);
			response.setMessage("No users in this state");
			System.err.println("ERROR:: " + this.getClass().getSimpleName());
		}
		return response;
	}

	@Override
	public Response findAllUsersByLGAs(String lga) {
		Response response = new Response();
		try {
			List<User> usersList = userDao.findAllUsersByLGAs	(lga);
			if (usersList != null && usersList.size() > 0) {
				List<UserVo> voList = new ArrayList<UserVo>();
				for (User user : usersList) {
					UserVo vo = new UserVo();
					vo.setId(user.getId());
					vo.setSystemId(user.getSystemId());
					vo.setBirthday(user.getBirthday());
					vo.setFirstName(user.getFirstName());
					vo.setLastName(user.getLastName());
					vo.setMiddleName(user.getMiddleName());
					vo.setOneTimeToken(user.getOneTimeToken());
					vo.setPhotoBase64(user.getPhotoBase64());
					vo.setPassword(user.getPassword());
					vo.setPrimaryEmail(user.getPrimaryEmail());
					vo.setPrimaryNumber(user.getPrimaryNumber());
					vo.setSecondaryEmail(user.getSecondaryEmail());
					vo.setSecondaryNumber(user.getSecondaryNumber());
					vo.setSecretAnswer(user.getSecretAnswer());
					vo.setSecretQuestion(user.getSecretQuestion());
					vo.setSex(user.getSex());
					vo.setStatus(user.getStatus());
					vo.setState(vo.getState());
					vo.setLga(vo.getLga());
					vo.setUsername(user.getUsername());
					vo.setStreetAddress(user.getStreetAddress());
					voList.add(vo);
				}

				response.setSuccess(true);
				response.setObject(voList);
			} else {
				response.setSuccess(false);
				response.setMessage("No users in this LGA");
			}
		} catch(Exception e) {
			response.setSuccess(false);
			response.setMessage("No users in this LGA");
			System.err.println("ERROR:: " + this.getClass().getSimpleName());
		}
		return response;
	}

	@Override
	public Response validateUser(UserVo userVo) {
		Response response = new Response();
		if (!userVo.getBirthday().isEmpty() && !userVo.getFirstName().isEmpty() && !userVo.getLastName().isEmpty() && !userVo.getLga().isEmpty() &&
				!userVo.getPhotoBase64().isEmpty() && !userVo.getPassword().isEmpty() && !userVo.getPrimaryEmail().isEmpty() && !userVo.getPrimaryNumber().isEmpty() &&
				!userVo.getSex().isEmpty() && !userVo.getState().isEmpty() && !userVo.getLga().isEmpty() && !userVo.getStreetAddress().isEmpty()) {
			this.registerUser(userVo);
			response.setSuccess(true);
		} else {
			response.setSuccess(false);
			response.setMessage("Please fill in the highlighted fields");
		}
		return response;
	}
	
	private boolean registerUser(UserVo userVo) {
		do {
			userVo.setSystemId(Utils.getCustomString(10, ""));
		}
		while (userDao.findBySystemId(userVo.getSystemId()) != null);
		User user = new User();
		user.setId(userVo.getId());
		user.setFirstName(userVo.getFirstName());
		user.setLastName(userVo.getLastName());
		user.setMiddleName(userVo.getMiddleName());
		user.setSex(userVo.getSex());
		user.setBirthday(userVo.getBirthday());
		user.setPrimaryEmail(userVo.getPrimaryEmail());
		user.setPrimaryNumber(userVo.getPrimaryNumber());
		user.setSecondaryEmail(userVo.getSecondaryEmail());
		user.setSecondaryNumber(userVo.getSecondaryNumber());
		user.setPhotoBase64(Utils.saveBase64ToPath(userVo.getPhotoBase64(), ApplicationConstant.SCHOOL_ALIAS, userVo.getSystemId() + "_photo"));
		user.setOneTimeToken(Utils.generateUUID());
		user.setStatus(ApplicationConstant.PENDING_STATUS);
		user.setState(new State(Long.parseLong(userVo.getState())));
		user.setLga(new LGA(Long.parseLong(userVo.getLga())));
		user.setUsername(userVo.getFirstName().toLowerCase().concat(".").concat(userVo.getLastName().toLowerCase().concat("@magnolia.com")));
		user.setTempPassword(Utils.generateRandomPassword());
		user.setPassword(this.passwordEncoder.encode(userVo.getTempPassword()));
		userDao.create(user);
		
		return true;
	}

	@Override
	@org.springframework.transaction.annotation.Transactional(readOnly=true)
	public User getAccount(String username) {
		return this.userDao.findByUsername(username);
	}
}
