package com.bitwise.magnolia.model.support;
/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.magnolia.model.school.Campus;
import com.bitwise.magnolia.model.school.SubSchool;

@Component
public class CampusBuilder extends EntityBuilder<Campus> {

	@Override
	void initProduct() {
		this.product = new Campus();
	}
	
	public CampusBuilder subSchool(SubSchool subSchool) {
		this.product.setSubSchool(subSchool);
		return this;
	}
	
	public CampusBuilder campus(String name, String createdAt, String updatedAt, String status) {
		this.product.setName(name);
		this.product.setCreatedAt(createdAt);
		this.product.setUpdatedAt(updatedAt);
		this.product.setStatus(status);
		return this;
	}

	@Override
	Campus assembleProduct() {
		return this.product;
	}

}
