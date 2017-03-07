package com.bitwise.magnolia.util;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import com.bitwise.magnolia.model.staff.Staff;

public class StaffList {

	public StaffList(List<Staff> staff) {
		this.staff = staff;
	}
	private List<Staff> staff = new ArrayList<Staff>();
	public List<Staff> getStaff() {
		return staff;
	}
	public void setStaff(List<Staff> staff) {
		this.staff = staff;
	}
}
