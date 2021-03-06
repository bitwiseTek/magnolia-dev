package com.bitwise.magnolia.service.common;
/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 */

import java.util.List;

import com.bitwise.magnolia.model.common.LGA;
import com.bitwise.magnolia.util.LGAList;

public interface LGAService {

	public LGA findById(Long id);
	
	public LGA findByName(String name);
	
	public List<LGA> findAll();
	
	public LGAList findAllLGAs();
	
	public LGAList findLGAsByStateId(Long stateId);
}
