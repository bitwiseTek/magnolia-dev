package com.bitwise.magnolia.service.user;
/**
 *  
 * @author Sika Kay
 * @date 18/02/17
 *
 */
import com.bitwise.magnolia.common.Response;
import com.bitwise.magnolia.model.user.User;
import com.bitwise.magnolia.vo.user.UserVo;

public interface UserService {

	public Response findById(long id);
	
	public Response findByUsername(String username);
	
	public Response findAllUsers();
	
	public Response findAllActiveUsers(String status);
	
	public Response findAllUsersByStates(String state);
	
	public Response findAllUsersByLGAs(String lga);
	
	public User getAccount(String username);
	
	public Response validateUser(UserVo userVo);
}
