package com.bitwise.magnolia.dao.userImpl;
/**
 *  
 * @author Sika Kay
 * @date 17/02/17
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.magnolia.common.AbstractDao;
import com.bitwise.magnolia.dao.user.UserDao;
import com.bitwise.magnolia.model.user.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<User> implements UserDao {

	final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<User> findAllUsers() {
		String sql = "select u from User u";
		return this.em.createQuery(sql, User.class).getResultList();
	}

	@Override
	public User findByUsername(String username) {
		String sql = "select distinct u from User u where u.username = :username";
		TypedQuery<User> query = em.createQuery(sql, User.class).setParameter("username", username);
		List<User> users = query.getResultList();
		User user = users.size() == 1 ? users.get(0) : null;
		if (user != null) {
			Hibernate.initialize(user.getRoles());
		}
		return user;
	}

	@Override
	public User findById(Long id) {
		String sql = "select distinct u from User u where u.id = :id";
		TypedQuery<User> query = em.createQuery(sql, User.class).setParameter("id", id);
		List<User> users = query.getResultList();
		User user = users.size() == 1 ? users.get(0) : null;
		if (user != null) {
			Hibernate.initialize(user.getRoles());
		}
		return user;
	}
	
	@Override
	public User findBySystemId(String systemId) {
		String sql = "select distinct u from User u where u.systemId = :systemId";
		TypedQuery<User> query = em.createQuery(sql, User.class).setParameter("systemId", systemId);
		List<User> users = query.getResultList();
		User user = users.size() == 1 ? users.get(0) : null;
		if (user != null) {
			Hibernate.initialize(user.getRoles());
		}
		return user;
	}

	@Override
	public List<User> findAllActiveUsers(String status) {
		String sql = "select u from User u where u.status = :status";
		TypedQuery<User> query = em.createQuery(sql, User.class).setParameter("status", status);
		List<User> users = query.getResultList();
		return users;
	}

	@Override
	public List<User> findAllUsersByStateId(Long stateId) {
		String sql = "select u from User u where u.state.id = :stateId";
		TypedQuery<User> query = em.createQuery(sql, User.class).setParameter("stateId", stateId);
		List<User> users = query.getResultList();
		return users;
	}

	@Override
	public List<User> findAllUsersByLGAId(Long lgaId) {
		String sql = "select u from User u where u.lga.id = :lgaId";
		TypedQuery<User> query = em.createQuery(sql, User.class).setParameter("lgaId", lgaId);
		List<User> users = query.getResultList();
		return users;
	}

	@Override
	@Transactional
	public User save(User user) {
		logger.info("Adding/Updating user with ID " + user.getId());
		return this.em.merge(user);
	}

	@Override
	@Transactional
	public void delete(User user) {
		logger.info("Deleting User with ID: " + user.getId());
		this.em.remove(em.merge(user));
	}

	@Override
	public User findByEmailAndToken(String email, String token) {
		String sql = "select distinct u from User u where u.email = :email and u.recoveryToken = :token";
		TypedQuery<User> query = em.createQuery(sql, User.class).setParameter("email", email).setParameter("token", token);
		List<User> users = query.getResultList();
		return users.size() == 1 ? users.get(0) : null;
	}
}
