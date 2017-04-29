package com.bitwise.magnolia.service.staffImpl;
import java.util.List;

import javax.persistence.EntityExistsException;

/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.magnolia.dao.staff.StaffDao;
import com.bitwise.magnolia.exception.EntityDoesNotExistException;
import com.bitwise.magnolia.model.staff.Staff;
import com.bitwise.magnolia.service.staff.StaffService;
import com.bitwise.magnolia.util.StaffList;

@Transactional
@Service("staffService")
public class StaffServiceImpl implements StaffService {

	final Logger logger = LoggerFactory.getLogger(StaffServiceImpl.class);
	
	@Autowired
	private StaffDao staffDao;
	
	@Override
	@Transactional(readOnly=true)
	public Staff findById(Long id) {
		return this.staffDao.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Staff findByStaffId(String staffId) {
		return this.staffDao.findByStaffId(staffId);
	}

	@Override
	@Transactional(readOnly=true)
	public Staff findByStaffApiKey(String apiKey) {
		return this.staffDao.findByStaffApiKey(apiKey);
	}

	@Override
	@Transactional(readOnly=true)
	public StaffList findStaffByDepartmentId(Long deptId) {
		return new StaffList(this.staffDao.findStaffByDepartmentId(deptId));
	}

	@Override
	@Transactional(readOnly=true)
	public StaffList findAllStaff() {
		return new StaffList(this.staffDao.findAllStaff());
	}

	@Override
	@Transactional(readOnly=false)
	public Staff save(Staff data) {
		Staff staff = staffDao.findByUserId(data.getUser().getId());
		if (staff != null) {
			throw new EntityExistsException("Staff already exists");
		}
		return this.staffDao.save(data);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Staff> findAll() {
		return this.staffDao.findAllStaff();
	}

	@Override
	@Transactional(readOnly=false)
	public Staff updateStaff(Staff data) {
		Staff staff = staffDao.findById(data.getId());
		try {
			if (staff != null) {
				staff.setStaffId(data.getStaffId());
				staff.setApiKey(data.getApiKey());
				staff.setIsAcademic(data.getIsAcademic());
				staff.setIsTemporary(data.getIsTemporary());
				staff.setTitle(data.getTitle());
				staff.setStatus(data.getStatus());
				staff.setStaffDepartment(data.getStaffDepartment());
				staff.setUser(data.getUser());
			} else {
				throw new EntityDoesNotExistException("Staff does not exist");
			}
		} catch(Exception e) {
			throw new EntityDoesNotExistException("Staff does not exist");
		}
		return this.staffDao.update(staff);
	}

}
