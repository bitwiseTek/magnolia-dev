package com.bitwise.magnolia.service.common;
/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 */
import java.util.List;

import com.bitwise.magnolia.model.common.LGA;

public interface LGAService {

	public LGA findById(Long id);
	
	public List<LGA> findAll();
}
