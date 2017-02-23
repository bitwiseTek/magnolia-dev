package com.bitwise.magnolia.dao.common;
/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 */
import java.util.List;

import com.bitwise.magnolia.common.BaseDao;
import com.bitwise.magnolia.model.common.LGA;

public interface LGADao extends BaseDao<Object> {

	public LGA findById(Long id);
	
	public List<LGA> findAll();
}
