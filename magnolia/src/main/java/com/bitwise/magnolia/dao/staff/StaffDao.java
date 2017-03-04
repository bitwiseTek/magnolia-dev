package com.bitwise.magnolia.dao.staff;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import java.util.List;

import com.bitwise.magnolia.common.BaseDao;
import com.bitwise.magnolia.model.staff.Staff;

public interface StaffDao extends BaseDao<Object>{

	public Staff findById(Long id);
	
	//Get staff's record by staffId
	public Staff findByStaffId(String staffId);

	//Get staff's record by staffApiKey
	public Staff findByStaffApiKey(String apiKey);
	
	public List<Staff> findStaffByDepartmentId(Long deptId);
	
	public List<Staff> findAllStaff();
	
	public Staff save(Staff staff);
}
