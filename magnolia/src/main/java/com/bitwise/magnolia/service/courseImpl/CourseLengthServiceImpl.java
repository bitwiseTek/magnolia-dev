package com.bitwise.magnolia.service.courseImpl;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
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

import com.bitwise.magnolia.dao.course.CourseLengthDao;
import com.bitwise.magnolia.exception.EntityDoesNotExistException;
import com.bitwise.magnolia.exception.EntityExistsException;
import com.bitwise.magnolia.model.course.CourseLength;
import com.bitwise.magnolia.service.course.CourseLengthService;
import com.bitwise.magnolia.util.CourseLengthList;

@Transactional
@Service("lengthService")
public class CourseLengthServiceImpl implements CourseLengthService {

	final Logger logger = LoggerFactory.getLogger(CourseLengthServiceImpl.class);
	
	@Autowired
	private CourseLengthDao lengthDao;
	
	@Override
	@Transactional(readOnly=true)
	public CourseLength findById(Long id) {
		return this.lengthDao.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public CourseLength findByName(String name) {
		return this.lengthDao.findByName(name);
	}

	@Override
	@Transactional(readOnly=true)
	public CourseLengthList findAllCourseLengths() {
		return new CourseLengthList(this.lengthDao.findAllCourseLengths());
	}

	@Override
	@Transactional(readOnly=false)
	public CourseLength save(CourseLength data) {
		logger.info("Adding course length with ID " + data.getId());
		CourseLength length = lengthDao.findByName(data.getName());
		if (length != null) {
			throw new EntityExistsException("Length already exists");
		}
		return this.lengthDao.save(data);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CourseLength> findAll() {
		return this.lengthDao.findAllCourseLengths();
	}

	@Override
	@Transactional(readOnly=false)
	public CourseLength update(CourseLength data) {
		CourseLength length = lengthDao.findById(data.getId());
		try {
			if (length != null) {
				length.setName(data.getName());
				length.settCH(data.gettCH());
				length.settCU(data.gettCU());
			} else {
				throw new EntityDoesNotExistException("Length does not exist");
			}
		} catch(Exception e) {
			throw new EntityDoesNotExistException("Length does not exist");
		}
		return length;
	}

}
