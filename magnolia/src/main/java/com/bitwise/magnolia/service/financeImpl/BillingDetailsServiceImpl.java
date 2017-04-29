package com.bitwise.magnolia.service.financeImpl;
/**
 *  
 * @author Sika Kay
 * @date 25/04/17
 *
 */
import java.util.List;

import javax.persistence.EntityExistsException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.dao.finance.BillingDetailsDao;
import com.bitwise.magnolia.exception.EntityDoesNotExistException;
import com.bitwise.magnolia.model.finance.BillingDetails;
import com.bitwise.magnolia.service.finance.BillingDetailsService;
import com.bitwise.magnolia.util.BillingDetailsList;

@Transactional
@Service("billingService")
public class BillingDetailsServiceImpl implements BillingDetailsService {

	final Logger logger = LoggerFactory.getLogger(BillingDetailsServiceImpl.class);
	
	@Autowired
	private BillingDetailsDao billingDao;
	
	@Override
	@Transactional(readOnly=true)
	public BillingDetails findById(Long id) {
		return this.billingDao.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public BillingDetails findByStudentId(Long studentId) {
		return this.billingDao.findByStudentId(studentId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<BillingDetails> findAll() {
		return this.billingDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public BillingDetailsList findAllBills() {
		return new BillingDetailsList(this.billingDao.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public BillingDetails save(BillingDetails data) {
		BillingDetails billing = billingDao.findByStudentId(data.getStudentId().getId());
		if (billing != null) {
			throw new EntityExistsException("Billing process has been initiated already");
		}
		return this.billingDao.save(data);
	}

	@Override
	@Transactional(readOnly=false)
	public BillingDetails update(BillingDetails data) {
		BillingDetails billing = billingDao.findById(data.getId());
		try {
			if (billing != null) {
				billing.setId(data.getId());
				billing.setNotes(data.getNotes());
				billing.setEmailAddress(data.getEmailAddress());
				billing.setLga(data.getLga());
				billing.setState(data.getState());
				billing.setSemester(data.getSemester());
				billing.setStatement(data.getStatement());
				billing.setStatus(data.getStatus());
				billing.setStudentId(data.getStudentId());
				billing.setPaymentMethod(data.getPaymentMethod());
				billing.setPaymentReference(data.getPaymentReference());
				billing.setPersonName(data.getPersonName());
				billing.setReferenceNumber(data.getReferenceNumber());
				billing.setResponseCode(data.getResponseCode());
				billing.setUserId(data.getUserId());
				billing.setStreetAddress(data.getStreetAddress());
				billing.setFeesAmount(data.getFeesAmount());
			} else {
				throw new EntityDoesNotExistException("Billing has not been initiated");
			}
		}
		catch(Exception e) {
			throw new EntityDoesNotExistException("Billing has not been initiated");
		}
		return this.billingDao.update(billing);
	}

	@Override
	public List<BillingDetails> findAllCompleted(String status) {
		return this.billingDao.findAllCompleted(ApplicationConstant.COMPLETED_STATUS);
	}

	@Override
	public BillingDetailsList findAllCompletedBills(String status) {
		return new BillingDetailsList(this.billingDao.findAllCompleted(ApplicationConstant.COMPLETED_STATUS));
	}

	
}
