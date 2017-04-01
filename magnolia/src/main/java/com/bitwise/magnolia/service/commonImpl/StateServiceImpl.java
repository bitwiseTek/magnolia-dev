package com.bitwise.magnolia.service.commonImpl;
import java.util.List;

/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.magnolia.dao.common.StateDao;
import com.bitwise.magnolia.model.common.State;
import com.bitwise.magnolia.service.common.StateService;
import com.bitwise.magnolia.util.StateList;
/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 */
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
	public StateList findAllStates() {
		return new StateList(stateDao.findAllStates());
	}

	@Override
	public State findByName(String name) {
		return this.stateDao.findByName(name);
	}

	@Override
	public List<State> findAll() {
		return this.stateDao.findAllStates();
	}

}
