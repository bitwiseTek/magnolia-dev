package com.bitwise.magnolia.service.commonImpl;
/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.magnolia.dao.common.StateDao;
import com.bitwise.magnolia.model.common.State;
import com.bitwise.magnolia.service.common.StateService;

@Transactional
@Service("stateService")
public class StateServiceImpl implements StateService {

	@Autowired
	private StateDao stateDao;
	
	@Override
	@Transactional(readOnly=true)
	public State findById(Long id) {
		return this.stateDao.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<State> findAll() {
		return this.stateDao.findAll();
	}

}
