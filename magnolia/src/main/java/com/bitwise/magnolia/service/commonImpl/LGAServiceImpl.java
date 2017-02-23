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

import com.bitwise.magnolia.dao.common.LGADao;
import com.bitwise.magnolia.model.common.LGA;
import com.bitwise.magnolia.service.common.LGAService;

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
	public List<LGA> findAll() {
		return this.lgaDao.findAll();
	}

}
