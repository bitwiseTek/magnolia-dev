package com.bitwise.magnolia.dao.userImpl;

import java.util.ArrayList;
import java.util.List;
/**
 *  
 * @author Sika Kay
 * @date 17/02/17
 *
 */
import org.springframework.stereotype.Repository;

import com.bitwise.magnolia.common.AbstractDao;
import com.bitwise.magnolia.dao.user.UserDao;
import com.bitwise.magnolia.model.user.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<User> implements UserDao{

	@Override
	public List<User> findAllUsers() {
		String sql = "from User u";
		List<?> list = this.getCurrentSession().createQuery(sql).list();
		List<User> userList = new ArrayList<User>();
		for(Object object : list){
			User temp = (User) object;
			userList.add(temp);
		}
		return userList;
	}

	@Override
	public User findByUsername(String username) {
		String sql = "from User u where u.username = :username";
		return (User) this.getCurrentSession().createQuery(sql).setParameter("username", username).uniqueResult();
	}

	@Override
	public User findById(long id) {
		String sql = "from User u where u.id = :id";
		return (User) this.getCurrentSession().createQuery(sql).setParameter("id", id).uniqueResult();
	}
	
	@Override
	public User findBySystemId(String systemId) {
		String sql = "from User u where u.systemId = :systemId";
		return (User) this.getCurrentSession().createQuery(sql).setParameter("systemId", systemId).uniqueResult();
	}

	@Override
	public List<User> findAllActiveUsers(String status) {
		String sql = "from User u where u.status = :status";
		List<?> list = this.getCurrentSession().createQuery(sql).setParameter("status", status).list();
		List<User> userList = new ArrayList<User>();
		for(Object object : list){
			User temp = (User) object;
			userList.add(temp);
		}
		return userList;
	}

	@Override
	public List<User> findAllUsersByStates(String state) {
		String sql = "from User u where u.state.name = :state";
		List<?> list = this.getCurrentSession().createQuery(sql).setParameter("state", state).list();
		List<User> userList = new ArrayList<User>();
		for(Object object : list){
			User temp = (User) object;
			userList.add(temp);
		}
		return userList;
	}

	@Override
	public List<User> findAllUsersByLGAs(String lga) {
		String sql = "from User u where u.lga.name = :lga";
		List<?> list = this.getCurrentSession().createQuery(sql).setParameter("lga", lga).list();
		List<User> userList = new ArrayList<User>();
		for(Object object : list){
			User temp = (User) object;
			userList.add(temp);
		}
		return userList;
	}

}
