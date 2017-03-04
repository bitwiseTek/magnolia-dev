package com.bitwise.magnolia.service.schoolImpl;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.magnolia.dao.school.CampusDao;
import com.bitwise.magnolia.model.school.Campus;
import com.bitwise.magnolia.service.school.CampusService;
import com.bitwise.magnolia.util.CampusList;

@Transactional
@Service("campusService")
public class CampusServiceImpl implements CampusService {

	final Logger logger = LoggerFactory.getLogger(CampusServiceImpl.class);
	
	@Autowired
	private CampusDao campusDao;
	
	@Override
	@Transactional(readOnly=true)
	public Campus findById(Long id) {
		return this.campusDao.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Campus findByName(String name) {
		return this.campusDao.findByName(name);
	}

	@Override
	@Transactional(readOnly=true)
	public CampusList findAllCampuses() {
		return new CampusList(this.campusDao.findAllCampuses());
	}

	@Override
	@Transactional(readOnly=true)
	public CampusList findCampusesBySubSchoolId(Long id) {
		return new CampusList(this.campusDao.findCampusesBySubSchoolId(id));
	}

	@Override
	@Transactional(readOnly=false)
	public Campus save(Campus campus) {
		logger.info("Adding campus with ID " + campus.getCampusId());
		return this.campusDao.save(campus);
	}

}
