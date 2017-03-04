package com.bitwise.magnolia.model.support;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.magnolia.model.school.Department;
import com.bitwise.magnolia.model.staff.Staff;
import com.bitwise.magnolia.model.user.User;

@Component
public class StaffBuilder extends EntityBuilder<Staff> {

	@Override
	void initProduct() {
		this.product = new Staff();
	}
	
	public StaffBuilder user(User user) {
		this.product.setUser(user);
		return this;
	}
	
	public StaffBuilder department(Department dept) {
		this.product.setStaffDepartment(dept);
		return this;
	}
	
	public StaffBuilder staff(String staffId, String status, String title, String apiKey, Boolean isTemp, Boolean isAcad) {
		this.product.setStaffId(staffId);
		this.product.setTitle(title);
		this.product.setApiKey(apiKey);
		this.product.setIsAcademic(isAcad);
		this.product.setIsTemporary(isTemp);
		this.product.setStatus(status);
		return this;
	}

	@Override
	Staff assembleProduct() {
		return this.product;
	}

}
