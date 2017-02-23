package com.bitwise.magnolia.model.support;
/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.magnolia.model.school.Faculty;
import com.bitwise.magnolia.model.school.SubSchool;

@Component
public class FacultyBuilder extends EntityBuilder<Faculty> {

	@Override
	void initProduct() {
		this.product = new Faculty();
	}
	
	public FacultyBuilder subSchool(SubSchool subSchool) {
		this.product.setSubSchool(subSchool);
		return this;
	}
	
	public FacultyBuilder faculty(String name, String createdAt, String updatedAt, String status) {
		this.product.setName(name);
		this.product.setCreatedAt(createdAt);
		this.product.setUpdatedAt(updatedAt);
		this.product.setStatus(status);
		return this;
	}

	@Override
	Faculty assembleProduct() {
		return this.product;
	}

}
