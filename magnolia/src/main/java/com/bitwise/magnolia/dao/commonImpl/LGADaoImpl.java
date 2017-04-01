package com.bitwise.magnolia.dao.commonImpl;
/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bitwise.magnolia.common.AbstractDao;
import com.bitwise.magnolia.dao.common.LGADao;
import com.bitwise.magnolia.model.common.LGA;

@Repository("lgaDao")
public class LGADaoImpl extends AbstractDao<Long, LGA> implements LGADao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public LGA findById(Long id) {
		String sql = "select l from LGA l where l.id = :id";
		return this.em.createQuery(sql, LGA.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public List<LGA> findAll() {
		String sql = "select l from LGA l";
		return this.em.createQuery(sql, LGA.class).getResultList();
	}

	@Override
	public List<LGA> findLGAsByStateId(Long stateId) {
		String sql = "select l from LGA l where l.stateCode.id = :stateId";
		TypedQuery<LGA> query = em.createQuery(sql, LGA.class).setParameter("stateId", stateId);
		List<LGA> lgas = query.getResultList();
		return lgas;
	}

	@Override
	public LGA findByName(String name) {
		String sql = "select l from LGA l where l.name = :name";
		TypedQuery<LGA> query = em.createQuery(sql, LGA.class).setParameter("name", name);
		List<LGA> lgas = query.getResultList();
		return lgas.size() == 1 ? lgas.get(0) : null;
	}

}
