package com.bitwise.magnolia.dao.commonImpl;
/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bitwise.magnolia.common.AbstractDao;
import com.bitwise.magnolia.dao.common.StateDao;
import com.bitwise.magnolia.model.common.State;

@Repository("stateDao")
public class StateDaoImpl extends AbstractDao<Object> implements StateDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public State findById(Long id) {
		String sql = "from State s where s.id = :id";
		return this.em.createQuery(sql, State.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public List<State> findAll() {
		String sql = "from State s";
		return this.em.createQuery(sql, State.class).getResultList();
	}

}
