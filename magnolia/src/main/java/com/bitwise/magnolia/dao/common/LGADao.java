package com.bitwise.magnolia.dao.common;
/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 */
import java.util.List;

import com.bitwise.magnolia.model.common.LGA;

public interface LGADao {

	public LGA findById(Long id);
	
	public LGA findByName(String name);
	
	public List<LGA> findLGAsByStateId(Long stateId);
	
	public List<LGA> findAll();
}
