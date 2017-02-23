package com.bitwise.magnolia.service.common;
/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 */
import java.util.List;

import com.bitwise.magnolia.model.common.State;

public interface StateService {

	public State findById(Long id);
	
	public List<State> findAll();
}
