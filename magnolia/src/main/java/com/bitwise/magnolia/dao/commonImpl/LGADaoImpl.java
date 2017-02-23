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
import com.bitwise.magnolia.dao.common.LGADao;
import com.bitwise.magnolia.model.common.LGA;

@Repository("lgaDao")
public class LGADaoImpl extends AbstractDao<Object> implements LGADao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public LGA findById(Long id) {
		String sql = "from LGA l where l.id = :id";
		return this.em.createQuery(sql, LGA.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public List<LGA> findAll() {
		String sql = "from LGA l";
		return this.em.createQuery(sql, LGA.class).getResultList();
	}

}
