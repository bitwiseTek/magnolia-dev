package com.bitwise.magnolia.model.support;
/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.magnolia.model.school.Department;
import com.bitwise.magnolia.model.school.Faculty;

@Component
public class DepartmentBuilder extends EntityBuilder<Department> {

	@Override
	void initProduct() {
		this.product = new Department();
	}
	
	public DepartmentBuilder faculty(Faculty faculty) {
		this.product.setFaculty(faculty);
		return this;
	}
	
	public DepartmentBuilder department(String name, String code, String createdAt, String updatedAt, String status) {
		this.product.setName(name);
		this.product.setCode(code);
		this.product.setCreatedAt(createdAt);
		this.product.setUpdatedAt(updatedAt);
		this.product.setStatus(status);
		return this;
	}

	@Override
	Department assembleProduct() {
		return this.product;
	}

}
