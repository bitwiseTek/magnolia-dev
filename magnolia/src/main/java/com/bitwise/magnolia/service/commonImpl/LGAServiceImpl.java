package com.bitwise.magnolia.service.commonImpl;
/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.magnolia.dao.common.LGADao;
import com.bitwise.magnolia.model.common.LGA;
import com.bitwise.magnolia.service.common.LGAService;
import com.bitwise.magnolia.util.LGAList;

@Transactional
@Service("lgaService")
public class LGAServiceImpl implements LGAService {

	@Autowired
	private LGADao lgaDao;
	
	@Override
	@Transactional(readOnly=true)
	public LGA findById(Long id) {
		return this.lgaDao.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public LGAList findAllLGAs() {
		return new LGAList(lgaDao.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public LGAList findLGAsByStateId(Long stateId) {
		return new LGAList(lgaDao.findLGAsByStateId(stateId));
	}

	@Override
	public LGA findByName(String name) {
		return this.lgaDao.findByName(name);
	}

}
