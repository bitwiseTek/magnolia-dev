package com.bitwise.magnolia.dao.common;
/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 */
import java.util.List;

import com.bitwise.magnolia.common.BaseDao;
import com.bitwise.magnolia.model.common.State;

public interface StateDao extends BaseDao<Object> {

	public State findById(Long id);
	
	public List<State> findAll();
}
