package com.bitwise.magnolia.service.finance;
/**
 *  
 * @author Sika Kay
 * @date 25/04/17
 *
 */
import java.util.List;

import com.bitwise.magnolia.model.finance.BillingDetails;
import com.bitwise.magnolia.util.BillingDetailsList;

public interface BillingDetailsService {

	public BillingDetails findById(Long id);
	
	public BillingDetails findByStudentId(Long studentId);
	
	public List<BillingDetails> findAll();
	
	public List<BillingDetails> findAllCompleted(String status);
	
	public BillingDetailsList findAllBills();
	
	public BillingDetailsList findAllCompletedBills(String status);
	
	public BillingDetails save(BillingDetails data);
	
	public BillingDetails update(BillingDetails data);
}
