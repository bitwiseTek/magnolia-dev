package com.bitwise.magnolia.service.common;
import java.util.List;

/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 */
import com.bitwise.magnolia.model.common.State;
import com.bitwise.magnolia.util.StateList;
/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 */
public interface StateService {

	public State findById(Long id);
	
	public State findByName(String name);
	
	public StateList findAllStates();
	
	public List<State> findAll();
}
