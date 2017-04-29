package com.bitwise.magnolia.dao.finance;
/**
 *  
 * @author Sika Kay
 * @date 25/04/17
 *
 */
import java.util.List;

import com.bitwise.magnolia.model.finance.BillingDetails;

public interface BillingDetailsDao {

	public BillingDetails findById(Long id);
	
	public BillingDetails findByStudentId(Long studentId);
	
	public List<BillingDetails> findAll();
	
	public List<BillingDetails> findAllCompleted(String status);
	
	public BillingDetails save(BillingDetails bills);
	
	public BillingDetails update(BillingDetails bills);

}
