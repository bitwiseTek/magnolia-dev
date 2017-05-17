package com.bitwise.magnolia.service.schoolImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.bitwise.magnolia.exception.EntityDoesNotExistException;
import com.bitwise.magnolia.exception.EntityExistsException;
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
	public Campus save(Campus data) {
		logger.info("Adding campus with ID " + data.getCampusId());
		Campus campus = campusDao.findByName(data.getName());
		if (campus != null) {
			throw new EntityExistsException("Campus already exists");
		}
		return this.campusDao.save(data);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Campus> findAll() {
		return this.campusDao.findAllCampuses();
	}

	@Override
	@Transactional(readOnly=false)
	public Campus update(Campus data) {
		Campus campus = campusDao.findById(data.getCampusId());
		try {
			if (campus != null) {
				campus.setCreatedAt(data.getCreatedAt());
				campus.setName(data.getName());
				campus.setStatus(data.getStatus());
				campus.setSubSchool(data.getSubSchool());
				campus.setUpdatedAt(new SimpleDateFormat("E, dd MMM Y h:mm a").format(new Date()));
			} else {
				throw new EntityDoesNotExistException("Campus does not exist");
			}
		} catch(Exception e) {
			throw new EntityDoesNotExistException("Campus does not exist");
		}
		return campus;
	}

}
