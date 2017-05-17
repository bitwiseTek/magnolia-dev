package com.bitwise.magnolia.dao.financeImpl;
/**
 *  
 * @author Sika Kay
 * @date 25/04/17
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.magnolia.common.AbstractDao;
import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.dao.finance.BillingDetailsDao;
import com.bitwise.magnolia.model.finance.BillingDetails;

@Repository("billingDao")
public class BillingDetailsDaoImpl extends AbstractDao<Long, BillingDetails> implements BillingDetailsDao {

	final Logger logger = LoggerFactory.getLogger(BillingDetailsDaoImpl.class);

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public BillingDetails findById(Long id) {
		TypedQuery<BillingDetails> query = em.createNamedQuery("BillingDetails.findById", BillingDetails.class).setParameter("id", id);
		List<BillingDetails> billingDetails = query.getResultList();
		return billingDetails.size() == 1 ? billingDetails.get(0) : null;
	}

	@Override
	public BillingDetails findByStudentId(Long studentId) {
		TypedQuery<BillingDetails> query = em.createNamedQuery("BillingDetails.findByStudentId", BillingDetails.class).setParameter("studentId", studentId);
		List<BillingDetails> billingDetails = query.getResultList();
		return billingDetails.size() == 1 ? billingDetails.get(0) : null;
	}

	@Override
	public List<BillingDetails> findAll() {
		return this.em.createNamedQuery("BillingDetails.findAll", BillingDetails.class).getResultList();
	}

	@Override
	@Transactional
	public BillingDetails save(BillingDetails bills) {
		logger.info("Adding billing details with ID: " + bills.getId());
		persist(bills);
		return bills;
	}

	@Override
	@Transactional
	public BillingDetails update(BillingDetails bills) {
		logger.info("Updating billing details with ID: " + bills.getId());
		merge(bills);
		return bills;
	}

	@Override
	public List<BillingDetails> findAllCompleted(String status) {
		return this.em.createNamedQuery("BillingDetails.findAllCompleted", BillingDetails.class).setParameter("status", ApplicationConstant.COMPLETED_STATUS).getResultList();
	}

}
