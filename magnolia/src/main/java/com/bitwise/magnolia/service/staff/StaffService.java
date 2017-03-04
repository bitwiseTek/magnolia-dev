package com.bitwise.magnolia.service.staff;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import com.bitwise.magnolia.model.staff.Staff;
import com.bitwise.magnolia.util.StaffList;

public interface StaffService {

	public Staff findById(Long id);
	
	//Get staff's record by staffId
	public Staff findByStaffId(String staffId);

	//Get staff's record by staffApiKey
	public Staff findByStaffApiKey(String apiKey);
	
	public StaffList findStaffByDepartmentId(Long deptId);
	
	public StaffList findAllStaff();
	
	public Staff save(Staff staff);
}
